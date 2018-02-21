import java.util.ArrayList;
import java.util.Arrays;

import org.junit.Test;
import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;
import static org.junit.Assert.assertFalse;

public final class KeyInputsTest {
  
  KeyInputs keyInputs;
  
  public KeyInputsTest() {
    keyInputs = new KeyInputs();
  }
  
  public void initKeyInputs() {
    keyInputs = new KeyInputs();
  }
  
  @Test
  public void testGetKeysFromEmptyList() {
    initKeyInputs();
    assertEquals(new ArrayList<Integer>(), keyInputs.getKeys());
  }
  
  @Test
  public void testAddKey() {
    initKeyInputs();
    keyInputs.addKey(52);
    
    assertEquals(new ArrayList<Integer>(Arrays.asList(52)), keyInputs.getKeys());
    
    keyInputs.addKey(25);
    assertEquals(new ArrayList<Integer>(Arrays.asList(52, 25)), keyInputs.getKeys());
  }
  
  @Test
  public void testRemoveKey() {
    initKeyInputs();
    keyInputs.addKey(52);
    keyInputs.addKey(25);
    keyInputs.removeKey(52);
    assertEquals(new ArrayList<Integer>(Arrays.asList(25)), keyInputs.getKeys());
    
    // Nothing happens when attempting to remove a key that is not in the list
    keyInputs.removeKey(30);
    assertEquals(new ArrayList<Integer>(Arrays.asList(25)), keyInputs.getKeys());
    
    keyInputs.removeKey(25);
    assertEquals(new ArrayList<Integer>(), keyInputs.getKeys());
    
    // Nothing happens when attempting to remove a key from an empty list
    keyInputs.removeKey(25);
    assertEquals(new ArrayList<Integer>(), keyInputs.getKeys());
  }
  
  @Test
  public void testHasKey() {
    initKeyInputs();
    keyInputs.addKey(52);
    keyInputs.addKey(66);
    
    assertTrue(keyInputs.hasKey(52));
    assertTrue(keyInputs.hasKey(66));
    assertFalse(keyInputs.hasKey(77));
    
    keyInputs.removeKey(52);
    assertFalse(keyInputs.hasKey(52));
    
    keyInputs.addKey(44);
    assertTrue(keyInputs.hasKey(44));
  }
  
  @Test
  public void testHasKeys() {
    initKeyInputs();
    keyInputs.addKey(73);
    keyInputs.addKey(23);
    keyInputs.addKey(99);
    
    assertTrue(keyInputs.hasKeys(23, 99));
    assertTrue(keyInputs.hasKeys(73));
    assertFalse(keyInputs.hasKeys(23, 100));
    assertFalse(keyInputs.hasKeys(75));
  }
}