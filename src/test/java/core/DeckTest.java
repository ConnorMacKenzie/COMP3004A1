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
		Card card1 = deck.draw();
		Card card2 = deck.draw();
		
		assertEquals(49, deck.cardsInDeck());
		assertTrue(((card.getValue() != 1) && (card.getSuit() != "H"))
					&& ((card1.getValue() != 2) && (card1.getSuit() != "H"))
					&& ((card2.getValue() != 3) && (card2.getSuit() != "H")));
	}
}
