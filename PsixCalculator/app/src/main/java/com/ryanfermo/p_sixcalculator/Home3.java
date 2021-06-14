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

public class Home3 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, AdapterView.OnItemSelectedListener {
    private MenuItem item;
    private Spinner spinner,spinner2;
    ImageButton btn,home;
    EditText value1,value2;
    TextView first,second,result;
    Button calculate;
    double ryan=1;
    double v1,v2,compute;
    String un,uni;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home3);
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
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.unit7, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence>adapter1=ArrayAdapter.createFromResource(this,R.array.unit8, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Home3.this);
                builder.setTitle("Information");
                builder.setMessage("Ohms law says that the current running through some conductor material is directly proportional to the potential difference between two endpoints of the conductor.\n" +
                        "\n" +
                        "V= I × R\nV=voltage\nI=current\nR=resistance");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss(); }
                });
                builder.show();
            }
        });
    }
    public void home3(View view) {
        Toast.makeText(this, "Proceeding to Home", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,page.class);
        startActivity(intent);
    }
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu3);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Currrent clicked", Toast.LENGTH_SHORT).show();
                first.setText("V :");
                second.setText("R :");
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan=1;
                return true;
            case R.id.item2:
                Toast.makeText(this, "Voltage clicked", Toast.LENGTH_SHORT).show();
                first.setText("I :");
                second.setText("R :");
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan=2;
                return true;
            case R.id.item3:
                Toast.makeText(this, "Resistance clicked", Toast.LENGTH_SHORT).show();
                first.setText("V :");
                second.setText("I :");
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan=3;
                return true;
            case R.id.item4:
                Toast.makeText(this, "Power clicked", Toast.LENGTH_SHORT).show();
                first.setText("V :");
                second.setText("I :");
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan=4;
                return true;
            default:
                return false;
        }

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice=parent.getItemAtPosition(position).toString();
        if(choice.equals("volt")){un="volt";}
        if(choice.equals("ohm")){un="ohm";}
        if(choice.equals("amp")){un="amp";}
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
                compute = v1 / v2;
                result.setText("Current=" + compute + " Amp\n\n I=" + v1 + "/" + v2 + "\n=" + compute);
            }else if (ryan==2) {
            if(v1==0 || v2==0){
                Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show();}
                v1 = Double.parseDouble(value1.getText().toString());
                v2 = Double.parseDouble(value2.getText().toString());
                compute = v1 * v2;
                result.setText("Voltage=" + compute + " Volt\n\n V=" + v1 + "*" + v2 + "\n=" + compute);
            } else if (ryan==3) {
            if (v1==0 || v2==0) {
                Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show(); }
                v1 = Double.parseDouble(value1.getText().toString());
                v2 = Double.parseDouble(value2.getText().toString());
                compute = v1 / v2;
                result.setText("Resistance=" + compute + " ohm\n\n R=" + v1 + "/" + v2 + "\n=" + compute);
            } else if (ryan==4) {
            if (v1==0 || v2==0) {
                Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show(); }
                v1 = Double.parseDouble(value1.getText().toString());
                v2 = Double.parseDouble(value2.getText().toString());
                compute = v1 * v2;
                result.setText("Power=" + compute + "watt\n\n P=" + v1 + "*" + v2 + "\n=" + compute);
            } else {Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show();}
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