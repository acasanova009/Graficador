package mx.unam.ciencias.edd.test;

//import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import mx.unam.ciencias.edd.ExcepcionIndiceInvalido;
import mx.unam.ciencias.edd.IteradorLista;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.ArbolSintactico;
import org.junit.Assert;
import org.junit.Test;

/**
 * Clase para pruebas unitarias de la clase {@link ArbolSintactico}.
 */
public class TestArbolSintactico {

    private Random random;
    private int total;
    private ArbolSintactico alex;
    
    /**
     */
    public TestArbolSintactico() {
        random = new Random();
        total = 10 + random.nextInt(90);
        alex = new ArbolSintactico();
    }
    /**
     * Prueba unitaria para {@link AnalizadorLexico#analizarLexico}.
     */
    @Test public void testArbolSintactico() {
        
        Assert.assertTrue(true);
        //        lista.agregaInicio(1);
        //        Assert.assertTrue(1  == lista.getPrimero());
        //        lista.agregaFinal(2);
        //        Assert.assertFalse(2 == lista.getPrimero());
        //        for (int i = 0; i < total; i++) {
        //            int e = random.nextInt(total);
        //            lista.agregaInicio(e);
        //            Assert.assertTrue(e == lista.getPrimero());
        //        }
    }
}
