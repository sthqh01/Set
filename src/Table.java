/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danielhuynh
 */
public class Table
{
  private TableNode head;
  
  public Table()
  {
    head = null;
  }
  
  public void add(Card a)
  {
    TableNode addTableNode = new TableNode(a);
    if (head == null)
    {
      head = addTableNode;
    }
    else
    {
      addTableNode.setNext(head);
      head = addTableNode;
    }
  }
  
  private int findIndex(Card a)
  {
    TableNode curr = head;
    int currIndex = 0;
    while (curr != null)
    {
      Card currCard = curr.getCard();
      if(currCard.equals(a))
      {
        return currIndex;
      }
      currIndex ++;
      curr = curr.getNext();
    }
    return currIndex;
  }
  
  private TableNode getTableNode(int a)
  {
    TableNode curr = head;
    for (int i = 0; i < a; i++)
    {
      curr = curr.getNext();
    }
    return curr;
  }
  
  private void removeCard(Card a)
  {
    int removeIndex = findIndex(a);
    if(removeIndex == 0)
    {
      head = getTableNode(1);
    }
    else if (removeIndex == (this.numCards()-1))
    {
      getTableNode(removeIndex-1).setNext(null);
    }
    else
    {
      getTableNode(removeIndex-1).setNext(getTableNode(removeIndex+1));
    }
  }
  
  private Boolean isMember(Card a)
  {
    TableNode curr = head;
    while(curr != null)
    {
      Card currCard = curr.getCard();
      if(currCard.equals(a))
      {
        return true;
      }
      curr = curr.getNext();
    }
    return false;
  }
  
  public void removeSet(Card a, Card b, Card c)
  {
   if (a.isSet(b,c) && isMember(a) && isMember(b) && isMember(c))
   {
     removeCard(a);
     removeCard(b);
     removeCard(c);
   }
  }
  
  public int numCards()
  {
    int numCards = 0;
    TableNode current = head;
    while(current != null)
    {
      numCards++;
      current = current.getNext();
    }
    return numCards;
  }
  
  public Card getCard(int a)
  {
    TableNode current = head;
    int num = 0;
    
    if (a > (this.numCards() - 1) || a < 0)
      return null;
    
    while (current.getNext() != null && num != a)
    {
      num ++;
      current= current.getNext();
    }
    return current.getCard();
  }
  
  public int numSets()
  {
    int numSets = 0;
    for (int i = 0; i < numCards(); i++)
    {
      for (int j = i + 1; j < numCards(); j++)
      {
        for (int k = j + 1; k < numCards(); k++)
        {
          if (getCard(i).isSet(getCard(j),getCard(k)))
          {
            numSets ++;
          }
        }
      }
    }
    return numSets;
  }
}

