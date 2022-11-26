package com.example.aplicacindepulsos.Modelos;

public class pulsotest {
        public String pulsominimo;
        public String pulsomaximo;

        public pulsotest(String pulsominimo, String pulsomaximo) {
            this.pulsominimo = pulsominimo;
            this.pulsomaximo = pulsomaximo;
        }


    @Override
    public String toString() {
        return "Pulso Mínimo:  " + pulsominimo + "   /   " +
                "Pulso Máximo:  " + pulsomaximo;
    }
}
