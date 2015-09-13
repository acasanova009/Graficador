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

    private Random random;
    private int total;
    private Ficha ficha;
    
    /**
     */
    public TestFicha() {
        random = new Random();
        total = 10 + random.nextInt(90);
//        ficha = new Ficha("");
    }
    /**
     * Prueba unitaria para {@link AnalizadorLexico#analizarLexico}.
     */
    @Test public void testGenerarFicha() {
//        
//        Ficha f;
//        f = new Ficha("sin");
//        Assert.assertTrue(Ficha.Simbolo.FUNCION == f.getSimbolo());
//        Assert.assertTrue("sin" == f.getValor());
//        
//        f = new Ficha("45678.67");
//        Assert.assertTrue(Ficha.Simbolo.REAL == f.getSimbolo());
//        Assert.assertTrue("45678.67" == f.getValor());
//        
//        f = new Ficha(".67");
//        Assert.assertTrue(Ficha.Simbolo.REAL == f.getSimbolo());
//        Assert.assertTrue(".67" == f.getValor());
//        
//        f = new Ficha("45678.");
//        Assert.assertTrue(Ficha.Simbolo.REAL == f.getSimbolo());
//        Assert.assertTrue("45678." == f.getValor());
//        
//        f = new Ficha("45");
//        Assert.assertTrue(Ficha.Simbolo.REAL == f.getSimbolo());
//        Assert.assertTrue("45" == f.getValor());
//        
//        f = new Ficha("x");
//        Assert.assertTrue(Ficha.Simbolo.VAR == f.getSimbolo());
//        Assert.assertTrue("x" == f.getValor());
        
    }
    /**
     * Prueba unitaria para {@link Ficha#esFichaValida}.
     */
    @Test public void testEsFichaValida() {
        
//        Assert.assertTrue(Ficha.esFichaValida("2345.09876"));
//        Assert.assertTrue(Ficha.esFichaValida("("));
//        Assert.assertTrue(Ficha.esFichaValida(")"));
//        Assert.assertTrue(Ficha.esFichaValida("sin"));
//        Assert.assertTrue(Ficha.esFichaValida("cos"));
//        Assert.assertTrue(Ficha.esFichaValida("tan"));
//        Assert.assertTrue(Ficha.esFichaValida("cot"));
//        Assert.assertTrue(Ficha.esFichaValida("sec"));
//        Assert.assertTrue(Ficha.esFichaValida("csc"));
//        
//                Assert.assertTrue(Ficha.esFichaValida("*"));
//                Assert.assertTrue(Ficha.esFichaValida("+"));
//                Assert.assertTrue(Ficha.esFichaValida("-"));
//                Assert.assertTrue(Ficha.esFichaValida("/"));
//                Assert.assertTrue(Ficha.esFichaValida("^"));
//        
//        Assert.assertFalse(Ficha.esFichaValida("--"));
//        Assert.assertFalse(Ficha.esFichaValida("*sen"));
//        Assert.assertFalse(Ficha.esFichaValida("(3"));
//        Assert.assertFalse(Ficha.esFichaValida("-6"));
//        Assert.assertFalse(Ficha.esFichaValida("2^"));
//        
//        Assert.assertFalse(Ficha.esFichaValida(""));
//        Assert.assertFalse(Ficha.esFichaValida(" "));
//        
//        
//        Ficha f;
//        f = new Ficha("sin");
//        Assert.assertTrue(Ficha.Simbolo.FUNCION == f.getSimbolo());
//        
//        f = new Ficha("45678.67");
//        Assert.assertTrue(Ficha.Simbolo.REAL == f.getSimbolo());
//        
//        f = new Ficha(".67");
//        Assert.assertTrue(Ficha.Simbolo.REAL == f.getSimbolo());
//        
//        f = new Ficha("45678.");
//        Assert.assertTrue(Ficha.Simbolo.REAL == f.getSimbolo());
//        
//        f = new Ficha("45");
//        Assert.assertTrue(Ficha.Simbolo.REAL == f.getSimbolo());
//        
//        f = new Ficha("x");
//        Assert.assertTrue(Ficha.Simbolo.VAR == f.getSimbolo());
//        

        
        
    }
    
    /**
     * Prueba unitaria para {@link Ficha#sePuedeReducir}.
     */
    @Test public void testSePuedeReducir() {

//        try{
//            Ficha.sePuedeReducir(null,-1);
//            
//        }catch(IllegalArgumentException e){}
//        
//        try{
//            Ficha.sePuedeReducir(null,10);
//            
//        }catch(IllegalArgumentException e){}

    }
}
