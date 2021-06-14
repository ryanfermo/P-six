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

public class Home1 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, AdapterView.OnItemSelectedListener {
    private MenuItem item;
    private Spinner spinner,spinner2,spinner4;
    ImageButton btn,home;
    EditText value1,value2;
    TextView first,second,result,answer;
    Button calculate;
    double ryan=1;
    double v1,v2,compute,con1,con2;
    String un,uni,den;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home1);
        value1=findViewById(R.id.editTextTextPersonName);
        value2=findViewById(R.id.editTextTextPersonName2);
        value1.setText("00");
        value2.setText("00");
        answer=findViewById(R.id.textView8);
        calculate=findViewById(R.id.button2);
        first=findViewById(R.id.textView2);
        second=findViewById(R.id.textView5);
        result=findViewById(R.id.textView3);
        btn=findViewById(R.id.imageButton);
        home=findViewById(R.id.imageButton2);
        spinner=findViewById(R.id.spinner);
        spinner2=findViewById(R.id.spinner2);
        spinner4=findViewById(R.id.spinner4);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.unit3, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence>adapter1=ArrayAdapter.createFromResource(this,R.array.unit4, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence>adapter2=ArrayAdapter.createFromResource(this,R.array.den, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner4.setAdapter(adapter2);
        spinner4.setOnItemSelectedListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Home1.this);
                builder.setTitle("Information");
                builder.setMessage("The density of material shows the denseness of it in a specific given area.\n" +
                        "\n" +
                        "ρ=mV\np=density\nm=mass\nv=volume");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss(); }
                });
                builder.show();
            }
        });
    }
    public void home1(View view) {
        Toast.makeText(this, "Proceeding to Home", Toast.LENGTH_SHORT).show();
        Intent intent=new Intent(this,page.class);
        startActivity(intent);
    }
    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu1);
        popup.show();
    }
    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Density clicked", Toast.LENGTH_SHORT).show();
                first.setText("m :");
                second.setText("v :");
                answer.setVisibility(View.VISIBLE);
                spinner4.setVisibility(View.VISIBLE);
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan=1;
                return true;
            case R.id.item2:
                Toast.makeText(this, "Mass clicked", Toast.LENGTH_SHORT).show();
                first.setText("p :");
                second.setText("v :");
                answer.setVisibility(View.GONE);
                spinner4.setVisibility(View.GONE);
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan=2;
                return true;
            case R.id.item3:
                Toast.makeText(this, "Volume clicked", Toast.LENGTH_SHORT).show();
                first.setText("m :");
                second.setText("p :");
                answer.setVisibility(View.GONE);
                spinner4.setVisibility(View.GONE);
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
        if(choice.equals("g")){un="g";}
        if(choice.equals("kg")){un="kg";}
        if(choice.equals("oz")){un="oz";}
        if(choice.equals("lb")){un="lb";}
        if(choice.equals("ml")){uni="ml";}
        if(choice.equals("cm³")){uni="cm³";}
        if(choice.equals("m³")){uni="m³";}
        if(choice.equals("l")){uni="l";}
        if(choice.equals("kg/cm³")){den="kg/cm³";}
        if(choice.equals("kg/m³")){den="kg/m³";}
        if(choice.equals("kg/ml")){den="kg/ml";}
        if(choice.equals("kg/l")){den="kg/l";}
        if(den=="kg/cm³"){
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            if (un=="g"){
                con1=v1*0.001;
            }
            else if (un=="kg"){
                con1=v1*1;
            }
            else if (un=="oz"){
                con1=v1*0.0283495;
            }
            else if (un=="lb"){
                con1=v1*0.453592;
            }
            else {}
            if(uni=="ml"){
                con2=v2/1;
            }
            else if(uni=="cm³"){
                con2=v2*1;
            }
            else if(uni=="m³"){
                con2=v2*0.00000001;
            }
            else if(uni=="l"){
                con2=v2*1000;
            }}
        if(den=="kg/ml"){
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            if (un=="g"){
                con1=v1*0.001;
            }
            else if (un=="kg"){
                con1=v1*1;
            }
            else if (un=="oz"){
                con1=v1*0.0283495;
            }
            else if (un=="lb"){
                con1=v1*0.453592;
            }
            else {}
            if(uni=="ml"){
                con2=v2*1;
            }
            else if(uni=="cm³"){
                con2=v2*1;
            }
            else if(uni=="m³"){
                con2=v2*1000000;
            }
            else if(uni=="l"){
                con2=v2*1000;
            }}
        if(den=="kg/m³"){
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            if (un=="g"){
                con1=v1*0.001;
            }
            else if (un=="kg"){
                con1=v1*1;
            }
            else if (un=="oz"){
                con1=v1*0.0283495;
            }
            else if (un=="lb"){
                con1=v1*0.453592;
            }
            else {}
            if(uni=="ml"){
                con2=v2*0.00000001;
            }
            else if(uni=="cm³"){
                con2=v2*0.00000001;
            }
            else if(uni=="m³"){
                con2=v2*1;
            }
            else if(uni=="l"){
                con2=v2*0.001;
            }
        }
        if(den=="kg/l"){
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            if (un=="g"){
                con1=v1*0.001;
            }
            else if (un=="kg"){
                con1=v1*1;
            }
            else if (un=="oz"){
                con1=v1*0.0283495;
            }
            else if (un=="lb"){
                con1=v1*0.453592;
            }
            else {}
            if(uni=="ml"){
                con2=v2*0.001;
            }
            else if(uni=="cm³"){
                con2=v2*0.001;
            }
            else if(uni=="m³"){
                con2=v2*1000;
            }
            else if(uni=="l"){
                con2=v2*1;
            }

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
        if (ryan==1) {
            if(v1==0 || v2==0){
                Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show();}
            compute = con1/con2;
            result.setText("Density=" + compute + "" + den + "\n\n p=" + v1 + "/" + v2 + "\n=" + compute);}
        else if (ryan==2) {
            if(v1==0 || v2==0){
                Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show();}
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            compute = v1 * v2;
            result.setText("Mass=" + compute + "" + uni + "\n\n m=" + v1 + "*" + v2 + "\n=" + compute);
        }
        else if (ryan==3) {
                if (v1==0 || v2==0) {
                    Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show(); }
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            compute = v1 / v2;
            result.setText("Volume=" + compute + "" + uni + "\n\n v=" + v1 + "/" + v2 + "\n=" + compute);
        }else{Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show();}
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