package mx.unam.ciencias.edd;



import java.util.NoSuchElementException;
import java.io.IOException;

/**
  * <p>Clase encargada de analizar un String en fromato UTF-8, y separar los
  * componentes en fichas reconocidas para las expreciones aritmeticas. No le 
  * corresponde verificar ambiguedades sintacticas o semanticas.</p>
  *
  */
public class AnalizadorLexico{
    
    

    /* Dado un texto se analizara en funcion de las fichas correspondientes 
     * a la gramatica de expreciones aritmeticas.
     * @param texto texto a analizar.
     * @return Lista donde estan las fichas correspondientes, y con sus respectivos
     * valores.
     */
    
    public static Lista<Ficha> analizarLexico(String texto){
        
        //Crearemos una lista de fichas.
        
        //Analizaremos el texto por caracter.
        
            //Le iremos preguntado a la clase Ficha si el texto es una ficha.
        
            //Mientras sea un numero decimal o entero lo continuaremos analizando.
            //Si detectamos letras entonces
                // Daremos una maxima acumulacion de 3 letras, unicamente si empieza por "s", "c" o "t" Para buscar funciones.
            //Si detectamos la letra x.
                //Este sera guardado como unica ficha.
            //Si encontramos un parantesis.
                //Este sera guardado como unica ficha.
            //Si encontramos un operador.
                //Sera guardado por igual.
        
            //Por cada ficha que encontremos esta se agregara a la lista de fichas.
            //De no encontrar fichas correspondiete al texto de entrada se regresara null.
        
        return new Lista<Ficha>();
        

    }
    
//    /* Dado un texto se analizara en funcion de las fichas correspondientes
//     * a la gramatica de expreciones aritmeticas.
//     * @param texto texto a analizar.
//     * @return string donde se indicara el error lexico encontrado. "@"LexicalError.
//     */
//    public String buscarErrorLexico(String texto){
//        
//    }
    
    
    
    
    
    

}
