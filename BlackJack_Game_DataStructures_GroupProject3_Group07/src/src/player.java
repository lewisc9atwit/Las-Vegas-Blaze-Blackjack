
package src ;

import java.util.Scanner ;

/**
 * @author klebanovy
 * @version 1.0.0 2021-11-29 Initial implementation
 */
public class player extends hand
    {

    String name ;
    boolean isBusted ;
    boolean stood ;
    boolean blackjack ;
    /**
     * @param name
     */
    public player( String name )
        {
        super( 5 ) ;
        this.name = name ;
        this.isBusted = false ;
        this.stood = false ;
        this.blackjack = false ;
        }


    /**
     * @param s
     * @return true or false
     */
    public boolean Hitting( Scanner input )
        {
        do
            {
            System.out.printf( "Do you want to hit? [yes/no]: " ) ;
            String answer = input.nextLine() ;

            if ( answer.toLowerCase().equals( "yes" ) )
                {
                return true ;
                }
            else if ( answer.toLowerCase().equals( "no" ) )
                {
                return false ;
                }
            else
                {
                System.out.println( "You have not entered an appropriate answer" ) ;
                }
            }
        while ( true ) ;
        }


    public boolean getIsBusted()
        {
        return this.isBusted ;
        }


    public boolean getStood()
        {
        return this.stood ;
        }


    public void playerStands()
        {
        this.stood = true ;
        }


    public boolean checkIfBusted()
        {
        if ( this.getValue(  ) <= 21 )
            {
            return false ;
            }
        else if ( this.getValue(  ) > 21 )
            {
            this.isBusted = true ;
            System.out.println(this.name + " has gone over 21!!!");
            return true ;
            }
        else
            {
            return this.isBusted ;

            }
        }
    
    public boolean checkIfBlackjack() {
        if (this.getValue() == 21) {
            this.blackjack = true;
            System.out.println( this.name + " has blackjack!!!" );
        }
        return this.blackjack;
    }

    }
// end class Player