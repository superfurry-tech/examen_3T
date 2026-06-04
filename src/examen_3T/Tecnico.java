package examen_3T;

public class Tecnico extends Profesional {
  private String puesto;

  public Tecnico(String nombre, double salarioBase, String puesto) {
    super(nombre, salarioBase);
    this.puesto = puesto;
  }

  public String getPuesto() {
    return puesto;
  }

  @Override
  public double calcularPlusSalarial() {
    return 200.0;
  }

  @Override
  public String toString() {
    return "Tecnico{" +
        "puesto='" + puesto + '\'' +
        "} " + super.toString();
  }
}
