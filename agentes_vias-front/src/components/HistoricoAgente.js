import React, {Component} from 'react'
import Registro  from './Registro'
import axios from 'axios'


class HistoricoAgente extends Component{
  constructor(props){
    super(props);
    this.state={
      pagina: 0,
      registros:[]
    };
  }

  componentDidMount() {
        var id=this.props.match.params.idAgente;
        var i;
        var registros=new Array();
        axios.get('http://localhost:8080/s1_Agentes_Vias-api/api/historico/'+id+"/agente")
            .then((response)=>{
                registros= response.data;
                var state = this.state;
                state.registros=registros;
                this.setState(state);
            });
  }
  render(){
    return(
      <div className="row container-fuid d-flex justify-content-center">
        <div className='row'>
          <table class="table text-center">
            <thead class="thead-dark">
              <tr>
                <th scope="col">#ID</th>
                <th scope="col">Activo</th>
                <th scope="col">Nombre Agente de Transito</th>
                <th scope="col">Fecha de creacion</th>
                <th scope="col">Via asignada</th>
              </tr>
            </thead>
            <tbody>
                {this.state.registros.map( (reg)=> <Registro key={reg.id} data={reg}/>)}
            </tbody>
            </table>
        </div>
      </div>
    )
  }
}
export default HistoricoAgente;
