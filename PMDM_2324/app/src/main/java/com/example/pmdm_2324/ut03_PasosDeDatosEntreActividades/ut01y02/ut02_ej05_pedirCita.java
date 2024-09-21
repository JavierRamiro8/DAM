package com.example.pmdm_2324.ut03_PasosDeDatosEntreActividades.ut01y02;

import androidx.appcompat.app.AppCompatActivity;
import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.TimePicker;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import com.example.pmdm_2324.R;

public class ut02_ej05_pedirCita extends AppCompatActivity {
    Button fecha, tiempo, aceptar;
    EditText introducirDNI;
    TextView fechaSeleccionada, horaSeleccionada, fechaError, horaError, DNIerror,Resumen,header,lbDNI;
    Calendar calendar;

    View tick;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_ut02_ej05_pedir_cita);

        fecha = findViewById(R.id.ut205btFecha);
        tiempo = findViewById(R.id.ut205btHora);
        aceptar = findViewById(R.id.ut205Aceptar);
        introducirDNI = findViewById(R.id.ut205edtvIntroducirDNI);
        fechaSeleccionada = findViewById(R.id.ut205edtvFechaSeleccionada);
        horaSeleccionada = findViewById(R.id.ut205tvHoraSeleccionada);
        horaError = findViewById(R.id.ut205tvHoraError);
        fechaError = findViewById(R.id.ut205tvFechaError);
        DNIerror = findViewById(R.id.ut205tvDNIError);
        Resumen=findViewById(R.id.ut205tvResumen);
        header=findViewById(R.id.ut205_header);
        lbDNI=findViewById(R.id.ut205tvLbDNI);
        tick=findViewById(R.id.ut205Img);

        calendar = Calendar.getInstance();

        fecha.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDatePickerDialog();
            }
        });

        tiempo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showTimePickerDialog();
            }
        });

        aceptar.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                boolean horaValida = !horaValida(calendar);
                boolean dniValido = isValidDNI(introducirDNI.getText().toString());
                boolean fechaValida = !fechaError.getText().toString().equals("Fecha no válida o esta vacio");

                if (horaValida && dniValido && fechaValida && fechaSeleccionada.getText()!="" && horaSeleccionada.getText()!="") {
                    ocultarElementos();
                    Resumen.setText("Vamos a repartir amor al DNI: " + introducirDNI.getText().toString() +" El dia: " +fechaSeleccionada.getText().toString() + " a las: "+horaSeleccionada.getText().toString());
                    tick.setVisibility(View.VISIBLE);
                } else {
                    // Alguno de los datos no es válido, muestra un mensaje de error apropiado
                    if (!horaValida) {
                        horaError.setText("Hora no válida");
                    }
                    if (!dniValido) {
                        DNIerror.setText("DNI no válido");
                    }
                    if (!fechaValida) {
                        fechaError.setText("Fecha no válida");
                    }
                }
            }
        });

    }

    private void showDatePickerDialog() {
        DatePickerDialog datePickerDialog = new DatePickerDialog(
                this,
                new DatePickerDialog.OnDateSetListener() {
                    @Override
                    public void onDateSet(DatePicker view, int year, int monthOfYear, int dayOfMonth) {
                        calendar.set(Calendar.YEAR, year);
                        calendar.set(Calendar.MONTH, monthOfYear);
                        calendar.set(Calendar.DAY_OF_MONTH, dayOfMonth);

                        Calendar fechaSistema = Calendar.getInstance();
                        if (calendar.before(fechaSistema) || SemanaValida(calendar)) {
                            fechaError.setText("Fecha no válida");
                        } else {
                            SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                            fechaSeleccionada.setText(sdf.format(calendar.getTime()));
                        }
                    }

                },
                calendar.get(Calendar.YEAR),
                calendar.get(Calendar.MONTH),
                calendar.get(Calendar.DAY_OF_MONTH)
        );

        datePickerDialog.getDatePicker().setMinDate(new Date().getTime());

        datePickerDialog.show();
    }

    private void showTimePickerDialog() {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);

        TimePickerDialog timePickerDialog = new TimePickerDialog(
                this,
                new TimePickerDialog.OnTimeSetListener() {
                    @Override
                    public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
                        calendar.set(Calendar.HOUR_OF_DAY, hourOfDay);
                        calendar.set(Calendar.MINUTE, minute);

                        SimpleDateFormat sdf = new SimpleDateFormat("HH:mm");
                        horaSeleccionada.setText(sdf.format(calendar.getTime()));
                    }
                },
                hour,
                minute,
                true
        );
        timePickerDialog.show();
    }

    private boolean horaValida(Calendar calendar) {
        int hour = calendar.get(Calendar.HOUR_OF_DAY);
        int minute = calendar.get(Calendar.MINUTE);
        return (hour < 9 || hour > 14);
    }

    private boolean SemanaValida(Calendar calendar) {
        int dayOfWeek = calendar.get(Calendar.DAY_OF_WEEK);
        return (dayOfWeek == Calendar.SATURDAY || dayOfWeek == Calendar.SUNDAY);
    }

    private boolean isValidDNI(String dni) {
        String regex = "[0-9]{8}[A-Z]";
        Pattern pattern = Pattern.compile(regex);
        Matcher matcher = pattern.matcher(dni);
        return matcher.matches();
    }

    private void ocultarElementos() {
        fecha.setVisibility(View.GONE);
        tiempo.setVisibility(View.GONE);
        introducirDNI.setVisibility(View.GONE);
        fechaSeleccionada.setVisibility(View.GONE);
        horaSeleccionada.setVisibility(View.GONE);
        horaError.setVisibility(View.GONE);
        fechaError.setVisibility(View.GONE);
        DNIerror.setVisibility(View.GONE);
        aceptar.setVisibility(View.GONE);
        header.setVisibility(View.GONE);
        lbDNI.setVisibility(View.GONE);
    }
}




