var crypto=require('crypto');
var key='mykey';
var msg='abcdefg';

var hash=crypto.createHash('MD5');
hash.update(msg+key);

console.log(hash.digest('hex'));