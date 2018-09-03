package com.example.kevin_medina.fraccionesv2;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText Num1, Num2, Den1, Den2, Ent1, Ent2;
    TextView Num3, Den3, Ent3, Operacion;
    Button Suma, Resta, Multiplicacion, Division;
    Fraccion fraccion1, fraccion2, resultado;
    int num1, den1, num2, den2, ent1, ent2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Num1 = (EditText)findViewById(R.id.num1);
        Num2 = (EditText)findViewById(R.id.num2);
        Num3 = (TextView) findViewById(R.id.num3);
        Den1 = (EditText)findViewById(R.id.den1);
        Den2 = (EditText)findViewById(R.id.den2);
        Den3 = (TextView) findViewById(R.id.den3);
        Ent1 = (EditText) findViewById(R.id.entero1);
        Ent2 = (EditText) findViewById(R.id.entero2);
        Ent3 = (TextView) findViewById(R.id.entero3);
        Suma = (Button)findViewById(R.id.suma);
        Resta = (Button)findViewById(R.id.resta);
        Multiplicacion = (Button)findViewById(R.id.multiplicacion);
        Division = (Button) findViewById(R.id.division);
        Operacion = (TextView)findViewById(R.id.operacion);
        fraccion1 = new Fraccion();
        fraccion2 = new Fraccion();
        resultado = new Fraccion();

        Suma.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                        getValue();
                        if (den1 == 0 || den2 == 0){
                            Toast.makeText(getApplicationContext(), "[ERROR]: El denominador no puede ser 0. ", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Operacion.setText("+");
                            fraccion1.set(num1, den1, ent1);
                            fraccion2.set(num2, den2, ent2);
                            resultado.suma(fraccion1, fraccion2);

                            if (resultado.numerador == 0){
                                Num3.setText("0");
                                Den3.setText("0");
                            }
                            else {
                                resultado.reducir();
                                Ent3.setText(String.valueOf(resultado.obtenerParteEntera()));
                                Num3.setText(String.valueOf(resultado.numerador));
                                Den3.setText(String.valueOf(resultado.denominador));
                            }
                        }
                    }
                }
        );

        Resta.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getValue();
                        if (den1 == 0 || den2 == 0){
                            Toast.makeText(getApplicationContext(), "[ERROR]: El denominador no puede ser 0.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Operacion.setText("-");
                            fraccion1.set(num1, den1, ent1);
                            fraccion2.set(num2, den2, ent2);
                            resultado.resta(fraccion1, fraccion2);

                            if (resultado.numerador == 0){
                                Num3.setText("0");
                                Den3.setText("0");
                            }
                            else {
                                resultado.reducir();
                                Ent3.setText(String.valueOf(resultado.obtenerParteEntera()));
                                Num3.setText(String.valueOf(resultado.numerador));
                                Den3.setText(String.valueOf(resultado.denominador));
                            }
                        }
                    }
                }
        );

        Multiplicacion.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getValue();
                        if ((den1 == 0 && ent1 == 0) || (den2 == 0 && ent2 == 0)){
                            Toast.makeText(getApplicationContext(), "[ERROR]: El denominador no puede ser 0.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Operacion.setText("*");
                            if (num1 == 0 || num2 == 0){
                                Num3.setText("0");
                                Den3.setText("0");
                                Ent3.setText("0");
                            }

                            else {
                                fraccion1.set(num1, den1, ent1);
                                fraccion2.set(num2, den2, ent2);
                                resultado.multiplicacion(fraccion1, fraccion2);
                                resultado.reducir();
                                Ent3.setText(String.valueOf(resultado.obtenerParteEntera()));
                                Num3.setText(String.valueOf(resultado.numerador));
                                Den3.setText(String.valueOf(resultado.denominador));
                            }
                        }
                    }
                }
        );

        Division.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        getValue();
                        if (den1 == 0 || den2 == 0){
                            Toast.makeText(getApplicationContext(), "[ERROR]: El denominador no puede ser 0.", Toast.LENGTH_SHORT).show();
                        }
                        else {
                            Operacion.setText("/");
                            fraccion2.set(num2, den2, ent2);

                            if (fraccion2.numerador == 0){
                                Toast.makeText(getApplicationContext(), "[ERROR]: No se puede dividir entre 0.", Toast.LENGTH_SHORT).show();

                            }
                            else {
                                fraccion1.set(num1, den1, ent1);
                                resultado.division(fraccion1, fraccion2);
                                resultado.reducir();
                                Ent3.setText(String.valueOf(resultado.obtenerParteEntera()));
                                Num3.setText(String.valueOf(resultado.numerador));
                                Den3.setText(String.valueOf(resultado.denominador));
                            }
                        }
                    }
                }
        );
    }


    public void getValue(){
        num1 = avoidEmptyString(Num1);
        num2 = avoidEmptyString(Num2);
        den1 = avoidEmptyString(Den1);
        den2 = avoidEmptyString(Den2);
        ent1 = avoidEmptyString(Ent1);
        ent2 = avoidEmptyString(Ent2);
    }

    public int avoidEmptyString(EditText editText){
        if (editText.getText().toString().isEmpty())
            return 0;
        else
            return Integer.parseInt(editText.getText().toString());
    }
}