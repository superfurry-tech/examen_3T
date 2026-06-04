package examen_3T;

import java.util.ArrayList;
import java.util.Scanner;

public class GestorClub {
  private static final int PRESUPUESTO_MAXIMO = 10000;

  private static ArrayList<Profesional> listaProfesionales = new ArrayList<>();

  public static void contratarJugador() {
    double totalAcumulado = 0;
    if (listaProfesionales.isEmpty()){
      totalAcumulado = 0;
    } else {
      for (Profesional p : listaProfesionales){
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
    if (opcionPosicion == 1){
      posicion = Posicion.PORTERO;
    } else if (opcionPosicion == 2) {
      posicion = Posicion.DEFENSA;
    } else if (opcionPosicion == 3) {
      posicion = Posicion.CENTROCAMPISTA;
    } else if (opcionPosicion == 4){
      posicion = Posicion.DELANTERO;
    }
    
    Jugador j1 = new Jugador(nombre, salarioBase, posicion);






  }


}
