import React, { useState } from 'react'
import { Provider, useDispatch, useSelector } from 'react-redux';
import { createStore } from 'redux';

function reducer(prev={val:1},action){
    console.log(prev,action);
    if(action.type=='up') return {...prev,val:prev.val+1};
    if(action.type=='upup') return {...prev,val:prev.val+action.su};
    return {...prev};
}
const store=createStore(reducer);
export default function App2() {
  return (
    <Provider store={store}>
        <Comn3/>
        <Comn1/>
        <Comn2/>
    </Provider>
  )
}
function Comn3(){
    const dispatch=useDispatch();
    return <div><button onClick={e=>dispatch({type:'upup',su:10})}>클릭+2</button></div>
}
function Comn1(){
    const dispatch=useDispatch();
    return <div><button onClick={e=>dispatch({type:'up'})}>클릭+1</button></div>
}

function Comn2(){
    const su=useSelector(state=>state.val);
    return <div><h1>{su}</h1></div>
}
