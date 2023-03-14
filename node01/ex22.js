var http=require('http');
var url=require('url');
var fs=require('fs');

var serv=http.createServer(function(req,res){
    // console.log(url.parse(req.url).path);
    // console.log(url.parse(req.url,true).query.id);
    res.writeHead(200, {'Content-Type': 'text/html'});
    // res.write('<h1>abcd</h1>');
    // res.write(msg);
    fs.readFile('ex22.html',function(err,data){
        res.write(data);
        res.end();
    });
});

serv.listen(3000,function(){
    console.log('server start...');
});