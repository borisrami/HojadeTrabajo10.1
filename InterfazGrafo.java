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

public interface InterfazGrafo<V,E> {

    public void add(V v);

    public void addEdge(V v1, V v2, E n);
    
    public void show();
    
    public int getIndex(V v);

    public V get(int d);
    
    public int getEdge(V v1, V v2);
    
    public boolean contains(V v);
    
    public int size();
    
}
