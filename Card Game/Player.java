//package cardgame;

public class Player 
{
  String name;
  Cards hand;
  
  public Player(String name) 
  {
    this.name=name;
    hand = new Cards(false);
  }
  
  public String getName() 
  {
    return name;
  }
  
  public void add(Card c) 
  {
    hand.addTopCard(c);
  }
  
  public Card playCard() 
  {
    /*
     *  ToDo
     */
    return hand.getTopCard();
    
  }
  
  public String toString()
  {
    return getName();
  }
}