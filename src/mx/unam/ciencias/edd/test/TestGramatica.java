package mx.unam.ciencias.edd.test;

//import java.util.Iterator;
//import java.util.NoSuchElementException;
//import java.lang.IllegalArgumentException;
//import java.util.Random;
//import mx.unam.ciencias.edd.ExcepcionIndiceInvalido;
//import mx.unam.ciencias.edd.IteradorLista;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.Ficha;
import mx.unam.ciencias.edd.Ficha.Simbolo;
//import mx.unam.ciencias.edd.Cola;
import mx.unam.ciencias.edd.Gramatica.ReglaGramatical;
import mx.unam.ciencias.edd.ArbolSintactico;
import mx.unam.ciencias.edd.Gramatica;
import org.junit.Assert;
import org.junit.Test;

/**
 * Clase para pruebas unitarias de la clase {@link Ficha}.
 */
public class TestGramatica {

//    private Random random;
//    private int total;
//    private Ficha ficha;
    
    /**
     */
    public TestGramatica() {
//        random = new Random();
//        total = 10 + random.nextInt(90);
////        ficha = new Ficha();
    }
    /**
     * Prueba unitaria para {@link Gramatica#sePuedeProducir}.
     */
    @Test public void testSePuedeProducir() {
        
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.S)),ReglaGramatical._1_S_E));
        
        
            for (ReglaGramatical r : ReglaGramatical.values())
            {
                if(r == ReglaGramatical._1_S_E)
                    continue;
                
                    Assert.assertFalse(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.S)),r));
            }
//
        Ficha.Simbolo actual = Ficha.Simbolo.E;
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._2_E_E_T));
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._3_E_E__T));
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._4_E_T));

        for (ReglaGramatical r : ReglaGramatical.values())
        {
            if(r == ReglaGramatical._2_E_E_T ||  r == ReglaGramatical._3_E_E__T || r == ReglaGramatical._4_E_T )
                continue;
            
                Assert.assertFalse(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),r));
        }
//
//        
        actual = Ficha.Simbolo.T;
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._5_T_T_F));
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._6_T_T__F));
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._7_T_F));
//
//        
        for (ReglaGramatical r : ReglaGramatical.values())
        {
            if(r == ReglaGramatical._5_T_T_F ||  r == ReglaGramatical._6_T_T__F || r == ReglaGramatical._7_T_F )
                continue;
            
            Assert.assertFalse(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),r));
        }
//
//        
        actual = Ficha.Simbolo.F;
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._8_F_F_M));
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._9_F_M));
        
        for (ReglaGramatical r : ReglaGramatical.values())
        {
            if(r == ReglaGramatical._8_F_F_M ||  r == ReglaGramatical._9_F_M )
                continue;
            
            Assert.assertFalse(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),r));
        }
//
//        
//        
//        
        actual = Ficha.Simbolo.M;
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._10_M_Y_E_));
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._11_M__E_));
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._12_M__E));
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._13_M_Q));
        
        for (ReglaGramatical r : ReglaGramatical.values())
        {
            if(r == ReglaGramatical._10_M_Y_E_ ||  r == ReglaGramatical._11_M__E_ || r == ReglaGramatical._12_M__E  || r == ReglaGramatical._13_M_Q  )
                continue;
            
            Assert.assertFalse(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),r));
        }
//
//
        actual = Ficha.Simbolo.Y;
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._14_Y_func));
        for (ReglaGramatical r : ReglaGramatical.values())
        {
            if(r == ReglaGramatical._14_Y_func )
                continue;
            Assert.assertFalse(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),r));
        }
//
        actual = Ficha.Simbolo.Q;
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._15_Q_num));
        Assert.assertTrue(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),ReglaGramatical._16_Q_var));
        for (ReglaGramatical r : ReglaGramatical.values())
        {
            if(r == ReglaGramatical._15_Q_num ||  r == ReglaGramatical._16_Q_var  )
                continue;
            
            Assert.assertFalse(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(new Ficha(actual)),r));
        }
//
        Lista<Ficha> lf = new Lista<Ficha>();
        for( Simbolo s : Simbolo.values())
            lf.agregaFinal(new Ficha(s));
        
        for( Ficha f : lf)
        {
            
            if(!f.esTerminal())
                continue;
            
            for(ReglaGramatical r : ReglaGramatical.values())
            {
                Assert.assertFalse(Gramatica.sePuedeProducir(new ArbolSintactico<Ficha>(f),r));
                
            }
                
        }
    
    
    
    }
        
        
        
       
    
    
    
//    /**
//     * Prueba unitaria para {@link Gramatica#producir}.
//     */
//    @Test public void testProducir() {
//        
//        
//        
//    }
    /**
     * Prueba unitaria para {@link Gramatica#sePuedeDerivar}.
     */
    @Test public void testSePuedeDerivar() {
        
        Lista<ArbolSintactico<Ficha>> l;
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.Y)));
        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_I)));
        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E)));
        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_D)));
        
                Assert.assertTrue(Gramatica.sePuedeDerivar(l,ReglaGramatical._10_M_Y_E_));
        
        for (ReglaGramatical r: ReglaGramatical.values()){
            if(r == ReglaGramatical._10_M_Y_E_ || r== ReglaGramatical._11_M__E_ )
                continue;
            Assert.assertFalse(Gramatica.sePuedeDerivar(l,r));
        }


        l = new Lista<ArbolSintactico<Ficha>>();

        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_I)));
        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E)));
        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_D)));
        
        Assert.assertTrue(Gramatica.sePuedeDerivar(l,ReglaGramatical._11_M__E_));
        for (ReglaGramatical r: ReglaGramatical.values())
        {
            if(r == ReglaGramatical._11_M__E_)
                continue;
            Assert.assertFalse(Gramatica.sePuedeDerivar(l,r));
        }



        l = new Lista<ArbolSintactico<Ficha>>();
        
        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MENOS)));
        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E)));
        Assert.assertTrue(Gramatica.sePuedeDerivar(l,ReglaGramatical._12_M__E));
        for (ReglaGramatical r: ReglaGramatical.values())
        {
            if(r == ReglaGramatical._1_S_E || r == ReglaGramatical._12_M__E)
                continue;
            Assert.assertFalse(Gramatica.sePuedeDerivar(l,r));
        }
      
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E)));
        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MAS)));
        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T)));
        Assert.assertTrue(Gramatica.sePuedeDerivar(l,ReglaGramatical._2_E_E_T));
        
        for (ReglaGramatical r: ReglaGramatical.values())
        {
            if(r == ReglaGramatical._2_E_E_T || r == ReglaGramatical._4_E_T)
                continue;
            Assert.assertFalse(Gramatica.sePuedeDerivar(l,r));
        }
    
        
        
        
    }
//    
//    /**
//     * Prueba unitaria para {@link Gramatica#derivar}.
//     */
//    @Test public void testDerivar() {
//        Lista<ArbolSintactico<Ficha>> l;
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.Y)));
//        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_I)));
//        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E)));
//        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_D)));
//
//        ArbolSintactico<Ficha> given = Gramatica.derivar(l,ReglaGramatical._10_M_Y_E_);
//        Assert.assertTrue(given.getFicha().getSimbolo()==Ficha.Simbolo.M);
//        
//        
//   
//        l = new Lista<ArbolSintactico<Ficha>>();
//        
//        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_I)));
//        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E)));
//        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_D)));
//        
//        given = Gramatica.derivar(l,ReglaGramatical._11_M__E_);
//        Assert.assertTrue(given.getFicha().getSimbolo()==Ficha.Simbolo.M);
//        
//        
//        l = new Lista<ArbolSintactico<Ficha>>();
//        
//        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MENOS)));
//        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E)));
//        
//
//        given = Gramatica.derivar(l,ReglaGramatical._12_M__E);
//        Assert.assertTrue(given.getFicha().getSimbolo()==Ficha.Simbolo.M);
//        
//        
//        
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E)));
//        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MAS)));
//        l.agregaFinal(new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T)));
//        
//        
//        given = Gramatica.derivar(l,ReglaGramatical._2_E_E_T);
//        Assert.assertTrue(given.getFicha().getSimbolo()==Ficha.Simbolo.E);
//        
//        
//
//        
//    }


}
