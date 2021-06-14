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

public class Home4 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, AdapterView.OnItemSelectedListener {
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
        setContentView(R.layout.activity_home4);
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
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.unit9, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence>adapter1=ArrayAdapter.createFromResource(this,R.array.unit10, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Home4.this);
                builder.setTitle("Information");
                builder.setMessage("Frequency is the revolutions completed per second or as the number of wave cycles.\n" +
                        "\n" +
                        "f= V/λ\nf=frequency\nV=velocity\nλ=wavelength");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss(); }
                });
                builder.show();
            }
        });
    }
    public void home4(View view) {
        Toast.makeText(this, "Proceeding to Home", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,page.class);
        startActivity(intent);
    }
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu4);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Frequency clicked", Toast.LENGTH_SHORT).show();
                first.setText("v :");
                second.setText("λ :");
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan=1;
                return true;
            case R.id.item2:
                Toast.makeText(this, "Velocity clicked", Toast.LENGTH_SHORT).show();
                first.setText("λ :");
                second.setText("f :");
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan=2;
                return true;
            case R.id.item3:
                Toast.makeText(this, "Wavelength clicked", Toast.LENGTH_SHORT).show();
                first.setText("v :");
                second.setText("f :");
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
        if(choice.equals("m/s")){un="m/s";}
        if(choice.equals("Hz")){un="Hz";}
        if(choice.equals("cm")){un="cm";}
        if(choice.equals("m")){un="m";}
        if(choice.equals("km")){un="km";}
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
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            compute = v1 / v2;
            result.setText("Frequency=" + compute +"Hz\n\n f=" + v1 + "/" + v2 + "\n=" + compute);
        }
        else if (ryan==2){
            if(v1==0 || v2==0){
                Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show();}
            v1 = Double.parseDouble(value1.getText().toString());
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            compute = v1 * v2;
            result.setText("Velocity=" + compute + "" + un + "/" + uni + "\n\n v=" + v1 + "*" + v2 + "\n=" + compute);
        }
        else if (ryan==3){
            if(v1==0 || v2==0){
                Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show();}
            v1 = Double.parseDouble(value1.getText().toString());
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            compute = v1 / v2;
            result.setText("Wavelength=" + compute + "" + un + "/" + uni + "\n\n λ=" + v1 + "/" + v2 + "\n=" + compute);
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