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

import java.util.Vector;


public class MatrizGrafo<V,E> implements InterfazGrafo<V,E>{

    private Vector vertices = new Vector();
    private int[][] arcos= new int [25][25];
    
    public MatrizGrafo(){
        
        for(int i=0;i<25;i++){
            for(int j=0;j<25;j++){
                if(i==j){
                    arcos[i][j]=0;
                }
                else{
                    arcos[i][j]=10000;
                }
            }
        }
    }

    @Override
    public void add(V v) {
        
        if(!vertices.contains(v)){
            vertices.add(v);
        }
        
        
    }

    @Override
    public void addEdge(V vtx1, V vtx2, E n) {
        int i = vertices.indexOf(vtx1);
        int j = vertices.indexOf(vtx2);        
        String tmp = ""+n;
        int distancia = Integer.parseInt(tmp);
        arcos[i][j]=distancia;
    }
    
    @Override
    public void show(){
        for(int a=0;a<vertices.size();a++){
            for(int b=0;b<vertices.size();b++){
                System.out.print(""+arcos[a][b]+" ");
            }
            System.out.println("");
        }
    }
    
    @Override
    public int size(){
        return vertices.size();
    }

    @Override
    public int getEdge(V v1, V v2){
        return arcos[vertices.indexOf(v1)][vertices.indexOf(v2)];
    }
    
    @Override
    public V get(int p){
        
        return (V)vertices.get(p);
        
    }
    
    @Override
    public int getIndex(V v){
        return vertices.indexOf(v);
    }
    
    public boolean contains(V v){
        return vertices.contains(v);
    }
}

