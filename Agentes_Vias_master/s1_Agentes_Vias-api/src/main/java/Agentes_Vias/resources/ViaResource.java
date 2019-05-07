/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.resources;

import Agentes_Vias.dtos.AgenteDetailDTO;
import Agentes_Vias.dtos.ViaDetailDTO;
import Agentes_Vias.ejb.AgenteLogic;
import Agentes_Vias.ejb.ViasLogic;
import Agentes_Vias.entities.AgenteEntity;
import Agentes_Vias.entities.ViaEntity;
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
@Path("vias")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class ViaResource {
    @Inject
    ViasLogic viaLogic;
    
    /**
     * Convierte una lista de ViaEntity a una lista de ViaDetailDTO.
     *
     * @param entityList Lista de ViaEntity a convertir.
     * @return Lista de ViaDetailDTO convertida.
     * 
     */
    private List<ViaDetailDTO> listEntity2DTO(List<ViaEntity> entityList) {
        List<ViaDetailDTO> list = new ArrayList<>();
        for (ViaEntity entity : entityList) {
            list.add(new ViaDetailDTO(entity));
        }
        return list;
    }

    @POST
    public ViaDetailDTO createVia(ViaDetailDTO s) throws BusinessLogicException
    {
        return new ViaDetailDTO(viaLogic.createVia(s.toEntity()));
    }

    @GET
    public List<ViaDetailDTO> getVias()
    {
        return listEntity2DTO(viaLogic.getVias());
    }

    @GET
    @Path("{id: \\d+}")
    public ViaDetailDTO getVia(@PathParam("id") Long id) throws WebApplicationException
    {
        return new ViaDetailDTO(viaLogic.getVia(id));
    }

    @PUT
    @Path("{id: \\d+}")
    public ViaDetailDTO updateVia(@PathParam ("id") Long id,ViaDetailDTO s)throws WebApplicationException,BusinessLogicException
    {
        ViaEntity entity=s.toEntity();
        entity.setId(id);
        if(viaLogic.getVia(id)==null)
            throw new WebApplicationException("La via no existe", 404);
       return new ViaDetailDTO(viaLogic.updateVia(entity));
    }

    @DELETE
    @Path("{id: \\d+}")
    public void deleteVia(@PathParam ("id") Long id)throws BusinessLogicException
    {
        if(viaLogic.getVia(id)==null)
            throw new WebApplicationException("La via no existe", 404);
        viaLogic.deleteVia(id);
    }
}
