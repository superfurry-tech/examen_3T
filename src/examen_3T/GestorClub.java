package examen_3T;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorClub {
  private static final int PRESUPUESTO_MAXIMO = 10000;
  static double totalAcumulado = 0.0;

  private static ArrayList<Profesional> listaProfesionales = new ArrayList<>();

  public static void contratarJugador() throws PresupuestoExcedidoException {
    if (listaProfesionales.isEmpty()) {
      totalAcumulado = 0;
    } else {
      for (Profesional p : listaProfesionales) {
        totalAcumulado += p.getSalarioBase();
      }
    }
    String nombre;
    double salarioBase = 0;
    int opcionPosicion;
    Posicion posicion = null;
    Scanner sc = new Scanner(System.in);
    System.out.print("Nombre: ");
    nombre = sc.nextLine();
    System.out.print("Salario Base: ");
    salarioBase = sc.nextDouble();
    sc.nextLine();
    System.out.print("1. Portero\n2. Defensa\n3. Centrocampista\n4. Delantero\nPosición: ");
    opcionPosicion = sc.nextInt();
    sc.nextLine();
    if (opcionPosicion == 1) {
      posicion = Posicion.PORTERO;
    } else if (opcionPosicion == 2) {
      posicion = Posicion.DEFENSA;
    } else if (opcionPosicion == 3) {
      posicion = Posicion.CENTROCAMPISTA;
    } else if (opcionPosicion == 4) {
      posicion = Posicion.DELANTERO;
    }

    Jugador j1 = new Jugador(nombre, salarioBase, posicion);

    totalAcumulado += j1.getSalarioBase();

    if (totalAcumulado > PRESUPUESTO_MAXIMO) {
      throw new PresupuestoExcedidoException("No se puede añadir a " + j1.getNombre() + " porque supera el presupuesto de " + PRESUPUESTO_MAXIMO + " €.");
    } else {
      listaProfesionales.add(j1);
    }
  }

  public static void contratarTecnico() throws PresupuestoExcedidoException {
    String nombre;
    double salarioBase = 0;
    String puesto;
    Scanner sc = new Scanner(System.in);
    System.out.print("Nombre: ");
    nombre = sc.nextLine();
    System.out.print("Salario Base: ");
    salarioBase = sc.nextDouble();
    sc.nextLine();
    System.out.print("Puesto: ");
    puesto = sc.nextLine();

    Tecnico t1 = new Tecnico(nombre, salarioBase, puesto);

    totalAcumulado += t1.getSalarioBase();

    if (totalAcumulado > PRESUPUESTO_MAXIMO) {
      throw new PresupuestoExcedidoException("No se puede añadir a " + t1.getNombre() + " porque supera el presupuesto de " + PRESUPUESTO_MAXIMO + " €.");
    } else {
      listaProfesionales.add(t1);
    }

  }

  /*public static void despedirProfesional() throws ProfesionalNoEncontradoException {
    Scanner sc = new Scanner(System.in);
    String nombreDespedido;
    System.out.print("Nombre a despedir: ");
    nombreDespedido = sc.nextLine();
    ArrayList<String> nombresLista = new ArrayList<>();
    for (Profesional p : listaProfesionales) {
      nombresLista.add(p.getNombre());

      if (nombresLista.contains(nombreDespedido)) {
        listaProfesionales.remove(p);
        if (listaProfesionales.isEmpty()) {
          break;
        }
      } else {
        throw new ProfesionalNoEncontradoException(nombreDespedido + " no pertenece al club.");
      }
    }
  }*/

  public static void despedirProfesional() throws ProfesionalNoEncontradoException {
    boolean encontrado = false;
    Scanner sc = new Scanner(System.in);
    String nombreDespedido;
    System.out.print("Nombre a despedir: ");
    nombreDespedido = sc.nextLine();
    for (Profesional p : listaProfesionales) {
      if (p.getNombre().equalsIgnoreCase(nombreDespedido)) {
        encontrado = true;
      }
    }

    for (Profesional p : listaProfesionales) {
      if (encontrado) {
        if (p.getNombre().equalsIgnoreCase(nombreDespedido)) {
          listaProfesionales.remove(p);
        }
      } else {
        throw new ProfesionalNoEncontradoException(nombreDespedido + " no pertenece al club.");
      }
    }
  }


  public static void verNominasTotales() {
    double dineroTotal = 0;
    for (Profesional p : listaProfesionales) {
      if (p instanceof Jugador) {
        System.out.println(p.getNombre() + " - " + ((Jugador) p).getPosicion() + " - " + (p.getSalarioBase() + p.calcularPlusSalarial()));
        dineroTotal += (p.getSalarioBase() + p.calcularPlusSalarial());
      } else if (p instanceof Tecnico) {
        System.out.println(p.getNombre() + " - " + ((Tecnico) p).getPuesto() + " - " + (p.getSalarioBase() + p.calcularPlusSalarial()));
        dineroTotal += (p.getSalarioBase() + p.calcularPlusSalarial());
      }
    }
    System.out.println(dineroTotal);
  }

  public static ArrayList<Profesional> getListaProfesionales() {
    return listaProfesionales;
  }
}



