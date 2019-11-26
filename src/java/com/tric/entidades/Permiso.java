package com.tric.entidades;
import com.tric.anotaciones.*;
@Entity (table = "permiso")
public class Permiso {
    @PrimaryKey
    @NotNull
    @AutoIncrement
    private Integer idpermiso;
    @NotNull
    private Integer idmenu;
    @NotNull
    private Integer idrol;

    public Permiso(Integer idpermiso, Integer idmenu, Integer idrol) {
        this.idpermiso = idpermiso;
        this.idmenu = idmenu;
        this.idrol = idrol;
    }

    public Integer getIdpermiso() {
        return idpermiso;
    }

    public Integer getIdmenu() {
        return idmenu;
    }

    public Integer getIdrol() {
        return idrol;
    }

    public void setIdpermiso(Integer idpermiso) {
        this.idpermiso = idpermiso;
    }

    public void setIdmenu(Integer idmenu) {
        this.idmenu = idmenu;
    }

    public void setIdrol(Integer idrol) {
        this.idrol = idrol;
    }
    
}
