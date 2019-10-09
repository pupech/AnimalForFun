package sdu.cs.prem.animalforfun;

import androidx.appcompat.app.AppCompatActivity;

import android.media.MediaPlayer;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ImageView;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;

public class Game extends AppCompatActivity {
    //Explicit
    ImageView quetionImageView ;
    ImageButton volumeImageButton;
    Button btn1,btn2,btn3, btn4;
    int questionCount = 1;
    ArrayList<Integer> qID = new ArrayList<Integer>();
    String answer;
    MediaPlayer mediaPlayer; 
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
    }//end Question
}//end class
