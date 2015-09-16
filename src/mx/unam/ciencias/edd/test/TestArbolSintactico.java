package mx.unam.ciencias.edd.test;

//import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import mx.unam.ciencias.edd.ExcepcionIndiceInvalido;
import mx.unam.ciencias.edd.IteradorLista;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.ArbolRetroceso;
import mx.unam.ciencias.edd.ArbolSintactico;
import mx.unam.ciencias.edd.AnalizadorSintactico;
import mx.unam.ciencias.edd.AnalizadorLexico;
import mx.unam.ciencias.edd.Ficha;
import mx.unam.ciencias.edd.Pila;
import mx.unam.ciencias.edd.Gramatica;
import mx.unam.ciencias.edd.Gramatica.ReglaGramatical;

import java.lang.Math;

import org.junit.Assert;
import org.junit.Test;

/**
 * Clase para pruebas unitarias de la clase {@link ArbolSintactico}.
 */
public class TestArbolSintactico {

    private Random random;

    private AnalizadorSintactico aSint;
    private Ficha.Simbolo[] simbolos;
    private static final int cantidadDeSimbolos = 17;//LOS SIMBOLOS DE LAS FICHAS..
    
    /**
     */
    public TestArbolSintactico() {
        random = new Random();
//        arbol = setArbol(); //22+33*x
        simbolos = new Ficha.Simbolo[cantidadDeSimbolos];
        setSimbolos();
        
        aSint = new AnalizadorSintactico();
        
    }
    public void setSimbolos(){
        int i= 0;
        for(Ficha.Simbolo s : Ficha.Simbolo.values())
        {
            simbolos[i] = s;
            i++;
        }
            
    }
    public Ficha.Simbolo randomSimbolExcept(Ficha.Simbolo oldSimbol)
    {
        Ficha.Simbolo newSimbol = simbolos[random.nextInt(cantidadDeSimbolos)];
        if(newSimbol == oldSimbol)
            return randomSimbolExcept(oldSimbol);
        return newSimbol;
        
        
    }
    public Ficha.Simbolo randomSimbol()
    {
        Ficha.Simbolo newSimbol = simbolos[random.nextInt(cantidadDeSimbolos)];
        return newSimbol;
        
    }
     /**
     * Prueba unitaria para {@link ArbolSintactico#derivar}.
     */
    
    @Test public void TestDerivar()
    {

        
        
        ArbolSintactico<Ficha> root = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.S),ReglaGramatical.__none);
        Lista<ArbolSintactico<Ficha>> l;
        ArbolSintactico<Ficha> _1;
        ArbolSintactico<Ficha> _2;
        ArbolSintactico<Ficha> _3;
        ArbolSintactico<Ficha> _4;
        ArbolSintactico<Ficha> _5;
    ArbolSintactico<Ficha> _6;
    
        Lista<ArbolSintactico<Ficha>> m; //Lista despues de la derivacion
        Lista<ArbolSintactico<Ficha>> acotada;//Lista original simplemente acotada.
        
        
        
        m= new Lista<ArbolSintactico<Ficha>>();
                acotada = new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.REAL,ReglaGramatical.__none,"12"));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.Q));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.M));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.F));
        _5 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
        _5 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        m.agregaFinal(_1);
        root.derivar(new Ficha(Ficha.Simbolo.Q), ReglaGramatical._15_Q_num,m );
        root.derivar(new Ficha(Ficha.Simbolo.M), ReglaGramatical._13_M_Q, m );
        root.derivar(new Ficha(Ficha.Simbolo.F), ReglaGramatical._9_F_M,m );
        root.derivar(new Ficha(Ficha.Simbolo.T), ReglaGramatical._7_T_F,m );
        root.derivar(new Ficha(Ficha.Simbolo.E), ReglaGramatical._4_E_T,m );

        acotada = m.getUltimo().reducir();
        acotada = acotada.getUltimo().reducir();
        acotada = acotada.getUltimo().reducir();
        acotada = acotada.getUltimo().reducir();
        acotada = acotada.getUltimo().reducir();
        
        ArbolSintactico<Ficha> again = acotada.getUltimo();
        Assert.assertTrue(again.getFicha().getValor().equals("12"));

        
        
        
        
        
        
        
        
        
        
        
        //         _1_S_E,
        //        _4_E_T,
        //        _7_T_F,
        //        _9_F_M,
        //        _13_M_Q,
        //        _14_Y_func,
        //        _15_Q_num,
        //        _16_Q_var,
        
        /**
         * Para gramaticas de un simbolo, con mas un un arbol en la lista.
         *
         */

        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        for(int i = 4; i>0; i-- )
        {
            acotada = l.getUltimos(i);
            try{
                
                m =  root.derivar(new Ficha(Ficha.Simbolo.S), ReglaGramatical._1_S_E,acotada);
               
                Assert.assertTrue(m.getUltimo().getFicha().getSimbolo()==Ficha.Simbolo.S);
                
            }catch(IllegalArgumentException e)
            {
                Assert.fail();
            }
            
        }
       
       
//        /**
//         * Para gramaticas de un simbolo, si el simbolo no esta contenido genera una expcion.
//         * Independiente a los demas arboles.
//         *
//         */
        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        
        for(int i = 4; i>0; i-- )
        {
            acotada = l.getUltimos(i);
            try{

                m =  root.derivar(new Ficha(Ficha.Simbolo.S), ReglaGramatical._1_S_E,acotada);
                Assert.fail();
            }catch(IllegalArgumentException e)
            {}
            
        }
//
//        
//        
//
//        //        _2_E_E_T,
//        //        _3_E_E__T,
//        //        _5_T_T_F,
//        //        _6_T_T__F,
//        //        _8_F_F_M,
//        
//        //        _11_M__E_,
//        
//      
        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MAS));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        for(int i = 4; i>2; i-- )
        {
            acotada = l.getUltimos(i);
            try{
                
                m =  root.derivar(new Ficha(Ficha.Simbolo.E), ReglaGramatical._2_E_E_T,acotada);
                if (i==4)
                    Assert.assertTrue(m.getLongitud()==2);
                if(i==3)
                    Assert.assertTrue(m.getLongitud()==1);
                
                Assert.assertTrue(m.getUltimo().getFicha().getSimbolo()==Ficha.Simbolo.E);
                
            }catch(IllegalArgumentException e)
            {
                Assert.fail();
            }
            
        }
//
//        
        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        for(int i = 4; i>0; i-- )
        {
            acotada = l.getUltimos(i);
            try{
                
                m =  root.derivar(new Ficha(Ficha.Simbolo.E), ReglaGramatical._2_E_E_T,acotada);
                //                Assert.assertTrue(m.getLongitud()==i);
                //                Assert.assertTrue(m.getUltimo().getFicha().getSimbolo()==Ficha.Simbolo.E);
                
                Assert.fail();
                
            }catch(IllegalArgumentException e)
            {
            }
            
        }
//
//        
//        //        _12_M__E,
//        
        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MENOS));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        for(int i = 4; i>1; i-- )
        {
            acotada = l.getUltimos(i);
            try{
                
                m =  root.derivar(new Ficha(Ficha.Simbolo.M), ReglaGramatical._12_M__E,acotada);

                    Assert.assertTrue(m.getLongitud()==(i-1));
                Assert.assertTrue(m.getUltimo().getFicha().getSimbolo()==Ficha.Simbolo.M);
                
            }catch(IllegalArgumentException e)
            {
                Assert.fail();
            }
            
        }
//
        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        for(int i = 4; i>0; i-- )
        {
            acotada = l.getUltimos(i);
            try{
                
                m =  root.derivar(new Ficha(Ficha.Simbolo.E), ReglaGramatical._12_M__E,acotada);
                //                Assert.assertTrue(m.getLongitud()==i);
                //                Assert.assertTrue(m.getUltimo().getFicha().getSimbolo()==Ficha.Simbolo.E);
                
                Assert.fail();
                
            }catch(IllegalArgumentException e)
            {
            }
            
        }
//
//        
//        //        _10_M_Y_E_,
        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.Y));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_I));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_D));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        
            acotada = l.getUltimos(4);
            try{
                
                m =  root.derivar(new Ficha(Ficha.Simbolo.M), ReglaGramatical._10_M_Y_E_,acotada);
                Assert.assertTrue(m.getLongitud()==1);
                Assert.assertTrue(m.getUltimo().getFicha().getSimbolo()==Ficha.Simbolo.M);
                
            }catch(IllegalArgumentException e)
            {
                Assert.fail();
            }
//
//        
        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        for(int i = 4; i>0; i-- )
        {
            acotada = l.getUltimos(i);
            try{
                
                m =  root.derivar(new Ficha(Ficha.Simbolo.M), ReglaGramatical._10_M_Y_E_,acotada);
                //                Assert.assertTrue(m.getLongitud()==i);
                //                Assert.assertTrue(m.getUltimo().getFicha().getSimbolo()==Ficha.Simbolo.E);
                
                Assert.fail();
                
            }catch(IllegalArgumentException e)
            {
            }
            
        }
//
        
    }
    
    
    
    /**
     * Prueba unitaria para {@link ArbolSintactico#reducir}.
     */
    @Test public void testReducir() {
        
        
        ArbolSintactico<Ficha> root = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.S),ReglaGramatical.__none);
        
        Lista<ArbolSintactico<Ficha>> l;
                ArbolSintactico<Ficha> _0;
        ArbolSintactico<Ficha> _1;
        ArbolSintactico<Ficha> _2;
        ArbolSintactico<Ficha> _3;
        ArbolSintactico<Ficha> _4;
        Lista<ArbolSintactico<Ficha>> m; //Lista con los elementos pero diferentes referencias.
    
        Lista<ArbolSintactico<Ficha>> acotada;//Lista original simplemente acotada.
        Lista<ArbolSintactico<Ficha>> reducida;//Tendria que ser igual a la acotada.
        
        
        ArbolSintactico<Ficha> arbolParaReducir;

        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()),ReglaGramatical.__none);
        reducida =  _1.reducir();
        Assert.assertTrue(reducida.getLongitud()==0);
//
//
//        
        l= new Lista<ArbolSintactico<Ficha>>();
        
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        
        m= new Lista<ArbolSintactico<Ficha>>();
        m.agregaFinal(_1);
        m.agregaFinal(_2);
        m.agregaFinal(_3);
        m.agregaFinal(_4);
        
        acotada = m.getUltimos(1);
        root.derivar(new Ficha(Ficha.Simbolo.S), ReglaGramatical._1_S_E, l);
        arbolParaReducir = l.getUltimo();
        reducida = arbolParaReducir.reducir();
        Assert.assertTrue(reducida.equals(acotada));

        




        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MAS));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MAS));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
        m= new Lista<ArbolSintactico<Ficha>>();
        m.agregaFinal(_1);
        m.agregaFinal(_2);
        m.agregaFinal(_3);
        m.agregaFinal(_4);
        
        acotada = m.getUltimos(3);
        root.derivar(new Ficha(Ficha.Simbolo.E), ReglaGramatical._2_E_E_T,l);
        
        arbolParaReducir = l.getUltimo();
        reducida = arbolParaReducir.reducir();
        Assert.assertTrue(acotada.equals(reducida));

        
        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MENOS));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        
        
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MENOS));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
        m= new Lista<ArbolSintactico<Ficha>>();
        m.agregaFinal(_1);
        m.agregaFinal(_2);
        m.agregaFinal(_3);
        m.agregaFinal(_4);
        
        acotada = m.getUltimos(3);
        root.derivar(new Ficha(Ficha.Simbolo.E), ReglaGramatical._3_E_E__T,l);
        arbolParaReducir = l.getUltimo();
        reducida = arbolParaReducir.reducir();
        Assert.assertTrue(acotada.equals(reducida));

        
        
        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
        m= new Lista<ArbolSintactico<Ficha>>();
        m.agregaFinal(_1);
        m.agregaFinal(_2);
        m.agregaFinal(_3);
        m.agregaFinal(_4);
        acotada = m.getUltimos(1);
         root.derivar(new Ficha(Ficha.Simbolo.E), ReglaGramatical._4_E_T,l);
        arbolParaReducir =l.getUltimo();
        reducida = arbolParaReducir.reducir();
        Assert.assertTrue(acotada.equals(reducida));
//
//        /**********************************************************************/
//        
        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MULT));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.F));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MULT));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.F));
        m= new Lista<ArbolSintactico<Ficha>>();
        m.agregaFinal(_1);
        m.agregaFinal(_2);
        m.agregaFinal(_3);
        m.agregaFinal(_4);
        acotada = m.getUltimos(3);
        root.derivar(new Ficha(Ficha.Simbolo.T), ReglaGramatical._5_T_T_F,l);

        
        arbolParaReducir = l.getUltimo();
        
        reducida = arbolParaReducir.reducir();
        
        Assert.assertTrue(acotada.equals(reducida));

        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.DIV));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.F));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.DIV));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.F));
        m= new Lista<ArbolSintactico<Ficha>>();
        m.agregaFinal(_1);
        m.agregaFinal(_2);
        m.agregaFinal(_3);
        m.agregaFinal(_4);
        acotada = m.getUltimos(3);
         root.derivar(new Ficha(Ficha.Simbolo.T), ReglaGramatical._6_T_T__F,l);
        arbolParaReducir = l.getUltimo();
        reducida = arbolParaReducir.reducir();
        Assert.assertTrue(acotada.equals(reducida));

        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.F));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.F));
        m= new Lista<ArbolSintactico<Ficha>>();
        m.agregaFinal(_1);
        m.agregaFinal(_2);
        m.agregaFinal(_3);
        m.agregaFinal(_4);
        acotada = m.getUltimos(1);
        root.derivar(new Ficha(Ficha.Simbolo.T), ReglaGramatical._7_T_F,l);
        arbolParaReducir = l.getUltimo();
        reducida = arbolParaReducir.reducir();
        Assert.assertTrue(acotada.equals(reducida));

        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.F));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.EXPO));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.M));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.F));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.EXPO));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.M));
        m= new Lista<ArbolSintactico<Ficha>>();
        m.agregaFinal(_1);
        m.agregaFinal(_2);
        m.agregaFinal(_3);
        m.agregaFinal(_4);
        acotada = m.getUltimos(3);
          root.derivar(new Ficha(Ficha.Simbolo.F), ReglaGramatical._8_F_F_M,l);
        arbolParaReducir = l.getUltimo();
        reducida = arbolParaReducir.reducir();
        Assert.assertTrue(acotada.equals(reducida));

        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.M));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.M));
        m= new Lista<ArbolSintactico<Ficha>>();
        m.agregaFinal(_1);
        m.agregaFinal(_2);
        m.agregaFinal(_3);
        m.agregaFinal(_4);
        acotada = l.getUltimos(1);
        root.derivar(new Ficha(Ficha.Simbolo.F), ReglaGramatical._9_F_M,l);
        arbolParaReducir = l.getUltimo();
        reducida = arbolParaReducir.reducir();
        Assert.assertTrue(acotada.equals(reducida));

//
        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.Y));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_I));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_D));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        
        _1 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.Y));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_I));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_D));
        m= new Lista<ArbolSintactico<Ficha>>();
        m.agregaFinal(_1);
        m.agregaFinal(_2);
        m.agregaFinal(_3);
        m.agregaFinal(_4);
        acotada = m.getUltimos(4);

        root.derivar(new Ficha(Ficha.Simbolo.M), ReglaGramatical._10_M_Y_E_,l);
        

        arbolParaReducir = l.getUltimo();
        reducida = arbolParaReducir.reducir();

        Assert.assertTrue(acotada.equals(reducida));
////
        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_I));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_D));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_I));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_D));
        m= new Lista<ArbolSintactico<Ficha>>();
        m.agregaFinal(_1);
        m.agregaFinal(_2);
        m.agregaFinal(_3);
        m.agregaFinal(_4);
        acotada = m.getUltimos(3);
        root.derivar(new Ficha(Ficha.Simbolo.M), ReglaGramatical._11_M__E_,l);
        arbolParaReducir = l.getUltimo();
        reducida = arbolParaReducir.reducir();
        Assert.assertTrue(acotada.equals(reducida));

        l= new Lista<ArbolSintactico<Ficha>>();
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MENOS));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        l.agregaFinal(_1);
        l.agregaFinal(_2);
        l.agregaFinal(_3);
        l.agregaFinal(_4);
        
        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MENOS));
        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
        m= new Lista<ArbolSintactico<Ficha>>();
        m.agregaFinal(_1);
        m.agregaFinal(_2);
        m.agregaFinal(_3);
        m.agregaFinal(_4);
        acotada = m.getUltimos(2);
         root.derivar(new Ficha(Ficha.Simbolo.M), ReglaGramatical._12_M__E,l);
        arbolParaReducir = l.getUltimo();
        reducida = arbolParaReducir.reducir();
        Assert.assertTrue(acotada.equals(reducida));

        
//
        

    }
   
    
    /**
     * Prueba unitaria para {@link ArbolSintactico#evaluar}.
     */
    @Test public void testEvaluar() {
        
        
        Lista<ArbolSintactico<Ficha>> a;
        Pila<ArbolSintactico<Ficha>> b;
        ArbolRetroceso<Gramatica> t;
        Lista<Ficha> f;
        ArbolSintactico<Ficha> tree;
        
        //SE TIENE QUE METER COMO DOUBLE DE OTRA MANERA SE GENERAN ERRORES.
        double test = random.nextInt(100);
        
        f = AnalizadorLexico.analizar("5");
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        aSint.analizar(a,AnalizadorLexico.convertir(f),t);
        tree = a.getUltimo();
        Assert.assertTrue(tree.evaluar(0)==5);

//        
        f = AnalizadorLexico.analizar("x");
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        aSint.analizar(a,AnalizadorLexico.convertir(f),t);
        tree = a.getUltimo();
        
        Assert.assertTrue(test== tree.evaluar(test));
        
//        
        f = AnalizadorLexico.analizar("-x");
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        aSint.analizar(a,AnalizadorLexico.convertir(f),t);
        tree = a.getUltimo();
        
        Assert.assertTrue(-test== tree.evaluar(test));
        
//        
        f = AnalizadorLexico.analizar("x+10");
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        aSint.analizar(a,AnalizadorLexico.convertir(f),t);
        tree = a.getUltimo();
        
        Assert.assertTrue(test+10== tree.evaluar(test));
        
        f = AnalizadorLexico.analizar("x*10");
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        aSint.analizar(a,AnalizadorLexico.convertir(f),t);
        tree = a.getUltimo();
        
        Assert.assertTrue(test*10== tree.evaluar(test));
        
        
        
        f = AnalizadorLexico.analizar("x/11");
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();

        aSint.analizar(a,AnalizadorLexico.convertir(f),t);
        tree = a.getUltimo();
            Assert.assertTrue((test/11)== tree.evaluar(test));
        
        
        
        f = AnalizadorLexico.analizar("11/x");
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        aSint.analizar(a,AnalizadorLexico.convertir(f),t);
        tree = a.getUltimo();
        try{
            tree.evaluar(0);
            Assert.fail();
        }catch(IllegalArgumentException e){
            
        }
//
        f = AnalizadorLexico.analizar("2^2");
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        aSint.analizar(a,AnalizadorLexico.convertir(f),t);
        tree = a.getUltimo();
        Assert.assertTrue((Math.pow(2,2))== tree.evaluar(0));
        
//        
        f = AnalizadorLexico.analizar("2^x");
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        aSint.analizar(a,AnalizadorLexico.convertir(f),t);
        tree = a.getUltimo();
        Assert.assertTrue((Math.pow(2,test))== tree.evaluar(test));
        //
        f = AnalizadorLexico.analizar("x^x");
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        aSint.analizar(a,AnalizadorLexico.convertir(f),t);
        tree = a.getUltimo();
        Assert.assertTrue((Math.pow(test,test))== tree.evaluar(test));
        
        

        

        

        f = AnalizadorLexico.analizar("5*x");
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        aSint.analizar(a,AnalizadorLexico.convertir(f),t);
        tree = a.getUltimo();
        
        for(int i = -100 ;i<100; i++  )
            Assert.assertTrue((5.0 *i) == tree.evaluar(i));

        
//
//        
        f = AnalizadorLexico.analizar("1/x");
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        aSint.analizar(a,AnalizadorLexico.convertir(f),t);
        tree = a.getUltimo();
        
        for(double i = -100.0 ;i<100; i++  )
        {
            if(i==0.0)
            {
                try{
                    tree.evaluar(i);
                    Assert.fail();
                    
                }catch(IllegalArgumentException e){
                }
                
                
            }
            else
            {
                Assert.assertTrue( 1.0/i == tree.evaluar(i));
            }
        }
//
        f = AnalizadorLexico.analizar("sqrt(x)");
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        aSint.analizar(a,AnalizadorLexico.convertir(f),t);
        tree = a.getUltimo();
        
        for(double i = -100 ;i<100; i++  )
        {
            if(i<0)
            {
                try{
                    tree.evaluar(i);
                    Assert.fail();
                }catch(IllegalArgumentException e){}
                
            }
            else
            {
                Assert.assertTrue( (Math.sqrt(i)) == tree.evaluar(i));
            }
        }
//
//        
        f = AnalizadorLexico.analizar("x*(x+2)");
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        aSint.analizar(a,AnalizadorLexico.convertir(f),t);
        tree = a.getUltimo();
        

        Lista<Ficha> f_ = AnalizadorLexico.analizar("x^2+2*x");

        Lista<ArbolSintactico<Ficha>> a_= new Lista<ArbolSintactico<Ficha>> ();
        ArbolRetroceso<Gramatica> t_ = new ArbolRetroceso<Gramatica>();
        aSint.analizar(a_,AnalizadorLexico.convertir(f_),t_);
        ArbolSintactico<Ficha> tree_ = a.getUltimo();
        
        for(int i = -100 ;i<100; i++  ){
            Assert.assertTrue(i*(i+2)   == tree.evaluar(i) );
            Assert.assertTrue(tree_.evaluar(i) == tree.evaluar(i));
        }
        
        

    }
    
    
}
