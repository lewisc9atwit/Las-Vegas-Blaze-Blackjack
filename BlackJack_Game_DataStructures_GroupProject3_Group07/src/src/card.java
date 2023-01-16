
package src ;

/**
 * @author lewisc9
 * @version 1.0.0 2021-11-29 Initial implementation
 */
public class card
    {

    private String name ;
    private String suit ;
    private int value ;

    /**
     * @param name
     * @param suit
     * @param value
     */
    public card( String name, String suit, int value )
        {
        this.name = name ;
        this.suit = suit ;
        this.value = value ;
        }


    /**
     * @return the name
     */
    public String getName()
        {
        return this.name ;
        }


    /**
     * @param name
     *     the name to set
     */
    public void setName( String name )
        {
        this.name = name ;
        }


    /**
     * @return the suit
     */
    public String getSuit()
        {
        return this.suit.toUpperCase() ;
        }


    /**
     * @param suit
     *     the suit to set
     */
    public void setSuit( String suit )
        {
        this.suit = suit ;
        }


    /**
     * @return the value
     */
    public int getValue()
        {
        return value ;
        }


    /**
     * @param value
     *     the value to set
     */
    public void setValue( int value )
        {
        this.value = value ;
        }

    }
// end class card