package mx.edu.ittepic.a1_3_pulsador;

import android.content.Intent;
import android.os.CountDownTimer;
import android.support.constraint.ConstraintLayout;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import java.math.RoundingMode;
import java.text.DecimalFormat;
import java.util.Random;

public class MainActivity extends AppCompatActivity {

    TextView tiempoEstable, timer;
    Button nuevo;
    CountDownTimer countdowntimer;
    double incremento=0.0, contador, n;
    ConstraintLayout layin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        tiempoEstable = findViewById(R.id.numero);
        timer = findViewById(R.id.Txt_timer);
        nuevo = findViewById(R.id.Btn_nuevo);
        layin = findViewById(R.id.layo);


        double numRandom =(Math.random()*(3.0-1.0)+1.0);

        final DecimalFormat formatoDec = new DecimalFormat("#.#");
        formatoDec.setRoundingMode(RoundingMode.FLOOR);

        n = new Double(formatoDec.format(numRandom));
        tiempoEstable.setText(""+n);

        countdowntimer = new CountDownTimer(100000, 800) {
            @Override
            public void onTick(long millisUntilFinished) {
                contador = new Double(formatoDec.format(incremento));
                timer.setText(""+contador);
                incremento+=0.1;

                if (contador==3.0){
                    Toast.makeText(MainActivity.this, "Perdiste", Toast.LENGTH_LONG).show();
                    countdowntimer.cancel();
                }

            }

            @Override
            public void onFinish() {
                timer.setText(""+contador);
            }
        };

        countdowntimer.start();

        timer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (n==contador){
                    Toast.makeText(MainActivity.this, "Bien hecho Ganaste", Toast.LENGTH_LONG).show();
                    //layin.setBackgroundColor(Integer.parseInt("#79FF76"));
                }
                if (contador<n || contador>n){
                    Toast.makeText(MainActivity.this, "Perdiste", Toast.LENGTH_LONG).show();
                }
                countdowntimer.cancel();
            }
        });

        nuevo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent nuevaPantalla = new Intent(MainActivity.this, MainActivity.class);
                startActivity(nuevaPantalla);
            }
        });

    }
}
