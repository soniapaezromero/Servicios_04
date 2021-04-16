
package com.example.paez_sonia_servicios04.Bicis.BicisModel;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.io.Serializable;


public class Result implements Serializable{

    @SerializedName("id")
    @Expose
    private int id;
    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("tipo")
    @Expose
    private String tipo;
    @SerializedName("plazas")
    @Expose
    private int plazas;
    @SerializedName("anclajes")
    @Expose
    private int anclajes;
    @SerializedName("lastUpdated")
    @Expose
    private String lastUpdated;
    private final static long serialVersionUID = 860124889380347110L;

    /**
     * No args constructor for use in serialization
     *
     */
    public Result() {
    }

    /**
     *
     * @param lastUpdated
     * @param tipo
     * @param anclajes
     * @param plazas
     * @param id
     * @param title
     */
    public Result(int id, String title, String tipo, int plazas, int anclajes, String lastUpdated) {
        super();
        this.id = id;
        this.title = title;
        this.tipo = tipo;
        this.plazas = plazas;
        this.anclajes = anclajes;
        this.lastUpdated = lastUpdated;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public Result withId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public Result withTitle(String title) {
        this.title = title;
        return this;
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public Result withTipo(String tipo) {
        this.tipo = tipo;
        return this;
    }

    public int getPlazas() {
        return plazas;
    }

    public void setPlazas(int plazas) {
        this.plazas = plazas;
    }

    public Result withPlazas(int plazas) {
        this.plazas = plazas;
        return this;
    }

    public int getAnclajes() {
        return anclajes;
    }

    public void setAnclajes(int anclajes) {
        this.anclajes = anclajes;
    }

    public Result withAnclajes(int anclajes) {
        this.anclajes = anclajes;
        return this;
    }

    public String getLastUpdated() {
        return lastUpdated;
    }

    public void setLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
    }

    public Result withLastUpdated(String lastUpdated) {
        this.lastUpdated = lastUpdated;
        return this;
    }

}
