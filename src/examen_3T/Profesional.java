package examen_3T;

public abstract class Profesional implements Bonificable{
  private String nombre;
  private double salarioBase;

  public Profesional(String nombre, double salarioBase) {
    this.nombre = nombre;
    this.salarioBase = salarioBase;
  }

  public String getNombre() {
    return nombre;
  }

  public double getSalarioBase() {
    return salarioBase;
  }

  @Override
  public String toString() {
    return "Profesional{" +
        "nombre='" + nombre + '\'' +
        ", salarioBase=" + salarioBase +
        '}';
  }
}
