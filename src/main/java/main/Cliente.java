package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String idCliente;
    private String nombre;
    private List<Reserva> reservas;

    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    package main;

import java.time.LocalDate;
import java.util.ArrayList;
import java.util.List;

public class Cliente {
    private String idCliente;
    private String nombre;
    private List<Reserva> reservas;

    public Cliente(String idCliente, String nombre) {
        this.idCliente = idCliente;
        this.nombre = nombre;
        this.reservas = new ArrayList<>();
    }

    public String getIdCliente() {
        return idCliente;
    }

    public String getNombre() {
        return nombre;
    }

    public List<Reserva> getReservas() {
        return reservas;
    }

    public boolean tieneReservaActiva() {
        
        for (Reserva reserva : reservas) {
            if (reserva.getFechaFin().compareTo(LocalDate.now()) > 0) {
                return true;
            }
        }
        return false;
    }

    public void reservarVehiculo(Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, boolean seguro, boolean gps) {
        if (!vehiculo.isDisponible()) {
            System.out.println("ESTE VEHICULO NO SE ENCUENTRA DISPONIBLE PARA REALIZAR UNA RESERVA");
            return;
        }

        if (tieneReservaActiva()) {
            System.out.println("NO SE PUEDE REALIZAR UNA RESERVA YA QUE EL CLIENTE TIENE UNA ACTIVA EN ESTE MOMENTO");
            return;
        }

        try {
            Reserva reserva = new Reserva(this, vehiculo, fechaInicio, fechaFin, seguro, gps);
            reserva.confirmarReserva();
            reservas.add(reserva);
        } catch (Exception e) {
            System.out.println("ERROR AL RELIZAR LA RESERVA: " + e.getMessage());
        }
    }

    @Override
    public String toString() {
        return "Cliente ID: " + idCliente + ", Nombre: " + nombre;
    }
}


    
