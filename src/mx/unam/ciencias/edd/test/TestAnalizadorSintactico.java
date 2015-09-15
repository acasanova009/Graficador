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
    
    private ArbolSintactico<Ficha> setArbol(){
        return null;
    }
    
}
