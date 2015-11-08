//@===================================================
//@Universidad del Valle de Guatemala
//@Algoritmos y Estructura de Datos
//@Sección: 10
//@laboratorio10
//@
//@08/11/2015
//@Christopher Antonio Chiroy Miranda. Carné: 14411
//@Boris Ramiro Cifuentes de Leon. Carné: 14411
//@================================================== 

import java.util.Scanner;

public class Main {

   
    public static void main(String[] args){
        
    	AlgoritmoDeFloyd matriz = new AlgoritmoDeFloyd(); 				// Matriz de adyacencia
        matriz.caminoCorto(); 											// Algoritmo de Floyd para encontrar el camino mas corto entre todos los nodos
        int seleccion; 													// Seleccion del usuario para realizar
        int opcion; 													// Seleccion del usuario para la pregunta 3
        Scanner scan = new Scanner(System.in); 							//Entrada por teclado
        System.out.println("1. Buscar ruta mas corta entre dos ciudades ");
        System.out.println("2. Nombre de la ciudad en el centro del grafo");
        System.out.println("3. Modificar grafo");
        System.out.println("4. Finalizar programa");
        seleccion = scan.nextInt(); 
        
        while(seleccion!=4){
            // Desplegar la matriz
            
            // Si la respuesta es 1, preguntar por las ciudades y desplegar resultados
            if(seleccion==1){
                matriz.caminoCorto(); // Camino mas corto entre todas las ciudades
                //Primera letra mayuscula el resto en minuscula
                System.out.println("Ciudad de salida: ");
                String ciudad1 = scan.next(); 
                System.out.println("Ciudad de destino: ");
                String ciudad2 = scan.next();
                // Si las ciudades se encuentran en la matriz, entonces desplegar la distancia minima y la ruta completa
                if(matriz.D.contains(ciudad1)&&matriz.D.contains(ciudad2)){
                    System.out.println("\nDistancia minima: "+matriz.D.getEdge(ciudad1, ciudad2)+".");
                    if(matriz.D.getEdge(ciudad1, ciudad2)!=10000){
                        System.out.print("Ruta: "+ciudad1);
                        matriz.mostrarIntermedias(matriz.D.getIndex(ciudad1), matriz.D.getIndex(ciudad2));
                        System.out.println(", "+ciudad2);
                    }
                }
                else{
                	System.out.println("***Problema con el ingreso de ciudades, por favor verificar ingreso***");
                }
                System.out.println();
            }
            
            // Si la respuesta es 2, desplegar el centro de grafo
            else if(seleccion==2){
                matriz.centroGrafo();
            }
            
            // Si la respuesta es 3, preguntar cual es el cambio a realizar y ejecutarlo
            else if(seleccion==3){
                System.out.println("1. Hay interrupcion de trafico entre un par de ciudades");
                System.out.println("2. Establecer nueva conexion");
                opcion = scan.nextInt();
                // Si la respuesta es 1, preguntar por el nombre de las ciudades y colocar un numero muy grande
                // en la matriz de adyacencia para indicar que no hay conexion
                if(opcion==1){
                    System.out.println("Ingrese el nombre de la ciudad de salida");
                    String ciudad1 = scan.next();
                    System.out.println("Ingrese el nombre de la ciudad de destino");
                    String ciudad2 = scan.next();
                    if(matriz.D.contains(ciudad1)&&matriz.D.contains(ciudad2)){
                        matriz.D.addEdge(ciudad1, ciudad2, 10000);
                    }
                }
                // Si la respuesta es 2, preguntar por el nombre de las ciudades y agregar nueva distancia.
                else if(opcion==2){
                    System.out.println("Ingrese el nombre de la ciudad de salida");
                    String ciudad1 = scan.next();
                    System.out.println("Ingrese el nombre de la ciudad de destino");
                    String ciudad2 = scan.next();
                    System.out.println("Ingrese la distancia entre las ciudades");
                    int distancia = scan.nextInt();
                    // Si las ciudades ya existen, cambiar el valor
                    if(matriz.D.contains(ciudad1)&&matriz.D.contains(ciudad2)){
                        matriz.D.addEdge(ciudad1, ciudad2, distancia);
                    }
                    // Si las ciudades no existen, agregarlas a la matriz
                    else{
                        matriz.D.add(ciudad1);
                        matriz.D.add(ciudad2);
                        matriz.D.addEdge(ciudad1, ciudad2, distancia);
                    }
                }
                // Recalcular las rutas mas cortas
                matriz.caminoCorto();
            }
       
            System.out.println("1. Buscar ruta mas corta entre dos ciudades ");
            System.out.println("2. Nombre de la ciudad en el centro del grafo");
            System.out.println("3. Modificar grafo");
            System.out.println("4. Finalizar programa");
            seleccion = scan.nextInt();
        }
        
    }
}

