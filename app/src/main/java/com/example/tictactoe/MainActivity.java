package com.example.tictactoe;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static Button[][] MATRIX = new Button[3][3];
    public boolean x_or_not = true;
    public TextView player_turn_TV;
    public static int COUNT;
    public ImageView winnerImage;

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
        player_turn_TV = findViewById(R.id.textView2);
        player_turn_TV.setText(getString(R.string.PlayerTurn, getString(R.string.X)));
        COUNT = 0;
        winnerImage = findViewById(R.id.winnerView);
        resetBoard();
    }

    public void onClick(View view){
        Button btn = (Button) view;

        if(btn.getText().toString().equals("") && COUNT < 9){
            if(x_or_not){
                btn.setText(getString(R.string.X));
                player_turn_TV.setText(getString(R.string.PlayerTurn, getString(R.string.O)));
                x_or_not = false;
            }else{
                btn.setText(getString(R.string.O));
                player_turn_TV.setText(getString(R.string.PlayerTurn, getString(R.string.X)));
                x_or_not = true;
            }
            if(verifyWin()){
                if(x_or_not){
                    winnerImage.setImageResource(R.drawable.winner_o);
                }else{
                    winnerImage.setImageResource(R.drawable.winner_x);
                }
                blockBoard();
                winnerImage.setVisibility(View.VISIBLE);
            }
            COUNT++;
        }
    }

    public boolean verifyWin(){
        for (int i=0; i<3; i++){
            //three in a row
            if((MATRIX[i][0].getText().toString().equals(MATRIX[i][1].getText().toString()) &&
                    MATRIX[i][1].getText().toString().equals(MATRIX[i][2].getText().toString())) &&
                    !MATRIX[i][0].getText().toString().equals("")) {
                return true;
            }
            //three in a column
            if((MATRIX[0][i].getText().toString().equals(MATRIX[1][i].getText().toString()) &&
                    MATRIX[1][i].getText().toString().equals(MATRIX[2][i].getText().toString())) &&
                    !MATRIX[0][i].getText().toString().equals("")) {
                return true;
            }
        }
        //three diagonally
        if((MATRIX[0][0].getText().toString().equals(MATRIX[1][1].getText().toString())
                && MATRIX[1][1].getText().toString().equals(MATRIX[2][2].getText().toString()) ||
                MATRIX[0][2].getText().toString().equals(MATRIX[1][1].getText().toString()) &&
                        MATRIX[1][1].getText().toString().equals(MATRIX[2][0].getText().toString())) &&
                        !MATRIX[0][0].getText().toString().equals("")){
            return true;

        }
        return false;
    }

    public void onClickReset(View view){
        resetBoard();
    }

    public void blockBoard(){
        MATRIX[0][0].setActivated(false);
        MATRIX[0][1].setActivated(false);
        MATRIX[0][2].setActivated(false);
        MATRIX[1][0].setActivated(false);
        MATRIX[1][1].setActivated(false);
        MATRIX[1][2].setActivated(false);
        MATRIX[2][0].setActivated(false);
        MATRIX[2][1].setActivated(false);
        MATRIX[2][2].setActivated(false);
    }

    public void unblockBoard(){
        MATRIX[0][0].setActivated(true);
        MATRIX[0][1].setActivated(true);
        MATRIX[0][2].setActivated(true);
        MATRIX[1][0].setActivated(true);
        MATRIX[1][1].setActivated(true);
        MATRIX[1][2].setActivated(true);
        MATRIX[2][0].setActivated(true);
        MATRIX[2][1].setActivated(true);
        MATRIX[2][2].setActivated(true);
    }
    public void resetBoard(){
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

        winnerImage.setVisibility(View.INVISIBLE);
        unblockBoard();
    }
}