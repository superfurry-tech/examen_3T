package examen_3T;

public class Jugador extends Profesional{
  private Posicion posicion;

  public Jugador(String nombre, double salarioBase, Posicion posicion) {
    super(nombre, salarioBase);
    this.posicion = posicion;
  }

  public Posicion getPosicion() {
    return posicion;
  }

  @Override
  public double calcularPlusSalarial() {
    return getSalarioBase() * 0.10;
  }

  @Override
  public String toString() {
    return "Jugador{" +
        "posicion=" + posicion +
        "} " + super.toString();
  }
}
