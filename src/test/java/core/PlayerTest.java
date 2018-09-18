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
	
	public void testSplit() {
		Deck deck = new Deck();
		Player player = new Player(deck);
		assertEquals(54, deck.cardsInDeck());
		assertTrue(player.hand.isEmpty() == false);
		assertTrue(player.hand2.isEmpty() == true);
		player.split();
		assertTrue(2 <= player.handTotal && player.handTotal <= 21);
		assertTrue(2 <= player.handTotal2 && player.handTotal2 <= 21);
		assertTrue(player.busted == false);
	}
	
}
