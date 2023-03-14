var url=require('url');
var msg="https://search.naver.com/search.naver?where=nexearch&sm=top_hty&fbm=1&ie=utf8&query=node";

console.log(url.parse(msg).protocol);
console.log(url.parse(msg).host);
console.log(url.parse(msg).port);
console.log(url.parse(msg).path);
console.log(url.parse(msg,true).query);
console.log(url.parse(msg).auth);
console.log(url.parse(msg).href);
console.log('--------------------------------');
console.log(url.format(url.parse(msg)));
console.log('--------------------------------');
console.log(url.resolve('https://m.naver.com','dept'));