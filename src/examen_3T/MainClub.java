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

      seguir = false;
    }

  }

  public static void mostrarMenu() {
    System.out.print("1. Contratar Jugador\n2. Contratar Cuerpo Técnico\n3. Despedir Profesional\n4. Ver nóminas Totales\nOpción: ");
  }

  public static void elegirOpcion() {
    opcion = sc.nextInt();
  }
}
