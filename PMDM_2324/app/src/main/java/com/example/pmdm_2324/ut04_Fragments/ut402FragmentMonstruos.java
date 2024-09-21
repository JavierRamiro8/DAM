package com.example.pmdm_2324.ut04_Fragments;

import android.graphics.Color;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.fragment.app.Fragment;

import com.example.pmdm_2324.R;
import com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.Monstruo;
import com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.MonstruoParaFragments;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ut402FragmentMonstruos#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ut402FragmentMonstruos extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    // TextView para mostrar el monstruo

    public ut402FragmentMonstruos() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ut402Monstruos.
     */
    // TODO: Rename and change types and number of parameters
    public static ut402FragmentMonstruos newInstance(String param1, String param2) {
        ut402FragmentMonstruos fragment = new ut402FragmentMonstruos();
        Bundle args = new Bundle();
        args.putString(ARG_PARAM1, param1);
        args.putString(ARG_PARAM2, param2);
        fragment.setArguments(args);
        return fragment;
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        if (getArguments() != null) {
            mParam1 = getArguments().getString(ARG_PARAM1);
            mParam2 = getArguments().getString(ARG_PARAM2);
        }
    }

    TextView mostrarMonstruo;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_ut402_monstruos, container, false);
        mostrarMonstruo = layout.findViewById(R.id.ut402idfrMostrarMonstruo);
        return layout;
    }

    public void actualizarMonstruo(MonstruoParaFragments monstruo) {
        if (mostrarMonstruo != null) {
            mostrarMonstruo.setTextColor(Color.parseColor(monstruo.getColor()));
            mostrarMonstruo.setText(monstruo.toString());
        }
    }
}
