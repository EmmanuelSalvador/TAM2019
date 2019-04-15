package mx.edu.ittepic.a3_3_laboratorio_json;


import android.content.Context;
import android.graphics.Color;
import android.support.annotation.NonNull;
import android.support.design.widget.Snackbar;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.MyViewHolder> {

    private Context context;
    private List<Item> list;

    public CardListAdapter(Context context, List<Item> list) {
        this.context = context;
        this.list = list;
    }

    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itemView = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.card_list_item, viewGroup, false);
        return new MyViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final MyViewHolder myViewHolder, final int i) {

        final Item item = list.get(i);
        myViewHolder.nombreAlumno.setText(item.getName());
        myViewHolder.noControl.setText(item.getNoControl());
        myViewHolder.cel.setText(item.getCel());
        //myViewHolder.cel.setText(item.getCalificacion());
        myViewHolder.carrera.setText(item.getCarrera());

        /*int intCalificacion = Integer.parseInt(myViewHolder.cel.getText().toString());
        colorRojo(intCalificacion, myViewHolder);

        myViewHolder.imagen.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Snackbar snackbar = Snackbar.make(myViewHolder.frameLayout, "Eliminar a: "+myViewHolder.noControl.getText().toString(), -15);
                snackbar.setAction("ELIMINAR", new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        removeItem(i);
                    }
                });
                snackbar.setActionTextColor(Color.WHITE);
                snackbar.show();
            }
        });*/

    }

    private void colorRojo(int intCalificacion, MyViewHolder myViewHolder) {
        if (intCalificacion > 70){
            myViewHolder.viewForeground.setBackgroundColor(Color.parseColor("#F2826A"));
        }
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public void removeItem(int posicion){
        list.remove(posicion);
        notifyItemRemoved(posicion);
        notifyItemRangeChanged(posicion, list.size());
    }

    public void restoreItem(Item item, int posicion){
        list.add(posicion, item);
        notifyItemInserted(posicion);
    }

    public class MyViewHolder extends RecyclerView.ViewHolder{
        public TextView nombreAlumno, noControl, cel,  carrera;
        public ImageView imagen;
        public RelativeLayout viewBackgroud, viewForeground;
        public FrameLayout frameLayout;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            frameLayout = itemView.findViewById(R.id.frame);
            nombreAlumno = itemView.findViewById(R.id.nombreAlumno);
            noControl = itemView.findViewById(R.id.noControl);
            cel = itemView.findViewById(R.id.cel);
            carrera = itemView.findViewById(R.id.carrera);
            imagen = itemView.findViewById(R.id.thumbnail);
            viewBackgroud = itemView.findViewById(R.id.view_background);
            viewForeground = itemView.findViewById(R.id.view_foreground);
        }
    }

}
