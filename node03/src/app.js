const express = require('express');
var path = require('path');
var ejs = require('ejs');
const rootRouter=require('./routers');
const deptRouter=require('./routers/dept');

var app = express();
app.use(express.static(path.join(__dirname, '../public')));
app.set('views', path.join(__dirname, '../views'));
app.set('view engine', 'ejs');

app.use(express.urlencoded({extended:false}));

app.use('/',rootRouter);
app.use('/dept',deptRouter);

app.listen(3000);