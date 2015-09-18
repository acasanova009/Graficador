package mx.unam.ciencias.edd;

/**
 * Clase para excepciones caracteres lexicos no validos de mi gramatica.
 */
public class LexicalSimbolException extends IllegalArgumentException {

    /**
     * Constructor vacío.
     */
    public LexicalSimbolException() {
        super();
    }

    /**
     * Constructor que recibe un mensaje para el usuario.
     * @param mensaje un mensaje que verá el usuario cuando ocurra
     *                la excepción.
     */
    public LexicalSimbolException(String mensaje) {
        super(mensaje);
    }
}
