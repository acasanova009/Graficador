 
package mx.unam.ciencias.edd;

import java.util.Iterator;
import java.util.NoSuchElementException;
import mx.unam.ciencias.edd.Gramatica.ReglaGramatical;
import mx.unam.ciencias.edd.Ficha.Simbolo;

/**
 * <p>El analizador sintactico permite dada una lista de fichas, verificar la sintaxis de esta lista.
 * Lo hace a partir del algoritmo de construccion ascendente con retroceso.
 * El cual tiene una complejidad a lo menos <i>O</i>(<i>n*n</i>)</p>
 *
 */
public class AnalizadorSintactico{

    
    private ArbolSintactico<Ficha>root;
    private Lista<Gramatica> gramaticas;
    public AnalizadorSintactico(){
        root = new ArbolSintactico<Ficha>(new Ficha(Ficha.Simbolo.S));
        gramaticas = new Lista<Gramatica>();
        for (ReglaGramatical rG : ReglaGramatical.values()) {
            if(rG == ReglaGramatical.__none )//|| rG==ReglaGramatical._1_S_E)
                continue;
            gramaticas.agregaFinal(new Gramatica(rG));
        }
    }
   
    /* A partir de una pila de fichas b, que proviene del analizador lexico, analizaremos las
     * posibles derivaciones. Se usara el algoritmo de construccion acendente con retroceso.
     *
     * @param a Lista contenedora las derivaciones.
     * @param b Pila que contiene las fichas originales.
     * @param t ArbolRetroceso, nos permitira guardar todos los posibles caminos de reglasGramaticales,
     * aunque solo uno sea efectivo.
     * @return <tt>true</tt> las fichas de b eran sintacticamente correcta. Y el arbol-final estara como
     * unico elemento en la lista -a.
     *         <tt>false</tt> en otro caso.

     */
    public boolean analizar(Lista<ArbolSintactico<Ficha>> a, Pila<ArbolSintactico<Ficha>> b, ArbolRetroceso<Gramatica> t){
        
        //Por cada derivacion de fichas de las 16 derivaciones, que estan en mi Gramatica, le intentaremos aplicar la regla -r a las ultimas 4-posibles fichas de la lista -a. 4, ya que nuestra derivacion mas grande contiene 4 fichas.
        
        
        //Por cada -r reglaGramatical
        for (Gramatica g: gramaticas){
            

            
//            System.out.print("AB:" +a+"#"+b+"  T: "+t +" \n\n");
            //Si la -r, aun no se registra en -t. Y las ultimas fichas de -a, son producibles por r.
            if(!t.elementoYaFueRegistrado(g) && Gramatica.sePuedeDerivar(a.getUltimos(4),g.getRegla())){
                
                
                //***Derivamos -a en -r. Y -r la registraremos en -t.
                root.derivar(Gramatica.getFichaForGramatica(g.getRegla()),g.getRegla(),a);
                t.registrar(g);
                
                
                
//                System.out.println("\n\n\nAB:" +a+"#"+b+"");
                //Si la lista -a, es el axioma inicial, y la pila -b esta vacia.
                if(a.getLongitud()==1 && b.esVacia()){
                    
                    ArbolSintactico<Ficha> last = a.getUltimo();
                                        
                    if(last.esArbolRaiz())
                        return true;
                }
                //Analizamos.
                return analizar(a,b,t);
            }
            
//
        }
        //Si ninguna regla -r es aplicable y -b no es vacia.
       if (!b.esVacia()){
            //
            //                //Desplazamos. de -a a -b
            a.agregaFinal(b.saca());
            ////                //Analizamos.
            return analizar(a,b,t);
        }
        
        //Al llegar aqui significa:
        //El camino que tomamos fue insuficiente para satisfacer la gramatica para llegar al aixoma inicial.
        
        
        
//        System.out.println("SALDIO DE LAS GRAMATICAS.");
        //Si t tiene mas reglasGramaticales. //Podemos buscar otros caminos.
        if(t.hayMasPosiblesCaminos())
        {
//            System.out.println("HAY OTROS CAMINOS");
            //+De -a tener simbolos terminales, los regresamos a -b.
            regresaTerminales(a,b);
            
            //Para la ultima regla -r en -t. Produciremos a -r en -a, y nos moveremos sobre t uno hacia atras.
            Gramatica r =  t.regresar();
            ArbolSintactico<Ficha> aProductor = a.getUltimo();
            a.eliminaUltimo();
            
            
//            System.out.print("Reduciendo a aProductor: "+aProductor.toString() );
            Lista<ArbolSintactico<Ficha>> ver = aProductor.reducir();
//            System.out.print(" Con:" + ver.toString()+"\n\n\n");
            for(ArbolSintactico<Ficha> hijo :ver)
                a.agregaFinal(hijo);
            
            
//            System.out.println("AB:" +a+"#"+b+"\n\n");

            
            
            //+De -a tener simbolos terminales, los regresamos a -b.
            
            regresaTerminales(a,b);
            //analizamos nuevamente.
            return analizar(a,b,t);
            
        }
        
            // No hay mas caminos en t por encontrar.
            //Y consideramos a esta expresion, sintacticamente incorrecta.
            //La derivacion fallo.
         
        
        return false;
        
        
        
    }
    
    
    private void regresaTerminales(Lista<ArbolSintactico<Ficha>>a, Pila<ArbolSintactico<Ficha>>b){
        IteradorLista<ArbolSintactico<Ficha>> itr = a.iteradorLista();
        itr.end();
        boolean sigueSiendoTermianl = true;
        int i = 0;
        while(itr.hasPrevious()){
            
            ArbolSintactico<Ficha> as =  itr.previous();
            if(as.getFicha().esTerminal() && sigueSiendoTermianl)
            {
                b.mete(as);
                i++;
            }
            else
            {
                sigueSiendoTermianl =false;
            }
            
        }
        a.extraerUltimos(i);
    }
    
    
    

}
