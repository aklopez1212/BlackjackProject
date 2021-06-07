package com.skilldistillery.cards.blackjack;

import com.skilldistillery.cards.common.*;

public class BlackJackHand extends Hand {

	@Override
	public int getHandValue() {
		// TODO Implement soft ace here.
		int numOfAces = 0;
		int sumOfCards = 0;
		for (Card card : getCards()) {
			if (card.getRank() == Rank.Ace) {
				numOfAces++;
			}
			sumOfCards += card.getValue();
		}
		if (sumOfCards > 21 && numOfAces == 1) {
			sumOfCards -= 10;
		} else if (sumOfCards > 21 && numOfAces > 1) {
			sumOfCards -= 10 * (numOfAces - 1);
		}
//		} else if(sumOfCards == 21) {
//			isBlackJack();
//		} else if (sumOfCards > 21) {
//			isBust();
//		}
		return sumOfCards;
	}

	public void isBlackJack() {
		//Had issues with method isBlackJack breaking game
		System.out.println("Blackjack!");
	}

	public void isBust() {
		//Had issues with method isBust breaking game
		System.out.println("Bust!");
	}
}
