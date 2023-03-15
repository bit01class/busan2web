var express = require('express');
var router = express.Router();
var session = require('express-session');
var pool=require('../modules/mysql');

router.use(session({
  secret: 'keyboard cat',
  resave: false,
  saveUninitialized: true,
  cookie: { secure: false,maxAge: 60000 }
}));

/* GET users listing. */
router.get('/login',(req,res)=>{
  req.session.login='admin';
  res.status(200).end();
});

var login=(req,res,nxt)=>{
  if(req.session.login) nxt();
  else res.status(403).end();
};
//router.use('/',login);

router.get('/',login, function(req, res, next) {
    const sql="select * from dept";
    const query = pool.query(sql,(err,results,fields)=>{
      res.status(200).json(results);
    });
});
router.post('/',(req,res)=>{
  const deptno=req.body.deptno;
  const dname=req.body.dname;
  const loc=req.body.loc;
  const sql=`insert into dept values (${deptno},'${dname}','${loc}')`;
  pool.query(sql,(err)=>{
    if(err) return res.status(500).end();
    res.status(200).end();
  });
});
router.get('/:deptno',(req,res)=>{
  const deptno=req.params.deptno;
  const sql=`select * from dept where deptno=${deptno}`;
  const query=pool.query(sql);
  query
      .on('error', function(err) {
        console.log(err);
      })
      .on("result",function(row){
        res.status(200).json(row);
      });
});


module.exports = router;
