/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.resources;

import Agentes_Vias.dtos.AgenteDetailDTO;
import Agentes_Vias.ejb.AgenteLogic;
import Agentes_Vias.entities.AgenteEntity;
import exceptions.BusinessLogicException;
import java.util.ArrayList;
import java.util.List;
import javax.enterprise.context.RequestScoped;
import javax.inject.Inject;
import javax.ws.rs.Consumes;
import javax.ws.rs.DELETE;
import javax.ws.rs.GET;
import javax.ws.rs.POST;
import javax.ws.rs.PUT;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
import javax.ws.rs.Produces;
import javax.ws.rs.WebApplicationException;

/**
 *
 * @author Santisgo
 */
@Path("agentes")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AgenteResource {
    @Inject
    AgenteLogic agenteLogic;
    
    /**
     * Convierte una lista de AgenteEntity a una lista de AgenteDetailDTO.
     *
     * @param entityList Lista de ServicioEntity a convertir.
     * @return Lista de AgenteDetailDTO convertida.
     * 
     */
    private List<AgenteDetailDTO> listEntity2DTO(List<AgenteEntity> entityList) {
        List<AgenteDetailDTO> list = new ArrayList<>();
        for (AgenteEntity entity : entityList) {
            list.add(new AgenteDetailDTO(entity));
        }
        return list;
    }

    @POST
    public AgenteDetailDTO createAgente(AgenteDetailDTO s) throws BusinessLogicException
    {
        return new AgenteDetailDTO(agenteLogic.createAgente(s.toEntity()));
    }

    @GET
    public List<AgenteDetailDTO> getAgentes()
    {
        return listEntity2DTO(agenteLogic.getAgentes());
    }

    @GET
    @Path("{id: \\d+}")
    public AgenteDetailDTO getAgente(@PathParam("id") Long id) throws WebApplicationException
    {
        return new AgenteDetailDTO(agenteLogic.getAgente(id));
    }

    @PUT
    @Path("{id: \\d+}")
    public AgenteDetailDTO updateAgente(@PathParam ("id") Long id,AgenteDetailDTO s)throws WebApplicationException,BusinessLogicException
    {
        AgenteEntity entity=s.toEntity();
        entity.setId(id);
        if(agenteLogic.getAgente(id)==null)
            throw new WebApplicationException("El servicio no existe", 404);
       return new AgenteDetailDTO(agenteLogic.updateAgente(entity));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteAgente(@PathParam ("id") Long id)throws BusinessLogicException
    {
        if(agenteLogic.getAgente(id)==null)
            throw new WebApplicationException("El agente no existe", 404);
        agenteLogic.deleteAgente(id);
    }
}
