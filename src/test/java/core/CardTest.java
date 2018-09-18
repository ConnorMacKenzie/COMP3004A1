package core;

import junit.framework.TestCase;

public class CardTest extends TestCase{

	public void testCardAttributes() {
		Card card = new Card("H", "K", 10);
		assertEquals("H", card.getSuit());
		assertEquals("K", card.getNumber());
		assertEquals(10, card.getValue());
	}
	
	public void testSetAceValue() {
		Card card = new Card("H", "K", 11);
		
		assertEquals("H", card.getSuit());
		assertEquals("K", card.getNumber());
		assertEquals(11, card.getValue());
		
		card.setValue(1);
		assertEquals(1, card.getValue());
	}
}
