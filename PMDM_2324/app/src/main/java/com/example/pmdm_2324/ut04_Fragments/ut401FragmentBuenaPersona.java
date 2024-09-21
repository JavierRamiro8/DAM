package com.example.pmdm_2324.ut04_Fragments;

import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.text.Layout;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pmdm_2324.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ut401FragmentBuenaPersona#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ut401FragmentBuenaPersona extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ut401FragmentBuenaPersona() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ut401FragmentBuenaPersona.
     */
    // TODO: Rename and change types and number of parameters
    public static ut401FragmentBuenaPersona newInstance(String param1, String param2) {
        ut401FragmentBuenaPersona fragment = new ut401FragmentBuenaPersona();
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

    TextView imprimirBarra;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View layout = inflater.inflate(R.layout.fragment_ut401_buena_persona, container, false);
        imprimirBarra = layout.findViewById(R.id.ut401idtvBarra);
        imprimirBarra.setOnClickListener((View v) -> {
            imprimirBarra.append("|");
        });
        return layout;
    }
}