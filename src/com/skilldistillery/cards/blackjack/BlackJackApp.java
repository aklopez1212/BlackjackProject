package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.*;

import java.util.Scanner;

public class BlackJackApp {
	static Scanner sc = new Scanner(System.in);

	public static void main(String[] args) {
		BlackJackApp app = new BlackJackApp();
		app.run(sc);

	}

	public void run(Scanner sc) {
		int userIn = 0;
		System.out.println("|==================================|");
		System.out.println("|Welcome to command line Blackjack!|");
		System.out.println("|--1) Begin Game                   |");
		System.out.println("|--2) See Shuffled Deck            |");
		System.out.println("|--3) Quit                         |");
		System.out.println("|==================================|");
		System.out.print("Make your selection: ");
		userIn = sc.nextInt();
		System.out.println();
		switch (userIn) {
		case 1:
			gamePlay();
			break;
		case 2:
			shuffleDeck();
			break;
		case 3:
			System.exit(0);
			break;
		default:
			System.err.println("Invalid selection, ");
		}
	}

	public void shuffleDeck() {
		Hand test = new BlackJackHand();
		Deck testShuffle = new Deck();
		testShuffle.shuffle();
		for (int i = 0; i < 52; i++) {
			test.addCard(testShuffle.dealCard());
		}
		System.out.println(test.getCards());
		run(sc);
	}

	public void gamePlay() {
		BlackJackHand player = new BlackJackHand();
		Hand dealer = new BlackJackHand();
		Deck deck = new Deck();
		System.out.println("Shuffling deck... ");
		deck.shuffle();
		System.out.println("Dealing cards... ");
		System.out.println();
		player.addCard(deck.dealCard());
		player.addCard(deck.dealCard());
		dealer.addCard(deck.dealCard());
		System.out.println("Dealer shows a " + dealer.getCards());
		dealer.addCard(deck.dealCard());
		System.out.println("You have " + player.getCards());
		System.out.println("For a total of: " + player.getHandValue());
		System.out.println();
		String userIn = "";
		do {
			System.out.println("Would you like to Hit or Stay?");
			userIn = sc.next();
			System.out.println();

			if (userIn.equalsIgnoreCase("Hit")) {
				player.addCard(deck.dealCard());
				System.out.println(player.getCards());
				System.out.println("Total of: " + player.getHandValue());
			} 

		} while (userIn.equalsIgnoreCase("hit") && player.getHandValue() <= 21);
		if (userIn.equalsIgnoreCase("Stay")) {
			dealerTurn(player, dealer, deck);
		} else if (player.getHandValue() > 21){
			winCheck(dealer, player);
		} 
		}

	private void dealerTurn(Hand player, Hand dealer, Deck deck) {
		do {
			if (dealer.getHandValue() < 17) {
				dealer.addCard(deck.dealCard());
				System.out.println("Dealer has: " + dealer.getCards() + "For a Total of: " + dealer.getHandValue());
			}
		} while (dealer.getHandValue() <= 17);
		winCheck(dealer, player);
	}

	private void winCheck(Hand dealer, Hand player) {
		Scanner sc = new Scanner(System.in);
		if (player.getHandValue() > dealer.getHandValue() && player.getHandValue() <= 21) {
			System.out.println("You have won! Would you like to play again? (Y/N) ");
			String select = sc.next();
			System.out.println();
			if (select.equalsIgnoreCase("Y")) {
				gamePlay();
			} else if (select.equalsIgnoreCase("N")) {
				System.out.println("Thanks for playing!");
				System.exit(0);
			} else if (player.getHandValue() > 21) {
				System.out.println("Bust! Dealer has won. Play again? (Y/N)");
				select = sc.next();
				System.out.println();
				if (select.equalsIgnoreCase("Y")) {
					gamePlay();
				} else if (select.equalsIgnoreCase("N")) {
					System.out.println("Thanks for playing!");
					System.exit(0);
				}

			}
		} else if (dealer.getHandValue() > player.getHandValue() && dealer.getHandValue() <= 21) {
			System.out.println("The dealer has won, would you like to play again? (Y/N) ");
			String select = sc.next();
			System.out.println();
			if (select.equalsIgnoreCase("Y")) {
				gamePlay();
			} else if (select.equalsIgnoreCase("N")) {
				System.out.println("Thanks for playing!");
				System.exit(0);
			} else if (dealer.getHandValue() > 21) {
				System.out.println("Dealer Bust! You have won. Play again? (Y/N)");
				select = sc.next();
				System.out.println();
				if (select.equalsIgnoreCase("Y")) {
					gamePlay();
				} else if (select.equalsIgnoreCase("N")) {
					System.out.println("Thanks for playing!");
					System.exit(0);
				}
			}
		}
	}

}
