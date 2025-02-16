import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class MenuSom extends JFrame {

    private static MenuSom instance; // Instância única
    private Clip backgroundTheme;
    private Clip somBotao;
    private final String LofiHipHop = "LofihiphopMix.wav";
    private final String LofiJAzz = "AfternoonJAZZ.wav";
    private final String MemoriesofGreen = "MemoriesOfGreen.wav";
    private final String MemoryReboot = "memoryReboot.wav";
    private final String Synthwave = "Synthwave.wav";
    private final String Omaweamu = "omaweamu.wav";

    // Construtor privado para evitar instanciação externa
    private MenuSom() {

        carregarSom(LofiHipHop);
        carregarSomBotao();

    }

    private JButton criarBotao(String texto, Color cor) {
        JButton botao = new JButton(texto);
        botao.setFont(new Font("Arial", Font.BOLD, 20));
        botao.setPreferredSize(new Dimension(200, 200));
        botao.setBackground(cor);
        botao.setForeground(Color.WHITE);
        botao.setFocusPainted(false);
        botao.setBorder(BorderFactory.createLineBorder(Color.BLACK, 2));
        botao.setOpaque(true);
        return botao;
    }

    // Método para obter a instância única
    public static MenuSom getInstance() {
        if (instance == null) {
            instance = new MenuSom();
        }
        return instance;
    }

    public void carregarSom(String audioFile) {
        try (InputStream backgroundThemeStream = getClass().getResourceAsStream("/sons/" + audioFile)) {
            if (backgroundThemeStream == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado: " + audioFile);
            }
            AudioInputStream backgroundThemeAIS = AudioSystem.getAudioInputStream(backgroundThemeStream);
            backgroundTheme = AudioSystem.getClip();
            backgroundTheme.open(backgroundThemeAIS);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar o áudio: " + audioFile, "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void carregarSomBotao() {
        try (InputStream somBotaoStream = getClass().getResourceAsStream("/sons/ui-button-click-4-284571.wav")) {
            if (somBotaoStream == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado: ui-button-click-4-284571.wav");
            }
            AudioInputStream somBotaoAIS = AudioSystem.getAudioInputStream(somBotaoStream);
            somBotao = AudioSystem.getClip();
            somBotao.open(somBotaoAIS);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar o áudio do botão!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void playButtonSound() {
        stopBackgroundMusic();
        if (somBotao != null) {
            somBotao.setFramePosition(0); // Rewind to the beginning
            somBotao.start();
        }
    }

    public void playButtonSound2() {
        stopBackgroundMusic();
        if (somBotao != null) {
            somBotao.setFramePosition(0); // Rewind to the beginning
            somBotao.start();
        }
        startBackgroundMusic();
    }

    public void selecionarNovoSom() {
        JFrame frame = new JFrame();
        frame.setTitle("Menu Som");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(new FlowLayout());
        frame.setSize(800, 600); // Define o tamanho do JFrame
        frame.setResizable(false);

        JPanel panel = new JPanel(new GridLayout(6, 1, 11, 11));


        JButton lofi = criarBotao("Lofi/Atual", Color.CYAN);
        lofi.addActionListener(e -> {
            carregarSom(LofiHipHop);
            frame.dispose();
            new Jogo();
        });
        panel.add(lofi);

        JButton jazz = criarBotao("Jazz-Lofi", Color.YELLOW);
        jazz.addActionListener(e -> {
            carregarSom(LofiJAzz);
            frame.dispose();
            new Jogo();
        });
        panel.add(jazz);

        JButton green = criarBotao("Memories Of Green", Color.GREEN);
        green.addActionListener(e -> {
            carregarSom(MemoriesofGreen);
            frame.dispose();
            new Jogo();
        });
        panel.add(green);

        JButton memory = criarBotao("Memory Reboot - VOJ & NARVENT", Color.BLACK);
        memory.addActionListener(e -> {
            carregarSom(MemoryReboot);
            frame.dispose();
            new Jogo();
        });
        panel.add(memory);

        JButton synth = criarBotao("Synthwave", Color.MAGENTA);
        synth.addActionListener(e -> {
            carregarSom(Synthwave);
            frame.dispose();
            new Jogo();
        });
        panel.add(synth);

        JButton omaweamu = criarBotao("Omaweamu", Color.PINK);
        omaweamu.addActionListener(e -> {
            carregarSom(Omaweamu);
            frame.dispose();
            new Jogo();
        });
        panel.add(omaweamu);


        panel.setBorder(BorderFactory.createEmptyBorder(9, 9, 9, 9));
        frame.setContentPane(panel);
        frame.setLocationRelativeTo(null);
        frame.setVisible(true);

    }

    public void stopBackgroundMusic() {
        if (backgroundTheme != null) {
            backgroundTheme.stop();
        }
    }

    public void startBackgroundMusic() {
        if (backgroundTheme != null) {
            backgroundTheme.start();
            backgroundTheme.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }
}