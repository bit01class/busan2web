import React, { useEffect, useState } from 'react'
import { Link } from 'react-router-dom'

export default function DeptList() {
  const [list,setList]=useState([]);
  useEffect(()=>{
    // const dummy=[
    //   {deptno:1111,dname:'tester',loc:'test1'}
    //   ,{deptno:2222,dname:'tester',loc:'test2'}
    //   ,{deptno:3333,dname:'tester',loc:'test3'}
    //   ,{deptno:4444,dname:'tester',loc:'test4'}
    // ];
    fetch('http://localhost:8080/api/v1/')
        .then((response) => {
          console.log('resp',response);
          return response.json()
        })
        .then((data) =>{ 
          console.log(typeof data, data);
         setList(data);
        });

    // setList(dummy);
  },[]);
  return (
    <>
    <div className={list.length?'':'glyphicon glyphicon-refresh'}></div>
    <div className="page-header">
      <h1>list page</h1>
    </div>
    <table className='table'>
      <thead>
        <tr>
          <th>deptno</th>
          <th>dname</th>
          <th>loc</th>
        </tr>
      </thead>
      <tbody>
        {/*         
        <tr>
          <td><Link to="/detail">1111</Link></td>
          <td><Link to="/detail">test</Link></td>
          <td><Link to="/detail">test</Link></td>
        </tr>
        */}
        {
          list.map(ele=>(
          <tr key={ele.deptno}>
            <td><Link to="/detail">{ele.deptno}</Link></td>
            <td><Link to="/detail">{ele.dname}</Link></td>
            <td><Link to="/detail">{ele.loc}</Link></td>
          </tr>
          ))
        }
      </tbody>
    </table>
    
    </>
  )
}
