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
	
	public void testHit() {
		Deck deck = new Deck();
		deck.mockDeck();
		
		Card card1 = new Card("H", "6", 6);
		Card card2 = new Card("D", "5", 5);
		Card card3 = new Card("H", "10", 10);
		deck.mockAddCard(card1);
		deck.mockAddCard(card2);
		deck.mockAddCard(card3);
		
		Player player = new Player(deck);
		
		assertEquals(1, deck.cardsInDeck());
		assertTrue(player.handTotal == 11);
		
		player.hit(1);
		assertEquals(0, deck.cardsInDeck());
		assertTrue(player.handTotal == 21);
		assertTrue(player.busted == false);
	}
	
	public void testHitAndBust() {
		Deck deck = new Deck();
		deck.mockDeck();
		
		Card card1 = new Card("H", "6", 6);
		Card card2 = new Card("D", "7", 7);
		Card card3 = new Card("H", "10", 10);
		deck.mockAddCard(card1);
		deck.mockAddCard(card2);
		deck.mockAddCard(card3);
		
		Player player = new Player(deck);
		
		assertEquals(1, deck.cardsInDeck());
		assertTrue(player.handTotal == 12);
		
		player.hit(1);
		assertEquals(0, deck.cardsInDeck());
		assertTrue(player.handTotal == 22);
		assertTrue(player.busted == true);
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
	
	public void testSplitAndHitBothHands() {
		Deck deck = new Deck();
		deck.mockDeck();
		
		Card card1 = new Card("H", "5", 5);
		Card card2 = new Card("D", "5", 5);
		Card card3 = new Card("H", "4", 4);
		Card card4 = new Card("H", "6", 6);
		Card card5 = new Card("H", "J", 10);
		Card card6 = new Card("H", "Q", 10);
		deck.mockAddCard(card1);
		deck.mockAddCard(card2);
		deck.mockAddCard(card3);
		deck.mockAddCard(card4);
		deck.mockAddCard(card5);
		deck.mockAddCard(card6);
		
		Player player = new Player(deck);
		assertEquals(4, deck.cardsInDeck());
		assertTrue(player.hand.isEmpty() == false);
		assertTrue(player.hand2.isEmpty() == true);
		
		player.split();
		
		assertEquals(2, deck.cardsInDeck());
		assertTrue(player.hand.isEmpty() == false);
		assertTrue(player.hand2.isEmpty() == false);
		assertTrue(player.handTotal == 9);
		assertTrue(player.handTotal2 == 11);
		
		player.hit(1);
		assertTrue(player.handTotal == 19);
		assertTrue(player.busted == false);
		
		player.hit(2);
		assertTrue(player.handTotal == 21);
		assertTrue(player.busted == false);
	}
	
	public void testSplitAndHitBustFirst() {
		Deck deck = new Deck();
		deck.mockDeck();
		
		Card card1 = new Card("H", "8", 8);
		Card card2 = new Card("D", "5", 5);
		Card card3 = new Card("H", "4", 4);
		Card card4 = new Card("H", "6", 6);
		Card card5 = new Card("H", "J", 10);
		Card card6 = new Card("H", "Q", 10);
		deck.mockAddCard(card1);
		deck.mockAddCard(card2);
		deck.mockAddCard(card3);
		deck.mockAddCard(card4);
		deck.mockAddCard(card5);
		deck.mockAddCard(card6);
		
		Player player = new Player(deck);
		assertEquals(4, deck.cardsInDeck());
		assertTrue(player.hand.isEmpty() == false);
		assertTrue(player.hand2.isEmpty() == true);
		
		player.split();
		
		assertEquals(2, deck.cardsInDeck());
		assertTrue(player.hand.isEmpty() == false);
		assertTrue(player.hand2.isEmpty() == false);
		assertTrue(player.handTotal == 12);
		assertTrue(player.handTotal2 == 11);
		
		player.hit(1);
		assertTrue(player.handTotal == 22);
		assertTrue(player.busted == true);
		
		player.hit(2);
		assertTrue(player.handTotal == 21);
		assertTrue(player.busted == false);
	}
	
	public void testSplitAndHitBustBoth() {
		Deck deck = new Deck();
		deck.mockDeck();
		
		Card card1 = new Card("H", "8", 8);
		Card card2 = new Card("D", "6", 6);
		Card card3 = new Card("H", "4", 4);
		Card card4 = new Card("H", "6", 6);
		Card card5 = new Card("H", "J", 10);
		Card card6 = new Card("H", "Q", 10);
		deck.mockAddCard(card1);
		deck.mockAddCard(card2);
		deck.mockAddCard(card3);
		deck.mockAddCard(card4);
		deck.mockAddCard(card5);
		deck.mockAddCard(card6);
		
		Player player = new Player(deck);
		assertEquals(4, deck.cardsInDeck());
		assertTrue(player.hand.isEmpty() == false);
		assertTrue(player.hand2.isEmpty() == true);
		
		player.split();
		
		assertEquals(2, deck.cardsInDeck());
		assertTrue(player.hand.isEmpty() == false);
		assertTrue(player.hand2.isEmpty() == false);
		assertTrue(player.handTotal == 12);
		assertTrue(player.handTotal2 == 12);
		
		player.hit(1);
		assertTrue(player.handTotal == 22);
		assertTrue(player.busted == true);
		
		player.hit(2);
		assertTrue(player.handTotal == 22);
		assertTrue(player.busted == true);
	}
	
}
