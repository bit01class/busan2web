import React from "react";
import "./App.css";

class H2 extends React.Component {
    constructor(props){
        super(props);
        this.msg=props.msg2;
        this.state = {brand: "Ford",model: 1111,};
    }
    componentDidMount() {
        // 페이지 로딩 후
        // setTimeout(() => {
        //   const obj=this.state;
        //   this.setState({...obj,brand: "기아"})
        // }, 1000)
    }
    componentDidUpdate() {
        setTimeout(() => {
            const obj=this.state;
            let su=obj.model;
            this.setState({...obj,model: su+1})
        }, 1000)
    }
    render() {
      return (<>
      <h2>{this.state.brand} - {this.state.model}, {this.msg}!</h2>
      <button onClick={()=>{
        const obj=this.state;
        this.setState({...obj,brand: "현대"});
      }}>클릭</button>
      </>);
    }
  }

function Ex02({sub,msg}){

    return (
    <>
        <h1 className='cl01'>{sub}</h1>
        <p>{msg}</p>
    </>);
}

const Ex03=()=>{
    const func01=(e)=>{
        console.log(e.target.value);
    };
    return (
        <div>
        <button onClick={()=>{
            alert('클릭');
        }}>버튼</button>
        <button onClick={func01}>클릭2</button>
        <button onClick={func01}>클릭3</button>
        <input onChange={func01}/>
        </div>
    );
};

function Garage(props) {
    const cars = props.cars;
    return (
      <>
        <h1>Garage</h1>
        {cars.length > 0 ?(
          <h2>
            You have {cars.length} cars in your garage.
          </h2>
            ):null
        }
      </>
    );
  }
  

function Ex01(){

    let msg='Ex01 page';

    // return <h1> {msg} function을 이용한 엘리먼트</h1>;
    // return React.createElement('h1', {}, 'I do not use JSX!');
    const cars = ['현대','기아','쌍용'];
    return(
        <React.Fragment>
        {/* 
        <Ex02 sub="한글" msg="환영합니다"/>
        <Ex02 sub="영어" msg="welcome.."/>
        <H2 msg2="클래스 방식"/>
        <Ex03/> 
        <Garage cars={cars} />
        */}
        <ul>
            {cars.map((ele,idx)=><li key={idx}>{ele}</li>)}
        </ul>

        </React.Fragment>
    );

}

export default Ex01;
