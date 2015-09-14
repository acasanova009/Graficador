
package mx.unam.ciencias.edd;

import java.lang.IllegalArgumentException;
import mx.unam.ciencias.edd.Ficha.Simbolo;
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
    M-> Y(E) //tamaño 4
    M-> (E)
    M-> -E   //tamño 2
    M-> Q
    Y-> func
    Q-> num 
    Q-> var
 
 
 _1_S_E,
 _4_E_T,
 _7_T_F,
 _9_F_M,
 _13_M_Q,
 _14_Y_func,
 _15_Q_num,
 _16_Q_var,
 
 
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
        _16_Q_var,
        //La gramatica __none especifica a los arboles que no fueron creados por una regla gramatical.
        __none
    }
//   
//    /* Verifica que la ficha, es un token no-terminal.
//     * Y verifica que la ficha se puede producir a partir de una reglaGramatical r.
//     * @return  boolean <tt>true</tt> Si se puede Producir
//     *                  <tt>false</tt> en otro caso.
//     */
    public static boolean sePuedeProducir(ArbolSintactico<Ficha> f, ReglaGramatical r){
        boolean siSePuede = false;
        switch(r){
            case _1_S_E:
                if(f.getFicha().getSimbolo() == Simbolo.S)
                   siSePuede = true;
                break;
            case _2_E_E_T:
                
                if(f.getFicha().getSimbolo() == Simbolo.E)
                    siSePuede = true;
                break;
            case _3_E_E__T:
                
                if(f.getFicha().getSimbolo() == Simbolo.E)
                    siSePuede = true;
                break;
            case _4_E_T:
                
                if(f.getFicha().getSimbolo() == Simbolo.E)
                    siSePuede = true;
                break;
            case _5_T_T_F:
                
                if(f.getFicha().getSimbolo() == Simbolo.T)
                    siSePuede = true;
                break;
            case _6_T_T__F:
                
                if(f.getFicha().getSimbolo() == Simbolo.T)
                    siSePuede = true;
                break;
            case _7_T_F:
                
                if(f.getFicha().getSimbolo() == Simbolo.T)
                    siSePuede = true;
                break;
            case _8_F_F_M:
                
                if(f.getFicha().getSimbolo() == Simbolo.F)
                    siSePuede = true;
                break;
            case _9_F_M:
                
                if(f.getFicha().getSimbolo() == Simbolo.F)
                    siSePuede = true;
                break;
            case _10_M_Y_E_:
                
                if(f.getFicha().getSimbolo() == Simbolo.M)
                    siSePuede = true;
                break;
            case _11_M__E_:
                
                if(f.getFicha().getSimbolo() == Simbolo.M)
                    siSePuede = true;
                break;
            case _12_M__E:
                
                if(f.getFicha().getSimbolo() == Simbolo.M)
                    siSePuede = true;
                break;
            case _13_M_Q:
                
                if(f.getFicha().getSimbolo() == Simbolo.M)
                    siSePuede = true;
                break;
            case _14_Y_func:
                
                if(f.getFicha().getSimbolo() == Simbolo.Y)
                    siSePuede = true;
                break;
            case _15_Q_num:
                
                if(f.getFicha().getSimbolo() == Simbolo.Q)
                    siSePuede = true;
                break;
            case _16_Q_var:
                
                if(f.getFicha().getSimbolo() == Simbolo.Q)
                    siSePuede = true;
                break;
            default:
                siSePuede = false;
                
        }
        return siSePuede;
    }
    /* Produce la lista de fichas a partir de una reglaGramatical.
     * @return Lista<Ficha> Lista de fichas que provienen de una 
     * produccion.
     */
//    public static Lista<ArbolSintactico<Ficha>> producir(ArbolSintactico<Ficha> f, ReglaGramatical r){
//        if (!sePuedeProducir(f,r))
//            return null;
//        return null;
//    }
//    
    
    /* Derivar de un lista de fichas a una anterior especifica.
     * @param a lista de fichas a reducir.
     * @param r ReglaGramatical a revisar
     * @return  boolean <tt>true</tt> Si se puede reducir
     *                  <tt>false</tt> en otro caso.
     */
    public static boolean sePuedeDerivar(Lista<ArbolSintactico<Ficha>> a, ReglaGramatical r){
        boolean siSePuede =false;
        
//        System.out.println(a + "  LONG " + a.getLongitud());
        
        if (ReglaGramatical.__none == r)
            return siSePuede;
        
        

        if(a.getLongitud() == 1)
        {
//            System.out.println("EN 1");
            //TODAS LA GRAMATICAS POSIBLES CON UN ELEMENTO.
            if(ReglaGramatical._1_S_E == r ||
               ReglaGramatical._4_E_T == r ||
               ReglaGramatical._7_T_F == r ||
               ReglaGramatical._9_F_M == r ||
               ReglaGramatical._13_M_Q == r ||
               ReglaGramatical._14_Y_func == r ||
               ReglaGramatical._15_Q_num == r ||
               ReglaGramatical._16_Q_var == r)
            {
                switch (r) {
                    case _1_S_E:
                        if(a.getPrimero().getFicha().getSimbolo() == Simbolo.E)
                            siSePuede = true;
                        break;
                    case _4_E_T:
                        if (a.getPrimero().getFicha().getSimbolo() == Simbolo.T)
                            siSePuede = true;
                        break;
                    case _7_T_F:
                        if (a.getPrimero().getFicha().getSimbolo() == Simbolo.F)
                            siSePuede =true;
                        break;
                    case _9_F_M:
                        if(a.getPrimero().getFicha().getSimbolo() == Simbolo.M)
                            siSePuede= true;
                        break;
                    case _13_M_Q:
                        if(a.getPrimero().getFicha().getSimbolo() == Simbolo.Q)
                            siSePuede= true;
                        break;
                    case _14_Y_func:
                        if(a.getPrimero().getFicha().getSimbolo() == Simbolo.FUNCION)
                            siSePuede = true;
                        break;
                    case _15_Q_num:
                        if(a.getPrimero().getFicha().getSimbolo() == Simbolo.REAL)
                            siSePuede= true;
                        break;
                    case _16_Q_var:
                        if(a.getPrimero().getFicha().getSimbolo() == Simbolo.VAR)
                            siSePuede = true;
                        break;
                    default:
                        siSePuede = false;
                }
            }
            else
            {
                siSePuede = false;
            }
            
                
        }
        else if(a.getLongitud() == 2)
            
            
        {   //INICIAMOS POR EL CASO SENCILLO.
            //Continuamos por el caso simple de 1 elemento.
            //Cuando analizamos por 1 elemento unicamente se tomara el que esta mas hacia a la derecha.
            
//            System.out.println("EN 2");
            if(r == ReglaGramatical._12_M__E)
            {
                
                
                if(a.getPrimero().getFicha().getSimbolo() == Simbolo.MENOS &&
                   a.getUltimo().getFicha().getSimbolo() == Simbolo.E )
                    siSePuede = true;
            }
            else
            {

                siSePuede = sePuedeDerivar(a.getUltimos(1),r);
            }
            
            
        }
        else if(a.getLongitud() == 3)
        {
            if(ReglaGramatical._2_E_E_T == r ||
               ReglaGramatical._3_E_E__T == r ||
               ReglaGramatical._5_T_T_F == r ||
               ReglaGramatical._6_T_T__F == r ||
               ReglaGramatical._8_F_F_M == r ||
               ReglaGramatical._11_M__E_ == r )
            {
                
                Lista<Simbolo> expectativaDeSimbolos;
                Lista<Simbolo> losSimbolosQueTengo;
                
                switch (r) {
                    case _2_E_E_T:
                        
                         expectativaDeSimbolos = new Lista<Simbolo>();
                         losSimbolosQueTengo =  new Lista<Simbolo>();
                        
                        expectativaDeSimbolos.agregaFinal(Simbolo.E);
                        expectativaDeSimbolos.agregaFinal(Simbolo.MAS);
                        expectativaDeSimbolos.agregaFinal(Simbolo.T);
                        
                        for(ArbolSintactico<Ficha> as: a)
                            losSimbolosQueTengo.agregaFinal(as.getFicha().getSimbolo());

                        if(losSimbolosQueTengo.equals(expectativaDeSimbolos))
                            siSePuede = true;
                            
                            
                        break;
                        
                    case _3_E_E__T:
                         expectativaDeSimbolos = new Lista<Simbolo>();
                        losSimbolosQueTengo =  new Lista<Simbolo>();
                        
                        expectativaDeSimbolos.agregaFinal(Simbolo.E);
                        expectativaDeSimbolos.agregaFinal(Simbolo.MENOS);
                        expectativaDeSimbolos.agregaFinal(Simbolo.T);
                        
                        for(ArbolSintactico<Ficha> as: a)
                            losSimbolosQueTengo.agregaFinal(as.getFicha().getSimbolo());
                        
                        if(losSimbolosQueTengo.equals(expectativaDeSimbolos))
                            siSePuede = true;
                        break;
                        
                    case _5_T_T_F:
                        
                         expectativaDeSimbolos = new Lista<Simbolo>();
                        losSimbolosQueTengo =  new Lista<Simbolo>();
                        
                        expectativaDeSimbolos.agregaFinal(Simbolo.T);
                        expectativaDeSimbolos.agregaFinal(Simbolo.MULT);
                        expectativaDeSimbolos.agregaFinal(Simbolo.F);
                        
                        for(ArbolSintactico<Ficha> as: a)
                            losSimbolosQueTengo.agregaFinal(as.getFicha().getSimbolo());
                        
                        if(losSimbolosQueTengo.equals(expectativaDeSimbolos))
                            siSePuede = true;
                        break;
                        
                    case _6_T_T__F:
                        
                        
                         expectativaDeSimbolos = new Lista<Simbolo>();
                        losSimbolosQueTengo =  new Lista<Simbolo>();
                        
                        expectativaDeSimbolos.agregaFinal(Simbolo.T);
                        expectativaDeSimbolos.agregaFinal(Simbolo.DIV);
                        expectativaDeSimbolos.agregaFinal(Simbolo.F);
                        
                        for(ArbolSintactico<Ficha> as: a)
                            losSimbolosQueTengo.agregaFinal(as.getFicha().getSimbolo());
                        
                        if(losSimbolosQueTengo.equals(expectativaDeSimbolos))
                            siSePuede = true;
                        
                        break;
                        
                    case _8_F_F_M:
                        
                         expectativaDeSimbolos = new Lista<Simbolo>();
                        losSimbolosQueTengo =  new Lista<Simbolo>();
                        
                        expectativaDeSimbolos.agregaFinal(Simbolo.F);
                        expectativaDeSimbolos.agregaFinal(Simbolo.EXPO);
                        expectativaDeSimbolos.agregaFinal(Simbolo.M);
                        
                        for(ArbolSintactico<Ficha> as: a)
                            losSimbolosQueTengo.agregaFinal(as.getFicha().getSimbolo());
                        
                        if(losSimbolosQueTengo.equals(expectativaDeSimbolos))
                            siSePuede = true;
                        
                        
                        break;
                        
                    case _11_M__E_:
                        
                        expectativaDeSimbolos = new Lista<Simbolo>();
                         losSimbolosQueTengo =  new Lista<Simbolo>();
                        
                        expectativaDeSimbolos.agregaFinal(Simbolo.PAR_I);
                        expectativaDeSimbolos.agregaFinal(Simbolo.E);
                        expectativaDeSimbolos.agregaFinal(Simbolo.PAR_D);
                        
                        for(ArbolSintactico<Ficha> as: a)
                            losSimbolosQueTengo.agregaFinal(as.getFicha().getSimbolo());
                        
                        if(losSimbolosQueTengo.equals(expectativaDeSimbolos))
                            siSePuede = true;
                        
                        break;
                    default:
                        siSePuede = false;
                        break;
                }
                
                
                
            }
            else
                siSePuede = sePuedeDerivar(a.getUltimos(2),r);
        }
        else if(a.getLongitud() == 4)
        {

            if(r == ReglaGramatical._10_M_Y_E_)
            {
               Lista<Simbolo> expectativaDeSimbolos = new Lista<Simbolo>();
                Lista<Simbolo> losSimbolosQueTengo =  new Lista<Simbolo>();
                
                expectativaDeSimbolos.agregaFinal(Simbolo.Y);
                expectativaDeSimbolos.agregaFinal(Simbolo.PAR_I);
                expectativaDeSimbolos.agregaFinal(Simbolo.E);
                expectativaDeSimbolos.agregaFinal(Simbolo.PAR_D);
                
                for(ArbolSintactico<Ficha> as: a)
                    losSimbolosQueTengo.agregaFinal(as.getFicha().getSimbolo());
                
                if(losSimbolosQueTengo.equals(expectativaDeSimbolos))
                    siSePuede = true;
            }
                else
                    siSePuede = sePuedeDerivar(a.getUltimos(3),r);
        }
        
        return siSePuede;
    }
   
    
//    /* Derivador de una lista de fichas a un ficha -d particular.
//     * @param a lista de fichas a reducir.
//     * @param r Regla a aplicar.
//     * @return Ficha La ficha que se derivo de la lista.
//     */
//    public static ArbolSintactico<Ficha> derivar(Lista<ArbolSintactico<Ficha>> a,ReglaGramatical r){
//        if(!sePuedeDerivar(a,r))
//            return null;
//    
//        
//        return null;
//    }
//    

}
