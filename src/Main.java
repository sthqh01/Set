/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danielhuynh
 */
public class Main
{
  public static void main (String[] args)
  {
    double countSets = 0;
    for (int i = 0; i < 10000; i++)
    {
      Game a = new Game();
      countSets += a.numSets();
    }
    System.out.println("The average number of sets in a random collection of 12 cards from the deck: " + countSets/10000);
    
    double countCardsLeft = 0;
    for (int i = 0; i < 10000; i++)
    {
      Game a = new Game();
      while(!a.isGameOver())
      {
        a.playRound();
      }
      countCardsLeft += a.numCards();
    }
    System.out.println("The average number of cards left at the end of the game: " + countCardsLeft/10000);
  }
}
