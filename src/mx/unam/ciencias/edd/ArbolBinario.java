package mx.unam.ciencias.edd;

import java.util.NoSuchElementException;
import java.lang.Math;

/**
 * <p>Clase abstracta para árboles binarios genéricos.</p>
 *
 * <p>La clase proporciona las operaciones básicas para árboles
 * binarios, pero deja la implementación de varios en manos de las
 * clases concretas.</p>
 */
public abstract class ArbolBinario<T> implements Iterable<T> {

    /**
     * Clase interna protegida para vértices.
     */
    protected class Vertice<T> implements VerticeArbolBinario<T> {
        /** El elemento del vértice. */
        public T elemento;
        /** El padre del vértice. */
        public Vertice<T> padre;
        /** El izquierdo del vértice. */
        public Vertice<T> izquierdo;
        /** El derecho del vértice. */
        public Vertice<T> derecho;
        /** El color del nodo. */
        public Color color;
        /**
         * Regresa el color del vértice.
         * @return el color del vértice.
         */
        @Override public Color getColor() {
            return color;
        }

        public void cambiaColor()
        {
            if (color == Color.ROJO)
                color = Color.NEGRO;
            else
                color = Color.ROJO;
        }
        /**
         * Constructor único que recibe un elemento.
         * @param elem el elemento del vértice.
         */
        public Vertice(T elem) {
            //Aquí va su código.
            
            padre = izquierdo = derecho = null;
            this.elemento = elem;
        }

        /**
         * Regresa una representación en cadena del vértice.
         * @return una representación en cadena del vértice.
         */
        public String toString() {
            
            String elem = new String();
            if(elemento == null)
                elem = "(F)";
            else
                elem = elemento.toString();
            
//            if (color == Color.ROJO)
//                elem = ("[" + elem + "]");
            
                return elem;
        }

        /**
         * Nos dice si el vértice tiene un padre.
         * @return <tt>true</tt> si el vértice tiene padre,
         *         <tt>false</tt> en otro caso.
         */
        @Override public boolean hayPadre() {
            // Aquí va su código.
            
            // Aquí va su código.
            boolean hayDichoElemento = false;
            if (padre != null)
                hayDichoElemento = true;
            return hayDichoElemento;
        }

        /**
         * Nos dice si el vértice tiene un izquierdo.
         * @return <tt>true</tt> si el vértice tiene izquierdo,
         *         <tt>false</tt> en otro caso.
         */
        @Override public boolean hayIzquierdo() {
            // Aquí va su código.
            
            // Aquí va su código.
            boolean hayDichoElemento = false;
            if (izquierdo!= null)
                hayDichoElemento = true;
            return hayDichoElemento;
        }

        /**
         * Nos dice si el vértice tiene un derecho.
         * @return <tt>true</tt> si el vértice tiene derecho,
         *         <tt>false</tt> en otro caso.
         */
        @Override public boolean hayDerecho() {
            // Aquí va su código.
            boolean hayDichoElemento = false;
            if (derecho != null)
                hayDichoElemento = true;
            return hayDichoElemento;
        }
        

        /**
         * Regresa el padre del vértice.
         * @return el padre del vértice.
         * @throws NoSuchElementException si el vértice no tiene padre.
         */
        @Override public VerticeArbolBinario<T> getPadre() {
            // Aquí va su código.            
            if (hayPadre())
                return padre;
            else throw new NoSuchElementException("No hay padre");
        }

        /**
         * Regresa el izquierdo del vértice.
         * @return el izquierdo del vértice.
         * @throws NoSuchElementException si el vértice no tiene izquierdo.
         */
        @Override public VerticeArbolBinario<T> getIzquierdo() {
            
            if (hayIzquierdo())
                return izquierdo;
            else throw new NoSuchElementException("No hay elemnto izquierdo");
            // Aquí va su código.
        }

        /**
         * Regresa el derecho del vértice.
         * @return el derecho del vértice.
         * @throws NoSuchElementException si el vértice no tiene derecho.
         */
        @Override public VerticeArbolBinario<T> getDerecho() {
            if (hayDerecho())
                return derecho;
            else throw new NoSuchElementException("No hay elemnto derecho");
            // Aquí va su código.
        }

        /**
         * Regresa el elemento al que apunta el vértice.
         * @return el elemento al que apunta el vértice.
         */
        @Override public T get() {
            return elemento;
            // Aquí va su código.
        }
    }

    /** La raíz del árbol. */
    protected Vertice<T> raiz;
    /** El número de elementos */
    protected int elementos;

    /**
     * Construye un árbol con cero elementos.
     */
    public ArbolBinario() {
        // Aquí va su código.
        raiz = null;
        elementos = 0;
    }

    /**
     * Regresa la profundidad del árbol. La profundidad de un árbol
     * es la longitud de la ruta más larga entre la raíz y una hoja.
     * @return la profundidad del árbol.
     */
    public int profundidad() {
        
        return profundidad(raiz);
    }
    
    private int profundidad(Vertice<T> ver ) {
        if (ver == null || (!ver.hayIzquierdo() && !ver.hayDerecho()))
            return 0;
        return (1 + Math.max(profundidad(ver.izquierdo), profundidad(ver.derecho)));
    }
    

    /**
     * Regresa el número de elementos en el árbol. El número de
     * elementos es el número de elementos que se han agregado al
     * árbol.
     * @return el número de elementos en el árbol.
     */
    public int getElementos() {
        return getElementos(raiz);
    }
    private int getElementos(Vertice<T> ver)
    {
        if (ver == null)
            return 0;
        else
            return (1 + getElementos(ver.izquierdo) + getElementos(ver.derecho));
    }
    
    
    
    
    /**
     * Agrega un elemento al árbol.
     * @param elemento el elemento a agregar al árbol.
     * @return el vértice agregado al árbol que contiene el
     *         elemento.
     */
    public abstract VerticeArbolBinario<T> agrega(T elemento);

    /**
     * Elimina un elemento del árbol.
     * @param elemento el elemento a eliminar.
     */
    public abstract void elimina(T elemento);

    /**
     * Busca un elemento en el árbol. Si lo encuentra, regresa el
     * vértice que lo contiene; si no, regresa <tt>null</tt>.
     * @param elemento el elemento a buscar.
     * @return un vértice que contiene el elemento buscado si lo
     *         encuentra; <tt>null</tt> en otro caso.
     */
    public VerticeArbolBinario<T> busca(T elemento) {
//        return null;
        return busquedaDFS(raiz, elemento);
        
    }

    private VerticeArbolBinario<T> busquedaDFS(Vertice<T> v, T e)
    {
        VerticeArbolBinario<T> verticeEncontrado = null;
        if (v != null)
            if (v.elemento.equals(e))
                verticeEncontrado = v;
            else
            {
                verticeEncontrado = busquedaDFS(v.izquierdo, e);
                
                if (verticeEncontrado == null)
                verticeEncontrado = busquedaDFS(v.derecho, e);
                    
            }
        
        return verticeEncontrado;
        
    }
    /**
     * Regresa el vértice que contiene la raíz del árbol.
     * @return el vértice que contiene la raíz del árbol.
     * @throws NoSuchElementException si el árbol es vacío.
     */
    public VerticeArbolBinario<T> raiz() {
        return raiz;
        // Aquí va su código.
    }

    /**
     * Regresa una representación en cadena del árbol.
     * @return una representación en cadena del árbol.
     */
    @Override public String toString() {
        /* Necesitamos la profundidad para saber cuántas ramas puede
           haber. */
        if (elementos == 0)
            return "";
        int p = profundidad() + 1;
        /* true == dibuja rama, false == dibuja espacio. */
        boolean[] rama = new boolean[p];
        for (int i = 0; i < p; i++)
            /* Al inicio, no dibujamos ninguna rama. */
            rama[i] = false;
        String s = aCadena(raiz, 0, rama);
        return s.substring(0, s.length()-1);
    }

    /* Método auxiliar recursivo que hace todo el trabajo. */
    private String aCadena(Vertice<T> vertice, int nivel, boolean[] rama) {
        /* Primero que nada agregamos el vertice a la cadena. */
        String s = vertice + "\n";
        /* A partir de aquí, dibujamos rama en este nivel. */
        rama[nivel] = true;
        if (vertice.izquierdo != null && vertice.derecho != null) {
            /* Si hay vertice izquierdo Y derecho, dibujamos ramas o
             * espacios. */
            s += espacios(nivel, rama);
            /* Dibujamos el conector al hijo izquierdo. */
            s += "├─›";
            /* Recursivamente dibujamos el hijo izquierdo y sus
               descendientes. */
            s += aCadena(vertice.izquierdo, nivel+1, rama);
            /* Dibujamos ramas o espacios. */
            s += espacios(nivel, rama);
            /* Dibujamos el conector al hijo derecho. */
            s += "└─»";
            /* Como ya dibujamos el último hijo, ya no hay rama en
               este nivel. */
            rama[nivel] = false;
            /* Recursivamente dibujamos el hijo derecho y sus
               descendientes. */
            s += aCadena(vertice.derecho, nivel+1, rama);
        } else if (vertice.izquierdo != null) {
            /* Dibujamos ramas o espacios. */
            s += espacios(nivel, rama);
            /* Dibujamos el conector al hijo izquierdo. */
            s += "└─›";
            /* Como ya dibujamos el último hijo, ya no hay rama en
               este nivel. */
            rama[nivel] = false;
            /* Recursivamente dibujamos el hijo izquierdo y sus
               descendientes. */
            s += aCadena(vertice.izquierdo, nivel+1, rama);
        } else if (vertice.derecho != null) {
            /* Dibujamos ramas o espacios. */
            s += espacios(nivel, rama);
            /* Dibujamos el conector al hijo derecho. */
            s += "└─»";
            /* Como ya dibujamos el último hijo, ya no hay rama en
               este nivel. */
            rama[nivel] = false;
            /* Recursivamente dibujamos el hijo derecho y sus
               descendientes. */
            s += aCadena(vertice.derecho, nivel+1, rama);
        }
        return s;
    }

    /* Dibuja los espacios (incluidas las ramas, de ser necesarias)
       que van antes de un vértice. */
    private String espacios(int n, boolean[] rama) {
        String s = "";
        for (int i = 0; i < n; i++)
            if (rama[i])
                /* Rama: dibújala. */
                s += "│  ";
            else
                /* No rama: dibuja espacio. */
                s += "   ";
        return s;
    }

    /**
     * Convierte el vértice (visto como instancia de {@link
     * VerticeArbolBinario}) en vértice (visto como instancia de
     * {@link Vertice}). Método auxililar para hacer esta audición
     * en un único lugar.
     * @param verticeArbolBinario el vértice de árbol binario que queremos
     *        como vértice.
     * @return el vértice recibido visto como vértice.
     * @throws ClassCastException si el vértice no es instancia de
     *         {@link Vertice}.
     */
    protected Vertice<T> vertice(VerticeArbolBinario<T> verticeArbolBinario) {
        /* Tenemos que suprimir advertencias. */
        @SuppressWarnings("unchecked") Vertice<T> n = (Vertice<T>)verticeArbolBinario;
        return n;
    }
    
    /**
     * Genera codigo svg para visualizar el arbol.
     * @return El String que contiene el svg.
     */
    
    public String generaScalableVectorGraphics() {
        
        //Reviso si hay raiz.
        if(raiz == null)
            return "";
        
        //Generamos proporciones.
        
        //La altura  va a ser la profunidad;
        //La anchura = 2^p + (distancias entre nodos);
        
        int svgWidth =  (int)Math.pow(2, profundidad()) * getXconstant();
        int svgHeight = 0;
        
        if(profundidad()<2)
            
            svgHeight = 2*(getYconstant()+20);
        else
            svgHeight =  (profundidad()+1)*(getYconstant()+20);
        
        
        //Inicilizamos masterString, altura y anchura generamos en String codigo <svg>, <g>.
        String mS = "";
        mS += svgSize(svgWidth, svgHeight);
        
        
        //Recusrivamente vamos a contruir todos los nodos.
        //Metodo recursivo empieza con:
        // Raiz, Tamaño del nivel actual, posicionX del Vertice actual.
//        String lineas = "";
        String vectores = svgConstructor(1,svgWidth,raiz,-1,svgWidth/2);
        
//        mS+=lineas;
        mS+=vectores;
        
        
        
        mS+="\n</g>\n</svg>";
        

        //Cerramos con masterString </g></svg>;
        
        return mS;
    }
    /**Constructor recursivo de svg del arbol.
     * cX, es la posicion del vertice current.
     * pX, para evitar calcular doble, mandamos tambien la informacion de padre para construccion de la linea.
     * Contrario a la profunidad que empieza en 0, level empieza en 1.
     */
    
    private String svgConstructor(int level, int size , VerticeArbolBinario<T> v, int pX, int cX)
    {
        
        String s = "\n";
        
        if(v.hayDerecho())
                s+= lineTag(cX,level*getYconstant(), (cX+ (size/4)) , getYconstant()*(level+1));
        
        if(v.hayIzquierdo())
                s+= lineTag(cX,level*getYconstant(), (cX- (size/4)) , getYconstant()*(level+1));
        
            
            
        //Variables estaticas
//        int cR = 15; //Radio del criculo
        //String donde estara toda la informacion respecto a este vertice, y de ser necesarias la linea que lo conecta con su antecesor.
        
        //Dentro del string tres acciones quedan por hacer.
        //*Primero la linea
        //Si no es la raiz => hay que construir linea.
        int cY = getYconstant()*level;
        //**Segundo el criculo
        s+=cirlceTag(cX, cY, 15 , v);
        //De haber hijos recursamos.
        
        
        if(v.hayDerecho())
            s+=svgConstructor(level+1, size/2, v.getDerecho(), cX, (cX+ (size/4)) );
        
        
        if(v.hayIzquierdo())
            s+=svgConstructor(level+1, size/2, v.getIzquierdo(), cX, (cX- (size/4)) );
        
        
        return s;
    }
    
    
    private int getXconstant()
    {
        return 35;
    }
    
    private int getYconstant()
    {
        return 50;
    }
    private String valueTag( int  x , int y, String s)
    {
        return String.format("<text fill='white' font-family='sans-serif' font-size='15' x='%d' y='%d' text-anchor='middle'>%s</text>",x,y,s);
        
    }
    
    
    protected String cirlceTag(int x, int y, int r, VerticeArbolBinario<T >v)
    {
        
        //
        String t = "black";
        String c = "white";
        if(v.getColor()==Color.NEGRO)
        {
            c = "black";
            t= "white";
        }
        
        if(v.getColor()==Color.ROJO)
        {
            t = "white";
            c = "red";
        }
            
        
        return String.format("<circle cx='%d' cy='%d' r='%d' stroke='black' stroke-width='2' fill='%s' />\n "+
                             "<text fill='%s' font-family='sans-serif' font-size='15' x='%d' y='%d' text-anchor='middle'>%s</text>\n",x,y,15,c,t,x,y+5,v.toString());
    }
    
    private String lineTag(int x1, int y1, int x2, int y2)
    {
        return String.format("<line x1='%d' y1='%d' x2='%d' y2='%d' %s />\n",x1,y1,x2,y2, lineStyle() );
    }
    private String lineStyle()
    {
        return ("stroke='black' stroke-width='2'");
    }
    
    
    private String svgSize(int width , int height)
    {
        return String.format("<svg width='%d' height='%d'>\n<g>\n",width,height);
    }
    

}
