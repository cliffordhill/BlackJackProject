package BlackJackGame;

import java.util.ArrayList;
import java.util.List;

public class BlackJackPlayer {

	private String name;
	private List<Card> cardHand = new ArrayList<Card>();

	public BlackJackPlayer(String name) {
		this.name = name;
	}

	public void addCardToHand(Card card) {
		cardHand.add(card);
	}

	public void printHand() {
		System.out.print(name + " hand contains");
		for (Card card : cardHand) {
			System.out.print(" " + card.getValue() + ":" + card.getSuit());
		}
		System.out.println("\n" + name + " value at :" + getHandValue());

	}

	//Calculate the players current score based on their hand
	public int getHandValue() {
		int value = 0;
		int aces = 0;
		for (Card card : cardHand) {
			// convert suits to 10
			if (card.getValue() > 10) {
				value += 10;
			} else if (card.getValue() == 1) {
				aces++;
			} else {
				value += card.getValue();
			}
		}
		value += calculateAce(value, aces);

		return value;
	}

	//calculate the special rules for aces
	private int calculateAce(int startValue, int aces) {
		if (aces ==0) {
			return 0;
		}
		int value = startValue;
		
			if (value + 11 > 21) {
				return aces;
			} else {
				return 10 + aces;
			}
			
	}
	
	public void discardHand() {
		cardHand.clear();
	}

	/**Summary
	 * Check if player's hand is over 21, if it is, returns true
	 */
	public Boolean checkBust() {
		if (getHandValue() > 21) {
			System.out.println("Busted!");
			return true;
		} else {
			return false;
		}
	}

	public String getName() {
		return this.name;
	}
}
