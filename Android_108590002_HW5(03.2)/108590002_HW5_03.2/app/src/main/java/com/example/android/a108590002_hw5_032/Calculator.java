package com.example.android.a108590002_hw5_032;

public class Calculator {
    public enum Operator{ADD, SUB, DIV, MUL, POW}

    public double add(double op1, double op2){
        return op1 + op2;
    }

    public double sub(double op1, double op2){
        return op1 - op2;
    }

    public double mul(double op1, double op2){
        return op1 * op2;
    }

    public double div(double op1, double op2){
        if (op2 == 0 ) {
            throw new IllegalArgumentException("You cannot divide by zero");
        }
        return op1 / op2;
    }

    public double pow(double op1, double op2){
        double result = 0;
        if(op2 < 0){
            op2 = -op2;
            result = Math.pow(op1, op2);
            return 1/result;
        }
        return (long) Math.pow(op1, op2);
    }
}
