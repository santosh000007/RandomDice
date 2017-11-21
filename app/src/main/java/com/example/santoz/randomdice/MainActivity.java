package com.example.santoz.randomdice;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import java.util.Random;

public class MainActivity extends AppCompatActivity {
    Button roll1, roll2;
    ImageView img1, img2;
    TextView textView;
    final int[] images = {R.mipmap.dice1, R.mipmap.dice2, R.mipmap.dice3, R.mipmap.dice4, R.mipmap.dice5, R.mipmap.dice6};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        roll1= (Button) findViewById(R.id.button1);
        roll2=(Button)findViewById(R.id.button2);
        img1= (ImageView) findViewById(R.id.img1);
        img2= (ImageView) findViewById(R.id.img2);
        textView= (TextView) findViewById(R.id.textView);


        roll2.setEnabled(false);
        roll1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll2.setEnabled(true);
                roll1.setEnabled(false);

                Random RandomNumber = new Random();
                int Number1 = RandomNumber.nextInt(6);
                int Number2 = RandomNumber.nextInt(6);
                img1.setImageResource(images[Number1]);
                img2.setImageResource(images[Number2]);


                if (Number1 == Number2) {
                    textView.setText("hurray player1 has won");
                } else{
                    textView.setText("");

                }
            }
        });
        roll2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                roll1.setEnabled(true);
                roll2.setEnabled(false);

                Random RandomNumber = new Random();
                int Number1 = RandomNumber.nextInt(6);
                int Number2 = RandomNumber.nextInt(6);

                if (Number1 == Number2) {
                    textView.setText("hurray player 2 has won");
                } else {
                    textView.setText("");

                }
            }
        });
        }

    }