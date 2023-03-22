import { useSelector } from "react-redux";

export default function Comn2(){
    const su=useSelector(state=>state.val);
    return <div><h1>{su}</h1></div>
}