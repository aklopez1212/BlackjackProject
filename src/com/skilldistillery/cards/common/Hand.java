package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public abstract class Hand {
private List<Card> cards = new ArrayList<>();

public void addCard(Card card) {
	getCards().add(card);
}
public int getHandValue() {
	int value = 0;
	for (Card card : getCards()) {
		value += card.getValue();
	} return value;
}
public void fold() {
	getCards().clear();
}
public List<Card> getCards() {
	return cards;
}

}
