package pack;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class WordCount{
    public static void main(String[] args){
        String filename = getfile();
        int c = countfile(filename);
        Word[] unfiltered = readfile(filename, c);
        Word[] filtered = addwords(unfiltered);
        Word[] sorted = sortwords(filtered);
        printwords(sorted);
    }
    //This is the main method it is just like a table of contents for the program
    
    public static String getfile(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Filename: ");
        String filename = input.nextLine();
        input.close();
        return filename;
    }
    //This method just uses a scanner to take the filename, and then returns
    //it to the main method
    
	public static int countfile(String filename){
    	int counter = 0;
    	try{
    	File file = new File(filename);
    	Scanner input = new Scanner(file);
    	while (input.hasNext()) {
    		String lel = input.next();
    		counter++;
    	}
    	input.close();
    	}
    	catch (FileNotFoundException e) {
    	      System.out.println(e.getMessage());
    	    }
    	return counter;
    }
	//This method counts the number of words in the file and then
	//returns the number to the main method
    
    public static Word[] readfile(String filename, int c){
    	Word[] array = new Word[c];
    	try{
        	File file = new File(filename);
        	Scanner input = new Scanner(file);
        	while (input.hasNext()) {
        		for (int i = 0; i < c; i++){
        			String nopunct = input.next();
        			array[i] = new Word(0, nopunct.replaceAll("[\\W]", ""));
        		}
        	}
        	input.close();
        	}
    	catch (FileNotFoundException e) {
    	      System.out.println(e.getMessage());
    	    }
        	return array;
        }
    //This method uses the number of words in the file to make an
    //array of Word objects using the file.
     
    
    public static Word[] addwords(Word[] array){
    	for (int i = 1; i < array.length; i++){
            for (int j = 0; j < i; j++){
                if (array[i].wordstring.equalsIgnoreCase(array[j].wordstring)){
                    array[j].frequency++;
                    break;
                }
                
            }
        }
    	return array;
    }
    //This method takes the array of words and modifies the frequency
    //based on how many times it counts the word
    
    public static Word[] sortwords(Word[] array){
    	for (int i = 0; i < array.length; i++){
    		int minIndex = i;
    		int min = Integer.MAX_VALUE;
    		for (int j = i; j < array.length; j++){
    			if(array[j].frequency < min){
    				min = array[j].frequency;
    				minIndex = j;
    			}
    		}
    		array = swap(array, i, minIndex);
    	}
    	return array;
    }
    

    public static Word[] swap(Word[] array, int i, int minIndex){
    	Word tmp = array[i];
    	array[i] = array[minIndex];
    	array[minIndex] = tmp;
    	return array;
    }
    //These two methods sort the words so they're ordered by
    //frequency and then can be easily displayed in the correct order

    
    public static void printwords(Word[] array){
    	System.out.println("Most Frequent Words:");
    	System.out.println("Word          Frequency");
    	int top = (array.length - 1);
    	for (int i = 0; i < 5; i++){
    		System.out.println(array[top].wordstring + "          " + array[top].frequency);
    		top--;
    	}
    }
    //This method prints out the words and their frequency
  
}
