package core;

import java.util.Scanner;

public class Console {

	public static void console() {
		Deck deck = new Deck();
		Player player = new Player(deck);
		Player dealer = new Player(deck);
		
		System.out.println("Dealers Hand: " + dealer.hand.get(0).getSuit() + dealer.hand.get(0).getNumber() + "\n");
		
		
		playerTurnConsole(player);
		if((player.busted && player.hand2.isEmpty()) || (player.busted && player.busted2)) {
			System.out.print("Dealer wins with: ");
			for(Card card: dealer.hand) {
				System.out.print(card.getSuit() + card.getNumber() + " ");
			}
			System.out.println("\nDealer Total: " + dealer.handTotal + "\n");
		}
		else {
			dealerTurnConsole(dealer);
			
			if((dealer.busted && dealer.hand2.isEmpty()) || (dealer.busted && player.busted2)) {
				System.out.print("Player wins with: ");
				for(Card card: player.hand) {
					System.out.print(card.getSuit() + card.getNumber() + " ");
				}
				System.out.println("\nPlayer Total: " + player.handTotal + "\n");
			}
			else {
				int dealerTotal = 0;
				if(dealer.handTotal >= dealer.handTotal2) {
					dealerTotal = dealer.handTotal;
				}
				else {
					dealerTotal = dealer.handTotal2;
				}
				
				int playerTotal = 0;
				if(player.handTotal >= player.handTotal2) {
					playerTotal = player.handTotal;
				}
				else {
					playerTotal = player.handTotal2;
				}
				
				if(playerTotal > dealerTotal) {
					System.out.println("Player wins with: ");
					for(Card card: player.hand) {
						System.out.print(card.getSuit() + card.getNumber() + " ");
					}
					System.out.println("\nPlayer Total: " + player.handTotal + "\n");
				}
				else {
					System.out.print("Dealer wins with: ");
					for(Card card: dealer.hand) {
						System.out.print(card.getSuit() + card.getNumber() + " ");
					}
					System.out.println("\nDealer Total: " + dealer.handTotal + "\n");
				}
			}
		}
		
	}
	
	public static void playerTurnConsole(Player player) {
		Scanner input = new Scanner(System.in);
		
		System.out.print("Players Hand: ");
		for(Card card: player.hand) {
			System.out.print(card.getSuit() + card.getNumber() + " ");
		}
		System.out.println("\nPlayer Total: " + player.handTotal + "\n");
		
		System.out.println("Would you like to hit (h), stand (s) or split (d)?");
		String in = input.nextLine();
		
		switch(in) {
		case "h":
			player.hit(1);
			if(!player.busted) {
				playerTurnConsole(player);
			}
			else {
				System.out.println("Player busted with: " + player.handTotal + "\n");
				break;
			}
		case "s":
			break;
		case "d":
			if(player.hand.get(0).getNumber() != player.hand.get(1).getNumber()) {
				System.out.println("Cannot split on different card values \n");
				playerTurnConsole(player);
			}
			else {
				player.split();
				playerTurnSplitConsole(1, player);
				break;
			}
		default:
			System.out.println("Invalid input \n");
			playerTurnConsole(player);
			break;
		}
	}
	
	public static void playerTurnSplitConsole(int hand, Player player) {
		Scanner input = new Scanner(System.in);
		
		switch(hand) {
		case 1:
			System.out.print("Players First Hand: ");
			for(Card card: player.hand) {
				System.out.print(card.getSuit() + card.getNumber() + " ");
			}
			System.out.println("\nPlayer First Total: " + player.handTotal + "\n");
			
			System.out.println("Would you like to hit (h) or stand (s)?");
			String in = input.nextLine();
			
			switch(in) {
			case "h":
				if(!player.busted) {
					player.hit(1);
					playerTurnSplitConsole(1, player);
				}
				else {
					System.out.println("Player first hand busted with: " + player.handTotal + "\n");
					break;
				}
			case "s":
				playerTurnSplitConsole(2, player);
				break;
			default:
				System.out.println("Invalid input \n");
				playerTurnSplitConsole(1, player);
				break;
			}
			break;
		case 2:
			System.out.print("Players Second Hand: ");
			for(Card card: player.hand2) {
				System.out.print(card.getSuit() + card.getNumber() + " ");
			}
			System.out.println("\nPlayer Second Total: " + player.handTotal + "\n");
			
			System.out.println("Would you like to hit (h) or stand (s)?");
			String in2 = input.nextLine();
			
			switch(in2) {
			case "h":
				if(!player.busted2) {
					player.hit(2);
					playerTurnSplitConsole(2, player);
				}
				else {
					System.out.println("Player second hand busted with: " + player.handTotal2 + "\n");
					break;
				}
			case "s":
				break;
			default:
				System.out.println("Invalid input \n");
				playerTurnSplitConsole(2, player);
				break;
			}
			break;
		}
	}
	
	public static void dealerTurnConsole(Player dealer) {
		System.out.println("Dealers Turn\n");
		System.out.print("Dealers Hand: ");
		for(Card card: dealer.hand) {
			System.out.print(card.getSuit() + card.getNumber() + " ");
		}
		System.out.println("\nDealer Total: " + dealer.handTotal + "\n");
		
		if(dealer.handTotal < 17) {
			System.out.println("Dealer is hitting \n");
			dealer.hit(1);
			if(!dealer.busted) {
				dealerTurnConsole(dealer);
			}
			else {
				System.out.println("Dealer first hand busted with: " + dealer.handTotal + "\n");
			}
		}
		else {
			System.out.println("Dealer is standing \n");
		}
	}
}
