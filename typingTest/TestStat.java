//-----------------------------------------------------------------------------------------------------Class TestStat

public class TestStat implements TypingStats{
    
//------------------------------------------------------------------------------------------------------------Fields

    private final String test; //String user must match
    private final String input; //String user typed
    private final double start; //Double start time in nanoseconds
    private final double stop; //Double stop time in nanoseconds
    private final int testChars; //Int number of characters in test
    
    private final double time; //Double time typing in seconds
    private final double accuracy; //Double correct characters typed / total test characters
    private final int rawwpm; //Unadjusted words per minute: characters typed / 5 / one minute
    private final int wpm; //Adjusted words per minute: rawwpm * accuracy
    
//-------------------------------------------------------------------------------------------------------Constructors


    //Constructor takes test string, input string, start time, and stop time
    //Calculates time typed, accuracy, rawwpm, and wpm
    public TestStat(String test, String input, double startTime, double stopTime){
        
        this.test = test;
        this.testChars = test.replace(" ", "").length();
        this.input = input;
        this.start = startTime;
        this.stop = stopTime;
        
        this.time = time(startTime, stopTime);
        this.accuracy = accuracy(test, input);
        this.rawwpm = rawwpm(testChars, this.time);
        this.wpm = wpm(this.rawwpm, this.accuracy);
        
    }
    
//----------------------------------------------------------------------------------------------------Getter Methods

    public double getTime(){
        return this.time;
    }
    
    public double getAccuracy(){
        return this.accuracy;
    }
    
    public int getwpm(){
        return this.wpm;
    }
    
    public int getRawwpm(){
        return this.rawwpm;
    }
                                                                                              
//-----------------------------------------------------------------------------------------------Calculation Methods


    //Takes start time and stop time in nanoseconds
    //Returns elapsed time in seconds
    public double time(double start, double stop){
        
        //Time in nanoseconds
        double rawTime = stop-start;
        
        //Convert to seconds
        double _time = rawTime / 1000000000.0;
        return _time;
    }
    
    //Takes test string and input string
    //Counts number of correct characters in input string
    //  - Correct characters are identical characters at indentical indices
    //Returns accuracy value as a percent
    public double accuracy(String test, String input){
        
      //Number of chars not including spaces
      int total = this.test.replace(" ", "").length(); 
      
      int correct = matchingChars(this.test, this.input);
        
      double _accuracy= ((double) correct / total ) *100;
              
      return _accuracy;
    }
    
    
    //Takes number of characters and elapsed time in seconds
    //Calculates rawwpm as characters / 5 / one minute
    //Adds 5% to wpm for user retention :)
    //Returns integer rawwpm
    public int rawwpm(int chars, double time){
      
      int _rawwpm = (int)((((double) chars / 5) / time) * 60 *1.05);
      
      return _rawwpm;
    }
    
    //Takes int rawwpm and double accuracy as a percentage
    //Calculates wpm as rawwpm * accuracy
    //Returns integer wpm
    public int wpm(int rawwpm, double accuracy){
      
      int _wpm = (int)(rawwpm * accuracy / 100);
      return _wpm;
      
    }                       
                                                                                         
//----------------------------------------------------------------------------------------------------Helper Methods

    //Takes two strings to compare
    //Returns number of characters of identical value at indentical indices
    private int matchingChars(String a, String b){
        
        //Remove spaces
        a = a.replace(" ", "");
        b = b.replace(" ", "");
        
        //Initialize count
        int count = 0;
        
        //Get string lengths
        int a_length= a.length();
        int b_length = b.length();
        
        //Index
        int i = 0;
        
        //Iterate through the shorter string
        if(a_length >= b_length){
            
            //For each index
            while(i < b_length){
                
                //If characters in both strings are identical
                if(a.charAt(i) == b.charAt(i)){
                    
                    //Increase the count
                    count++;
                }
                
                //Move on to next index
                i++;
            }
            
        } else {
            while(i < a_length){
                if(a.charAt(i) == b.charAt(i)){
                    count++;
                }
                i++;
            }
        }
        
        //Return number of matching characters
        return count;
    }
                                                                                                    
//----------------------------------------------------------------------------------------------------Class TestStat

}