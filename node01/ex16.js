var fs=require('fs');

fs.writeFile('temp01.txt','한글작성',function(err){
    console.log(err);
});

fs.readFile('temp01.txt',function(err,data){
    console.log(data.toString('utf-8'));
});