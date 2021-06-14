package com.ryanfermo.p_sixcalculator;

import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.view.menu.ShowableListMenu;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_page);
    }

    public void page1(View view) {
        Intent intent=new Intent(page.this, Home.class);
        startActivity(intent);
    }
    public void page2(View view) {
        Intent intent=new Intent(page.this, Home1.class);
        startActivity(intent);
    }
    public void page3(View view) {
        Intent intent=new Intent(page.this, Home2.class);
        startActivity(intent);
    }
    public void page5(View view) {
        Intent intent=new Intent(page.this, Home4.class);
        startActivity(intent);
    }
    public void page4(View view) {
        Intent intent=new Intent(page.this, Home3.class);
        startActivity(intent);
    }

    public void page6(View view) {
        Intent intent=new Intent(page.this, Home5.class);
        startActivity(intent);
    }

    public void back(View view) {
        finish();
        System.exit(0);
    }
}