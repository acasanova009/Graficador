package mx.unam.ciencias.edd;

import java.util.NoSuchElementException;
import java.lang.Math;

/**
 * <p>Un arbol retroceso permite al usuario hacer un BackTracking.
 * Lo cual significa que te permite generar caminos en busqueda de la solucion.
 * Y no te permite repetir caminos.
 */
public class ArbolRetroceso<T> {
    
    private Vertice<T> verticeActual;
    private Vertice<T> verticesRaiz;
    
    
    /**
     * Clase interna protegida para vértices.
     */
    protected class Vertice<T> {
        /** El elemento del vértice. */
        public T elemento;
        /** El padre del vértice. */
        public Vertice<T> padre;
        /** Hijos del vértice. */
        public Lista<Vertice<T>> hijos;
        
        /**
         * Constructor único que recibe un elemento.
         * @param elemento el elemento del vértice.
         */
        public Vertice(T elem) {
            //Aquí va su código.
            
            padre =  null;
            
            hijos = new Lista<Vertice<T>>();
            this.elemento = elem;
        }

        /**
         * Regresa una representación en cadena del vértice.
         * @return una representación en cadena del vértice.
         */
        public String toString() {
            
            String elem = new String();
            return elem;
        }
//
        /**
         * Nos dice si el vértice tiene un padre.
         * @return <tt>true</tt> si el vértice tiene padre,
         *         <tt>false</tt> en otro caso.
         */
         public boolean hayPadre() {
            boolean hayDichoElemento = false;
            if (padre != null)
                hayDichoElemento = true;
            return hayDichoElemento;
        }
//
//        
//        
//        
//        /**
//         * Regresa el padre del vértice.
//         * @return el padre del vértice.
//         * @throws NoSuchElementException si el vértice no tiene padre.
//         */
        public Vertice<T> getPadre() {
            // Aquí va su código.
            if (hayPadre())
                return padre;
            else throw new NoSuchElementException("No hay padre");
        }
//
//
        /**
         * Regresa el elemento al que apunta el vértice.
         * @return el elemento al que apunta el vértice.
         */
         public T get() {
            return elemento;
            // Aquí va su código.
        }
    }
    
    public ArbolRetroceso(T elemento){
        verticesRaiz = new Vertice<T>(elemento);
        verticeActual = verticesRaiz;
    }
    /**
     * Revisa si este elemento ya esta en los hijos del vertice actual.
     * @param elem Elemento a revisar.
     * @return <tt> true <tt> Si el elemento ya existe.
                    <tt> false <tt> En otro caso.
     */
    public boolean elementoYaFueRegistrado(T elem)
    {
        return false;
    }
    
    /**
     * Crea un nuevo vertice con el elemento y este nuevo vertice se 
     * vuelve el vertice Actual.
     * @param elem element a crear.
     */
    public void registrar(T elemento){
        //..
    }
    
    /**
     *
     *
     */
 //WARNING
    public T regresar(){

        //REVISAR PARA CASO CUANDO YA NO HAY PADRE.
        T t= verticeActual.elemento;
        verticeActual = verticeActual.padre;
        return t;
    }
    
    /**
     *
     *
     */
    public boolean hayMasPosiblesCaminos(){
        if (verticeActual == verticesRaiz)
            return false;
        return true;
    }
    

    

   

}
