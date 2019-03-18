package mx.edu.ittepic.unidad3_31jsonclima;

import android.graphics.BitmapFactory;
import android.net.Uri;
import android.nfc.cardemulation.CardEmulation;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.CardView;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.squareup.picasso.Picasso;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.InputStream;
import java.math.RoundingMode;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.text.DecimalFormat;

public class MainActivity extends AppCompatActivity implements AsyncResponse  {

    ConexionWeb conexionWeb;
    TextView nombre,biografia;
    EditText edNombre;
    Button consultar;
    CardView c;
    ImageView imagen;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        nombre=findViewById(R.id.nombre);
        biografia=findViewById(R.id.biografia);
        consultar = findViewById(R.id.button);
        edNombre = findViewById(R.id.edNombre);
        imagen=findViewById(R.id.imageView);
        c=findViewById(R.id.cardView);
        consultar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                CargarArtista(); c.setVisibility(View.VISIBLE);
            }
        });
    }
    public void CargarArtista() {
        try {
            conexionWeb = new ConexionWeb(MainActivity.this);
            String cad = "http://ws.audioscrobbler.com/2.0/?method=artist.getinfo&artist="+edNombre.getText().toString()+"&api_key=04664c9b86b5c9132c3c0bb1d029d916&format=json";
            URL direcciopn = new URL(cad);
            conexionWeb.execute(direcciopn);
        } catch (MalformedURLException e) {
            Toast.makeText(MainActivity.this, e.getMessage(), Toast.LENGTH_LONG).show();
        }
    }
    @Override
    public void procesarRespuesta(String r) {
        try {

            JSONObject object = new JSONObject(r);

            JSONObject artist = object.getJSONObject("artist");
            nombre.setText("Nombre: "+artist.getString("name"));
            JSONArray image = artist.getJSONArray("image");
            JSONObject cuatro = image.getJSONObject(2);
            String url = cuatro.getString("#text");
            loadImageFromUrl(url);

            JSONObject bio = artist.getJSONObject("bio");
            biografia.setText(bio.getString("summary"));


        }catch (JSONException e){
            Toast.makeText(this, ""+e, Toast.LENGTH_SHORT).show();
        }
    }

    private void loadImageFromUrl(String url) {

        Picasso.with(this).load(url).placeholder(R.mipmap.ic_launcher) // optional
                .error(R.mipmap.ic_launcher) //if error
                .into(imagen,new com.squareup.picasso.Callback(){


                    @Override
                    public void onSuccess() {

                    }

                    @Override
                    public void onError() {

                    }
                });
    }
}
