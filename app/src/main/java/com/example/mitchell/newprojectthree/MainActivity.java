package com.example.mitchell.newprojectthree;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import org.w3c.dom.Text;

public class MainActivity extends AppCompatActivity {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
    }

    public void buttonClickTest(View v){
        TextView newNameDisplay = findViewById(R.id.newNameDisplay);
        EditText nameText = findViewById(R.id.nameInput);
        Editable name = nameText.getText();
        newNameDisplay.setText(name);
    }
}
