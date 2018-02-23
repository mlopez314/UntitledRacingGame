/**
 * Represents the game camera which will determine the location
 * each image is displayed.
 */
public class Camera {
  
  public Vector2D position;
  public int rotation;
  
  /**
   * Constructor for Camera which initializes position and rotation.
   * 
   * @param position the position
   * @param rotation the rotation in degrees
   */
  public Camera(Vector2D position, int rotation) {
    this.position = position;
    this.rotation = rotation;
  }
  
  /**
   * Moves the camera's position by the given Vector2D.
   * 
   * @param v the given Vector2D
   */
  public void translate(Vector2D v) {
    this.position.translate(v);
  }
  
  /**
   * Rotates the camera by the given angle.
   * 
   * @param angle the given angle in degrees
   */
  public void rotate(int angle) {
    this.rotation += angle;
    
    while(this.rotation < 0) {
      this.rotation += 360;
    }
    
    while(this.rotation >= 360) {
      this.rotation -= 360;
    }
  }

  public void positionRelativeToPlayer(Player player) {
    this.position = new Vector2D(player.position.x - (400 - 300 * Math.sin(Math.toRadians(player.direction))), 
        player.position.y - (700 - 600 * Math.abs(Math.sin(0.5 * Math.toRadians(player.direction)))));
  }
}