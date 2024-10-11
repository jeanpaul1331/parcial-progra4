package main;

import java.time.LocalDate;

public class Reserva {
    private static int contadorReservas = 1;
    private String idReserva;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costoTotal;

    public Reserva(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, boolean seguro, boolean gps) throws Exception {
        if (fechaFin.isBefore(fechaInicio)) {
            throw new Exception("La fecha de fin no puede ser antes de la fecha de inicio.");
        }
        this.idReserva = "R" + contadorReservas++;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        int dias = (int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay()) + 1;
        this.costoTotal = vehiculo.calcularPrecio(dias, seguro, gps);
    }

    public String getIdReserva() {
        return idReserva;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public Vehiculo getVehiculo() {
        return vehiculo;
    }

    public LocalDate getFechaInicio() {
        return fechaInicio;
    }

    public LocalDate getFechaFin() {
        return fechaFin;
    }

    public double getCostoTotal() {
        return costoTotal;
    }

    public void confirmarReserva() {
        vehiculo.setDisponible(false);
        SistemaAlquiler.DataStore.reservas.add(this);
        System.out.println("Reserva Confirmada: " + idReserva + ", Costo Total: $" + costoTotal);
    }

    @Override
    public String toString() {
        return "Reserva ID: " + idReserva +
                ", Cliente: " + cliente.getNombre() + " (ID: " + cliente.getIdCliente() + ")" +
                ", Vehículo: " + vehiculo.getMarca() + " " + vehiculo.getModelo() + " (ID: " + vehiculo.getIdVehiculo() + ")" +
                ", Fecha Inicio: " + fechaInicio +
                ", Fecha Fin: " + fechaFin +
                ", Costo Total: $" + costoTotal;
    }
}