import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class TableTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testTable() 
  {
    Table a = new Table();
    
    assertEquals(0,a.numSets());
    assertEquals(0,a.numCards());
    
    Deck b = new Deck();
    Table c = new Table();
    for (int i = 0; i < 12; i++)
    {
      c.add(b.getNext());
    }

    assertEquals(12,c.numCards());
  }
}
