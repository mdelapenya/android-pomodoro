package es.mdelapenya.android.pomodoro;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_main);

        txtPomodoro = (TextView) findViewById(R.id.pomodoroTime);

        txtPomodoro.setText(R.string.defaultPomodoroValue);
    }

    private TextView txtPomodoro;

}
