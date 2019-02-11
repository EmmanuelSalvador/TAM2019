package com.ejemplo.rcview2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

public class MainActivity extends AppCompatActivity {

    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter;
    private RecyclerView.LayoutManager layoutManager;

    String [] nombres={"ARANDA PATRON NOMAR JAZIEL",
            "CARDENAS RAMOS FRANCISCO EMANUEL",
            "CASTILLO CORRALES VICTOR EMMANUEL",
            "CERVANTES JIMÉNEZ JOSÉ MIGUEL",
            "CORDERO RIVERA SELVA YAZMIN",
            "CORDERO VILLA OSCAR ALBERTO",
            "ESPINOSA ABANDO DENISSE YANETH",
            "FIGUEROA CUETO JUAN RAMON",
            "GALLEGOS GODINEZ FRANCISCO JAVIER",
            "GIL LLANOS JUAN PEDRO",
            "GONZALEZ ARELLANO ERNESTO",
            "GUTIERREZ ESPARZA BRAYAN JESUS",
            "GUTIÉRREZ ROJAS BRYAN",
            "LOPEZ ALVARADO MISSAEL",
            "MARTINEZ BAÑUELOS ERIKA LIZBETH",
            "MENDEZ SANTANA KEVIN ALEJANDRO",
            "MONROY SALCEDO JOSE DE JESUS",
            "PADILLA SIMÓN BRIAN EFRÉN",
            "PARRA DOMINGUEZ DYLAN SALVADOR",
            "PEREZ ARAIZA FLOR MARIELA",
            "PUGA FLORES CARLOS",
            "REYES GODINEZ CARLA GUADALUPE",
            "REYES GUERRERO GUILLERMO GUADALUPE",
            "RICO ESPARZA HENRY",
            "RIVERA RAMIREZ DAVID",
            "SANCHEZ CARRILLO BETSY DEL CARMEN",
            "SILVA CAMACHO EDUARDO LUIS",
            "TORRES CUETO JESUS MANUEL",
            "VALDEZ LOPEZ HOLLIVER EDUARDO",
            "VALENZUELA MIRAMONTES JOSE PABLO",
            "ZAMORANO ALCALÁ GUILLERMO"};

    String [] numControl={"14400901",
            "14400902",
            "14400903",
            "14400904",
            "14400905",
            "14400906",
            "14400907",
            "14400908",
            "14400909",
            "14400910",
            "14400911",
            "14400912",
            "14400913",
            "14400914",
            "14400915",
            "14400916",
            "14400917",
            "14400918",
            "14400919",
            "14400920",
            "14400921",
            "14400922",
            "14400923",
            "14400924",
            "14400925",
            "14400926",
            "14400927",
            "14400928",
            "14400929",
            "14400930",
            "14400931"};
    String [] carrera={"Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "ITIC'S",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas",
            "Sistemas"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Crear referencias hacia el componente RecycleriView
        recyclerView = findViewById(R.id.recycler_id);

        // Crear un objeto de tipo RecyclerAdapter que recibe un arreglo de cadenas
        adapter = new RecyclerAdapter(nombres,numControl,carrera, this);
        // Crea un objeto de tipo LinearLayoutManager
        layoutManager = new LinearLayoutManager(this);

        // Establecer el LayautManager
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);

        // Establecer el Adapter
        recyclerView.setAdapter(adapter);

    }
}
