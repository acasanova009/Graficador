package mx.unam.ciencias.edd.test;

//import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import mx.unam.ciencias.edd.ExcepcionIndiceInvalido;
import mx.unam.ciencias.edd.IteradorLista;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.AnalizadorSintactico;
import org.junit.Assert;
import org.junit.Test;

/**
 * Clase para pruebas unitarias de la clase {@link AnalizadorSintactico}.
 */
public class TestAnalizadorSintactico {

    private Random random;
    private int total;
//    private AnalizadorSintactico aSin;
    
    /**
     */
    public TestAnalizadorSintactico() {
        random = new Random();
        total = 10 + random.nextInt(90);
//        aSin = new AnalizadorSintactico();
    }
    /**
     * Prueba unitaria para {@link AnalizadorLexico#EsGramaticaValida}.
     */
    @Test public void testEsGramaticaValida() {
        
        Assert.assertTrue(AnalizadorSintactico.esGramaticaValida("[v,o,r,o,f,(,r,o,r,)]"));
        
        Assert.assertTrue(AnalizadorSintactico.esGramaticaValida("[o,r]"));
        Assert.assertTrue(AnalizadorSintactico.esGramaticaValida("[o,v]"));
        Assert.assertTrue(AnalizadorSintactico.esGramaticaValida("[f,(,o,v,),o,v,o,r]"));
        Assert.assertTrue(AnalizadorSintactico.esGramaticaValida("[r]"));
        Assert.assertTrue(AnalizadorSintactico.esGramaticaValida("[r,o,r]"));
        Assert.assertTrue(AnalizadorSintactico.esGramaticaValida("[r,o,v]"));
        Assert.assertTrue(AnalizadorSintactico.esGramaticaValida("[v,o,f,(,v,)]"));
        Assert.assertTrue(AnalizadorSintactico.esGramaticaValida("[f,(,r,o,(,v,o,v,),)]"));
        Assert.assertTrue(AnalizadorSintactico.esGramaticaValida("[r,o,(,r,o,v,)]"));
        Assert.assertTrue(AnalizadorSintactico.esGramaticaValida("[v,o,v,o,v,o,v]"));
        
        
        
        Assert.assertFalse(AnalizadorSintactico.esGramaticaValida("[v,v]"));
        Assert.assertFalse(AnalizadorSintactico.esGramaticaValida("[o,o]"));
        Assert.assertFalse(AnalizadorSintactico.esGramaticaValida("[f,v]"));
        Assert.assertFalse(AnalizadorSintactico.esGramaticaValida("[o,f]"));
        Assert.assertFalse(AnalizadorSintactico.esGramaticaValida("[f,)]"));
        Assert.assertFalse(AnalizadorSintactico.esGramaticaValida("[v,)]"));
        Assert.assertFalse(AnalizadorSintactico.esGramaticaValida("[(,)]"));
        Assert.assertFalse(AnalizadorSintactico.esGramaticaValida("[),(]"));
        
    }
}
