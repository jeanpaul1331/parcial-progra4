package main;

class Cliente {
    private String idCliente;
    private String nombre;

    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    @Override
    public String toString() {
        return "Cliente ID: " + idCliente + ", Nombre: " + nombre;
    }
}