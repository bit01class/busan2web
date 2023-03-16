import React,{ useState } from "react";

export default function Ex02() {
  const [title,setTitle]=useState('제목없음');
  const [ipval,setIpval]=useState(["",'']);

  const func01=(e)=>{
    e.preventDefault();
    setTitle(e.target.ename.value);
  };
  const func02=(e)=>{
    if(e.target.name=='ename')
        setIpval([e.target.value,ipval[1]]);
    else if(e.target.name=='ename2')
            // setIpval([ipval[0],e.target.value]);
        setIpval(ipval.map((ele,idx)=>idx==1?e.target.value:ele));
  };
  return (
    <form onSubmit={func01}>
        <h1>{title}</h1>
        <input name="ename" onChange={func02} value={ipval[0]}/>
        <input name="ename2" onChange={func02} value={ipval[1]}/>
        <button>전송</button>
    </form>
  )
}
