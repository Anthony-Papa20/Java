import java.util.Scanner;

public class BlackJack {
	
	  public static void main(String[] args) {
		    
		    int hand;
		    int handSum;
		    int cpuHand;
		    int card1;
		    int card2;
		    int cpu1;
		    int cpu2;
		    int cpuHandSum;
		    String answer;
		    String cpuColor = "\u001B[31m";
		    String userColor = "\u001B[37m";
		    String baseColor = "\u001B[34m";

		    Scanner keybd = new Scanner(System.in);

		    System.out.println(baseColor + "\nWelcome to the new Blackjack program!");

		    card1 = (int)(Math.random()*10 + 1);
		    card2 = (int)(Math.random()*10 + 1);
		    handSum = card1 + card2;

		    cpu1 = (int)(Math.random()*10 + 1);
		    cpu2 = (int)(Math.random()*10 + 1);
		    cpuHandSum = cpu1 + cpu2;

		    System.out.println(userColor + "\nYour starting hand is a " + card1 + " and a " + card2 + ". Your total is " + handSum + ". Would you like to hit? y or n");
		    answer = keybd.nextLine();

		    if (answer.equalsIgnoreCase("y"))
		    {

		      do {

		       if (cpuHandSum < 17)
		       {
		         cpuHand = (int)(Math.random()*10 + 1);
		         cpuHandSum = cpuHand + cpuHandSum;
		         System.out.print(cpuColor + "\nThe CPU decided to hit this round!");
		       }
		       else
		       {
		         System.out.print(cpuColor + "\nThe CPU decided to hold");
		       }

		        hand = (int)(Math.random()*10 + 1);
		        handSum = hand + handSum;

		        answer = "n";
		     
		       if (handSum < 21)
		       {
		         System.out.println(userColor + "\nYour next card is a " + hand + ". hand totals up to " + handSum + ". Would you like to hit? y or n");

		          answer = keybd.nextLine();
		       }

		      } while (handSum < 21 && answer.equalsIgnoreCase("y"));
		    
		    }

		     keybd.close();

		      while (cpuHandSum < 17)
		      {
		       cpuHand = (int)(Math.random()*10 + 1);
		       cpuHandSum = cpuHand + cpuHandSum;
		       System.out.print(cpuColor + "\nThe CPU took another hit!\n");
		      }

		    if (handSum > 21)
		    {
		      System.out.println(baseColor + "\n\nYou went over 21, tough luck, you already lost.");
		    }
		    else if (cpuHandSum > 21)
		    {
		      System.out.println(baseColor + "\nCongratulations on that W! You had " + userColor + handSum + baseColor + " while the CPU got a little to risky and went up to " + cpuColor + cpuHandSum);
		    }
		    else if (handSum > cpuHandSum)
		    {
		     System.out.println(baseColor + "\nCongratulations on that W! You had " + userColor + handSum + baseColor + " while the CPU had " + cpuColor + cpuHandSum);
		    } 
		    else if (handSum == cpuHandSum)
		    {
		      System.out.println(baseColor + "\nLooks like you tied with the CPU at " + handSum + ". Better than losing I guess");
		    }
		    else 
		    {
		     System.out.println(baseColor + "\nLooks like this wasn't your game. You had " + userColor + handSum + baseColor + " while the CPU had " + cpuColor + cpuHandSum);
		    }

		    System.out.println(baseColor + "Thanks For Playing!");


		  }
}
