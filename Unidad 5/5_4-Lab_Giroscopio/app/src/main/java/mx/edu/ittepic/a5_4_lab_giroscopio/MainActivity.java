package mx.edu.ittepic.a5_4_lab_giroscopio;


import android.content.Context;
import android.hardware.Sensor;
import android.hardware.SensorEvent;
import android.hardware.SensorEventListener;
import android.hardware.SensorManager;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.juang.jplot.PlotPlanitoXY;

import java.util.Timer;
import java.util.TimerTask;


public class MainActivity extends AppCompatActivity implements SensorEventListener{
    private Sensor mySensor;
    private SensorManager senMan;
    TextView txt_X,txt_Y,txt_Z;
    private PlotPlanitoXY plot;
    private LinearLayout pantalla;
    Context context;

    int i=0; // contador de datos

    float [] Xd,Yd,Yd2,Xd2,Xd3,Yd3,Xd4,Yd4;
    private float[] X=new float [4000];//almacenado de
    private float[] Y=new float [4000];//datos
    private float[] X2=new float [4000];//almacenado de
    private float[] Y2=new float [4000];//datos
    private float[] X3=new float [4000];//almacenado de
    private float[] Y3=new float [4000];//datos

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);



        context=this;
        pantalla= (LinearLayout) (findViewById(R.id.grafico));

        inicia();
    }

    private void inicia() {
        // inicializamos el grafico dinamico ó serie de tiempo
        plot = new PlotPlanitoXY(context,"xx vs yy","xx","yy");//el "context" si no esta dentro del hilo UI puede simplemente colocarse this
        plot.SetEscalaAutomatica(true);// escala automatica si no se coloca true deben definirse los valores maximos de xmin,xmax,y1min,y1max,y2min,y2max
        plot.SetHD(false);

        senMan = (SensorManager) getSystemService(SENSOR_SERVICE);
        mySensor= senMan.getDefaultSensor(Sensor.TYPE_GYROSCOPE);
        txt_X=(TextView)findViewById(R.id.txtX);
        txt_Y=(TextView)findViewById(R.id.txtY);
        txt_Z=(TextView)findViewById(R.id.txtZ);
        senMan.registerListener(this,mySensor,SensorManager.SENSOR_DELAY_NORMAL);


        Timer timer = new Timer();
        TimerTask task = new TimerTask()
        {
            /* se inicia un hilo en paralelo para ejecutar la tarea asincrona podria usarse tambien la clase AnsycTask y usar su
               su hilo especifico para acceder a la UI */
            @Override
            public void run()
            {
                //hilo para comunicarse con la UI intefaz de usuario y poder pintar el el LinearLayout "pantalla"
                runOnUiThread(new Runnable()
                {
                    @Override
                    public void run()
                    {
                        pantalla.removeAllViews();

                        Xd=new float[i+1]; Xd[0]=0;
                        Yd=new float[i+1];
                        Xd2=new float[i+1];
                        Yd2=new float[i+1];
                        Xd3=new float[i+1];
                        Yd3=new float[i+1];

                        X[i]=i;
                        Y[i]=0;
                        for (int j = 0; j < Xd.length; j++) {
                            Xd[j]= X[j];
                            Yd[j] =Float.parseFloat(txt_X.getText().toString());
                        }

                        X2[i]=i;
                        Y2[i]=0;
                        for (int j = 0; j < Xd2.length; j++) {
                            Xd2[j]= X2[j];
                            Yd2[j] =Float.parseFloat(txt_Y.getText().toString());
                        }

                        X3[i]=i;
                        Y3[i]=0;
                        for (int j = 0; j < Xd3.length; j++) {
                            Xd3[j]= X3[j];
                            Yd3[j] =Float.parseFloat(txt_Z.getText().toString());
                        }
                        plot.SetSerie1(Xd,Yd,"Eje X",8,true);// el true indica que unira los puntos con recta
                        plot.SetSerie2(Xd2,Yd2,"Eje Y",8,true,2);// este dato se grafica en el eje y2(lado derecho)
                        plot.SetSerie3(Xd3,Yd3,"Eje Z",8,true,1);// se grafica en el eje y1(lado izquierdo), tamaño de punto 5

                        pantalla.addView(plot);
                        i=i+1;
                    }//hilo2
                });//hilo para acceder a la intefaz grafica
            }//hilo1
        };
        timer.schedule(task, 1000, 200);// el timer se ejecura despues de 1000ms=1seg de haber precionando el boton "plot2d" y se repite cada 200ms
    }

    @Override
    public void onSensorChanged(SensorEvent event) {

        txt_X.setText(""+event.values[0]);
        txt_Y.setText(""+event.values[1]);
        txt_Z.setText(""+event.values[2]);
    }

    @Override
    public void onAccuracyChanged(Sensor sensor, int accuracy) {

    }
}


