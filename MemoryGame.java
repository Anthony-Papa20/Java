//ALL Credits Belong To: Cameron Kranz & Anthony Papa

import java.util.ArrayList;
import java.util.Random;
import java.util.Scanner;

public class MemoryGame {
	
	static ArrayList<Integer> usedPositions = new ArrayList<Integer>();
	public static int matchCount = 0;
	public static char [] pos = {' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' ', ' '};
	public static boolean playing = true;
	public static String answer = "";
	public static int part1 = 0;
	public static int part2 = 0;
	public static int part3 = 0;
	public static int part4 = 0;
	public static int first = 0;
	static Scanner keybd = new Scanner(System.in);
	
	public static void main(String[] args) {
		
		while(playing == true){
			
		int fPick;
		
		setSymbols();
		char [][] memoryBoard = {{'+', '-', '-', '-', '-', '-', '-', '-', '+'}, 
				                 {'|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
				                 {'|', '-', '+', '-', '+', '-', '+', '-', '|'},
				                 {'|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
				                 {'|', '-', '+', '-', '+', '-', '+', '-', '|'},
				                 {'|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
				                 {'|', '-', '+', '-', '+', '-', '+', '-', '|'},
				                 {'|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
				                 {'|', '-', '+', '-', '+', '-', '+', '-', '|'},
				                 {'|', ' ', '|', ' ', '|', ' ', '|', ' ', '|'},
				                 {'+', '-', '-', '-', '-', '-', '-', '-', '+'}};
		
		System.out.println("Welcome to the Game of Memory!");
		
		while(matchCount < 20){
			printGameBoard(memoryBoard);
			reset();
			System.out.print("Pick Your First Position (1-20): ");
			fPick = keybd.nextInt();
			partOne(memoryBoard, fPick);
			printGameBoard(memoryBoard);
			System.out.print("Pick Your Second Place (1-20): ");
			fPick = keybd.nextInt();
			partTwo(memoryBoard, fPick);
		}
		printGameBoard(memoryBoard);
		System.out.print("Would You Like To Play Again (y or n): ");
		answer = keybd.nextLine();
		if(answer.equals("y")){
			playing = true;
		}else{
			playing = false;
		}
	  }
	 keybd.close();
	 System.out.println("Thanks For Playing!");
	}
	
	public static void printGameBoard(char [][] gameboard){
		for(char [] row: gameboard) {
			for(char c: row) {
				System.out.print(c);
			}
		  System.out.println();
		}
	}
	
	public static void setSymbols(){
		
		Random rand = new Random();
		char symbol;
		int symPos;
		int count = 0;
		
		while(count < 20){
			symbol = symbols(count);
			symPos = rand.nextInt(20) + 1;
			
				if(pos[symPos] == ' '){
					pos[symPos] = symbol;
				}else{
					while(pos[symPos] != ' '){
						symPos = rand.nextInt(20) + 1;
					}
				  pos[symPos] = symbol;
				}
		  count++;
		}
	}
	
public static void partOne(char [][] gameboard, int place){
		
		while(usedPositions.contains(place)){
			System.out.print("Something's Already There Silly! Try Again: ");
			place = keybd.nextInt();
			while (place > 20 || place < 1){
				System.out.print("Doesn't Exist! Try Again: ");
				place = keybd.nextInt();
			}
		}
		
		first = place;
		
		switch (place){
			case 1:
				gameboard[1][1] = pos[place];
				part1 = 1;
				part2 = 1;
				break;
			case 2:
				gameboard[1][3] = pos[place];
				part1 = 1;
				part2 = 3;
				break;
			case 3:
				gameboard[1][5] = pos[place];
				part1 = 1;
				part2 = 5;
				break;
			case 4:
				gameboard[1][7] = pos[place];
				part1 = 1;
				part2 = 7;
				break;
			case 5:
				gameboard[3][1] = pos[place];
				part1 = 3;
				part2 = 1;
				break;
			case 6:
				gameboard[3][3] = pos[place];
				part1 = 3;
				part2 = 3;
				break;
			case 7:
				gameboard[3][5] = pos[place];
				part1 = 3;
				part2 = 5;
				break;
			case 8:
				gameboard[3][7] = pos[place];
				part1 = 3;
				part2 = 7;
				break;
			case 9:
				gameboard[5][1] = pos[place];
				part1 = 5;
				part2 = 1;
				break;
			case 10:
				gameboard[5][3] = pos[place];
				part1 = 5;
				part2 = 3;
				break;
			case 11:
				gameboard[5][5] = pos[place];
				part1 = 5;
				part2 = 5;
				break;
			case 12:
				gameboard[5][7] = pos[place];
				part1 = 5;
				part2 = 7;
				break;
			case 13:
				gameboard[7][1] = pos[place];
				part1 = 7;
				part2 = 1;
				break;
			case 14:
				gameboard[7][3] = pos[place];
				part1 = 7;
				part2 = 3;
				break;
			case 15:
				gameboard[7][5] = pos[place];
				part1 = 7;
				part2 = 5;
				break;
			case 16:
				gameboard[7][7] = pos[place];
				part1 = 7;
				part2 = 7;
				break;
			case 17:
				gameboard[9][1] = pos[place];
				part1 = 9;
				part2 = 1;
				break;
			case 18:
				gameboard[9][3] = pos[place];
				part1 = 9;
				part2 = 3;
				break;
			case 19:
				gameboard[9][5] = pos[place];
				part1 = 9;
				part2 = 5;
				break;
			case 20:
				gameboard[9][7] = pos[place];
				part1 = 9;
				part2 = 7;
				break;
			default:
				break;
		}
		
	}

public static void partTwo(char [][] gameboard, int place){
	
	while(place == first || usedPositions.contains(place)){
		System.out.print("You already picked that position numnut! Try again: ");
		place = keybd.nextInt();
		while (place > 20 || place < 1){
			System.out.print("Doesn't Exist! Try Again: ");
			place = keybd.nextInt();
		}
	}
	
		switch (place){
			case 1:
				gameboard[1][1] = pos[place];
				part3 = 1;
				part4 = 1;
				break;
			case 2:
				gameboard[1][3] = pos[place];
				part3 = 1;
				part4 = 3;
				break;
			case 3:
				gameboard[1][5] = pos[place];
				part3 = 1;
				part4 = 5;
				break;
			case 4:
				gameboard[1][7] = pos[place];
				part3 = 1;
				part4 = 7;
				break;
			case 5:
				gameboard[3][1] = pos[place];
				part3 = 3;
				part4 = 1;
				break;
			case 6:
				gameboard[3][3] = pos[place];
				part3 = 3;
				part4 = 3;
				break;
			case 7:
				gameboard[3][5] = pos[place];
				part3 = 3;
				part4 = 5;
				break;
			case 8:
				gameboard[3][7] = pos[place];
				part3 = 3;
				part4 = 7;
				break;
			case 9:
				gameboard[5][1] = pos[place];
				part3 = 5;
				part4 = 1;
				break;
			case 10:
				gameboard[5][3] = pos[place];
				part3 = 5;
				part4 = 3;
				break;
			case 11:
				gameboard[5][5] = pos[place];
				part3 = 5;
				part4 = 5;
				break;
			case 12:
				gameboard[5][7] = pos[place];
				part3 = 5;
				part4 = 7;
				break;
			case 13:
				gameboard[7][1] = pos[place];
				part3 = 7;
				part4 = 1;
				break;
			case 14:
				gameboard[7][3] = pos[place];
				part3 = 7;
				part4 = 3;
				break;
			case 15:
				gameboard[7][5] = pos[place];
				part3 = 7;
				part4 = 5;
				break;
			case 16:
				gameboard[7][7] = pos[place];
				part3 = 7;
				part4 = 7;
				break;
			case 17:
				gameboard[9][1] = pos[place];
				part3 = 9;
				part4 = 1;
				break;
			case 18:
				gameboard[9][3] = pos[place];
				part3 = 9;
				part4 = 3;
				break;
			case 19:
				gameboard[9][5] = pos[place];
				part3 = 9;
				part4 = 5;
				break;
			case 20:
				gameboard[9][7] = pos[place];
				part3 = 9;
				part4 = 7;
				break;
			default:
				break;
	}
		
   if(pos[first] == pos[place]){
	   usedPositions.add(first);
	   usedPositions.add(place);
	   matchCount+= 2;
	   System.out.println("MATCH!");
   }else{
	   printGameBoard(gameboard);
	   System.out.print("NO MATCH! Hit Enter to Continue: ");
	   answer = keybd.nextLine();
	   answer = keybd.nextLine();
	   gameboard[part1][part2] = ' ';
	   gameboard[part3][part4] = ' ';
   }
}
	
	public static char symbols(int set){
		
		char symbol = 'e';
		
		switch(set){
			case 0:
				symbol = '/';
				break;
			case 1:
				symbol = '/';
				break;
			case 2:
				symbol = ']';
				break;
			case 3:
				symbol = ']';
				break;
			case 4:
				symbol = '}';
				break;
			case 5:
				symbol = '}';
				break;
			case 6:
				symbol = '=';
				break;
			case 7:
				symbol = '=';
				break;
			case 8:
				symbol = '!';
				break;
			case 9:
				symbol = '!';
				break;
			case 10:
				symbol = '@';
				break;
			case 11:
				symbol = '@';
				break;
			case 12:
				symbol = '$';
				break;
			case 13:
				symbol = '$';
				break;
			case 14:
				symbol = '%';
				break;
			case 15:
				symbol = '%';
				break;
			case 16:
				symbol = '&';
				break;
			case 17:
				symbol = '&';
				break;
			case 18:
				symbol = '#';
				break;
			case 19:
				symbol = '#';
				break;
			default:
				break;
		}
	  return symbol;
     }
	
	public static void reset(){
		part1 = 0;
		part2 = 0;
		part3 = 0;
		part4 = 0;
		first = 0;
	}
}    