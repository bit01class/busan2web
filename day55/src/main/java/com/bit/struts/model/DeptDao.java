package com.bit.struts.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.apache.log4j.Logger;
import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import com.mongodb.client.result.UpdateResult;



public class DeptDao {
	Logger log=Logger.getLogger(this.getClass().getCanonicalName());
	final String DATABASENAME="lecture";
	final String COLLECTIONNAME="dept";
	List<ServerAddress> seeds=Arrays.asList(
			new ServerAddress("127.0.0.1", 27117),
			new ServerAddress("127.0.0.1", 27217),
			new ServerAddress("127.0.0.1", 27317)
			);

	public List<DeptVo> findAll(){
		List<DeptVo> list=new ArrayList<>();
		try(MongoClient client = new MongoClient(seeds);){
			MongoDatabase db = client.getDatabase(DATABASENAME);
			MongoCollection<Document> coll = db.getCollection(COLLECTIONNAME);
			FindIterable<Document> ite = coll.find();
			MongoCursor<Document> cur = ite.cursor();
			while(cur.hasNext()) {
				Document doc = cur.next();
				list.add(new DeptVo(
							doc.getObjectId("_id")
							,doc.getInteger("deptno")
							,doc.getString("dname")
							,doc.getString("loc")
						));
			}
		}
		log.debug(list.toString());
		return list;
	}

	public void addOne(int deptno, String dname, String loc) {
		try(
				MongoClient client=new MongoClient(seeds);
				){
			MongoCollection<Document> coll = client.getDatabase(DATABASENAME)
											.getCollection(COLLECTIONNAME);
			Document doc=new Document();
			doc.append("deptno", deptno);
			doc.append("dname", dname);
			doc.append("loc", loc);
			coll.insertOne(doc);
		}
	}
	
	public DeptVo findOne(String id) {
		DeptVo bean=null;
		ObjectId _id=new ObjectId(id);
		try(
				MongoClient client=new MongoClient(seeds);
				){
			MongoCollection<Document> coll = null;
			coll=client.getDatabase(DATABASENAME)
					.getCollection(COLLECTIONNAME);
			Bson filter=Filters.eq("_id", _id);
			FindIterable<Document> ite = coll.find(filter);
			Document doc = ite.first();
			bean = new DeptVo(
					doc.getObjectId("_id")
					,doc.getInteger("deptno")
					,doc.getString("dname")
					,doc.getString("loc")
					);
		}
		log.debug(bean.toString());
		return bean;
	}

	public long updateOne(String id, int deptno, String dname, String loc) {
		log.debug(id);
		try(
			MongoClient client=new MongoClient(seeds);	
				){
			MongoCollection<Document> coll=null;
			coll=client.getDatabase(DATABASENAME)
						.getCollection(COLLECTIONNAME);
			Bson update=Updates.combine(
					Updates.set("dname", dname)
					,Updates.set("loc", loc)
					);
			log.debug(update);
			UpdateResult result = null;
			result=coll.updateOne(Filters.eq("_id", new ObjectId(id))
					, update);
			return result.getModifiedCount();
		}
		
	}
}









