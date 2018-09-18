package core;

public class Card {

	private String suit;
	private String number;
	private int value;
	
	public Card(String suit, String number, int value) {
		this.suit = suit;
		this.number = number;
		this.value = value;
	}
	
	public String getSuit() {
		return this.suit;
	}
	
	public String getNumber() {
		return this.number;
	}
	
	public int getValue() {
		return this.value;
	}
	
	public void setValue(int value) {
		this.value = value;
	}
}
