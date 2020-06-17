package cs.ubru.rolldice;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ResultActivity extends AppCompatActivity {
    private TextView tvResult, tvScore;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_result);

        initComponent();

        Intent intent = getIntent();
        int result = intent.getIntExtra("result", 3);
        if(result>=3 && result<=10) {
            tvResult.setText("LO");

        }else if(result==11) {
            tvResult.setText("HI-LO");

        }else{
            tvResult.setText("HI");
        }
        tvScore.setText(result + " แต้ม");
    }

    private void initComponent() {
        tvResult = findViewById(R.id.tv_result);
        tvScore = findViewById(R.id.tv_score);
    }
}