package com.thomas.siadous.moodtracker;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.DisplayMetrics;
import android.util.Log;
import android.view.View;
import android.widget.ImageButton;
import android.widget.TextView;
import android.widget.Toast;

/**
 * HistoryActivity class permit to display the mood history
 */
public class HistoryActivity extends AppCompatActivity {

    /**
     * VARIABLES
     */
    private SharedPreferences mPreferencesHistory;
    private String mComment;
    TextView mDisplayComment;
    ImageButton mToastComment;
    int mColorTest = R.color.banana_yellow;

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

        //mDisplayComment.setBackgroundResource(R.color.banana_yellow);

        /* RelativeLayout layout = findViewById(R.id.relativeLayout);
        RelativeLayout.LayoutParams layoutParams = (RelativeLayout.LayoutParams) layout.getLayoutParams();
        layoutParams.height = dpToPx(1280);
        layoutParams.width = dpToPx(768);
        layout.setLayoutParams(layoutParams);
        */

    }

    private int dpToPx(int dp) {
        return Math.round(dp*(getResources().getDisplayMetrics().xdpi/ DisplayMetrics.DENSITY_DEFAULT));
    }




}