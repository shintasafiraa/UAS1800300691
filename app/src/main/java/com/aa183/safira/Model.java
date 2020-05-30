package com.aa183.safira;

public class Model {
    private String id;
    private String name;
    private String genre;
    private String durasi;
    private String sutradara;

    public Model(String id, String name, String genre, String durasi, String sutradara) {
        this.id = id;
        this.name = name;
        this.genre = genre;
        this.durasi = durasi;
        this.sutradara = sutradara;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGenre() {
        return genre;
    }

    public void setGenre(String genre) {
        this.genre = genre;
    }

    public String getDurasi() {
        return durasi;
    }

    public void setDurasi(String durasi) {
        this.durasi = durasi;
    }

    public String getSutradara() {
        return sutradara;
    }

    public void setSutradara(String sutradara) {
        this.sutradara = sutradara;
    }
}
