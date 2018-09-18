package core;

import junit.framework.TestCase;

public class DeckTest extends TestCase {

	public void testDeckAttributes() {
		Deck deck = new Deck();
		
		assertEquals(56, deck.cardsInDeck());
	}
	
	public void testDraw() {
		Deck deck = new Deck();
		Card card = deck.draw();
		
		assertEquals(55, deck.cardsInDeck());
		assertTrue(1 <= card.getValue() && card.getValue() <= 11);
	}
	
	public void testDoNotDrawDuplicate() {
		Deck deck = new Deck();
		Card card = deck.draw();
		Card card1 = deck.draw();
		
		assertEquals(54, deck.cardsInDeck());
		assertTrue((card.getValue() != card1.getValue()) || (card.getSuit() != card1.getSuit()));
	}
}
