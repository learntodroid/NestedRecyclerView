package com.learntodroid.nestedrecyclerview;

public interface OnCardListChangeListener {
    void previousList(Card card, int currentListIndex);
    void nextList(Card card, int currentListIndex);
}
