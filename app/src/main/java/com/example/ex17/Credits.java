package com.example.ex17;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class Credits extends AppCompatActivity {
    /**
     * @author        Etay Sabag
     * @version       1.0
     * @since         17/12/2021
     *
     * Credits class, display the credits for the app.
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_credits);
    }

    public void finish(View view) {
        finish();
    }
}