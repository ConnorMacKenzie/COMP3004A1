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
		assertEquals(11, player.handTotal);
		
		player.hit(1);
		assertEquals(0, deck.cardsInDeck());
		assertEquals(21, player.handTotal);
		assertEquals(false, player.busted);
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
		assertEquals(13, player.handTotal);
		
		player.hit(1);
		assertEquals(0, deck.cardsInDeck());
		assertTrue(player.handTotal == 23);
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
		assertEquals(false, player.hand.isEmpty());
		assertEquals(true, player.hand2.isEmpty());
		
		player.split();
		
		assertEquals(0, deck.cardsInDeck());
		assertEquals(6, player.handTotal);
		assertEquals(7, player.handTotal2);
		assertEquals(false, player.busted);
		assertEquals(false, player.busted2);
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
		assertEquals(false, player.hand.isEmpty());
		assertEquals(true, player.hand2.isEmpty());
		
		player.split();
		
		assertEquals(2, deck.cardsInDeck());
		assertEquals(false, player.hand.isEmpty());
		assertEquals(true, player.hand2.isEmpty());
		assertEquals(5, player.handTotal);
		assertEquals(false, player.busted);
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
		assertEquals(false, player.hand.isEmpty());
		assertEquals(true, player.hand2.isEmpty());
		
		player.split();
		
		assertEquals(2, deck.cardsInDeck());
		assertEquals(false, player.hand.isEmpty());
		assertEquals(false, player.hand2.isEmpty());
		assertEquals(9, player.handTotal);
		assertEquals(11, player.handTotal2);
		
		player.hit(1);
		assertEquals(19, player.handTotal);
		assertEquals(false, player.busted);
		
		player.hit(2);
		assertEquals(21, player.handTotal2);
		assertEquals(false, player.busted2);
	}
	
	public void testSplitAndHitBustFirst() {
		Deck deck = new Deck();
		deck.mockDeck();
		
		Card card1 = new Card("H", "8", 8);
		Card card2 = new Card("D", "8", 8);
		Card card3 = new Card("H", "4", 4);
		Card card4 = new Card("H", "3", 3);
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
		assertEquals(false, player.hand.isEmpty());
		assertEquals(true, player.hand2.isEmpty());
		
		player.split();
		
		assertEquals(2, deck.cardsInDeck());
		assertEquals(false, player.hand.isEmpty());
		assertEquals(false, player.hand2.isEmpty());
		assertEquals(12, player.handTotal);
		assertEquals(11, player.handTotal2);
		
		player.hit(1);
		assertEquals(22, player.handTotal);
		assertEquals(true, player.busted);
		
		player.hit(2);
		assertEquals(21, player.handTotal);
		assertEquals(false, player.busted);
	}
	
	public void testSplitAndHitBustBoth() {
		Deck deck = new Deck();
		deck.mockDeck();
		
		Card card1 = new Card("H", "8", 8);
		Card card2 = new Card("D", "8", 8);
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
		assertEquals(false, player.hand.isEmpty());
		assertEquals(true, player.hand2.isEmpty());
		
		player.split();
		
		assertEquals(2, deck.cardsInDeck());
		assertEquals(false, player.hand.isEmpty());
		assertEquals(false, player.hand2.isEmpty());
		assertEquals(12, player.handTotal);
		assertEquals(14, player.handTotal2);
		
		player.hit(1);
		assertEquals(22, player.handTotal);
		assertEquals(true, player.busted);
		
		player.hit(2);
		assertEquals(24, player.handTotal);
		assertEquals(true, player.busted);
	}
	
}
