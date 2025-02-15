import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class PropiedadesTabela implements ActionListener {

    String[] perguntas = {
            "Sabendo que o Raio Atômico, tamanho do átomo, aumenta de cima para baixo em um grupo e diminui da esquerda para a direita em um período. Selecione o elemento com MAIOR Raio Atômico."
            , "Agora selecione o elemnto com MENOR Raio Atômico",
            "Sabendo que Eletronegatividade, capacidade de atrair elétrons, aumenta da esquerda para a direita e Diminui de cima para baixo. Selecione o elemento com MAIOR Eletronegatividade.",
            "Agora selecione o elemento com MENOR Eletronegatividade",
            "Energia de Ionização, energia necessária para remover um elétron, aumenta da esquerda para a direita e diminui de cima para baixo. Selecione o elemento com MAIOR Energia de Ionização.",
            "Agora selecione o elemento com MENOR Energia de Ionização",
            "Sabendo que Afinidade Eletrônica, tendência de ganhar elétrons, aumenta da esquerda para a direita e diminui de cima para baixo. Selecione o elemento com MAIOR Afinidade Eletrônica",
            "Agora selecione o elemnto com MENOR Afinidade Eletrônica",
            "Sabendo que Reatividade é a capacidade de reagir com outros elemntos e que nos Metais aumenta para baixo e para a esquerda. Selecione o Metal MAIS Reativo",
            "Agora selecione o Metal MENOS Reativo",
            "Sabendo que Reatividade é a capacidade de reagir com outros elemntos e que nos Não Metais aumenta para cima e para a direita. Selecione o Não Metal MAIS Reativo",
            "Agora Selecione o Não Metal MENOS Reativo"
    };

    String[][] opcoes = {
            {"Césio", "Rubídio", "Frâncio", "Potássio"},
            {"Neônio", "Hélio", "Flúor", "Oxigênio"},
            {"Oxigênio", "Cloro", "Flúor", "Nitrogênio"},
            {"Rubídio", "Césio", "Potássio", "Frâncio"},
            {"Hélio", "Neônio", "Argônio", "Rênio"},
            {"Césio", "Frâncio", "Rubídio", "Potássio"},
            {"Iodo", "Bromo", "Flúor", "Cloro"},
            {"Neônio", "Radônio", "Árgon", "Hélio"},
            {"Potássio ", "Césio", "Rubídio", "Frâncio"},
            {"Ouro", "Platina", "Irídio ", "Ródio"},
            {"Flúor", "Cloro", "Bromo", "Iodo"},
            {"Neônio", "Hélio", "Criptônio", "Argônio"}
    };

    char[] respostas = {
            'C','B','C','D','A','B','D','C','D','B','B','A'
    };

    int cartaLargura = 90;
    int cartaAltura = 128;




    ImageIcon[][] imagens = {
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/raioatomico/cesio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/raioatomico/rubidio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/raioatomico/francio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/raioatomico/potassio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/raioatomico/neon.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/raioatomico/helio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/raioatomico/fluor.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/raioatomico/oxigenio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/eletronegatividade/oxigenio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/eletronegatividade/cloro.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/eletronegatividade/fluor.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/eletronegatividade/nitrogenio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/eletronegatividade/rubidio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/eletronegatividade/cesio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/eletronegatividade/potassio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/eletronegatividade/francio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/ionizacao/helio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/ionizacao/neon.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/ionizacao/argonio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/ionizacao/renio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/ionizacao/cesio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/ionizacao/francio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/ionizacao/rubidio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/ionizacao/potassio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/afinidade/iodo.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/afinidade/bromo.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/afinidade/fluor.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/afinidade/cloro.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/afinidade/neon.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/afinidade/radonio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/afinidade/argonio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/afinidade/helio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeMetal/potassio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeMetal/cesio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeMetal/rubidio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeMetal/francio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeMetal/ouro.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeMetal/platina.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeMetal/iridio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeMetal/rodio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeNaoMetal/fluor.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeNaoMetal/cloro.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeNaoMetal/bromo.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeNaoMetal/iodo.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeNaoMetal/neon.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeNaoMetal/helio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeNaoMetal/cripton.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("propiedades/reatividadeNaoMetal/argonio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            }

    };

    char chute;
    char resposta;
    int index = 0;
    int chutes_corretos = 0;
    int total_perguntas = perguntas.length;
    int resultado;
    int segundos = 30;

    JFrame frame = new JFrame();
    JTextField textfiled = new JTextField();
    JTextArea textarea = new JTextArea();
    JButton botaoA = new JButton();
    JButton botaoB = new JButton();
    JButton botaoC = new JButton();
    JButton botaoD = new JButton();
    JLabel respostaLabelA = new JLabel();
    JLabel respostaLabelB = new JLabel();
    JLabel respostaLabelC = new JLabel();
    JLabel respostaLabelD = new JLabel();
    JLabel tempoLabel = new JLabel();
    JLabel tempoRestante = new JLabel();
    JTextField numeroAcertos = new JTextField();
    JTextField porcentagemAcertos = new JTextField();
    JPanel buttonPanel = new JPanel();
    JButton voltarButton = new JButton("Voltar");

    Timer tempo = new Timer(1000, new ActionListener() {
        @Override
        public void actionPerformed(ActionEvent e) {
            segundos--;
            tempoRestante.setText(String.valueOf(segundos));

            if(segundos<=0){
                mostarResposta();
            }
        }
    });

    public PropiedadesTabela() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setSize(1050, 800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setResizable(false);

        textfiled.setBounds(0, 0, 800, 100);
        textfiled.setBackground(Color.BLACK);
        textfiled.setForeground(Color.YELLOW);
        textfiled.setFont(new Font("Arial", Font.PLAIN, 30));
        textfiled.setBorder(BorderFactory.createBevelBorder(1));
        textfiled.setHorizontalAlignment(JTextField.CENTER);
        textfiled.setEditable(false);

        textarea.setBounds(0, 100, 1000, 50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setBackground(Color.BLACK);
        textarea.setForeground(Color.YELLOW);
        textarea.setFont(new Font("Arial", Font.PLAIN, 20));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);

        botaoA.setBounds(0, 150, cartaLargura, cartaAltura);
        botaoA.setOpaque(true);
        botaoA.setFocusable(false);
        botaoA.addActionListener(this);

        botaoB.setBounds(0, 300, cartaLargura, cartaAltura);
        botaoB.setOpaque(true);
        botaoB.setFocusable(false);
        botaoB.addActionListener(this);

        botaoC.setBounds(0, 450, cartaLargura, cartaAltura);
        botaoC.setOpaque(true);
        botaoC.setFocusable(false);
        botaoC.addActionListener(this);

        botaoD.setBounds(0, 600, cartaLargura, cartaAltura);
        botaoD.setOpaque(true);
        botaoD.setFocusable(false);
        botaoD.addActionListener(this);

        respostaLabelA.setBounds(100, 150, 500, 150);
        respostaLabelA.setBackground(Color.BLACK);
        respostaLabelA.setForeground(Color.YELLOW);
        respostaLabelA.setFont(new Font("Arial", Font.PLAIN, 30));

        respostaLabelB.setBounds(100, 300, 500, 100);
        respostaLabelB.setBackground(Color.BLACK);
        respostaLabelB.setForeground(Color.YELLOW);
        respostaLabelB.setFont(new Font("Arial", Font.PLAIN, 30));

        respostaLabelC.setBounds(100, 450, 500, 100);
        respostaLabelC.setBackground(Color.BLACK);
        respostaLabelC.setForeground(Color.YELLOW);
        respostaLabelC.setFont(new Font("Arial", Font.PLAIN, 30));

        respostaLabelD.setBounds(100, 600, 500, 100);
        respostaLabelD.setBackground(Color.BLACK);
        respostaLabelD.setForeground(Color.YELLOW);
        respostaLabelD.setFont(new Font("Arial", Font.PLAIN, 30));

        tempoRestante.setBounds(930, 680, 80, 80);
        tempoRestante.setBackground(Color.BLACK);
        tempoRestante.setForeground(Color.YELLOW);
        tempoRestante.setFont(new Font("Arial", Font.PLAIN, 60));
        tempoRestante.setBorder(BorderFactory.createBevelBorder(1));
        tempoRestante.setOpaque(true);
        tempoRestante.setHorizontalAlignment(JTextField.CENTER);
        tempoRestante.setText(String.valueOf(segundos));

        tempoLabel.setBounds(850, 650, 200, 30);
        tempoLabel.setBackground(Color.BLACK);
        tempoLabel.setForeground(Color.YELLOW);
        tempoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        tempoLabel.setBorder(BorderFactory.createBevelBorder(1));
        tempoLabel.setOpaque(true);
        tempoLabel.setHorizontalAlignment(JTextField.CENTER);
        tempoLabel.setText("Tempo Restante");

        numeroAcertos.setBounds(100, 225, 600, 100);
        numeroAcertos.setBackground(Color.BLACK);
        numeroAcertos.setForeground(Color.YELLOW);
        numeroAcertos.setFont(new Font("Arial", Font.PLAIN, 40));
        numeroAcertos.setBorder(BorderFactory.createBevelBorder(1));
        numeroAcertos.setHorizontalAlignment(JTextField.CENTER);
        numeroAcertos.setEditable(false);

        porcentagemAcertos.setBounds(100, 300, 600, 100);
        porcentagemAcertos.setBackground(Color.BLACK);
        porcentagemAcertos.setForeground(Color.YELLOW);
        porcentagemAcertos.setFont(new Font("Arial", Font.PLAIN, 40));
        porcentagemAcertos.setBorder(BorderFactory.createBevelBorder(1));
        porcentagemAcertos.setHorizontalAlignment(JTextField.CENTER);
        porcentagemAcertos.setEditable(false);

        voltarButton.setFont(new Font("Arial", Font.PLAIN, 20));
        voltarButton.setFocusable(false);
        voltarButton.setBounds(500, 700, 300, 300);
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //botao.playButtonSound2();
                frame.dispose(); // Fecha a janela atual
                new Jogo(); // Retorna para a classe Jogo
            }
        });

        buttonPanel.setBounds(500, 700, 100, 100);
        buttonPanel.setBackground(Color.BLACK);
        buttonPanel.add(voltarButton);

        frame.add(buttonPanel);
        frame.add(tempoLabel);
        frame.add(tempoRestante);
        frame.add(respostaLabelA);
        frame.add(respostaLabelB);
        frame.add(respostaLabelC);
        frame.add(respostaLabelD);
        frame.add(botaoA);
        frame.add(botaoB);
        frame.add(botaoC);
        frame.add(botaoD);
        frame.add(textarea);
        frame.add(textfiled);
        frame.setVisible(true);

        proximaQuestao();

    }

    public void proximaQuestao() {
        if (index >= total_perguntas) {
            resultado();
        } else {

            tempo.stop();

            segundos = 30;
            tempoRestante.setText(String.valueOf(segundos));

            tempo.start();

            textfiled.setText("Pergunta " + (index + 1) + " de " + " " + perguntas.length);
            textarea.setText(perguntas[index]);
            respostaLabelA.setText(opcoes[index][0]);
            respostaLabelB.setText(opcoes[index][1]);
            respostaLabelC.setText(opcoes[index][2]);
            respostaLabelD.setText(opcoes[index][3]);

            // Atualiza as imagens das cartas
            botaoA.setIcon(imagens[index][0]);
            botaoB.setIcon(imagens[index][1]);
            botaoC.setIcon(imagens[index][2]);
            botaoD.setIcon(imagens[index][3]);

            botaoA.setEnabled(true);
            botaoB.setEnabled(true);
            botaoC.setEnabled(true);
            botaoD.setEnabled(true);
        }
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        //botao.playButtonSound2();

        botaoA.setEnabled(false);
        botaoB.setEnabled(false);
        botaoC.setEnabled(false);
        botaoD.setEnabled(false);

        if (e.getSource() == botaoA) {
            chute = 'A';
        }
        if (e.getSource() == botaoB) {
            chute = 'B';
        }
        if (e.getSource() == botaoC) {
            chute = 'C';
        }
        if (e.getSource() == botaoD) {
            chute = 'D';
        }

        if (chute == respostas[index]) {
            chutes_corretos++;
        }

        mostarResposta();
    }

    public void mostarResposta() {

        tempo.stop();

        if (respostas[index] != 'A')
            respostaLabelA.setForeground(new Color(255, 0, 0));
        if (respostas[index] != 'B')
            respostaLabelB.setForeground(new Color(255, 0, 0));
        if (respostas[index] != 'C')
            respostaLabelC.setForeground(new Color(255, 0, 0));
        if (respostas[index] != 'D')
            respostaLabelD.setForeground(new Color(255, 0, 0));

        Timer pausa = new Timer(2000, new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                respostaLabelA.setForeground(Color.YELLOW);
                respostaLabelB.setForeground(Color.YELLOW);
                respostaLabelC.setForeground(Color.YELLOW);
                respostaLabelD.setForeground(Color.YELLOW);
                index++;
                proximaQuestao();
            }
        });

        pausa.setRepeats(false);
        pausa.start();
    }

    public void resultado() {
        botaoA.setEnabled(false);
        botaoB.setEnabled(false);
        botaoC.setEnabled(false);
        botaoD.setEnabled(false);

        botaoA.setVisible(false);
        botaoB.setVisible(false);
        botaoC.setVisible(false);
        botaoD.setVisible(false);

        resultado = (int) ((chutes_corretos / (double) total_perguntas) * 100);

        textfiled.setText("Resultados: ");
        textfiled.setFont(new Font("Arial", Font.PLAIN, 60));
        textarea.setVisible(false);
        respostaLabelA.setVisible(false);
        respostaLabelB.setVisible(false);
        respostaLabelC.setVisible(false);
        respostaLabelD.setVisible(false);

        tempoRestante.setVisible(false);
        tempoLabel.setVisible(false);

        numeroAcertos.setText("Total de acertos: " + chutes_corretos + "/" + total_perguntas);
        porcentagemAcertos.setText("Porcetagem de acertos: " + resultado + "%");

        frame.add(porcentagemAcertos);
        frame.add(numeroAcertos);
    }

}