/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.ejb;

import Agentes_Vias.entities.AgenteEntity;
import Agentes_Vias.entities.AgenteViaHistoricoEntity;
import Agentes_Vias.persistence.AgentePersistence;
import Agentes_Vias.persistence.AgenteViaHistoricoPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.inject.Inject;

/**
 *
 * @author Santisgo
 */
@Stateless
public class AgenteViaHistoricoLogic {
    private static final Logger LOGGER= Logger.getLogger(AgenteViaHistoricoPersistence.class.getName());
    
    @Inject
    private AgenteViaHistoricoPersistence persistence;
    
    /**
     * Obtiene la lista de los registros.
     *
     * @return Colección de objetos de AgenteViaHistoricoEntity.
     */
    public List<AgenteViaHistoricoEntity> getRegistros() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los registros");
        return persistence.findAll();
    }
        /**
     * Se encarga de crear un AgenteViaHistoricoEntity en la base de datos.
     *
     * @param entity Objeto de AgenteViaHistoricoEntity con los datos nuevos
     * @return Objeto de AgenteViaHistoricoEntity con los datos nuevos y su ID.
     */
    public AgenteViaHistoricoEntity createRegistro(AgenteViaHistoricoEntity entity)
    {
        LOGGER.log(Level.INFO,"Inicia proceso de crear un registro");
        return persistence.create(entity);
    }
    /**
     * Actualiza la información de una instancia de AgenteViaHistoricoEntity.
     *
     * @param entity Instancia de AgenteViaHistoricoEntity con los nuevos datos.
     * @return Instancia de AgenteViaHistoricoEntity con los datos actualizados.
     */
    public AgenteViaHistoricoEntity updateRegistro(AgenteViaHistoricoEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un registro");
        return persistence.update(entity);
    }
}
