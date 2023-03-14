var query=require('querystring');

var msg='where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=node';

console.log(query.parse(msg));
console.log(query.stringify(query.parse(msg)));