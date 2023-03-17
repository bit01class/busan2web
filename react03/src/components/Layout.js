import React from 'react'
import { Link, NavLink, Outlet } from 'react-router-dom'

export default function Layout() {
  return (
    <>
    <nav className="navbar navbar-inverse">
        <div className="container-fluid">
            <div className="navbar-header">
            <button type="button" className="navbar-toggle collapsed" data-toggle="collapse" data-target="#bs-example-navbar-collapse-1" aria-expanded="false">
                <span className="sr-only">Toggle navigation</span>
                <span className="icon-bar"></span>
                <span className="icon-bar"></span>
                <span className="icon-bar"></span>
            </button>
            <Link className="navbar-brand" to="/">Brand</Link>
            </div>

            <div className="collapse navbar-collapse" id="bs-example-navbar-collapse-1">
            <ul className="nav navbar-nav">
                <li><NavLink to='/' className={({ isActive, isPending }) =>isPending ? "pending" : isActive ? "active" : ""} end>Home</NavLink></li>
                <li><Link to='/intro' className={({ isActive, isPending }) =>isPending ? "pending" : isActive ? "active" : ""} end>Intro</Link></li>
                <li><Link to='/dept/' className={({ isActive, isPending }) =>isPending ? "pending" : isActive ? "active" : ""}>Dept</Link></li>
            </ul>
            </div>
        </div>
    </nav>
    <div className='container'>
        <Outlet/>
    </div>
    </>
  )
}
