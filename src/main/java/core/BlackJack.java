package core;

import java.util.Scanner;

public class BlackJack {
	

	public static void main(String[] args) {
		startGame();
	}
	
	public static void startGame() {
		Scanner input = new Scanner(System.in);
        
        System.out.println("Would you like to use console (c) or input file (f)?");
        String in = input.nextLine();
        
        if(in.equals("c")) {
        	Console.console();
        }
        else if(in.equals("f")) {
        	File.file();
        }
        else{
        	System.out.println("Invalid input \n");
        	startGame();
        }
	}
}
