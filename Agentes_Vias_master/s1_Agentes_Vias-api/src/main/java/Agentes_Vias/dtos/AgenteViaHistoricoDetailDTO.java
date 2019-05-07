/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.dtos;

import Agentes_Vias.entities.AgenteViaHistoricoEntity;
import java.io.Serializable;

/**
 *
 * @author Santisgo
 */
public class AgenteViaHistoricoDetailDTO extends AgenteViaHistoricoDTO implements Serializable {
    
   private AgenteDTO agente;
   
   private ViaDTO via;
   
   public AgenteViaHistoricoDetailDTO(){}
   
   public AgenteViaHistoricoDetailDTO(AgenteViaHistoricoEntity entity)
    {
        super(entity);
        
        if(entity.getAgente()!=null)
            agente=new AgenteDTO(entity.getAgente());
        if(entity.getVia()!=null)
            via=new ViaDTO(entity.getVia());
    }

    public AgenteDTO getAgente() {
        return agente;
    }

    public void setAgente(AgenteDTO agente) {
        this.agente = agente;
    }

    public ViaDTO getVia() {
        return via;
    }

    public void setVia(ViaDTO via) {
        this.via = via;
    }
   
    @Override
    public AgenteViaHistoricoEntity toEntity()
    {
        AgenteViaHistoricoEntity e= super.toEntity();
        if(agente!=null)
            e.setAgente(agente.toEntity());
        if(via!=null)
            e.setVia(via.toEntity());
        return e;
    }
}
