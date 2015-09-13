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
import mx.unam.ciencias.edd.Gramatica.ReglaGramatical;

import org.junit.Assert;
import org.junit.Test;

/**
 * Clase para pruebas unitarias de la clase {@link ArbolSintactico}.
 */
public class TestArbolSintactico {

    private Random random;
    private int total;
    private ArbolSintactico<Ficha> arbol;
    
    /**
     */
    public TestArbolSintactico() {
        random = new Random();
        total = 10 + random.nextInt(90);
        arbol = setArbol(); //22+33*x
        
        
    }
    private ArbolSintactico<Ficha> setArbol()
    {
        //ARBOL DE EXPECTATIVA. 22+33*x
        
        ArbolSintactico<Ficha> izq = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.REAL,"22.0"));
        ArbolSintactico<Ficha> mid = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.REAL,"33.0"));
        ArbolSintactico<Ficha> der = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.VAR,"x"));
        //Setting der
        
        Ficha f;
        Lista<ArbolSintactico<Ficha>> l;
        f = new Ficha(Ficha.Simbolo.Q);
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(der);
        
        der = new ArbolSintactico<Ficha>(f,ReglaGramatical._16_Q_var,l);
        
        
        f = new Ficha(Ficha.Simbolo.M);
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(der);
        der = new ArbolSintactico<Ficha>(f,ReglaGramatical._13_M_Q,l);
        
        
        f = new Ficha(Ficha.Simbolo.F);
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(der);
        der = new ArbolSintactico<Ficha>(f,ReglaGramatical._9_F_M,l);
        //Setting mid.
        
        f = new Ficha(Ficha.Simbolo.Q);
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(mid);
        mid = new ArbolSintactico<Ficha>(f,ReglaGramatical._15_Q_num,l);
        
        f = new Ficha(Ficha.Simbolo.M);
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(mid);
        mid = new ArbolSintactico<Ficha>(f,ReglaGramatical._13_M_Q,l);
        
        
        f = new Ficha(Ficha.Simbolo.F);
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(mid);
        mid = new ArbolSintactico<Ficha>(f,ReglaGramatical._9_F_M,l);
        
        
        f = new Ficha(Ficha.Simbolo.T);
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(mid);
        mid = new ArbolSintactico<Ficha>(f,ReglaGramatical._7_T_F,l);
        
        
        // Setting mid and der.
        f = new Ficha(Ficha.Simbolo.T);
        l = new Lista<ArbolSintactico<Ficha>>();
        ArbolSintactico<Ficha> mult = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MULT));
        l.agregaFinal(mid);
        l.agregaFinal(mult);
        l.agregaFinal(der);
        der = new ArbolSintactico<Ficha>(f,ReglaGramatical._5_T_T_F,l);
        
        //Setting izq.
        
        
        f = new Ficha(Ficha.Simbolo.Q);
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(izq);
        izq = new ArbolSintactico<Ficha>(f,ReglaGramatical._15_Q_num,l);
        
        f = new Ficha(Ficha.Simbolo.M);
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(izq);
        izq = new ArbolSintactico<Ficha>(f,ReglaGramatical._13_M_Q,l);
        
        
        f = new Ficha(Ficha.Simbolo.F);
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(izq);
        izq = new ArbolSintactico<Ficha>(f,ReglaGramatical._9_F_M,l);
        
        
        f = new Ficha(Ficha.Simbolo.T);
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(izq);
        izq = new ArbolSintactico<Ficha>(f,ReglaGramatical._7_T_F,l);
        
        f = new Ficha(Ficha.Simbolo.E);
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(izq);
        izq = new ArbolSintactico<Ficha>(f,ReglaGramatical._4_E_T,l);
        
        //Setting SUMA simboloContenedor de E.
        
        
        f = new Ficha(Ficha.Simbolo.E);
        l = new Lista<ArbolSintactico<Ficha>>();
        ArbolSintactico<Ficha> sum = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MAS));
        l.agregaFinal(izq);
        l.agregaFinal(sum);
        l.agregaFinal(der);
        izq = new ArbolSintactico<Ficha>(f,ReglaGramatical._2_E_E_T,l);
        
        
        //Setting ROOT
        
        
        f = new Ficha(Ficha.Simbolo.S);
        l = new Lista<ArbolSintactico<Ficha>>();
        l.agregaFinal(izq);
        izq = new ArbolSintactico<Ficha>(f,ReglaGramatical._1_S_E,l);
        
        //Se supone izq, ya tiene todo el arbol de derivacion.....
        
        
        return izq;
    }
   
    
    
    /**
     * Prueba unitaria para {@link ArbolSintactico#reducir}.
     */
    @Test public void testReducir() {
        
        
        Lista<ArbolSintactico<Ficha>> r;
        
        ArbolSintactico<Ficha> y = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.FUNCION));
        ArbolSintactico<Ficha> p_i = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_I));
        ArbolSintactico<Ficha> e = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        ArbolSintactico<Ficha> p_d = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_D));
        Lista<ArbolSintactico<Ficha>> l = new Lista<ArbolSintactico<Ficha>>();
        
        l.agregaFinal(y);
        l.agregaFinal(p_i);
        l.agregaFinal(e);
        l.agregaFinal(p_d);
        
        
        ArbolSintactico<Ficha> m = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.M), ReglaGramatical._10_M_Y_E_,l);
        
        
         r = m.reducir();
        Assert.assertTrue(l.getLongitud() == r.getLongitud());
        Assert.assertTrue(l.equals(r));
        
        

//        p_i = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_I));
        e = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
//        p_d = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_D));
        l = new Lista<ArbolSintactico<Ficha>>();
        

        l.agregaFinal(p_i);
        l.agregaFinal(e);
        l.agregaFinal(p_d);
        
        
         m = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.M), ReglaGramatical._11_M__E_,l);
        
         r = m.reducir();
        
        
        Assert.assertTrue(l.getLongitud() == r.getLongitud());
        Assert.assertTrue(l.equals(r));
        
        
        
        ArbolSintactico<Ficha> exp = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        ArbolSintactico<Ficha> suma = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MAS));
        ArbolSintactico<Ficha> t_exp = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
         l = new Lista<ArbolSintactico<Ficha>>();
        
        
        l.agregaFinal(p_i);
        l.agregaFinal(e);
        l.agregaFinal(p_d);
        
        
         m = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.M), ReglaGramatical._2_E_E_T,l);
        
        r = m.reducir();
        
        
        Assert.assertTrue(l.getLongitud() == r.getLongitud());
        Assert.assertTrue(l.equals(r));
        
        
        
    }
   
    
    /**
     * Prueba unitaria para {@link ArbolSintactico#evaluar}.
     */
    @Test public void testEvaluar() {
        
        
        
        
        
        //Esta prueba es la unica independiente al creador de arboles - AnalizadorSintactico.
        for (double i = -10; i<10;i++ )
        {
            double x = 22+(33*i);
            Assert.assertTrue(x== arbol.evaluar(i));
            
        }
        
        

    }
}
