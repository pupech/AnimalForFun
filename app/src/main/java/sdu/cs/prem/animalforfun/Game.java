package sdu.cs.prem.animalforfun;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Game extends AppCompatActivity {
    //Explicit
    ImageView quetionImageView ;
    ImageButton volumeImageButton;
    Button btn1,btn2,btn3, btn4;
    int questionCount = 10;

    ArrayList<Integer> qID = new ArrayList<Integer>();
    String answer;
    MediaPlayer mediaPlayer;
    int score = 0;
        @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_game);
        
        //ผูกตัวแปร
        quetionImageView = findViewById(R.id.imvQuestion);
        volumeImageButton = findViewById(R.id.imbVolume);
        btn1 = findViewById(R.id.btnQ1);
        btn2 = findViewById(R.id.btnQ2);
        btn3 = findViewById(R.id.btnQ3);
        btn4 = findViewById(R.id.btnQ4);

        for (int i = 1; i <= questionCount; i++) {
            qID.add(i);
        }
        Collections.shuffle(qID);
        setQuetion(qID.remove(0));
        
    }// end onCreate

    private void setQuetion(Integer qID ) {
        if (qID == 1) {
            answer = "นก";
            quetionImageView.setImageResource(R.drawable.bird);
            mediaPlayer = MediaPlayer.create(this, R.raw.bird);

            ArrayList<String> choice = new ArrayList<String>();
            choice.add("นก");
            choice.add("หมา");
            choice.add("แมว");
            choice.add("แกะ");
            Collections.shuffle(choice);
            btn1.setText(choice.remove(0));
            btn2.setText(choice.remove(0));
            btn3.setText(choice.remove(0));
            btn4.setText(choice.remove(0));

        }
        if (qID == 2) {
            answer = "แมว";
            quetionImageView.setImageResource(R.drawable.cat);
            mediaPlayer = MediaPlayer.create(this, R.raw.cat);

            ArrayList<String> choice = new ArrayList<String>();
            choice.add("แมว");
            choice.add("นก");
            choice.add("หมา");
            choice.add("แกะ");
            Collections.shuffle(choice);
            btn1.setText(choice.remove(0));
            btn2.setText(choice.remove(0));
            btn3.setText(choice.remove(0));
            btn4.setText(choice.remove(0));

        }
        if (qID == 3) {
            answer = "วัว";
            quetionImageView.setImageResource(R.drawable.cow);
            mediaPlayer = MediaPlayer.create(this, R.raw.cow);

            ArrayList<String> choice = new ArrayList<String>();
            choice.add("วัว");
            choice.add("นก");
            choice.add("แมว");
            choice.add("แกะ");
            Collections.shuffle(choice);
            btn1.setText(choice.remove(0));
            btn2.setText(choice.remove(0));
            btn3.setText(choice.remove(0));
            btn4.setText(choice.remove(0));

        }
        if (qID == 4) {
            answer = "หมา";
            quetionImageView.setImageResource(R.drawable.dog);
            mediaPlayer = MediaPlayer.create(this, R.raw.dog);

            ArrayList<String> choice = new ArrayList<String>();
            choice.add("หมา");
            choice.add("นก");
            choice.add("แมว");
            choice.add("แกะ");
            Collections.shuffle(choice);
            btn1.setText(choice.remove(0));
            btn2.setText(choice.remove(0));
            btn3.setText(choice.remove(0));
            btn4.setText(choice.remove(0));

        }
        if (qID == 5) {
            answer = "ช้าง";
            quetionImageView.setImageResource(R.drawable.elephant);
            mediaPlayer = MediaPlayer.create(this, R.raw.elephant);

            ArrayList<String> choice = new ArrayList<String>();
            choice.add("ช้าง");
            choice.add("นก");
            choice.add("แมว");
            choice.add("แกะ");
            Collections.shuffle(choice);
            btn1.setText(choice.remove(0));
            btn2.setText(choice.remove(0));
            btn3.setText(choice.remove(0));
            btn4.setText(choice.remove(0));

        }
        if (qID == 6) {
            answer = "ม้า";
            quetionImageView.setImageResource(R.drawable.horse);
            mediaPlayer = MediaPlayer.create(this, R.raw.horse);

            ArrayList<String> choice = new ArrayList<String>();
            choice.add("ม้า");
            choice.add("นก");
            choice.add("แมว");
            choice.add("แกะ");
            Collections.shuffle(choice);
            btn1.setText(choice.remove(0));
            btn2.setText(choice.remove(0));
            btn3.setText(choice.remove(0));
            btn4.setText(choice.remove(0));

        }
    }//end Question

    public void playSound(View view) {
        mediaPlayer.start();
    }

    public void choiceAns(View view) {
        Button button = (Button) view;
        String buttonString = button.getText().toString(); //เก็บค่าจากการกดไว้ใน string
        if (buttonString.equals(answer)) {
            score++;
        }
        if (qID.isEmpty()) {
             //Toast.makeText(getApplicationContext(), "คุณได้ " + score + "คะแนน", Toast.LENGTH_SHORT).show();
            dialogboxScore();
        } else {
            setQuetion(qID.remove(0));
        }

    }// end choiceAns() method

    private void dialogboxScore() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("Sum Score!");
        builder.setMessage("คุณได้ " + score + "คะแนน")
                .setCancelable(false)
                .setPositiveButton("play again", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        Intent intent = getIntent(); //รีเซตค่า
                        finish();
                        startActivity(intent);
                    }
                })
                .setNegativeButton("Exit", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialogInterface, int i) {
                        finish();
                    }
                });
        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }//end dialogboxscore() method
}//end class
