package com.firstapp.sharedprefences;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Context;
import android.content.SharedPreferences;
import android.view.View;
import android.view.Menu;
import android.widget.TextView;
import android.os.Bundle;
public class MainActivity extends AppCompatActivity {
    SharedPreferences sharedPreferences;
    TextView name;
    TextView email;
    public static final String mypreference ="mypref";
    public static final String Name ="namekey";
    public static final String Email ="emailkey";


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        name  =(TextView) findViewById(R.id.etName);
        email  =(TextView) findViewById(R.id.etEmail);
        sharedPreferences = getSharedPreferences(mypreference,Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Name)){
            name.setText(sharedPreferences.getString(Name,""));
        }
        if(sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email,""));
        }
    }
    public void Save(View view){
        String n=name.getText().toString();
        String e=email.getText().toString();
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(Name,n);
        editor.putString(Email,e);
        editor.apply();
    }
    public void clear(View view){
        name  =(TextView) findViewById(R.id.etName);
        email  =(TextView) findViewById(R.id.etEmail);
        name.setText("");
        email.setText("");
    }

    public void Get(View view){
        name  =(TextView) findViewById(R.id.etName);
        email  =(TextView) findViewById(R.id.etEmail);
        sharedPreferences = getSharedPreferences(mypreference,Context.MODE_PRIVATE);
        if(sharedPreferences.contains(Name)){
            name.setText(sharedPreferences.getString(Name,""));
        }
        if(sharedPreferences.contains(Email)){
            email.setText(sharedPreferences.getString(Email,""));
        }

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.menu_main,menu);
        return true;
    }
}