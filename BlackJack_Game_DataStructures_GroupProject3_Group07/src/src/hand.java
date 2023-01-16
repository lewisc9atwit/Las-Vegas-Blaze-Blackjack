
package src ;

import java.util.ArrayList ;

/**
 * @author lewisc9
 * @version 1.0.0 2021-12-01 Initial implementation
 */
public class hand extends pile
    {

    private int handValue ;

    /**
     * @param size
     */
    protected hand( int size )
        {
        // TODO Auto-generated constructor stub
        super( size ) ;
        this.handValue = this.getValue() ;
        }


    @SuppressWarnings( "null" )
    public int getValue()
        {
        int sum = 0 ;
        ArrayList<card> potentialAces = new ArrayList<>( 4 ) ;
        ArrayList<card> hand = new ArrayList<>( this.cards.size() ) ;
        for ( int i = 0 ; i < this.cards.size() ; i++ )
            {
            card card = this.cards.get( i ) ;
            if ( card.getName() == "A" )
                {
                potentialAces.add( card ) ;
                }
            else
                {
                hand.add( card ) ;
                }
            }

        for ( int i = 0 ; i < hand.size() ; i++ )
            {
            sum += hand.get( i ).getValue() ;
            }

        for ( int i = 0 ; i < potentialAces.size() ; i++ )
            {
            if ( potentialAces.get( i ).getName() == "A" )
                {
                if ( sum + 11 > 21 )
                    {
                    sum++ ;
                    }
                if ( sum + 11 <= 21 )
                    {
                    sum = sum + 11 ;
                    }
                }

            }
        this.handValue = sum ;
        return sum ;
        }

    }
// end class hand