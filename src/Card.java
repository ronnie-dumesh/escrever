import java.util.Comparator;
import java.util.Date;

/** This class contains a given word, its definition, a hint, and a time
 * associated with it for when it could next be made available for the rotation */ 
public class Card {
	private String word; //the Card's vocabulary word
	private String def;  //the Card'sdefinition
	private String hint; //an optional hint 
	private Long time; //associated time
	
	/**Constructor for the Card object 
	 * 
	 * @param vals is a String array that contains in order
	 * the word, definition, (optional) hint, and (optional) time.
	 * It must be at least two elements and no more than four
	 * elements where vals[0] = word, vals[1] = definition,
	 * vals[2] = hint, and vals[3] = time.
	 */
	public Card(String[] vals) {
		assert vals.length > 1;
		this.word = vals[0];
		this.def = vals[1];
		this.hint = vals.length > 2 ? vals[2] : " ";
		if (vals.length > 3) {
	    	this.time = Long.parseLong(vals[3]);
	    } else{
	    	this.time = new Date().getTime();
	    }
	}
	
	/** @return toStringArray() returns a String Array where:
	 * arr[0] is the card's word, 
	 * arr[1] is the card's definition, 
	 * arr[2] is the card's hint,
	 * arr[3] is the card's time
	 * 
	 * @return a String array representation of the Card
	 * 
	 */
	public String[] toStringArray(){
		String[] strArray = {getWord(), getDef(), getHint(), getTimeString()};
		return strArray;
	}
	
	@Override
	/** toString() returns a single-line String representation of the object
	 * that consists of 
	 * 
	 * @return a String representation of the Card
	 */
	public String toString() {
		return getWord() + " " + getDef() + " " + getHint() + " " + getTimeString(); 
	}
	
	/** modifyTime is a function that changes the time of the Card
	 * The amount time increases by is given by a Delay object 
	 * 
	 * @parameter delay: delay is a Delay object
	 * 
	 */ 
	public void modifyTime(Delay delay) {
		time = new Date().getTime() + delay.getNumVal();
	}
	
	//Getters
	/**@return the Card's word */
	public String getWord() {return word;}	
	
	/**@return the Card's definition */
	public String getDef() {return def;}
	
	/**@return the Card's hint */
	public String getHint() {return hint;}
	
	/**@return the Card's time as a Long*/
	public Long getTimeLong() {return time;} 

	/**@returns the Card's time as a String*/ 
	public String getTimeString() {return time.toString();} 
}

/** Class cardComparator implements the Comparator interface
 * for cards. It can be used to sort cards by time in 
 * ascending order
 * 
 * @return a positive number if a > b, a negative number if
 * b > a, and 0 if a == b
 */
class cardComparator implements Comparator<Card> 
{ 
    public int compare(Card a, Card b) 
    { 
        return a.getTimeLong().compareTo(b.getTimeLong());
    } 
} 
