import java.awt.event.*;
import javax.swing.*;
import java.awt.*;

public class CuriosidadeElementos implements ActionListener {

    String[] perguntas = {
            "Qual elemento foi utilizado na primeira bomba Nuclear?", "Qual o elemento mais abundante no universo?",
            "Qual o único metal encontrado no estado líquido na natureza?",
            "Todos os compostos orgânicos possuem esse elemento em sua cadeia.",
            "É usado para fazer os ímãs mais poderosos do mundo, essenciais em fones de ouvido e discos rígidos",
            "Reage violentamente com a água, liberando gás hidrogênio que pode explodir",
            "No nosso sangue permite que o oxigênio seja transportado pelo corpo"
    };

    String[][] opcoes = {
            {"Urânio", "Plutônio", "Protactínio", "Frâncio"},
            {"Carbono", "Hélio", "Hidrogênio", "Oxigênio"},
            {"Mercúrio", "Molibdênio", "Nióbio", "Níquel"},
            {"Cloro", "Enxofre", "Fluor", "Carbono"},
            {"Bromo", "Neodímio", "Chumbo", "Califórnio"},
            {"Arsenio", "Potássio", "Polônio", "Rádio"},
            {"Cálcio", "Oxigênio", "Cripton", "Ferro"}
    };

    char[] respostas = {
            'A', 'C', 'A', 'D','B', 'B', 'D'
    };

    int cartaLargura = 90;
    int cartaAltura = 128;

    private MenuSom menuSom = MenuSom.getInstance();


    ImageIcon[][] imagens = {
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/radioativo/uranio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/radioativo/plutonio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/radioativo/protactinio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/radioativo/francio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/abundante/carbono.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/abundante/helio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/abundante/hidrogenio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/abundante/oxigenio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/liquido/mercurio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/liquido/molibdenio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/liquido/niobio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/liquido/niquel.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/organico/cloro.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/organico/enxofre.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/organico/fluor.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/organico/carbono.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/ima/bromo.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/ima/neodimio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/ima/chumbo.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/ima/californio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/explosao/arsenio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/explosao/potassio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/explosao/polonio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/explosao/radio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            },
            {
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/sangue/calcio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/sangue/oxigenio.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/sangue/cripton.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH)),
                    new ImageIcon(new ImageIcon(getClass().getResource("curiosidade/sangue/ferro.jpg"))
                            .getImage().getScaledInstance(cartaLargura, cartaAltura, Image.SCALE_SMOOTH))
            }

    };

    char chute;
    char resposta;
    int index = 0;
    int chutes_corretos = 0;
    int total_perguntas = perguntas.length;
    int resultado;
    int segundos = 20;

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
    JTextField tempoLabel = new JTextField();
    JTextField tempoRestante = new JTextField();
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

    public CuriosidadeElementos() {

        if(menuSom != null) {
            menuSom.startBackgroundMusic();
        }

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(350, 0, 800, 800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setResizable(false);

        textfiled.setBounds(0, 0, 800, 100);
        textfiled.setForeground(Color.YELLOW);
        textfiled.setFont(new Font("Arial", Font.PLAIN, 30));
        textfiled.setBorder(BorderFactory.createBevelBorder(1));
        textfiled.setHorizontalAlignment(JTextField.CENTER);
        textfiled.setEditable(false);
        textfiled.setOpaque(false);
        textfiled.setBackground(new Color(0, 0, 0, 0)); // Define o fundo como transparente

        textarea.setBounds(0, 100, 800, 50);
        textarea.setLineWrap(true);
        textarea.setWrapStyleWord(true);
        textarea.setForeground(Color.YELLOW);
        textarea.setFont(new Font("Arial", Font.PLAIN, 20));
        textarea.setBorder(BorderFactory.createBevelBorder(1));
        textarea.setEditable(false);
        textarea.setOpaque(false); // Torna o fundo transparente
        textarea.setBackground(new Color(0, 0, 0, 0)); // Define o fundo como transparente


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

        tempoLabel.setBounds(600, 650, 200, 30);
        tempoLabel.setForeground(Color.YELLOW);
        tempoLabel.setFont(new Font("Arial", Font.PLAIN, 20));
        tempoLabel.setBorder(null); // Remove a borda
        tempoLabel.setOpaque(false); // Torna o fundo transparente
        tempoLabel.setBackground(new Color(0, 0, 0, 0)); // Define o fundo como transparente
        tempoLabel.setHorizontalAlignment(JTextField.CENTER);
        tempoLabel.setText("Tempo Restante");

        tempoRestante.setBounds(680, 680, 80, 80);
        tempoRestante.setForeground(Color.YELLOW);
        tempoRestante.setFont(new Font("Arial", Font.PLAIN, 60));
        tempoRestante.setBorder(null); // Remove a borda
        tempoRestante.setOpaque(false); // Torna o fundo transparente
        tempoRestante.setBackground(new Color(0, 0, 0, 0)); // Define o fundo como transparente
        tempoRestante.setHorizontalAlignment(JTextField.CENTER);
        tempoRestante.setText(String.valueOf(segundos));

        numeroAcertos.setBounds(100, 225, 600, 100);
        numeroAcertos.setForeground(Color.YELLOW);
        numeroAcertos.setFont(new Font("Arial", Font.PLAIN, 40));
        numeroAcertos.setBorder(BorderFactory.createBevelBorder(1));
        numeroAcertos.setHorizontalAlignment(JTextField.CENTER);
        numeroAcertos.setEditable(false);
        numeroAcertos.setOpaque(false);
        numeroAcertos.setBackground(new Color(0, 0, 0, 0));
        numeroAcertos.setVisible(false);

        porcentagemAcertos.setBounds(100, 300, 600, 100);
        porcentagemAcertos.setForeground(Color.YELLOW);
        porcentagemAcertos.setFont(new Font("Arial", Font.PLAIN, 40));
        porcentagemAcertos.setBorder(BorderFactory.createBevelBorder(1));
        porcentagemAcertos.setHorizontalAlignment(JTextField.CENTER);
        porcentagemAcertos.setEditable(false);
        porcentagemAcertos.setOpaque(false);
        porcentagemAcertos.setBackground(new Color(0, 0, 0, 0));
        porcentagemAcertos.setVisible(false);

        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("imgfundo/imageback2.jpg"));
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 800, 800);

        voltarButton.setFont(new Font("Arial", Font.PLAIN, 20));
        voltarButton.setFocusable(false);
        voltarButton.setOpaque(true);
        voltarButton.setBorderPainted(false);
        voltarButton.setBackground(Color.MAGENTA);
        voltarButton.setForeground(Color.WHITE);
        voltarButton.setBounds(150, 700, 0, 0);
        voltarButton.setPreferredSize(new Dimension(100, 50));
        //voltarButton.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        voltarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                menuSom.playButtonSound2();
                menuSom.stopVitoria();
                menuSom.stopVitoriaNotBased();
                menuSom.stopAiMamae();
                menuSom.stopSeloko();
                frame.dispose(); // Fecha a janela atual
                new Jogo(); // Retorna para a classe Jogo
            }
        });

        // Configuração do buttonPanel
        buttonPanel.setBounds(150, 700, 500, 500);
        buttonPanel.setOpaque(false); // Torna o fundo transparente
        buttonPanel.setBackground(new Color(0, 0, 0, 0)); // Define o fundo como transparente
        buttonPanel.setBorder(null); // Remove a borda (opcional)
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
        frame.add(numeroAcertos);
        frame.add(porcentagemAcertos);
        frame.add(backgroundLabel);
        frame.setVisible(true);

        proximaQuestao();
    }

    public void proximaQuestao() {
        if (index >= total_perguntas) {
            resultado();
        } else {

            tempo.stop();

            segundos = 20;
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

        menuSom.playSomCarta();

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
            menuSom.playSomAcerto();
            chutes_corretos++;
        }else{
            menuSom.playSomErro();
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

        if(resultado == 100){
            menuSom.playVitoria();
            textfiled.setText("Parabéns acertou todas as questões!");
            textfiled.setFont(new Font("Arial", Font.PLAIN, 40));
        }else if(resultado < 100 && resultado >= 70){
            menuSom.playVitoriaNotBased();
            textfiled.setText("Aprovado, parabéns");
            textfiled.setFont(new Font("Arial", Font.PLAIN, 60));
        } else if (resultado >= 40 && resultado < 70) {
            menuSom.playVitoriaAimamae();
            textfiled.setText("Prova final, estude mais");
            textfiled.setFont(new Font("Arial", Font.PLAIN, 60));
        } else if (resultado < 40) {
            menuSom.playVitoriaSeloko();
            textfiled.setText("Reprovado");
            textfiled.setFont(new Font("Arial", Font.PLAIN, 60));
        }

        textarea.setVisible(false);
        respostaLabelA.setVisible(false);
        respostaLabelB.setVisible(false);
        respostaLabelC.setVisible(false);
        respostaLabelD.setVisible(false);

        tempoRestante.setVisible(false);
        tempoLabel.setVisible(false);

        numeroAcertos.setText("Total de acertos: " + chutes_corretos + "/" + total_perguntas);
        porcentagemAcertos.setText("Porcetagem de acertos: " + resultado + "%");

        numeroAcertos.setVisible(true);
        porcentagemAcertos.setVisible(true);
    }

}