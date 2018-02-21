import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.io.IOException;

import javax.imageio.ImageIO;

/**
 * Represents the player driving a car.
 */
public class Player {
  
  public Vector2D position;
  public double direction;
  public double currSpeed;
  private boolean throttleApplied;
  private boolean brakeAppied;
  private BufferedImage img;
  
  public Player(Vector2D position) {
    this.position = position;
    this.direction = 0;
    this.currSpeed = 0;
    this.throttleApplied = false;
    this.brakeAppied = false;
    
    try {
      this.img = ImageIO.read(Player.class.getResource("/img/car.png"));
    } catch (IOException e) {
      // TODO Auto-generated catch block
      e.printStackTrace();
    }
  }
  
  /**
   * Getter for field throttleApplied.
   * 
   * @return throttleApplied
   */
  public boolean getThrottleApplied() {
    return this.throttleApplied;
  }
  
  /**
   * Setter for throttleApplied.
   * 
   * @param b boolean to set throttleApplied to
   */
  public void setThrottleApplied(boolean b) {
    this.throttleApplied = b;
  }
  
  /**
   * Getter for brakeApplied.
   * 
   * @return brakeApplied
   */
  public boolean getBrakeApplied() {
    return this.brakeAppied;
  }
  
  /**
   * Setter for brakeApplied.
   * 
   * @param b boolean to set brakeApplied to
   */
  public void setBrakeApplied(boolean b) {
    this.brakeAppied = b;
  }
  
  /**
   * Steers the car (TEMPORARY)
   * 
   * @param isRight
   */
  public void steer(boolean isRight) {
    if (isRight) {
      this.direction += 150 * GameCanvas.DELTA_TIME;
    } else {
      this.direction -= 150 * GameCanvas.DELTA_TIME;
    }
    
    while(this.direction < 0) {
      this.direction += 360;
    }
    
    while(this.direction >= 360) {
      this.direction -= 360;
    }
  }
  
  public void updatePlayer() {
    if (this.throttleApplied && !this.brakeAppied) {
      this.currSpeed += 100 * GameCanvas.DELTA_TIME;
    }
    
    if (this.brakeAppied) {
      this.currSpeed -= 1000 * GameCanvas.DELTA_TIME;
    }
    
    if (!this.throttleApplied && !this.brakeAppied) {
      this.currSpeed -= 100 * GameCanvas.DELTA_TIME;
    }
    
    if (this.currSpeed < 0) {
      this.currSpeed = 0;
    }
    
    if (this.currSpeed > 400) {
      this.currSpeed = 400;
    }
    
    Vector2D v = new Vector2D(Math.sin(Math.toRadians(direction)), -Math.cos(Math.toRadians(direction)));
    v.normalize();
    v.multiply(this.currSpeed * GameCanvas.DELTA_TIME);
    this.position.translate(v);
  }
  
  public void draw(Graphics g, Camera c) {
    Graphics2D g2d = (Graphics2D)g;
    AffineTransform at = new AffineTransform();
    at.translate(this.position.x - c.position.x, this.position.y - c.position.y);
    at.rotate((direction * Math.PI) / 180);
    at.translate(-img.getWidth() / 2, -img.getHeight() / 2);
    g2d.drawImage(img, at, null);
    
    //g.drawImage(img, position.xInt() - c.position.xInt(), position.yInt() - c.position.yInt(), null);
  }
}