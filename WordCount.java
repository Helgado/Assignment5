package Question1;

import java.io.File;
import java.io.FileNotFoundException;
import java.util.Scanner;
public class WordCount{
    public static void main(String[] args){
        String filename = getfile();
        readfile(filename);
        addwords();
        sortandprint();
    }
    
    public static String getfile(){
        Scanner input = new Scanner(System.in);
        System.out.print("Enter Filename: ");
        String filename = input.nextLine();
        return filename;
    }
    
    public static void readfile(String filename){
        try{
            File file = new File(filename);
            Scanner input = new Scanner(file);
            while (input.hasNext()) {
                System.out.printf("%s ", input.next());
            }
        }
        catch (FileNotFoundException e){
            System.out.println(e.getMessage());
        }
    }
    
    public static void addwords(){
    }
    
    public static void sortandprint(){
    }
    
}
