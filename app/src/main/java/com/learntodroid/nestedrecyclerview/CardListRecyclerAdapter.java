package com.learntodroid.nestedrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardListRecyclerAdapter extends RecyclerView.Adapter<CardListRecyclerAdapter.CardListViewHolder> {
    List<CardList> cardLists;
    OnCardListChangeListener onCardListChangeListener;

    public CardListRecyclerAdapter(List<CardList> cardLists, OnCardListChangeListener onCardListChangeListener) {
        this.cardLists = cardLists;
        this.onCardListChangeListener = onCardListChangeListener;
    }

    @NonNull
    @Override
    public CardListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new CardListViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardListViewHolder holder, int position) {
        holder.bind(cardLists.get(position), position);
    }

    @Override
    public int getItemCount() {
        return cardLists.size();
    }

    public void setCardLists(List<CardList> cardLists) {
        this.cardLists = cardLists;
        notifyDataSetChanged();
    }

    class CardListViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        RecyclerView recyclerView;
        CardRecyclerAdapter cardRecyclerAdapter;

        public CardListViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.item_list_title);
            recyclerView = itemView.findViewById(R.id.item_list_cards);

            recyclerView.setLayoutManager(new LinearLayoutManager(itemView.getContext()));
        }

        public void bind(CardList cardList, int listIndex) {
            title.setText(cardList.getTitle());

            cardRecyclerAdapter = new CardRecyclerAdapter(cardList.getCards(), listIndex, cardLists.size(), onCardListChangeListener);
            recyclerView.setAdapter(cardRecyclerAdapter);
        }
    }
}
