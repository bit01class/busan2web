import React from 'react';
import ReactDOM from 'react-dom/client';
import './index.css';
import App from './App';
import DeptAdd from './pages/DeptAdd';
import DeptList from './pages/DeptList';
import DeptDetail from './pages/DeptDetail';
import reportWebVitals from './reportWebVitals';
import { Route, Routes, BrowserRouter} from 'react-router-dom';
import Nav from './Nav';


const root = ReactDOM.createRoot(document.getElementById('root'));
root.render(
  <BrowserRouter>
    <Routes>
      <Route path="/" element={<Nav/>}>
        <Route index element={<App />}/>
        <Route path='list' element={<DeptList />}/>
        <Route path='add' element={<DeptAdd />}/>
        <Route path='detail' element={<DeptDetail />}/>
      </Route>
    </Routes>
  </BrowserRouter>
  // <React.StrictMode>
  // </React.StrictMode>
);

// If you want to start measuring performance in your app, pass a function
// to log results (for example: reportWebVitals(console.log))
// or send to an analytics endpoint. Learn more: https://bit.ly/CRA-vitals
reportWebVitals();
