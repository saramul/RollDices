package cs.ubru.rolldice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

    private Button btnRoll;
    private ImageView imgDice, imgDice1, imgDice2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initComponent();
        btnRoll.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                int n1 = (int) (Math.random()*6 + 1);
                imgDice.setImageResource(rollDice(n1));

                int n2 = (int) (Math.random()*6 + 1);
                imgDice1.setImageResource(rollDice(n2));

                int n3 = (int) (Math.random()*6 + 1);
                imgDice2.setImageResource(rollDice(n3));

                final int result = n1+n2+n3;

                Handler handler = new Handler();
                handler.postDelayed(new Runnable() {
                    @Override
                    public void run() {
                        Intent intent = new Intent(MainActivity.this, ResultActivity.class);
                        intent.putExtra("result", result);
                        startActivity(intent);
                    }
                }, 900);


            }
        });
    }

    private int rollDice(int n) {
        int id = R.drawable.dice_one_64px;
        switch (n) {
            case 1: id = R.drawable.dice_1;break;
            case 2: id = R.drawable.dice_2;break;
            case 3: id = R.drawable.dice_3;break;
            case 4: id = R.drawable.dice_4;break;
            case 5: id = R.drawable.dice_5;break;
            case 6: id = R.drawable.dice_6;break;
        }
        return id;
    }

    private void initComponent() {
        btnRoll = findViewById(R.id.btn_roll);
        imgDice = findViewById(R.id.img_dice);
        imgDice1 = findViewById(R.id.img_dice_1);
        imgDice2 = findViewById(R.id.img_dice_2);

    }
}