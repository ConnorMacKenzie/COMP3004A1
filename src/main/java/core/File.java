package core;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.*;
import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class File {
	
	String path;
	List<String> content = new LinkedList<String>();

	public File(String path) {
		this.path = path;
	}
	public static void file() {
		Scanner input = new Scanner(System.in);
		
		Deck deck = new Deck();
		Player player = new Player(deck);
		Player dealer = new Player(deck);
		
		System.out.println("Enter the path to the folder you would like to use:");
		String fullPath = input.nextLine() + "\\blackJack.txt";
		File file = new File(fullPath);
		
		file.content.add("Dealer Hand: " + dealer.hand.get(0).getSuit() + dealer.hand.get(0).getNumber());
		
		writeFile(file.path, file.content);
		file.content = readFile(file.path);
		playerTurnFile(player, file);
		
		if((player.busted && player.hand2.isEmpty()) || (player.busted && player.busted2)) {
			String msg = "Dealer wins with: ";
			for(Card card: dealer.hand) {
				msg += card.getSuit() + card.getNumber() + " ";
			}
			file.content.add(msg);
			file.content.add("Dealer Total: " + dealer.handTotal);
			writeFile(file.path, file.content);
		}
		else {
			file.content.add("Dealers Turn");
			writeFile(file.path, file.content);
			dealerTurnFile(dealer, file);
			
			if((dealer.busted && dealer.hand2.isEmpty()) || (dealer.busted && player.busted2)) {
				String msg2 = "Player wins with: ";
				for(Card card: player.hand) {
					msg2 += card.getSuit() + card.getNumber() + " ";
				}
				file.content.add(msg2);
				file.content.add("Player Total: " + player.handTotal);
				writeFile(file.path, file.content);
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
					String msg3 = "Player wins with: ";
					for(Card card: player.hand) {
						msg3 += card.getSuit() + card.getNumber() + " ";
					}
					file.content.add(msg3);
					file.content.add("Player Total: " + player.handTotal);
					writeFile(file.path, file.content);
				}
				else {
					String msg4 = "Dealer wins with: ";
					for(Card card: dealer.hand) {
						msg4 += card.getSuit() + card.getNumber() + " ";
					}
					file.content.add(msg4);
					file.content.add("Dealer Total: " + dealer.handTotal);
					writeFile(file.path, file.content);
				}
			}
		}
		
		
	}
	
	public static void playerTurnFile(Player player, File file) {
		writePlayerHand(player, file);
		while(file.content.size() == readFile(file.path).size()) {
			
		}
		file.content = readFile(file.path);
		String action = file.content.get(file.content.size() - 1);
		
		switch(action) {
		case "h":
			player.hit(1);
			if(!player.busted) {
				playerTurnFile(player, file);
			}
			else {
				file.content.add("Player busted with: " + player.handTotal);
				writeFile(file.path, file.content);
				break;
			}
		case "s":
			break;
		case "d":
			if(player.hand.get(0).getNumber() != player.hand.get(1).getNumber()) {
				file.content.add("Cannot split on different card values");
				writeFile(file.path, file.content);
				playerTurnFile(player, file);
			}
			else {
				player.split();
				playerTurnSplitFile(1, player, file);
				break;
			}
		default:
			file.content.add("Invalid input");
			writeFile(file.path, file.content);
			playerTurnFile(player, file);
			break;
		}
	}
	
	public static void playerTurnSplitFile(int hand, Player player, File file) {
		
		switch(hand) {
		case 1:
			String hand1 ="Players First Hand: ";
			for(Card card: player.hand) {
				hand1 += card.getSuit() + card.getNumber() + " ";
			}
			file.content.add(hand1);
			file.content.add("Player First Total: " + player.handTotal);
			file.content.add("Would you like to hit (h) or stand (s)?");
			
			writePlayerHand(player, file);
			while(file.content.size() == readFile(file.path).size()) {
				
			}
			file.content = readFile(file.path);
			String action = file.content.get(file.content.size() - 1);
			
			switch(action) {
			case "h":
				if(!player.busted) {
					player.hit(1);
					playerTurnSplitFile(1, player, file);
				}
				else {
					file.content.add("Player first hand busted with: " + player.handTotal);
					writeFile(file.path, file.content);
					break;
				}
			case "s":
				playerTurnSplitFile(2, player, file);
				break;
			default:
				file.content.add("Invalid input");
				writeFile(file.path, file.content);
				playerTurnSplitFile(1, player, file);
				break;
			}
			break;
		case 2:
			String hand2 ="Players Second Hand: ";
			for(Card card: player.hand2) {
				hand2 += card.getSuit() + card.getNumber() + " ";
			}
			file.content.add(hand2);
			file.content.add("Player Second Total: " + player.handTotal2);
			file.content.add("Would you like to hit (h) or stand (s)?");
			
			writePlayerHand(player, file);
			while(file.content.size() == readFile(file.path).size()) {
				
			}
			file.content = readFile(file.path);
			String action2 = file.content.get(file.content.size() - 1);
			
			switch(action2) {
			case "h":
				if(!player.busted2) {
					player.hit(1);
					playerTurnSplitFile(2, player, file);
				}
				else {
					file.content.add("Player second hand busted with: " + player.handTotal2 + "\n");
					writeFile(file.path, file.content);
					break;
				}
			case "s":
				break;
			default:
				file.content.add("Invalid input \n");
				writeFile(file.path, file.content);
				playerTurnSplitFile(2, player, file);
				break;
			}
			break;
		}
	}
	
	public static void dealerTurnFile(Player dealer, File file) {
		String hand = "Dealers Hand: ";
		for(Card card: dealer.hand) {
			hand += card.getSuit() + card.getNumber() + " ";
		}
		file.content.add(hand);
		file.content.add("Dealer Total: " + dealer.handTotal);
		writeFile(file.path, file.content);
		
		if(dealer.handTotal < 17) {
			file.content.add("Dealer is hitting");
			writeFile(file.path, file.content);
			dealer.hit(1);
			if(!dealer.busted) {
				dealerTurnFile(dealer, file);
			}
			else {
				file.content.add("Dealer first hand busted with: " + dealer.handTotal + "\n");
				writeFile(file.path, file.content);
			}
		}
		else {
			file.content.add("Dealer is standing");
			writeFile(file.path, file.content);
		}
	}
	
	public static void writePlayerHand(Player player, File file) {
		String hand1 = "Player Hand: ";
		for(Card card: player.hand) {
			hand1 += card.getSuit() + card.getNumber() + " ";
		}
		file.content.add(hand1);
		file.content.add("Player Total: " + player.handTotal);
		file.content.add("On the line below enter your next action, hit (h), stand (s) or split (d)");
		writeFile(file.path, file.content);
	}
	
	public static List<String> readFile(String fileName){
    	Path file = Paths.get(fileName);
    	List<String> data = null;
    	try{
    		data = Files.readAllLines(file, Charset.forName("UTF-8"));
    	}
    	catch (IOException e) {
    		e.printStackTrace();
            System.exit(1);
    	}
		return data;
    }
    
	public static void writeFile(String fileName, List<String> data){
        Path file = Paths.get(fileName);
        try{
        	Files.write(file, data, Charset.forName("UTF-8"));
        }
        catch (IOException e) {
            e.printStackTrace();
            System.exit(1);
        }
    }
}
