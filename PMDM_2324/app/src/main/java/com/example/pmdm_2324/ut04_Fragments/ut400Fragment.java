package com.example.pmdm_2324.ut04_Fragments;

import android.graphics.Color;
import android.os.Bundle;

import androidx.fragment.app.Fragment;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.pmdm_2324.R;

/**
 * A simple {@link Fragment} subclass.
 * Use the {@link ut400Fragment#newInstance} factory method to
 * create an instance of this fragment.
 */
public class ut400Fragment extends Fragment {

    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";

    private static final double COLOR_RANGE = 254;

    // TODO: Rename and change types of parameters
    private String mParam1;
    private String mParam2;

    public ut400Fragment() {
        // Required empty public constructor
    }

    /**
     * Use this factory method to create a new instance of
     * this fragment using the provided parameters.
     *
     * @param param1 Parameter 1.
     * @param param2 Parameter 2.
     * @return A new instance of fragment ut401Fragment.
     */
    // TODO: Rename and change types and number of parameters
    public static ut400Fragment newInstance(String param1, String param2) {
        ut400Fragment fragment = new ut400Fragment();
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

    TextView tvHola;

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View layout = inflater.inflate(R.layout.fragment_ut400, container, false);
        tvHola = layout.findViewById(R.id.ut401FragmentPrincipal);
        tvHola.setOnClickListener((v) -> {
            int c = Color.argb(
                    (int) (Math.random() * COLOR_RANGE),
                    (int) (Math.random() * COLOR_RANGE),
                    (int) (Math.random() * COLOR_RANGE),
                    (int) (Math.random() * COLOR_RANGE)
            );
            tvHola.setBackgroundColor(c);
            if (observer != null) {
                observer.OnColorChange(c);
            }
        });
        return layout;
    }

    public void setColor(int a, int r, int g, int b) {
        tvHola.setBackgroundColor(Color.argb(a, r, g, b));
    }

    ;

    public interface ICambiaColor {
        public void OnColorChange(int c);
    }

    ICambiaColor observer;

    public void addColorChangeListener(ICambiaColor elQueRecibe) {
        observer = elQueRecibe;
    }
}