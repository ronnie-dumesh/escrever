import java.util.Date;
import java.util.PriorityQueue;

public class Base {
	private static PriorityQueue<Card> queue; //Priority queue that contains all
	//cards sorted by their time 
	private static Card currentCard; //The current Card that is being modified
	private static String path; //The path of the file to be modified 
	
	/** importSet has the user select a CSV file from which to 
	 * make a PriorityQueue of Card objects ordered by time. This
	 * PriorityQueue is then used for later functions. 
	 * 
	 * importSet also sets the initial current Card to be displayed if
	 * the current set of Cards isn't finished for studying 
	 * 
	 * Precondition: the CSV file selected is formatted to have
	 * vocabulary words in the first column, accompanying definitions
	 * in the second column, accompanying hints in the third column
	 * (optional), and an accompanying time in the fourth column
	 * (optional). 
	 */
	public static void importSet() {
		path = csvModifier.chooseCSV();
		queue = csvModifier.readCSV(path);
		setCurrentCard(queue.poll());
		//included to prevent review from starting
		//if all cards are not ready to be reviewed again
		end();
	}
	
	/** saveProgress rewrites the CSV file from which
	 * the queue of Card objects was imported with updated
	 * information about the Card objects. 
	 */
	public static void saveProgress() {
		csvModifier.writeCSV(getQueueCopy(), path);
	}

	/** nextCard increases the time of the current Card,
	 * and if the current set of Card objects isn't finished
	 * for studying, it adds the current card back into the
	 * priority queue and sets a new current card to be 
	 * displayed 
	 * 
	 * @param delay is a Delay object by which the current
	 * Card's current time is increased. 
	 */
	public static void nextCard(Delay delay) {
		getCurrentCard().modifyTime(delay);
		if(!end()) {
			queue.add(getCurrentCard());
			setCurrentCard(queue.poll());
		}
	}

	/** end() determines whether the current set 
	 * of Card objects is finished for studying based on 
	 * whether the time of the Card with the highest priority
	 * is greater than the current time of the System. 
	 * 
	 * If this condition is met, false is returned
	 * 
	 * If this condition is not met, end() makes a new 
	 * Card object that then displays to the user that
	 * the current studying session is finished and
	 * returns true
	 * 
	 * @return Boolean of whether the current set of 
	 * Card objects is finished for studying 
	 */
	private static boolean end() {
		Long nextCardTime = queue.peek().getTimeLong();
		Long currentTime = new Date().getTime();
		if(nextCardTime < currentTime) {
			return false;
		} else {
			//included to prevent last card from getting
			//cut off and to prevent "you are done!" card from
			//being included 
			if(!currentCard.getDef().equals(" ")) { 
				queue.add(getCurrentCard());
			}
			//Card made to tell user they are finished 
			String[] doneString = new String[3];
			doneString[0] = "you are done! click save!";
			doneString[1] = " ";
			doneString[2] = "";
			Card doneCard = new Card(doneString);
			setCurrentCard(doneCard);
			return true;
		}
	}
	
	//returns a copy of the PriorityQueue containing all Card objects
	public static PriorityQueue<Card> getQueueCopy() {
		PriorityQueue<Card> copyPQ = new PriorityQueue<>(queue);
		return copyPQ;
	}
	
	//returns the current Card that is displayed
	public static Card getCurrentCard() {return currentCard;}
	
	//sets a new current Card to be displayed 
	private static void setCurrentCard(Card newCard) {
		currentCard = newCard;
	}
}
