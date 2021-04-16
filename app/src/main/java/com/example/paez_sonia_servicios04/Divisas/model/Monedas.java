
package com.example.paez_sonia_servicios04.Divisas.model;


/**
 * @author : Sonia Páez Romero crado el 11/04/2021
 */

public class Monedas {

    private boolean success;

    private long timestamp;

    private String base;

    private String date;

    private Rates rates;

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public Monedas withSuccess(boolean success) {
        this.success = success;
        return this;
    }

    public long getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public Monedas withTimestamp(long timestamp) {
        this.timestamp = timestamp;
        return this;
    }

    public String getBase() {
        return base;
    }

    public void setBase(String base) {
        this.base = base;
    }

    public Monedas withBase(String base) {
        this.base = base;
        return this;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public Monedas withDate(String date) {
        this.date = date;
        return this;
    }

    public Rates getRates() {
        return rates;
    }

    public void setRates(Rates rates) {
        this.rates = rates;
    }

    public Monedas withRates(Rates rates) {
        this.rates = rates;
        return this;
    }

    @Override
    public String toString() {
        return "Monedas{" +
                "success=" + success +
                ", timestamp=" + timestamp +
                ", base='" + base + '\'' +
                ", date='" + date + '\'' +
                ", rates=" + rates +
                '}';
    }
}
