import React, { Component } from 'react';
import './css/producto-style.css';
import {Link} from 'react-router-dom';
import axios from 'axios'
class Agente extends Component{
    deleteAgente=()=>{
      axios.delete('http://localhost:8080/s1_Agentes_Vias-api/api/agentes/'+this.props.data.id)
      .then(()=>{
      window.location.href = 'http://localhost:3000/Agentes';
    });

    }

  render(){
    return(
      <tr>
        <th>{this.props.data.id}</th>
        <td>{this.props.data.nombre}</td>
        <td>{this.props.data.codigo}</td>
        <td>{this.props.data.experiencia} Años</td>
        <td>{this.props.data.codigoSecretT}</td>
        <td>{this.props.data.viaActual}</td>
        <td><Link to={{pathname:"/AgentesPut/"+this.props.data.id,}} className="btn btn-outline-success" data={this.props.data}>Modificar-Asignar Via</Link></td>
        <td><button type="button" className="btn btn-danger" onClick={this.deleteAgente}>Eliminar</button></td>
        <td><Link to={{pathname:"/HistoricoAgente/"+this.props.data.id,}} className="btn btn-warning" data={this.props.data}>Historico Agente</Link></td>
      </tr>
    );
  }
}
export default Agente;
