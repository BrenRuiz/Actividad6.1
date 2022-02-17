
package javamongodsm501;

import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBCursor;
import com.mongodb.Mongo;
import java.net.UnknownHostException;
import java.util.logging.Level;
import java.util.logging.Logger;

/**
 *
 * @author brenr
 */
public class Conexion {
    DB dataBase;
    DBCollection collection;
    BasicDBObject document = new BasicDBObject();
    
    public Conexion() {
        try {
            Mongo mongo = new Mongo("localhost",27017);
            dataBase = mongo.getDB("books501");
            collection = dataBase.getCollection("books501");
            System.out.println("Established connection");
        } catch(UnknownHostException ex) {
            Logger.getLogger(Conexion.class.getName()).log(Level.SEVERE,null,ex);
        }
    }
    
    public boolean insert(String estatus) {
        document.put("estatus",estatus);
        collection.insert(document);
        return true;
    }
    
    public void show() {
        DBCursor cursor = collection.find();
        while(cursor.hasNext()) {
            System.out.println(cursor.next());
        }
    }
    
    public boolean update(String oldest, String newest) {
        document.put("estatus", oldest);
        BasicDBObject newDocument = new BasicDBObject();
        newDocument.put("estatus", newest);
        collection.findAndModify(document, newDocument);
        return true;
    }
    
    public boolean delete(String estatus) {
        document.put("estatus", estatus);
        collection.remove(document);
        return true;
    }
}


