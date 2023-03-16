import React from 'react';
import { Outlet, Link } from "react-router-dom";

export default function Nav() {
  return (
    <div>
        <nav className="navbar navbar-default">
            <div className="container-fluid">
                <div className="navbar-header">
                <Link className="navbar-brand" to="/">
                    <div>비트교육센터</div>
                </Link>
                </div>
                <div className="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
                    <ul className="nav navbar-nav">
                        <li className="active"><Link to='/'>Home</Link></li>
                        <li><Link to='/add'>Intro</Link></li>
                        <li><Link to='/list'>DEPT</Link></li>
                        <li><Link to='/detail'>Login</Link></li>
                    </ul>
                </div>
            </div>
        </nav>
        <div  className="container">
            <Outlet />
        </div>
    </div>
  )
}
