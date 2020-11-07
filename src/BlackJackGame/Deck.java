package BlackJackGame;

import java.util.List;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class Deck {

	Queue<Card> stackOfCards = new LinkedList<Card>();
	List<Card> cardStack = new ArrayList<Card>();

	public Deck() {
		setupDeck();
		shuffleDeck();
	}

	public Card drawCard() {
		if (stackOfCards.isEmpty()) {
			setupDeck();
			shuffleDeck();
		}
		return stackOfCards.poll();
	}

	public void addCardToDeck(Card card) {
		stackOfCards.add(card);
	}


	public void setupDeck() {
		for (int i = 1; i <= 13; i++) {
			addCardToDeck(new Card(i, Suit.CLUB));
			addCardToDeck(new Card(i, Suit.DIAMOND));
			addCardToDeck(new Card(i, Suit.HEART));
			addCardToDeck(new Card(i, Suit.SPADE));
		}
	}
	
	public void shuffleDeck() {
		// take stack of cards
		for (Card card : stackOfCards) {
			cardStack.add(card);
		}
		stackOfCards.clear();
		int randomIndex;
		while (!cardStack.isEmpty()) {
			randomIndex = (int) (Math.random() * (cardStack.size() - 0) + 0);
			stackOfCards.add(cardStack.get(randomIndex));
			cardStack.remove(randomIndex);
		}
		System.out.println("DeckShuffled");
	}
}
