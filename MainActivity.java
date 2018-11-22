package com.example.owner.cb16124individualassignment;

import android.content.Intent;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import java.io.FileOutputStream;
import java.io.OutputStreamWriter;

public class MainActivity extends AppCompatActivity {

    EditText et1;
    Button b1, b2;
    Intent intentSecond;
    Snackbar sb1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        et1=(EditText)findViewById(R.id.editText);
        b1=(Button)findViewById(R.id.saveButton);
        b2=(Button)findViewById(R.id.viewButton);

        et1.setText("");

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try
                {
                    // Create a new output file stream
                    FileOutputStream fos = openFileOutput("saveText.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fos);
                    outputWriter.write(et1.getText().toString());
                    outputWriter.close();
                    sb1 = Snackbar.make(findViewById(R.id.constraintLayout), "Saved successfully!", Snackbar.LENGTH_SHORT);
                    sb1.show();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        b2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                intentSecond=new Intent(MainActivity.this, SecondActivity.class);
                startActivity(intentSecond);
            }
        });


    }
}
