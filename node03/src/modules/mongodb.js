var MongoClient = require('mongodb').MongoClient;
var url = "mongodb://127.0.0.1:27018/";

MongoClient.connect(url, function(err, db) {
  if (err) throw err;
  var dbo = db.db("mydb");
  coll=dbo.collection("dept");
//   dummy insert
//   var myobj = [
//     { deptno: 2222, dname: "물류팀",loc:"대전" }
//     ,{ deptno: 3333, dname: "영업팀",loc:"서울" }
//     ,{ deptno: 4444, dname: "생산팀",loc:"대구" }
//   ];
//   coll.insertMany(myobj, function(err, res) {
//     if (err) throw err;
//     console.log("Number of documents inserted: " + res.insertedCount);
//     db.close();
//   });
});

module.exports={MongoClient,url};