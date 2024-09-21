    package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades;
    import static com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.u303Heladeria.CHOCOLATE;
    import static com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.u303Heladeria.FRESA;
    import static com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.u303Heladeria.TIPOTARRINA;
    import static com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.u303Heladeria.VAINILLA;

    import androidx.appcompat.app.AppCompatActivity;

    import android.graphics.Color;
    import android.os.Bundle;
    import android.widget.TextView;

    import com.example.pmdm_2324.R;

    public class u303ResultadoHeladeria extends AppCompatActivity {
    static final int NULO=0;
    static boolean vacio=false;
        TextView fresaResumen,vainillaResumen,chocoResumen,tipoResumen;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_ut303_resultado_heladeria);
            fresaResumen=findViewById(R.id.u303tvFresaResumen);
            chocoResumen=findViewById(R.id.u303tvChocolateResumen);
            vainillaResumen=findViewById(R.id.u303tvVainillaResumen);
            tipoResumen=findViewById(R.id.u303tvTipoResumen);
            String vainilla = getIntent().getStringExtra(VAINILLA);
            String chocolate = getIntent().getStringExtra(CHOCOLATE);
            String fresa = getIntent().getStringExtra(FRESA);
            String tipo = getIntent().getStringExtra(TIPOTARRINA);
            int bolasVainilla=0;
            int bolasFresa=0;
            int bolasChoco=0;
            if (vainilla != null) {
                bolasVainilla = Integer.parseInt(vainilla);
            }

            if (chocolate != null) {
                 bolasChoco = Integer.parseInt(chocolate);
            }

            if (fresa != null) {
                 bolasFresa = Integer.parseInt(fresa);
            }

            if(bolasVainilla >= NULO){
                for(int i=1;i<=bolasVainilla;i++){
                    vainillaResumen.setTextColor(Color.YELLOW);
                    vainillaResumen.append("( )");
                }
            }
            if(bolasFresa>=NULO){
                for(int i=1;i<=bolasFresa;i++){
                    fresaResumen.setTextColor(Color.rgb(255,182,193));
                    fresaResumen.append("( )");
                }
            }
            if(bolasChoco>=NULO){
                for(int i=1;i<=bolasChoco;i++){
                    chocoResumen.setTextColor(Color.rgb(128,60,0));
                    chocoResumen.append("( )");
                }
            }
            if(tipo.equals("Cucurucho")){
                tipoResumen.setText("\\/");
            }else if(tipo.equals("Cucurucho_de_chocolate")){
                tipoResumen.setTextColor(Color.rgb(128,60,0));
                tipoResumen.append("\\/");
            }else if(tipo.equals("Tarrina")){
                tipoResumen.setText("U");
            }
        }
    }
