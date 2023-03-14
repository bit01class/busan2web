var http=require('http');
var url=require('url');
var fs=require('fs');


http.createServer(function(req,res){
    var obj=url.parse(req.url,true);
    if(obj.path=='/index.html')
        res
        .writeHead(200, {'Content-Type': 'text/html'})
        .end(fs.readFileSync(__dirname+'/js02/index.html'));
    else if(obj.path=='/ex01.html')
        res
            .writeHead(200, {'Content-Type': 'text/html'})
            .end(fs.readFileSync(__dirname+"/js02/ex01.html"));
    else{
        res
            .writeHead(404, {'Content-Type': 'text/html'})
            .end(fs.readFileSync(__dirname+"/js02/err.html"))
        ;
    }
}).listen(3000);