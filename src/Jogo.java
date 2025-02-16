import java.awt.*;
import javax.swing.*;

public class Jogo extends JFrame {

    private static MenuSom menu = MenuSom.getInstance();

    public Jogo() {
        super("Exemplo JLabel e Icon");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new FlowLayout());
        setBounds(350, 100, 800, 600);
        setResizable(false);

        JPanel panel = new JPanel(new GridLayout(6, 2, 11, 11));

       if(menu != null) {
           menu.startBackgroundMusic();
        }

        // Criando um botão com as novas configurações
        JButton gas = criarBotao("Gases", Color.CYAN);
        gas.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new Gas();
        });
        panel.add(gas);

        JButton semimetal = criarBotao("Semimetais", Color.PINK);
        semimetal.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new SemiMetal();
        });
        panel.add(semimetal);

        JButton metalpostransicao = criarBotao("Metais de Pós Transição", Color.YELLOW);
        metalpostransicao.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new MetalPosTransicao();
        });
        panel.add(metalpostransicao);

        JButton naometal = criarBotao("Não Metais", Color.GREEN);
        naometal.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new NaoMetal();
        });
        panel.add(naometal);

        JButton superpesado = criarBotao("Elementos Super pesados", Color.ORANGE);
        superpesado.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new SuperPesado();
        });
        panel.add(superpesado);

        JButton alcalino = criarBotao("Metais Alcalinos e Alcalinos Terrosos", Color.MAGENTA);
        alcalino.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new AlcalinoAlcalinoTerroso();
        });
        panel.add(alcalino);

        JButton actidio = criarBotao("Actinídeos", Color.GREEN);
        actidio.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new Actinidio();
        });
        panel.add(actidio);

        JButton latanidio = criarBotao("Lantanídeos", Color.RED);
        latanidio.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new Latanideo();
        });
        panel.add(latanidio);

        JButton transicao = criarBotao("Metais de Transição", Color.BLUE);
        transicao.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new MetalTransicao();
        });
        panel.add(transicao);

        JButton curiosidade = criarBotao("Curiosidades", Color.GRAY);
        curiosidade.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new CuriosidadeElementos();
        });
        panel.add(curiosidade);

        JButton propiedades = criarBotao("Propiedades da Tabela", Color.LIGHT_GRAY);
        propiedades.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new PropiedadesTabela();
        });
        panel.add(propiedades);

        JButton escolherMusica = criarBotao("Escolha Música de Fundo", Color.BLACK);
        escolherMusica.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            menu.selecionarNovoSom();
        });
        panel.add(escolherMusica);

        panel.setBorder(BorderFactory.createEmptyBorder(9, 9, 9, 9));

        setContentPane(panel);

        setVisible(true);
    }

    // Função para criar botões com estilo
    private JButton criarBotao(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 20));
        botao.setPreferredSize(new Dimension(200, 200)); // Botão quadrado e menor
        botao.setBackground(cor);  // Definir a cor de fundo
        botao.setForeground(Color.WHITE); // Cor do texto
        botao.setFocusPainted(false); // Remove o foco
        botao.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2)); // Borda preta
        botao.setOpaque(true); // Para garantir que a cor de fundo seja visível
        return botao;
    }

    public static void main(String[] args) {
        new Jogo();
    }
}
