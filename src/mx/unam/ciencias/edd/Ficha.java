package mx.unam.ciencias.edd;

import java.lang.IllegalArgumentException;
import mx.unam.ciencias.edd.Gramatica.ReglaGramatical;
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
    private Simbolo simbolo;
    
    //Valor real. Puede ser un string vacio o nulo. Excepto cuando se va a evauluar el arbol. Podria tirar una excepcion.
    private String valor;

    //Por un problema del modelo de mi arbolSintactico de grado mayor, tengo que poder saber de que gramatica proviene esta Ficha, para evaluar el arbolSintactico de manera correcta.
    private ReglaGramatical regla;
    
    //Valor del Simbolo.
    public Simbolo getSimbolo(){
        return simbolo;
    }
    
    //Getter para el valor real.
    public String getValor(){
        return valor;
    }
    //Getter para el valor real.
    public void setRegla(ReglaGramatical r){
        regla = r;
    }
    public ReglaGramatical getRegla(){
        return regla;
    }
    

    /*Consutrctor de un ficha sin valor.
     *@param Simbolo aSimbolo El Simbolo que representa.
     */
    public Ficha(Simbolo aSimbolo){
        this(aSimbolo, ReglaGramatical.__none,"");

    }
    /*Consutrctor de un ficha sin valor.
    *@param r regla Gramatical Constructora.
     *@param Simbolo aSimbolo El Simbolo que representa.
     */
    public Ficha(Simbolo aSimbolo , Gramatica.ReglaGramatical  r){
        this(aSimbolo,r,"");
        
        
        
    }
    
    /*Constructor de una ficha con valor.
     *@param Simbolo aSimbolo El Simbolo que representa.
     *@param r regla Gramatical Constructora.
     *@param String texto que sera el valor de la ficha.
     */
    public Ficha(Simbolo aSimbolo, Gramatica.ReglaGramatical  r ,String v){

        
            simbolo = aSimbolo;
            regla = r;
            valor = v;
        
        
    }
    
    /* Nos dice si el simbolo de la ficha es terminal.
     *@return  <tt>true</tt> Si es Simbolo TERMINAL.,
     *         <tt>false</tt> en otro caso.
     */
  
    
    public boolean esTerminal(){
        boolean siEs = true;
        if (simbolo == Simbolo.S ||
            simbolo == Simbolo.E ||
            simbolo == Simbolo.T ||
            simbolo == Simbolo.F ||
            simbolo == Simbolo.M ||
            simbolo == Simbolo.Y ||
            simbolo == Simbolo.Q)
            siEs = false;
            

        return siEs;
    }
    
    
    /**
     * Regresa una representación en del Simbolo
     * @return una representación en cadena del Simbolo
     */
    @Override public String toString(){
        String s = "";
        //NO-TERMINALES
    
        if(this.simbolo==Simbolo.S)
            s= "S";
        if(this.simbolo==Simbolo.E)
            s= "E";
        if(this.simbolo==Simbolo.T)
            s= "T";
        if(this.simbolo==Simbolo.F)
            s= "F";
        if(this.simbolo==Simbolo.M)
            s= "M";
        if(this.simbolo==Simbolo.Y)
            s= "Y";
        if(this.simbolo==Simbolo.Q)
            s= "Q";

        //TERMINALES
        
        if(this.simbolo==Simbolo.MAS)
            s= "+";
        if(this.simbolo==Simbolo.MENOS)
            s= "-";
        if(this.simbolo==Simbolo.MULT)
            s= "*";
        if(this.simbolo==Simbolo.DIV)
            s= "/";
        if(this.simbolo==Simbolo.EXPO)
            s= "^";
        if(this.simbolo==Simbolo.PAR_I)
            s= "(";
        if(this.simbolo==Simbolo.PAR_D)
            s= ")";
        if(this.simbolo==Simbolo.FUNCION)
            s= "f";
        if(this.simbolo==Simbolo.REAL)
            s= "r";
        if(this.simbolo==Simbolo.VAR)
            s= "v";
    
//        return s;
        return s+"["+ valor+"]";
    }
    
    
    @Override public boolean equals(Object o){
        if (o == null)
            return false;
        if (getClass() != o.getClass())
            return false;
        @SuppressWarnings("unchecked")Ficha f = (Ficha)o;
        return (f.simbolo == this.simbolo);
        
    
    }

    

}
