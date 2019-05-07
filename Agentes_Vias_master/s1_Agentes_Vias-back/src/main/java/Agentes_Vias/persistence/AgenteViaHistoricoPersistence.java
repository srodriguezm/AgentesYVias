/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.persistence;

import Agentes_Vias.entities.AgenteViaHistoricoEntity;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;

/**
 *
 * @author Santisgo
 */
@Stateless
public class AgenteViaHistoricoPersistence {
    private static final Logger LOGGER= Logger.getLogger(AgenteViaHistoricoPersistence.class.getName());
    
    @PersistenceContext(unitName="Agentes_ViasPU")
    protected EntityManager em;
    /**
     * Busca los historicos en la base de datos
     * @return devuelve una lista de los historicos que estan en la base de datos.
     */
    public List<AgenteViaHistoricoEntity> findAll()
    {
        LOGGER.info("Consultando todos los historicos");
        Query q=em.createQuery("select u from AgenteViaHistoricoEntity u");
        return q.getResultList();
    }
    /**
     * Crea un registro en la base de datos
     * @param registro Historico que se creará en la base de datos
     * @return devuelve el registro creado con un id dado por la base de datos.
     */
    public AgenteViaHistoricoEntity create(AgenteViaHistoricoEntity registro)
    {
        LOGGER.info("Creando un nuevo registro");
        em.persist(registro);
        LOGGER.info("Registro creado");
        return registro;
    }
    /**
     * Actualiza un agente en la base de datos
     * @param agente Agente por el que se remplaza el que esta en la base de datos
     * @return devuelve el agente actualizado.
     */
    public AgenteViaHistoricoEntity update(AgenteViaHistoricoEntity agente)
    {
        LOGGER.log(Level.INFO,"Actualizando el registro con id={0}",agente.getId());
        return em.merge(agente);
    }
}
