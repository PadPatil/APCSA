
public class Taunt {
   private int sum;
   private String currentPlayer;
   private String player2;
   private String[] taunts = { player2 + "says:  \"T'is a shame Earth provides enough to satisfy every man's needs, but not every man's greed.!\"",
                               player2 + "says: Everyone has a bad day, just not as bad as your's",
                               player2 + "says: This could make or break you, with more of a chance of breaking you. Think of your money",
                               player2 + "says: If only your optimism could get you to finally win something!!!"
                               player2 + "says: \"H-How could you be so LUCKY!!!\"" };
   
   
   public Taunt(int sum, String currentPlayer, String player2, int player2Wins) {
      this.sum = sum;
      this.currentPlayer = currentPlayer;
      this.player2 = player2; 
      this.losses = player2Wins;
   }
   
   public String tauntNow() {
      if (21 - sum >= 19) {
         return taunts[4];
      }
      
      else if(sum >= 21 + 3) {
         return taunts[0];
      }
      
      else if(loses >= 3) {
         return taunts[1];
      }           
      
      else if(sum >= 15) {
         return taunts[2];
      }
      
      else if(losses >= 3) {
         return taunts[3];
      }
      
      else {
         return "";
      }
   }
   
}