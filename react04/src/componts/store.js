import { createStore } from "redux";

function reducer(prev={val:1},action){
    console.log(prev,action);
    if(action.type=='up') return {...prev,val:prev.val+1};
    if(action.type=='upup') return {...prev,val:prev.val+action.su};
    return {...prev};
}
const store=createStore(reducer);

export default store;