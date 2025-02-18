import java.awt.*;
import java.awt.event.*;
import java.net.URL;
import java.util.ArrayList;
import javax.swing.*;

public class AlcalinoAlcalinoTerroso {
    class Carta {
        String nomeCarta;
        ImageIcon iconeCarta;

        Carta(String nomeCarta, ImageIcon iconeCarta) {
            this.nomeCarta = nomeCarta;
            this.iconeCarta = iconeCarta;
        }

        public String toString() {
            return nomeCarta;
        }
    }

    String[] cardList = {
            "bario", "berilio", "calcio", "cesio",
            "estroncio", "francio", "litio", "magnesio",
            "potassio", "radio", "rubidio", "sodio"
    };

    int linha = 4;
    int coluna = 3;
    int cartaLargura = 90;
    int cartaAltura = 128;
    int totalDePares = cardList.length; // Total de pares no jogo
    int contadorAcertos = 0; // Contador de pares encontrados

    ArrayList<Carta> deckCarta;
    ImageIcon iconeTrasCarta;

    int bordaLargura = coluna * cartaLargura;
    int bordaAltura = linha * cartaAltura;

    JFrame frame = new JFrame("Metais Alcalinos e Alcalinos Terrosos");
    JLabel textoLabel = new JLabel();
    JLabel tempoLabel = new JLabel("Tempo: 0s"); // Rótulo para o contador de tempo
    JPanel textoPanel = new JPanel();
    JPanel bordaPanel = new JPanel();
    JPanel buttonPanel = new JPanel(); // Painel para agrupar os botões
    JButton restartGameButton = new JButton("Reiniciar Jogo");
    JButton voltarButton = new JButton("Voltar"); // Botão de voltar

    int contadorDeErros = 0;
    ArrayList<JButton> borda;
    Timer esconderCartas;
    Timer esconderCartasGame;
    Timer timer; // Timer para o contador de tempo
    int segundos = 0; // Contador de segundos
    boolean jogoPronto = false;
    JButton selecionarCarta1;
    JButton selecionarCarta2;

    private MenuSom menuSom = MenuSom.getInstance();

    AlcalinoAlcalinoTerroso() {
        if (menuSom != null) {
            menuSom.startBackgroundMusic();
        }

        mostrarCarta();
        misturarCarta();

        frame.setLayout(new BorderLayout());
        frame.setBounds(500, 0, bordaLargura, bordaAltura);
        frame.setResizable(false);
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

        textoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        textoLabel.setHorizontalAlignment(SwingConstants.CENTER);
        atualizarTextoLabel();

        textoPanel.setLayout(new GridLayout(2, 1)); // Altera o layout para acomodar o rótulo de tempo
        textoPanel.setPreferredSize(new Dimension(bordaLargura, 60));
        textoPanel.add(textoLabel);
        textoPanel.add(tempoLabel); // Adiciona o rótulo de tempo ao painel
        frame.add(textoPanel, BorderLayout.NORTH);

        borda = new ArrayList<>();
        bordaPanel.setLayout(new GridLayout(linha, coluna));
        for (int i = 0; i < deckCarta.size(); i++) {
            JButton botao = new JButton();
            botao.setPreferredSize(new Dimension(cartaLargura, cartaAltura));
            botao.setOpaque(true);
            botao.setIcon(deckCarta.get(i).iconeCarta);
            botao.setFocusable(false);
            botao.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    menuSom.playButtonSound2();
                    if (!jogoPronto) {
                        return;
                    }
                    JButton botao = (JButton) e.getSource();
                    if (botao.getIcon() == iconeTrasCarta) {
                        if (selecionarCarta1 == null) {
                            selecionarCarta1 = botao;
                            int index = borda.indexOf(selecionarCarta1);
                            selecionarCarta1.setIcon(deckCarta.get(index).iconeCarta);
                        } else if (selecionarCarta2 == null) {
                            selecionarCarta2 = botao;
                            int index = borda.indexOf(selecionarCarta2);
                            selecionarCarta2.setIcon(deckCarta.get(index).iconeCarta);

                            if (selecionarCarta1.getIcon() != selecionarCarta2.getIcon()) {
                                menuSom.playSomErro();
                                contadorDeErros++;
                                atualizarTextoLabel();
                                esconderCartasGame.start();
                            } else {
                                menuSom.playSomAcerto();
                                selecionarCarta1 = null;
                                selecionarCarta2 = null;
                                contadorAcertos++; // Incrementa os acertos
                                atualizarTextoLabel();

                                // Se todos os pares foram encontrados, exibir mensagem
                                if (contadorAcertos == totalDePares) {
                                    if (contadorAcertos > contadorDeErros) {
                                        menuSom.playVitoria();
                                    } else {
                                        menuSom.playVitoriaNotBased();
                                    }
                                    // Para o contador de tempo quando o jogo termina
                                    timer.stop();
                                    JOptionPane.showMessageDialog(frame,
                                            "Parabéns! Você concluiu o jogo.",
                                            "Fim de Jogo", JOptionPane.INFORMATION_MESSAGE);
                                    jogoPronto = true;
                                    restartGameButton.setEnabled(true);
                                }
                            }
                        }
                    }
                }
            });
            borda.add(botao);
            bordaPanel.add(botao);
        }
        frame.add(bordaPanel);

        // Configuração do painel de botões
        buttonPanel.setLayout(new GridLayout(2, 1)); // Layout com 2 linhas e 1 coluna
        buttonPanel.setPreferredSize(new Dimension(bordaLargura, 80)); // Ajuste a altura conforme necessário

        // Configuração do botão de reiniciar
        restartGameButton.setFont(new Font("Arial", Font.PLAIN, 20));
        restartGameButton.setFocusable(false);
        restartGameButton.setEnabled(false);
        restartGameButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSom.playButtonSound2();
                menuSom.stopVitoria();
                menuSom.stopVitoriaNotBased();
                if (!jogoPronto) {
                    return;
                }
                // Para o timer antes de reiniciar o jogo
                timer.stop();
                segundos = 0;
                atualizarTempoLabel();

                jogoPronto = false;
                restartGameButton.setEnabled(false);
                selecionarCarta1 = null;
                selecionarCarta2 = null;

                // Mistura as cartas novamente
                misturarCarta();

                // Reseta o estado dos botões para mostrar o verso das cartas
                for (int i = 0; i < borda.size(); i++) {
                    borda.get(i).setIcon(iconeTrasCarta);
                }

                // Reseta os contadores
                contadorDeErros = 0;
                contadorAcertos = 0;
                atualizarTextoLabel();

                // Reinicia o jogo e o timer
                esconderCartas.start();
            }
        });

        // Configuração do botão de voltar
        voltarButton.setFont(new Font("Arial", Font.PLAIN, 20));
        voltarButton.setFocusable(false);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSom.playButtonSound2();
                menuSom.stopVitoria();
                menuSom.stopVitoriaNotBased();
                frame.dispose(); // Fecha a janela atual
                new Jogo(); // Retorna para a classe Jogo
            }
        });

        // Adiciona os botões ao painel de botões
        buttonPanel.add(restartGameButton);
        buttonPanel.add(voltarButton);

        // Adiciona o painel de botões ao frame
        frame.add(buttonPanel, BorderLayout.SOUTH);

        frame.pack();
        frame.setVisible(true);

        // Delay para o inicio do jogo e para o restart
        esconderCartas = new Timer(5000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                esconderCartasFunction();
            }
        });
        esconderCartas.setRepeats(false);//executa apenas uma vez e para até que seja chamada novamente
        esconderCartas.start();

        // Delay para virar as cartas durante o jogo
        esconderCartasGame = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                esconderCartasFunction();
            }
        });
        esconderCartasGame.setRepeats(false);//executa apenas uma vez e para até que seja chamada novamente

        // Inicializa o timer para contar o tempo
        timer = new Timer(1000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                segundos++;
                atualizarTempoLabel();
            }
        });
        timer.setRepeats(true);
    }

    void atualizarTextoLabel() {
        textoLabel.setText("Erros: " + contadorDeErros + " | Acertos: " + contadorAcertos);
    }

    void atualizarTempoLabel() {
        tempoLabel.setText("Tempo: " + segundos + "s");
    }

    void mostrarCarta() {
        deckCarta = new ArrayList<>();

        for (String nomeCarta : cardList) {
            // Carrega a imagem da carta
            URL resourceUrl = getClass().getResource("/alcalino/" + nomeCarta + ".jpg");
            if (resourceUrl == null) {
                System.err.println("Erro: Imagem não encontrada - " + nomeCarta + ".jpg");
                continue;
            }
            Image imagemCarta = new ImageIcon(resourceUrl).getImage();
            ImageIcon iconeCarta = new ImageIcon(imagemCarta.getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH));

            Carta carta = new Carta(nomeCarta, iconeCarta);
            deckCarta.add(carta);
        }
        deckCarta.addAll(deckCarta);

        // Carrega a imagem do verso da carta
        URL backResourceUrl = getClass().getResource("/alcalino/tras.jpg");
        if (backResourceUrl == null) {
            System.err.println("Erro: Imagem do verso não encontrada - tras.jpg");
        } else {
            Image imagemTrasCarta = new ImageIcon(backResourceUrl).getImage();
            iconeTrasCarta = new ImageIcon(imagemTrasCarta.getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH));
        }
    }

    void misturarCarta() {
        menuSom.playSomVirarCartas();
        for (int i = 0; i < deckCarta.size(); i++) {
            int j = (int) (Math.random() * deckCarta.size());
            Carta temp = deckCarta.get(i);
            deckCarta.set(i, deckCarta.get(j));
            deckCarta.set(j, temp);
        }
    }

    void esconderCartasFunction() {
        if (jogoPronto && selecionarCarta1 != null && selecionarCarta2 != null) {
            selecionarCarta1.setIcon(iconeTrasCarta);
            selecionarCarta1 = null;
            selecionarCarta2.setIcon(iconeTrasCarta);
            selecionarCarta2 = null;
        } else {
            for (int i = 0; i < borda.size(); i++) {
                borda.get(i).setIcon(iconeTrasCarta);
            }
            jogoPronto = true;
            restartGameButton.setEnabled(true);
            // Inicia o contador de tempo quando o jogo começa
            timer.start();
        }
    }
}