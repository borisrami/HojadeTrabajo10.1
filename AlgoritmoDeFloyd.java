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


import java.io.IOException;

public class AlgoritmoDeFloyd {
    
    Archivo a= new Archivo();
    InterfazGrafo D;
    int[][] P;
    int[] max;
    int centro;
    int minimo=10000;
    
    public AlgoritmoDeFloyd(){
        
        try {
            a.obtenerArchivo("datos.txt");
            a.arregloCiudades(); 				// Nombre de los nodos
            D = a.matrizDistancias(); 				// Distancia de los arcos entre nodos
            P = new int[25][25]; 				// Matriz de nodos intermedios
            max = new int[25];
        } catch (IOException ex) {
            ex.printStackTrace();
        }
        for(int n=0;n<a.grafo.size();n++){
            for(int m=0;m<a.grafo.size();m++){
                P[n][m]=10000;
            }
        }
    }
    //Camino mas corto entre dos nodos
    public void caminoCorto(){
        for(int k=0;k<D.size();k++){
            for(int i=0;i<D.size();i++){
                for(int j=0;j<D.size();j++){
                    if(D.getEdge(D.get(i),D.get(j))>(D.getEdge(D.get(i), D.get(k))+D.getEdge(D.get(k), D.get(j)))){
                        D.addEdge(D.get(i), D.get(j), (D.getEdge(D.get(i), D.get(k))+D.getEdge(D.get(k), D.get(j))));
                        P[i][j]=k;
                    }
                }
            }
        }
        
    }
    
    //Encuentra el centro del grafo
    public void centroGrafo(){
        caminoCorto();
        int n=0;       
        // Encontrar los maximos de cada columna de la matriz
        for(int i=0;i<D.size();i++){
            for(int j=0;j<D.size()-1;j++){
                int num1=D.getEdge(D.get(j), D.get(i));
                n=j;
                n++;
                int num2=D.getEdge(D.get(n), D.get(i));
                if(num1>num2){
                    max[i]=num1;
                }
                else{
                    max[i]=num2;
                }
            }
            n++;
        }
        // Encontrar el minimo de los maximos de cada columna
        for(int i=0;i<D.size();i++){
            int num1=max[i];
            if(num1<minimo){
                centro=i;
                minimo=num1;
            }
        }
        System.out.println("\nEl centro del grafo es: "+D.get(centro)+"\n");
        
    }
    
    //Ciudades intermedias en el recorrido
    public void mostrarIntermedias(int num1, int num2){
        if(P[num1][num2]!=10000){
            mostrarIntermedias(num1,P[num1][num2]);
            System.out.print(", "+D.get(P[num1][num2]));
            mostrarIntermedias(P[num1][num2],num2);
            return;
        }
        else return;
           
    }
}
