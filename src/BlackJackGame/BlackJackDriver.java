package BlackJackGame;

import java.util.Scanner;

public class BlackJackDriver {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		Deck deck = new Deck();
		BlackJackPlayer player1 = new BlackJackPlayer("Player1");
		BlackJackPlayer dealer= new BlackJackPlayer("Dealer");
		
//		player1.AddCardToHand(deck.drawCard());
//		player1.AddCardToHand(deck.drawCard());
//		player1.PrintHand();
//		
//		dealer.AddCardToHand(deck.drawCard());
//		dealer.AddCardToHand(deck.drawCard());
//		dealer.PrintHand();
		player1.AceTest();
		player1.PrintHand();

		player1.AceTest2();
		player1.PrintHand();
		
		player1.AceTest3();
		player1.PrintHand();
		
	}
}
