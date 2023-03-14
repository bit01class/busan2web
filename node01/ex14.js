var fs=require('fs');
try{
    fs.rmdir('js02');
}catch(e){
    console.error(e);    
}