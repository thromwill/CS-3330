//------------------------------------------------------------------------------------------------Class CrazyWordList

import java.util.ArrayList;

public class CrazyWordList extends WordList {

//-------------------------------------------------------------------------------------------------------------Fields

/**
 *  String/int fields
 *      - Strings contain "crazy" lists of words that can be used for typing tests
 *      - ints contain the lengths of the respective lists
 */
    
    //Default crazy list
    private String [] crazy = {
                                        "Bumfuzzle","Fartlek","Everywhen","Erf",
                                        "Hullaballoo","Meldrop","Obelus","Sozzled",
                                        "Bumbershoot","Titter","Smicker","Cleek",
                                        "Whippersnapper","Salopettes","Bibliokept",
                                        "Accubation","Lollygag","Abecedarian",
                                        "Bamboozled","Cutesy-poo","Flabbergast",
                                        "Foppish","Cattywampus","Noob","Octothorpe",
                                        "Schmooze","Finifugal","Smaze","Skirl",
                                        "Adorbs","Waesucks","Widdershins","Blubber",
                                        "Dollop","Festooned","Fuddy-duddy",
                                        "Gobbledygook","Popple","Hodgepodge",
                                        "Ramshackle","Wishy-washy","Flummoxed",
                                        "Gardyloo","Collywobbles","Billingsgate",
                                        "Lickety-split","Slumgullion","Ill-willie",
                                        "Conjubilant ","Futz","Bunghole",
  
                                };
    
    private int crazy_length = 51;
    
    //Story 1
    private String [] humpty = {
                                        "Humpty","Dumpty","sat","on","a","wall.",
                                        "Humpty","Dumpty","had","a","great","fall.",
                                        "All","the","King's","horses","And","all",
                                        "the","King's","men","Cannot","put","Humpty",
                                        "together","again."
                                };
    
    private int humpty_length = 26;
    
    //Story 2
    private String [] spider = {
                                        "The ","itsy ","bitsy ","spider ","crawled ",
                                        "up","the ","water ","spout.","Down ",
                                        "came ","the ","rain, ","and ","washed ",
                                        "the ","spider ","out.","Out ","came ",
                                        "the ","sun, ","and ","dried ","up ","all ",
                                        "the ","rain,","and ","the ","itsy ","bitsy ",
                                        "spider ","went ","up ","the ","spout ",
                                        "again."
                                };
    
    private int spider_length = 38;
    
    //Quote 1
    private String [] lennon = {
                                        "Life","is","what","happens","when",
                                        "you're","busy","making","other","plans.",
                                        
                                };
    
    private int lennon_length = 10;
    
    //Quote 2
    private String [] mandela = {
                                        "The","greatest ","glory ","in ","living ",
                                        "lies ","not ","in ","never ","falling, ",
                                        "but ","in ","rising ","every ","time ",
                                        "we ","fall."  
                                };
    
    private int mandela_length = 17;
    
    //Alphabet
    private String [] alphabet = {
                                        "a","b","c","d","e","f","g","h","i","j",
                                        "k","l","m","n","o","p","q","r","s","t",
                                        "u","v","w","x","y","z"
                            };
    
    private int alphabet_length = 26;
    
//-------------------------------------------------------------------------------------------------------Constructors
    
    //Default constructor
    public CrazyWordList(){
        super();
        setWordList(this.crazy);
        setLength(this.crazy_length);
    }
    
    //Custom constructor
    //Fills words with any number of strings passed
    public CrazyWordList(String...wordsList){
        super();
        
        ArrayList<String> list = new ArrayList<>();
        
        for(String s: wordsList){
            list.add(s);
        }

        setLength(list.size());
        setWordList(list);

    }
    
    //Selection constructor
    //Takes integer corresponding to a crazy list of words
    //Sets words and length corresponding to selection
    public CrazyWordList(int selector){
        super();
        
        switch(selector){
            case 1:
            case 2:
                setWordList(this.alphabet);
                setLength(this.alphabet_length);
                break;
            case 3:
                setWordList(this.humpty);
                setLength(this.humpty_length);
                break;
            case 4:
                setWordList(this.spider);
                setLength(this.spider_length);
                break;
            case 5:
                setWordList(this.lennon);
                setLength(this.lennon_length);
                break;
            case 6:
                setWordList(this.mandela);
                setLength(this.mandela_length);
                break;
            
            default:
                setWordList(this.crazy);
                setLength(this.crazy_length);
                
        }
    }
    

//------------------------------------------------------------------------------------------------Class CrazyWordList

}
