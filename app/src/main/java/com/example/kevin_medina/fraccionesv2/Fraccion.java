package com.example.kevin_medina.fraccionesv2;

public class Fraccion {
    int numerador, denominador;

    public void suma(Fraccion fracc1, Fraccion fracc2){
        numerador = fracc1.numerador * fracc2.denominador + fracc1.denominador * fracc2.numerador;
        denominador =  fracc1.denominador * fracc2.denominador;
    }

    public void resta(Fraccion fracc1, Fraccion fracc2){
        numerador = fracc1.numerador * fracc2.denominador - fracc1.denominador * fracc2.numerador;
        denominador =  fracc1.denominador * fracc2.denominador;
    }

    public void multiplicacion(Fraccion fracc1, Fraccion fracc2){
        denominador = fracc1.denominador * fracc2.denominador;
        numerador = fracc1.numerador * fracc2.numerador;
    }

    public void division(Fraccion fracc1, Fraccion fracc2){
        numerador = fracc1.numerador * fracc2.denominador;
        denominador = fracc1.denominador * fracc2.numerador;
    }

    public void reducir(){
        int comunDivisor = GCD(numerador, denominador);
        numerador /= comunDivisor;
        denominador /= comunDivisor;
    }

    public int obtenerParteEntera(){
        int entero;
        entero = numerador / denominador;
        numerador -= entero * denominador;
        return entero;
    }

    private int GCD(int num, int den){
        int mod = num % den;

        while (mod != 0){
            num = den;
            den = mod;
            mod = num % den;
        }
        return den;
    }

    public void set(int num, int den, int entero){
        numerador = num + entero * den;
        denominador = den;
    }

    public Fraccion(){

    }
}
