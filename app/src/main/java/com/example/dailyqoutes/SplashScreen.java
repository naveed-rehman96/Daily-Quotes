package com.example.dailyqoutes;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;

public class SplashScreen extends AppCompatActivity {

    DatabaseHelper mDatabaseHelper;
    public static final String M_Q = "MotivationalQoutes";
    public static final String I_Q = "InspirationalQoutes";
    public static final String P_Q = "PositiveQoutes";
    public static final String R_Q = "RelationshipQuotes";
    public static final String F_Q = "FriendshipQoutes";
    public static final String L_Q = "LifeQoutes";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash_screen);
        mDatabaseHelper = new DatabaseHelper(this);

        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(!prefs.getBoolean("firstTime", false)) {
            // run your one time code
            // Inserting Shops

            Log.d("Insert: ", "Inserting ..");

            AddFriendshipQoutesToDatabase();
            AddInspirationalQoutesToDatabase();
            AddLifeQoutesToDatabase();
            AddMoticationalQoutesToDatabase();
            AddPositiveQoutesToDatabase();
            AddRelationShipQoutesToDatabase();
            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.apply();

        }

        Thread thread = new Thread() {
            @Override
            public void run() {
                try {
                    sleep(1000);
                } catch (Exception e) {
                    e.printStackTrace();
                } finally {



                    Intent mainIntent = new Intent(SplashScreen.this, MainActivity.class);
                    startActivity(mainIntent);
                }
            }
        };
        thread.start();



    }

    @Override
    protected void onPause() {
        super.onPause();

        finish();
    }

    public void AddMoticationalQoutesToDatabase ()
    {
        ArrayList<String> motivationalQoutes = new ArrayList<>();
        boolean check = false;
        motivationalQoutes.add("Look up at the stars and not down at your feet. Try to make sense of what you see, and wonder about what makes the universe exist. Be curious");
        motivationalQoutes.add("I am just a child who has never grown up. I still keep asking these 'how' and 'why' questions. Occasionally, I find an answer.");
        motivationalQoutes.add("I would like nuclear fusion to become a practical power source. It would provide an inexhaustible supply of energy, without pollution or global warming.");
        motivationalQoutes.add("Science is beautiful when it makes simple explanations of phenomena or connections between different observations. Examples include the double helix in biology and the fundamental equations of physics");
        motivationalQoutes.add("Beginning today, treat everyone you meet as if they were going to be dead by midnight. Extend to them all the care, kindness and understanding you can muster, and do it with no thought of any reward. Your life will never be the same again");

        for (int i = 0 ; i < motivationalQoutes.size() ; i++ )
        {

            check = mDatabaseHelper.Add_QOUTES_TO_DATABASE(motivationalQoutes.get(i) , M_Q );

        }
        if (check)
        {
            Toast.makeText(SplashScreen.this , "Added Succesfully" , Toast.LENGTH_SHORT).show();
        }
    }

    public void AddInspirationalQoutesToDatabase()
    {ArrayList<String> motivationalQoutes = new ArrayList<>();
        boolean check = false;
        motivationalQoutes.add("Look up at the stars and not down at your feet. Try to make sense of what you see, and wonder about what makes the universe exist. Be curious");
        motivationalQoutes.add("I am just a child who has never grown up. I still keep asking these 'how' and 'why' questions. Occasionally, I find an answer.");
        motivationalQoutes.add("I would like nuclear fusion to become a practical power source. It would provide an inexhaustible supply of energy, without pollution or global warming.");
        motivationalQoutes.add("Science is beautiful when it makes simple explanations of phenomena or connections between different observations. Examples include the double helix in biology and the fundamental equations of physics");
        motivationalQoutes.add("Beginning today, treat everyone you meet as if they were going to be dead by midnight. Extend to them all the care, kindness and understanding you can muster, and do it with no thought of any reward. Your life will never be the same again");

        for (int i = 0 ; i<motivationalQoutes.size() ; i++ )
        {
            check = mDatabaseHelper.Add_QOUTES_TO_DATABASE(motivationalQoutes.get(i) , I_Q );
        }
        if (check)
        {
            Toast.makeText(SplashScreen.this , "Added Succesfully" , Toast.LENGTH_SHORT).show();
        }
        else
        {
            Toast.makeText(SplashScreen.this , "Not Added Succesfully" , Toast.LENGTH_SHORT).show();
        }


    }
    public void AddLifeQoutesToDatabase()
    {
        ArrayList<String> motivationalQoutes = new ArrayList<>();
        boolean check = false;
        motivationalQoutes.add("Look up at the stars and not down at your feet. Try to make sense of what you see, and wonder about what makes the universe exist. Be curious");
        motivationalQoutes.add("I am just a child who has never grown up. I still keep asking these 'how' and 'why' questions. Occasionally, I find an answer.");
        motivationalQoutes.add("I would like nuclear fusion to become a practical power source. It would provide an inexhaustible supply of energy, without pollution or global warming.");
        motivationalQoutes.add("Science is beautiful when it makes simple explanations of phenomena or connections between different observations. Examples include the double helix in biology and the fundamental equations of physics");
        motivationalQoutes.add("Beginning today, treat everyone you meet as if they were going to be dead by midnight. Extend to them all the care, kindness and understanding you can muster, and do it with no thought of any reward. Your life will never be the same again");

        for (int i = 0 ; i<motivationalQoutes.size() ; i++ )
        {
            check = mDatabaseHelper.Add_QOUTES_TO_DATABASE(motivationalQoutes.get(i) , L_Q );
        }
        if (check)
        {
            Toast.makeText(SplashScreen.this , "Added Succesfully" , Toast.LENGTH_SHORT).show();
        }
    }

    public void AddFriendshipQoutesToDatabase()
    {
        ArrayList<String> motivationalQoutes = new ArrayList<>();
        boolean check = false;
        motivationalQoutes.add("Look up at the stars and not down at your feet. Try to make sense of what you see, and wonder about what makes the universe exist. Be curious");
        motivationalQoutes.add("I am just a child who has never grown up. I still keep asking these 'how' and 'why' questions. Occasionally, I find an answer.");
        motivationalQoutes.add("I would like nuclear fusion to become a practical power source. It would provide an inexhaustible supply of energy, without pollution or global warming.");
        motivationalQoutes.add("Science is beautiful when it makes simple explanations of phenomena or connections between different observations. Examples include the double helix in biology and the fundamental equations of physics");
        motivationalQoutes.add("Beginning today, treat everyone you meet as if they were going to be dead by midnight. Extend to them all the care, kindness and understanding you can muster, and do it with no thought of any reward. Your life will never be the same again");

        for (int i = 0 ; i<motivationalQoutes.size() ; i++ )
        {
            check = mDatabaseHelper.Add_QOUTES_TO_DATABASE(motivationalQoutes.get(i) , F_Q);
        }
        if (check)
        {
            Toast.makeText(SplashScreen.this , "Added Succesfully" , Toast.LENGTH_SHORT).show();
        }
    }
    public void AddPositiveQoutesToDatabase()
    {
        ArrayList<String> motivationalQoutes = new ArrayList<>();
        boolean check = false;
        motivationalQoutes.add("Look up at the stars and not down at your feet. Try to make sense of what you see, and wonder about what makes the universe exist. Be curious");
        motivationalQoutes.add("I am just a child who has never grown up. I still keep asking these 'how' and 'why' questions. Occasionally, I find an answer.");
        motivationalQoutes.add("I would like nuclear fusion to become a practical power source. It would provide an inexhaustible supply of energy, without pollution or global warming.");
        motivationalQoutes.add("Science is beautiful when it makes simple explanations of phenomena or connections between different observations. Examples include the double helix in biology and the fundamental equations of physics");
        motivationalQoutes.add("Beginning today, treat everyone you meet as if they were going to be dead by midnight. Extend to them all the care, kindness and understanding you can muster, and do it with no thought of any reward. Your life will never be the same again");

        for (int i = 0 ; i<motivationalQoutes.size() ; i++ )
        {
            check = mDatabaseHelper.Add_QOUTES_TO_DATABASE(motivationalQoutes.get(i) , P_Q);
        }
        if (check)
        {
            Toast.makeText(SplashScreen.this , "Added Succesfully" , Toast.LENGTH_SHORT).show();
        }
    }
    public void AddRelationShipQoutesToDatabase()
    {
        ArrayList<String> motivationalQoutes = new ArrayList<>();
        boolean check = false;
        motivationalQoutes.add("Look up at the stars and not down at your feet. Try to make sense of what you see, and wonder about what makes the universe exist. Be curious");
        motivationalQoutes.add("I am just a child who has never grown up. I still keep asking these 'how' and 'why' questions. Occasionally, I find an answer.");
        motivationalQoutes.add("I would like nuclear fusion to become a practical power source. It would provide an inexhaustible supply of energy, without pollution or global warming.");
        motivationalQoutes.add("Science is beautiful when it makes simple explanations of phenomena or connections between different observations. Examples include the double helix in biology and the fundamental equations of physics");
        motivationalQoutes.add("Beginning today, treat everyone you meet as if they were going to be dead by midnight. Extend to them all the care, kindness and understanding you can muster, and do it with no thought of any reward. Your life will never be the same again");

        for (int i = 0 ; i<motivationalQoutes.size() ; i++ )
        {
           check =  mDatabaseHelper.Add_QOUTES_TO_DATABASE(motivationalQoutes.get(i) , R_Q);
        }
        if (check)
        {
            Toast.makeText(SplashScreen.this , "Added Succesfully" , Toast.LENGTH_SHORT).show();
        }
    }



}
