package vn.edu.activestudy.activestudy.view.activity;


import android.app.Dialog;
import android.content.DialogInterface;
import android.graphics.drawable.ColorDrawable;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RatingBar;

import vn.edu.activestudy.activestudy.R;

public class ProfileActivity extends AppCompatActivity {
    RatingBar ratingBar;
    Button btnMongMuon;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_profile);
        initUI();
        initData();
        initControl();
    }


    private void initUI() {
        getSupportActionBar().setHomeButtonEnabled(true);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setBackgroundDrawable(new ColorDrawable(getResources().getColor(R.color.background_app)));
        ratingBar = (RatingBar) findViewById(R.id.ratingBar);
        btnMongMuon = (Button) findViewById(R.id.btnMongMuon);
    }

    private void initData() {

    }

    private void initControl() {
        btnMongMuon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                onMongMuon();
            }
        });
        ratingBar.setOnRatingBarChangeListener(new RatingBar.OnRatingBarChangeListener() {
            @Override
            public void onRatingChanged(RatingBar ratingBar, float rating, boolean fromUser) {
                showDialogRating();
            }
        });
    }

    private void onMongMuon() {
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_desire);
        dialog.setTitle("Mong muốn");

        // set the custom dialog components - text, image and button
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancelDesire);
        Button btnOk = (Button) dialog.findViewById(R.id.btnOkDesire);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    private void showDialogRating() {
        // custom dialog
//        LayoutInflater inflater = LayoutInflater.from(this);
//        View dialogLayout = inflater.inflate(R.layout.custom_dialog_rating, null);
//        AlertDialog.Builder builder = new AlertDialog.Builder(this);
//        builder.setView(dialogLayout);
//        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
//            @Override
//            public void onClick(DialogInterface dialog, int which) {
//
//            }
//        });
//        builder.show();
        final Dialog dialog = new Dialog(this);
        dialog.setContentView(R.layout.custom_dialog_rating);
        dialog.setTitle("Kỹ năng");

        // set the custom dialog components - text, image and button
        RatingBar ratingBarJava = (RatingBar) dialog.findViewById(R.id.ratingBarJava);
        RatingBar ratingBarCSharp = (RatingBar) dialog.findViewById(R.id.ratingBarCSharp);
        Button btnCancel = (Button) dialog.findViewById(R.id.btnCancelRating);
        Button btnOk = (Button) dialog.findViewById(R.id.btnOkRating);
        btnCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.cancel();
            }
        });
        dialog.show();
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_profile, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings) {
            return true;
        }
        if (id == android.R.id.home) {
            finish();
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
