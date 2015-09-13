package mx.unam.ciencias.edd.test;

//import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import mx.unam.ciencias.edd.ExcepcionIndiceInvalido;
import mx.unam.ciencias.edd.IteradorLista;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.ArbolSintactico;
import mx.unam.ciencias.edd.AnalizadorSintactico;
import mx.unam.ciencias.edd.AnalizadorLexico;
import mx.unam.ciencias.edd.Ficha;

import org.junit.Assert;
import org.junit.Test;

/**
 * Clase para pruebas unitarias de la clase {@link ArbolSintactico}.
 */
public class TestArbolSintactico {

    private Random random;
    private int total;
    private ArbolSintactico arbol;
    
    /**
     */
    public TestArbolSintactico() {
        random = new Random();
        total = 10 + random.nextInt(90);
        arbol = new ArbolSintactico();
    }
    /**
     * Prueba unitaria para {@link AnalizadorLexico#evaluar}.
     */
    @Test public void testEvaluar() {
        
//        arbol = AnalizadorSintactico.generarArbolConFichas(AnalizadorLexico.analizarLexico("5*5+x"));
//        Assert.assertTrue(arbol.evaluar(5.0)==30.0);
//        
//        
//        arbol = AnalizadorSintactico.generarArbolConFichas(AnalizadorLexico.analizarLexico("2^x"));
//        Assert.assertTrue(arbol.evaluar(4.0)==16.0);
//
//        
//        
//        
//
//        arbol = AnalizadorSintactico.generarArbolConFichas(AnalizadorLexico.analizarLexico("x/0"));
//        
//
//        
//        try{
//            
//            arbol.evaluar(1);
//            Assert.fail();
//            
//        }catch(IllegalArgumentException e)
//        {
//        }
//        
//        arbol = AnalizadorSintactico.generarArbolConFichas(AnalizadorLexico.analizarLexico("x^-(1/2)"));
//        try{
//            
//            arbol.evaluar(1.0);
//            
//            Assert.fail();
//            
//        }catch(IllegalArgumentException e)
//        {
//            
//        }
//        
        
        
        
       
    }
}
