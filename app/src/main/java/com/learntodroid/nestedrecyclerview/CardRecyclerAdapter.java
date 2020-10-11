package com.learntodroid.nestedrecyclerview;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class CardRecyclerAdapter extends RecyclerView.Adapter<CardRecyclerAdapter.CardViewHolder> {
    List<Card> cards;
    int listIndex;
    int listSize;
    OnCardListChangeListener onCardListChangeListener;

    public CardRecyclerAdapter(List<Card> cards, int listIndex, int listSize, OnCardListChangeListener onCardListChangeListener) {
        this.cards = cards;
        this.listIndex = listIndex;
        this.listSize = listSize;
        this.onCardListChangeListener = onCardListChangeListener;
    }

    @NonNull
    @Override
    public CardViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_card, parent, false);
        return new CardViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull CardViewHolder holder, int position) {
        holder.bind(cards.get(position));
    }

    @Override
    public int getItemCount() {
        return cards.size();
    }

    class CardViewHolder extends RecyclerView.ViewHolder {
        TextView title;
        ImageView previous, next;

        public CardViewHolder(@NonNull View itemView) {
            super(itemView);

            title = itemView.findViewById(R.id.item_card_title);
            previous = itemView.findViewById(R.id.item_card_backward);
            next = itemView.findViewById(R.id.item_card_foreward);
        }

        public void bind(final Card card) {
            title.setText(card.getTitle());

            if (listIndex == 0) {
                previous.setVisibility(View.INVISIBLE);
            } else {
                previous.setVisibility(View.VISIBLE);
                previous.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onCardListChangeListener.previousList(card, listIndex);
                    }
                });
            }

            if (listIndex == (listSize-1)) {
                next.setVisibility(View.INVISIBLE);
            } else {
                next.setVisibility(View.VISIBLE);
                next.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        onCardListChangeListener.nextList(card, listIndex);
                    }
                });
            }
        }
    }
}
