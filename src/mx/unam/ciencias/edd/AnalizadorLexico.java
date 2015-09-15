package mx.unam.ciencias.edd;



//import java.util.LexicalSimbolException;

import mx.unam.ciencias.edd.Gramatica.ReglaGramatical;
import mx.unam.ciencias.edd.Ficha.Simbolo;


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
     
     * @throws LexicalSimbolException si no reconoce a los caracteres.
     */
    
    public static Lista<Ficha> analizar(String texto) throws LexicalSimbolException{
        

        Lista<Ficha> listaFinal = new Lista<Ficha>();
        
        //Crearemos una lista de fichas.
    
        //Analizaremos el texto por caracter.
        
        //Quitamos los caracteres blancos.
        String onlyCharacters = texto.replaceAll("\\s","");
        String lowerCase = onlyCharacters.toLowerCase();
        
        
        
        String paraInformarDondeEstaElError = "";
        
        
        
        
        /***PARA LOS NUMEROS **/
        boolean numberDetected =false;
        String numberDetectedString = "";
        boolean backPointDetected = false;
        
        
        /***PARA ALGUN PUNTO . CON NUMEROS. **/
        String frontPointDetectedString = "";
        boolean frontPointDetected =false;
        char[] chars = lowerCase.toCharArray();
        int tamano = lowerCase.toCharArray().length;
        
        
//                        System.out.println("Original:"+lowerCase);

        for(int i = 0; i < tamano ; i++){
            paraInformarDondeEstaElError+=chars[i];
            
            //Si yaHabiamosDetectadoUnNumero
            if (numberDetected){
                
                if(esNumero(chars[i]))
                {
                    
                    numberDetectedString += chars[i];
                    
                    
                    if((i+1)>=tamano && backPointDetected==false)
                    {
                        
                        
                        numberDetectedString+='.';
                        
                        numberDetectedString+='0';
                        
                        
                        
                        Ficha f = new Ficha(Simbolo.REAL,ReglaGramatical.__none,numberDetectedString);
                        listaFinal.agregaFinal(f);
                        numberDetectedString = "";
                        
                        backPointDetected = false;
                        numberDetected = false;
                        
                        
                    }
                    else if((i+1)>=tamano && backPointDetected==true)
                    {
                        
                        
                        
                        
                        
                        Ficha f = new Ficha(Simbolo.REAL,ReglaGramatical.__none,numberDetectedString);
                        listaFinal.agregaFinal(f);
                        numberDetectedString = "";
                        
                        backPointDetected = false;
                        numberDetected = false;
                        
                        
                    }
                    continue;
                }
                else if(chars[i]=='.' && !backPointDetected){
                    backPointDetected = true;
                    numberDetectedString += chars[i];
                    
                    if((i+1)<tamano && !esNumero(chars[i+1]))
                    {
                        numberDetectedString+='0';
                        
                        Ficha f = new Ficha(Simbolo.REAL,ReglaGramatical.__none,numberDetectedString);
                        listaFinal.agregaFinal(f);
                        numberDetectedString = "";
                        backPointDetected = false;
                        numberDetected = false;
                    }
                    continue;
                    
                }
                
                else if(chars[i]!='.'){//NO es numero y no es punto.
                    
                    numberDetectedString+='.';
                                        numberDetectedString+='0';
                    Ficha f = new Ficha(Simbolo.REAL,ReglaGramatical.__none,numberDetectedString);
                    listaFinal.agregaFinal(f);
                    backPointDetected = false;
                    numberDetected = false;
                    numberDetectedString = "";
                }
                else {
                    
                    
                    Ficha f = new Ficha(Simbolo.REAL,ReglaGramatical.__none,numberDetectedString);
                    listaFinal.agregaFinal(f);
                    backPointDetected = false;
                    numberDetected = false;
                    numberDetectedString = "";
                }
            }
        

         // Daremos una maxima acumulacion de 3 letras, unicamente si empieza por "s", "c" o "t" Para buscar funciones.
            
            //Si yaHabiamosDetectadoUnPunto
            else if (frontPointDetected){
                if(esNumero( chars[i]))
                {
                    frontPointDetectedString += chars[i];
                    if((i+1)>=tamano)
                    {
                        Ficha f = new Ficha(Simbolo.REAL,ReglaGramatical.__none,frontPointDetectedString);
                        listaFinal.agregaFinal(f);
                        frontPointDetectedString = "";
                        frontPointDetected= false;
                        
                    }
                    continue;
                    
                }
                else
                {
                    if(frontPointDetectedString.length()==2)
                        frontPointDetectedString+='0';
                    
                    frontPointDetected = false;
                    
                    Ficha f = new Ficha(Simbolo.REAL,ReglaGramatical.__none,frontPointDetectedString);
                    listaFinal.agregaFinal(f);
                    frontPointDetectedString = "";
                }
                
                
            }
            //Si detectamosNumero
            
            if (esNumero(chars[i])){
                numberDetected = true;
                numberDetectedString+= chars[i];
                
                if((i+1)>=tamano)
                {
                    
                    
                    numberDetectedString+='.';

                    numberDetectedString+='0';
                    
                    
                    
                    Ficha f = new Ficha(Simbolo.REAL,ReglaGramatical.__none,numberDetectedString);
                    listaFinal.agregaFinal(f);
                    numberDetectedString = "";
                    
                    
                }
                else if((i+2)>=tamano && (chars[i+1]=='.'))
                {
                    
                    
                    numberDetectedString+='.';
                    
                    numberDetectedString+='0';
                    
                    
                    
                    Ficha f = new Ficha(Simbolo.REAL,ReglaGramatical.__none,numberDetectedString);
                    listaFinal.agregaFinal(f);
                    numberDetectedString = "";
                    
                    
                }
                
//
                
            }
                //avisasr
            
            //Si detecamosLetraDeFuncion
            else if (tieneQueSerFuncion(chars[i]))
            {
                
//                System.out.println("Aqui estamos con: "+ chars[i]);
                
                //Minetras siga dentro de mi array.
                boolean esFuncion4 = false;
                if((i+2)<tamano)
                {
                    
                    
//                    System.out.println("Aqui estamos con: "+ chars[i]);
                    if(esFuncion(chars[i],chars[i+1],chars[i+2]))
                    {
                        
//                        System.out.println("SI estamos con: "+ chars[i]);
                        Ficha funcion = generaFichaFuncion(chars[i],chars[i+1],chars[i+2]);
                        listaFinal.agregaFinal(funcion);
                        //Y NOS MOVEMOS.
                        i=i+2;
                        continue;
                        
                    }
                    else
                        esFuncion4 = true;
                        
                        
                }
                else
                {
                    throw new LexicalSimbolException("Deberia exisitr una funcion que inicia con'" + chars[i] +"' \nAl final de: " + paraInformarDondeEstaElError + "  Pero no hay mas caracteres.");
                }
                if ((i+3)<tamano)
                {
                    //TIENE QUE SER FUNCION DE CUARTO., PERO PREGUNTAMOS.
                    if(esFuncion4 && esFuncionCuarto(chars[i],chars[i+1],chars[i+2],chars[i+3]))
                    {
                        Ficha funcion = generaFichaFuncion(chars[i],chars[i+1],chars[i+2],chars[i+3]);
                        listaFinal.agregaFinal(funcion);
                        //Y NOS MOVEMOS.
                        i=i+3;
                        continue;
                        
                    }else
                    {
                        
                        throw new LexicalSimbolException("No es una funcion ni de tres caracteres ni de cuatro.'" + chars[i] + chars[i+1] +chars[+2] +chars[i+3]+"' \nAl final de: " + paraInformarDondeEstaElError + " ");
                    }
                        
                    
                }
                else{
                    
            
                    throw new LexicalSimbolException("Deberia exisitr una funcion que inicia con'" + chars[i]+ "' \nAl final de: " + paraInformarDondeEstaElError + "  Pero no hay mas caracteres.");
                }
            
                
            }
            
           // Si detectamosPunto
            else if(chars[i]=='.'){
//                
//                System.out.println("Aqui:"+lowerCase);
                
                    frontPointDetectedString += '0';
                    frontPointDetectedString += chars[i];

                
                if((i+1)>=tamano)
                {
                    
                    
                    frontPointDetectedString+='0';
                    
                    
                    
                    Ficha f = new Ficha(Simbolo.REAL,ReglaGramatical.__none,frontPointDetectedString);
                    listaFinal.agregaFinal(f);
                    frontPointDetectedString = "";
                    
                    
                }
                
                
                    frontPointDetected = true;
            }
            
            //Si detectamos VAR
            else if (chars[i]=='x')
            {
                listaFinal.agregaFinal( new Ficha(Ficha.Simbolo.VAR) );
            }
            
            
            else if (chars[i]=='(')
            {
                
                listaFinal.agregaFinal( new Ficha(Ficha.Simbolo.PAR_I));
            }
            
            else if (chars[i]==')')
            {
                
                listaFinal.agregaFinal( new Ficha(Ficha.Simbolo.PAR_D));
            }
            
            else if (chars[i]=='+')
            {
                
                listaFinal.agregaFinal( new Ficha(Ficha.Simbolo.MAS));
            }
            else if (chars[i]=='-')
            {
                
                listaFinal.agregaFinal( new Ficha(Ficha.Simbolo.MENOS));
            }
            else if (chars[i]=='*')
            {
                
                listaFinal.agregaFinal( new Ficha(Ficha.Simbolo.MULT));
            }
            else if (chars[i]=='/')
            {
                
                listaFinal.agregaFinal( new Ficha(Ficha.Simbolo.DIV));
            }
            else if (chars[i]=='^')
            {
                
                listaFinal.agregaFinal( new Ficha(Ficha.Simbolo.EXPO));
            }else{
                throw new LexicalSimbolException("Caracter no identificado. '" + chars[i] + "' \nAl final de: " + paraInformarDondeEstaElError);
                
            }
            
        }
        
        
        
            //Por cada ficha que encontremos esta se agregara a la lista de fichas.
        
            //De no encontrar fichas correspondiete lanzaremos una excepcion de Lexico.
        
        return listaFinal;
        

    }
    
    /* sin
     * sec
     * sqrt
     
     * tan
     
     * cos
     * csc
     * cot
     */
    private static boolean tieneQueSerFuncion(char c){
        
        
        boolean esN = false;
        if(c=='s')
            esN = true;
        else if(c=='t')
            esN = true;
        else if(c=='c')
            esN = true;
        
        return esN;

    }
    private static boolean esFuncionCuarto(char a,char b,char c,char d){
    
            return (a=='s' && b=='q' && c=='r' && d=='t');
    
    }
    private static Ficha generaFichaFuncion(char a,char b,char c,char d){
        
        Ficha f = null;
        if(a=='s' && b=='q' && c=='r' &&  d=='t');
        f= new Ficha(Simbolo.FUNCION,ReglaGramatical.__none,"sqrt");
        return f;
    }
    private static Ficha generaFichaFuncion(char a,char b,char c){
        Ficha f = null;
        if(a=='s' && b=='i' && c=='n')
            f= new Ficha(Simbolo.FUNCION,ReglaGramatical.__none,"sin");
        else if(a=='s' && b=='e' && c=='n')
            f= new Ficha(Simbolo.FUNCION,ReglaGramatical.__none,"sen");
        else if(a=='t' && b=='a' && c=='n')
            f= new Ficha(Simbolo.FUNCION,ReglaGramatical.__none,"tan");
        else if(a=='c' && b=='o' && c=='s')
            f= new Ficha(Simbolo.FUNCION,ReglaGramatical.__none,"cos");
        else if(a=='c' && b=='s' && c=='c')
            f= new Ficha(Simbolo.FUNCION,ReglaGramatical.__none,"csc");
        else if(a=='c' && b=='o' && c=='t')
            f= new Ficha(Simbolo.FUNCION,ReglaGramatical.__none,"cot");
        return f;
    }
    
    private static boolean esFuncion(char a,char b,char c){
        boolean esFuncion = false;
        if(a=='s' && b=='i' && c=='n')
            esFuncion = true;
        else if(a=='s' && b=='e' && c=='n')
            esFuncion = true;
        else if(a=='t' && b=='a' && c=='n')
            esFuncion = true;
        else if(a=='c' && b=='o' && c=='s')
            esFuncion = true;
        else if(a=='c' && b=='s' && c=='c')
            esFuncion = true;
        else if(a=='c' && b=='o' && c=='t')
            esFuncion = true;
            
        return esFuncion;
        
    }
    
    private static boolean esNumero(char c){
        boolean esN = false;
        if(c=='1')
            esN = true;
        else if(c=='2')
            esN = true;
        else if(c=='3')
            esN = true;
        else if(c=='4')
            esN = true;
        else if(c=='5')
            esN = true;
        else if(c=='6')
            esN = true;
        else if(c=='7')
            esN = true;
        else if(c=='8')
            esN = true;
        else if(c=='9')
            esN = true;
        else if(c=='0')
            esN = true;
        return esN;
            
    }
    /* Metemos las fichas en una pila.
     * @param l Lista con la fichas originales.
     * @return Pila con la fichas.
     */
    
    public static Pila<ArbolSintactico<Ficha>> convertir(Lista<Ficha> l)
    {
        
        Pila<ArbolSintactico<Ficha>> b = new Pila<ArbolSintactico<Ficha>> ();
        
        IteradorLista<Ficha> itr = l.iteradorLista();
        itr.end();

        while(itr.hasPrevious()){
            Ficha f =  itr.previous();
            b.mete(new ArbolSintactico<Ficha>(f));
            
        }
        return b;
            
    }
    
    
}
