package com.yee.myapplication;

import android.support.annotation.NonNull;
import android.support.design.internal.BottomNavigationItemView;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.Window;
import android.widget.FrameLayout;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        BottomNavigationView bottomNavigationView = (BottomNavigationView) findViewById(R.id.navbot);
        BottomNavigationViewHelper.removeShiftMode(bottomNavigationView);
        bottomNavigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                if(item.getItemId() == R.id.subway){
                    //do something
                    Toast.makeText(MainActivity.this, "Ahyeon", Toast.LENGTH_SHORT).show();
                }

                else if(item.getItemId() == R.id.bus){
                    //do something
                    Toast.makeText(MainActivity.this, "Ahhyeon", Toast.LENGTH_SHORT).show();
                }

                else if(item.getItemId() == R.id.taxi){
                    //do something
                    Toast.makeText(MainActivity.this, "Ahhhyeon", Toast.LENGTH_SHORT).show();
                }

                else if(item.getItemId() == R.id.food){
                    //do something
                    Toast.makeText(MainActivity.this, "Ahhhhyeon", Toast.LENGTH_SHORT).show();
                }

                else if(item.getItemId() == R.id.emergency){
                    //do something
                    Toast.makeText(MainActivity.this, "Ahhhhhyeon", Toast.LENGTH_SHORT).show();
                }
                return true;
            }
        });
    }
}
