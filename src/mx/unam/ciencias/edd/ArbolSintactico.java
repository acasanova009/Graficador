package mx.unam.ciencias.edd;

import java.util.Iterator;
import java.util.NoSuchElementException;
import java.lang.IllegalArgumentException;
import mx.unam.ciencias.edd.Gramatica.ReglaGramatical;
/**
 * <p>Clase para árboles sintacticos.</p>

 * <p>Un arbol sintactico contiene fichas en sus vertices. Las cuales son creadas a partir de una
 * lista de reglas gramaticales.
 * <p>
 */
public class ArbolSintactico<T extends Ficha> extends ArbolBinario<T> {
    
    /*Regla gramatical con la cual el arbol fue creado.*/
    private ReglaGramatical reglaGramatical;

    /**
     * Constructor sin parámetros. Sencillamente ejecuta el
     * constructor sin parámetros de {@link ArbolBinario}.
     */
    public ArbolSintactico(T ficha) {
        super();
        reglaGramatical = ReglaGramatical.__none;
        raiz.elemento = ficha;
        
    }
    
    /**
     * Consructor de arbol sintactico. 
     * @param ficha La ficha que reprensta al inicio del arbol.
     * @param r La regla Gramatical que nos permite saber como se comonen sus vertices hijos.
     * @param l Lista de contiene a sus futuros Hijos.
     */
    public ArbolSintactico(T ficha, ReglaGramatical r, Lista<ArbolSintactico<Ficha>> l) {
        super();
        reglaGramatical = r;
        raiz.elemento = ficha;
        
        //Agregar al vertice raiz, dependiendo de el tipo de gramatica en sus respectivos
        //derecha e izquerda vertices.
        
        
    }
    /** Este metodo permite recuperar en sentido inverso a los hijos de nuestra raiz.
     * Nos regresa una lista de sus hijos.
     * En los casos de la gramatica con parentesis
     * ReglaGramatical._10_M_Y_E_
     * ReglaGramatical._11_M__E_
     * se agregaran los parentesis.
     
     * Y en los casos de por ejemplo ReglaGramatical._3_E_E__T, se bajaran 2 niveles. para Una
     * exitosa reduccion.
     *@return Lista con los hijos de este arbol sintactico.
     */
    
    public Lista<ArbolSintactico<Ficha>> reducir(){
        return null;
    };
    
    /** Este metodo no hace nada, por el comportamiento de este tipo de arboles.
     */
    @Override public VerticeArbolBinario<T> agrega(T elemento) {
        
        return null;
    }
    
    /** Este metodo no hace nada, por el comportamiento de este tipo de arboles.
     */
    @Override public void elimina(T elemento) {}
    


   /** Este metodo no hace nada, por el comportamiento de este tipo de arboles.  */
    @Override public Iterator<T> iterator() { return null;}

    
    /**
     * Metodo que nos permite evaular este arbol en un valor x.
     * @param x valor de la rectas sobre el eje x.
     * @return valor de la funcion. Valor y.
     */
     public double evaluar(double x){
//        if (x==0)
//            throw new IllegalArgumentException("divisor is 0");
        return 0;
        
    }
    
}
