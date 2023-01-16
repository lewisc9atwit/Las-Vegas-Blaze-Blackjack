
package src ;

import java.util.ArrayList ;
import java.util.Collections ;
import java.util.Scanner ;

/**
 * @author klebanovy
 * @version 1.0.0 2021-11-29 Initial implementation
 */
public class Game
    {

    /**
     * @param args
     */
    public static void main( String[] args )
        {
        // TODO Auto-generated method stub
        deck deck = new deck() ;
        Scanner input = new Scanner( System.in ) ;

        System.out.printf( "Welcome to Blackjack!! %n" ) ;
        System.out.printf( "How many players are going to be playing?" ) ;
        int totalPlayers = input.nextInt() ;

        ArrayList<player> activePlayers = new ArrayList<>( totalPlayers ) ;

        // Generates Players and Adds them to an ArrayList
        for ( int i = 0 ; i < totalPlayers ; i++ )
            {
            int playerNum = i + 1 ;
            System.out.printf( "What is the name of Player #%d: ", playerNum ) ;
            String name = input.next() ;
            player player = new player( name ) ;
            activePlayers.add( player ) ;
            }

        // Dealing Cards to Players
        for ( int i = 0 ; i < activePlayers.size() ; i++ )
            {
            player player = activePlayers.get( i ) ;
            deck.draw( activePlayers.get( i ) ) ; // Draws first Card
            deck.draw( activePlayers.get( i ) ) ; // Draws second card
            System.out.println( activePlayers.get( i ).name + " - " ) ;
            deck.displayHand( activePlayers.get( i ) ) ;
            System.out.println( " with a total value of: " +
                                activePlayers.get( i ).getValue() ) ;
            player.checkIfBlackjack() ;
            System.out.println() ;
            }
        
        // Game continues with hit/stand/bust sequence
        Scanner hit = new Scanner( System.in ) ;
        for ( int i = 0 ; i < activePlayers.size() ; i++ )
            {
            System.out.println() ;
            System.out.println( activePlayers.get( i ).name + " - " ) ;
            player player = activePlayers.get( i ) ;
            while ( ( player.isBusted == false ) && ( player.stood == false ) &&
                    ( player.blackjack == false ) )
                {
                boolean t = activePlayers.get( i ).Hitting( hit ) ;
                if ( t == true )
                    {
                    deck.draw( activePlayers.get( i ) ) ;
                    System.out.println() ;
                    System.out.println( activePlayers.get( i ).name + " - " ) ;
                    deck.displayHand( activePlayers.get( i ) ) ;
                    System.out.println( " with a total value of: " +
                                        activePlayers.get( i ).getValue() ) ;
                    player.checkIfBusted() ;
                    player.checkIfBlackjack() ;
                    }
                else
                    {
                    player.playerStands() ;
                    System.out.print( activePlayers.get( i ).name +
                                      " stands with a value of: " ) ;
                    System.out.println( activePlayers.get( i ).getValue() ) ;
                    }
                }
            }
        endGameSequence( activePlayers ) ;
        }

// sort scores 
    public static void endGameSequence( ArrayList<player> activePlayers )
        {
        ArrayList<player> blackJackPlayers = new ArrayList<>() ;
        ArrayList<player> bustedPlayers = new ArrayList<>() ;
        ArrayList<player> needSorting = new ArrayList<>() ;

        for ( int i = 0 ; i < activePlayers.size() ; i++ )
            {
            player p = activePlayers.get( i ) ;
            if ( p.getValue() == 21 )
                {
                blackJackPlayers.add( p ) ;
                }
            if ( p.getValue() > 21 )
                {
                bustedPlayers.add( p ) ;
                }
            if ( p.getValue() < 21 )
                {
                needSorting.add( p ) ;
                }
            }
        if ( blackJackPlayers.isEmpty() == false )
            {
            System.out.println( "Winner(s): " ) ;
            for ( int i = 0 ; i < blackJackPlayers.size() ; i++ )
                {
                System.out.println( blackJackPlayers.get( i ).name + " " ) ;
                }
            System.out.println( "Loser(s): " ) ;
            for ( int i = 0 ; i < bustedPlayers.size() ; i++ )
                {
                System.out.println( bustedPlayers.get( i ).name + " " ) ;
                }
            for ( int i = 0 ; i < needSorting.size() ; i++ )
                {
                System.out.println( needSorting.get( i ).name + " " ) ;
                }
            }

        if ( blackJackPlayers.isEmpty() )
            {
            ArrayList<player> winners = new ArrayList<>() ;
            winners.add( needSorting.get( 0 ) ) ;
            for ( int i = 1 ; i < needSorting.size() ; i++ )
                {
                player p = needSorting.get( i ) ;
                if ( p.getValue() > winners.get( 0 ).getValue() )
                    {
                    bustedPlayers.add( winners.get( 0 ) ) ;
                    winners.remove( 0 ) ;
                    winners.add( p ) ;
                    }
                else if ( p.getValue() == winners.get( 0 ).getValue() )
                    {
                    winners.add( p ) ;
                    }
                else
                    {
                    bustedPlayers.add( p ) ;
                    }
                }
            System.out.println( "Winner(s): " ) ;
            for ( int i = 0 ; i < winners.size() ; i++ )
                {
                System.out.println( winners.get( i ).name + " " ) ;
                }
            System.out.println( "Loser(s): " ) ;
            for ( int i = 0 ; i < bustedPlayers.size() ; i++ )
                {
                System.out.println( bustedPlayers.get( i ).name + " " ) ;
                }

            }

        }

    }

// if ( p.isBusted == true )
// {
// winOrLose[ i ] = p.getValue( p ) ;
// System.out.println(p.name + " loses!");
// }
// if (p.checkIfBlackjack() == true ) {
// winOrLose[ i ] = p.getValue( p ) ;
// System.out.println(p.name + " wins!");
//

// end class Game