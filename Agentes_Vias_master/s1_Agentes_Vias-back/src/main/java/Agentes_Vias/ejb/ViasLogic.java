/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.ejb;

import Agentes_Vias.entities.ViaEntity;
import Agentes_Vias.persistence.ViaPersistence;
import java.util.List;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.inject.Inject;
import javax.ejb.Stateless;

/**
 *
 * @author Santisgo
 */
@Stateless
public class ViasLogic {
    private static final Logger LOGGER= Logger.getLogger(ViaPersistence.class.getName());
    
    @Inject
    private ViaPersistence persistence;
    
    /**
     * Obtiene la lista de las Vias.
     *
     * @return Colección de objetos de ViaEntity.
     */
    public List<ViaEntity> getVias() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todas las vias");
        return persistence.findAll();
    }
    /**
     * Obtiene los datos de una instancia de Via a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de ViaEntity con los datos de la Via consultada.
     */
    public ViaEntity getVia(Long id)
    {
        LOGGER.log(Level.INFO,"Inicia proceso de consultar una via con id={0}",id);
        return persistence.find(id);
    }
    /**
     * Se encarga de crear una Via en la base de datos.
     *
     * @param entity Objeto de ViaEntity con los datos nuevos
     * @return Objeto de ViaEntity con los datos nuevos y su ID.
     */
    public ViaEntity createVia(ViaEntity entity)
    {
        LOGGER.log(Level.INFO,"Inicia proceso de crear una via");
        return persistence.create(entity);
    }
    /**
     * Actualiza la información de una instancia de Servicio.
     *
     * @param entity Instancia de ViaEntity con los nuevos datos.
     * @return Instancia de ViaEntity con los datos actualizados.
     */
    public ViaEntity updateVia(ViaEntity entity) {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar una via");
        return persistence.update(entity);
    }
    /**
     * Elimina una instancia de ViaEntity de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteVia(Long id)
    {
        LOGGER.log(Level.INFO,"Inicia proceso de eliminar una via con id={0}",id);
        persistence.delete(id);
    }
}
