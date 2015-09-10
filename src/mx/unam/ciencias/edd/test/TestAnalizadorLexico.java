package mx.unam.ciencias.edd.test;

//import java.util.Iterator;
import java.util.NoSuchElementException;
import java.util.Random;
import mx.unam.ciencias.edd.ExcepcionIndiceInvalido;
import mx.unam.ciencias.edd.IteradorLista;
import mx.unam.ciencias.edd.Lista;
import mx.unam.ciencias.edd.AnalizadorLexico;
import mx.unam.ciencias.edd.Ficha;
import org.junit.Assert;
import org.junit.Test;

/**
 * Clase para pruebas unitarias de la clase {@link AnalizadorLexico}.
 */
public class TestAnalizadorLexico {

    private Random random;
    private int total;

    private Lista<Ficha> fichas;

    /**
     */
    public TestAnalizadorLexico() {
        random = new Random();
        total = 10 + random.nextInt(90);

        fichas = new Lista<Ficha>();
    }
    /**
     * Prueba unitaria para {@link AnalizadorLexico#analizarLexico}.
     */
    @Test public void testAnalizarLexico() {
        
        String fixedString;
        Ficha f;
        Lista<Ficha> lf;
        Ficha primera;

        
        fixedString = "123";
        f = new Ficha("123");
        lf = AnalizadorLexico.analizarLexico(fixedString);
        primera = lf.getPrimero();
        
        Assert.assertTrue(primera.getValor() == f.getValor());
        Assert.assertTrue(primera.getToken() == f.getToken());
        
        fixedString = "-123";
        f = new Ficha("-");
        lf = AnalizadorLexico.analizarLexico(fixedString);
         primera = lf.getPrimero();
        
        Assert.assertTrue(primera.getValor() == f.getValor());
        Assert.assertTrue(primera.getToken() == f.getToken());
        
        fixedString = "^12";
        f = new Ficha("^");
        lf = AnalizadorLexico.analizarLexico(fixedString);
         primera = lf.getPrimero();
        
        Assert.assertTrue(primera.getValor() == f.getValor());
        Assert.assertTrue(primera.getToken() == f.getToken());
        
        fixedString = "-1+2*3/4^5";
        for(int i=0; i<10;i++){
            if((i%2)==0)
                fichas.agregaFinal(new Ficha("+"));
            else
                fichas.agregaFinal(new Ficha("1"));
            
        }
        Assert.assertTrue(fichas.getLongitud()==AnalizadorLexico.analizarLexico(fixedString).getLongitud());
        
        
        
        
//        fichas = new Lista<Ficha>();
//        String[] arreglo = new String[total];
        String parentesis = "";
        for (int i = 0; i < total; i++) {
            parentesis+="(";
        }
        
        Assert.assertTrue(AnalizadorLexico.analizarLexico(parentesis).getLongitud()==total);
        
        
        
//        String[] arreglo = new String[total];
         parentesis = "";
        for (int i = 0; i < total; i++) {
            parentesis+="&";
        }
        Assert.assertTrue(AnalizadorLexico.analizarLexico(parentesis).getLongitud()==0);
        
        
        
        
        
        
        
    }
}
