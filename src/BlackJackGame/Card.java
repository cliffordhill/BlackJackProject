package BlackJackGame;

public class Card {
	private int value;
	private Suit suit;
	
	public Card(int value, Suit suit) {
		this.suit = suit;
		this.value = value;
	}
	
	
	//Getter setters
	public int getValue() {
		return value;
	}

	public void setValue(int value) {
		this.value = value;
	}

	public Suit getSuit() {
		return suit;
	}

	public void setSuit(Suit suit) {
		this.suit = suit;
	}

}
