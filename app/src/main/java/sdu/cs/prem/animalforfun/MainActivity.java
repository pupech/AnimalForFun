package sdu.cs.prem.animalforfun;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    String nameString ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        final EditText nameText = findViewById(R.id.edtName);
        Button startButton = findViewById(R.id.btnStart);

        startButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                nameString = nameText.getText().toString();
                if (nameString.length() == 0) {
                    Toast.makeText(getApplicationContext(), "กรุณาใส่ชื่อก่อน", Toast.LENGTH_SHORT)
                            .show();
                } else { Toast.makeText(getApplicationContext(),"ยินดีต้อนรับ"+nameString+"เข้าสู่ระบบ",
                        Toast.LENGTH_SHORT).show();

                }
            }
        });
    } //End ocCeate()Mwthod
} //End class
