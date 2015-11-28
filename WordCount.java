package Question1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class WordCount{
    public static void main(String[] args){
        String filename = getfile();
        int c = countfile(filename);
        System.out.println(c);
        Word[] unfiltered = readfile(filename, c);
        filterwords(unfiltered);
        printwords();
    }
    
    public static String getfile(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Filename: ");
        String filename = input.nextLine();
        input.close();
        return filename;
    }
    
    @SuppressWarnings("finally")
	public static int countfile(String filename){
    	int counter = 0;
    	try{
    	File file = new File(filename);
    	Scanner input = new Scanner(file);
    	while (input.hasNext()) {
    		String lel = input.next();
    		counter++;
    	}
    	} finally{
    	return counter;
    	}
    }
    
    public static Word[] readfile(String filename, int c){
    	Word[] array = new Word[c];
    	try{
        	File file = new File(filename);
        	Scanner input = new Scanner(file);
        	while (input.hasNext()) {
        		for (int i = 0; i < c; i++){
        			array[i].wordstring = input.next();
        		}
        	}
        	} finally{
        	return array;
        	}
        }
     
    
    public static void filterwords(Word[] array){
    	for (int i = 0; i < array.length; i++){
            for (int j = i; j > 0; j--){
                if (array[i] == array[j-1]){
                    array[j-1].frequency++
                    break;
            }
        }
    }
    
    public static void printwords(){
    }
  
}
