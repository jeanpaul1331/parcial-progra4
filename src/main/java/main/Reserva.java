package main;

import java.time.LocalDate;

class Reserva {
    private static int contadorReservas = 1;
    private String idReserva;
    private Cliente cliente;
    private Vehiculo vehiculo;
    private LocalDate fechaInicio;
    private LocalDate fechaFin;
    private double costoTotal;

    public Reserva(Cliente cliente, Vehiculo vehiculo, LocalDate fechaInicio, LocalDate fechaFin, boolean seguro, boolean gps) {
        this.idReserva = "R" + contadorReservas++;
        this.cliente = cliente;
        this.vehiculo = vehiculo;
        this.fechaInicio = fechaInicio;
        this.fechaFin = fechaFin;
        this.costoTotal = vehiculo.calcularPrecio((int) (fechaFin.toEpochDay() - fechaInicio.toEpochDay()), seguro, gps);
    }

    public void confirmarReserva() {
        vehiculo.setDisponible(false);
        System.out.println("Reserva Confirmada: " + idReserva + ", Costo Total: $" + costoTotal);
    }

    @Override
    public String toString() {
        return "Reserva ID: " + idReserva + ", Vehiculo: " + vehiculo.getIdVehiculo() + ", Cliente: " + cliente.getNombre() +
                ", Fecha Inicio: " + fechaInicio + ", Fecha Fin: " + fechaFin + ", Costo Total: $" + costoTotal;
    }
}