import React,{useState,useEffect} from 'react'
import { useNavigate } from 'react-router-dom';

export default function Ex03(props) {
    const navigate=useNavigate();
    const [msg,setMsg]=useState(1);
    useEffect(()=>{
        // setTimeout(() => {
        //     setMsg(msg+1);
        // }, 1000);
        //console.log(msg);
    },[msg]);
    return (
        <div>
            <h1>{msg}</h1>
            <button onClick={e=>{
                navigate(-1);
            }}>바꿈</button>
        </div>
    )
}
