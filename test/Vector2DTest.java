import org.junit.Test;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public final class Vector2DTest {
  
  public Vector2DTest() {}
  
  @Test
  public void testEquals() {
    Vector2D v = new Vector2D(2.36, -3.15);
    
    assertTrue(v.equals(new Vector2D(2.36, -3.15)));
    assertTrue(new Vector2D(2.36, -3.15).equals(v));
    
    assertFalse(v.equals(new Vector2D(2.35, -3.16)));
    assertFalse(new Vector2D(2.37, -3.14).equals(v));
  }
  
  @Test
  public void testTranslate() {
    Vector2D v = new Vector2D(2, 5);
    v.translate(new Vector2D(4, 5.05));
    
    assertEquals(new Vector2D(6, 10.05), v);
  }
  
  @Test
  public void testMagnitude() {
    Vector2D v0 = new Vector2D(3, 4);
    
    assertTrue(Math.abs(v0.magnitude() - 5) < 0.001);
  }
  
  @Test
  public void testNormalize() {
    Vector2D v0 = new Vector2D(3, 4);
    
    v0.normalize();
    assertEquals(new Vector2D(3.0 / 5.0, 4.0 / 5.0), v0);
  }
  
  @Test
  public void testXIntAndYInt() {
    Vector2D v0 = new Vector2D(2.40, 3.65);
    Vector2D v1 = new Vector2D(4.50, 4.49);
    
    assertEquals(2, v0.xInt());
    assertEquals(4, v0.yInt());
    assertEquals(5, v1.xInt());
    assertEquals(4, v1.yInt());
  }
}