import { BrowserRouter, Route, Routes } from "react-router-dom";
import Layout from "./components/Layout";
import DeptAdd from "./pages/DeptAdd";
import DeptDetail from "./pages/DeptDetail";
import DeptList from "./pages/DeptList";
import Home from "./pages/Home";
import Intro from "./pages/Intro";


function App() {
  return (
    <BrowserRouter>
    <Routes>
      <Route path="/" element={<Layout />}>
        <Route index element={<Home />} />
        <Route path="intro" element={<Intro />} />
        <Route path="dept/" element={<DeptList/>} />
        <Route path="dept/add" element={<DeptAdd/>} />
        <Route path="dept/:deptno" element={<DeptDetail/>} />
      </Route>
    </Routes>
  </BrowserRouter>
  );
}

export default App;
