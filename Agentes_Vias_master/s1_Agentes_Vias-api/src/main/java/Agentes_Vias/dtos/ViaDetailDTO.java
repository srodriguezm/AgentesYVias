/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.dtos;

import Agentes_Vias.entities.AgenteEntity;
import Agentes_Vias.entities.AgenteViaHistoricoEntity;
import Agentes_Vias.entities.ViaEntity;
import java.util.ArrayList;
import java.util.List;

/**
 *
 * @author Santisgo
 */
public class ViaDetailDTO extends ViaDTO{
    
    private List<AgenteViaHistoricoDTO> historico;
            
    public ViaDetailDTO(){}
    /**
     * Constructor que recibe un entity.
     * @param entity entidad
     */
    public ViaDetailDTO(ViaEntity entity)
    {
        super(entity);
        
        historico=new ArrayList<>();
        if(entity.getHistorico()!=null)
            historico=AgenteViaHistoricoEntityAAgenteViaHistoricoDTO(entity.getHistorico());
    }
    @Override
    public ViaEntity toEntity()
    {
        ViaEntity e= super.toEntity();
        if(historico!=null)
            e.setHistorico(AgenteViaHistoricoDTOAAgenteViaHistoricoEntity(historico));
        return e;
    }
        /**
     * @return la lista de historicos Entity.
     */
    
    public List<AgenteViaHistoricoEntity> AgenteViaHistoricoDTOAAgenteViaHistoricoEntity(List<AgenteViaHistoricoDTO> dto)
    {
       List<AgenteViaHistoricoEntity> res=new ArrayList<>();
       for(AgenteViaHistoricoDTO x: dto)
       {
           res.add(x.toEntity());
       }
       return res;
    }
    /**
     * @return la lista de servicios DTO.
     */
    
    public List<AgenteViaHistoricoDTO> AgenteViaHistoricoEntityAAgenteViaHistoricoDTO(List<AgenteViaHistoricoEntity> entity)
    {
       List<AgenteViaHistoricoDTO> res=new ArrayList<>();
       for(AgenteViaHistoricoEntity x: entity)
       {
           res.add(new AgenteViaHistoricoDTO(x));
       }
       return res;
    }
}
