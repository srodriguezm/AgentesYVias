import React, {Component} from 'react'
import Via  from './Via'
import axios from 'axios'


class Vias extends Component{
  constructor(props){
    super(props);
    this.state={
      pagina: 0,
      vias:[]
    };
  }

  componentDidMount() {
        axios.get('http://localhost:8080/s1_Agentes_Vias-api/api/vias')
            .then((response) => {
                var state = this.state;
                var vias = response.data;
                state.vias=vias;
                state.pagina = 0;
                // pueden cambiar el tamaño de partion aca
                this.setState(state);
            });
    }
    postVia=()=>{
      let tipo=document.getElementById('tipoPost').value;
      let calleCarrera=document.getElementById('calleCarreraPost').value;
      let nivelCongestion=document.getElementById('nivelCongestionPost').value;
      let numero=document.getElementById('numeroPost').value;
      let via={
        tipo:tipo,
        calleCarrera:calleCarrera,
        numero:numero,
        nivelCongestion:nivelCongestion
      }
      axios.post('http://localhost:8080/s1_Agentes_Vias-api/api/vias', via);
      window.location.href = 'http://localhost:3000/Vias';
      return false;
    }
  render(){
    return(
      <div className="row container-fuid d-flex justify-content-center">
        <div className='row'>
          <table class="table text-center">
            <thead class="thead-dark">
              <tr>
                <th scope="col">#ID</th>
                <th scope="col">Tipo</th>
                <th scope="col">Calle o Carrera</th>
                <th scope="col">Numero</th>
                <th scope="col">Nivel de Congestión</th>
                <th scope="col">Modificar</th>
                <th scope="col">Eliminar</th>
                <th scope="col">Historico</th>
              </tr>
            </thead>
            <tbody>
                {this.state.vias.map( (via)=> <Via key={via.id} data={via}/>)}
            </tbody>
            </table>
        </div>
        <div className="row-fluid">
          <h1>Crear Via</h1>
          <form className="form-horizontal" id="formPostVia">
            <div className="form-group">
              <label className="control-label col-sm-12">Tipo Via:</label>
              <div className="col-sm-10">
                <select className="form-control" name="ViasList" form="formPostVia" id="tipoPost">
                  <option value="Autopista">Autopista</option>
                  <option value="Carretera Principal">Carretera Principal</option>
                  <option value="Carretera Secundaria">Carretera Secundaria</option>
                </select>
              </div>
            </div>
          <div className="form-group">
            <label className="control-label col-sm-12" >¿Es Calle o Carrera?</label>
          <div className="col-sm-10">
            <select className="form-control" name="ViasList" form="formPostVia" id="calleCarreraPost">
              <option value="Calle">Calle</option>
              <option value="Carrera">Carrera</option>
            </select>
          </div>
          </div>
          <div className="form-group">
            <label className="control-label col-sm-12" >Número Calle o Carrera:</label>
          <div className="col-sm-10">
            <input type="text" className="form-control" id="numeroPost"/>
          </div>
          </div>
          <div className="form-group">
            <label className="control-label col-sm-12">Nivel de Congestión:</label>
          <div className="col-sm-10">
            <input type="number" step="0.01" className="form-control"  id="nivelCongestionPost"/>
          </div>
          </div>
          <div className="form-group">
            <div className="col-sm-offset-2 col-sm-10">
              <button className="btn btn-info" onClick={this.postVia}>Crear</button>
            </div>
          </div>
          </form >
        </div>
      </div>
    )
  }
}
export default Vias;
