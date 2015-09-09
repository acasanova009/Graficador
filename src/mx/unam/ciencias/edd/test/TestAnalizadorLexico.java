package mx.unam.ciencias.edd.test;

//import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import mx.unam.ciencias.edd.ExcepcionIndiceInvalido;
import mx.unam.ciencias.edd.IteradorLista;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.AnalizadorLexico;
import mx.unam.ciencias.edd.Ficha;
import org.junit.Assert;
import org.junit.Test;

/**
 * Clase para pruebas unitarias de la clase {@link AnalizadorLexico}.
 */
public class TestAnalizadorLexico {

    private Random random;
    private int total;
    private AnalizadorLexico alex;
    private Lista<Ficha> fichas;

    /**
     */
    public TestAnalizadorLexico() {
        random = new Random();
        total = 10 + random.nextInt(90);
        alex = new AnalizadorLexico();
        fichas = new Lista<Ficha>();
    }
    /**
     * Prueba unitaria para {@link AnalizadorLexico#analizarLexico}.
     */
    @Test public void testAnalizarLexico() {
        
        Assert.assertTrue(true);
        Assert.assertTrue( alex.analizarLexico("1") != null);
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
