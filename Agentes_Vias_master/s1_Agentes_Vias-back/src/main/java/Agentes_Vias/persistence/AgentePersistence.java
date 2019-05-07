/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.persistence;

import Agentes_Vias.entities.AgenteEntity;
import java.util.List;
import java.util.logging.Level;
import javax.ejb.Stateless;
import java.util.logging.Logger;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;
import javax.persistence.Query;
/**
 *
 * @author Santisgo
 */
@Stateless
public class AgentePersistence {
    private static final Logger LOGGER= Logger.getLogger(AgentePersistence.class.getName());
    
    @PersistenceContext(unitName="Agentes_ViasPU")
    protected EntityManager em;
    /**
     * Busca el agente en la base de datos con el id enviado en el argumento
     * @param id Id del agente que se buscará en la base de datos
     * @return devuelve el agente encontrado en la base de datos.
     */
    public AgenteEntity find(Long id)
    {
        LOGGER.log(Level.INFO,"Consultando agente con el id={0}",id);
        return em.find(AgenteEntity.class, id);
    }
    /**
     * Busca los agentes en la base de datos
     * @return devuelve una lista de los agentes que estan en la base de datos.
     */
    public List<AgenteEntity> findAll()
    {
        LOGGER.info("Consultando todos los agentes");
        Query q=em.createQuery("select u from AgenteEntity u");
        return q.getResultList();
    }
    /**
     * Crea un agente en la base de datos
     * @param agente Agente que se creará en la base de datos
     * @return devuelve el agente creada con un id dado por la base de datos.
     */
    public AgenteEntity create(AgenteEntity agente)
    {
        LOGGER.info("Creando un nuevo agente");
        em.persist(agente);
        LOGGER.info("Agente creado");
        return agente;
    }
    /**
     * Actualiza un agente en la base de datos
     * @param agente Agente por el que se remplaza el que esta en la base de datos
     * @return devuelve el agente actualizado.
     */
    public AgenteEntity update(AgenteEntity agente)
    {
        LOGGER.log(Level.INFO,"Actualizando el agente con id={0}",agente.getId());
        return em.merge(agente);
    }
    /**
     * Borra un agente en la base de datos con el id enviado en el argumento
     * @param id Id del servicio que se borrará de la base de datos
     */
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO, "Borrando agente con id={0}", id);
        em.remove(find(id));
    }
}
