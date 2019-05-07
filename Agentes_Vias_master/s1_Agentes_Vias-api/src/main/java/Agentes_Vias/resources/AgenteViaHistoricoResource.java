/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.resources;

import Agentes_Vias.dtos.AgenteDetailDTO;
import Agentes_Vias.dtos.AgenteViaHistoricoDetailDTO;
import Agentes_Vias.ejb.AgenteViaHistoricoLogic;
import Agentes_Vias.entities.AgenteEntity;
import Agentes_Vias.entities.AgenteViaHistoricoEntity;
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
@Path("historico")
@Produces("application/json")
@Consumes("application/json")
@RequestScoped
public class AgenteViaHistoricoResource {
    @Inject
    AgenteViaHistoricoLogic logic;

    private List<AgenteViaHistoricoDetailDTO> listEntity2DTO(List<AgenteViaHistoricoEntity> entityList) {
        List<AgenteViaHistoricoDetailDTO> list = new ArrayList<>();
        for (AgenteViaHistoricoEntity entity : entityList) {
            list.add(new AgenteViaHistoricoDetailDTO(entity));
        }
        return list;
    }

    @POST
    public AgenteViaHistoricoDetailDTO createAgente(AgenteViaHistoricoDetailDTO s) throws BusinessLogicException
    {
        return new AgenteViaHistoricoDetailDTO(logic.createRegistro(s.toEntity()));
    }

    @GET
    public List<AgenteViaHistoricoDetailDTO> getAgentes()
    {
        return listEntity2DTO(logic.getRegistros());
    }
    
    @GET
    @Path("{agenteId: \\d+}/agente")
    public List<AgenteViaHistoricoDetailDTO> getAgenteViaHistoricoPorAgente(@PathParam("agenteId") Long agenteId)
    {
        List<AgenteViaHistoricoDetailDTO> total= listEntity2DTO(logic.getRegistros());
        List<AgenteViaHistoricoDetailDTO> res= new ArrayList<AgenteViaHistoricoDetailDTO>();
        for(int i=0; i<total.size(); i++)
        {
            if(total.get(i).getAgente().getId().equals(agenteId))
                res.add(total.get(i));
        }
        return res;
    }
    @GET
    @Path("{viaId: \\d+}/via")
    public List<AgenteViaHistoricoDetailDTO> getAgenteViaHistoricoPorVia(@PathParam("viaId") Long viaId)
    {
        List<AgenteViaHistoricoDetailDTO> total= listEntity2DTO(logic.getRegistros());
        List<AgenteViaHistoricoDetailDTO> res= new ArrayList<AgenteViaHistoricoDetailDTO>();
        for(int i=0; i<total.size(); i++)
        {
            System.out.println("De la persistencia "+total.get(i).getVia().getId()+" y del path "+viaId);
            if(total.get(i).getVia().getId().equals(viaId)){
                System.out.println("Si son iguales");
                res.add(total.get(i));
            }

        }
        return res;
    }    
}
