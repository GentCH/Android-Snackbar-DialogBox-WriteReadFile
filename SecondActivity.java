package com.example.owner.cb16124individualassignment;

import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.method.ScrollingMovementMethod;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;

public class SecondActivity extends AppCompatActivity {

    TextView et1;
    Button bt1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        et1=(TextView)findViewById(R.id.viewText);
        bt1=(Button)findViewById(R.id.homeButton);

        try {
            // Create a new file input stream.
            FileInputStream fis = openFileInput("saveText.txt");
            InputStreamReader InputRead = new InputStreamReader(fis);

            int READ_BLOCK_SIZE = 100;
            char[] inputBuffer= new char[READ_BLOCK_SIZE];
            String s="";
            int charRead;

            while ((charRead=InputRead.read(inputBuffer))>0) {
                // char to string conversion
                String readstring=String.copyValueOf(inputBuffer,0,charRead);
                s +=readstring;
            }
            InputRead.close();
            et1.setMovementMethod(new ScrollingMovementMethod());
            et1.setText(s);
        }
        catch(Exception e)
        {
            e.printStackTrace();
        }

        bt1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                finish();
            }
        });

    }

    public void deleteContent(View view)
    {
        AlertDialog.Builder ad1= new AlertDialog.Builder(this);
        ad1.setTitle("Delete Content");
        ad1.setMessage("You are about to delete the content in the file. Undo is not allowed. Do you really want to proceed?");

        ad1.setPositiveButton("YES", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                try {
                    FileOutputStream fos = openFileOutput("saveText.txt", MODE_PRIVATE);
                    OutputStreamWriter outputWriter = new OutputStreamWriter(fos);
                    outputWriter.write("");
                    outputWriter.close();
                    et1.setText("");
                    dialog.dismiss();
                }
                catch (Exception e)
                {
                    e.printStackTrace();
                }
            }
        });

        ad1.setNegativeButton("NO", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                dialog.dismiss();
            }
        });

        ad1.create();
        ad1.show();
    }
}
