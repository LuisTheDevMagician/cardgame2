import javax.sound.sampled.*;
import javax.swing.*;
import java.io.IOException;
import java.io.InputStream;

public class MenuSom {

    private static MenuSom instance; // Instância única
    private Clip backgroundTheme;
    private Clip somBotao;
    private final String IzzaMusic = "Izzamuzzic-Shootout_256k.wav";

    // Construtor privado para evitar instanciação externa
    private MenuSom() {
        carregarSom(IzzaMusic);
        carregarSomBotao();
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

    public void playButtonSound3() {
        if (somBotao != null) {
            somBotao.setFramePosition(0); // Rewind to the beginning
            somBotao.start();
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
}