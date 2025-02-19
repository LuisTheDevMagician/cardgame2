import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class Ajuda {

    private JFrame frame;
    private JButton botaoFrente, botaoTras, botaoFrente2, botaoFrente3, botaoFrente4, botaoFrente5, voltarButton;
    private JTextArea textCima, textMeio, textFim;
    private JPanel buttonPanel;
    private MenuSom menuSom = MenuSom.getInstance();

    private static final int CARTA_LARGURA = 90;
    private static final int CARTA_ALTURA = 128;

    private ImageIcon[] imagens = {
            criarImagemIcon("metaltransicao/ouro.jpg"),
            criarImagemIcon("semimetal/tras.jpg"),
            criarImagemIcon("semimetal/silicio.jpg"),
            criarImagemIcon("gas/helio.jpg"),
            criarImagemIcon("alcalino/potassio.jpg"),
            criarImagemIcon("naometal/carbono.jpg")
    };

    public Ajuda() {
        inicializarComponentes();
        configurarFrame();
        configurarTextAreas();
        configurarBotoes();
        adicionarComponentesAoFrame();
        frame.setVisible(true);
    }

    private void inicializarComponentes() {
        frame = new JFrame();
        botaoFrente = new JButton();
        botaoTras = new JButton();
        botaoFrente2 = new JButton();
        botaoFrente3 = new JButton();
        botaoFrente4 = new JButton();
        botaoFrente5 = new JButton();
        voltarButton = new JButton("Voltar");
        textCima = new JTextArea();
        textMeio = new JTextArea();
        textFim = new JTextArea();
        buttonPanel = new JPanel();
    }

    private void configurarFrame() {
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setBounds(350, 0, 800, 800);
        frame.getContentPane().setBackground(Color.BLACK);
        frame.setLayout(null);
        frame.setResizable(false);

        if (menuSom != null) {
            menuSom.startBackgroundMusic();
        }
    }

    private void configurarTextAreas() {
        configurarTextArea(textCima, 0, 0, 800, 100,
                "Nos botões que representam a classificação dos elementos da tabela periódica, " +
                        "neles você encontrará jogos da memória em que consiste basicamente em juntar todos os pares de cartas. " +
                        "No início elas estarão visíveis e após alguns segundos serão viradas.");

        configurarTextArea(textMeio, 0, 300, 800, 100,
                "Nos botões Curiosidades da tabela e Propriedades da tabela você irá testar " +
                        "seus conhecimentos sobre certas curiosidades dos elementos da tabela e terá 4 opções " +
                        "representadas por botões em forma de cartas, apenas uma opção é verdadeira.");

        configurarTextArea(textFim, 250, 600, 800, 100,
                "Isso é tudo, boa sorte e bom jogo :)");
    }

    private void configurarTextArea(JTextArea textArea, int x, int y, int width, int height, String texto) {
        textArea.setBounds(x, y, width, height);
        textArea.setLineWrap(true);
        textArea.setWrapStyleWord(true);
        textArea.setForeground(Color.YELLOW);
        textArea.setFont(new Font("Arial", Font.PLAIN, 20));
        textArea.setBorder(BorderFactory.createBevelBorder(1));
        textArea.setEditable(false);
        textArea.setOpaque(false);
        textArea.setBackground(new Color(0, 0, 0, 0));
        textArea.setText(texto);
    }

    private void configurarBotoes() {
        configurarBotao(botaoFrente, 250, 100, CARTA_LARGURA, CARTA_ALTURA, imagens[0]);
        configurarBotao(botaoTras, 450, 100, CARTA_LARGURA, CARTA_ALTURA, imagens[1]);
        configurarBotao(botaoFrente2, 50, 400, CARTA_LARGURA, CARTA_ALTURA, imagens[2]);
        configurarBotao(botaoFrente3, 250, 400, CARTA_LARGURA, CARTA_ALTURA, imagens[3]);
        configurarBotao(botaoFrente4, 450, 400, CARTA_LARGURA, CARTA_ALTURA, imagens[4]);
        configurarBotao(botaoFrente5, 650, 400, CARTA_LARGURA, CARTA_ALTURA, imagens[5]);

        voltarButton.setFont(new Font("Arial", Font.PLAIN, 20));
        voltarButton.setFocusable(false);
        voltarButton.setOpaque(true);
        voltarButton.setBorderPainted(false);
        voltarButton.setBackground(new Color(0, 0, 128));
        voltarButton.setForeground(Color.WHITE);
        voltarButton.setPreferredSize(new Dimension(100, 50));
        voltarButton.addActionListener(this::voltarButtonAction);

        buttonPanel.setBounds(150, 700, 500, 500);
        buttonPanel.setOpaque(false);
        buttonPanel.setBackground(new Color(0, 0, 0, 0));
        buttonPanel.setBorder(null);
        buttonPanel.add(voltarButton);
    }

    private void configurarBotao(JButton botao, int x, int y, int width, int height, ImageIcon icon) {
        botao.setBounds(x, y, width, height);
        botao.setOpaque(true);
        botao.setFocusable(false);
        botao.setIcon(icon);
    }

    private void voltarButtonAction(ActionEvent e) {
        menuSom.playButtonSound2();
        menuSom.stopVitoria();
        menuSom.stopVitoriaNotBased();
        menuSom.stopAiMamae();
        menuSom.stopSeloko();
        frame.dispose();
        new Jogo();
    }

    private void adicionarComponentesAoFrame() {
        ImageIcon backgroundImage = new ImageIcon(getClass().getResource("imgfundo/imageback3.jpg"));
        JLabel backgroundLabel = new JLabel(backgroundImage);
        backgroundLabel.setBounds(0, 0, 800, 800);

        frame.add(buttonPanel);
        frame.add(textCima);
        frame.add(botaoFrente);
        frame.add(botaoTras);
        frame.add(textMeio);
        frame.add(botaoFrente2);
        frame.add(botaoFrente3);
        frame.add(botaoFrente4);
        frame.add(botaoFrente5);
        frame.add(textFim);
        frame.add(backgroundLabel);
    }

    private ImageIcon criarImagemIcon(String caminho) {
        return new ImageIcon(new ImageIcon(getClass().getResource(caminho))
                .getImage().getScaledInstance(CARTA_LARGURA, CARTA_ALTURA, Image.SCALE_SMOOTH));
    }
}