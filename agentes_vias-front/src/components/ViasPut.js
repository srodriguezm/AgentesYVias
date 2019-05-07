import React, { Component } from 'react';
import './css/producto-style.css';
import {Link} from 'react-router-dom';
import axios from 'axios'
class ViasPut extends Component{
  constructor(props){
    super(props);
    this.state={
      id:0,
      tipo: "",
      calleCarrera:"",
      numero:0,
      nivelCongestion:0
    };
  }

  componentDidMount() {
        var id=this.props.match.params.idVia;
        var i;
            axios.get('http://localhost:8080/s1_Agentes_Vias-api/api/vias/'+id)
                .then((response) => {
                    var state = this.state;
                    var via = response.data;
                    state.id = id;
                    state.tipo = via.tipo;
                    state.calleCarrera = via.calleCarrera;
                    state.numero = via.numero;
                    state.nivelCongestion = via.nivelCongestion;
                    // pueden cambiar el tamaño de partion aca
                    this.setState(state);
                });
    }
    putVia=()=>{
      let tip=document.getElementById('tipoPut').value;
      if(tip==""){
        tip=this.state.tipo;
      }
      let calleC=document.getElementById('calleCarreraPut').value;
      if(calleC==""){
        calleC=this.state.calleCarrera;
      }
      let n=document.getElementById('numeroPut').value;
      if(n==""){
        n=this.state.numero;
      }
      let cong=document.getElementById('nivelCongestionPut').value;
      if(cong==""){
        cong=this.state.nivelCongestion;
      }
      let via={
        tipo:tip,
        calleCarrera:calleC,
        numero:n,
        nivelCongestion:cong
      }
      this.saveputvia(via);
      console.log(this.state.id);
    }

    saveputvia=(via)=>{
      axios.put('http://localhost:8080/s1_Agentes_Vias-api/api/vias/'+this.state.id, via)
      .then(()=>{
      window.location.href = 'http://localhost:3000/Vias';
    });
    }
  render(){
    return(
      <div className="container">
        <h1>Actualizar Via</h1>
        <form className="form-horizontal" id="formPutVia">
          <div className="form-group">
            <label className="control-label col-sm-12">Tipo Via:</label>
            <div className="col-sm-10">
              <select className="form-control" name="ViasList" form="formPutVia" id="tipoPut" placeholder={this.state.tipo}>
                <option value="Autopista">Autopista</option>
                <option value="Carretera Principal">Carretera Principal</option>
                <option value="Carretera Secundaria">Carretera Secundaria</option>
              </select>
            </div>
          </div>
        <div className="form-group">
          <label className="control-label col-sm-12" >¿Es Calle o Carrera?</label>
        <div className="col-sm-10">
          <select className="form-control" name="ViasList" form="formPutVia" id="calleCarreraPut">
            <option value="Calle">Calle</option>
            <option value="Carrera">Carrera</option>
          </select>
        </div>
        </div>
        <div className="form-group">
          <label className="control-label col-sm-12" >Número Calle o Carrera:</label>
        <div className="col-sm-10">
          <input type="text" className="form-control" id="numeroPut" placeholder={this.state.numero}/>
        </div>
        </div>
        <div className="form-group">
          <label className="control-label col-sm-12">Nivel de Congestión:</label>
        <div className="col-sm-10">
          <input type="text" className="form-control"  id="nivelCongestionPut" placeholder={this.state.nivelCongestion}/>
        </div>
        </div>
        <div className="form-group">
          <div className="col-sm-offset-2 col-sm-10">
            <button className="btn btn-info" onClick={this.putVia}>Actualizar</button>
          </div>
        </div>
        </form >
      </div>
    );
  }
}
export default ViasPut;
