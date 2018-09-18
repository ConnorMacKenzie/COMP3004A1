package core;

import java.util.ArrayList;
import java.util.Scanner;

public class Player {

	ArrayList<Card> hand = new ArrayList<Card>();
	ArrayList<Card> hand2 = new ArrayList<Card>();
	int handTotal;
	int handTotal2;
	Deck deck;
	boolean busted = false; 
	
	public Player(Deck deck) {
		this.deck = deck;
		Card card = deck.draw();
		Card card1 = deck.draw();
		
		hand.add(card);
		hand.add(card1);
		
		this.handTotal = totalHand();
	}
	
	public void split() {
		Card card = hand.remove(1);
		hand2.add(card);
		
		Card card1 = deck.draw();
		Card card2 = deck.draw();
		
		hand.add(card1);
		hand2.add(card2);
	}
	
	private int totalHand() {
		int total = 0;
		for (Card card : this.hand) 
		{ 
		    total += card.getValue();
		}
		return total;
	}
}
