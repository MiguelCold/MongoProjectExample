package co.edu.udea.proyectmongodb.code;

import java.net.UnknownHostException;
import com.mongodb.BasicDBObject;
import com.mongodb.DB;
import com.mongodb.DBCollection;
import com.mongodb.DBObject;
import com.mongodb.Mongo;
import com.mongodb.WriteResult;

public class MongoManager {
	
	private Mongo mongo = null;
	private DB database = null;
	private DBCollection collection = null;
 	
	
	public MongoManager(){
		try {
			mongo = new Mongo("localhost", 27017);
		} catch (UnknownHostException e) {
			e.printStackTrace();
		}
		if(!mongo.equals(null)){
			database = mongo.getDB("dbexample");
			collection = database.getCollection("employee");
		}
	}

	public WriteResult save(BasicDBObject document){
	    return collection.insert(document);
	}

	public DBObject find(BasicDBObject document){
	    return collection.findOne(document);
	}

}
