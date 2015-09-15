package mx.unam.ciencias.edd.test;

//import java.util.Iterator;
//import java.util.NoSuchElementException;
//import java.lang.IllegalArgumentException;
import java.util.Random;
//import mx.unam.ciencias.edd.ExcepcionIndiceInvalido;
//import mx.unam.ciencias.edd.IteradorLista;
//import mx.unam.ciencias.edd.Lista;
//import mx.unam.ciencias.edd.Ficha;
//import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.ArbolRetroceso;
import org.junit.Assert;
import org.junit.Test;

/**
 * Clase para pruebas unitarias de la clase {@link Ficha}.
 */
public class TestArbolRetroceso {

    private Random random;
    private int total;

    
    /**
     */
    public TestArbolRetroceso() {
        random = new Random();
        total = 10 + random.nextInt(90);

    }
    
    /**
     * Prueba unitaria para {@link ArbolRetroceso#registrar}.
     */
    @Test public void TestRegistrar() {
        
        ArbolRetroceso<Integer> ar = new ArbolRetroceso<Integer>();
        for(int i = 0; i<3;i++)
            ar.registrar(2);
        
        ar.registrar(1);
        ar.regresar();
        Assert.assertTrue(ar.elementoYaFueRegistrado(1));
        Assert.assertFalse(ar.elementoYaFueRegistrado(2));
    }
    /**
     * Prueba unitaria para {@link ArbolRetroceso#elementoYaFueRegistrado}.
     */
    @Test public void TestElementoYaFueRegistrado() {
        ArbolRetroceso<Integer> ar = new ArbolRetroceso<Integer>();
        for(int i = 0; i<3;i++)
            ar.registrar(2);
        
        ar.registrar(1);
        ar.regresar();
        Assert.assertTrue(ar.elementoYaFueRegistrado(1));
        Assert.assertFalse(ar.elementoYaFueRegistrado(2));
    }
    /**
     * Prueba unitaria para {@link ArbolRetroceso#regresar}.
     */
    @Test public void TestRegresar(){
        ArbolRetroceso<Integer> ar = new ArbolRetroceso<Integer>();
        for(int i = 0; i<3;i++)
            ar.registrar(2);
        
        ar.registrar(1);
        ar.regresar();
        Assert.assertTrue(ar.elementoYaFueRegistrado(1));
        Assert.assertFalse(ar.elementoYaFueRegistrado(2));

        
    }
    
    
}
