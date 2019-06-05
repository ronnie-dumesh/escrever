import java.io.File;
import java.io.FileNotFoundException;
import java.io.PrintWriter;

import java.util.Scanner;
import java.util.PriorityQueue;

import javax.swing.JFileChooser;
import javax.swing.filechooser.FileSystemView;

public class csvModifier {
	
	/** readCSV reads a CSV file to create Card objects and add
	 * them to a priority queue 
	 *
	 *@param path is the path to a CSV file that is properly formatted
	 * to have vocabulary words in the first column, accompanying definitions
	 * in the second column, accompanying hints in the third column
	 * (optional), and an accompanying time in the fourth column
	 * (optional). 
	 *
	 *@return PriorityQueue of Card objects read from the CSV file
	 */
	public static PriorityQueue<Card> readCSV(String path) {
		//https://www.youtube.com/watch?v=3_40oiUdLG8
		
		 PriorityQueue<Card> queue = new 
	             PriorityQueue<Card>(new cardComparator()); 
		
		File file = new File(path);
		
		try {
			Scanner inputStream = new Scanner(file);
			while(inputStream.hasNext()) {
				String data = inputStream.nextLine();
				String[] values = data.split(",");
				Card card = new Card(values);
				queue.add(card);
			}
			
			inputStream.close();
		} catch (FileNotFoundException e) {
			System.out.println("Error reading CSV");
			e.printStackTrace();
		}
		return queue; 
	}
	
	/**writeCSV saves the progress of a user by copying the information
	 * of every card being reviewed into a CSV file
	 * 
	 * @param queue is a PriorityQueue of Card objects to be written to the file 
	 * @param fileName is the name of a CSV file. 
	 */
	public static void writeCSV(PriorityQueue<Card> queue, String fileName) {
		//https://stackoverflow.com/questions/30073980/java-writing-strings-to-a-csv-file
		
	    try (PrintWriter writer = new PrintWriter(new File(fileName))) {
 
		  String[] cardStrArr = new String[4];
		  StringBuilder sb = new StringBuilder();
		  while (!queue.isEmpty()) { 
			  cardStrArr = queue.poll().toStringArray();
		      sb.append(cardStrArr[0]);
		      sb.append(',');
		      sb.append(cardStrArr[1]);
		      sb.append(',');
		      sb.append(cardStrArr[2]);
		      sb.append(',');
		      sb.append(cardStrArr[3]);
		      sb.append('\n');
		  }
	      writer.write(sb.toString());
	      
	    } catch (FileNotFoundException e) {
	    	System.out.println("Please make sure the file is not open elsewhere");
	    	e.printStackTrace();
	    }

	  }
	

	/** chooseCSV allows the user to select a CSV file 
	 * 
	 * @return String of chosen file 
	 */
	public static String chooseCSV() {
		//https://www.mkyong.com/swing/java-swing-jfilechooser-example/
	
		JFileChooser jfc = new JFileChooser(FileSystemView.getFileSystemView().getHomeDirectory());
	
		int returnValue = jfc.showOpenDialog(null);
	
		if (returnValue == JFileChooser.APPROVE_OPTION) {
			File selectedFile = jfc.getSelectedFile();
			return selectedFile.getAbsolutePath();
		}
		throw new NullPointerException("Failed to Select File");
	}
}
