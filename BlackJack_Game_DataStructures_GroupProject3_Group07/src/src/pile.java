
package src ;

import java.util.ArrayList ;


/**
 * @author lewisc9
 * @version 1.0.0 2021-12-01 Initial implementation
 */
public class pile
    {

    protected ArrayList<card> cards ;

    protected pile( int size )
        {
        this.cards = new ArrayList<>( size ) ;
        }


    public void addCard( card c )
        {
        cards.add( c ) ;

        }


    public void removeCard( card c )
        {
        cards.remove( c ) ;
        }


    public void draw( hand h )
        {
        int r = this.cards.size() ;
        card c = this.cards.get( r - 1 ) ;
        h.addCard( c ) ;
        this.cards.remove( c ) ;
        }


    public void displayHand( hand h )
        {

        System.out.print( "Currently has " + h.cards.get( 0 ).getName() +
                          h.cards.get( 0 ).getSuit() ) ;

        for ( int i = 1 ; i <= h.cards.size() - 1; i++ )
            {
            card w = h.cards.get( i ) ;
            if ( w != null )
                {
                System.out.print( ", " + w.getName() + w.getSuit() ) ;
                }
            else
                {
                return ;
                }
            }

        }   
    }
// end class pile