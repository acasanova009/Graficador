package mx.unam.ciencias.edd;

import java.util.Iterator;
import java.util.NoSuchElementException;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.OutputStreamWriter;
import java.io.InputStreamReader;
import java.io.BufferedWriter;
import java.io.BufferedReader;
import java.io.IOException;

/**
 *
 *
 *
 */
public class AnalizadorSintactico{

    
    public static boolean esGramaticaValida(String s){
        
        return false;
    }

    public static ArbolSintactico generarArbolConFichas(Lista<Ficha> fichas)
    {
        //En la pila t tendremos la derivacion del arbol final del arbol de ser que las fichas sean una gramatica sintacticamente valida. Y la usaremos para crear el arbol sintactico.
        //Usaremos una "a" donde estaran las fichas a las que le aplicaremos las reducciones.
        //Usaremos la cola "b", de la cual unicamente agregaremos y quitaremos elementos.
        
        //this.analizar(a,b,t);
        
        return new ArbolSintactico();
    }
    
    
    private static boolean analizar(Lista<Ficha> a, Cola<Ficha> b, Pila<Integer> t){
        
        //Por cada derivacion de fichas de las 16 derivaciones que tenemos en esta gramatica, le intentaremos aplicar la regla "d" a las ultimas 4 fichas de la lista "a". 4, ya que nuestra derivacion mas grande contiene 4 tokens.
            //Si la lista "a", es reducible con d.
                    //Se la aplicaremos.
                //En nuestra pila "t", guardaremos el indice de la reduccion que le aplicamos.
                //Si la lista "a", es el axioma inicial, y la cola b esta vacia.
                    //La derivacion fue exitosa.
                //De otra manera analizaremos con respecto a la nueva reduccion de a.
        //Si ninguna produccion es aplicable.
            //Si podemos desplazar. b!=vacio
                //Desplazaremos una ficha de "b" a "a".
                //Intentaremos analizar nuevamente.
        //Tenemos que retroceder sobre sobre t.
            //Por cada produccion p en t. La aplicaremos p a "a", y quitaremos p de t
             //Regresamos todos los simbolos finales.
             //Hasta encontrar un simbolo no-terminal.
            //Si se puede le aplico una derivacion no usada anteriormente.
                
        
        
        
        return false;
        
        
        
    }

}
