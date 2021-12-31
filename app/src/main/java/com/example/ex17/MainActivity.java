package com.example.ex17;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    /**
     * @author        Etay Sabag
     * @version       1.2
     * @since         17/12/2021
     *
     * MainActivity class, the main screen.
     * The class contains functions that are linked to each button in the app.
     */


    AlertDialog.Builder adb1,adb2,adb3;
    ConstraintLayout cl;
    Intent si;
    final String[] colors = {"Red","Green","Blue"};


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        cl = (ConstraintLayout) findViewById(R.id.cl);
        si = new Intent(this,Credits.class);
    }



    public void run1(View view) {
        /**
         * The method opens the dialog that lets you choose the color of the background.
         *
         * @param view
         */
        int[] color = new int[]{0,0,0};
        adb1 = new AlertDialog.Builder(this);
        adb1.setTitle("Choose color");

        adb1.setItems(colors, new DialogInterface.OnClickListener(){
            @Override
            public void onClick(DialogInterface dialog, int which) {
                color[which]=255;
                cl.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        adb1.setPositiveButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb1.setCancelable(false);
        adb1.create().show();
    }

    public void run2(View view) {
        /**
         * The method opens the dialog that lets you choose the combination of
         * the background color.
         *
         * @param view
         */
        int[] color = new int[]{0,0,0};
        adb2 = new AlertDialog.Builder(this);
        adb2.setTitle("Choose color");

        adb2.setMultiChoiceItems(colors, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked) color[which]=255;
                else if (color[which]==255) color[which]=0;
            }
        });
        adb2.setPositiveButton("Ok",new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                cl.setBackgroundColor(Color.rgb(color[0],color[1],color[2]));
            }
        });
        adb2.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });
        adb2.setCancelable(false);
        adb2.create().show();
    }


    public void run3(View view) {
        /**
         * The method will change the background color to white.
         * @param view
         */
        cl.setBackgroundColor(Color.rgb(255,255,255));
    }


    public void run4(View view) {
        /**
         * The method will open a dialog that can display in a toast the input of the user.
         * @param view
         */
        adb3 = new AlertDialog.Builder(this);
        adb3.setTitle("enter text");

        final EditText eT = new EditText(this);
        eT.setHint("Enter Text");
        adb3.setView(eT);

        adb3.setNegativeButton("Cancel",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.cancel();
            }
        });

        adb3.setPositiveButton("Okay",new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(getApplicationContext(), eT.getText().toString(), Toast.LENGTH_LONG).show();
            }
        });

        adb3.setCancelable(false);
        adb3.create().show();
    }


    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.main,menu);
        return true;
    }
    public boolean onOptionsItemSelected(MenuItem item) {
        if (item.getItemId() == R.id.menuCredits){
            startActivityForResult(si, 1);
        }
        return true;
    }
}
