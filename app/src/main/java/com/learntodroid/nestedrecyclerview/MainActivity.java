package com.learntodroid.nestedrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.widget.LinearLayout;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity implements OnCardListChangeListener {
    RecyclerView recyclerView;
    CardListRecyclerAdapter cardListRecyclerAdapter;
    List<CardList> cardLists;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.activity_main_cardlists);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(RecyclerView.HORIZONTAL);

        recyclerView.setLayoutManager(linearLayoutManager);

        cardLists = new ArrayList<>();

        List<Card> toDoCards = new ArrayList<>();
        toDoCards.add(new Card("Eat Dinner"));
        toDoCards.add(new Card("Read Book"));
        toDoCards.add(new Card("Walk Dog"));
        cardLists.add(new CardList("To Do", toDoCards));

        List<Card> doingCards = new ArrayList<>();
        doingCards.add(new Card("Eat Lunch"));
        doingCards.add(new Card("Write Article"));
        cardLists.add(new CardList("Doing", doingCards));

        List<Card> doneCards = new ArrayList<>();
        doneCards.add(new Card("Brush Teeth"));
        doneCards.add(new Card("Make Bed"));
        doneCards.add(new Card("Wash Dishes"));
        cardLists.add(new CardList("Done", doneCards));

        cardListRecyclerAdapter = new CardListRecyclerAdapter(cardLists, this);
        recyclerView.setAdapter(cardListRecyclerAdapter);
    }

    @Override
    public void previousList(Card card, int currentListIndex) {
        cardLists.get(currentListIndex).getCards().remove(card);
        cardLists.get(currentListIndex-1).getCards().add(card);
        cardListRecyclerAdapter.setCardLists(cardLists);
    }

    @Override
    public void nextList(Card card, int currentListIndex) {
        cardLists.get(currentListIndex).getCards().remove(card);
        cardLists.get(currentListIndex+1).getCards().add(card);
        cardListRecyclerAdapter.setCardLists(cardLists);
    }
}