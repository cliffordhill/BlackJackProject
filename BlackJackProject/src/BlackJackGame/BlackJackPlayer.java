package BlackJackGame;

import java.util.ArrayList;
import java.util.List;


public class BlackJackPlayer {

	String name;
	List<Card> cardHand = new ArrayList<Card>();

	public BlackJackPlayer(String name) {
		this.name = name;
	}

	public void AddCardToHand(Card card) {
		cardHand.add(card);
	}

	public void PrintHand() {
		System.out.print(name + " hand contains");
		for (Card card : cardHand) {
			System.out.print(" " + card.getValue() + ":" + card.getSuit());
		}
		System.out.println("\n"+ name +" value at :"+ getHandValue());

	}

	public int getHandValue() {
		int value = 0;
		for(Card card : cardHand) {
			//convert suits to 10
			if(card.getValue()>10) {
				value+= 10;
			}else if(card.getValue() == 1){
				value += aceClause(value);
			}else {
				value += card.getValue();				
			}
		}
		return value;
	}
	
	private int aceClause(int value) {
		//runs this 
		if(value + 11 > 21) {
			return value + 11;
		}else {
			return value + 1;
		}
	}
	public Boolean checkBust() {
		if (getHandValue()> 21) {
			return false;
		} else {
			return true;
		}
	}
	
	public void AceTest() {
		cardHand.clear();		
		cardHand.add(new Card(1,Suit.CLUB));
		cardHand.add(new Card(11,Suit.CLUB));
		cardHand.add(new Card(11,Suit.CLUB));
		
	}
	public void AceTest2() {
		cardHand.clear();		
		cardHand.add(new Card(11,Suit.CLUB));
		cardHand.add(new Card(11,Suit.CLUB));
		cardHand.add(new Card(1,Suit.CLUB));
		
	}
	public void AceTest3() {
		cardHand.clear();		
		cardHand.add(new Card(1,Suit.CLUB));
		cardHand.add(new Card(11,Suit.CLUB));
		cardHand.add(new Card(11,Suit.CLUB));
		cardHand.add(new Card(1,Suit.CLUB));
		
	}
}
