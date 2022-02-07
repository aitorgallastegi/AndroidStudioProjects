package com.example.ficheros;

public class WebFavorita
{
    private String nombre;
    private String url;
    private String logo;
    private String id;

    public WebFavorita(String nombre,String url,String logo,String id)
    {
        this.nombre = nombre;
        this.url = url;
        this.logo = logo;
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    @Override
    public String toString() {
        return nombre;
    }
}
