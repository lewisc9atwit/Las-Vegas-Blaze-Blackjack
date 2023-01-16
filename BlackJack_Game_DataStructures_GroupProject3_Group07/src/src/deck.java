
package src ;

import java.util.* ;

/**
 * @author lewisc9
 * @version 1.0.0 2021-11-29 Initial implementation
 */
public class deck extends pile
    {

    private static Random random = new Random() ;

    public deck()
        {
        super(52);
        populateDeck();
        shuffleDeck();
        }


   public void populateDeck()
        {
        String[] names = { "2", "3", "4", "5", "6", "7", "8", "9", "10", "J", "Q",
                           "K", "A" } ;
        int[] values = { 2, 3, 4, 5, 6, 7, 8, 9, 10, 10, 10, 10, 1 } ;

        for ( int i = 0 ; i <= 12 ; i++ )
            {
            card c = new card( names[ i ], "D", values[ i ] ) ;
            addDiamonds( c ) ;
            }
        for ( int i = 0 ; i <= 12 ; i++ )
            {
            card c = new card( names[ i ], "H", values[ i ] ) ;
            addHearts( c ) ;
            }
        for ( int i = 0 ; i <= 12 ; i++ )
            {
            card c = new card( names[ i ], "S", values[ i ] ) ;
            addSpades( c ) ;
            }
        for ( int i = 0 ; i <= 12 ; i++ )
            {
            card c = new card( names[ i ], "C", values[ i ] ) ;
            addClubs( c ) ;
            }
        }


    public void shuffleDeck()
        {
        Collections.shuffle( this.cards ) ;
        }


    public void addDiamonds( card c )
        {
        this.cards.add( c ) ;
        }


    public void addHearts( card c )
        {
        this.cards.add( c ) ;
        }


    public void addSpades( card c )
        {
        this.cards.add( c ) ;
        }


    public void addClubs( card c )
        {
        this.cards.add( c ) ;
        }

    }
// end class deck