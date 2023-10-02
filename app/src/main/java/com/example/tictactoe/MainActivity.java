package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends AppCompatActivity {

    public static Button[][] MATRIX = new Button[3][3];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MATRIX[0][0] = findViewById(R.id.button);
        MATRIX[0][1] = findViewById(R.id.button2);
        MATRIX[0][2] = findViewById(R.id.button3);
        MATRIX[1][0] = findViewById(R.id.button4);
        MATRIX[1][1] = findViewById(R.id.button5);
        MATRIX[1][2] = findViewById(R.id.button6);
        MATRIX[2][0] = findViewById(R.id.button7);
        MATRIX[2][1] = findViewById(R.id.button8);
        MATRIX[2][2] = findViewById(R.id.button9);
    }

    public void onClick(View view){
        Button btn = (Button) view;

        if(!btn.getText().toString().equals("")){

        }
    }

    public boolean verifyWin(){
        for (int i=0; i<3; i++){
            //three in a row
            if(MATRIX[i][0].equals(MATRIX[i][1]) && MATRIX[i][1].equals(MATRIX[i][2])) {
                return true;
            }
            //three in a column
            if(MATRIX[0][i].equals(MATRIX[1][i]) && MATRIX[1][i].equals(MATRIX[2][i])) {
                return true;
            }
        }
        return false;
    }

    public void onClickReset(View view){
        //clean matrix
        MATRIX[0][0].setText("");
        MATRIX[0][1].setText("");
        MATRIX[0][2].setText("");
        MATRIX[1][0].setText("");
        MATRIX[1][1].setText("");
        MATRIX[1][2].setText("");
        MATRIX[2][0].setText("");
        MATRIX[2][1].setText("");
        MATRIX[2][2].setText("");
    }
}