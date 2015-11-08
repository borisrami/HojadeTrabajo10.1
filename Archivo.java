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

import java.io.*;


public class Archivo{
    
    File archivo;
    FileReader fr;
    BufferedReader br;
    InterfazGrafo grafo = new MatrizGrafo();

    
    //Obtener archivo con las ciudades
    public void obtenerArchivo(String direccion) throws FileNotFoundException{
       archivo=new File(direccion); 
    }  
    
    //Nombre de los nodos para el grafo
    public InterfazGrafo arregloCiudades() throws IOException{
        // Lectura del fichero
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        String linea;
        while((linea=br.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafo.add(tmp[0]);
            grafo.add(tmp[1]);
        }
        return grafo;
    }
    
    //Distancia de los arcos entre nodos
    public InterfazGrafo matrizDistancias() throws IOException{
        // Lectura del fichero
        fr = new FileReader (archivo);
        br = new BufferedReader(fr);
        String linea;

        while((linea=br.readLine())!=null){
            String[] tmp;
            tmp=linea.split(" ");
            grafo.addEdge(tmp[0], tmp[1], tmp[2]);
        }
        return grafo;
    }
    

}

