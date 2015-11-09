//Christopher Chiroy
//Boris Cifuentes


//Algoritmos y estructura de datos
//Hoja de trabajo 10


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
