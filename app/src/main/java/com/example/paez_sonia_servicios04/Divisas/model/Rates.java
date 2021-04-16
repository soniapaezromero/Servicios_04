
package com.example.paez_sonia_servicios04.Divisas.model;
/**
 * @author : Sonia Páez Romero crado el 11/04/2021/**
 * @author : Sonia Páez Romero crado el 11/04/2021
 * Hay distintas monedas en la api yo solo me he descargado los euros
 */

public class Rates {

    private double usd;
    public double getUsd() {
        return usd;
    }
    public void setUsd(double usd) {
        this.usd = usd;
    }
    public Rates withUsd(double usd) {
        this.usd = usd;
        return this;
    }

}
