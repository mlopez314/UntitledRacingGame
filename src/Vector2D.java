/**
 * Represents a 2D vector where both of its points are doubles.
 */
public class Vector2D {
  
  public double x;
  public double y;
  
  /**
   * Constructor for Vector2D which initializes its x and y position
   * 
   * @param x the x position
   * @param y the y position
   */
  public Vector2D(double x, double y) {
    this.x = x;
    this.y = y;
  }
  
  /**
   * Translates this Vector2D by the given Vector2D
   * 
   * @param v the given Vector2D
   */
  public void translate(Vector2D v) {
    this.x += v.x;
    this.y += v.y;
  }
  
  /**
   * Calculates the magnitude of this Vector2D.
   * 
   * @return the magnitude of the Vector2D
   */
  public double magnitude() {
    return Math.sqrt(Math.pow(this.x, 2) + Math.pow(this.y, 2));
  }
  
  /**
   * Multiplies this Vector2D by a given constant 
   * 
   * @param num the constant to multiply with
   */
  public void multiply(double num) {
    this.x *= num;
    this.y *= num;
  }
  
  /**
   * Normalizes this Vector2D
   * 
   * @return the normalized Vector2D
   */
  public void normalize() {
    double mag = this.magnitude();
    
    this.x = this.x / mag;
    this.y = this.y / mag;
  }
  
  /**
   * Rounds given x and returns the result as an Integer
   * 
   * @return x as an Integer
   */
  public int xInt() {
    return (int)(Math.round(this.x));
  }
  
  /**
   * Rounds given y and returns the result as an Integer
   * 
   * @return y as an Integer
   */
  public int yInt() {
    return (int)(Math.round(this.y));
  }
  
  @Override
  public boolean equals(Object obj) {
    if (!(obj instanceof Vector2D)) {
      return false;
    } else {
      Vector2D that = (Vector2D)obj;
      
      return Math.abs(this.x - that.x) < 0.001
          && Math.abs(this.y - that.y) < 0.001;
    }
  }
  
  @Override
  public int hashCode() {
    return (int)(x * 10000 + y);
  }
}