/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.ejb;

import Agentes_Vias.entities.AgenteEntity;
import Agentes_Vias.entities.AgenteViaHistoricoEntity;
import Agentes_Vias.entities.ViaEntity;
import Agentes_Vias.persistence.AgentePersistence;
import exceptions.BusinessLogicException;
import java.util.Date;
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
public class AgenteLogic {
        private static final Logger LOGGER= Logger.getLogger(AgentePersistence.class.getName());
    
    @Inject
    private AgentePersistence persistence;
    
    @Inject
    private ViasLogic viaLogic;
    
    @Inject
    private AgenteViaHistoricoLogic historial;
    
    /**
     * Obtiene la lista de los Agentes.
     *
     * @return Colección de objetos de AgenteEntity.
     */
    public List<AgenteEntity> getAgentes() {
        LOGGER.log(Level.INFO, "Inicia proceso de consultar todos los agentes");
        return persistence.findAll();
    }
    /**
     * Obtiene los datos de una instancia de AgenteEntity a partir de su ID.
     *
     * @param id Identificador de la instancia a consultar
     * @return Instancia de AgenteEntity con los datos del Agente consultado.
     */
    public AgenteEntity getAgente(Long id)
    {
        LOGGER.log(Level.INFO,"Inicia proceso de consultar un agente con id={0}",id);
        return persistence.find(id);
    }
    /**
     * Se encarga de crear un AgenteEntity en la base de datos.
     *
     * @param entity Objeto de AgenteEntity con los datos nuevos
     * @return Objeto de AgenteEntity con los datos nuevos y su ID.
     */
    public AgenteEntity createAgente(AgenteEntity entity)throws BusinessLogicException
    {
        LOGGER.log(Level.INFO,"Inicia proceso de crear un agente");
        Integer a=entity.getViaActual();
        Long id=Long.valueOf(a);
        ViaEntity via= viaLogic.getVia(id);
        if(via.getNivelCongestion()<30){
            throw new BusinessLogicException("No es posible asignar esa via al agente en cuestión ya que esta presenta un nivel de congestión menor a 30.");
        }
        List<AgenteViaHistoricoEntity> historico=historial.getRegistros();
        for(int i=0; i<historico.size();i++)
        {
            AgenteViaHistoricoEntity registro=historico.get(i);
            if(registro.getAgente().getViaActual()==entity.getViaActual()&&registro.isActiva())
            {
                registro.setActiva(false);
                historial.updateRegistro(registro);
            }
        }
        AgenteViaHistoricoEntity nuevoRegistro=new AgenteViaHistoricoEntity();
        nuevoRegistro.setActiva(true);
        AgenteEntity nuevoAgente=persistence.create(entity);
        nuevoRegistro.setAgente(nuevoAgente);
        nuevoRegistro.setFechaRegistro(new Date());
        nuevoRegistro.setVia(via);
        historial.createRegistro(nuevoRegistro);
        return nuevoAgente;
    }
    /**
     * Actualiza la información de una instancia de Servicio.
     *
     * @param entity Instancia de AgenteEntity con los nuevos datos.
     * @return Instancia de AgenteEntity con los datos actualizados.
     */
    public AgenteEntity updateAgente(AgenteEntity entity) throws BusinessLogicException {
        LOGGER.log(Level.INFO, "Inicia proceso de actualizar un agente");
        AgenteEntity nuevoAgente=new AgenteEntity();
        if(entity.getViaActual()!=null)
        {
            Integer a=entity.getViaActual();
            Long id=Long.valueOf(a);
            ViaEntity via= viaLogic.getVia(id);
            if(persistence.find(entity.getId()).getViaActual()!=entity.getViaActual())
            {
                if(via.getNivelCongestion()<30)
                {
                    throw new BusinessLogicException("No es posible asignar esa via al agente en cuestión ya que esta presenta un nivel de congestión menor a 30.");
                }
                List<AgenteViaHistoricoEntity> historico=historial.getRegistros();
                for(int i=0; i<historico.size();i++)
                {
                    AgenteViaHistoricoEntity registro=historico.get(i);
                    if(registro.getAgente().getViaActual()==entity.getViaActual()&&registro.isActiva())
                    {
                        registro.setActiva(false);
                        historial.updateRegistro(registro);
                    }
                }
                AgenteViaHistoricoEntity nuevoRegistro=new AgenteViaHistoricoEntity();
                nuevoRegistro.setActiva(true);
                nuevoAgente = persistence.update(entity);
                nuevoRegistro.setAgente(nuevoAgente);
                nuevoRegistro.setFechaRegistro(new Date());
                nuevoRegistro.setVia(via);
                historial.createRegistro(nuevoRegistro);
            }
        }
        return nuevoAgente;
    }
    /**
     * Elimina una instancia de AgenteEntity de la base de datos.
     *
     * @param id Identificador de la instancia a eliminar.
     */
    public void deleteAgente(Long id)
    {
        LOGGER.log(Level.INFO,"Inicia proceso de eliminar un agente con id={0}",id);
        persistence.delete(id);
    }
}
