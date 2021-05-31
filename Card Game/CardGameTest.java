//package cardgame;
import java.util.Scanner;
import cardgame.*;

public class CardGameTest
{
  public static void main (String[] args)
  {
    Scanner scan = new Scanner(System.in);
    System.out.println("Start of CardGameTest\n");
    
    Card c;
    Cards cards;
    ScoreCard scores;
    Player p;
    CardGame game;
    
    c = new Card(1);
    System.out.println(c);
    System.out.println();
    
    cards = new Cards(true);
    cards.addTopCard(c);
    
    scores = new ScoreCard(4);
    scores.update(3,1);
    scores.update(1,2);
    System.out.println("\n"+scores);
    
    p = new Player("umut");
    p.add(c);
    System.out.println(p.getName().toUpperCase());
    System.out.println(p.playCard());
    
    System.out.println("\nEnd of CardGameTest\n");
  }
}