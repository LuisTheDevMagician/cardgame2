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

        JPanel panel = new JPanel(new GridLayout(7, 2, 11, 11));

       if(menu != null) {
           menu.startBackgroundMusic();
        }

        // Criando um botão com as novas configurações
        JButton gas = criarBotao("Gases",new Color(0, 191, 255));
        gas.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new Gas();
        });
        panel.add(gas);

        JButton semimetal = criarBotao("Semimetais",new Color(255, 20, 147));
        semimetal.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new SemiMetal();
        });
        panel.add(semimetal);

        JButton metalpostransicao = criarBotao("Metais de Pós Transição",new Color(255, 215, 0));
        metalpostransicao.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new MetalPosTransicao();
        });
        panel.add(metalpostransicao);

        JButton naometal = criarBotao("Não Metais", new Color(34, 139, 34));
        naometal.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new NaoMetal();
        });
        panel.add(naometal);

        JButton superpesado = criarBotao("Elementos Super pesados", new Color(255, 140, 0));
        superpesado.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new SuperPesado();
        });
        panel.add(superpesado);

        JButton alcalino = criarBotao("Metais Alcalinos e Alcalinos Terrosos", new Color(148, 0, 211));
        alcalino.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new AlcalinoAlcalinoTerroso();
        });
        panel.add(alcalino);

        JButton actidio = criarBotao("Actinídeos", new Color(85, 107, 47));
        actidio.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new Actinidio();
        });
        panel.add(actidio);

        JButton latanidio = criarBotao("Lantanídeos", new Color(220, 20, 60));
        latanidio.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new Latanideo();
        });
        panel.add(latanidio);

        JButton transicao = criarBotao("Metais de Transição", new Color(30, 144, 255));
        transicao.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new MetalTransicao();
        });
        panel.add(transicao);

        JButton curiosidade = criarBotao("Curiosidades", new Color(75, 0, 130));
        curiosidade.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new CuriosidadeElementos();
        });
        panel.add(curiosidade);

        JButton propiedades = criarBotao("Propiedades da Tabela", new Color(169, 169, 169));
        propiedades.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new PropiedadesTabela();
        });
        panel.add(propiedades);

        JButton escolherMusica = criarBotao("Escolher Música de Fundo", new Color(0, 0, 0));
        escolherMusica.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            menu.selecionarNovoSom();
        });
        panel.add(escolherMusica);

        JButton ajuda = criarBotao("Ajuda", new Color(0, 128, 128));
        ajuda.addActionListener(e -> {
            menu.playButtonSound();
            dispose();
            new Ajuda();
        });
        panel.add(ajuda);

        JButton sair = criarBotao("Sair", new Color(0, 0, 128));
        sair.addActionListener(e -> {
            menu.playButtonSound();
            System.exit(0);
        });
        panel.add(sair);

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
