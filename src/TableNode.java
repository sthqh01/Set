/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danielhuynh
 */
public class TableNode
{
  private Card theCard;
  private TableNode next;
  
  public TableNode(Card a)
  {
    theCard = a;
    next = null;
  }
  
  public void setNext(TableNode a)
  {
    next = a;
  }
  
  public TableNode getNext()
  {
    return next;
  }
  
  public Card getCard()
  {
    return theCard;
  }
}

