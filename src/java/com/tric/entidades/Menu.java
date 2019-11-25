package com.tric.entidades;
import com.tric.anotaciones.*;
@Entity (table = "menu")
public class Menu {
    @PrimaryKey
    @NotNull
    @AutoIncrement
    private Integer idmenu;
    @NotNull
    private String menu;
    private String descripcion;
    private String url;
    private int idpadre;

    public Menu() {
    }

    public Menu(Integer idmenu, String menu, String descripcion, String url, int idpadre) {
        this.idmenu = idmenu;
        this.menu = menu;
        this.descripcion = descripcion;
        this.url = url;
        this.idpadre = idpadre;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public String getMenu() {
        return menu;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public String getUrl() {
        return url;
    }

    public int getIdpadre() {
        return idpadre;
    }

    public void setIdmenu(int idmenu) {
        this.idmenu = idmenu;
    }

    public void setMenu(String menu) {
        this.menu = menu;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public void setUrl(String url) {
        this.url = url;
    }

    public void setIdpadre(int idpadre) {
        this.idpadre = idpadre;
    }
    
    
}
