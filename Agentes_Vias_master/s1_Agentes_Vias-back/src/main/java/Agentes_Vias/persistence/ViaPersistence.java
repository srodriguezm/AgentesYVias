/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.persistence;

import Agentes_Vias.entities.ViaEntity;
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
public class ViaPersistence {
    private static final Logger LOGGER= Logger.getLogger(ViaPersistence.class.getName());
    
    @PersistenceContext(unitName="Agentes_ViasPU")
    protected EntityManager em;
    /**
     * Busca la via en la base de datos con el id enviado en el argumento
     * @param id Id de la via que se buscará en la base de datos
     * @return devuelve la via encontrada en la base de datos.
     */
    public ViaEntity find(Long id)
    {
        LOGGER.log(Level.INFO,"Consultando via con el id={0}",id);
        return em.find(ViaEntity.class, id);
    }
    /**
     * Busca las vias  en la base de datos
     * @return devuelve una lista de las vias que estan en la base de datos.
     */
    public List<ViaEntity> findAll()
    {
        LOGGER.info("Consultando todas las vias");
        Query q=em.createQuery("select u from ViaEntity u");
        return q.getResultList();
    }
    /**
     * Crea una via en la base de datos
     * @param via Via que se creará en la base de datos
     * @return devuelve la via creada con un id dado por la base de datos.
     */
    public ViaEntity create(ViaEntity via)
    {
        LOGGER.info("Creando una nueva via");
        em.persist(via);
        LOGGER.info("Via creado");
        return via;
    }
    /**
     * Actualiza una via en la base de datos
     * @param via Via por la que se remplaza la que esta en la base de datos
     * @return devuelve la via actualizada.
     */
    public ViaEntity update(ViaEntity via)
    {
        LOGGER.log(Level.INFO,"Actualizando la via con id={0}",via.getId());
        return em.merge(via);
    }
    /**
     * Borra una via en la base de datos con el id enviado en el argumento
     * @param id Id de la via que se borrará de la base de datos
     */
    public void delete(Long id)
    {
        LOGGER.log(Level.INFO, "Borrando via con id={0}", id);
        em.remove(find(id));
    }
}
