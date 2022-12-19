
import java.util.Scanner;


public class PlayGame {
      
   private Scanner scan;
   private String name1;
   private String name2;
   
   public PlayGame (Scanner scan, String name1, String name2) {
      this.scan = scan;
      this.name1 = name1;
      this.name2 = name2;
   }
   
   public void play() {
      String answer = "y";
         while (answer.equals("y")) { 
         Deck playingDeck = new Deck();
         playingDeck.createFullDeck();
         playingDeck.shuffle();
      
         //player1Cards will be the cards the player has in their hand
         Deck player1Cards = new Deck();
         
         //player1Money holds players cash - we will be lazy and use doubles instead of bigdecimals
         double player1Money = 100.0;
         double player2Money = 100.0;
         double player1Win = 0.0;
         double player2Win = 0.0;
         
         //playingDeck will be the cards the dealer has in their hand
         Deck player2Cards = new Deck();
      
         player1Cards.moveAllToDeck(playingDeck);
         player2Cards.moveAllToDeck(playingDeck); 
      
         //Play the game while the player has money
         //Game loop
         while((player1Money > 0) && (player2Money > 0)){
            //Take Bet
            System.out.println(name1 + ", you have $" + player1Money + ", how much would you like to bet?");
            double player1Bet = scan.nextDouble();
            System.out.println(name2 + ", you have $" + player1Money + ", how much would you like to bet?");
            double player2Bet = scan.nextDouble();
            
            if(player1Bet > player1Money){
            //Break if they bet too much
               System.out.println("You cannot bet more than you have.");
               break;
            }
           //Player gets two cards
            player1Cards.draw(playingDeck);
            player1Cards.draw(playingDeck);
         
           //Dealer gets two cards
            player2Cards.draw(playingDeck);
            player2Cards.draw(playingDeck);
            System.out.println("\n");
            System.out.println(name1 + " shows: " + player1Cards.getCard(0).toString());
            System.out.println(name2 + " shows: " + player2Cards.getCard(0).toString() + "\n");
            System.out.println(name2 + ", it is your turn."); 
            System.out.println(name2 + ", your hand:" + player2Cards.toString());
          
          //Display Value
            System.out.println("Your hand is currently valued at: " + player2Cards.cardsValue());
            
            //Display dealer cards
            //What do they want to do
               System.out.println("Would you like to (h)it or (s)tand");
               String response1 = scan.next(); 
            //They hit
               if(response1.equals("h")) {
                  player2Cards.draw(playingDeck);
                  System.out.println("You draw a " + player2Cards.getCard(player2Cards.deckSize()-1).toString());
                  System.out.println(name2 + ", you have: " + player2Cards.toString());
                  System.out.println("Your hand is currently valued at: " + player2Cards.cardsValue());
                  
                  //Bust if they go over 21
                  if(player2Cards.cardsValue() > 21){
                     System.out.println("Bust. Currently valued at: " + player2Cards.cardsValue());                                    
                     System.out.println("==============");
                     break;
                  }
               }
            
            //Stand
               if(response1.equals("s")){
                  System.out.println("==============");
                  break;
               }
            }
          
            //Display player cards
            System.out.println(name1 + ", it is your turn.");
            System.out.println(name1 + ", your hand:" + player1Cards.toString());
          
          //Display Value
            System.out.println("Your hand is currently valued at: " + player1Cards.cardsValue());
         
            while(true) {
               System.out.println("Would you like to (h)it or (s)tand");
               String response2 = scan.next(); 
               
               //They hit
               if(response2.equals("h")){
                  player1Cards.draw(playingDeck);
                  System.out.println("You draw a:" + player1Cards.getCard(player1Cards.deckSize()-1).toString());
                  System.out.println(name1 + ", you have: " + player1Cards.toString());
                  System.out.println("Your hand is currently valued at: " + player1Cards.cardsValue());
               
                  //Bust if they go over 21
                  if(player1Cards.cardsValue() > 21){
                     System.out.println("Bust. Currently valued at: " + player1Cards.cardsValue());
                     System.out.println("==============");
                     break;
                  }
               }
            
               //Stand
               if(response2.equals("s")){
                  System.out.println("==============");
                  break;
               }            
            }
          
            //Reveal Dealer Cards
            //See if dealer has more points than player
            if ((player2Cards.cardsValue() <= 21) && (player1Cards.cardsValue() <= 21)) {
            
               if ((player2Cards.cardsValue() == player1Cards.cardsValue())) {
                  System.out.println("It's a push!");
                  player1Win += 0.5;
                  player2Win += 0.5;
                  System.out.println(name1 + " has " + player1Win + " wins.");
                  System.out.println(name2 + " has " + player2Win + " wins.");
                  System.out.println(name1 + " has $" + player1Money);
                  System.out.println(name2 + " has $" + player2Money);
               }
               
               else if((player2Cards.cardsValue() > player1Cards.cardsValue())){
                  System.out.println(name2 + " wins!");
                  player1Money -= player1Bet;
                  player2Money += player2Bet;
                  player2Win += 1.0;
                  System.out.println(name1 + " has " + player1Win + " wins.");
                  System.out.println(name2 + " has " + player2Win + " wins.");
                  System.out.println(name1 + " has $" + player1Money);
                  System.out.println(name2 + " has $" + payer2Money);
      
               }
               
               else if ((player1Cards.cardsValue() > player2Cards.cardsValue())&&endRound) {
                  System.out.println(name1 + " wins!");
                  player1Money += player1Bet;
                  player2Money -= player2Bet;
                  player1Win += 1.0;
                  System.out.println(name1 + " has " + player1Win + " wins.");
                  System.out.println(name2 + " has " + player2Win + " wins.");
                  System.out.println(name1 + " has $" + player1Money);
                  System.out.println(name2 + " has $" + player2Money);
               }
            }
            
            
            //Dealer hits at 16 stands at 17
            //Determine if dealer busted
            else 
               if ((player2Cards.cardsValue() > 21) && (player1Cards.cardsValue() > 21)){
                  System.out.println("Both " + name1 + " and " + name2 + " bust. It's a push!");
                  player1Money -= player1Bet;
                  player2Money -= player2Bet;
                  
                  System.out.println(name1 + " has " + player1Win + " wins.");
                  System.out.println(name2 + " has " + player2Win + " wins.");
                  System.out.println(name1 + " has $" + player1Money);
                  System.out.println(name2 + " has $" + player2Money);
               }
            
            
               else if ((player2Cards.cardsValue() > 21) || (player1Cards.cardsValue() > 21)) {
                  if((player2Cards.cardsValue()>21)){
                     System.out.println(name2 + " busts. " + name1 + " wins!");
                     player1Money += player1Bet;
                     player2Money -= player2Bet;
                     player1Win += 1.0;
                     System.out.println(name1 + " has " + player1Win + " wins.");
                     System.out.println(name2 + " has " + player2Win + " wins.");
                     System.out.println(name1 + " has $" + player1Money);
                     System.out.println(name2 + " has $" + player2Money);
                  }
               
                  //Determine if push
                  else if((player1Cards.cardsValue() > 21)){
                     System.out.println(name1 + " busts. " + name2 + " wins!");
                     player2Money += player2Bet;
                     player1Money -= player1Bet;
                     player2Win += 1.0;
                     System.out.println(name1 + " has " + player1Win + " wins.");
                     System.out.println(name2 + " has " + player2Win + " wins.");
                     System.out.println(name1 + " has $" + player1Money);
                     System.out.println(name2 + " has $" + player2Money);
                  }
               }
            //End of hand - put cards back in deck
               player1Cards.moveAllToDeck(playingDeck);
               player2Cards.moveAllToDeck(playingDeck);
               System.out.println("Play again? (y/n)");
               answer = scan.next();
               System.out.println("End of Hand.");
               break; 
            }
   }
}