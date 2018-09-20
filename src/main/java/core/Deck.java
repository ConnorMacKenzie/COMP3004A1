package core;

import java.util.ArrayList;
import java.util.Collections;

public class Deck {

	private ArrayList<Card> cardList = new ArrayList<Card>();
	
	public Deck() {
		Card card1 = new Card("H", "2", 2);
		Card card2 = new Card("H", "3", 3);
		Card card3 = new Card("H", "4", 4);
		Card card4 = new Card("H", "5", 5);
		Card card5 = new Card("H", "6", 6);
		Card card6 = new Card("H", "7", 7);
		Card card7 = new Card("H", "8", 8);
		Card card8 = new Card("H", "9", 9);
		Card card9 = new Card("H", "10", 10);
		Card card10 = new Card("H", "J", 10);
		Card card11 = new Card("H", "Q", 10);
		Card card12 = new Card("H", "K", 10);
		Card card13 = new Card("H", "A", 11);
		Card card14 = new Card("D", "2", 2);
		Card card15 = new Card("D", "3", 3);
		Card card16 = new Card("D", "4", 4);
		Card card17 = new Card("D", "5", 5);
		Card card18 = new Card("D", "6", 6);
		Card card19 = new Card("D", "7", 7);
		Card card20 = new Card("D", "8", 8);
		Card card21 = new Card("D", "9", 9);
		Card card22 = new Card("D", "10", 10);
		Card card23 = new Card("D", "J", 10);
		Card card24 = new Card("D", "Q", 10);
		Card card25 = new Card("D", "K", 10);
		Card card26 = new Card("D", "A", 11);
		Card card27 = new Card("S", "2", 2);
		Card card28 = new Card("S", "3", 3);
		Card card29 = new Card("S", "4", 4);
		Card card30 = new Card("S", "5", 5);
		Card card31 = new Card("S", "6", 6);
		Card card32 = new Card("S", "7", 7);
		Card card33 = new Card("S", "8", 8);
		Card card34 = new Card("S", "9", 9);
		Card card35 = new Card("S", "10", 10);
		Card card36 = new Card("S", "J", 10);
		Card card37 = new Card("S", "Q", 10);
		Card card38 = new Card("S", "K", 10);
		Card card39 = new Card("S", "A", 11);
		Card card40 = new Card("C", "2", 2);
		Card card41 = new Card("C", "3", 3);
		Card card42 = new Card("C", "4", 4);
		Card card43 = new Card("C", "5", 5);
		Card card44 = new Card("C", "6", 6);
		Card card45 = new Card("C", "7", 7);
		Card card46 = new Card("C", "8", 8);
		Card card47 = new Card("C", "9", 9);
		Card card48 = new Card("C", "10", 10);
		Card card49 = new Card("C", "J", 10);
		Card card50 = new Card("C", "Q", 10);
		Card card51 = new Card("C", "K", 10);
		Card card52 = new Card("C", "A", 11);
		
		cardList.add(card1);
		cardList.add(card2);
		cardList.add(card3);
		cardList.add(card4);
		cardList.add(card5);
		cardList.add(card6);
		cardList.add(card7);
		cardList.add(card8);
		cardList.add(card9);
		cardList.add(card10);
		cardList.add(card11);
		cardList.add(card12);
		cardList.add(card13);
		cardList.add(card14);
		cardList.add(card15);
		cardList.add(card16);
		cardList.add(card17);
		cardList.add(card18);
		cardList.add(card19);
		cardList.add(card20);
		cardList.add(card21);
		cardList.add(card22);
		cardList.add(card23);
		cardList.add(card24);
		cardList.add(card25);
		cardList.add(card26);
		cardList.add(card27);
		cardList.add(card28);
		cardList.add(card29);
		cardList.add(card30);
		cardList.add(card31);
		cardList.add(card32);
		cardList.add(card33);
		cardList.add(card34);
		cardList.add(card35);
		cardList.add(card36);
		cardList.add(card37);
		cardList.add(card38);
		cardList.add(card39);
		cardList.add(card40);
		cardList.add(card41);
		cardList.add(card42);
		cardList.add(card43);
		cardList.add(card44);
		cardList.add(card45);
		cardList.add(card46);
		cardList.add(card47);
		cardList.add(card48);
		cardList.add(card49);
		cardList.add(card50);
		cardList.add(card51);
		cardList.add(card52);
		
		Collections.shuffle(cardList);
	} 
	
	public int cardsInDeck() {
		return cardList.size();
	}
	
	public Card draw() {
		return cardList.remove(0);
	}
	
	public void mockDeck() {
		cardList.clear();
	}
	
	public void mockAddCard(Card card) {
		cardList.add(card);
	}
	
}
