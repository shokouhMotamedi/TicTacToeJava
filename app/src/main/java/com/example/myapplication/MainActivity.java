package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import com.example.myapplication.databinding.ActivityMainBinding;

import java.util.ArrayList;
import java.util.List;


public class MainActivity extends AppCompatActivity {

    ActivityMainBinding binding;
    private final List<int[]> winCombinations = new ArrayList<>();
    private int[] boxPositions = {0,0,0,0,0,0,0,0,0};
    private int playerTurn = 1;
    private int totalSelectedBoxes = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        binding = ActivityMainBinding.inflate(getLayoutInflater());
        setContentView(binding.getRoot());

        winCombinations.add(new int[]{0,1,2});
        winCombinations.add(new int[]{3,4,5});
        winCombinations.add(new int[]{6,7,8});
        winCombinations.add(new int[]{1,4,7});
        winCombinations.add(new int[]{2,5,8});
        winCombinations.add(new int[]{0,3,6});
        winCombinations.add(new int[]{0,4,8});
        winCombinations.add(new int[]{2,4,6});


        //EditText playerOneName = findViewById(R.id.getPlayerOne);
        String playerOneName = getIntent().getStringExtra("playerOne");
        String playerTwoName = getIntent().getStringExtra("playerTwo");

        binding.tvPlayerOne.setText(playerOneName);
        binding.tvPlayerTwo.setText(playerTwoName);

        binding.image1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(0)){
                    startGame((ImageView) view, 0);
                }
            }
        });

        binding.image2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(1)){
                    startGame((ImageView) view, 1);
                }
            }
        });

        binding.image3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(2)){
                    startGame((ImageView) view, 2);
                }
            }
        });

        binding.image4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(3)){
                    startGame((ImageView) view, 3);
                }
            }
        });


        binding.image5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(4)){
                    startGame((ImageView) view, 4);
                }
            }
        });
        binding.image6.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(5)){
                    startGame((ImageView) view, 5);
                }
            }
        });


        binding.image7.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(6)){
                    startGame((ImageView) view, 6);
                }
            }
        });
        binding.image8.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(7)){
                    startGame((ImageView) view, 7);
                }
            }
        });


        binding.image9.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(isBoxSelectable(8)){
                    startGame((ImageView) view, 8);
                }
            }
        });

    }



    private void startGame(ImageView imageView, int selectedPosition){
        boxPositions[selectedPosition] = playerTurn;

        if(playerTurn == 1){
            imageView.setImageResource(R.drawable.ximage);
            if(checkResult()){
                ResultActivity resultActivity = new ResultActivity(MainActivity.this, binding.tvPlayerOne.getText().toString() + " is the winner !!", MainActivity.this);
                resultActivity.setCancelable(false);
                resultActivity.show();
            } else if (totalSelectedBoxes == 9) {
                ResultActivity resultActivity = new ResultActivity(MainActivity.this, "Tie Match", MainActivity.this);
                resultActivity.setCancelable(false);
                resultActivity.show();
            }else {
                changePlayerTurn(2);
                totalSelectedBoxes++;
            }
        }else {
            imageView.setImageResource(R.drawable.oimage);
            if(checkResult()){
                ResultActivity resultActivity = new ResultActivity(MainActivity.this, binding.tvPlayerTwo.getText().toString() + " is the winner !!", MainActivity.this);
                resultActivity.setCancelable(false);
                resultActivity.show();
            } else if (totalSelectedBoxes == 9) {
                ResultActivity resultActivity = new ResultActivity(MainActivity.this, "Tie Match", MainActivity.this);
                resultActivity.setCancelable(false);
                resultActivity.show();
            }else {
                changePlayerTurn(1);
                totalSelectedBoxes++;
            }
        }


    }



    private void changePlayerTurn(int curPlayer){
        playerTurn = curPlayer;

        if (playerTurn ==1){
            binding.playerOneLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerTwoLayout.setBackgroundResource(R.drawable.white_box);
        }
        else{
            binding.playerTwoLayout.setBackgroundResource(R.drawable.black_border);
            binding.playerOneLayout.setBackgroundResource(R.drawable.white_box);
        }
    }

    private boolean checkResult(){
        boolean result = false;
        for (int i=0; i< winCombinations.size(); i++){
            final int[] combination = winCombinations.get(i);

            if (boxPositions[combination[0]] == playerTurn
                    && boxPositions[combination[1]] == playerTurn
                    && boxPositions[combination[2]] == playerTurn){
                result =true;
            }
        }
        return result;
    }



    //?
    private boolean isBoxSelectable(int boxPosition) {
        boolean response = false;
        if (boxPositions[boxPosition] == 0) {
            response = true;
        }
        return response;
    }


    public void restart(){
        boxPositions = new int[]{0, 0, 0, 0, 0, 0, 0, 0, 0};
        playerTurn =1;
        totalSelectedBoxes =1;
        binding.image1.setImageResource(R.drawable.white_box);
        binding.image2.setImageResource(R.drawable.white_box);
        binding.image3.setImageResource(R.drawable.white_box);
        binding.image4.setImageResource(R.drawable.white_box);
        binding.image5.setImageResource(R.drawable.white_box);
        binding.image6.setImageResource(R.drawable.white_box);
        binding.image7.setImageResource(R.drawable.white_box);
        binding.image8.setImageResource(R.drawable.white_box);
        binding.image9.setImageResource(R.drawable.white_box);
    }
}