package main;

abstract class Vehiculo {
    protected String idVehiculo;
    protected String marca;
    protected String modelo;
    protected int año;
    protected double costoDiario;
    protected boolean disponibilidad;

    public Vehiculo(String idVehiculo, String marca, String modelo, int año, double costoDiario) {
        this.idVehiculo = idVehiculo;
        this.marca = marca;
        this.modelo = modelo;
        this.año = año;
        this.costoDiario = costoDiario;
        this.disponibilidad = true;
    }

    public String getIdVehiculo() {
        return idVehiculo;
    }

    public boolean isDisponible() {
        return disponibilidad;
    }

    public void setDisponible(boolean disponibilidad) {
        this.disponibilidad = disponibilidad;
    }

    public double calcularPrecio(int dias, boolean seguro, boolean gps) {
        double total = costoDiario * dias;
        if (seguro) {
            total += costoDiario * 0.10 * dias;
        }
        if (gps) {
            total += 5 * dias;
        }
        return total;
    }

    @Override
    public String toString() {
        return "ID: " + idVehiculo + ", Marca: " + marca + ", Modelo: " + modelo + ", Año: " + año + ", Costo Diario: $" + costoDiario;
    }
}

class Auto extends Vehiculo {
    private String tipoCombustible;

    public Auto(String idVehiculo, String marca, String modelo, int año, double costoDiario, String tipoCombustible) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.tipoCombustible = tipoCombustible;
    }

    @Override
    public String toString() {
        return super.toString() + ", Tipo Combustible: " + tipoCombustible;
    }
}

class Moto extends Vehiculo {
    private int cilindrada;

    public Moto(String idVehiculo, String marca, String modelo, int año, double costoDiario, int cilindrada) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.cilindrada = cilindrada;
    }

    @Override
    public String toString() {
        return super.toString() + ", Cilindrada: " + cilindrada + "cc";
    }
}

class Camioneta extends Vehiculo {
    private int capacidadCarga;

    public Camioneta(String idVehiculo, String marca, String modelo, int año, double costoDiario, int capacidadCarga) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.capacidadCarga = capacidadCarga;
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacidad de Carga: " + capacidadCarga + "kg";
    }
}

class Autobus extends Vehiculo {
    private int capacidadPasajeros;

    public Autobus(String idVehiculo, String marca, String modelo, int año, double costoDiario, int capacidadPasajeros) {
        super(idVehiculo, marca, modelo, año, costoDiario);
        this.capacidadPasajeros = capacidadPasajeros;
    }

    @Override
    public String toString() {
        return super.toString() + ", Capacidad de Pasajeros: " + capacidadPasajeros;
    }
}
