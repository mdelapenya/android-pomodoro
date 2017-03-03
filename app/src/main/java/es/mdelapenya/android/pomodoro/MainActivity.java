package es.mdelapenya.android.pomodoro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnPause = (Button) findViewById(R.id.btnPause);
        btnStart = (Button) findViewById(R.id.btnStart);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        txtPomodoro = (TextView) findViewById(R.id.pomodoroTime);

        progressBar.setMax(60);
        progressBar.setProgress(20);
        txtPomodoro.setText(R.string.defaultPomodoroValue);
    }

    private Button btnPause;
    private Button btnStart;
    private ProgressBar progressBar;
    private TextView txtPomodoro;

}
