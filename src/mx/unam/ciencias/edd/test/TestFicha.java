package mx.unam.ciencias.edd.test;

//import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;
import java.util.Random;
import mx.unam.ciencias.edd.ExcepcionIndiceInvalido;
import mx.unam.ciencias.edd.IteradorLista;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.Ficha;
import mx.unam.ciencias.edd.Cola;
import org.junit.Assert;
import org.junit.Test;

/**
 * Clase para pruebas unitarias de la clase {@link Ficha}.
 */
public class TestFicha {

//    private Random random;
//    private int total;
//    private Ficha ficha;
    
    /**
     */
    public TestFicha() {
//        random = new Random();
//        total = 10 + random.nextInt(90);
////        ficha = new Ficha();
    }
    
    /**
     * Prueba unitaria para {@link Ficha#esTerminal}.
     */
    @Test public void testEsTerminal() {
        Ficha f;
        f = new Ficha(Ficha.Simbolo.S);
        Assert.assertFalse(f.esTerminal());
        
        f = new Ficha(Ficha.Simbolo.E);
        Assert.assertFalse(f.esTerminal());
        
        f = new Ficha(Ficha.Simbolo.T);
        Assert.assertFalse(f.esTerminal());
        
        f = new Ficha(Ficha.Simbolo.F);
        Assert.assertFalse(f.esTerminal());
        
        f = new Ficha(Ficha.Simbolo.M);
        Assert.assertFalse(f.esTerminal());
        
        f = new Ficha(Ficha.Simbolo.Y);
        Assert.assertFalse(f.esTerminal());
        
        f = new Ficha(Ficha.Simbolo.Q);
        Assert.assertFalse(f.esTerminal());
        
        f = new Ficha(Ficha.Simbolo.REAL);
        Assert.assertTrue(f.esTerminal());

        
    }
}
