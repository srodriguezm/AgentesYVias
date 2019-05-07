import React, { Component } from 'react';
import './css/producto-style.css';
import {Link} from 'react-router-dom';
import axios from 'axios'
class AgentePut extends Component{
  constructor(props){
    super(props);
    this.state={
      id:0,
      nombre:"",
      codigo:"",
      experiencia:0,
      codigoSecretT:"",
      viaActual:0,
      vias:[]
    };
  }

  componentDidMount() {
        var id=this.props.match.params.idAgente;
        var i;
        var vias=new Array();
          axios.get('http://localhost:8080/s1_Agentes_Vias-api/api/vias')
            .then((response)=>{
                vias= response.data;
                var state = this.state;
                state.vias=vias;
                this.setState(state);
            });
            axios.get('http://localhost:8080/s1_Agentes_Vias-api/api/agentes/'+id)
                .then((response) => {
                    var state = this.state;
                    var agente = response.data;
                    state.id = id;
                    state.nombre = agente.nombre;
                    state.codigo = agente.codigo;
                    state.experiencia = agente.experiencia;
                    state.codigoSecretT = agente.codigoSecretT;
                    state.viaActual = agente.viaActual;
                    // pueden cambiar el tamaño de partion aca
                    this.setState(state);
                });
    }
    putAgente=()=>{
      let nombre=document.getElementById('nombrePut').value;
      if(nombre==""){
        nombre=this.state.nombre;
      }
      let codigo=document.getElementById('codigoPut').value;
      if(codigo==""){
        codigo=this.state.codigo;
      }
      let exp=document.getElementById('experienciaPut').value;
      if(exp==""){
        exp=this.state.experiencia;
      }
      let codigoSecretT=document.getElementById('codigoSecretTPut').value;
      if(codigoSecretT==""){
        codigoSecretT=this.state.codigoSecretT;
      }
      let viaActual=document.getElementById('viaActualPut').value;
      if(viaActual==""){
        viaActual=this.state.viaActual;
      }
      let agente={
        nombre:nombre,
        codigo:codigo,
        experiencia:exp,
        codigoSecretT:codigoSecretT,
        viaActual:viaActual
      }
      axios.put('http://localhost:8080/s1_Agentes_Vias-api/api/agentes/'+this.state.id, agente);
      console.log(this.state.id);
    }
  render(){
    return(
      <div className="container">
        <form className="form-horizontal text-center">
          <h1 className="text-center">Actualizar Información Agente</h1>
          <div className="form-group">
            <label className="control-label col-sm-12">Nombre Completo:</label>
            <div className="col-sm-10">
              <input type="text" className="form-control" id="nombrePut" placeholder={this.state.nombre}/>
            </div>
          </div>
        <div className="form-group">
          <label className="control-label col-sm-12" >Código Agente de Transito:</label>
        <div className="col-sm-10">
          <input type="text" className="form-control" id="codigoPut" placeholder={this.state.codigo}/>
        </div>
        </div>
        <div className="form-group">
          <label className="control-label col-sm-12" >Años de experiencia:</label>
        <div className="col-sm-10">
          <input type="number" step="0.01" className="form-control" id="experienciaPut" placeholder={this.state.experiencia}/>
        </div>
        </div>
        <div className="form-group">
          <label className="control-label col-sm-12">Código de la secretaría de tránsito a la que pertenece:</label>
        <div className="col-sm-10">
          <input type="text" className="form-control"  id="codigoSecretTPut" placeholder={this.state.codigoSecretT}/>
        </div>
        </div>
        <div className="form-group">
          <label className="control-label col-sm-12">Identificador Via Actual:</label>
        <div className="col-sm-10">
        <select className="form-control" name="ViasList" form="formPostAgente" id="viaActualPut">
          {this.state.vias.map( (via)=> <option value={via.id}>{via.calleCarrera} {via.numero}</option>)}
        </select>
        </div>
        </div>
        <div className="form-group">
          <div className="col-sm-offset-2 col-sm-10">
            <button className="btn btn-info" onClick={this.putAgente}>Modificar</button>
          </div>
        </div>
        </form >
      </div>
    );
  }
}
export default AgentePut;
