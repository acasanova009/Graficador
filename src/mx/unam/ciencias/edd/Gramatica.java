package mx.unam.ciencias.edd;

import java.lang.IllegalArgumentException;
/**
 * Clase que define que producciones o derivaciones se 
 * pueden realizar dadas n Fichas,  0<n<5.
 *
 * Gramatica:
 
    S-> E
    E-> E+T | E-T | T
    T-> T*F | T/F | F
    F-> F^M | M
    M-> Y(E) | (E) | -E | Q
    Y-> func
    Q-> num | var
 
    Gramatica Desglosada.
 
    S-> E
    E-> E+T
    E-> E-T
    E-> T
    T-> T*F 
    T-> T/F 
    T-> F
    F-> F^M
    F-> M
    M-> Y(E) 
    M-> (E)
    M-> -E 
    M-> Q
    Y-> func
    Q-> num 
    Q-> var
 
 
 
 * Una produccion va de izquierda a derecha "->"
 * Una derivacion va de derecha a izquierda "<-"
 * Contiene todas las 16 posibles derivaciones.
 *
 *
 */
public class Gramatica {
    
    
    public static enum ReglaGramatical{

        _1_S_E,
        _2_E_E_T,
        _3_E_E__T,
        _4_E_T,
        _5_T_T_F,
        _6_T_T__F,
        _7_T_F,
        _8_F_F_M,
        _9_F_M,
        _10_M_Y_E_,
        _11_M__E_,
        _12_M__E,
        _13_M_Q,
        _14_Y_func,
        _15_Q_num,
        _16_Q_var
    }
   
    /* Verifica que la ficha, es un token no-terminal.
     * Y verifica que la ficha se puede producir a partir de una reglaGramatical r.
     * @return  boolean <tt>true</tt> Si se puede Producir
     *                  <tt>false</tt> en otro caso.
     */
    public static boolean sePuedeProducir(Ficha f, ReglaGramatical r){
        return false;
    }
    /* Produce la lista de fichas a partir de una reglaGramatical.
     * @return Lista<Ficha> Lista de fichas que provienen de una 
     * produccion.
     */
    public static Lista<Ficha> producir(Ficha f, ReglaGramatical r){
        if (!sePuedeProducir(f,r))
            return null;
        return null;
    }
    
    
    /* Derivar de un lista de fichas a una anterior especifica.
     * @param a lista de fichas a reducir.
     * @param r ReglaGramatical a revisar
     * @return  boolean <tt>true</tt> Si se puede reducir
     *                  <tt>false</tt> en otro caso.
     */
    public static boolean sePuedeDerivar(Lista<Ficha> a, ReglaGramatical r){
        
        return false;
    }
   
    
    /* Derivador de una lista de fichas a un ficha -d particular.
     * @param a lista de fichas a reducir.
     * @param r Regla a aplicar.
     * @return Ficha La ficha que se derivo de la lista.
     */
    public static Ficha derivar(Lista<Ficha> a,ReglaGramatical r){
        if(!sePuedeDerivar(a,r))
            return null;
    
        
        return null;
    }
    

}
