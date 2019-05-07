import React, {Component} from 'react'
import './css/nav.css';

class NavBar extends Component{
  render(){
    return(
      <nav className="navbar navbar-expand navbar-dark bg-dark">
      <a className="navbar-brand"><h2 className="gft">Agentes y Vias</h2></a>
      <button className="navbar-toggler" type="button">
        <span className="navbar-toggler-icon"></span>
      </button>

      <div className="collapse navbar-collapse" id="navbarsExample02">
        <ul className="navbar-nav mr-auto">
          <li className="nav-item active">
            <a className="nav-link" href="/">Home</a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="/Agentes">Agentes de Transito</a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="/Vias">Vías</a>
          </li>
          <li className="nav-item">
            <a className="nav-link" href="/Historico">Historico General</a>
          </li>
        </ul>
      </div>
    </nav>

    )
  }
}
export default NavBar;
