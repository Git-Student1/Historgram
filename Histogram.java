import java.io.BufferedWriter;
import java.io.File;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class Histogram {
	public static Map<Character, Integer> frequencyMap = new HashMap<>();

	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("src\\Test.txt");

		int c;
		while ((c = file.read()) != -1) {
			if (c == 92) {
				file.read();// int next= file.read();
				// if (next==110||next==114)//do nothing;
			} else if (c != ' ') {
				countFrequency(toUpperCase(c));
			}
		}
		generateFrequencyFile() ;
		generateHistogram();
	}

	private static void countFrequency(char c) {
		if (!frequencyMap.containsKey(c))
			frequencyMap.put(c, 1);// if character is not in map create a key for this character
		else {// else {int numberOfChar= frequencyMap.get(c);
				// frequencyMap.remove(c);frequencyMap.put(c,numberOfChar+1);}// if key is there
				// add one to the number of this character
			int numberOfCharacters = frequencyMap.get(c);
			frequencyMap.replace(c, numberOfCharacters + 1);
		}

	}

	private static void generateFrequencyFile() throws IOException {
		File FrequencyFile = new File("src//Frequency.txt");
		FileWriter fwriter = new FileWriter(FrequencyFile);
		BufferedWriter bwriter = new BufferedWriter(fwriter);
		
		for (Character key : frequencyMap.keySet()) {
			bwriter.write(key+": " + frequencyMap.get(key));
			bwriter.newLine();
		}
		bwriter.close();
		fwriter.close();
	}
	
	
	private static void generateHistogram() throws IOException {
		File HistogramFile = new File("src//Histogram.txt");
		FileWriter fwriter = new FileWriter(HistogramFile);
		// we need the method newLine of BufferedReader to not write anything in a
		// single line
		BufferedWriter bwriter = new BufferedWriter(fwriter);
		// saves how often the most common character in this file occurs
		int maxAmount = 1;
		// searches how often the most common character in this file occurs
		for (Character key : frequencyMap.keySet()) {
			int amount = frequencyMap.get(key);
			if (maxAmount < amount)
				maxAmount = amount;
		}

		// writes the stars of the histogram into the file
		for (Character key : frequencyMap.keySet()) {
			int maxStars=100;
			// the greatest amount of stars per char should 
			
			int numberOfStars = frequencyMap.get(key) * maxStars / maxAmount; 
			System.out.println(key+"  "+maxAmount+"  "+frequencyMap.get(key)+"  "+numberOfStars);
			bwriter.write(key + ": ");
			for (int index = 0; index < numberOfStars; index++)
				bwriter.write("*");
			bwriter.newLine();
		}
		bwriter.close();
		fwriter.close();
	}

	/**
	 * takes an int-value of a char, makes lower to upperCase and returns the number
	 * as a char
	 * 
	 */
	public static char toUpperCase(int number) {
		if (number >= 97 && number <= 122)
			number -= 32;
		return (char) (number);
	}

}
