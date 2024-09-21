package com.example.pmdm_2324.ut04_Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import com.example.pmdm_2324.R;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ut403PingPong#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ut403PingPong extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ut403PingPong() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ut402PingPong.
     */
    // TODO: Rename and change types and number of parameters
    public static ut403PingPong newInstance(String param1, String param2) {
        ut403PingPong fragment = new ut403PingPong();
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

    TextView jugador1, jugador2;
    Button jugar;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_ut403_ping_pong, container, false);
        jugador1=layout.findViewById(R.id.ut403idTvPuntuacionJ1);
        jugador2=layout.findViewById(R.id.ut403idTvPuntuacionJ2);
        jugar=layout.findViewById(R.id.ut403idBtJugamos);
        return layout;
    }
}