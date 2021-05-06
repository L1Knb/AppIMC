package com.ifsc.appimc;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import java.text.DecimalFormat;

public class ImcActivity extends AppCompatActivity {
    String nome;
    Double peso, altura, imc;
    TextView tvName, tvPeso, tvAltura, tvIMC, tvMensagem, textResul;
    DecimalFormat decimalFormat = new DecimalFormat("##,##,##,##0.00");

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_imc);

        Bundle bundle = getIntent().getExtras();
        nome= bundle.getString("nome");
        peso= bundle.getDouble("peso");
        altura= bundle.getDouble("altura");

        tvName= findViewById(R.id.tvName);
        tvAltura= findViewById(R.id.tvAltura);
        tvPeso= findViewById(R.id.tvPeso);
        tvIMC= findViewById(R.id.tvIMC);
        tvMensagem= findViewById(R.id.tvMensagem);
        textResul = findViewById(R.id.textResul);
    }

    @Override
    protected void onStart() {
        super.onStart();
        tvName.setText(nome);
        tvAltura.setText(altura.toString());
        tvPeso.setText(peso.toString());
        tvIMC.setText(decimalFormat.format(calculaIMC(peso,altura)));
        if(imc < 18.5) {
            textResul.setText("MAGREZA, OBESIDADE GRAU: 0");
        } else if(imc >= 18.5 && imc < 25) {
            textResul.setText("NORMAL, OBESIDADE GRAU: 0");
        } else if(imc >= 25 && imc < 30) {
            textResul.setText("SOBREPESO, OBESIDADE GRAU: 1");
        } else if(imc >= 30 && imc < 40) {
            textResul.setText("OBESIDADE, OBESIDADE GRAU: 2");
        }  else if(imc >= 40) {
            textResul.setText("OBESIDADE GRAVE, OBESIDADE GRAU: 3");
        }

    }

    public Double calculaIMC(Double peso, Double altura){
        imc = peso/(altura*altura);
        return imc;
    }

}