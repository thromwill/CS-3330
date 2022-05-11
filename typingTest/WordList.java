//-----------------------------------------------------------------------------------------------------Class WordList

import java.util.Random;
import java.util.ArrayList;

public class WordList {

//-------------------------------------------------------------------------------------------------------------Fields
    
    private int length;
    private String [] words = { //200 most common english words
                                "the","be","of","and","a","to","in","he","have","it","that","for","they",
                                "I","with","as","not","on","she","at","by","this","we","you","do","but",
                                "from","or","which","one","would","all","will","there","say","who","make",
                                "when","can","more","if","no","man","out","other","so","what","time","up",
                                "go","about","than","into","could","state","only","new","year","some",
                                "take","come","these","know","see","use","get","like","then","first",
                                "any","work","now","may","such","give","over","think","most","even",
                                "find","day","also","after","way","many","must","look","before","great",
                                "back","through","long","where","much","should","well","people","down",
                                "own","just","because","good","each","those","feel","seem","how","high",
                                "too","place","little","world","very","still","nation","hand","old",
                                "life","tell","write","become","here","show","house","both","between",
                                "need","mean","call","develop","under","last","right","move","thing",
                                "general","school","never","same","another","begin","while","number",
                                "part","turn","real","leave","might","want","point","form","off","child",
                                "few","small","since","against","ask","late","home","interest","large",
                                "person","end","open","public","follow","during","present","without",
                                "again","hold","govern","around","possible","head","consider","word",
                                "program","problem","however","lead","system","set","order","eye","plan",
                                "run","keep","face","fact","group","play","stand","increase","early",
                                "course","change","help","line"
                               };
    
//-------------------------------------------------------------------------------------------------------Constructors

    public WordList(){
        
        //Default list is 200 words
        this.length = 200;
    }
   
    //Sets words based on String array
    public WordList(String [] wordsList){
        this.words = wordsList;
        this.length = wordsList.length;
    }
    
//----------------------------------------------------------------------------------------------------Getter Methods
    
    public String [] getWordList(){
        return this.words;
    }
    
    public int getLength(){
        return this.length;
    }
    
//----------------------------------------------------------------------------------------------------Setter Methods
    
    //Sets words based on String array
    public void setWordList(String [] wordsList){
        this.words = wordsList;
    }
    
    //Sets words based on String ArrayList
    public void setWordList(ArrayList<String> wordsList){
        
        //Initialize an array of same size as parameter ArrayList
        String[] _words = new String[wordsList.size()];
        
        //Fill array from ArrayList
        for (int i = 0; i < wordsList.size(); i++) {
            _words[i] = wordsList.get(i);
        }
        
        //Set words
        this.words = _words;
    }
    
    public void setLength(int l){
        this.length = l;
    }
    
//-----------------------------------------------------------------------------------------------------Functionality

    //Takes int length value corresponding to desired test length
    //Returns random list of length l of words from words in the form of a string
    public String testList(int l){
        
        Random r = new Random();
        
        //Initialize output string
        String testList = "";
        
        //l times...
        for(int i = 0; i < l; i++){
            
            try{
                
                //Add a random word from words to the output string
               testList += (this.words[r.nextInt(this.length)] + " ");
            }
               //If this.length is invalid, use the 1th index
            catch(IllegalArgumentException e){
               testList += (this.words[r.nextInt(1)] + " ");
            }
        }
        
        return testList;
    }
    
    //If no length value is passed
    //Returns full list of words in ascending order in the form of a string
    //Used for inorder tests like stories, quotes, and the alphabet
    public String testList(){
        
        //Initialize output string
        String testList = "";
        
        //Add each word in words to the output
        for(int i = 0; i < this.length; i++){
            testList += this.words[i] + " ";
        }
        
        //Return the string
        return testList;
    }
//----------------------------------------------------------------------------------------------------Helper Methods
    
    //Takes String array and String array length
    //Prints each String in the array
    public void printStringArray(String [] s, int l){
        
        for(int i = 0; i < l; i++){
            System.out.print(s[i]);
        }
        
        System.out.println();
    }
    
    


//-----------------------------------------------------------------------------------------------------Class WordList

}