import student.*;
import java.util.ArrayList;
import java.util.Random;
// -------------------------------------------------------------------------
/**
 *  Write a one-sentence summary of your class here.
 *  Follow it with additional details about its purpose, what abstraction
 *  it represents, and how to use it.
 * 
 *  @author  your-pid (and if in lab, partner's pid on same line)
 *  @version (place the date here, in this format: yyyy.mm.dd)
 */
public class WordPuzzle
{
    //~ Instance/static variables .............................................
      private String message; 
      private ArrayList<ArrayList<ArrayList<Integer>>> puzzle; 

    //~ Constructor ...........................................................
       
       
    // ----------------------------------------------------------
    /**
     * Creates a new WordPuzzle object.
     */
    public WordPuzzle()
    {
        //we don't need to do anything for an empty constructor.
    }

    public WordPuzzle(String message)
    {
       
        
        this.setFromMessage(message); 
        
    }
    
    public WordPuzzle(ArrayList<ArrayList<ArrayList<Integer>>> puzzle)
    {
       
         
         this.setFromPuzzle(puzzle); 
        
    }
    
    public WordPuzzle(String message, ArrayList<ArrayList<ArrayList<Integer>>> puzzle)
    {   
        this.message = message; 
        this.puzzle = puzzle ; 
        
    }

    public WordPuzzle(ArrayList<ArrayList<ArrayList<Integer>>> puzzle, String message)
    {  
        this.puzzle = puzzle; 
        this.message = message; 
        
        
    }  
    
    public String getMessage()
    {
        return this.message; 
    }

    public void setMessage(String message)
    {
          this.setFromMessage(message); 
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> getPuzzle()
    {
       return this.puzzle; 
    }

    public void setPuzzle(ArrayList<ArrayList<ArrayList<Integer>>> puzzle)
    {
        this.setFromPuzzle(puzzle) ; 
    }

    public void setFromMessage(String message)
    {
        this.message = message; 
        puzzle = this.puzzleFromMessage(message); 
        this.puzzle = puzzle; 
    }
    
    public void setFromPuzzle(ArrayList<ArrayList<ArrayList<Integer>>> puzzle)
    { 
        this.puzzle = puzzle; 
        message = this.messageFromPuzzle(puzzle); 
        this.message  = message; 
        
    }

    public static int ord(char chr)
    {
        return (int)chr;
    }
    
    public String messageFromPuzzle(ArrayList<ArrayList<ArrayList<Integer>>> puzzle)
     {
        //create an empty string to hold the letters of the message that you 
        //figure out
            
            String message = ""; 
            for(Integer i = 0 ; i <puzzle.size(); ++i) { 
               
                 ArrayList<ArrayList<Integer>> wordPuzzle = puzzle.get(i); 
                 String word = "";  
                 
                 
                 
                 
                 for(Integer p = 0; p < wordPuzzle.size(); ++p) {
                        
                        ArrayList<Integer>  pair = wordPuzzle.get(p);  
                        int letterNumber = pair.get(0) + pair.get(1); 
                        
                        char letter = (char) letterNumber; 
                        word= word + letter; 
                        
                }
           
                
                message =   message + " "  + word ; 
               
            }   
              String finalMessage = message.trim(); 
        return  finalMessage; 
        
        
    }

    public ArrayList<ArrayList<ArrayList<Integer>>> puzzleFromMessage(String message)
     {
        
        /*# Do any work to initialize your class here. *///this create a random number generator, if you do 
        //r.nextInt(someNumber)
        //then it will give you an integers from 0-someNumber
        Random r = new Random();

        // this will be an array of Strings with each element being one of the
        //words from your message
        String[] words = message.split(" "); 
       
         
        
        ArrayList<ArrayList<ArrayList<Integer>>> puzzle  =  new  ArrayList<ArrayList<ArrayList<Integer>>>();
        //create a new ArrayList<ArrayList<ArrayList<Integer>>> to hold your final result
        
        //create a ArrayList<ArrayList<Integer>> to hold the pairs that belong to the current word in the message
        
        //loop over all the words in words 
          for (Integer i =0;i <  words.length; ++i) {  
              String word; 
              word = words[i]; 
              ArrayList<ArrayList<Integer>> wordPairs = new ArrayList<ArrayList<Integer>>();
              
              for(Integer l = 0; l <word.length(); ++l) { 
                 
                 ArrayList<Integer> letterNumber = new  ArrayList<Integer>(); 
                 
                 Integer number = (int)word.charAt(l); 
                 Integer firstNumber = r.nextInt(number); 
                 Integer secondNumber = number -firstNumber; 
                 letterNumber.add(firstNumber) ; 
                 letterNumber.add(secondNumber) ; 
                 wordPairs.add(letterNumber); 
                 
                 
               }
               puzzle.add(wordPairs); 
              
               
          
    }
      
      
      return puzzle; 

    //~ Methods ...............................................................

}

    public static char chr(int chrVal)
    {
        char r = (char) chrVal;
        return r;
    }
    
    public String toString()
    {
        String prettyPrint = "";
        String topLine;
        String bottomLine;
        String underLine;
        for (ArrayList<ArrayList<Integer>> wordArray : this.puzzle)
        {
            topLine = "";
            bottomLine = "";
            underLine = "";
            for (ArrayList<Integer> pair : wordArray)
            {
                topLine += padLeft(pair.get(0).toString(), 4) + "  ";
                bottomLine += "+" + padLeft(pair.get(1).toString(), 3) + "  ";
                underLine += "----  ";
            }
            prettyPrint += topLine + "\n" + bottomLine + "\n" + underLine + "\n\n\n";
        }
        return prettyPrint;
    }
    
    public static String padLeft(String s, int n) 
    {
        return String.format("%1$#" + n + "s", s);   
    }

 
    public static void main(String[] args)
    {
        ArrayList<ArrayList<ArrayList<Integer>>> puzzle = new ArrayList<ArrayList<ArrayList<Integer>>>();
        ArrayList<ArrayList<Integer>>word = new ArrayList<ArrayList<Integer>>();
        ArrayList<Integer>pair = new ArrayList<Integer>();
        pair.add(61);
        pair.add(11);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(93);
        pair.add(4);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(73);
        pair.add(39);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(78);
        pair.add(34);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(17);
        pair.add(104);
        word.add(pair);
        puzzle.add(word);
        word = new ArrayList<ArrayList<Integer>>();
        pair = new ArrayList<Integer>();
        pair.add(23);
        pair.add(43);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(11);
        pair.add(93);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(65);
        pair.add(52);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(20);
        pair.add(96);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(66);
        pair.add(31);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(86);
        pair.add(24);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(40);
        pair.add(61);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(102);
        pair.add(13);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(50);
        pair.add(51);
        word.add(pair);
        puzzle.add(word);
        word = new ArrayList<ArrayList<Integer>>();
        pair = new ArrayList<Integer>();
        pair.add(73);
        pair.add(43);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(28);
        pair.add(73);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(8);
        pair.add(89);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(31);
        pair.add(68);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(77);
        pair.add(27);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(24);
        pair.add(77);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(42);
        pair.add(72);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(15);
        pair.add(24);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(64);
        pair.add(51);
        word.add(pair);
        puzzle.add(word);
        word = new ArrayList<ArrayList<Integer>>();
        pair = new ArrayList<Integer>();
        pair.add(25);
        pair.add(75);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(7);
        pair.add(90);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(10);
        pair.add(111);
        word.add(pair);
        pair = new ArrayList<Integer>();
        pair.add(17);
        pair.add(16);
        word.add(pair);
        puzzle.add(word);
        WordPuzzle wp = new WordPuzzle();
        
        WordPuzzle wp2 = new WordPuzzle(puzzle);
        System.out.println(wp2); 
        System.out.println(wp.messageFromPuzzle(puzzle));

    }
} 
