/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danielhuynh
 */
import java.util.Collections;
import java.util.ArrayList;
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.StringTokenizer;

public class Deck
{
  ArrayList<Card> theCards = new ArrayList<Card>();
  private int nextCardIndex = 0;
  
  public Deck()
  {
    for(int a = 1; a <= 3; a++)
    {
      for (int b = 1; b<= 3; b++)
      {
        for (int c = 1; c <= 3; c++)
        {
          for (int d = 1; d <= 3; d++)
          {
            Card newCard = new Card(a,b,c,d);
            theCards.add(newCard);
          }
        }
      }
    }
    Collections.shuffle(theCards);
  }
  
  public Deck(String filename)
  {
     // Create the arraylist so we have a place to put the cards
    theCards = new ArrayList<Card>(81);
    
    try
    {
      String line;
      BufferedReader infile = new BufferedReader(new FileReader(filename));
      //int position = 0;
  
      while((line = infile.readLine()) != null)
      {
        // Blank lines might contain white space, so trim it off
        line = line.trim();
        
        // ignore blank lines
        // continue will cause the program to stop executing this iteration
        // of the body and re-evaluate the condition.
        if(line.length() == 0)
          continue;
        
        // ignore comments
        if(line.startsWith("#"))
          continue;
            
        // a valid line contains 4 integers
        // The StringTokenizer auto-magically breaks a string
        // into parts
        StringTokenizer tokenizer = new StringTokenizer(line);
        
        // The tokenizer gives us strings, that have to be converted,
        // or parsed, into integers.  If the string isn't an integer,
        // it will through an exception
        int quantity = Integer.parseInt(tokenizer.nextToken());
        int color = Integer.parseInt(tokenizer.nextToken());
        int shading = Integer.parseInt(tokenizer.nextToken());
        int shape = Integer.parseInt(tokenizer.nextToken());
        
        // If there was not an exception in the parse, then we
        // can create the card and add it to the deck.
        theCards.add(new Card(quantity, color, shading, shape));
      }
    }
    // We catch exceptions here and through a different kind of exception.
    // This code will make sense by the end of the semester.  I promise!
    catch(Exception e)
    {
      throw new RuntimeException("Error while reading file: " + e.toString());
    }
    
    // The first card we take is in index 0 (no matter how many cards
    // were in the file).
    nextCardIndex = 0;
  }
  
  public boolean hasNext()
  {
    if(nextCardIndex < theCards.size())
    {
      return true;
    }
    return false;
  }
  
  public Card getNext()
  {
    if (nextCardIndex < theCards.size())
    {
      Card a = theCards.get(nextCardIndex);
      nextCardIndex++;
      return a;
    }
    else
    {
      return null;
    }
  }
}

