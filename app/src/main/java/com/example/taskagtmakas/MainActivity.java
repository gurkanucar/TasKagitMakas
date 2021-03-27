package com.example.taskagtmakas;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    ImageView aiImage,yourImage;
    Button rockBtn,paperBtn,scissorsBtn;
    TextView scoreText;

    int yourScore=0;
    int aiScore=0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aiImage = findViewById(R.id.aiImage);
        yourImage = findViewById(R.id.yourImage);

        scoreText=findViewById(R.id.scoreText);

        rockBtn=findViewById(R.id.rockBtn);
        paperBtn=findViewById(R.id.paperBtn);
        scissorsBtn=findViewById(R.id.scissorsBtn);

        rockBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yourImage.setBackground(getResources().getDrawable(R.drawable.rock));
                Results result = calculateResult(Choices.ROCK,AIChoice());
                updateScore(result);
            }
        });



        paperBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yourImage.setBackground(getResources().getDrawable(R.drawable.paper));
                Results result = calculateResult(Choices.PAPER,AIChoice());
                updateScore(result);
            }
        });


        scissorsBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                yourImage.setBackground(getResources().getDrawable(R.drawable.scissors));
                Results result = calculateResult(Choices.SCISSORS,AIChoice());
                updateScore(result);
            }
        });

    }

    public void updateScore(Results result){
        if(result.equals(Results.WIN)){
            yourScore++;
        }else if(result.equals(Results.LOST)){
            aiScore+=1;
        }
        scoreText.setText("AI: "+aiScore+"  YOU: "+yourScore);
    }

    public Results calculateResult(Choices yourChoice,Choices aiChoice){
        if(yourChoice.equals(aiChoice)){
            return Results.DRAW;
        }
        else if( (yourChoice.equals(Choices.ROCK) && aiChoice.equals(Choices.SCISSORS)) ||
                (yourChoice.equals(Choices.PAPER) && aiChoice.equals(Choices.ROCK)) ||
                (yourChoice.equals(Choices.SCISSORS) && aiChoice.equals(Choices.PAPER))){

            return Results.WIN;
        }
        else{
            return Results.LOST;
        }
    }

    public Choices AIChoice(){
        int random = new Random().nextInt(3);
        if(random==0){
            aiImage.setBackground(getResources().getDrawable(R.drawable.rock));
            return Choices.ROCK;
        }
       else if(random==1){
            aiImage.setBackground(getResources().getDrawable(R.drawable.paper));
            return Choices.PAPER;
        }
       else{
            aiImage.setBackground(getResources().getDrawable(R.drawable.scissors));
            return Choices.SCISSORS;
        }
    }


}