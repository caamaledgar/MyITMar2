package com.example.myitmar2.Model;

public class Usuarios {
    String uid;
    String usuario;
    String email;
    String passw;
    String nombre;
    String telefono;

    public Usuarios() {
    }

    public Usuarios(String uid, String usuario, String email, String passw, String nombre,String telefono) {
        this.uid = uid;
        this.usuario = usuario;
        this.email = email;
        this.passw = passw;
        this.nombre = nombre;
        this.telefono = telefono;
    }

    public String getUid() {
        return uid;
    }

    public void setUid(String uid) {
        this.uid = uid;
    }

    public String getEmail() {
        return email;
    }

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassw() {
        return passw;
    }

    public void setPassw(String passw) {
        this.passw = passw;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }


}
