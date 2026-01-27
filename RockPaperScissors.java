import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        char Play_again = 'Y';
        Scanner input = new Scanner(System.in);
        String user_pick;

        while (Play_again == 'Y') {
            
            System.out.print("Enter your move(rock,paper or scissors): ");
            user_pick = input.nextLine();
            System.out.println(user_pick);
            
           if (!isValid(user_pick)) {
                System.err.println("Error, invalid pick!");
            }else{
              String bot = bot();
              System.out.println("You picked "+user_pick+"!"); 
              System.out.println("The bot picked "+bot.toLowerCase()+".");
              Outcome(user_pick,bot);
            }
            System.out.print("Would you like to play again?(Y/n): ");
            Play_again = input.next().toUpperCase().charAt(0);
            input.nextLine();
        }

        input.close();
    }

    static String bot(){
        Random bot_pick = new Random();

        int pick = bot_pick.nextInt(1,4);
        
        switch (pick) {
            case 1 : return "ROCK";
            case 2 : return "PAPER";
            case 3 : return "SCISSORS";
            default : return " ";
        }
    }

   static boolean isValid(String pick){
        pick = pick.toUpperCase();
        if (!pick.equals("ROCK") &&!pick.equals("PAPER") && !pick.equals("SCISSORS")) {
            return false;
        }else{
            return true;
        }
   }

   static void Outcome(String user_pick, String bot_pick){
    user_pick = user_pick.toUpperCase();
    if (user_pick.equals(bot_pick)) {System.out.println("You tied ");}
    else if(user_pick.equals("ROCK") && bot_pick.equals("SCISSORS")){ System.out.println("You win ");}
    else if(user_pick.equals("PAPER") && bot_pick.equals("SCISSORS")){System.out.println("You lose ");}
    else if(user_pick.equals("ROCK") && bot_pick.equals("PAPER")){System.out.println("You lose ");}
    else if(user_pick.equals("SCISSORS") && bot_pick.equals("PAPER")){System.out.println("You win ");}
    else if(user_pick.equals("PAPER") && bot_pick.equals("ROCK")){System.out.println("You win ");}
    else if(user_pick.equals("SCISSORS") && bot_pick.equals("ROCK")){System.out.println("You lose");}
    else{System.err.println( "Error in fetching results");}
   }
}
