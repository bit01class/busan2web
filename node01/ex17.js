var fs=require('fs');


fs.writeFileSync('temp02.txt','두번째 파일 작성');


var msg=fs.readFileSync('temp02.txt','utf-8');
console.log(msg);