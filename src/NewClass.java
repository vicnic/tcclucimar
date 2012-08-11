import java.io.BufferedInputStream;
import java.io.FileInputStream;
import javazoom.jl.player.Player;

/**
 * Wayne, K. (2005). How to Play an MP3 File in Java. 
 * Available: http://introcs.cs.princeton.edu/faq/mp3/mp3.html.
 * Last accessed 10th Mar 2011.
 * @author temelm
 */
public class NewClass {
  private String filename;
  private Player player;

  /**
   * MP3 constructor
   * @param filename name of input file
   */
  public NewClass(String filename) {
    this.filename = filename;
  }

  /**
   * Creates a new Player
   */
  public void play() {
    try {
      FileInputStream fis = new FileInputStream(this.filename);
      BufferedInputStream bis = new BufferedInputStream(fis);

      this.player = new Player(bis);
    } catch (Exception e) {
        System.err.printf("%s\n", e.getMessage());
    }

    new Thread() {
      @Override
      public void run() {
        try {
          player.play();
        } catch (Exception e) {
            System.err.printf("%s\n", e.getMessage());
        }
      }
    }.start();
  }

  /**
   * Closes the Player
   */
  public void close() {
    if (this.player != null) {
      this.player.close();
    }
  }

  /////////////////////////

  /**
   * Plays '01 Maenam.mp3' in an infinite loop
   */
  public static void playMaenam() {
    NewClass mp3 = new NewClass("./01 Maenam.mp3");

    mp3.play();

    while (true) {
      if (mp3.player.isComplete()) {
        mp3.close();
        mp3.play();
      }
    }
  }   
}