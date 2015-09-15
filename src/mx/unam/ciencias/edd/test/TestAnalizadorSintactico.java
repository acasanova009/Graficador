 package mx.unam.ciencias.edd.test;

//import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import mx.unam.ciencias.edd.ExcepcionIndiceInvalido;
import mx.unam.ciencias.edd.IteradorLista;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.AnalizadorSintactico;
import mx.unam.ciencias.edd.AnalizadorLexico;
import mx.unam.ciencias.edd.Gramatica;
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
    private AnalizadorSintactico aSint;
    
//    private AnalizadorSintactico aSin;
    
    /**
     */
    public TestAnalizadorSintactico() {
        random = new Random();
        total = 10 + random.nextInt(90);
//        arbol = setArbol();
        
        aSint = new AnalizadorSintactico();
    }
    /**
     * Prueba unitaria para {@link AnalizadorSintactico#analizar}.
     */
    @Test public void testAnalizar()
    {
        Lista<ArbolSintactico<Ficha>> a;
        Pila<ArbolSintactico<Ficha>> b;
        ArbolRetroceso<Gramatica> t;
        
        a= new Lista<ArbolSintactico<Ficha>> ();
        b = new Pila<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();

        ArbolSintactico<Ficha> _1 = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.REAL));
        ArbolSintactico<Ficha> _2 = new ArbolSintactico<Ficha>(new Ficha (Ficha.Simbolo.REAL));
        ArbolSintactico<Ficha> _3 = new ArbolSintactico<Ficha>(new Ficha (Ficha.Simbolo.REAL));
        ArbolSintactico<Ficha> _4 = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.REAL));
        ArbolSintactico<Ficha> _x = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.VAR));
        
        ArbolSintactico<Ficha> _func = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.FUNCION));
        ArbolSintactico<Ficha> _func2 = new ArbolSintactico<Ficha>(new Ficha (Ficha.Simbolo.FUNCION));
        ArbolSintactico<Ficha> _pI = new ArbolSintactico<Ficha>(new Ficha (Ficha.Simbolo.PAR_I));
        ArbolSintactico<Ficha> _pD = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.PAR_D));
        ArbolSintactico<Ficha> _x2 = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.VAR));
        
        
        ArbolSintactico<Ficha> _mas = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MAS));
        ArbolSintactico<Ficha> _menos = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MENOS));
        ArbolSintactico<Ficha> _mult = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.MULT));
        ArbolSintactico<Ficha> _div = new ArbolSintactico<Ficha>(new Ficha (Ficha.Simbolo.DIV));
        ArbolSintactico<Ficha> _expo = new ArbolSintactico<Ficha>(new Ficha (Ficha.Simbolo.EXPO));
        
        b.mete(_3);
        b.mete(_mas);
        b.mete(_x);
        b.mete(_mult);
        b.mete(_2);
        Assert.assertTrue(aSint.analizar(a,b,t));
        
        a= new Lista<ArbolSintactico<Ficha>> ();
        b = new Pila<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        b.mete(_mas);
        b.mete(_3);
        b.mete(_x);
        b.mete(_mult);
        b.mete(_2);
        Assert.assertFalse(aSint.analizar(a,b,t));
        
        a= new Lista<ArbolSintactico<Ficha>> ();
        b = new Pila<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        b.mete(_mas);
        b.mete(_3);
        b.mete(_x);
        b.mete(_mult);
        b.mete(_2);
        Assert.assertFalse(aSint.analizar(a,b,t));
        
        a= new Lista<ArbolSintactico<Ficha>> ();
        b = new Pila<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        b.mete(_pD);
        b.mete(_x);
        b.mete(_pI);
        b.mete(_func2);
        b.mete(_mas);
        b.mete(_x2);

        Assert.assertTrue(aSint.analizar(a,b,t));
        
        a= new Lista<ArbolSintactico<Ficha>> ();
        b = new Pila<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        b.mete(_func);
        b.mete(_x);
        b.mete(_pI);
        b.mete(_func2);
        
        Assert.assertFalse(aSint.analizar(a,b,t));
        
        Lista<Ficha> f = AnalizadorLexico.analizar("25+sin(sqrt(x)*x)");
//        System.out.println("Fichas: " + f);
        
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        
        Assert.assertTrue(aSint.analizar(a,AnalizadorLexico.convertir(f),t));
        
            
            
        
    }
    
}
