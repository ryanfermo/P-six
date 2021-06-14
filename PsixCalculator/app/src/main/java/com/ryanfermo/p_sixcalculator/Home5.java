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

public class Home5 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, AdapterView.OnItemSelectedListener {
    private MenuItem item;
    private Spinner spinner,spinner2;
    ImageButton btn,home;
    EditText value1,value2;
    TextView first,second,result;
    Button calculate;
    double ryan=1;
    double v1,v2,compute,compute1;
    String un,uni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home5);
        value1=findViewById(R.id.editTextTextPersonName);
        value2=findViewById(R.id.editTextTextPersonName2);
        value1.setText("00");
        value2.setText("00");
        calculate=findViewById(R.id.button2);
        first=findViewById(R.id.textView2);
        second=findViewById(R.id.textView5);
        result=findViewById(R.id.textView3);
        btn=findViewById(R.id.imageButton);
        home=findViewById(R.id.imageButton2);
        spinner=findViewById(R.id.spinner);
        spinner2=findViewById(R.id.spinner2);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.unit11, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence>adapter1=ArrayAdapter.createFromResource(this,R.array.unit12, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Home5.this);
                builder.setTitle("Information");
                builder.setMessage("Kinetic energy is the energy that is possessed by a body due to its state of motion.\n" +
                        "\n" +
                        "E = 12mv^2 \nE=kinetic energy\nm=mass\nv=velocity");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss(); }
                });
                builder.show();
            }
        });
    }
    public void home5(View view) {
        Toast.makeText(this, "Proceeding to Home", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,page.class);
        startActivity(intent);
    }
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu5);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Kinetic Energy clicked", Toast.LENGTH_SHORT).show();
                first.setText("m :");
                second.setText("v :");
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan=1;
                return true;
            case R.id.item2:
                Toast.makeText(this, "Mass clicked", Toast.LENGTH_SHORT).show();
                first.setText("E :");
                second.setText("v :");
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan=2;
                return true;
            case R.id.item3:
                Toast.makeText(this, "Velocity clicked", Toast.LENGTH_SHORT).show();
                first.setText("E :");
                second.setText("m :");
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
        if(choice.equals("mg")){un="mg";}
        if(choice.equals("cg")){un="cg";}
        if(choice.equals("dg")){un="dg";}
        if(choice.equals("g")){un="g";}
        if(choice.equals("hg")){un="hg";}
        if(choice.equals("kg")){un="kg";}
        if(choice.equals("m/s")){uni="(m/s)";}
        if(choice.equals("unit")){uni="";un="";}
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
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            compute = (0.5 * v1 * (v2*v2));
            result.setText("Kinetic Energy=" + compute + " J\n\n E= 0.5*" + v1 + "*" + v2 + "\n=" + compute);
        }
        else if (ryan==2){
            if(v1==0 || v2==0){
                Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show();}
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            compute = ((2*v1) / v2);
            result.setText("Mass=" + compute + "" + un + "/" + uni + "\n\n m= (2*" + v1 + ")/" + v2 + "\n=" + compute);
        }
        else if (ryan==3){
            if(v1==0 || v2==0){
                Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show();}
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            compute = ((2*v1)/v2);
            compute1=(Math.sqrt(compute));
            result.setText("Velocity=" + compute1 + "" + un + "/" + uni + "\n\n v= √(2*" + v1 + ")/" + v2 + "\n=" + compute);
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