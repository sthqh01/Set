/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author danielhuynh
 */
public class Card
{
  private int quantity;
  private int color;
  private int shading;
  private int shape;
  
  public Card(int theQuantity, int theColor, int theShading, int theShape)
  {
    //checkQuantity
    if ((theQuantity % 3) < 1)
    {
      quantity  = (theQuantity % 3) + 3;
    }
    else
    {
      quantity = (theQuantity % 3);
    }
    //checkColor
    if ((theColor % 3) < 1)
    {
      color  = (theColor % 3) + 3;
    }
    else
    {
      color = (theColor % 3);
    }
    //checkShading
    if ((theShading % 3) < 1)
    {
      shading  = (theShading % 3) + 3;
    }
    else
    {
      shading = (theShading % 3);
    }
    //checkShape
    if ((theShape % 3) < 1)
    {
      shape  = (theShape % 3) + 3;
    }
    else
    {
      shape = (theShape % 3);
    }
  }
  
  public int getQuantity()
  {
    return quantity;
  }
  
  public int getColor()
  {
    return color;
  }
  
  public int getShading()
  {
    return shading;
  }
  
  public int getShape()
  {
    return shape;
  }
  
  public boolean isSet(Card a, Card b)
  {
    if (((quantity + a.getQuantity() + b.getQuantity()) % 3) == 0 &&
        ((color + a.getColor() + b.getColor()) % 3) == 0 &&
        ((shape + a.getShape() + b. getShape()) % 3) == 0 &&
        ((shading + a.getShading() + b. getShading()) % 3) == 0)
    {
      return true;
    }
    return false;
  }
  
  public String toString()
  {
    String theString;
    //Initializing theString and append the quantity string
    if (quantity == 1)
    { 
      theString = "1";
    }
    else if (quantity == 2)
    {
      theString = "2";
    }
    else
    {
      theString = "3";
    }
    
    //Appending the color string
    if (color == 1)
    {
      theString = theString + "R";
    }
    else if (color == 2)
    {
      theString = theString + "G";
    }
    else
    {
      theString = theString + "P";
    }
    
    //Appending the shading string
    if (shading == 1)
    {
      theString = theString + "O";
    }
    else if (shading == 2)
    {
      theString = theString + "T";
    }
    else
    {
      theString = theString + "S";
    }
    
    //Appending the shape string
    if (shape == 1)
    {
      theString = theString + "O";
    }
    else if (shape == 2)
    {
      theString = theString + "D";
    }
    else
    {
      theString = theString + "S";
    }
    
    return theString;
  }
  
  public boolean equals(Object obj)
  {
    Card that = (Card)obj;
    return quantity == that.getQuantity() &&
      color == that.getColor() &&
      shading == that.getShading() &&
      shape == that.getShape();
  }
}
