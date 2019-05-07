import React, { Component } from 'react';
import './css/producto-style.css';
import {Link} from 'react-router-dom';
import axios from 'axios'
class Via extends Component{
    deleteVia=()=>{
      axios.delete('http://localhost:8080/s1_Agentes_Vias-api/api/vias/'+this.props.data.id)
      .then(()=>{
      window.location.href = 'http://localhost:3000/Vias';
      });
    }
  render(){
    return(
      <tr>
        <th scope="row">{this.props.data.id}</th>
        <td>{this.props.data.tipo}</td>
        <td>{this.props.data.calleCarrera}</td>
        <td>{this.props.data.numero}</td>
        <td>{this.props.data.nivelCongestion}</td>
        <td><Link to={{pathname:"/ViasPut/"+this.props.data.id,}} className="btn btn-outline-success" data={this.props.data}>Modificar</Link></td>
        <td><button type="button" className="btn btn-danger" onClick={this.deleteVia}>Eliminar</button></td>
        <td><Link to={{pathname:"/HistoricoVia/"+this.props.data.id,}} className="btn btn-warning" data={this.props.data}>Historico Via</Link></td>
      </tr>
    );
  }
}
export default Via;
