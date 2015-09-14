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
        
        super();
        reglaGramatical = r;
        raiz = new Vertice<T>(ficha);
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
    
    public Lista<ArbolSintactico<T>> derivar(T ficha, ReglaGramatical r, Lista<ArbolSintactico<T>> l) throws IllegalArgumentException
    {
        if(l.getLongitud()<1 || l== null)
            throw new IllegalArgumentException("La lista de arboles esta vacia. O es nula.");
        ArbolSintactico<T> arbolContenedor = new ArbolSintactico<T>(ficha,r);
        
        //Debido a que es un arbol Binario, para conservar esto en los vertices unicamente guardaremos las fichas. No otro arbolSintactico. En otras palabras, un arbolSintactico no tiene Arboles Sintacticos.
        //        //LOS VERTICES IZQUIERDOS VAN A SER LOS VERTICES FUERTES.
        //        if (!Gramatica.sePuedeDerivar(l,r)){
        //            throw new IllegalArgumentException("Hay un error. En la derivacion.");
        //            return;
        //        }
        //NO SE ESTAN ELIMINANDO LOS ARBOLES QUE SOBRAN. SE ME OCURRE PUEDO MANTENER MEJOR SIMPRE MANDANDO A TODOS...ENTONCES LA -A DEL ANALIZADOR SIEMPRE ES -l.
        //Para las gramaticas de n componentes.
        Lista<ArbolSintactico<T>> acotada;
        
        Vertice<T> leftVertice;
        Vertice<T> rightVertice;
        
        ArbolSintactico<T> left;
        ArbolSintactico<T> right;
        
        Ficha.Simbolo primerSimbolo;
        Ficha.Simbolo ultimoSimbolo;
        
        
        
        //Para las gramaticas de 1 componente.
        
        Vertice<T> verticeContenedor; // Sera para almacenar la ficha.
    
        ArbolSintactico<T> unico; // Lo usaremos para gramaticas de un solo elemento.
        
        Ficha.Simbolo unicoSimbolo; // Para corroborar que mi simboloCoincide con la gramatica.
        
        switch(r){
            case _1_S_E:
                
                
                unico = l.getUltimo();
                unicoSimbolo = unico.getFicha().getSimbolo();
                if(unicoSimbolo!=Ficha.Simbolo.E)
                    throw new IllegalArgumentException("Gramatica _1_S_E, solo funciona con simbolo E.");
                
                verticeContenedor =  new Vertice<T>(unico.getFicha());
                verticeContenedor.padre = arbolContenedor.raiz;
                arbolContenedor.raiz.izquierdo = verticeContenedor;
                
                l.eliminaUltimo();
                l.agregaFinal(arbolContenedor);
                
                
                break;
            case _2_E_E_T:
                
                acotada = l.getUltimos(3);
                Ficha.Simbolo[] suma ={Ficha.Simbolo.E, Ficha.Simbolo.MAS, Ficha.Simbolo.T };
                
                if (!listaEqualSimbolArray(acotada,suma))
                    throw new IllegalArgumentException("Gramatica _2_E_E_T, solo funciona con simbolos E,MAS,T.");

                
                leftVertice =  new Vertice<T>(acotada.getPrimero().getFicha());
                rightVertice =  new Vertice<T>(acotada.getUltimo().getFicha());
                leftVertice.padre = arbolContenedor.raiz;
                rightVertice.padre = arbolContenedor.raiz;
                
                arbolContenedor.raiz.izquierdo = leftVertice;
                arbolContenedor.raiz.derecho = rightVertice;
                
                l.extraerUltimos(3);
                
                l.agregaFinal(arbolContenedor);
                
                //                if(f.getFicha().getSimbolo() == Simbolo.E)
                //                    siSePuede = true;
                break;
            case _3_E_E__T:
                
                
                acotada = l.getUltimos(3);
                Ficha.Simbolo[] resta ={Ficha.Simbolo.E, Ficha.Simbolo.MENOS, Ficha.Simbolo.T };
                
                if (!listaEqualSimbolArray(acotada,resta))
                    throw new IllegalArgumentException("Gramatica _3_E_E__T, solo funciona con simbolos E,MENOS,T.");
                
                
                leftVertice =  new Vertice<T>(acotada.getPrimero().getFicha());
                rightVertice =  new Vertice<T>(acotada.getUltimo().getFicha());
                leftVertice.padre = arbolContenedor.raiz;
                rightVertice.padre = arbolContenedor.raiz;
                
                arbolContenedor.raiz.izquierdo = leftVertice;
                arbolContenedor.raiz.derecho = rightVertice;
                
                l.extraerUltimos(3);
                
                l.agregaFinal(arbolContenedor);
                break;
            case _4_E_T:
                
                unico = l.getUltimo();

                    unicoSimbolo = unico.getFicha().getSimbolo();
                if(unicoSimbolo!=Ficha.Simbolo.T)
                    throw new IllegalArgumentException("Gramatica _4_E_T, solo funciona con simbolo T.");
                
                verticeContenedor =  new Vertice<T>(unico.getFicha());
                verticeContenedor.padre = arbolContenedor.raiz;
                arbolContenedor.raiz.izquierdo = verticeContenedor;
                
                l.eliminaUltimo();
                l.agregaFinal(arbolContenedor);
                
                break;
            case _5_T_T_F:
                
                
                acotada = l.getUltimos(3);
                Ficha.Simbolo[] mult ={Ficha.Simbolo.T, Ficha.Simbolo.MULT, Ficha.Simbolo.F };
                
                if (!listaEqualSimbolArray(acotada,mult))
                    throw new IllegalArgumentException("Gramatica _5_T_T_F, solo funciona con simbolos T,MULT,F.");
                
                
                leftVertice =  new Vertice<T>(acotada.getPrimero().getFicha());
                rightVertice =  new Vertice<T>(acotada.getUltimo().getFicha());
                leftVertice.padre = arbolContenedor.raiz;
                rightVertice.padre = arbolContenedor.raiz;
                
                arbolContenedor.raiz.izquierdo = leftVertice;
                arbolContenedor.raiz.derecho = rightVertice;
                
                l.extraerUltimos(3);
                
                l.agregaFinal(arbolContenedor);
                break;
            case _6_T_T__F:
                
                
                acotada = l.getUltimos(3);
                Ficha.Simbolo[] div ={Ficha.Simbolo.T, Ficha.Simbolo.DIV, Ficha.Simbolo.F };
                
                if (!listaEqualSimbolArray(acotada,div))
                    throw new IllegalArgumentException("Gramatica _6_T_T__F, solo funciona con simbolos T,DIV,F.");
                
                
                leftVertice =  new Vertice<T>(acotada.getPrimero().getFicha());
                rightVertice =  new Vertice<T>(acotada.getUltimo().getFicha());
                leftVertice.padre = arbolContenedor.raiz;
                rightVertice.padre = arbolContenedor.raiz;
                
                arbolContenedor.raiz.izquierdo = leftVertice;
                arbolContenedor.raiz.derecho = rightVertice;
                
                l.extraerUltimos(3);
                
                l.agregaFinal(arbolContenedor);
                
                break;
            case _7_T_F:
                
                
                unico = l.getUltimo();
                 unicoSimbolo = unico.getFicha().getSimbolo();
                if(unicoSimbolo!=Ficha.Simbolo.F)
                    throw new IllegalArgumentException("Gramatica _7_T_F, solo funciona con simbolo F.");
                
                verticeContenedor =  new Vertice<T>(unico.getFicha());
                verticeContenedor.padre = arbolContenedor.raiz;
                arbolContenedor.raiz.izquierdo = verticeContenedor;
                
                l.eliminaUltimo();
                l.agregaFinal(arbolContenedor);
                break;
            case _8_F_F_M:
                
                
                acotada = l.getUltimos(3);
                Ficha.Simbolo[] expo ={Ficha.Simbolo.F, Ficha.Simbolo.EXPO, Ficha.Simbolo.M };
                
                if (!listaEqualSimbolArray(acotada,expo))
                    throw new IllegalArgumentException("Gramatica _8_F_F_M, solo funciona con F.EXPO.M .");
                
                
                leftVertice =  new Vertice<T>(acotada.getPrimero().getFicha());
                rightVertice =  new Vertice<T>(acotada.getUltimo().getFicha());
                leftVertice.padre = arbolContenedor.raiz;
                rightVertice.padre = arbolContenedor.raiz;
                
                arbolContenedor.raiz.izquierdo = leftVertice;
                arbolContenedor.raiz.derecho = rightVertice;
                
                l.extraerUltimos(3);
                
                l.agregaFinal(arbolContenedor);
                
                
                break;
            case _9_F_M:
                
                unico = l.getUltimo();
                 unicoSimbolo = unico.getFicha().getSimbolo();
                if(unicoSimbolo!=Ficha.Simbolo.M)
                    throw new IllegalArgumentException("Gramatica _9_F_M, solo funciona con simbolo M.");
                
                verticeContenedor =  new Vertice<T>(unico.getFicha());
                verticeContenedor.padre = arbolContenedor.raiz;
                arbolContenedor.raiz.izquierdo = verticeContenedor;
                
                l.eliminaUltimo();
                l.agregaFinal(arbolContenedor);
                break;
            case _10_M_Y_E_:
                
                
                
                acotada = l.getUltimos(4);
                Ficha.Simbolo[] func ={Ficha.Simbolo.Y, Ficha.Simbolo.PAR_I, Ficha.Simbolo.E,Ficha.Simbolo.PAR_D };
                
                if (!listaEqualSimbolArray(acotada,func))
                    throw new IllegalArgumentException("Gramatica _10_M_Y_E_, solo funciona con Y,PAR_I,E,PAR_D.");
                
                
                leftVertice =  new Vertice<T>(acotada.getPrimero().getFicha());
                //Hacemos una prequeña transicion para que sea mas facil.
                acotada = l.getUltimos(2);
                rightVertice =  new Vertice<T>(acotada.getPrimero().getFicha());
                
                leftVertice.padre = arbolContenedor.raiz;
                rightVertice.padre = arbolContenedor.raiz;
                
                arbolContenedor.raiz.izquierdo = leftVertice;
                arbolContenedor.raiz.derecho = rightVertice;
                
                l.extraerUltimos(4);
                
                l.agregaFinal(arbolContenedor);
                
                break;
            case _11_M__E_:
                
                acotada = l.getUltimos(3);
                Ficha.Simbolo[] parentesis ={Ficha.Simbolo.PAR_I,Ficha.Simbolo.E,Ficha.Simbolo.PAR_D};
                
                if (!listaEqualSimbolArray(acotada,parentesis))
                    throw new IllegalArgumentException("Gramatica _11_M__E_, solo p_i E p_d");
                
                
                
                acotada = l.getUltimos(2);
                
                leftVertice =  new Vertice<T>(acotada.getPrimero().getFicha());
                
                leftVertice.padre = arbolContenedor.raiz;
                arbolContenedor.raiz.izquierdo = leftVertice;
                
                l.extraerUltimos(3);
                
                l.agregaFinal(arbolContenedor);
                break;
            case _12_M__E:
                
                
                acotada = l.getUltimos(2);
                Ficha.Simbolo[] menosE ={Ficha.Simbolo.MENOS, Ficha.Simbolo.E};
                
                if (!listaEqualSimbolArray(acotada,menosE))
                    throw new IllegalArgumentException("Gramatica _12_M__E, solo funciona con MENOS,E");
                
                
                leftVertice =  new Vertice<T>(acotada.getUltimo().getFicha());
                //Hacemos una prequeña transicion para que sea mas facil.
//                acotada = l.getUltimos(2);
//                rightVertice =  new Vertice<T>(acotada.getUltimo().getFicha());
                
                leftVertice.padre = arbolContenedor.raiz;
//                rightVertice.padre = arbolContenedor.raiz;
                
                arbolContenedor.raiz.izquierdo = leftVertice;
//                arbolContenedor.raiz.derecho = rightVertice;
                
                l.extraerUltimos(2);
                
                l.agregaFinal(arbolContenedor);
                
                
                break;
            case _13_M_Q:
                
                unico = l.getUltimo();
                 unicoSimbolo = unico.getFicha().getSimbolo();
                if(unicoSimbolo!=Ficha.Simbolo.Q)
                    throw new IllegalArgumentException("Gramatica _13_M_Q, solo funciona con simbolo Q.");
                
                verticeContenedor =  new Vertice<T>(unico.getFicha());
                verticeContenedor.padre = arbolContenedor.raiz;
                arbolContenedor.raiz.izquierdo = verticeContenedor;
                
                l.eliminaUltimo();
                l.agregaFinal(arbolContenedor);
                break;
            case _14_Y_func:
                
                unico = l.getUltimo();
                unicoSimbolo = unico.getFicha().getSimbolo();
                if(unicoSimbolo!=Ficha.Simbolo.FUNCION)
                    throw new IllegalArgumentException("Gramatica _14_Y_func, solo funciona con simbolo FUNCION.");
                
                verticeContenedor =  new Vertice<T>(unico.getFicha());
                verticeContenedor.padre = arbolContenedor.raiz;
                arbolContenedor.raiz.izquierdo = verticeContenedor;
                
                l.eliminaUltimo();
                l.agregaFinal(arbolContenedor);
                break;
            case _15_Q_num:
                
                unico = l.getUltimo();
                 unicoSimbolo = unico.getFicha().getSimbolo();
                if(unicoSimbolo!=Ficha.Simbolo.REAL)
                    throw new IllegalArgumentException("Gramatica _15_Q_num, solo funciona con simbolo REAL.");
                
                verticeContenedor =  new Vertice<T>(unico.getFicha());
                verticeContenedor.padre = arbolContenedor.raiz;
                arbolContenedor.raiz.izquierdo = verticeContenedor;
                
                l.eliminaUltimo();
                l.agregaFinal(arbolContenedor);
                break;
            case _16_Q_var:
                
                unico = l.getUltimo();
                 unicoSimbolo = unico.getFicha().getSimbolo();
                if(unicoSimbolo!=Ficha.Simbolo.VAR)
                    throw new IllegalArgumentException("Gramatica _16_Q_var, solo funciona con simbolo VAR.");
                
                verticeContenedor =  new Vertice<T>(unico.getFicha());
                verticeContenedor.padre = arbolContenedor.raiz;
                arbolContenedor.raiz.izquierdo = verticeContenedor;
                
                l.eliminaUltimo();
                l.agregaFinal(arbolContenedor);
                break;
                
            default:
                //                siSePuede = false;
                
        }
        
        return l;
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
    
    private boolean listaEqualSimbolArray(Lista<ArbolSintactico<T>> miAcotada, Ficha.Simbolo[] misSimbolos)
    {
        
        Lista<Ficha.Simbolo> original = new Lista<Ficha.Simbolo>();
        Lista<Ficha.Simbolo> expectativa = new Lista<Ficha.Simbolo>();
        
        for(ArbolSintactico<T> as : miAcotada){
            original.agregaFinal(as.getFicha().getSimbolo());
            
        }
        for(Ficha.Simbolo s : misSimbolos){
            expectativa.agregaFinal(s);
        }
        return original.equals(expectativa);
    }
    
}
