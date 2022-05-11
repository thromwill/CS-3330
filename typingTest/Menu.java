//---------------------------------------------------------------------------------------------------------Class Menu

import java.util.*;

public class Menu {

//------------------------------------------------------------------------------------------------------------Fields
    
    private static String header = """
                                         _ _____     _                 _                   
                                      _ | |_   _|   (_)__ ___ ____ _  | |_ _  _ _ __  ___  
                                     | || | | |     | / _` \\ V / _` | |  _| || | '_ \\/ -_) 
                                      \\__/  |_|    _/ \\__,_|\\_/\\__,_|  \\__|\\_, | .__/\\___| 
                                                  |__/                     |__/|_|         """ + "\n" +
                                     "-----------------------------------------------------";

//----------------------------------------------------------------------------------------------------Public Methods

    
    //Prints header
    public static void header(){
        System.out.println(header);
    }
    
    //Takes integer input for menu selection
    //Calls testMenu or exits program
    //Recurs if non-integer input is entered
    public static void mainMenu() throws InterruptedException{
        
        //Clear the screen
        clear();
        System.out.flush();
        
        //Print header
        header();
        
        //Print menu
        System.out.println("""
                           Menu:
                           [1] Take typing test
                           [2] Exit
                           """);
        
        //Initialize Scanner
        Scanner s = new Scanner(System.in);
        
        try {
            
            //If input is an integer...
            validateMenuInput(s);
            int i = s.nextInt();
            
            //Check that input is either 1 or 2
            switch(i){
                //If 1 go to the test menu
                case 1:
                    testMenu();
                //If 2 exit
                case 2:
                    System.exit(0);
                    
                //If input is not 1 or 2
                //recur to let user enter new input
                default:
                    mainMenu();
            }
          
          //If input is not an integer
          //let user enter new input
        } catch(InvalidInputException i) {
            mainMenu();
        }
    }
    
    //Takes integer input for menu selection
    //Starts typing test corresponding to selection
    //Recurs if non-integer input is entered
    public static void testMenu() throws InterruptedException{
        
        //Clear the screen
        clear();
        
        //Print header
        header();
        
        //Print menu
        System.out.println("""
                           Select Test Type:
                           [1] Standard
                           [2] Crazy
                           [3] Single Letter
                           [4] Alphabet
                           [5] Story 1
                           [6] Story 2
                           [7] Quote 1
                           [8] Quote 2
                           [9] Custom
                           
                           [10] Back to menu
                           """);
        
        //Initialize scanner, testList, and length
        Scanner s = new Scanner(System.in);
        String testList = "";
        int length;
        
        
        try{
            
            //If input is an integer...
            validateMenuInput(s);
            int i = s.nextInt();
            
            //Check for correct input 1-10
            switch(i){
            case 1:
                //Get desired length
                length = Menu.lengthMenu();
                //Make testList with standard words of chosen length
                testList = makeTestList("standard", length);
                break;
            case 2:
                //Get desired length
                length = Menu.lengthMenu();
                //Make testList with crazy words of chosen length
                testList = makeTestList("crazy", length);
                break;
            case 3:
                //Make testList of a random single letter
                testList = makeTestList("singleletter");
                break;
            case 4:
                //Make testList of the complete alphabet
                testList = makeTestList("alphabet");
                break;
            case 5:
                //Make testList of Humpty Dumpty
                testList = makeTestList("story1");
                break;
            case 6:
                //Make testList of The Itsy Bitsy Spider
                testList = makeTestList("story2");
                break;
            case 7:
                //Make testList of to Lennon's quote
                testList = makeTestList("quote1");
                break;
            case 8:
                //Make testList of to Mandela's quote
                testList = makeTestList("quote2");
                break;
            case 9:
                //Create a custom test
                customMenu();
            case 10:
                //Go back to main menu
                mainMenu();
            
            //If input is not a valid integer
            //recur to let user enter input again
            default:
                testMenu();
            }
            
            //Perform the typing test using the selected testList
            TypingTest.test(testList);
            
            //Return to main menu
            returnToMain();
          
          //If input is not an integer
          //recur to let user enter new input
        } catch(InvalidInputException e) {
            testMenu();
        }
        
    }
        
//---------------------------------------------------------------------------------------------------Private Methods

    
    //Takes String input for test words
    //Creates words list from input string
    //Continues to inorderMenu
    private static void customMenu() throws InterruptedException{
        
        //Clear the screen
        clear();
        
        //Print menu
        header();
        
        //Print directions
        System.out.println("""
                           Create a unique typing test!
                           Enter words seperated by spaces, then enter!
                           """);
        
        //Initialize Scanner
        Scanner s = new Scanner(System.in);
        
        //Collect input
        String input = s.nextLine();
        
        //Create string array from input split at spaces
        String[] wordsList = input.split("\\s+");
        
        //Continue to inorderMenu
        inorderMenu(wordsList);
        
    }
    
    //Takes String array of test words
    //Takes integer input for menu selection
    //Performs typing test using either random or sequential based on selection
    //Recurs if non-integer input is entered
    private static void inorderMenu(String [] wordsList) throws InterruptedException{
        
        //Clear the screen
        clear();
        
        //Print header
        header();
        
        //Print menu
        System.out.println("""
                           Should your test be in:
                           [1] In order
                           [2] Random
                           """);
        
        //Initialize Scanner, testList
        Scanner s = new Scanner(System.in);
        String testList = "";
        
        try {
            
            //If input is an integer...
            validateMenuInput(s);
            int i = s.nextInt();
            
            //Check for correct input
            switch(i){
                case 1:
                    //Set testList to wordsList in sequential order
                    testList = makeTestList(wordsList);
                    break;
                case 2:
                    //Get desired length
                    int length = Menu.lengthMenu();
                    //Set testList to wordsList in random order of desired length
                    testList = makeTestList(wordsList, length);
                    break;
                    
                //If input is not 1 or 2
                //recur to let user enter input again
                default:
                    inorderMenu(wordsList);
            }
            
          //If input is not an integer
          //recur to let user enter input again
        } catch(InvalidInputException i) {
            inorderMenu(wordsList);
        }
        
        //Perform the typing test using the selected testList
        TypingTest.test(testList);
        
        //Return to main menu
        returnToMain();
    }

    //Takes integer input for menu selection
    //Returns integer selection upon success
    //Recurs if non-integer input is entered
    private static int lengthMenu() throws InterruptedException{
        
        //Clear the screen
        clear();
        
        //Print header
        header();
        
        //Print menu
        System.out.println("""
                           Enter test length:
                           [1] 1 words
                           [2] 10 words
                           [3] 25 words
                           [4] 50 words
                           """);
        
        //Initialize Scanner
        Scanner s = new Scanner(System.in);
        
        try {
            
            //If input is an integer...
            validateMenuInput(s);
            int i = s.nextInt();
            
            //Check for correct input 1-4
            //Return test length
            switch(i){
                case 1:
                    return 1;
                case 2:
                    return 10;
                case 3:
                    return 25;
                case 4:
                    return 50;
                    
                //If input is not a valid integer
                //recur to let user enter input again
                default:
                    lengthMenu();
            }

          //If the input is not an integer
          //recur to let user enter input again
        } catch(InvalidInputException i) {
            lengthMenu();
        }
        
        return -1;
    }
       
    //Takes string corresponding to test selection
    //Creates and returns proper testList based on selection
    private static String makeTestList(String type) throws InterruptedException{
        
        //Initialize testList
        String testList = "";
        
        //Iterate through possible selections
        switch(type){
            case "singleletter":
                //Set test list to a random single letter
                CrazyWordList words = new CrazyWordList(1);
                testList = words.testList(1);
                break;
            case "alphabet":
                //Set test list to the alphabet in order
                CrazyWordList words1 = new CrazyWordList(2);
                testList = words1.testList();
                break;

            case "story1":
                //Set test list to Humpty Dumpty
                CrazyWordList words2 = new CrazyWordList(3);
                testList = words2.testList();
                break;

            case "story2":
                //Set test list to The Itsy Bitsy Spider
                CrazyWordList words3 = new CrazyWordList(4);
                testList = words3.testList();
                break;

            case "quote1":
                //Set test list to Lennon's quote
                CrazyWordList words4 = new CrazyWordList(5);
                testList = words4.testList();
                break;

            case "quote2":
                //Set test list to Mandela's quote
                CrazyWordList words5 = new CrazyWordList(6);
                testList = words5.testList();
                break;
        }
        
        //Return the test
        return testList;
     }
    
    //Takes String corresponding to test selection and integer length value
    //Creates and returns proper testList based on selection
    private static String makeTestList(String type, int length) throws InterruptedException{
        
        //Initialize testList
        String testList = "";
        
        //Iterate through possible selections
        switch(type){
            case "standard":
                //Set testList of desired length using random standard words
                WordList words = new WordList();
                testList = words.testList(length);
                break;
            case "crazy":
                //Set testList of desired length using random crazy words
                CrazyWordList words1 = new CrazyWordList();
                testList = words1.testList(length);
                break;
        }
        
        //Return the test
        return testList;
    }
    
    //Takes String array of test words
    //Creates and returns proper testList based on selection
    private static String makeTestList(String [] wordsList) throws InterruptedException{
       
        //Set testList to input wordsList
        WordList words = new WordList(wordsList);
        String testList = words.testList();
 
        //Return the test
        return testList;
    }
    
    private static String makeTestList(String [] wordsList, int length) throws InterruptedException{
        Menu.header();
        
        WordList words = new WordList(wordsList);
        String testList = words.testList(length);
        
        return testList;
    }
    
    
    
    //Clears console screen
    private static void clear(){

        System.out.print("\033[H\033[2J");
        System.out.flush(); 
    }
    //Takes Scanner object
    //Throws custom exception if input is non-integer
    private static void validateMenuInput(Scanner s){
        
        if(!s.hasNextInt()){
            throw new InvalidInputException("Non-integer input.");
        }
    }
    
    //Waits for user to press enter and returns to main menu
    private static void returnToMain() throws InterruptedException{
        
        //Print directions
        System.out.println("\n[enter] Return to menu");
        
        //Scan enter keypress
        try{System.in.read();}
            catch(Exception e){}
        
        //Go to main menu
        Menu.mainMenu();
    }
    
//--------------------------------------------------------------------------------------------------------Class Menu

}

