package mx.unam.ciencias.edd;

/**
 * Classe contenedora de el valor en ficha, y el valor real.
 * EJEMPLO:  ficha.representa = "NUM"
             ficha.valor = "345";
 */
public class Ficha{
    
    public static enum Token {
        OPERADOR ,
        REAL,
        VAR,
        FUNCION,
        PAR_I,
        PAR_D
    }
    
    //Token.
    private Token token;
    //Valor real.
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
    
    /**
     * Regresa una representación en del token
     * @return una representación en cadena del token
     */
    @Override public String toString(){
        String s = "";
        
        if(this.token==Token.OPERADOR)
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
