import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.event.KeyEvent;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * This game state will be used to test added mechanics and game objects.
 */
public class TestState {
  
  private Player player;
  private Camera camera;
  private BufferedImage bg;
  
  public TestState() {
    this.player = new Player(new Vector2D(0, 0));
    this.camera = new Camera(new Vector2D(0, 0), 0);
    
    try {
      this.bg = ImageIO.read(TestState.class.getResource("/img/neu_map11.png"));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  public void update(KeyInputs keyInputs) {
    if (keyInputs.hasKey(KeyEvent.VK_W)) {
      player.setThrottleApplied(true);
    } else {
      player.setThrottleApplied(false);
    }
    
    if (keyInputs.hasKey(KeyEvent.VK_A)) {
      player.steer(false);
    }
    
    if (keyInputs.hasKey(KeyEvent.VK_S) || keyInputs.hasKey(KeyEvent.VK_SPACE)) {
      player.setBrakeApplied(true);
    } else {
      player.setBrakeApplied(false);
    }
    
    if (keyInputs.hasKey(KeyEvent.VK_D)) {
      player.steer(true);
    }
    
    player.updatePlayer();
    camera.positionRelativeToPlayer(this.player);
  }

  public void draw(Graphics g) {    
    g.drawImage(bg, 0 - camera.position.xInt(), 0 - camera.position.yInt(), null);
    player.draw(g, this.camera);
    
    g.setColor(Color.BLACK);
    g.setFont(new Font("Arial", Font.PLAIN, 25));
    g.drawString("Speed: " + (int)(player.currSpeed / 5.0) + " km/h", 600, 30);
  }
}