package com.learntodroid.nestedrecyclerview;

import java.util.List;

public class CardList {
    private String title;
    private List<Card> cards;

    public CardList(String title, List<Card> cards) {
        this.title = title;
        this.cards = cards;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public List<Card> getCards() {
        return cards;
    }

    public void setCards(List<Card> cards) {
        this.cards = cards;
    }
}
