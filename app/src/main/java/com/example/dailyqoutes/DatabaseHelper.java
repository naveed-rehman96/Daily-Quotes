package com.example.dailyqoutes;

import android.content.ContentValues;
import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class DatabaseHelper extends SQLiteOpenHelper {


    public static final String DB_NAME = "MY_DB";
    public static final String KEY_QOUTES = "QUOTES";
    public static final String KEY_INDEX = "Q_ID";
    public static final String KEY_CATEGORY = "Q_CAT";
    public static final String KEY_FAVORITE = "Q_FAV";
    public static final String KEY_CHECK = "CH";




    public static final String M_Q = "MotivationalQoutes";
    public static final String I_Q = "InspirationalQoutes";
    public static final String P_Q = "PositiveQoutes";
    public static final String R_Q = "RelationshipQuotes";
    public static final String F_Q = "FriendshipQoutes";
    public static final String L_Q = "LifeQoutes";


    public DatabaseHelper(Context context ){
        super(context, DB_NAME , null , 1);
    }

    @Override
    public void onCreate(SQLiteDatabase db) {

        String createTable = "CREATE TABLE IF NOT EXISTS ALL_QOUTES (Q_ID INTEGER PRIMARY KEY AUTOINCREMENT ," +
                KEY_QOUTES +" TEXT ," +
                KEY_CATEGORY +" TEXT ," + KEY_CHECK+ " TEXT )";

            db.execSQL(createTable);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int oldVersion, int newVersion) {
        db.execSQL("DROP TABLE IF EXISTS ALL_QOUTES");
        onCreate(db);

    }

    public boolean Add_QOUTES_TO_DATABASE (String qoutes ,String category ){

        SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_QOUTES , qoutes);
        contentValues.put(KEY_CATEGORY , category);
        contentValues.put(KEY_CHECK , "unlike");

        long result = db.insert("ALL_QOUTES" , null , contentValues);
        return result != -1;
    }

//    public Cursor getAllData (String Category)
//    {
//        SQLiteDatabase db = getWritableDatabase();
//        String query = "SELECT Q_ID , QUOTES , Q_CAT FROM All_QOUTES WHERE Q_CAT =" + "'"+ Category+"'";
//        Cursor mCursor = db.rawQuery(query , null);
//        if (mCursor != null) {
//
//        }
//        return mCursor;
//
//    }

    public boolean addQouteToFavoriteList(String ID )
    {
            SQLiteDatabase db = getWritableDatabase();
        ContentValues contentValues = new ContentValues();

        contentValues.put(KEY_CHECK , "like");

        long result = db.update("All_QOUTES" ,contentValues , "Q_ID = ?" , new String[]{ID});

        return result != -1;

    }

    public boolean RemoveQouteFromFavorites (String index)
    {

        String filter  = KEY_INDEX +" = '"+index+"'";
        ContentValues cv = new ContentValues();
        cv.put(KEY_CHECK , "unlike");
        SQLiteDatabase db = getWritableDatabase();
        int num = db.update("All_QOUTES" , cv , filter ,null);
        return num == 1;
    }

    public Cursor fetch_Favorite_Qoutes()
    {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM All_QOUTES WHERE CH = 'like'" ;
        Cursor mCursor = db.rawQuery(query , null);
        if (mCursor != null) {
            mCursor.moveToFirst();
        }
        return mCursor;
    }


    public Cursor saveDataIntoModelClass (String category)
    {
        SQLiteDatabase db = getWritableDatabase();
        String query = "SELECT * FROM All_QOUTES WHERE Q_CAT = '"+category+"'";
        Cursor mCursor = db.rawQuery(query , null);
        if (mCursor != null) {

        }
        return mCursor;
    }

}
