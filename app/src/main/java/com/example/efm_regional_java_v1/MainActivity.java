package com.example.efm_regional_java_v1;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText edittext1, edittext2;
    Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        edittext1 = findViewById(R.id.edittext1);
        edittext2 = findViewById(R.id.edittext2);
        button = findViewById(R.id.button);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(MainActivity.this, "Votre IMC est : " + calculeIMC() + " , Votre état est : " + etat(), Toast.LENGTH_LONG).show();
            }
        });
    }
    public double calculeIMC(){
        double poid = Double.parseDouble(edittext1.getText().toString());
        double taille = Double.parseDouble(edittext2.getText().toString());

        double IMC = (poid/(taille*taille));
        return  IMC;
    }

    public String etat(){
        String etat = "";
        if(calculeIMC()<18.5){etat = "Maigreur";}
        else if(calculeIMC()>=18.5 && calculeIMC()<25){etat = "Normale";}
        else if(calculeIMC()<40 && calculeIMC()>=25){etat = "Surpoids";}
        else if(calculeIMC()>=40 ){etat = "Obésité";}

        return etat;
    }
}