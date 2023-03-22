import { useDispatch } from "react-redux";

export default function Comn1(){
    const dispatch=useDispatch();
    return <div><button onClick={e=>dispatch({type:'up'})}>클릭+1</button></div>
}