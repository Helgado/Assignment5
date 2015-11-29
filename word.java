package pack;

public class Word{
    public int frequency;
    //the amount of times the word comes up in the file
    public String wordstring;
    //the word itself
    public Word(int frequency, String wordstring){
    	this.frequency = frequency;
    	this.wordstring = wordstring;
    }
}
