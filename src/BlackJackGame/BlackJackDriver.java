package BlackJackGame;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class BlackJackDriver {
	public static void main(String[] args) {

		Scanner input = new Scanner(System.in);
		
		boolean keepPlaying = true; // Game loop terminating case
		boolean playersTurn; // Player loop terminating case

		Deck deck = new Deck();
		
		//Functionality for many players 
		List<BlackJackPlayer> players = new ArrayList<BlackJackPlayer>();
		
		BlackJackPlayer dealer = new BlackJackPlayer("Dealer");
		BlackJackPlayer player1 = new BlackJackPlayer("Player1");

		players.add(dealer);
		players.add(player1);
		
		// Both players given 2 cards to start
		// Game loop
		while (keepPlaying) {
			startNewGame(deck, player1, dealer);
			//Begin Players turn
			playersTurn = true;
			while (playersTurn) {

				playersTurn = handlePlayerTurn(input, deck, player1);

			}
			
			// Dealers turn
			while(dealer.getHandValue()< 18) {
				System.out.println("Dealer Hits");
				hitDeck(deck,dealer,true);
			}
			
			//Print final results
			player1.printHand();
			dealer.printHand();
			
			// Check who wins
			if(checkWinner(player1, dealer)) {
				System.out.println("You win!");
			}else {
				System.out.println("Dealer wins!");				
			}
			System.out.println("Do you want to keep playing? Y or N");
			if (input.next().toLowerCase().equals("n")) {
				keepPlaying = false;
			}
		}

		input.close();
	}// end of main

	/**
	 * This will perform the input check from the user, for each player
	 * @param input - scanner for user input
	 * @param deck - deck of cards to draw from
	 * @param player - player who's turn it is
	 * @return
	 */
	private static boolean handlePlayerTurn(Scanner input, Deck deck, BlackJackPlayer player) {

		boolean playersTurn = true;
		String playerInput;
		
		System.out.println("Type H for hit, S for stay.");
		playerInput = input.next().toLowerCase();

		// Draw a card
		if (playerInput.equals("h")) {
			System.out.println("Player Hits");
			hitDeck(deck, player, true);
		}
		// end players turn if they bust or choose to stay
		if (playerInput.equals("s") || player.checkBust())
			playersTurn = false;
		
		
		return playersTurn;
	}

	public static void startNewGame(Deck deck, BlackJackPlayer player1, BlackJackPlayer dealer) {
		player1.discardHand();
		dealer.discardHand();
		hitDeck(deck, dealer, false);
		hitDeck(deck, dealer, true);
		hitDeck(deck, player1, false);
		hitDeck(deck, player1, true);
	}
	/**
	 * Draws from the deck provided
	 * @param deck - deck of cards to draw from
	 * @param player - add the card draw to this player's hand
	 * @param print - if you want to print players hand or not
	 */
	public static void hitDeck(Deck deck, BlackJackPlayer player, boolean print) {
//		System.out.println(player.getName()+ " hits");
		player.addCardToHand(deck.drawCard());
		if (print) {
			player.printHand();
			System.out.println();
		}
	}
	
	/**
	 * Check if player's hand wins vs the dealer
	 * @param player1
	 * @param dealer
	 * @returns true if player wins otherwise false
	 */
	//for now going to work only with dealer vs player
	public static boolean checkWinner(BlackJackPlayer player1,BlackJackPlayer dealer) {
		if(player1.checkBust()) {
			return false;
		}else if(dealer.checkBust()) {
			return true;
		}else if(player1.getHandValue()< dealer.getHandValue()) {
			return false;
		}
		
		return true;
	}
}
