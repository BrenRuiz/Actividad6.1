package javamongodsm501;

/**
 *
 * @author brenr
 */
public class JavaMongoDSM501 {

    public static void main(String[] args) {
        Conexion connection = new Conexion();
        
        System.out.println("");
        System.out.println("Right now your books are in status:");
        connection.show();
        
        System.out.println("");
        System.out.println("A new book has been added:");
        connection.insert("Leyendo");
        connection.show();
        
        System.out.println("");
        System.out.println("The book's status has been changed:");
        connection.update("Leyendo", "Leído");
        connection.show();
        
        System.out.println("");
        System.out.println("The book has been removed:");
        connection.delete("Leído");
        connection.show();
    }
}


