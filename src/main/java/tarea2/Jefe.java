/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package tarea2;

/**
 *
 * @author elian
 */
public class Jefe {
    // Atributos
    String nombre, sexo, cargo, area, dni;
    double aniosAntiguedad;
    String tipoSeguro;
    private double afp = 0.15;
    private double snp = 0.08;
    private double bfc = 2000;
    private int contador = 0;

    // Metodo
    public Jefe(String nombre, String sexo, String cargo, String area, String dni, double aAntiguedad,
            String tipoSeguro) {
        contador++;
        this.nombre = nombre;
        this.sexo = sexo;
        this.cargo = cargo;
        this.area = area;
        this.dni = dni;
        this.aniosAntiguedad = aAntiguedad;
        this.tipoSeguro = tipoSeguro;
    }

    public double sueldoBase() {
        switch (cargo.toLowerCase()) {
            case "gerente":
                switch (area.toLowerCase()) {
                    case "contabilidad":
                        return 6000;
                    case "tecnologias de informacion":
                        return 8000;
                    case "planificacion":
                        return 7000;
                }
            case "subgerente":
                switch (area.toLowerCase()) {
                    case "contabilidad":
                        return 5000;
                    case "tecnologias de informacion":
                        return 7000;
                    case "planificacion":
                        return 6000;
                }

            default:
                return 0;
        }
    }

    public double bonificacion() {
        return bfc;
    }

    public double movilidad() {
        if (cargo.equalsIgnoreCase("Gerente")) {
            return 700;
        } else if (cargo.equalsIgnoreCase("Subgerente")) {
            return 400;
        } else {
            return 0;
        }
    }

    public double sueldoBruto() {
        return sueldoBase() + bonificacion();
    }

    public double antiguedad() {
        if (aniosAntiguedad < 7) {
            return sueldoBruto() * 0.05;
        } else {
            return sueldoBruto() * 0.04;
        }
    }

    public double pensionario() {
        if (tipoSeguro.equalsIgnoreCase("AFP")) {
            return sueldoBase() * afp;
        } else if (tipoSeguro.equalsIgnoreCase("SNP")) {
            return sueldoBase() * snp;
        } else {
            return 0;
        }
    }

    public double descuentos() {
        return antiguedad() + pensionario();
    }

    public double sueldoNeto() {
        return sueldoBruto() - descuentos() + movilidad();
    }

    public int getContador() {
        return contador;
    }

}
