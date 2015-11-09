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

import static org.junit.Assert.*;

import org.junit.Test;


public class testCasos {
	MatrizGrafo grafo = new MatrizGrafo();
	String prueba = "a";
	
	@Test
	public void test_Add() {
		grafo.add(prueba);
		assertEquals(grafo.get(0), prueba);
	}
	
	@Test
	public void test_Index(){
		grafo.add(prueba);
		assertEquals(grafo.getIndex(prueba), 0);
	}
	
	@Test
	public void test_Contains(){
		grafo.add(prueba);
		assertEquals(grafo.contains(prueba), true);
	}
	
	@Test
	public void test_Size(){
		grafo.add(prueba);
		assertEquals(grafo.size(), 1);
	}
}
