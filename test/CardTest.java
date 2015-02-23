import junit.framework.TestCase;

/**
 * A JUnit test case class.
 * Every method starting with the word "test" will be called when running
 * the test with JUnit.
 */
public class CardTest extends TestCase {
  
  /**
   * A test method.
   * (Replace "X" with a name describing the test.  You may write as
   * many "testSomething" methods in this class as you wish, and each
   * one will be called when running JUnit over this class.)
   */
  public void testCard() 
  {
    Card a = new Card (1,1,1,1);
    assertEquals(1, a.getQuantity());
    assertEquals(1, a.getColor());
    assertEquals(1, a.getShading());
    assertEquals(1, a.getShape());
    assertEquals("1ROO",a.toString());
    
    Card b = new Card (2,2,2,2);
    assertEquals(2, b.getQuantity());
    assertEquals(2, b.getColor());
    assertEquals(2, b.getShading());
    assertEquals(2, b.getShape());
    assertEquals("2GTD",b.toString());
    
    Card c = new Card (3,3,3,3);
    assertEquals(3, c.getQuantity());
    assertEquals(3, c.getColor());
    assertEquals(3, c.getShading());
    assertEquals(3, c.getShape());
    assertEquals("3PSS",c.toString());
    
    Card d = new Card (-5,-14,7,8);
    assertEquals(1, d.getQuantity());
    assertEquals(1, d.getColor());
    assertEquals(1, d.getShading());
    assertEquals(2, d.getShape());
    assertEquals("1ROD", d.toString());
    
    assertFalse(a.isSet(c,d));
    assertTrue(a.isSet(b,c));
    
    Card e = new Card (5,5,5,5);
    assertFalse(a.equals(b));
    assertTrue(b.equals(e));
  }
}
