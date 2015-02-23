import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class DeckTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testDeck() 
  {
    Deck a = new Deck();
    Card theCards[] = new Card[81];
    
    for (int i = 0; i < 81; i++)
    {
      theCards[i] = a.getNext();
    }
    
    assertFalse(a.hasNext());
  }
  
}
