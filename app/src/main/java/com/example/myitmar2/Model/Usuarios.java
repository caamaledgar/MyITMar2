package com.example.myitmar2.Model;

public class Usuarios {
    String uid;
    String email;
    String passw;
    String nombre;
    String correo;
    String telefono;

    public Usuarios() {
    }

    public Usuarios(String uid, String email, String passw, String nombre, String correo, String telefono) {
        this.uid = uid;
        this.email = email;
        this.passw = passw;
        this.nombre = nombre;
        this.correo = correo;
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

    public String getCorreo() {
        return correo;
    }

    public void setCorreo(String correo) {
        this.correo = correo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    @Override
    public String toString() {
        return "Usuarios{" +
                "uid='" + uid + '\'' +
                ", email='" + email + '\'' +
                ", passw='" + passw + '\'' +
                ", nombre='" + nombre + '\'' +
                ", correo='" + correo + '\'' +
                ", telefono='" + telefono + '\'' +
                '}';
    }
}
