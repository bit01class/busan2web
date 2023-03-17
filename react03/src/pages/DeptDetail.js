import axios from 'axios';
import React, { useEffect, useRef, useState } from 'react'
import { useNavigate, useParams } from 'react-router-dom'

export default function DeptDetail() {
  const navigate=useNavigate();
  const [edit,setEdit] =useState(false);
  const [bean,setBean] =useState({});
  const {deptno}=  useParams();
  const [dinput,setDinput] =useState({});
  const ref1=useRef();
  useEffect(()=>{
    axios.get('http://localhost:8080/api/'+deptno)
    .then(e=>{setBean(e.data); setDinput(e.data)});
  },[]);
  const input1=e=>{
    setDinput({...dinput,dname:e.target.value});
  };
  const input2=e=>{
    setDinput({...dinput,loc:e.target.value});
  };
  const editform=e=>{
    setEdit(true);
  };
  const sbt=e=>{
    e.preventDefault();
    const params={
            deptno:e.target.deptno.value,
            dname:e.target.dname.value,
            loc:e.target.loc.value
        };
    axios
    //.put('http://localhost:8080/api/'+deptno,params)
    ({
        method:'put',
        url:'http://localhost:8080/api/'+deptno,
        data:params
    })
    .then(e=>navigate('/dept/'));
  };
  const bck=e=>{
    
    alert(ref1.current.value);
    if(edit) setEdit(!edit);
    else navigate(-1);
  };
  const del=e=>{
    axios.delete('http://localhost:8080/api/'+deptno)
    .then(e=>navigate('/dept/'));
  }
  return (
    <>
    <div className="page-header">
        <h1>{!edit?'Detail':'Update'} page</h1>
    </div>
    <form onSubmit={sbt}>
        <div className="form-group">
            {!edit?bean.deptno:<input ref={ref1} value={bean.deptno} class="form-control" name='deptno' placeholder='deptno'/>}
        </div>
        <div className="form-group">
            {!edit?bean.dname:<input onChange={input1} value={dinput.dname} class="form-control" name='dname' placeholder='dname'/>}
        </div>
        <div className="form-group">
            {!edit?bean.loc:<input onChange={input2} value={dinput.loc} class="form-control" name='loc' placeholder='loc'/>}
        </div>
        <div className="form-group">
            {
            !edit?
            (<>
            <button onClick={editform} className='btn btn-primary btn-block' type='button'>수정</button>
            <button onClick={del} className='btn btn-danger btn-block' type='button'>삭제</button>
            </>)
            :<button className='btn btn-primary btn-block' type='submit'>수정</button>
            }
            <button className='btn btn-default btn-block' type='reset'>취소</button>
            <button onClick={bck} className='btn btn-default btn-block' type='button'>뒤로</button>
        </div>
    </form>
    </>
  )
}
