package com.ryanfermo.p_sixcalculator;

import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.PopupMenu;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.google.android.material.dialog.MaterialAlertDialogBuilder;
import com.google.android.material.snackbar.Snackbar;

import java.util.Objects;

public class Home extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, AdapterView.OnItemSelectedListener {
    private MenuItem item;
    private Spinner spinner,spinner2,spinner3;
    ImageButton btn,home;
    EditText value1,value2;
    TextView first,second,result,answer;
    Button calculate;
    double ryan=1;
    double v1,v2,compute,con1,con2;
    String u,i,spd;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        value1=findViewById(R.id.editTextTextPersonName);
        value2=findViewById(R.id.editTextTextPersonName2);
        value1.setText("00");
        value2.setText("00");
        answer=findViewById(R.id.textView7);
        calculate=findViewById(R.id.button2);
        first=findViewById(R.id.textView2);
        second=findViewById(R.id.textView5);
        result=findViewById(R.id.textView3);
        btn=findViewById(R.id.imageButton);
        home=findViewById(R.id.imageButton2);
        spinner=findViewById(R.id.spinner);
        spinner2=findViewById(R.id.spinner2);
        spinner3=findViewById(R.id.spinner3);
        ArrayAdapter<CharSequence>adapter=ArrayAdapter.createFromResource(this,R.array.unit, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
       ArrayAdapter<CharSequence>adapter1=ArrayAdapter.createFromResource(this,R.array.unit1, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence>adapter2=ArrayAdapter.createFromResource(this,R.array.speed, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner3.setAdapter(adapter2);
        spinner3.setOnItemSelectedListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Home.this);
                builder.setTitle("Information");
                builder.setMessage("The average speed is the average of speed of a moving body for the overall distance that it has covered.\ns=d/t\ns=speed\nd=distance\nt=time");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss(); }
                });
                builder.show();
            }
        });
    }
    public void home(View view) {
        Toast.makeText(this, "Proceeding to Home", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,page.class);
        startActivity(intent);
    }
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Speed clicked", Toast.LENGTH_SHORT).show();
                first.setText("d :");
                second.setText("t :");
                answer.setVisibility(View.VISIBLE);
                spinner3.setVisibility(View.VISIBLE);
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan=1;
                return true;
            case R.id.item2:
                Toast.makeText(this, "Distance clicked", Toast.LENGTH_SHORT).show();
                first.setText("s :");
                second.setText("t :");
                answer.setVisibility(View.GONE);
                spinner3.setVisibility(View.GONE);
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan=2;
                return true;
            case R.id.item3:
                Toast.makeText(this, "Time clicked", Toast.LENGTH_SHORT).show();
                first.setText("d :");
                second.setText("s :");
                answer.setVisibility(View.GONE);
                spinner3.setVisibility(View.GONE);
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan=3;
                return true;
            default:
                return false;
        }

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice=parent.getItemAtPosition(position).toString();
        if(choice.equals("cm")){u="cm";}
        if(choice.equals("m")){u="m";}
        if(choice.equals("km")){u="km";}
        if(choice.equals("sec")){i="sec";}
        if(choice.equals("min")){i="min";}
        if(choice.equals("hr")){i="hr";}
        if(choice.equals("km/sec")){spd="km/sec";}
        if(choice.equals("km/min")){ spd="km/min";}
        if(choice.equals("km/hr")){spd="km/hr";}
        if(spd=="km/sec"){
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            if (u=="km"){
                con1=v1*1;
            }
            else if (u=="m"){
                con1=v1*1000;
            }
            else if (u=="cm"){
                con1=v1*10000;
            }
            else {}
            if(i=="sec"){
                con2=v2/1;
            }
            else if(i=="min"){
                con2=v2/60;
            }
            else if(i=="hr"){
                con2=v2/60/60;
            }}
        if(spd=="km/min"){
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            if (u=="km"){
                con1=v1*1;
            }
            else if (u=="m"){
                con1=v1*1000;
            }
            else if (u=="cm"){
                con1=v1*10000;
            }
            else {}
            if(i=="sec"){
                con2=v2*60;
            }
            else if(i=="min"){
                con2=v2/1;
            }
            else if(i=="hr"){
                con2=v2/60;
            }}
        if(spd=="km/hr"){
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            if (u=="km"){
                con1=v1*1;
            }
            else if (u=="m"){
                con1=v1*1000;
            }
            else if (u=="cm"){
                con1=v1*10000;
            }
            else {}
            if(i=="sec"){
                con2=v2*60*60;
            }
            else if(i=="min"){
                con2=v2*60;
            }
            else if(i=="hr"){
                con2=v2/1;
            }else {}
        }
    }
    @Override
    public void onNothingSelected(AdapterView<?> parent) {
    }
    public void btnfunction(View view) {
        if ((value1.getText().toString().trim().length() > 0) && (value1.getText().toString().trim().length() > 0)){
            v1 = Double.parseDouble(value1.getText().toString().trim());
            v2 = Double.parseDouble(value2.getText().toString().trim());
        }
        if (ryan==1){
            if(v1==0 || v2==0){
                Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show();}
            compute = con1 / con2;
            result.setText("Speeed=" + compute + ""+spd+"\n\n s=" + v1 + "/" + v2 + "\n=" + compute);
        }
        else if (ryan==2) {
            if(v1==0 || v2==0){
                Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show();}
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            compute = v1 * v2;
            result.setText("Distance=" + compute + ""+ u +"\n\n s=" + v1 + "*" + v2 + "\n=" + compute);
        }
        else if (ryan==3) {
            if (v1==0 || v2==0) {
                Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show(); }
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            compute = v1 / v2;
            result.setText("Time=" + compute + ""+ i +"\n\n s=" + v1 + "/" + v2 + "\n=" + compute);
        }
        else{Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show();}
    }

    public void back(View view) {
        finish();
        System.exit(0);
    }

    public void clear(View view) {
        value1.setText("00");
        value2.setText("00");
        result.setText("");
    }
}