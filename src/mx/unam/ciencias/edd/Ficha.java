package mx.unam.ciencias.edd;

import java.lang.IllegalArgumentException;
/**
 * Classe contenedora de el valor en ficha, y el valor real.
 * EJEMPLO:  ficha.representa = "NUM"
             ficha.valor = "345";
 */
public class Ficha{
    
    public static enum Token {
        MAS,
        MENOS,
        MULT,
        DIV,
        EXPO,
        PAR_I,
        PAR_D,
        
        //Son los que usan valores. => Que si es FUNCION, mejor un string else un double.
        FUNCION,
        REAL,
        VAR
    }
    
    //Token.
    private Token token;
    //Valor real.
    //Unicamente me importara el valor cuando vaya a evaluar el arbol (y obviamente este construido).
    private String valor;
    
    //Valor del token.
    public Token getToken(){
        return token;
    }
    
    //Getter para el valor real.
    public String getValor(){
        return valor;
    }
    

    /*Constructro que recibe un texto con el posible.
     *Por seguridad revisar antes si esFichaValida.
     *@param String texto que contiene la ficha.
     */
    public Ficha(String texto){
        
        valor = "";
        
        if (texto.equals("sin"))
            token = Token.FUNCION;
            valor = texto;
    
        
        
    }
    /*Metodo estatico o de clase para revisar si una ficha es valida
     *y sea un comportamiento encapsulado.
     *@return boolean <tt>true</tt> Si es una ficha valida.
     *         <tt>false</tt> en otro caso.
     */
    public static boolean esFichaValida(String  texto){
        return false;
        
    }
    public static enum Produccion {
        
        
    }
    /* Reductor de un lista de fichas a un ficha. 
     * Constructor de fichas inverso.
     
     
     Gramatica: 
     
     S-> E
     E-> E+T | E-T | T
     T-> T*F | T/F | F
     F-> F^M | M
     M-> Y(E) | (E) | -E | Q
     Y-> func
     Q-> num | var
     
     

     
     * @param Cola<Ficha> lista de fichas a reducir.
     * @return  boolean <tt>true</tt> Si se puede reducir   
     *                  <tt>false</tt> en otro caso.
     
     
     
     */
    
    public static boolean sePuedeReducir(Lista<Ficha> a, int reglaGramaticalNumero){
        
        boolean siSePuede= false;
        switch(reglaGramaticalNumero){
            case 0:
            break;}
        
        
            return siSePuede;
    }
    
    /**
     * Regresa una representación en del token
     * @return una representación en cadena del token
     */
    @Override public String toString(){
        String s = "";
        
        if(this.token==Token.EXPO)
            s= "o";
        if(this.token==Token.REAL)
            s= "r";
        if(this.token==Token.VAR)
            s= "v";
        if(this.token==Token.FUNCION)
            s= "f";
        if(this.token==Token.PAR_I)
            s= "(";
        if(this.token==Token.PAR_D)
            s= ")";
            
        return s;
    }
    

    

}
