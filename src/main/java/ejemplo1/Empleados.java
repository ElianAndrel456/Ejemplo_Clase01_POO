/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */

package ejemplo1;

/**
 *
 * @author elian
 */
public class Empleados {

    // Atributos
    String codigo, nombre, area, tipo_seg;
    double sueldoBase, horasExtras;

    // valores Comunes
    private static double porc_Afp = 0.11;
    private static double porc_Snp = 0.06;
    private static double porc_Essalud = 0.01;
    private static int contador = 0;

    // Constructor
    public Empleados(String codigo, String nombre, String area, double sueldoBase, double horasExtras, String seguro) {
        contador++;

        this.codigo = codigo;
        this.nombre = nombre;
        this.area = area;
        this.sueldoBase = sueldoBase;
        this.horasExtras = horasExtras;
        this.tipo_seg = seguro;
    }

    /* Metodos Adicionales */

    // Calculando el monto extra
    public double montoExtras() {
        return sueldoBase * horasExtras / 240;
    }

    // Calculando el monto de seguro
    public double montoSeguro() {
        if (tipo_seg.equalsIgnoreCase("AFP")) {
            return sueldoBase * porc_Afp;
        }
        if (tipo_seg.equalsIgnoreCase("SNP")) {
            return sueldoBase * porc_Snp;
        }
        return 0;
    }

    // calculando el monto de Essalud
    public double montoEssalud() {
        return sueldoBase * porc_Essalud;
    }

    // calculando el monto de Descuentos
    public double montoDescuentos() {
        return montoSeguro() + montoEssalud();
    }

    // calculando el monto del sueldo bruto
    public double sueldoBruto() {
        return sueldoBase + montoExtras();
    }

    // calculando el sueldo neto
    public double sueldoNeto() {
        return sueldoBruto() - montoDescuentos();
    }

    // Obteniedo el numero de objetos generados con la clase
    public static int getContador() {
        return contador;
    }
}
