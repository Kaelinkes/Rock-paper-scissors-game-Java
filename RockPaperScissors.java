import java.util.Scanner;
import java.util.Random;

public class RockPaperScissors {
    public static void main(String[] args) {
        String Play_again = "YES";
        Scanner input = new Scanner(System.in);
        String user_pick;

        do{
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
            System.out.print("Would you like to play again?(Yes or no): ");
            Play_again = input.next().toUpperCase();
            if (!Play_again.equals("YES")) {
                System.out.println("Exiting...");
            }
            input.nextLine();
        }while (Play_again.equals("YES"));

        input.close();
    }

    static String bot(){
        Random bot_pick = new Random();
        String[] options = {"ROCK","PAPER","SCISSORS"};

        return options[bot_pick.nextInt(3)];
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
    if (user_pick.equals(bot_pick)) {System.out.println("You tied! ");}
    else if(user_pick.equals("ROCK") && bot_pick.equals("SCISSORS")){ System.out.println("You win! ");}
    else if(user_pick.equals("SCISSORS") && bot_pick.equals("PAPER")){System.out.println("You win! ");}
    else if(user_pick.equals("PAPER") && bot_pick.equals("ROCK")){System.out.println("You win! ");}
    else{System.err.println( "You lose!");}
   }
}
    //else if(user_pick.equals("PAPER") && bot_pick.equals("SCISSORS")){System.out.println("You lose ");}
    //else if(user_pick.equals("ROCK") && bot_pick.equals("PAPER")){System.out.println("You lose ");}
    //else if(user_pick.equals("SCISSORS") && bot_pick.equals("ROCK")){System.out.println("You lose");}
