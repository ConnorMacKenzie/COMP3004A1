package core;

import junit.framework.TestCase;

public class PlayerTest extends TestCase {

	public void testPlayerAttributes() {
		Deck deck = new Deck();
		Player player = new Player(deck);
		assertEquals(54, deck.cardsInDeck());
		assertTrue(player.hand.isEmpty() == false);
		assertTrue(2 <= player.handTotal && player.handTotal <= 21);
		assertTrue(player.busted == false);
	}
	
	public void testPlayerTurn() {
		
	}
	
	public void testDealerTurn() {
		
	}
	
}
