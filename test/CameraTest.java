import org.junit.Test;

import static org.junit.Assert.assertEquals;

public final class CameraTest {
  
  public CameraTest() {}
  
  @Test
  public void testTranslate() {
    Camera c = new Camera(new Vector2D(0, 0), 0);
    
    c.translate(new Vector2D(4, -10));
    
    assertEquals(new Vector2D(4, -10), c.position);
  }
}