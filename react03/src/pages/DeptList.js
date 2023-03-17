import axios from 'axios';
import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

export default function DeptList() {
    const [depts,setDepts]=useState([]);
    
    useEffect(()=>{
        // const getList=new Promise(function(resolve,reject){
        //     const xhr=new XMLHttpRequest();
        //     xhr.onload=function(e){
        //         if(xhr.status==200){
        //             const result=JSON.parse(xhr.response);
        //             resolve(result);
        //         }else{
        //             reject(xhr.status);
        //         }
        //     };
        //     xhr.open('get','http://localhost:8080/api/');
        //     xhr.send();
        // });
        // getList.then(e=>console.log(e));
        // const getList=new Promise((resolve,reject)=>{
        //     setTimeout(() => {
        //         resolve('3초뒤 호출됨');
        //     }, 3000);
        // });
        // let p=getList
        // .then((data)=>{
        //     console.log('step1');
        //     return data;
        // })
        // .then((e)=>{
        //     console.log('step2');
        //     console.log(e);
        // })
        // ;
        // fetch('http://localhost:8080/api/')
        // .then(e=>(e.json()))
        // .then(e=>setDepts(e))
        // .catch(e=>console.log(e))
        // ;
        //////////
        axios.get('http://localhost:8080/api/')
        .then(e=>setDepts(e.data))
    },[]);

  

  return (
    <>
    <div className="page-header">
        <h1>Dept List</h1>
    </div>
    <Link to='add' className='btn btn-primary btn-block' role="button">add</Link>
    {depts.map((ele)=>(
    <Link to={'./'+ele.deptno}>
        <div className="panel panel-primary">
            <div className="panel-heading">{ele.dname}</div>
            <div className="panel-body">{ele.loc}</div>
        </div>
    </Link>
    ))}
    </>
  )
}
