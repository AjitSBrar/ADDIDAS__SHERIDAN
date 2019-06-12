package cardgameweek4;
/**
 * Starter code for the Card class.
 * 
 * @author Addidas Sheridan 2019
 */
public class Card {
    
          private int value; //initialize the rank (2,3,4...King, Ace)
    private int suit; //initialize the suit (spades, hearts...)
    
    //constructor
    public Card(int s, int gVal){
        value = gVal;
        suit = s;
    }//end construcor
    
    //getter method
    public int getValue(){
        return value; 
    }//end getCard
    
    //setter method
    public void setValue(int gVal){
        value = gVal;
    }//end setValue
    
    @Override
    public String toString(){
    //combine rank and suit together into a single string(ex: Ace of Diamonds)

        //suing StringBuilder 
        StringBuilder display = new StringBuilder();
        
        //personal choice to use switch
        switch(value){
            //since rank is int type, now match int 11 to String jack...14 to Ace
            case 11:
                display.append("Jack");
                break;
            case 12:
                display.append("Queen");
                break;
            case 13:
                display.append("King");
                break;
            case 14:
                display.append("Ace");
                break;    
            default:
                display.append(value); // does not need to modify
                break;
        }//end rank switch
        
        display.append(" of "); // the format of the output
        
        switch(suit){
            case 0:
                display.append("Spades");
                break;
            case 1:
                display.append("Hearts");
                break;
            case 2:
                display.append("Clubs");
                break;
            case 3:
                display.append("Diamonds");
                break;
            default: 
                break;
        }//end suit switch
        
        // result of an entire cmombined string
        return display.toString();
    }//end toString
    
}//end Card Class 
