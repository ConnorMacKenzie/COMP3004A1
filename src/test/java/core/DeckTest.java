package core;

import junit.framework.TestCase;

public class DeckTest extends TestCase {

	public void testDeckAttributes() {
		Deck deck = new Deck();
		
		assertEquals(52, deck.cardsInDeck());
	}
	
	public void testDraw() {
		Deck deck = new Deck();
		Card card = deck.draw();
		
		assertEquals(51, deck.cardsInDeck());
		assertTrue(1 <= card.getValue() && card.getValue() <= 11);
	}
	
	public void testDoNotDrawDuplicate() {
		Deck deck = new Deck();
		Card card = deck.draw();
		Card card1 = deck.draw();
		
		assertEquals(50, deck.cardsInDeck());
		assertTrue((card.getValue() != card1.getValue()) || (card.getSuit() != card1.getSuit()));
	}
	
	public void testDeckIsShuffled() {
		Deck deck = new Deck();
		Card card = deck.draw();
		
		assertEquals(49, deck.cardsInDeck());
		assertTrue((card.getValue() != 2) && (card.getSuit() != "H"));
	}
	
	public void testMockDeck() {
		Deck deck = new Deck();
		deck.mockDeck();
		
		assertEquals(0, deck.cardsInDeck());
	}
	
	public void testMockAddCard() {
		Deck deck = new Deck();
		deck.mockDeck();
		
		assertEquals(0, deck.cardsInDeck());
		Card card = new Card("H", "2", 2);
		deck.mockAddCard(card);
		
		assertEquals(1, deck.cardsInDeck());
		Card card1 = deck.draw();
		assertEquals(0, deck.cardsInDeck());
		assertTrue((card1.getValue() == 2) && (card1.getSuit() == "H") && (card1.getNumber() == "2"));
	}
}
