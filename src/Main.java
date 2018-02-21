import javax.swing.JFrame;

/**
 * Represents the main class that will run the game.
 */
public class Main {
  
  public static void main(String[] args) {
    JFrame frame = new JFrame("O_o");
    frame.setSize(800, 800);
    frame.setLocationRelativeTo(null);
    frame.setResizable(false);
    frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    GameCanvas gc = new GameCanvas();
    frame.add(gc);
    frame.setVisible(true);
  }
  
}