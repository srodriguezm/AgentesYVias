import React, { Component } from 'react';
import {Route} from 'react-router-dom'
import Navbar from './NavBar'
import Agentes from './Agentes'
import AgentePut from './AgentePut'
import HistoricoAgente from './HistoricoAgente'
import HistoricoVia from './HistoricoVia'
import Historico from './Historico'
import Vias from './Vias'
import ViasPut from './ViasPut'

import Home from './Home'

class Vista extends Component {

    render() {
        return(
            <div>
                <Navbar/>
                <Route path="/" exact component={Home}/>
                <Route path="/Agentes" exact component={Agentes}/>
                <Route path="/AgentesPut/:idAgente" exact component={AgentePut}/>
                <Route path="/HistoricoAgente/:idAgente" exact component={HistoricoAgente}/>
                <Route path="/Vias" exact component={Vias}/>
                <Route path="/ViasPut/:idVia" exact component={ViasPut}/>
                <Route path="/HistoricoVia/:idVia" exact component={HistoricoVia}/>
                <Route path="/Historico" exact component={Historico}/>
            </div>
        );
    }
}

export default Vista;
