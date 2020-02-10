package com.example.dailyqoutes;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.database.Cursor;
import android.os.Bundle;
import android.widget.Toast;

import java.util.ArrayList;

public class FavoritesQuotes extends AppCompatActivity implements FavoriteQoutesAdapter.OnNoteListner {

    DatabaseHelper mDatabaseHelper;
    ArrayList<FavoriteModelClass> favoriteModelClassOBJECT;
    private RecyclerView.Adapter mAdapter;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_favorites_quotes);
        mDatabaseHelper = new DatabaseHelper(this);
        favoriteModelClassOBJECT = new ArrayList<>();
        PopulateListView();




    }

    public void PopulateListView ()
    {
        Cursor All_column_data = mDatabaseHelper.fetch_Favorite_Qoutes();

        while (All_column_data.moveToNext())
        {
            FavoriteModelClass object = new FavoriteModelClass();
            object.setID(All_column_data.getString(0));
            object.setCheck(All_column_data.getColumnName(3));
            object.setQuote(All_column_data.getString(1));
            object.setCheck(All_column_data.getColumnName(2));
            favoriteModelClassOBJECT.add(object);

        }
        RecyclerView quoteList = findViewById(R.id.quoteFavoritlist);
        quoteList.setLayoutManager(new LinearLayoutManager(this ));
        mAdapter =new FavoriteQoutesAdapter(favoriteModelClassOBJECT, this ,this);
        quoteList.setAdapter(mAdapter);
        mAdapter.notifyDataSetChanged ();
        Toast.makeText(FavoritesQuotes.this , "List Populated Successfully" , Toast.LENGTH_SHORT).show();
    }

    public void RemoveQouteFromFavorite(final String position , int pos)
    {

        boolean removeQoute = mDatabaseHelper.RemoveQouteFromFavorites(position);
        if(removeQoute)
        {
            Toast.makeText(FavoritesQuotes.this , "Quote Is Removed From Favorites" , Toast.LENGTH_SHORT).show();
            favoriteModelClassOBJECT.remove(position);
            favoriteModelClassOBJECT.remove(pos);
            mAdapter.notifyDataSetChanged();

        }
        else
        {

            Toast.makeText(FavoritesQuotes.this , "Unsuccessfull" , Toast.LENGTH_SHORT).show();
        }

    }
    @Override
    public void onNoteClick(int position)
    {
        favoriteModelClassOBJECT.get(position).getQuote();
        RemoveQouteFromFavorite(favoriteModelClassOBJECT.get(position).getID() ,position);
    }
}
