import java.util.Comparator;
import java.util.Date;

/** This class contains a given word, its definition, a hint, and a time
 * associated with it for when it could next be made available for the rotation */ 
public class Card {
	private String word; //the Card's vocabulary word
	private String def;  //the Card'sdefinition
	private String hint; //an optional hint 
	private Long time; //associated time
	
	
	/** Constructor for the Card object
	 * This constructor assigns a vocabulary word, the give definition,
	 * a blank hint of " ", and a time to next be reviewed of the current time. 
	 * 
	 * @param word is the card's associated word
	 * @param def is the card's associated definition
	 */
	public Card(String word, String def) {
		this.word = word;
		this.def = def;
		this.hint = " ";
		this.time = new Date().getTime();
	}
	
	/** Constructor for the Card object 
	 * This constructor assigns a vocabulary word, the given definition,
	 * the given hint, and a time to next be reviewed of the current time. 
	 * 
	 * @param word is the card's associated word
	 * @param def is the card's associated definition
	 * @param hint is the card's associated hint
	 */
	public Card(String word, String def, String hint) {
		this.word = word;
		this.def = def;
		this.hint = hint;
		this.time = new Date().getTime();
	}
	
	/**Constructor for the Card object
	 * This constructor assigns a vocabulary word, the given definition,
	 * a blank hint of " ", and a time to next be reviewed. 
	 * 
	 * @param word is the card's associated word
	 * @param def is the card's associated definition
	 * @param time is the card's associated time
	 */
	public Card(String word, String def, Long time) {
		this.word = word;
		this.def = def;
		this.hint = " ";
		this.time = new Date().getTime();
	}
	
	/** Constructor for the Card object
	 * This constructor assigns a given vocabulary word, the given definition,
	 * the given hint, and a time to next be reviewed 
	 * 
	 * @param word is the card's associated word
	 * @param def is the card's associated definition
	 * @param hint is the card's associated hint
	 * @param time is the card's associated time 
	 */
	public Card(String word, String def, String hint, Long time) {
		this.word = word;
		this.def = def;
		this.hint = hint;
		this.time = time;
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
		String[] strArray = {getWord(), getDef(), getHint(), Long.toString(getTime())};
		return strArray;
	}
	
	@Override
	/** toString() returns a single-line String representation of the object
	 * that consists of 
	 * 
	 * @return a String representation of the Card
	 */
	public String toString() {
		return getWord() + " " + getDef() + " " + getHint() + " " + Long.toString(getTime()); 
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
	public Long getTime() {return time;} 
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
        return a.getTime().compareTo(b.getTime());
    } 
} 
