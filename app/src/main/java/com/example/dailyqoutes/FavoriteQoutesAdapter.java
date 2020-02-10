package com.example.dailyqoutes;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;


public class FavoriteQoutesAdapter extends RecyclerView.Adapter<FavoriteQoutesAdapter.QuotesViewHolder> {

    ArrayList<FavoriteModelClass> ObjectList = null;
    Context context;
    OnNoteListner mOnNoteListner;
    public FavoriteQoutesAdapter(ArrayList<FavoriteModelClass> ObjectList, Context context , OnNoteListner mOnNoteListner) {
        this.ObjectList = ObjectList;
        this.context = context;
        this.mOnNoteListner = mOnNoteListner;

    }

    @NonNull
    @Override
    public QuotesViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(R.layout.list_favorit_qoute, viewGroup, false);
        return new QuotesViewHolder(view,mOnNoteListner);
    }

    @Override
    public void onBindViewHolder(@NonNull final QuotesViewHolder quotesViewHolder, final int i) {
        String[] colors = {"#448AFF", "#FFC107", "#009688", "#E91E63", "#FF5722"};
        final String quote = ObjectList.get(i).getQuote();


        quotesViewHolder.whatsappBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                shareWhatsapp(quote);

            }
        });

        quotesViewHolder.txtQuote.setText(quote);
        int color = i % colors.length;
        final int intColor = Color.parseColor(colors[color]);
        quotesViewHolder.quoteContainer.setBackgroundColor(intColor);

    }

    private void shareWhatsapp(String quote) {
        Intent sendIntent = new Intent();
        sendIntent.setAction(Intent.ACTION_SEND);
        sendIntent.putExtra(Intent.EXTRA_TEXT, quote);
        sendIntent.setType("text/plain");
        sendIntent.setPackage("com.whatsapp");
        context.startActivity(sendIntent);
    }

    @Override
    public int getItemCount() {
        return ObjectList.size();
    }

    public class QuotesViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {

        TextView txtQuote;
        LinearLayout quoteContainer;
        ImageButton whatsappBTN , FavoriteBTn;
        OnNoteListner listner;

        public QuotesViewHolder(@NonNull View itemView , OnNoteListner listner) {
            super(itemView);
            txtQuote = itemView.findViewById(R.id.txtQuote_fav);
            quoteContainer = itemView.findViewById(R.id.quoteContainer_fav);
            whatsappBTN = itemView.findViewById(R.id.shareWhatsappBtn_fav);
            FavoriteBTn = itemView.findViewById(R.id.favoriteBtn_fav);

            this.listner = listner;

            FavoriteBTn.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {

            listner.onNoteClick(getAdapterPosition());
        }
    }

    public interface OnNoteListner
    {
        void onNoteClick(int position);
    }
}
