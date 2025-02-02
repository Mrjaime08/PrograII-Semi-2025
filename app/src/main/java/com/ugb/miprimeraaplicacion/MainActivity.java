package com.ugb.miprimeraaplicacion;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioGroup;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {
    Button btn;
    TextView tempVal;
    RadioGroup rgb;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Referencias a los elementos
        btn = findViewById(R.id.btnCalcular);
        rgb = findViewById(R.id.rgbOpciones);
        tempVal = findViewById(R.id.lblRespuesta);

        // Evento del botón
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                calcularOperacion();
            }
        });
    }

    private void calcularOperacion() {
        EditText txtNum1 = findViewById(R.id.txtNum1);
        EditText txtNum2 = findViewById(R.id.txtNum2);
        TextView lblRespuesta = findViewById(R.id.lblRespuesta);

        try {
            double num1 = Double.parseDouble(txtNum1.getText().toString());
            double num2 = Double.parseDouble(txtNum2.getText().toString());
            double respuesta = 0;

            int selectedId = rgb.getCheckedRadioButtonId();
            if (selectedId == R.id.optSuma) {
                respuesta = num1 + num2;
            } else if (selectedId == R.id.optResta) {
                respuesta = num1 - num2;
            } else if (selectedId == R.id.optMultiplicacion) {
                respuesta = num1 * num2;
            } else if (selectedId == R.id.optDivision) {
                if (num2 != 0) {
                    respuesta = num1 / num2;
                } else {
                    lblRespuesta.setText("Error: División por 0");
                    return;
                }
            }

            lblRespuesta.setText("Respuesta: " + respuesta);
        } catch (NumberFormatException e) {
            lblRespuesta.setText("Error: Ingrese números válidos");
        }
    }
}


