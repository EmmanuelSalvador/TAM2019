package mx.edu.ittepic.a3_3_laboratorio_json;

import android.support.v7.widget.RecyclerView;

public interface RecyclerItemTouchHelperListener {
    void onSwipe(RecyclerView.ViewHolder viewHolder, int direccion, int posicion);
}
