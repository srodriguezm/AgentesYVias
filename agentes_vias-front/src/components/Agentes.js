import React, {Component} from 'react'
import Agente  from './Agente'
import axios from 'axios'


class Agentes extends Component{
  constructor(props){
    super(props);
    this.state={
      pagina: 0,
      agentes:[],
      vias:[]
    };
  }

  componentDidMount() {
        var vias=new Array();
        axios.get('http://localhost:8080/s1_Agentes_Vias-api/api/vias')
            .then((response)=>{
                vias= response.data;
                var state = this.state;
                state.vias=vias;
                this.setState(state);
            });
        axios.get('http://localhost:8080/s1_Agentes_Vias-api/api/agentes')
            .then((response) => {
                var state = this.state;
                var agentes = response.data;
                state.agentes=agentes;
                state.vias=vias;
                state.pagina = 0;
                // pueden cambiar el tamaño de partion aca
                this.setState(state);
            });
    }
    postAgente=()=>{
      console.log('entró al post');
      let nombre=document.getElementById('nombrePost').value;
      console.log(nombre);
      let codigo=document.getElementById('codigoPost').value;
      console.log(codigo);
      let exp=document.getElementById('experienciaPost').value;
      console.log(exp);
      let codigoSecretT=document.getElementById('codigoSecretTPost').value;
      console.log(codigoSecretT);
      let viaActual=document.getElementById('viaActualPost').value;
      console.log(viaActual);
      let agente={
        nombre:nombre,
        codigo:codigo,
        experiencia:exp,
        codigoSecretT:codigoSecretT,
        viaActual:viaActual,
      }
      axios.post('http://localhost:8080/s1_Agentes_Vias-api/api/agentes', agente);

      return false;
    }
  render(){
    return(
      <div className="row container-fuid d-flex justify-content-center">
        <div className='row'>
          <table class="table text-center">
            <thead class="thead-dark">
              <tr>
                <th scope="col">Identificador</th>
                <th scope="col">Nombre</th>
                <th scope="col">Código Agente de Transito</th>
                <th scope="col">Años de experiencia</th>
                <th scope="col">Código secretaría de tránsito</th>
                <th scope="col">Vía actual</th>
                <th scope="col">Modificar</th>
                <th scope="col">Eliminar</th>
                <th scope="col">Historico</th>
              </tr>
            </thead>
            <tbody>
                {this.state.agentes.map( (ag)=> <Agente key={ag.id} data={ag}/>)}
            </tbody>
            </table>
        </div>
        <div className="row-fluid">
          <h1>Crear Agente</h1>
          <form className="form-horizontal" id="formPostAgente">
            <div className="form-group">
              <label className="control-label col-sm-12">Nombre Completo:</label>
              <div className="col-sm-10">
                <input type="text" className="form-control" id="nombrePost"/>
              </div>
            </div>
          <div className="form-group">
            <label className="control-label col-sm-12" >Código Agente de Transito:</label>
          <div className="col-sm-10">
            <input type="text" className="form-control" id="codigoPost"/>
          </div>
          </div>
          <div className="form-group">
            <label className="control-label col-sm-12" >Años de experiencia:</label>
          <div className="col-sm-10">
            <input type="number" step="0.01" className="form-control" id="experienciaPost"/>
          </div>
          </div>
          <div className="form-group">
            <label className="control-label col-sm-12">Código secretaría de tránsito a la que pertenece:</label>
          <div className="col-sm-10">
            <input type="text" className="form-control"  id="codigoSecretTPost"/>
          </div>
          </div>
          <div className="form-group">
            <label className="control-label col-sm-12">Via Actual:</label>
          <div className="col-sm-10">
            <select className="form-control" name="ViasList" form="formPostAgente" id="viaActualPost">
              {this.state.vias.map( (via)=> <option value={via.id}>{via.calleCarrera} {via.numero}</option>)}
            </select>
          </div>
          </div>
          <div className="form-group">
            <div className="col-sm-offset-2 col-sm-10">
              <button className="btn btn-info" onClick={this.postAgente}>Crear</button>
            </div>
          </div>
          </form >
        </div>
      </div>
    )
  }
}
export default Agentes;
