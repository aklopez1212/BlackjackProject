package com.skilldistillery.cards.common;

import java.util.ArrayList;
import java.util.List;

public class Hand {
private List<Card> cards = new ArrayList<>();

public void addCard(Card card) {
	cards.add(card);
}
public int getHandValue() {
	int value = 0;
	for (Card card : cards) {
		value += card.getValue();
	} return value;
}
public void fold() {
	cards.clear();
}

}
