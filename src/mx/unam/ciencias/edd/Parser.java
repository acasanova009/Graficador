package mx.unam.ciencias.edd;


/**
 * Parser. Clase que con el texto genera un arbol sintactico.
 *
 */
public class Parser {
    
    
    public static ArbolSintactico<Ficha> scanf(String texto)
    {
        
        //Dada una linea de texto con formato UTF-8.
        
        //Analizar la linea con el analizador léxico, y regresar un lista de fichas.
        //Cada ficha contiene el valor real, y la gramatica correspondiente.
        
        //Con la lista de fichas, analizaremos la sintactica con el analizador sintactico utilizando la gramatica infija, y crearemos el arbol sintactico.
        //Este arbol tendra la capacidad de auto evaluarse en x. Generando un f(x)=arbolSintactico.evaluar(x).
        
        //Finalmente cargaremos la vista a partir de conectar el arbol sintactico con las escuchas de la interfaz grafica de java. Para que podamos pintar el grafica las veces que sea necesario.
        
        
        //Clases por implementar. Fichas. Analizador Lexico. Analizador Sintactico. Arbol Sintactico, que por tener expresiones algebraicas, es binario. Gramatica. Ficha. ArbolRetroceso.
        
        Lista<ArbolSintactico<Ficha>> a;
        
        ArbolRetroceso<Gramatica> t;
        ArbolSintactico<Ficha> arbolSintactico = null;
        
        a= new Lista<ArbolSintactico<Ficha>> ();
        t = new ArbolRetroceso<Gramatica>();
        AnalizadorSintactico aSint = new AnalizadorSintactico();
        
        if( aSint.analizar(a,AnalizadorLexico.convertir(AnalizadorLexico.analizar(texto)),t))
        {
            
            arbolSintactico = a.getUltimo();
        }
        
        return arbolSintactico;
    }

    
}
