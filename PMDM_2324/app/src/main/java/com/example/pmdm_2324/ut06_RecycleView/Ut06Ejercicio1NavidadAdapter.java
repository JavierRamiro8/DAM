package com.example.pmdm_2324.ut06_RecycleView;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_2324.R;

import java.util.ArrayList;
import java.util.Arrays;

public class Ut06Ejercicio1NavidadAdapter extends RecyclerView.Adapter<Ut06Ejercicio1NavidadAdapter.ViewHolder> {

    private ArrayList<Ut06Ejercicio1Dulces> datos;

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView dulceNavidenio;

        public ViewHolder(View view) {
            super(view);
            dulceNavidenio= (TextView) view.findViewById(R.id.ut06e1Resultado);
        }

        public TextView getTextDulce() {
            return dulceNavidenio;
        }
    }

    /**
     * Initialize the dataset of the Adapter.
     *
     * @param dataSet String[] containing the data to populate views to be used
     * by RecyclerView.
     */
    public Ut06Ejercicio1NavidadAdapter(Ut06Ejercicio1Dulces[] dataSet) {
        datos = new ArrayList<Ut06Ejercicio1Dulces>();
        add(dataSet);
    }
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Create a new view, which defines the UI of the list item
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.row_dulce, viewGroup, false);

        return new ViewHolder(view);
    }
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element
        viewHolder.getTextDulce().setText(datos.get(position).nombreDulce + ", "+datos.get(position).frutoSeco+" tiene frutos secos" +" y tiene "+datos.get(position).calorias+" Calorias" );
    }
    public int getItemCount() {
        return datos.size();
    }

    public void add(Ut06Ejercicio1Dulces[] dataSet){
        datos.addAll(Arrays.asList(dataSet));
        notifyDataSetChanged();
    }
}
