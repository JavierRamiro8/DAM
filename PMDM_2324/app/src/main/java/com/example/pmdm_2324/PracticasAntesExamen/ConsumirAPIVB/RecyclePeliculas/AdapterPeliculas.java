package com.example.pmdm_2324.PracticasAntesExamen.ConsumirAPIVB.RecyclePeliculas;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.example.pmdm_2324.PracticasAntesExamen.ConsumirAPIVB.CallAPI.Peliculas;
import com.example.pmdm_2324.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

    public class AdapterPeliculas extends RecyclerView.Adapter<AdapterPeliculas.ViewHolder> {
    private ArrayList<Peliculas> datos;
    private OnItemClickListener listener;

    public AdapterPeliculas(List<Peliculas> listaPeliculas) {
        datos = new ArrayList<>(listaPeliculas);
    }

    // Interface para manejar los clics en los elementos del RecyclerView
    public interface OnItemClickListener {
        void onItemClick(Peliculas pelicula);
    }

    // Método para establecer el listener
    public void setOnItemClickListener(OnItemClickListener listener) {
        this.listener = listener;
    }

    // ViewHolder para los elementos del RecyclerView
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final TextView nombrePeliculas;
        private final TextView descripcionPeliculas;
        private final TextView nombreActores;
        private final TextView urlActores;
        private final TextView urlPeliculas;
        private final TextView estrellasPeliculas;

        public ViewHolder(View view) {
            super(view);
            nombrePeliculas = view.findViewById(R.id.nombrePeliculas);
            descripcionPeliculas = view.findViewById(R.id.descripcionPeliculas);
            nombreActores = view.findViewById(R.id.nombreActores);
            estrellasPeliculas = view.findViewById(R.id.estrellasPeliculas);
            urlActores = view.findViewById(R.id.urlActoresAPI);
            urlPeliculas = view.findViewById(R.id.urlPeliculasAPI);
        }

        // Método para configurar los datos en el ViewHolder
        public void bind(Peliculas pelicula) {
            nombrePeliculas.setText(pelicula.nombre);
            descripcionPeliculas.setText(pelicula.descripcion);
            estrellasPeliculas.setText(pelicula.estrellas);
            nombreActores.setText(pelicula.actores.nombreActores.toString());
            urlPeliculas.setText(pelicula.actores.pelicula.toString());
            urlActores.setText(pelicula.actores.url.toString());
        }
    }

    // Método llamado cuando se crea un ViewHolder
    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.row_pelicula, viewGroup, false);
        return new ViewHolder(view);
    }

    // Método llamado cuando se enlazan los datos con un ViewHolder
    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        final Peliculas pelicula = datos.get(position);
        viewHolder.bind(pelicula);

        // Configuración del clic en el elemento del RecyclerView
        viewHolder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (listener != null) {
                    // Llamada al método onItemClick del listener
                    listener.onItemClick(pelicula);
                }
            }
        });
    }

    // Método que devuelve la cantidad de elementos en el RecyclerView
    @Override
    public int getItemCount() {
        return datos.size();
    }
    public void add(List<Peliculas> dataSet){
        datos.addAll(List.copyOf(dataSet));
        notifyDataSetChanged();
    }
}

