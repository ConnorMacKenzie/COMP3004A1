package core;

import java.util.ArrayList;

public class Player {

	ArrayList<Card> hand = new ArrayList<Card>();
	ArrayList<Card> hand2 = new ArrayList<Card>();
	int handTotal;
	int handTotal2;
	Deck deck;
	boolean busted = false; 
	boolean busted2 = false; 
	
	public Player(Deck deck) {
		this.deck = deck;
		Card card = deck.draw();
		Card card1 = deck.draw();
		
		hand.add(card);
		hand.add(card1);
		
		this.handTotal = totalHand(1);
	}
	
	public void hit(int hand) {
		Card card = deck.draw();
		
		switch(hand) {
		case 1:
			this.hand.add(card);
			this.handTotal = totalHand(1);
			if( this.handTotal > 21) {
				this.busted = true;
			}
			break;
		case 2:
			this.hand2.add(card);
			this.handTotal2 = totalHand(2);
			if( this.handTotal2 > 21) {
				this.busted2 = true;
			}
			break;
		}
	}
	
	public void split() {
		if(hand.get(0).getNumber() != hand.get(1).getNumber()) {
			return;
		}
		Card card = hand.remove(1);
		hand2.add(card);
		
		Card card1 = deck.draw();
		Card card2 = deck.draw();
		
		hand.add(card1);
		hand2.add(card2);
		
		this.handTotal = totalHand(1);
		this.handTotal2 = totalHand(2);
	}
	
	private int totalHand(int hand) {
		int total = 0;
		switch(hand) {
		case 1:
			for (Card card : this.hand) 
			{ 
			    total += card.getValue();
			}
			break;
		case 2:
			for (Card card : this.hand2) 
			{ 
			    total += card.getValue();
			}
			break;
		}
		
		return total;
	}
}
