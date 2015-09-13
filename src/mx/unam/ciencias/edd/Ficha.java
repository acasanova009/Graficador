package mx.unam.ciencias.edd;

import java.lang.IllegalArgumentException;
/**
 * Clase contenedora de el valor en ficha, y el valor real.
 *
 */
public class Ficha{
    
    public static enum Simbolo {
        //NO-TERMINALES
        S,
        E,
        T,
        F,
        M,
        Y,
        Q,
        
        
        //TERMINALES
        MAS,
        MENOS,
        MULT,
        DIV,
        EXPO,
        PAR_I,
        PAR_D,
        
        //USAN VALOR => Si es FUNCION, string else double.
        FUNCION,
        REAL,
        VAR
    }
    
    //Simbolo.
    private Simbolo Simbolo;
    
    //Valor real. Puede ser un string vacio o nulo. Excepto cuando se va a evauluar el arbol. Podria tirar una excepcion.
    private String valor;

    
    //Valor del Simbolo.
    public Simbolo getSimbolo(){
        return Simbolo;
    }
    
    //Getter para el valor real.
    public String getValor(){
        return valor;
    }
    

    /*Consutrctor de un ficha sin valor.
     *@param Simbolo aSimbolo El Simbolo que representa.
     */
    public Ficha(Simbolo aSimbolo){
        this(aSimbolo, "");

    }
    /*Constructor de una ficha con valor.
     *@param Simbolo aSimbolo El Simbolo que representa.
     *@param String texto que sera el valor de la ficha.
     */
    public Ficha(Simbolo aSimbolo,String v){
        

            Simbolo = aSimbolo;
            valor = v;
        
    }
    
    /* Nos dice si el simbolo de la ficha es terminal.
     *@return  <tt>true</tt> Si es Simbolo TERMINAL.,
     *         <tt>false</tt> en otro caso.
     */
    public boolean esTerminal(){
        return false;
    }
    
    
    /**
     * Regresa una representación en del Simbolo
     * @return una representación en cadena del Simbolo
     */
    @Override public String toString(){
        String s = "";
        //NO-TERMINALES
    
        if(this.Simbolo==Simbolo.S)
            s= "S";
        if(this.Simbolo==Simbolo.E)
            s= "E";
        if(this.Simbolo==Simbolo.T)
            s= "T";
        if(this.Simbolo==Simbolo.F)
            s= "F";
        if(this.Simbolo==Simbolo.M)
            s= "M";
        if(this.Simbolo==Simbolo.Y)
            s= "Y";
        if(this.Simbolo==Simbolo.Q)
            s= "Q";
        
        //TERMINALES
        
        if(this.Simbolo==Simbolo.MAS)
            s= "+";
        if(this.Simbolo==Simbolo.MENOS)
            s= "-";
        if(this.Simbolo==Simbolo.MULT)
            s= "*";
        if(this.Simbolo==Simbolo.DIV)
            s= "/";
        if(this.Simbolo==Simbolo.EXPO)
            s= "^";
        if(this.Simbolo==Simbolo.PAR_I)
            s= "(";
        if(this.Simbolo==Simbolo.PAR_D)
            s= ")";
        if(this.Simbolo==Simbolo.FUNCION)
            s= "f";
        if(this.Simbolo==Simbolo.REAL)
            s= "r";
        if(this.Simbolo==Simbolo.VAR)
            s= "v";
        
            
        return s;
    }
    

    

}
