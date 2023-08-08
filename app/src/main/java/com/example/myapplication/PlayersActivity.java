package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class PlayersActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_players);

        EditText playerOne = findViewById(R.id.getPlayerOne);
        EditText playerTwo = findViewById(R.id.getPlayerTwo);
        Button startGame = findViewById(R.id.btm_start);


        startGame.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String playerOneName = playerOne.getText().toString();
                String playerTwoName = playerTwo.getText().toString();

                if (playerOneName.isEmpty() || playerTwoName.isEmpty()){
                    Toast.makeText(PlayersActivity.this, "Please Add players Name", Toast.LENGTH_SHORT).show();
                }
                else {
                    Intent intent = new Intent(PlayersActivity.this, MainActivity.class);
                    intent.putExtra("playerOne", playerOneName);
                    intent.putExtra("playerTwo", playerTwoName);
                    startActivity(intent);
                }


            }
        });




    }






}