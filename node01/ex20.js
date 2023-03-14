var fs=require('fs');

fs.readdir('.',function(err,files){
    files.forEach(function(ele,idx){
        console.log(ele);
    });
});