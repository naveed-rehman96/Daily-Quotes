package com.example.dailyqoutes;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.TextView;
import android.widget.Toast;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;

public class QoutesActivity extends AppCompatActivity implements QuotesAdapter.OnNoteListner {

    String filename;
    String qoutesTitle;
    TextView title;
    RecyclerView quoteList;

    DatabaseHelper mDatabaseHelper;
    ArrayList<QuoteModelClass> quoteModelObject ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_qoutes);

        Intent intent = getIntent();
         filename = intent.getStringExtra("file");
         qoutesTitle = intent.getStringExtra("title");

         title = findViewById(R.id.text_qoutes_title);
         title.setText(qoutesTitle);
         mDatabaseHelper = new DatabaseHelper(this);
        quoteList = findViewById(R.id.quoteList);
        quoteModelObject = new ArrayList<>();
        PopulateListView();

    }

    public void QouteAddedToFavorites (String quote , String id)
    {
        boolean insertData = mDatabaseHelper.addQouteToFavoriteList(id);
        if (insertData)
        {
            Toast.makeText(QoutesActivity.this ,"Added To Favorite Quotes List" , Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(QoutesActivity.this ,"Added To Favorite Quotes List" , Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public void onNoteClick(int position) {

        Toast.makeText(this , quoteModelObject.get(position).getQuote() , Toast.LENGTH_SHORT ).show();
        QouteAddedToFavorites(quoteModelObject.get(position).getQuote() , quoteModelObject.get(position).getID());


    }

    public void PopulateListView ()
    {
        Cursor All_column_data = mDatabaseHelper.saveDataIntoModelClass(qoutesTitle);

        while (All_column_data.moveToNext())
        {
            QuoteModelClass object = new QuoteModelClass();
            object.setID(All_column_data.getString(0));
            object.setCheck(All_column_data.getColumnName(3));
            object.setQuote(All_column_data.getString(1));
            object.setCheck(All_column_data.getColumnName(2));
            quoteModelObject.add(object);

        }

        quoteList.setLayoutManager(new LinearLayoutManager(this ));
        quoteList.setAdapter(new QuotesAdapter(quoteModelObject, this ,this));
        Toast.makeText(QoutesActivity.this , "List Populated Successfully" , Toast.LENGTH_SHORT).show();
    }

}




