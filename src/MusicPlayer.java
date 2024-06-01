import javax.sound.sampled.*;
import java.io.File;
import java.io.IOException;

public class MusicPlayer extends Thread{
    private Clip clip;
    private FloatControl volumeControl;

    public void run() {
        try {
            // Open an audio input stream.
            File soundFile = new File("resources\\AudioFiles\\NarutoBackgroundMusic.wav");
            AudioInputStream audioIn = AudioSystem.getAudioInputStream(soundFile);

            // Get a sound clip resource.
            clip = AudioSystem.getClip();

            // Open audio clip and load samples from the audio input stream.
            clip.open(audioIn);

            // Get the volume control from the clip.
            volumeControl = (FloatControl) clip.getControl(FloatControl.Type.MASTER_GAIN);

            // Start playing the music.
            clip.loop(Clip.LOOP_CONTINUOUSLY);  // Loop the clip continuously.
            clip.start();
        } catch (UnsupportedAudioFileException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } catch (LineUnavailableException e) {
            e.printStackTrace();
        }
    }

    // Method to stop the music
    public void stopMusic() {
        if (clip != null) {
            clip.stop();
            clip.close();
        }
    }

    // Method to set the volume (volume should be between 0.0 and 1.0)
    public void setVolume(float volume) {
        if (volumeControl != null) {
            this.setVolume(volume);
        }
    }
}
