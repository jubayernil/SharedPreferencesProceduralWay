package com.mishu.mysimplesharedpreference;

import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView textViewShowData;
    EditText editTextWriteData;

    SharedPreferences sharedPreferences;
    SharedPreferences.Editor editor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textViewShowData = (TextView) findViewById(R.id.TextViewShowData);
        editTextWriteData = (EditText) findViewById(R.id.EditTextWriteData);

        sharedPreferences = getSharedPreferences("SavedData", MODE_PRIVATE);
        editor = sharedPreferences.edit();

    }

    public void retrive(View view) {
        String dataToBeSaved = editTextWriteData.getText().toString();

        editor.putString("message", dataToBeSaved);
        editor.commit();
    }

    public void save(View view) {
        String dataToBeShown = sharedPreferences.getString("message", "No Data Found");
        textViewShowData.setText(dataToBeShown);
    }
}
