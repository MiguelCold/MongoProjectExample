package co.edu.udea.proyectmongodb.test;

import java.util.Date;

import static org.junit.Assert.*;

import org.junit.Test;

import co.edu.udea.proyectmongodb.code.MongoManager;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;


public class TestMongoDB {

	@Test
	public void testSave(){
		BasicDBObject document = new BasicDBObject();
		document.put("nombre", "Miguel");
		document.put("apellidos", "Ossa Ruiz");
		document.put("años", 23);
		document.put("fecha", new Date());
		MongoManager prueba = new MongoManager();
		prueba.save(document);
		DBObject objectToFind = prueba.find(document);
		assertEquals("Miguel", (objectToFind.get("nombre")).toString());
	}
	
}
