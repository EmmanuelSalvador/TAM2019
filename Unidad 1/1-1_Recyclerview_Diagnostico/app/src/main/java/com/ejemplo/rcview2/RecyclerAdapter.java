package com.ejemplo.rcview2;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

/**
 * Created by lenovo on 20/02/2018.
 */

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private String[] nombres, numControl, carrera;
    Context con;


    public RecyclerAdapter(String[] nombres, String[] numControl, String[] carrera, Context context) {
        this.nombres = nombres;
        this.numControl = numControl;
        this.carrera = carrera;
        con=context;
    }


    @Override
    public RecyclerViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_layout,parent,false);
        RecyclerViewHolder recyclerViewHolder = new RecyclerViewHolder(view);
        return recyclerViewHolder;
    }

    @Override
    public void onBindViewHolder(RecyclerViewHolder holder, final int position) {
        holder.campo_nombre.setText(nombres[position]);
        holder.campo_numControl.setText(numControl[position]);
        holder.campo_carrera.setText(carrera[position]);
        holder.contacto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(con, "Actualizar al alumno "+nombres[position]+", de la carrera: "+carrera[position]+", con numero de control: "+numControl[position], Toast.LENGTH_SHORT).show();
            }
        });
        holder.eliminar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(con, "Eliminar a "+nombres[position]+"de la carrera: "+carrera[position]+", con numero de control: "+numControl[position], Toast.LENGTH_SHORT).show();
            }
        });
    }

    @Override
    public int getItemCount() {
        return nombres.length;
    }

    public static class RecyclerViewHolder extends RecyclerView.ViewHolder {
        TextView campo_nombre;
        TextView campo_numControl;
        TextView campo_carrera;
        ImageView contacto, eliminar;
        public RecyclerViewHolder(View itemView) {
            super(itemView);

            campo_nombre = itemView.findViewById(R.id.alumno_id);
            campo_numControl = itemView.findViewById(R.id.alumno_numControl);
            campo_carrera = itemView.findViewById(R.id.alumno_carrera);
            contacto = itemView.findViewById(R.id.contactoImagen);
            eliminar = itemView.findViewById(R.id.eliminarImagen);

        }
    }

}
