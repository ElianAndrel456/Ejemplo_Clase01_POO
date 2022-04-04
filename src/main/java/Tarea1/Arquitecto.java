/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package Tarea1;

/**
 *
 * @author elian
 */
public class Arquitecto {
    double codigo;
    String nombre, condicionDeContrato, especialidad, tipoDeSupervicion, tipoSeguro;
    int numerosDeObrasAsignadas;

    public Arquitecto(double codigo, String nombre, String condicionDeContrato, String especialidad,
            String tipoDeSupervicion, int numeroDeObrasAsignadas, String tipoSeguro) {
        this.codigo = codigo;
        this.nombre = nombre;
        this.condicionDeContrato = condicionDeContrato;
        this.especialidad = especialidad;
        this.tipoDeSupervicion = tipoDeSupervicion;
        this.numerosDeObrasAsignadas = numeroDeObrasAsignadas;
        this.tipoSeguro = tipoSeguro;
    }

    public double sueldoBase() {

        switch (condicionDeContrato.toLowerCase()) {
            case "estable":
                switch (tipoDeSupervicion.toLowerCase()) {
                    case "obras":
                        return 4000;
                    case "vias":
                        return 6000;
                }

            case "Contratado":
                switch (tipoDeSupervicion) {
                    case "obras":
                        return 4000;
                    case "vias":
                        return 6000;
                }
            default:
                return 0;
        }
    }

    public double bonificacion() {
        switch (especialidad.toLowerCase()) {
            case "estructura":
                return sueldoBase() * 0.16;
            case "recursos hidricos":
                return sueldoBase() * 0.18;
            case "ingenieria vial":
                return sueldoBase() * 0.22;

            default:
                return 0;
        }
    }

    public double descuentos() {
        if (tipoSeguro.equalsIgnoreCase("AFP")) {
            return sueldoBase() * 0.15;
        } else if (tipoSeguro.equalsIgnoreCase("SNP")) {
            return sueldoBase() * 0.08;
        } else {
            return 0;
        }
    }

    public double movilidad() {
        if (numerosDeObrasAsignadas < 17) {
            return 300;
        } else {
            return 600;
        }
    }

    public double sueldoBruto() {
        return sueldoBase() + bonificacion();
    }

    public double sueldoNeto() {
        return sueldoBruto() - descuentos() + movilidad();
    }
}
