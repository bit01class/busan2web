const mysql = require('mysql');
const pool  = mysql.createPool({
  connectionLimit : 10,
  host: '192.168.99.103',
  user: 'scott',
  password: 'tiger',
  database: 'mydb'
});

module.exports=pool;
