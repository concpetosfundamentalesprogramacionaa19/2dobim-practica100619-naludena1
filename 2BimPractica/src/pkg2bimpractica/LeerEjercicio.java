/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pkg2bimpractica;

import java.io.File;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;

/**
 *
 * @author nali1
 */
public class LeerEjercicio {

    public static void leerRegistros() { // leer registro del archivo

        try { // Entrada a registros del archivo
            Scanner entrada = new Scanner(new File("data/tabula-FWC_2018_"
                    + "Squadlists_4.csv"));
            // Variables
            int cont = 0;
            double goals = 0;
            double totalG = 0;
            double height = 0;
            double totalH = 0;
            double promG = 0;
            double promH = 0;

            while (entrada.hasNext()) {
                String linea = entrada.nextLine();

                ArrayList<String> linea_partes = new ArrayList<>(
                        Arrays.asList(linea.split("\\|")));

                // Tomando las posiciones
                goals = Double.parseDouble(linea_partes.get(11)); 
                height = Double.parseDouble(linea_partes.get(9));

                totalG = goals + totalG; // Cálculo de total de goles
                totalH = height + totalH; // Cálculo del total de estatura

                cont = cont + 1;
            }
            // Cálculo de promedios
            promG = totalG / cont; 
            promH = totalH / cont;

            System.out.printf("El promedio de goles es: %.2f\nEl promedio de "
                    + "estatura es: %.2f", promG, promH);
            entrada.close();
        } catch (Exception e) {
            System.err.println("Error al leer del archivo.");
            System.exit(1);
        } // fin de catch
    }

}

