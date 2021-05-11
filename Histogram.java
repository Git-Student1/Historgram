import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.FilterOutputStream;
import java.io.IOException;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;


//import sun.jvm.hotspot.debugger.win32.coff.TestParser;


public class Histogram {
	public static Map<Character, Integer> frequencyMap = new HashMap<>();
	
	public static void main(String[] args) throws IOException {
		FileReader file = new FileReader("src\\Test.txt");
		
		
		int c;
		while((c=file.read())!=-1) {
			if(c==92) {
				file.read();//int next= file.read();
				//if (next==110||next==114)//do nothing;
			}
			else if (c!=' '){ countFrequency(toUpperCase(c));}
		}
		for(Entry<Character, Integer> entry:frequencyMap.entrySet()) System.out.println(entry);
	
	
	generateHistogram(frequencyMap,true);
	}
		

	private static void countFrequency(char c) {
		if (!frequencyMap.containsKey(c)) frequencyMap.put(c, 1);//if character is not in map create a key for this character
		else {//else {int numberOfChar= frequencyMap.get(c); frequencyMap.remove(c);frequencyMap.put(c,numberOfChar+1);}// if key is there add one to the number of this character
			int numberOfCharacters = frequencyMap.get(c); 
			frequencyMap.replace(c,numberOfCharacters+1);
			}
		
	}

	
	private static void generateHistogram(Map<Character, Integer> dict, boolean addSeperator) throws IOException {
		File HistogramFile = new File("src//Histogram.txt");
		FileWriter fwriter = new FileWriter(HistogramFile);
		//we need the method newLine of BufferedReader to not write anything in a single line
		BufferedWriter bwriter = new BufferedWriter(fwriter);
		//saves how often the most common character in this file occurs
		int maxAmount = 1;
		//searches how often the most common character in this file occurs
		for(Character key:frequencyMap.keySet()) {
			int amount= frequencyMap.get(key);
			if (maxAmount<amount) maxAmount= amount;
		}
		
		// writes the stars of the histogram into the file
		for(Character key:frequencyMap.keySet()){
			int numberOfStars=frequencyMap.get(key)*50/maxAmount; // the greatest amount of stars per char should be 15
			bwriter.write(key+": ");
			for (int index=0;index<numberOfStars;index++)bwriter.write("*");
			bwriter.newLine();
		}
		bwriter.close();
		fwriter.close();
	}
	
	

	
	public static char toUpperCase(int number) {
		if (number>=97&&number <=122) number-=32;
		return (char) (number);
	}
	
}
