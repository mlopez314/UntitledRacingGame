import java.awt.Color;
import java.awt.Graphics;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;

import javax.swing.JPanel;
import javax.swing.Timer;

/**
 * Represents the canvas where the entire game will be rendered.
 */
public class GameCanvas extends JPanel implements KeyListener, ActionListener {
  
  private Timer tm;
  private KeyInputs keyInputs;
  private TestState testState;
  private long sysTime;
  
  public static double DELTA_TIME;
  
  /**
   * Constructor for GameCanvas that initializes the key inputs, timer, and
   * listeners.
   */
  public GameCanvas() {
    addKeyListener(this);
    this.keyInputs = new KeyInputs();
    this.testState = new TestState();
    this.tm = new Timer(10, this);
    this.tm.start();
    this.sysTime = System.nanoTime();
    GameCanvas.DELTA_TIME = 0;
  }
  
  @Override
  public void addNotify() {
    super.addNotify();
    requestFocus();
  }
  
  @Override
  public void paintComponent(Graphics g) {
    super.paintComponent(g);
    testState.draw(g);
  }

  @Override
  public void keyPressed(KeyEvent key) {
    keyInputs.addKey(key.getKeyCode());
  }

  @Override
  public void keyReleased(KeyEvent key) {
    keyInputs.removeKey(key.getKeyCode());
  }

  @Override
  public void keyTyped(KeyEvent arg0) {
    // TODO Auto-generated method stub
  }

  @Override
  public void actionPerformed(ActionEvent arg0) {
    GameCanvas.DELTA_TIME = (System.nanoTime() - this.sysTime) / 1000000000.0;
    this.sysTime = System.nanoTime();
    
    testState.update(keyInputs);
    repaint();
  }
}