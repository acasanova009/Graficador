package mx.unam.ciencias.edd;

/**
 * Clase para excepciones caracteres lexicos no validos de mi gramatica.
 */
public class AxiomaticSimbolException extends IllegalArgumentException {

    /**
     * Constructor vacío.
     */
    public AxiomaticSimbolException() {
        super();
    }

    /**
     * Constructor que recibe un mensaje para el usuario.
     * @param mensaje un mensaje que verá el usuario cuando ocurra
     *                la excepción.
     */
    public AxiomaticSimbolException(String mensaje) {
        super(mensaje);
    }
}
