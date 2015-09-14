package mx.unam.ciencias.edd;

import java.util.Iterator;
import java.lang.IllegalArgumentException;
import mx.unam.ciencias.edd.Gramatica;
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

   
    //Valor del Simbolo.
    public T getFicha(){
        return raiz.elemento;
    }
    
    /**
     * Constructor de arboles de una sola ficha.
     * Sin regla gramatical.
     */
    public ArbolSintactico(T ficha) {
        super();
        reglaGramatical = ReglaGramatical.__none;
        raiz = new Vertice<T>(ficha);
        
        
    }
    
    /**
     * Constructor de arboles con su ficha y regla Gramatical.
     * Este se agregara al final a la lista.
     * @param ficha La ficha que reprensta al inicio del arbol.
     * @param r La regla Gramatical que nos permite saber como se componen sus vertices hijos.
     */
    
    public ArbolSintactico(T ficha, ReglaGramatical r)    {
        
        

        
    }
    
    /**
     * -- Por incompatibilidad de tipo T con el metodo ser estatico, se dejo como metodo no-estatico.
     * Derivador de arboles. Dada una lista con n arboles, con 0<n<5. Y una regla gramatical.
     * Con respecto a la regla gramatical tomara todos los arboles que su puedan derivar. Y Regresara una lista con unicamente los arboles que sobraron y el nuevo arbol productor como ultimo elemento
     * Este se agregara al final a la lista.
     * @param ficha La ficha que reprensta al inicio del arbol.
     * @param r La regla Gramatical que nos permite saber como se comonen sus vertices hijos.
     * @param l Lista de contiene a sus futuros Hijos.
     * @throws  IllegalArgumentException Si la gramatica con coincide con los elementos dentro de mi lista.
        o si la lista tienes menos elementos de los esperados por la gramatica.
     */
    
    public Lista<ArbolSintactico<T>> derivar(T ficha, ReglaGramatical r, Lista<ArbolSintactico<T>> l)
    {
        
        
        return null;
    }
    
    /**
     
     * Constructor - Derivador de arboles. Dada una lista con n arboles, con 0<n<5. Y una regla gramatical.
     * Con respecto a la regla gramatical tomara todos los arboles que su puedan derivar. Y Regresara una lista con unicamente los arboles que sobraron y el nuevo arbol productor como ultimo elemento
     * Este se agregara al final a la lista.
     * @param ficha La ficha que reprensta al inicio del arbol.
     * @param r La regla Gramatical que nos permite saber como se comonen sus vertices hijos.
     * @param l Lista de contiene a sus futuros Hijos.
     * @throws  IllegalArgumentException Si no se corroboro con anteriorioridad si era una gramatica valida.
     * @deprecated Uso no recomendado.
     */
    public ArbolSintactico(T ficha, ReglaGramatical r, Lista<ArbolSintactico<T>> l) throws IllegalArgumentException{
        super();
        
    }
    /** Este metodo permite recuperar en sentido inverso a los hijos de nuestra raiz.
     * Nos regresa una lista de sus hijos.
     * En los casos de la gramatica con parentesis
     * ReglaGramatical._10_M_Y_E_
     * ReglaGramatical._11_M__E_
     * Y las gramaticas con simbolo, se agregaran.
     * se agregaran los parentesis.
     
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
     public double evaluar(double x)throws IllegalArgumentException,AxiomaticSimbolException {
//        if (x==0)
//            throw new IllegalArgumentException("divisor is 0");
        return 0;
        
    }
    public ReglaGramatical getReglaGramatical()
    {
        return reglaGramatical;
    }
    
}
