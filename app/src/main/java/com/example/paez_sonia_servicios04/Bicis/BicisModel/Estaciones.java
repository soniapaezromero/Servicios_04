package com.example.paez_sonia_servicios04.Bicis.BicisModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;
import java.util.List;

public class Estaciones implements Serializable {


    @SerializedName("result")
    @Expose
    private List<Result> result = null;
    private final static long serialVersionUID = -7082773433622743203L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Estaciones() {
    }

    /**
     *
     * @param result

     */
    public Estaciones(List<Result> result) {
        super();

        this.result = result;
    }


    public List<Result> getResult() {
        return result;
    }

    public void setResult(List<Result> result) {
        this.result = result;
    }

    public Estaciones withResult(List<Result> result) {
        this.result = result;
        return this;
    }

}

