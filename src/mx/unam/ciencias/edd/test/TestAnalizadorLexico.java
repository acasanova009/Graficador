package mx.unam.ciencias.edd.test;


import java.util.Random;
import mx.unam.ciencias.edd.LexicalSimbolException;
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

//    private Random random;
//    private int total;
//
    private Lista<Ficha> fichas;

    /**
     */
    public TestAnalizadorLexico() {
//
        fichas = new Lista<Ficha>();
    }
    
    /**
     * Prueba unitaria para {@link AnalizadorLexico#analizar}.
     */
    @Test public void testAnalizar() {
        Lista<Ficha> l;

         l = AnalizadorLexico.analizar(".");
        fichas = new Lista<Ficha>();
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        Assert.assertTrue(fichas.equals(l));
        
        l = AnalizadorLexico.analizar("..");
        fichas = new Lista<Ficha>();
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        Assert.assertTrue(fichas.equals(l));
        
        l = AnalizadorLexico.analizar("15+.1+1.+.");
        fichas = new Lista<Ficha>();
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.MAS));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.MAS));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.MAS));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        Assert.assertTrue(fichas.equals(l));
        
        
        l = AnalizadorLexico.analizar("2+12");
        fichas = new Lista<Ficha>();
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.MAS));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));

        Assert.assertTrue(fichas.equals(l));


        
        
        l = AnalizadorLexico.analizar("1.");
        fichas = new Lista<Ficha>();
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        Assert.assertTrue(fichas.equals(l));
        
        l = AnalizadorLexico.analizar("1");
        fichas = new Lista<Ficha>();
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        Assert.assertTrue(fichas.equals(l));



        
        fichas = new Lista<Ficha>();
        for (int i = 0; i < 3; i++)
            fichas.agregaFinal(new Ficha(Ficha.Simbolo.PAR_I));

        l = AnalizadorLexico.analizar("(((");
        Assert.assertTrue(fichas.equals(l));
        l = AnalizadorLexico.analizar(" ( ((   ");
        Assert.assertTrue(fichas.equals(l));

        l = AnalizadorLexico.analizar("- + *    /^");
        fichas = new Lista<Ficha>();
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.MENOS));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.MAS));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.MULT));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.DIV));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.EXPO));
        Assert.assertTrue(fichas.equals(l));

        l = AnalizadorLexico.analizar("1.  .2  1..3  4   .1.200  33.3");
        //SE TIENE QUE VER
        //1.0 0.21 0.0 0.34 0.1 0.20033 0.3
  
        fichas = new Lista<Ficha>();
        for (int i = 0; i < 7; i++)
            fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));

        Assert.assertTrue(fichas.getLongitud()==l.getLongitud());
        Assert.assertTrue(fichas.equals(l));

        l= AnalizadorLexico.analizar("sin  (cos ( tan ( x ) +.2) ) ");
        fichas = new Lista<Ficha>();
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.FUNCION));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.PAR_I));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.FUNCION));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.PAR_I));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.FUNCION));
        
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.PAR_I));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.VAR));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.PAR_D));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.MAS));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.PAR_D));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.PAR_D));
        


        Assert.assertTrue(fichas.getLongitud()==l.getLongitud());
        Assert.assertTrue(fichas.equals(l));

        l= AnalizadorLexico.analizar("++ --** xx secsec.1.1 (())1. 1. 2.2 2.2 )");
        fichas = new Lista<Ficha>();
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.MAS));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.MAS));
        
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.MENOS));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.MENOS));
        
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.MULT));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.MULT));
        
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.VAR));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.VAR));
        
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.FUNCION));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.FUNCION));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.PAR_I));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.PAR_I));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.PAR_D));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.PAR_D));
        
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));

        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.REAL));
        fichas.agregaFinal(new Ficha(Ficha.Simbolo.PAR_D));


        Assert.assertTrue(fichas.getLongitud()==l.getLongitud());
        Assert.assertTrue(fichas.equals(l));

        
        try{
            l= AnalizadorLexico.analizar("25+26*x+siy(x)");
            Assert.fail();
        }catch(LexicalSimbolException e)
        {

        }


        
    }

}
