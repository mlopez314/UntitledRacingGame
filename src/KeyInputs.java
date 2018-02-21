import java.util.ArrayList;

/**
 * This class keeps track of the current list of key inputs.
 * The key inputs are represented by Integers that are returned
 * when KeyEvent->getKeyCode() is called.
 */
public class KeyInputs {
  
  private ArrayList<Integer> currKeys;
  
  /**
   * Constructor for KeyInputs that initializes currKeys with an empty list.
   */
  public KeyInputs() {
    this.currKeys = new ArrayList<Integer>();
  }
  
  /**
   * Getter for current key inputs.
   * 
   * @return the current key inputs
   */
  public ArrayList<Integer> getKeys() {
    return currKeys;
  }
  
  /**
   * Adds a key to the list if the key is not there.
   * 
   * @param key the key code
   */
  public void addKey(int key) {
    if (!this.currKeys.contains(key)) {
      this.currKeys.add(key);
    }
  }
  
  /**
   * Removes a key from the list.
   * 
   * @param key the key code
   */
  public void removeKey(int key) {
    if (this.currKeys.contains(key)) {
      this.currKeys.remove(Integer.valueOf(key));
    }
  }  
  
  /**
   * Checks if the given key is in the current list of keys.
   * 
   * @param key the key code
   * @return true if key is in list
   */
  public boolean hasKey(int key) {
    return this.currKeys.contains(key);
  }
  
  /**
   * Checks if every key in the list is in KeyInputs.
   * 
   * @param keys the given list of keys
   * @return true of all keys are in list
   */
  public boolean hasKeys(int... keys) {
    boolean result = true;
    
    for (int key : keys) {
      if (!this.hasKey(key)) {
        result = false;
        break;
      }
    }
    
    return result;
  }
}