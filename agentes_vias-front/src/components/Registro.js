import React, { Component } from 'react';
import './css/producto-style.css';
import {Link} from 'react-router-dom';
import axios from 'axios'
class Registro extends Component{
constructor(props){
  super(props);
  this.state={
    activa:"Si"
  };
}
  componentDidMount() {
    if(!this.props.data.activa){
      var state = this.state;
      state.activa="No";
      this.setState(state);
    }
  }
  render(){
    return(
      <tr>
        <th scope="row">{this.props.data.id}</th>
        <td>{this.state.activa}</td>
        <td>{this.props.data.agente.nombre}</td>
        <td>{this.props.data.fechaRegistro}</td>
        <td>{this.props.data.via.calleCarrera} {this.props.data.via.numero}</td>
      </tr>
    );
  }
}
export default Registro;
