//package cardgame;
import java.util.Scanner;
import cardgame.*;

public class MyCardGame
{
    public static void main( String[] args)
    {
        Scanner scan = new Scanner( System.in);
        System.out.println( "Start of MyCardGame\n");
        
        final int MENU_EXIT    = 0;
        final int MENU_PLAY_P1 = 1;
        final int MENU_PLAY_P2 = 2;
        final int MENU_PLAY_P3 = 3;
        final int MENU_PLAY_P4 = 4;
        final int MENU_SCORES  = 5;
        
        Player     p1, p2, p3, p4;
        CardGame   game;
        int        selection;
        
        p1 = new Player( "p1");
        p2 = new Player( "p2");
        p3 = new Player( "p3");
        p4 = new Player( "p4");
        
        game = new CardGame( p1, p2, p3, p4);
        
        game.initGame();
        
        do 
        {
            System.out.println();
            System.out.println( "MyCardGame   Round: " + game.getRoundNo() + "\t TurnOfPlayer: " + game.getTurnOfPlayerNo() );
            System.out.println();
            System.out.println( MENU_PLAY_P1 + " - Player " + MENU_PLAY_P1 + " plays" );
            System.out.println( MENU_PLAY_P2 + " - Player " + MENU_PLAY_P2 + " plays" );
            System.out.println( MENU_PLAY_P3 + " - Player " + MENU_PLAY_P3 + " plays" );
            System.out.println( MENU_PLAY_P4 + " - Player " + MENU_PLAY_P4 + " plays" );
            System.out.println( MENU_SCORES  + " - Show scores" );
            
            System.out.println();
            System.out.println( "Selection (" + MENU_EXIT + " to exit): ");
            selection = scan.nextInt();
            
            if ( selection == MENU_PLAY_P1 )
                play( p1, game);
            else if ( selection == MENU_PLAY_P2 )
                play( p2, game);
            else if ( selection == MENU_PLAY_P3 )
                play( p3, game);
            else if ( selection == MENU_PLAY_P4 )
                play( p4, game);
            else if ( selection == MENU_SCORES )
            {
                System.out.println( game.showScoreCard() );
                System.out.println( "ToDo..." );
            }
            else if ( selection != MENU_EXIT)
                System.out.println( "Invalid selection! \n" );
            
        } while ( selection != MENU_EXIT);

        System.out.println("Winner");
        for(int i=0; i<game.getWinners().length;i++)
        {
         System.out.println( game.getWinners()[0] ); 
        }
        
        
        System.out.println( "\nEnd of MyCardGame\n" );   
    }

    static boolean play( Player p, CardGame game)
    {
        Card c;
        boolean accepted;
        
        c = p.playCard();
        
        accepted = game.playTurn(p, c);
       
        if(accepted == false)
        {
          p.hand.addTopCard(c);
        }
        
        /*
         * ToDo...
         */

        return accepted;
    } 
} 