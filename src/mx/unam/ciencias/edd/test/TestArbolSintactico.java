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

    private ArbolSintactico<Ficha> arbol;
    private Ficha.Simbolo[] simbolos;
    private static final int cantidadDeSimbolos = 17;//LOS SIMBOLOS DE LAS FICHAS..
    
    /**
     */
    public TestArbolSintactico() {
        random = new Random();
//        arbol = setArbol(); //22+33*x
        simbolos = new Ficha.Simbolo[cantidadDeSimbolos];
        setSimbolos();
        
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
//
//        
//        
//        ArbolSintactico<Ficha> root = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.S),ReglaGramatical.__none);
//        Lista<ArbolSintactico<Ficha>> l;
//        ArbolSintactico<Ficha> _1;
//        ArbolSintactico<Ficha> _2;
//        ArbolSintactico<Ficha> _3;
//        ArbolSintactico<Ficha> _4;
//        ArbolSintactico<Ficha> _5;
//    ArbolSintactico<Ficha> _6;
//    
//        Lista<ArbolSintactico<Ficha>> m; //Lista despues de la derivacion
//        Lista<ArbolSintactico<Ficha>> acotada;//Lista original simplemente acotada.
//        
//        
//        
//        m= new Lista<ArbolSintactico<Ficha>>();
//                acotada = new Lista<ArbolSintactico<Ficha>>();
//        _1 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.REAL,ReglaGramatical.__none,"12"));
//        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.Q));
//        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.M));
//        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.F));
//        _5 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
//        _5 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
//        m.agregaFinal(_1);
//        root.derivar(new Ficha(Ficha.Simbolo.Q), ReglaGramatical._15_Q_num,m );
//        root.derivar(new Ficha(Ficha.Simbolo.M), ReglaGramatical._13_M_Q, m );
//        root.derivar(new Ficha(Ficha.Simbolo.F), ReglaGramatical._9_F_M,m );
//        root.derivar(new Ficha(Ficha.Simbolo.T), ReglaGramatical._7_T_F,m );
//        root.derivar(new Ficha(Ficha.Simbolo.E), ReglaGramatical._4_E_T,m );
//
//        acotada = m.getUltimo().reducir();
//        acotada = acotada.getUltimo().reducir();
//        acotada = acotada.getUltimo().reducir();
//        acotada = acotada.getUltimo().reducir();
//        acotada = acotada.getUltimo().reducir();
//        
//        ArbolSintactico<Ficha> again = acotada.getUltimo();
//        Assert.assertTrue(again.getFicha().getValor().equals("12"));
//
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        
//        //         _1_S_E,
//        //        _4_E_T,
//        //        _7_T_F,
//        //        _9_F_M,
//        //        _13_M_Q,
//        //        _14_Y_func,
//        //        _15_Q_num,
//        //        _16_Q_var,
//        
//        /**
//         * Para gramaticas de un simbolo, con mas un un arbol en la lista.
//         *
//         */
//
//        l= new Lista<ArbolSintactico<Ficha>>();
//        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
//        l.agregaFinal(_1);
//        l.agregaFinal(_2);
//        l.agregaFinal(_3);
//        l.agregaFinal(_4);
//        for(int i = 4; i>0; i-- )
//        {
//            acotada = l.getUltimos(i);
//            try{
//                
//                m =  root.derivar(new Ficha(Ficha.Simbolo.S), ReglaGramatical._1_S_E,acotada);
//               
//                Assert.assertTrue(m.getUltimo().getFicha().getSimbolo()==Ficha.Simbolo.S);
//                
//            }catch(IllegalArgumentException e)
//            {
//                Assert.fail();
//            }
//            
//        }
//       
//       
////        /**
////         * Para gramaticas de un simbolo, si el simbolo no esta contenido genera una expcion.
////         * Independiente a los demas arboles.
////         *
////         */
//        l= new Lista<ArbolSintactico<Ficha>>();
//        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
//        l.agregaFinal(_1);
//        l.agregaFinal(_2);
//        l.agregaFinal(_3);
//        l.agregaFinal(_4);
//        
//        for(int i = 4; i>0; i-- )
//        {
//            acotada = l.getUltimos(i);
//            try{
//
//                m =  root.derivar(new Ficha(Ficha.Simbolo.S), ReglaGramatical._1_S_E,acotada);
//                Assert.fail();
//            }catch(IllegalArgumentException e)
//            {}
//            
//        }
////
////        
////        
////
////        //        _2_E_E_T,
////        //        _3_E_E__T,
////        //        _5_T_T_F,
////        //        _6_T_T__F,
////        //        _8_F_F_M,
////        
////        //        _11_M__E_,
////        
////      
//        l= new Lista<ArbolSintactico<Ficha>>();
//        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
//        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MAS));
//        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.T));
//        l.agregaFinal(_1);
//        l.agregaFinal(_2);
//        l.agregaFinal(_3);
//        l.agregaFinal(_4);
//        for(int i = 4; i>2; i-- )
//        {
//            acotada = l.getUltimos(i);
//            try{
//                
//                m =  root.derivar(new Ficha(Ficha.Simbolo.E), ReglaGramatical._2_E_E_T,acotada);
//                if (i==4)
//                    Assert.assertTrue(m.getLongitud()==2);
//                if(i==3)
//                    Assert.assertTrue(m.getLongitud()==1);
//                
//                Assert.assertTrue(m.getUltimo().getFicha().getSimbolo()==Ficha.Simbolo.E);
//                
//            }catch(IllegalArgumentException e)
//            {
//                Assert.fail();
//            }
//            
//        }
////
////        
//        l= new Lista<ArbolSintactico<Ficha>>();
//        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _4 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        l.agregaFinal(_1);
//        l.agregaFinal(_2);
//        l.agregaFinal(_3);
//        l.agregaFinal(_4);
//        for(int i = 4; i>0; i-- )
//        {
//            acotada = l.getUltimos(i);
//            try{
//                
//                m =  root.derivar(new Ficha(Ficha.Simbolo.E), ReglaGramatical._2_E_E_T,acotada);
//                //                Assert.assertTrue(m.getLongitud()==i);
//                //                Assert.assertTrue(m.getUltimo().getFicha().getSimbolo()==Ficha.Simbolo.E);
//                
//                Assert.fail();
//                
//            }catch(IllegalArgumentException e)
//            {
//            }
//            
//        }
////
////        
////        //        _12_M__E,
////        
//        l= new Lista<ArbolSintactico<Ficha>>();
//        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MENOS));
//        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
//        l.agregaFinal(_1);
//        l.agregaFinal(_2);
//        l.agregaFinal(_3);
//        l.agregaFinal(_4);
//        for(int i = 4; i>1; i-- )
//        {
//            acotada = l.getUltimos(i);
//            try{
//                
//                m =  root.derivar(new Ficha(Ficha.Simbolo.M), ReglaGramatical._12_M__E,acotada);
//
//                    Assert.assertTrue(m.getLongitud()==(i-1));
//                Assert.assertTrue(m.getUltimo().getFicha().getSimbolo()==Ficha.Simbolo.M);
//                
//            }catch(IllegalArgumentException e)
//            {
//                Assert.fail();
//            }
//            
//        }
////
//        l= new Lista<ArbolSintactico<Ficha>>();
//        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _4 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        l.agregaFinal(_1);
//        l.agregaFinal(_2);
//        l.agregaFinal(_3);
//        l.agregaFinal(_4);
//        for(int i = 4; i>0; i-- )
//        {
//            acotada = l.getUltimos(i);
//            try{
//                
//                m =  root.derivar(new Ficha(Ficha.Simbolo.E), ReglaGramatical._12_M__E,acotada);
//                //                Assert.assertTrue(m.getLongitud()==i);
//                //                Assert.assertTrue(m.getUltimo().getFicha().getSimbolo()==Ficha.Simbolo.E);
//                
//                Assert.fail();
//                
//            }catch(IllegalArgumentException e)
//            {
//            }
//            
//        }
////
////        
////        //        _10_M_Y_E_,
//        l= new Lista<ArbolSintactico<Ficha>>();
//        _1 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.Y));
//        _2 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_I));
//        _3 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.E));
//        _4 = new  ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_D));
//        l.agregaFinal(_1);
//        l.agregaFinal(_2);
//        l.agregaFinal(_3);
//        l.agregaFinal(_4);
//        
//            acotada = l.getUltimos(4);
//            try{
//                
//                m =  root.derivar(new Ficha(Ficha.Simbolo.M), ReglaGramatical._10_M_Y_E_,acotada);
//                Assert.assertTrue(m.getLongitud()==1);
//                Assert.assertTrue(m.getUltimo().getFicha().getSimbolo()==Ficha.Simbolo.M);
//                
//            }catch(IllegalArgumentException e)
//            {
//                Assert.fail();
//            }
////
////        
//        l= new Lista<ArbolSintactico<Ficha>>();
//        _1 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _2 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _3 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        _4 = new  ArbolSintactico<Ficha>(new Ficha(randomSimbol()));
//        l.agregaFinal(_1);
//        l.agregaFinal(_2);
//        l.agregaFinal(_3);
//        l.agregaFinal(_4);
//        for(int i = 4; i>0; i-- )
//        {
//            acotada = l.getUltimos(i);
//            try{
//                
//                m =  root.derivar(new Ficha(Ficha.Simbolo.M), ReglaGramatical._10_M_Y_E_,acotada);
//                //                Assert.assertTrue(m.getLongitud()==i);
//                //                Assert.assertTrue(m.getUltimo().getFicha().getSimbolo()==Ficha.Simbolo.E);
//                
//                Assert.fail();
//                
//            }catch(IllegalArgumentException e)
//            {
//            }
//            
//        }
////
//        
    }
    
//    private ArbolSintactico<Ficha> setArbol()
//    {
//        //ARBOL DE EXPECTATIVA. 22+33*x
//        
//        ArbolSintactico<Ficha> izq = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.REAL,"22.0"));
//        ArbolSintactico<Ficha> mid = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.REAL,"33.0"));
//        ArbolSintactico<Ficha> der = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.VAR,"x"));
//        //Setting der
//        
//        Ficha f;
//        Lista<ArbolSintactico<Ficha>> l;
//        f = new Ficha(Ficha.Simbolo.Q);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(der);
//        
//        der = new ArbolSintactico<Ficha>(f,ReglaGramatical._16_Q_var,l);
//        
//        
//        f = new Ficha(Ficha.Simbolo.M);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(der);
//        der = new ArbolSintactico<Ficha>(f,ReglaGramatical._13_M_Q,l);
//        
//        
//        f = new Ficha(Ficha.Simbolo.F);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(der);
//        der = new ArbolSintactico<Ficha>(f,ReglaGramatical._9_F_M,l);
//        //Setting mid.
//        
//        f = new Ficha(Ficha.Simbolo.Q);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(mid);
//        mid = new ArbolSintactico<Ficha>(f,ReglaGramatical._15_Q_num,l);
//        
//        f = new Ficha(Ficha.Simbolo.M);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(mid);
//        mid = new ArbolSintactico<Ficha>(f,ReglaGramatical._13_M_Q,l);
//        
//        
//        f = new Ficha(Ficha.Simbolo.F);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(mid);
//        mid = new ArbolSintactico<Ficha>(f,ReglaGramatical._9_F_M,l);
//        
//        
//        f = new Ficha(Ficha.Simbolo.T);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(mid);
//        mid = new ArbolSintactico<Ficha>(f,ReglaGramatical._7_T_F,l);
//        
//        
//        // Setting mid and der.
//        f = new Ficha(Ficha.Simbolo.T);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        ArbolSintactico<Ficha> mult = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MULT));
//        l.agregaFinal(mid);
//        l.agregaFinal(mult);
//        l.agregaFinal(der);
//        der = new ArbolSintactico<Ficha>(f,ReglaGramatical._5_T_T_F,l);
//        
//        //Setting izq.
//        
//        
//        f = new Ficha(Ficha.Simbolo.Q);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(izq);
//        izq = new ArbolSintactico<Ficha>(f,ReglaGramatical._15_Q_num,l);
//        
//        f = new Ficha(Ficha.Simbolo.M);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(izq);
//        izq = new ArbolSintactico<Ficha>(f,ReglaGramatical._13_M_Q,l);
//        
//        
//        f = new Ficha(Ficha.Simbolo.F);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(izq);
//        izq = new ArbolSintactico<Ficha>(f,ReglaGramatical._9_F_M,l);
//        
//        
//        f = new Ficha(Ficha.Simbolo.T);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(izq);
//        izq = new ArbolSintactico<Ficha>(f,ReglaGramatical._7_T_F,l);
//        
//        f = new Ficha(Ficha.Simbolo.E);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(izq);
//        izq = new ArbolSintactico<Ficha>(f,ReglaGramatical._4_E_T,l);
//        
//        //Setting SUMA simboloContenedor de E.
//        
//        
//        f = new Ficha(Ficha.Simbolo.E);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        ArbolSintactico<Ficha> sum = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MAS));
//        l.agregaFinal(izq);
//        l.agregaFinal(sum);
//        l.agregaFinal(der);
//        izq = new ArbolSintactico<Ficha>(f,ReglaGramatical._2_E_E_T,l);
//        
//        
//        //Setting ROOT
//        
//        
//        f = new Ficha(Ficha.Simbolo.S);
//        l = new Lista<ArbolSintactico<Ficha>>();
//        l.agregaFinal(izq);
//        izq = new ArbolSintactico<Ficha>(f,ReglaGramatical._1_S_E,l);
//        
//        //Se supone izq, ya tiene todo el arbol de derivacion.....
//        
//        
//        return izq;
//    }
   
    
    
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
//    @Test public void testEvaluar() {
//        
//        
//        
//        
//        
//        //Esta prueba es la unica independiente al creador de arboles - AnalizadorSintactico.
//        for (double i = -10; i<10;i++ )
//        {
//            double x = 22+(33*i);
//            Assert.assertTrue(x== arbol.evaluar(i));
//            
//        }
//        
//        
//
//    }
    
}
