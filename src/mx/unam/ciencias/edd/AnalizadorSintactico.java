package mx.unam.ciencias.edd;

import java.util.Iterator;
import java.util.NoSuchElementException;
import mx.unam.ciencias.edd.Gramatica.ReglaGramatical;

/**
 * <p>El analizador sintactico permite dada una lista de fichas, verificar la sintaxis de esta lista.
 * Lo hace a partir del algoritmo de construccion ascendente con retroceso.<p>
 *
 */
public class AnalizadorSintactico{

    

   
    /* A partir de una pila de fichas b, que proviene del analizador lexico, analizaremos las
     * posibles derivaciones. Se usara el algoritmo de construccion acendente con retroceso.
     *
     * @param a Lista contenedora las derivaciones.
     * @param b Pila que contiene las fichas originales.
     * @param t ArbolRetroceso, nos permitira guardar todos los posibles caminos de reglasGramaticales,
     * aunque solo uno sea efectivo.
     * @return <tt>true</tt> las fichas de b eran sintacticamente correctas,
     *         <tt>false</tt> en otro caso.

     */
    public static boolean analizar(Lista<Ficha> a, Pila<Ficha> b, ArbolRetroceso<ReglaGramatical> t){
        
        
//        for (ReglaGramatical rG : ReglaGramatical.values()) {
//
//            
//        }
//        
        //Por cada derivacion de fichas de las 16 derivaciones, que estan en mi Gramatica, le intentaremos aplicar la regla -r a las ultimas 4-posibles fichas de la lista -a. 4, ya que nuestra derivacion mas grande contiene 4 fichas.
        
        //Por cada -r reglaGramatical
            //Si la -r, aun no se registra en -t. Y las ultimas fichas de -a, son producibles por r.
                    //Derivamos -a en -r. Y -r la registraremos en -t.
                //Si la lista -a, es el axioma inicial, y la pila -b esta vacia.
                    //La derivacion fue exitosa.
                //analizamos()
        //Si ninguna regla -r es aplicable y -b no es vacia.
                //Desplazaremos una ficha de -b a -a.
                //analizamos()
        
        //Al llegar aqui significa:
        //El camino que tomamos fue insuficiente para satisfacer la gramatica para llegar al aixoma inicial.
        //Si t tiene mas reglasGramaticales. //Podemos buscar otros caminos.
            //+De tener simbolos terminales, los regresamos a -b.
            //Para la ultima regla -r en -t. Produciremos a -r en -a, y nos moveremos sobre t uno hacia atras.
            //+De tener simbolos terminales, los regresamos a -b.
                //analizamos nuevamente.
        
        //Si t NO tiene reglas // No hay mas caminos en t por encontrar.
            //Y consideramos a esta expresion, sintacticamente incorrecta.
                //La derivacion fallo.
                
        
        
        
        return false;
        
        
        
    }
    public static ArbolSintactico generar(Lista<Ficha> fichas, Lista<ReglaGramatical> listaReglas)
    {
        
        return null;
    }

}
