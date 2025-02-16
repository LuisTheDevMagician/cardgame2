import javax.sound.sampled.*;
import javax.swing.*;
import java.awt.*;
import java.io.IOException;
import java.io.InputStream;

public class MenuSom extends JFrame {

    private static MenuSom instance; // Instância única
    private Clip backgroundTheme;
    private Clip somBotao;
    private Clip acerto;
    private Clip erro;
    private Clip vitoriaBASED;
    private Clip vitoriaNotBASED;
    private Clip vitoriaAiMamae;
    private Clip vitoriaSeloko;
    private Clip somCarta;
    private Clip virarCartas;
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
        carregarSomAcerto();
        carregarSomErro();
        carregarSomVitoria();
        carregarSomCarta();
        carregarSomVirarCartas();
        carregarSomVitoriaNotBased();
        carregarSomVitoriaAiMamae();
        carregarSomSeloko();

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

    public void carregarSomAcerto() {
        try (InputStream SomAcertoStream = getClass().getResourceAsStream("/sons/acerto.wav")) {
            if (SomAcertoStream == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado: acerto.wav");
            }
            AudioInputStream SomAcertoStreamAIS = AudioSystem.getAudioInputStream(SomAcertoStream);
            acerto = AudioSystem.getClip();
            acerto.open(SomAcertoStreamAIS);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar o áudio do botão!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void carregarSomErro() {
        try (InputStream SomErroStream = getClass().getResourceAsStream("/sons/erro.wav")) {
            if (SomErroStream == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado: erro.wav");
            }
            AudioInputStream SomErroStreamAIS = AudioSystem.getAudioInputStream(SomErroStream);
            erro = AudioSystem.getClip();
            erro.open(SomErroStreamAIS);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar o áudio do botão!", "Erro", JOptionPane.ERROR_MESSAGE);
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

    public void carregarSomVitoria() {
        try (InputStream vitoriaStream = getClass().getResourceAsStream("/sons/gigachad.wav")) {
            if (vitoriaStream == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado: gigachad.wav");
            }
            AudioInputStream vitoriaAIS = AudioSystem.getAudioInputStream(vitoriaStream);
            vitoriaBASED = AudioSystem.getClip();
            vitoriaBASED.open(vitoriaAIS);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar o áudio do botão!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void carregarSomVitoriaNotBased() {
        try (InputStream vitoriaNotBasedStream = getClass().getResourceAsStream("/sons/vitoria.wav")) {
            if (vitoriaNotBasedStream == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado: vitoria.wav");
            }
            AudioInputStream vitoriaNotBasedAIS = AudioSystem.getAudioInputStream(vitoriaNotBasedStream);
            vitoriaNotBASED = AudioSystem.getClip();
            vitoriaNotBASED.open(vitoriaNotBasedAIS);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar o áudio do botão!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void carregarSomVitoriaAiMamae() {
        try (InputStream vitoriaAiMamaee = getClass().getResourceAsStream("/sons/aimaame.wav")) {
            if (vitoriaAiMamaee == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado: aimaame.wav");
            }
            AudioInputStream vitoriaAiMamaeeAIS = AudioSystem.getAudioInputStream(vitoriaAiMamaee);
            vitoriaAiMamae = AudioSystem.getClip();
            vitoriaAiMamae.open(vitoriaAiMamaeeAIS);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar o áudio do botão!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void carregarSomSeloko() {
        try (InputStream vitoriaSelokoNumCompensa = getClass().getResourceAsStream("/sons/numcompensa.wav")) {
            if (vitoriaSelokoNumCompensa == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado: numcompensa.wav");
            }
            AudioInputStream vitoriaSelokoNumCompensaAIS = AudioSystem.getAudioInputStream(vitoriaSelokoNumCompensa);
            vitoriaSeloko = AudioSystem.getClip();
            vitoriaSeloko.open(vitoriaSelokoNumCompensaAIS);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar o áudio do botão!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void carregarSomCarta() {
        try (InputStream cartaStream = getClass().getResourceAsStream("/sons/flipcard.wav")) {
            if (cartaStream == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado: flipcard.wav");
            }
            AudioInputStream cartaAIS = AudioSystem.getAudioInputStream(cartaStream);
            somCarta = AudioSystem.getClip();
            somCarta.open(cartaAIS);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar o áudio do botão!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void carregarSomVirarCartas() {
        try (InputStream cartassStream = getClass().getResourceAsStream("/sons/card-flipping.wav")) {
            if (cartassStream == null) {
                throw new IllegalArgumentException("Arquivo de áudio não encontrado: card-flipping.wav");
            }
            AudioInputStream cartassAIS = AudioSystem.getAudioInputStream(cartassStream);
            virarCartas = AudioSystem.getClip();
            virarCartas.open(cartassAIS);
        } catch (UnsupportedAudioFileException | IOException | LineUnavailableException e) {
            e.printStackTrace();
            JOptionPane.showMessageDialog(null, "Erro ao carregar o áudio do botão!", "Erro", JOptionPane.ERROR_MESSAGE);
        }
    }

    public void playSomAcerto() {
        stopBackgroundMusic();
        if (acerto != null) {
            acerto.setFramePosition(0); // Rewind to the beginning
            acerto.start();
        }
        startBackgroundMusic();
    }

    public void playSomErro() {
        stopBackgroundMusic();
        if (erro != null) {
            erro.setFramePosition(0); // Rewind to the beginning
            erro.start();
        }
        startBackgroundMusic();
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

    public void playVitoria() {
        stopBackgroundMusic();
        if (vitoriaBASED != null) {
            vitoriaBASED.setFramePosition(0); // Rewind to the beginning
            vitoriaBASED.start();
        }
    }

    public void stopVitoria() {
        if (vitoriaBASED != null) {
            vitoriaBASED.stop();
        }
    }

    public void playSomCarta() {
        stopBackgroundMusic();
        if (somCarta != null) {
            somCarta.setFramePosition(0); // Rewind to the beginning
            somCarta.start();
        }
        startBackgroundMusic();
    }

    public void playSomVirarCartas() {
        stopBackgroundMusic();
        if (virarCartas != null) {
            virarCartas.setFramePosition(0); // Rewind to the beginning
            virarCartas.start();
        }
        startBackgroundMusic();
    }

    public void stopVitoriaNotBased() {
        if (vitoriaNotBASED != null) {
            vitoriaNotBASED.stop();
        }
    }

    public void playVitoriaNotBased() {
        stopBackgroundMusic();
        if (vitoriaNotBASED != null) {
            vitoriaNotBASED.start();
            vitoriaNotBASED.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void stopAiMamae() {
        if (vitoriaAiMamae != null) {
            vitoriaAiMamae.stop();
        }
    }

    public void playVitoriaAimamae() {
        stopBackgroundMusic();
        if (vitoriaAiMamae != null) {
            vitoriaAiMamae.start();
            vitoriaAiMamae.loop(Clip.LOOP_CONTINUOUSLY);
        }
    }

    public void stopSeloko() {
        if (vitoriaSeloko != null) {
            vitoriaSeloko.stop();
        }
    }

    public void playVitoriaSeloko() {
        stopBackgroundMusic();
        if (vitoriaSeloko != null) {
            vitoriaSeloko.start();
            vitoriaSeloko.loop(Clip.LOOP_CONTINUOUSLY);
        }
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

}