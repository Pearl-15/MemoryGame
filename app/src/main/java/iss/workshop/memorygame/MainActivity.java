package iss.workshop.memorygame;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.os.Handler;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.Arrays;
import java.util.Collections;
import java.util.Locale;
import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    TextView tv_p1, tv_p2;

    ImageView iv_11,iv_12,iv_13,iv_21,iv_22,iv_23,iv_31,iv_32,iv_33,iv_41,iv_42,iv_43;

    //Array for image
    Integer[] cardsArray = {101,102,103,104,105,106,201,202,203,204,205,206};

    //actual images
    int image_101,image_102,image_103,image_104,image_105,image_106,image_201,image_202,image_203,image_204,image_205,image_206;

    int firstCard, secondCard;
    int clickedFirst, clickedSecond;
    int cardNumber = 1;

    int turn=1;
    int playerPoints = 0,cpuPoints = 0;

    //Timer
    TextView timer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //Timer
        timer = findViewById(R.id.timer);

        new CountDownTimer(30000, 1000) {
            public void onTick(long millisUntilFinished) {
                timer.setText("seconds remaining: " + millisUntilFinished / 1000);
            }

            public void onFinish() {
                alertDialog();
                timer.setText("done!");
            }
        }.start();



        tv_p1 = (TextView) findViewById(R.id.tv_p1);
        tv_p2 = (TextView) findViewById(R.id.tv_p2);

        iv_11 = (ImageView) findViewById(R.id.iv_11);
        iv_12 = (ImageView) findViewById(R.id.iv_12);
        iv_13 = (ImageView) findViewById(R.id.iv_13);
        iv_21 = (ImageView) findViewById(R.id.iv_21);
        iv_22 = (ImageView) findViewById(R.id.iv_22);
        iv_23 = (ImageView) findViewById(R.id.iv_23);
        iv_31 = (ImageView) findViewById(R.id.iv_31);
        iv_32 = (ImageView) findViewById(R.id.iv_32);
        iv_33 = (ImageView) findViewById(R.id.iv_33);
        iv_41 = (ImageView) findViewById(R.id.iv_41);
        iv_42 = (ImageView) findViewById(R.id.iv_42);
        iv_43 = (ImageView) findViewById(R.id.iv_43);

        iv_11.setTag("0");
        iv_12.setTag("1");
        iv_13.setTag("2");
        iv_21.setTag("3");
        iv_22.setTag("4");
        iv_23.setTag("5");
        iv_31.setTag("6");
        iv_32.setTag("7");
        iv_33.setTag("8");
        iv_41.setTag("9");
        iv_42.setTag("10");
        iv_43.setTag("11");

        //load the card images
        frontOfCardsResources();

        Collections.shuffle(Arrays.asList(cardsArray));


        //changing the color of second player (inactive)
        tv_p2.setTextColor(Color.GRAY);

        iv_11.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_11,theCard);

            }
        });

        iv_12.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_12,theCard);

            }
        });

        iv_13.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_13,theCard);

            }
        });

        iv_21.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_21,theCard);

            }
        });
        iv_22.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_22,theCard);

            }
        });
        iv_23.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {


                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_23,theCard);
            }
        });

        iv_31.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_31,theCard);

            }
        });

        iv_32.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_32,theCard);

            }
        });

        iv_33.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_33,theCard);

            }
        });

        iv_41.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_41,theCard);

            }
        });
        iv_42.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_42,theCard);

            }
        });
        iv_43.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                int theCard = Integer.parseInt((String) view.getTag());
                doStuff(iv_43,theCard);

            }
        });




    }

    private void doStuff(ImageView iv, int card){

        //set the correct image to the imageview
        if(cardsArray[card] ==101){
            iv.setImageResource(image_101);
        }
        else if(cardsArray[card]==102){
            iv.setImageResource(image_102);
        }
        else if(cardsArray[card]==103){
            iv.setImageResource(image_103);
        }
        else if(cardsArray[card]==104){
            iv.setImageResource(image_104);
        }
        else if(cardsArray[card]==105){
            iv.setImageResource(image_105);
        }
        else if(cardsArray[card]==106){
            iv.setImageResource(image_106);
        }
        else if(cardsArray[card]==201){
            iv.setImageResource(image_201);
        }
        else if(cardsArray[card]==202){
            iv.setImageResource(image_202);
        }
        else if(cardsArray[card]==203){
            iv.setImageResource(image_203);
        }
        else if(cardsArray[card]==204){
            iv.setImageResource(image_204);
        }
        else if(cardsArray[card]==205){
            iv.setImageResource(image_205);
        }
        else if(cardsArray[card]==206){
            iv.setImageResource(image_206);
        }

        //check which image is selected and save it to temporay
        if(cardNumber==1){
            firstCard = cardsArray[card];
            if(firstCard > 200){
                firstCard = firstCard - 100;
            }

            cardNumber = 2;
            clickedFirst = card;

            iv.setEnabled(false);
        }
        else if(cardNumber==2){
            secondCard = cardsArray[card];
            if(secondCard > 200){
                secondCard = secondCard - 100;
            }

            cardNumber =1;
            clickedSecond = card;

            iv_11.setEnabled(false);
            iv_12.setEnabled(false);
            iv_13.setEnabled(false);
            iv_21.setEnabled(false);
            iv_22.setEnabled(false);
            iv_23.setEnabled(false);
            iv_31.setEnabled(false);
            iv_32.setEnabled(false);
            iv_33.setEnabled(false);
            iv_41.setEnabled(false);
            iv_42.setEnabled(false);
            iv_43.setEnabled(false);

            Handler handler = new Handler();
            handler.postDelayed(new Runnable() {
                @Override
                public void run() {

                    //check if the selected images are equal
                    calculate();
                }
            },1000);

        }
    }

    private void calculate(){

        //if images are equal remove them and add point
        if(firstCard==secondCard) {

            if (clickedFirst == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 3) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 4) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 5) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 6) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 7) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 8) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 9) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 10) {
                iv_42.setVisibility(View.INVISIBLE);
            } else if (clickedFirst == 11) {
                iv_43.setVisibility(View.INVISIBLE);
            }

            if (clickedSecond == 0) {
                iv_11.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 1) {
                iv_12.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 2) {
                iv_13.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 3) {
                iv_21.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 4) {
                iv_22.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 5) {
                iv_23.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 6) {
                iv_31.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 7) {
                iv_32.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 8) {
                iv_33.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 9) {
                iv_41.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 10) {
                iv_42.setVisibility(View.INVISIBLE);
            } else if (clickedSecond == 11) {
                iv_43.setVisibility(View.INVISIBLE);
            }


            //add points to the correct player
            if(turn ==1){
                playerPoints++;
                tv_p1.setText("P1 : " + playerPoints);
            } else if(turn==2){
                cpuPoints++;
                tv_p2.setText("P2: " + cpuPoints);
            }
        }
        else{
            iv_11.setImageResource(R.drawable.hidden);
            iv_12.setImageResource(R.drawable.hidden);
            iv_13.setImageResource(R.drawable.hidden);
            iv_21.setImageResource(R.drawable.hidden);
            iv_22.setImageResource(R.drawable.hidden);
            iv_23.setImageResource(R.drawable.hidden);
            iv_31.setImageResource(R.drawable.hidden);
            iv_32.setImageResource(R.drawable.hidden);
            iv_33.setImageResource(R.drawable.hidden);
            iv_41.setImageResource(R.drawable.hidden);
            iv_42.setImageResource(R.drawable.hidden);
            iv_43.setImageResource(R.drawable.hidden);

            //change player turn
            if(turn ==1){
                turn =2;
                tv_p1.setTextColor(Color.GRAY);
                tv_p2.setTextColor(Color.GREEN);

            } else if(turn ==2){
                turn =1;
                tv_p2.setTextColor(Color.GRAY);
                tv_p1.setTextColor(Color.GREEN);
            }
        }

        iv_11.setEnabled(true);
        iv_12.setEnabled(true);
        iv_13.setEnabled(true);
        iv_21.setEnabled(true);
        iv_22.setEnabled(true);
        iv_23.setEnabled(true);
        iv_31.setEnabled(true);
        iv_32.setEnabled(true);
        iv_33.setEnabled(true);
        iv_41.setEnabled(true);
        iv_42.setEnabled(true);
        iv_43.setEnabled(true);

        //check if the game is over
        checkEnd();

    }
    private void checkEnd(){

        if(iv_11.getVisibility()==View.INVISIBLE &&
                iv_12.getVisibility()==View.INVISIBLE &&
                iv_13.getVisibility()==View.INVISIBLE &&
                iv_21.getVisibility()==View.INVISIBLE &&
                iv_22.getVisibility()==View.INVISIBLE &&
                iv_23.getVisibility()==View.INVISIBLE &&
                iv_31.getVisibility()==View.INVISIBLE &&
                iv_32.getVisibility()==View.INVISIBLE &&
                iv_33.getVisibility()==View.INVISIBLE &&
                iv_41.getVisibility()==View.INVISIBLE &&
                iv_42.getVisibility()==View.INVISIBLE &&
                iv_43.getVisibility()==View.INVISIBLE){

            alertDialog();

        }
    }

    private void alertDialog(){
                    AlertDialog.Builder alertDialogBuilder = new AlertDialog.Builder(MainActivity.this);
            alertDialogBuilder
                    .setMessage("Game Over!\nP1: " + playerPoints + "\nP2: " + cpuPoints)
                    .setCancelable(false)
                    .setPositiveButton("NEW", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            Intent intent = new Intent(getApplicationContext(),MainActivity.class);
                            startActivity(intent);
                            finish();


                        }
                    })
                    .setNegativeButton("EXIT", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    });

            AlertDialog alertDialog = alertDialogBuilder.create();
            alertDialog.show();
    }

    private void frontOfCardsResources(){
        image_101 = R.drawable.image_101;
        image_102 = R.drawable.image_102;
        image_103 = R.drawable.image_103;
        image_104 = R.drawable.image_104;
        image_105 = R.drawable.image_105;
        image_106 = R.drawable.image_106;
        image_201 = R.drawable.image_201;
        image_202 = R.drawable.image_202;
        image_203 = R.drawable.image_203;
        image_204 = R.drawable.image_204;
        image_205 = R.drawable.image_205;
        image_206 = R.drawable.image_206;

    }
}