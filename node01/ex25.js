var mysql=require('mysql');

var conn=mysql.createConnection({
    host: "192.168.99.103",
    user: "scott",
    password: "tiger",
    database: 'lecture'
});

conn.connect(function(err){
    if(err) throw err;
    console.log('conected..');
});