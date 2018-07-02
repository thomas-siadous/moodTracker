package com.thomas.siadous.moodtracker.controller;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;


import com.thomas.siadous.moodtracker.R;

public class HistoryActivity extends AppCompatActivity {


    private SharedPreferences mPreferencesHistory;
    private String mComment;
    TextView mDisplayComment;
    ImageButton mToastComment;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_history);

        mDisplayComment = findViewById(R.id.comment_test_preferences);
        mToastComment = findViewById(R.id.comment_toast_imageButton_history);
        Log.d("DEBUG", "Enter onCreate");

        mToastComment.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Log.d("DEBUG", "Enter onClick");
                mPreferencesHistory = getSharedPreferences(MainActivity.PREFERENCE_FILE, MODE_PRIVATE);
                mComment = mPreferencesHistory.getString(MainActivity.PREF_KEY_COMMENT, "Comments");
                Toast msg = Toast.makeText(HistoryActivity.this, mComment, Toast.LENGTH_SHORT);
                msg.show();
            }
        });

        mDisplayComment.setText("Hier");



    }


}
