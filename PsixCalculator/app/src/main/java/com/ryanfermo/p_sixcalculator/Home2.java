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

public class Home2 extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener, AdapterView.OnItemSelectedListener {
private MenuItem item;
private Spinner spinner,spinner2,spinner5;
        ImageButton btn,home;
        EditText value1,value2;
        TextView first,second,result,answer;
        Button calculate;
        double ryan=2;
        double v1,v2,compute,con1,con2;
        String un,uni,ton;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home2);
        value1 = findViewById(R.id.editTextTextPersonName);
        value2 = findViewById(R.id.editTextTextPersonName2);
        value1.setText("00");
        value2.setText("00");
        answer=findViewById(R.id.textView9);
        calculate = findViewById(R.id.button2);
        first = findViewById(R.id.textView2);
        second = findViewById(R.id.textView5);
        result = findViewById(R.id.textView3);
        btn = findViewById(R.id.imageButton);
        home = findViewById(R.id.imageButton2);
        spinner=findViewById(R.id.spinner);
        spinner2=findViewById(R.id.spinner2);
        spinner5=findViewById(R.id.spinner5);
        ArrayAdapter<CharSequence> adapter=ArrayAdapter.createFromResource(this,R.array.unit5, android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner.setAdapter(adapter);
        spinner.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence>adapter1= ArrayAdapter.createFromResource(this,R.array.unit6, android.R.layout.simple_spinner_item);
        adapter1.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner2.setAdapter(adapter1);
        spinner2.setOnItemSelectedListener(this);
        ArrayAdapter<CharSequence>adapter2= ArrayAdapter.createFromResource(this,R.array.newton, android.R.layout.simple_spinner_item);
        adapter2.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        spinner5.setAdapter(adapter2);
        spinner5.setOnItemSelectedListener(this);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                MaterialAlertDialogBuilder builder = new MaterialAlertDialogBuilder(Home2.this);
                builder.setTitle("Information");
                builder.setMessage("According to Newton’s second law of motion, the force can be expressed by the product of mass and acceleration of the body.\n" +
                        "\n" +
                        "F = m × a\nF=force\nm=mass\na=acceleration");
                builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        dialogInterface.dismiss();
                    }
                });
                builder.show();
            }
        });
    }

    public void home2(View view) {
        Toast.makeText(this, "Proceeding to Home", Toast.LENGTH_SHORT).show();
        Intent intent = new Intent(this, page.class);
        startActivity(intent);
    }

    public void showPopup(View v) {
        PopupMenu popup = new PopupMenu(this, v);
        popup.setOnMenuItemClickListener(this);
        popup.inflate(R.menu.popup_menu2);
        popup.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.item1:
                Toast.makeText(this, "Acceleration clicked", Toast.LENGTH_SHORT).show();
                first.setText("F :");
                second.setText("m :");
                answer.setVisibility(View.GONE);
                spinner5.setVisibility(View.GONE);
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan = 1;
                return true;
            case R.id.item2:
                Toast.makeText(this, "Force clicked", Toast.LENGTH_SHORT).show();
                first.setText("m :");
                second.setText("a :");
                answer.setVisibility(View.VISIBLE);
                spinner5.setVisibility(View.VISIBLE);
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan = 2;
                return true;
            case R.id.item3:
                Toast.makeText(this, "Mass clicked", Toast.LENGTH_SHORT).show();
                first.setText("F :");
                second.setText("a :");
                answer.setVisibility(View.GONE);
                spinner5.setVisibility(View.GONE);
                value1.setText("00");
                value2.setText("00");
                result.setText("");
                ryan = 3;
                return true;
            default:
                return false;
        }

    }
    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        String choice=parent.getItemAtPosition(position).toString();
        if(choice.equals("N")){un="N";}
        if(choice.equals("MN")){un="MN";}
        if(choice.equals("g")){un="g";}
        if(choice.equals("kg")){un="kg";}
        if(choice.equals("oz")){un="oz";}
        if(choice.equals("lb")){un="lb";}
        if(choice.equals("cm/s²")){uni="cm/s²";}
        if(choice.equals("m/s²")){uni="m/s²";}
        if(choice.equals("ft/s²")){uni="ft/s²";}
        if(choice.equals("pdl")){ton="pdl";}
        if(choice.equals("lbf")){ton="lbf";}
        if(choice.equals("Newton")){ton="Newton";}
        if(ton=="Newton"){
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
            if(uni=="m/s²"){
                con2=v2*1;
            }
            else if(uni=="cm/s²"){
                con2=v2*100;
            }
            else if(uni=="ft/s²"){
                con2=v2*0.3048;
            }
            compute = con1 * con2;
        }
        if(ton=="pdl"){
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
            if(uni=="m/s²"){
                con2=v2*1;
            }
            else if(uni=="cm/s²"){
                con2=v2*100;
            }
            else if(uni=="ft/s²"){
                con2=(v2*0.3048);
            }
            compute = (con1 * con2)*7.2330140801469;
        }
        if(ton=="lbf"){
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
            if(uni=="m/s²"){
                con2=v2*1;
            }
            else if(uni=="cm/s²"){
                con2=v2*100;
            }
            else if(uni=="ft/s²"){
                con2=(v2*0.3048);
            }
            compute = (con1 * con2)*0.224809;
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
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            compute = v1 / v2;
            result.setText("Acceleration=" + compute + "" + un + "/" + uni + "\n\n a=" + v1 + "/" + v2 + "\n=" + compute); }
        else if (ryan==2) {
            if(v1==0 || v2==0){
                Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show();}
            result.setText("Force=" + compute + ""+ton+"\n\n F=" + con1 + "*" + con2 + "\n=" + compute);
        } else if (ryan==3) {
            if (v1==0 || v2==0) {
                Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show(); }
            v1 = Double.parseDouble(value1.getText().toString());
            v2 = Double.parseDouble(value2.getText().toString());
            compute = v1 / v2;
            result.setText("Mass=" + compute + "" + un + "/" + uni + "\n\n m=" + v1 + "/" + v2 + "\n=" + compute);
        } else {Toast.makeText(this, "Please provide the Values!\nEmpty value may lead to close the application!", Toast.LENGTH_LONG).show(); }
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