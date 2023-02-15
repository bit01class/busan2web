package com.bit.model;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.bson.Document;
import org.bson.conversions.Bson;
import org.bson.types.ObjectId;

import com.mongodb.MongoClient;
import com.mongodb.ServerAddress;
import com.mongodb.client.FindIterable;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoCollection;
import com.mongodb.client.MongoCursor;
import com.mongodb.client.MongoDatabase;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;


public class EmpDao {
	com.mongodb.client.MongoClient client;
	String URL="mongodb://root:mongo@localhost:27018/";
	String DBNAME="lecture";
	String COLNAME="emp";
	
	public void updateOne(EmpDto bean) {
		client=MongoClients.create(URL);
		MongoDatabase db = client.getDatabase(DBNAME);
		MongoCollection<Document> col = db.getCollection(COLNAME);
		
		Bson filter=Filters.eq("_id", bean.getId());
		List<Bson> list=Arrays.asList(
							Updates.set("ename", bean.getEname())
							,Updates.set("sal",bean.getSal())
							,Updates.set("job",bean.getJob())
							,Updates.set("hiredate",bean.getHiredate())
						);
		
		col.updateOne(filter, list);
		client.close();
	}
	
	public EmpDto selectOne(ObjectId _id) {
		EmpDto bean=new EmpDto();
		client=MongoClients.create(URL);
		MongoDatabase db = client.getDatabase(DBNAME);
		MongoCollection<Document> col = db.getCollection(COLNAME);
//		Bson filter=new Document("_id",_id);
		// where id=1234;
		Bson filter=Filters.eq("_id", _id);
		// where sal>1000 and sal<2000;
		Bson filter2=Filters.and(Filters.gt("sal", 1000),Filters.lt("sal", 2000));
		
		FindIterable<Document> ite=col.find(filter);
		Document doc=ite.first();
		bean.setId(doc.getObjectId("_id"));
		bean.setEmpno(doc.getInteger("empno"));
		bean.setEname(doc.getString("ename"));
		bean.setHiredate(doc.getDate("hiredate"));
		bean.setJob(doc.getString("job"));
		bean.setSal(doc.getInteger("sal"));
		client.close();
		System.out.println(bean);
		return bean;
	}
	
	public void insertOne(EmpDto bean) {
		com.mongodb.client.MongoClient client;
		client=MongoClients.create("mongodb://localhost:27018/");
		MongoDatabase dbs = client.getDatabase("lecture");
		MongoCollection<Document> col = dbs.getCollection("emp");
		
		Document doc=new Document();
		doc.append("empno", bean.getEmpno());
		doc.append("ename", bean.getEname());
		doc.append("hiredate", bean.getHiredate());
		doc.append("sal", bean.getSal());
		doc.append("job", bean.getJob());
		col.insertOne(doc);
		client.close();
	}

	public List<EmpDto> selectAll(){
		List<EmpDto> list=new ArrayList<>();
		client=MongoClients.create(URL);
		MongoDatabase db = client.getDatabase(DBNAME);
		MongoCollection<Document> col = db.getCollection(COLNAME);
		FindIterable<Document> rs = col.find();
		MongoCursor<Document> ite = rs.iterator();
		while(ite.hasNext()) {
			Document doc=ite.next();
			EmpDto bean=new EmpDto();
			bean.setId(doc.getObjectId("_id"));
			bean.setEmpno(doc.getInteger("empno"));
			bean.setEname(doc.getString("ename"));
			bean.setHiredate(doc.getDate("hiredate"));
			bean.setJob(doc.getString("job"));
			bean.setSal(doc.getInteger("sal"));
			list.add(bean);
			System.out.println(bean);
		}
		client.close();
		return list;
	}
}









