package es.mdelapenya.android.pomodoro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        btnPause = (Button) findViewById(R.id.btnPause);
        btnStart = (Button) findViewById(R.id.btnStart);
        progressBar = (ProgressBar) findViewById(R.id.progressBar);
        txtPomodoro = (TextView) findViewById(R.id.pomodoroTime);

        initializeWidgets();
    }

    private void initializeWidgets() {
        progressBar.setMax(TOTAL_SECONDS);
        progressBar.setProgress(INITIAL_SECONDS);
        txtPomodoro.setText(R.string.defaultPomodoroValue);

        btnPause.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                pomodoroCountdownTimer.start();

                Toast.makeText(
                    view.getContext(), R.string.pausing_pomodoro, Toast.LENGTH_SHORT).show();
            }

        });

        btnStart.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                pomodoroCountdownTimer.start();

                Toast.makeText(
                    view.getContext(), R.string.starting_pomodoro, Toast.LENGTH_SHORT).show();
            }

        });

        pomodoroCountdownTimer = new PomodoroCountdownTimer(
            TOTAL_SECONDS, TOTAL_SECONDS, new PomodoroCountdownTimer.Listener() {

                @Override
                public void onProgressChange(int progress) {
                    progressBar.setProgress(progress);
                }

                @Override
                public void onCountDownChange(String countDown) {
                    txtPomodoro.setText(countDown);
                }

                @Override
                public void onFinish() {
                    txtPomodoro.setText("00:00");
                    progressBar.setProgress(INITIAL_SECONDS + TOTAL_SECONDS);
                }
            }
        );
    }

    private static final int INITIAL_SECONDS = 0;
    private static final int TOTAL_SECONDS = 10;

    private Button btnPause;
    private Button btnStart;
    private PomodoroCountdownTimer pomodoroCountdownTimer;
    private ProgressBar progressBar;
    private TextView txtPomodoro;

}
