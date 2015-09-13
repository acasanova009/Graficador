 package mx.unam.ciencias.edd.test;

//import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import mx.unam.ciencias.edd.ExcepcionIndiceInvalido;
import mx.unam.ciencias.edd.IteradorLista;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.AnalizadorSintactico;
import mx.unam.ciencias.edd.Gramatica.ReglaGramatical;
import mx.unam.ciencias.edd.ArbolSintactico;
import mx.unam.ciencias.edd.ArbolRetroceso;
import mx.unam.ciencias.edd.Ficha;
import mx.unam.ciencias.edd.Pila;
import org.junit.Assert;
import org.junit.Test;

/**
 * Clase para pruebas unitarias de la clase {@link AnalizadorSintactico}.
 */
public class TestAnalizadorSintactico {

    private Random random;
    private int total;
    private ArbolSintactico<Ficha> arbol;
//    private AnalizadorSintactico aSin;
    
    /**
     */
    public TestAnalizadorSintactico() {
        random = new Random();
        total = 10 + random.nextInt(90);
        arbol = setArbol();
    }
    /**
     * Prueba unitaria para {@link AnalizadorSintactico#analizar}.
     */
    @Test public void testAnalizar()
    {

        Lista<ArbolSintactico<Ficha>> l = new Lista<ArbolSintactico<Ficha>> ();
        ArbolRetroceso<ReglaGramatical> t = new ArbolRetroceso<ReglaGramatical>(ReglaGramatical.__none);
        Pila<ArbolSintactico<Ficha>> b = new Pila<ArbolSintactico<Ficha>> ();
//
        ArbolSintactico<Ficha> _22 = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.REAL));
        ArbolSintactico<Ficha> _mas = new ArbolSintactico<Ficha>(new Ficha (Ficha.Simbolo.MAS));
        ArbolSintactico<Ficha> _33 = new ArbolSintactico<Ficha>(new Ficha (Ficha.Simbolo.REAL));
        ArbolSintactico<Ficha> _mult = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MULT));
        ArbolSintactico<Ficha> _x = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.VAR));

        b.mete(_x);
        b.mete(_mult);
        b.mete(_33);
        b.mete(_mas);
        b.mete(_22);
        
        if (AnalizadorSintactico.analizar(l,b,t)){
            Assert.assertTrue(l.getLongitud() == 1);
            ArbolSintactico<Ficha> primero = l.getPrimero();
            Assert.assertTrue(primero.getReglaGramatical()==ReglaGramatical._1_S_E);
            Assert.assertTrue(arbol.getElementos()==primero.getElementos());
            
        }
        
        
            
            
            
        
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
    
}
