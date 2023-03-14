var event=require('events');

var obj=new event.EventEmitter();
var cb=function(e){
    console.log('이벤트 발생1');
};
obj.on('call1',cb);
obj.on('call2',function(e){
    obj.off('call1',cb);
    console.log('이벤트 발생2');
});
obj.on('call3',function(e){
    console.log('이벤트 발생3');
});

obj.emit('call1');
obj.emit('call2');
obj.emit('call1');
obj.emit('call2');