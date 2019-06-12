package cardgameweek4;
/**
 * GamePlayer class.
 * 
 * @author Addidas Sheridan 2019
 */

import java.util.ArrayList;       
import java.util.Random;        
import java.util.List;          
import java.util.Collections;   
import java.util.LinkedList;    

public class GamePlayer {
    public static void main(String[] args) {
        
        List<Card> deck = new ArrayList<Card>(); //create an ArrayList "deck"
        
        for(int x=0; x<4; x++){          //0-3 for suit (4 suits)
            for(int y=2; y<15; y++){     //2-14 for rank (13 ranks)
                deck.add(new Card(x,y)); //create new card  deck
            } //end value for
        }//end suit for
        
        Collections.shuffle(deck, new Random()); //shuffle the deck 
        
        //creating 2 decks, each for player1/player2
        LinkedList<Card> deckCPU = new LinkedList<Card>();
        LinkedList<Card> deckP1 = new LinkedList<Card>();
        
        deckCPU.addAll(deck.subList(0, 25));              //26 cards        
        deckP1.addAll(deck.subList(26, deck.size()));//26 cards
        
        while(true){
            Card p1Card = deckCPU.pop();  //each player place one card face up
            Card p2Card = deckP1.pop();
            
            //display the face up card
            System.out.println("Player 1 plays card is " + p1Card.toString());
            System.out.println("Player 2 plays card is " + p2Card.toString());
            
            //rank comparation between two cards
            if(p1Card.getValue() > p2Card.getValue()){//if player 1 win 
                deckCPU.addLast(p1Card);  //higher value wins both cards and 
                deckCPU.addLast(p2Card);  //places them at the bottom of his deck.
                System.out.println("PLayer 1 wins the round");
            }//end if
 
            else if(p1Card.getValue() < p2Card.getValue()){//if player 2 win 
                deckP1.addLast(p1Card);   
                deckP1.addLast(p2Card);  
                System.out.println("PLayer 2 wins the round");
            }//end else if
            
            else { //war happens when both cards' value matched
                System.out.println("War"); 
                
                //creating war cards
                List<Card> war1 = new ArrayList<Card>(); 
                List<Card> war2 = new ArrayList<Card>();
                
                //checking do players have enough (4)cards 
                for(int x=0; x<3; x++){ 
                    //either one player runs out of card is game over
                    if(deckCPU.size() == 0 || deckP1.size() == 0 ){                      
                        break;
                    }//end if
                    
                    System.out.println("War card for player1 is xx\nWar card for player2 is xx");

                    war1.add(deckCPU.pop());  //place additional card for war
                    war2.add(deckP1.pop());                  
                }//end for
                
                //only compare result when both players have enough cards for war
                if(war1.size() == 3 && war2.size() == 3 ){
                    //display the war cards from each player
                    System.out.println("War card for player1 is " + war1.get(0).toString());
                    System.out.println("War card for player2 is " + war2.get(0).toString());
                    
                    //if player 1 wins the war round
                    if(war1.get(2).getValue() > war2.get(2).getValue()){
                        deckCPU.addAll(war1); //player1 get all 10 cards
                        deckCPU.addAll(war2);
                        System.out.println("Player 1 wins the war round");
                    }//end if
                    //otherwise player 2 wins the war round
                    else{
                        deckP1.addAll(war1); //player2 get all 10 cards
                        deckP1.addAll(war2);
                        System.out.println("Player 2 wins the war round");
                    }//end else                      
                }//end if
                
            }//end war round else
            
            //game over either one player runs out of card(deck size is 0)
            if(deckCPU.size() == 0 ){
                System.out.println("game over\nPlayer 1 wins the game");
                break;
            }
            else if(deckP1.size() == 0){
                System.out.println("game over\nPlayer 2 wins the game");
                break;
            }
           
        }//end while  

    }//end main       
}//end class
