package examen_3T;

import java.util.Scanner;

public class MainClub {
  static int opcion;
  static Scanner sc = new Scanner(System.in);

  static void main(String[] args) {
    System.out.println();
    boolean seguir = true;

    while (seguir) {
      mostrarMenu();
      elegirOpcion();
      switch (opcion) {
        case 5:
          seguir = false;
          break;
        case 1:
          try {
            GestorClub.contratarJugador();
          } catch (PresupuestoExcedidoException e) {
            System.out.println(e.getMessage());
          }
          break;
        case 2:
          try {
            GestorClub.contratarTecnico();
          } catch (PresupuestoExcedidoException e) {
            System.out.println(e.getMessage());
          }
          break;
        case 3:
          try {
            GestorClub.despedirProfesional();
          } catch (ProfesionalNoEncontradoException e) {
            System.out.println(e.getMessage());
          }
          break;
        case 4:
          GestorClub.verNominasTotales();
          break;
        default:
          System.out.println("Opción no válida");
          break;
      }
    }

    System.out.println("Adiós!");
  }

  public static void mostrarMenu() {
    System.out.print("1. Contratar Jugador\n2. Contratar Cuerpo Técnico\n3. Despedir Profesional\n4. Ver nóminas Totales\n5. Salir\nOpción: ");
  }

  public static void elegirOpcion() {
    opcion = sc.nextInt();
    sc.nextLine();
  }
}
