package core;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {

	public void testPlayerAttributes() {
		Deck deck = new Deck();
		Player player = new Player(deck);
		assertEquals(50, deck.cardsInDeck());
		assertTrue(player.hand.isEmpty() == false);
		assertTrue(2 <= player.handTotal && player.handTotal <= 21);
		assertTrue(player.busted == false);
	}
	
	public void testSplit() {
		Deck deck = new Deck();
		deck.mockDeck();
		
		Card card1 = new Card("H", "2", 2);
		Card card2 = new Card("D", "2", 2);
		Card card3 = new Card("H", "4", 4);
		Card card4 = new Card("H", "5", 5);
		deck.mockAddCard(card1);
		deck.mockAddCard(card2);
		deck.mockAddCard(card3);
		deck.mockAddCard(card4);
		
		Player player = new Player(deck);
		
		assertEquals(2, deck.cardsInDeck());
		assertTrue(player.hand.isEmpty() == false);
		assertTrue(player.hand2.isEmpty() == true);
		
		player.split();
		
		assertEquals(0, deck.cardsInDeck());
		assertTrue(2 <= player.handTotal && player.handTotal <= 21);
		assertTrue(2 <= player.handTotal2 && player.handTotal2 <= 21);
		assertTrue(player.busted == false);
	}
	
	public void testDoesNotSplitWithDiffCards() {
		Deck deck = new Deck();
		deck.mockDeck();
		
		Card card1 = new Card("H", "2", 2);
		Card card2 = new Card("H", "3", 3);
		Card card3 = new Card("H", "4", 4);
		Card card4 = new Card("H", "5", 5);
		deck.mockAddCard(card1);
		deck.mockAddCard(card2);
		deck.mockAddCard(card3);
		deck.mockAddCard(card4);
		
		Player player = new Player(deck);
		assertEquals(2, deck.cardsInDeck());
		assertTrue(player.hand.isEmpty() == false);
		assertTrue(player.hand2.isEmpty() == true);
		
		player.split();
		
		assertEquals(2, deck.cardsInDeck());
		assertTrue(player.hand.isEmpty() == false);
		assertTrue(player.hand2.isEmpty() == true);
		assertTrue(2 <= player.handTotal && player.handTotal <= 21);
		assertTrue(player.busted == false);
	}
	
}
