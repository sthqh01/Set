/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danielhuynh
 */
public class Game
{
  private Table t = new Table();
  private Deck d;
  
  public Game()
  {
    d = new Deck();
    int i = 0;
    while (d.hasNext() && i != 12)
    {
      t.add(d.getNext());
      i++;
    }
  }
  
  public Game(String a)
  {
    d = new Deck(a);
    int i = 0;
    while (d.hasNext() && i != 12)
    {
      t.add(d.getNext());
      i++;
    }
  }
  
  public int numSets()
  {
    return t.numSets();
  }
  
  public int numCards()
  {
    return t.numCards();
  }
  
  public void playRound()
  {
    int execution = 0;
    
    if (execution == 0 && t.numSets() == 0 && d.hasNext())
    {
      int i = 0;
      while (d.hasNext() & i != 3)
      {
        t.add(d.getNext());
        i++;
      }
      
      execution ++;
    }
    
    if (execution == 0 && t.numSets() != 0 && d.hasNext() && t.numCards() == 12)
    {
      int count = 0;
      for (int i = 0; i < t.numCards(); i++)
      {
        for (int j = i + 1; j < t.numCards(); j++)
        {
          for (int k = j + 1; k < t.numCards() && count == 0; k++)
          {
            if (t.getCard(i).isSet(t.getCard(j),t.getCard(k)))
            {
              t.removeSet(t.getCard(i), t.getCard(j), t.getCard(k));
              count ++;
            }
          }
        }
      }
      
      int i = 0;
      while (d.hasNext() & i != 3)
      {
        t.add(d.getNext());
        i++;
      }
      
      execution++;
    }
    
    if (execution == 0 && t.numCards() > 12 && t.numSets() != 0)
    {
      int count = 0;
      for (int i = 0; i < t.numCards(); i++)
      {
        for (int j = i + 1; j < t.numCards(); j++)
        {
          for (int k = j + 1; k < t.numCards() && count == 0; k++)
          {
            if (t.getCard(i).isSet(t.getCard(j),t.getCard(k)))
            {
              t.removeSet(t.getCard(i), t.getCard(j), t.getCard(k));
              count ++;
            }
          }
        }
      }
      
      execution ++;
    }
    
    if (execution == 0 && t.numSets() != 0 && !d.hasNext())
    {
      int count = 0;
      for (int i = 0; i < t.numCards(); i++)
      {
        for (int j = i + 1; j < t.numCards(); j++)
        {
          for (int k = j + 1; k < t.numCards() && count == 0; k++)
          {
            if (t.getCard(i).isSet(t.getCard(j),t.getCard(k)))
            {
              t.removeSet(t.getCard(i), t.getCard(j), t.getCard(k));
              count ++;
            }
          }
        }
      }
      
      execution ++;
    }
  }
  
  public boolean isGameOver()
  {
    return (t.numSets() == 0 && !d.hasNext());
  }
}
