package mx.edu.ittepic.u4_lab1_asynctask;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ProgressBar;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edtNumero;
    TextView txtResultado;
    Button btnCalcular;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edtNumero = findViewById(R.id.edtNumero);
        txtResultado = findViewById(R.id.txtResultado);
        btnCalcular = findViewById(R.id.btnCalcular);

        btnCalcular.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                AsyncTarea asyncTarea = new AsyncTarea();
                asyncTarea.execute(Integer.parseInt(edtNumero.getText().toString()));
            }
        });
    }

    private class  AsyncTarea extends AsyncTask<Integer, Integer,Boolean> {
        String resultado="0, 1, ";
        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Boolean doInBackground(Integer... params) {
            if (Integer.parseInt(edtNumero.getText().toString())==1){
                resultado = "0.";
            }
            else if (Integer.parseInt(edtNumero.getText().toString())==2) {
                resultado="0, 1. ";
            }
            else {
                long n1 = 0;
                long n2 = 1;
                long aux;
                long limite = Long.parseLong(edtNumero.getText().toString()) - 2;
                int i = 1;
                while ((i) <= limite) {

                    aux = n1;
                    n1 = n2;
                    n2 = aux + n1;
                    i++;
                    if (i == limite + 1) {
                        resultado += " " + n2 + ".";
                    } else {
                        resultado += " " + n2 + ", ";
                    }
                }
            }
            return true;
        }

        @Override
        protected void onProgressUpdate(Integer... values) {
            super.onProgressUpdate(values);
        }

        @Override
        protected void onPostExecute(Boolean aVoid) {
            super.onPostExecute(aVoid);
            txtResultado.setText(resultado);
        }


        @Override
        protected void onCancelled() {
            super.onCancelled();
        }


    }
}
