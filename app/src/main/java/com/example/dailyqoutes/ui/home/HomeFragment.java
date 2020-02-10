package com.example.dailyqoutes.ui.home;

import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.dailyqoutes.QoutesActivity;
import com.example.dailyqoutes.R;

public class HomeFragment extends Fragment {

    private HomeViewModel homeViewModel;
    private Button inspirational_btn , positive_btn , motivational_btn , friendship_btn , relationship_btn , life_btn;
    public static final String M_Q = "MotivationalQoutes";
    public static final String I_Q = "InspirationalQoutes";
    public static final String P_Q = "PositiveQoutes";
    public static final String R_Q = "RelationshipQuotes";
    public static final String F_Q = "FriendshipQoutes";
    public static final String L_Q = "LifeQoutes";

    public View onCreateView(@NonNull final LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        homeViewModel =
                ViewModelProviders.of(this).get(HomeViewModel.class);
        View root = inflater.inflate(R.layout.fragment_home, container, false);
        //final TextView textView = root.findViewById(R.id.text_home);

        inspirational_btn = root.findViewById(R.id.inspirationalbtn);
        positive_btn = root.findViewById(R.id.positivebtn);
        motivational_btn = root.findViewById(R.id.motivationbtn);
        friendship_btn = root.findViewById(R.id.friendshipbtn);
        relationship_btn = root.findViewById(R.id.relatonshipbtn);
        life_btn = root.findViewById(R.id.lifebtn);


        motivational_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , QoutesActivity.class);
                intent.putExtra("file","M_Qoutes");
                intent.putExtra("title",M_Q);
                startActivity(intent);
            }
        });
        inspirational_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , QoutesActivity.class);
                intent.putExtra("file","I_Qoutes");
                intent.putExtra("title",I_Q);
                startActivity(intent);
            }
        });
        positive_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , QoutesActivity.class);
                intent.putExtra("file","P_Qoutes");
                intent.putExtra("title",P_Q);

                startActivity(intent);
            }
        });
        life_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , QoutesActivity.class);
                intent.putExtra("file","L_Qoutes");
                intent.putExtra("title",L_Q);
                startActivity(intent);
            }
        });
        friendship_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , QoutesActivity.class);
                intent.putExtra("file","F_Qoutes");
                intent.putExtra("title",F_Q);
                startActivity(intent);
            }
        });

        relationship_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getActivity() , QoutesActivity.class);
                intent.putExtra("file","R_Qoutes");
                intent.putExtra("title",R_Q);
                startActivity(intent);
            }
        });
        homeViewModel.getText().observe(this, new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }
}