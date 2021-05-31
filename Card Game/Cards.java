//package cardgame;
import java.util.Random;

public class Cards
{
  final int NOOFCARDSINFULLPACK = 52;


  Card[] cards;
  int valid; 

 
  public Cards(boolean fullPack) 
  {
    cards = new Card[NOOFCARDSINFULLPACK];
    valid = 0;
    if (fullPack)
      createFullPackOfCards();
  }
  
  public Card getTopCard() 
  {
    Card tmp;
    if (valid <= 0)
      return null;
    else 
    {
      valid--;
      tmp = cards[valid];
      cards[valid] = null;
      return tmp;
    }
  }
  
  public boolean addTopCard(Card c) 
  {
    if (valid < cards.length)
    {
      cards[valid] = c;   
      valid++;
      return true;
    }
    return false;
  }
  
  private void createFullPackOfCards() 
  {
    /*
     *  Todo
     */
    
    for(int i = 0; i<52;i++)
    {
      addTopCard(new Card(i));
    }
  }
  
  public void shuffle() 
  {
    Random rGen = new Random();     
    for (int i=0; i<cards.length; i++) 
    {
      int randomPosition = rGen.nextInt(cards.length);
      Card temp = cards[i];
      cards[i] = cards[randomPosition];
      cards[randomPosition] = temp;
    }
    /*
     *  Todo
     */
  }
  
  // For testOnly... remove from production version!
  public void testOnlyPrint() 
  {
    for (int i = 0; i < valid; i++) 
    {
      System.out.println(cards[i]);
    }
  }
}