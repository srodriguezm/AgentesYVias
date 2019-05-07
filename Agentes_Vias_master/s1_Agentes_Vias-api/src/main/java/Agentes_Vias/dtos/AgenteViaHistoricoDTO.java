/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.dtos;

import Agentes_Vias.entities.AgenteEntity;
import Agentes_Vias.entities.AgenteViaHistoricoEntity;
import java.util.Date;

/**
 *
 * @author Santisgo
 */
public class AgenteViaHistoricoDTO {
    private Long id;
    private boolean activa;
    private Date fechaRegistro;
    
    public AgenteViaHistoricoDTO(){}
    
     /**
     * Crea un objeto AgenteViaHistoricoDTO a partir de un objeto AgenteViaHistoricoEntity.
     *
     * @param entity Entidad AgenteViaHistoricoEntity desde la cual se va a crear el nuevo
     * objeto.
     * 
     */
    public AgenteViaHistoricoDTO(AgenteViaHistoricoEntity entity) {
        if (entity != null) {
            this.id= entity.getId();
            this.activa = entity.isActiva();
            this.fechaRegistro=entity.getFechaRegistro();
        }
    }
    public AgenteViaHistoricoEntity toEntity()
    {
        AgenteViaHistoricoEntity e=new AgenteViaHistoricoEntity();
        e.setId(id);
        e.setActiva(activa);
        e.setFechaRegistro(fechaRegistro);
        return e;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public boolean isActiva() {
        return activa;
    }

    public void setActiva(boolean activa) {
        this.activa = activa;
    }

    public Date getFechaRegistro() {
        return fechaRegistro;
    }

    public void setFechaRegistro(Date fechaRegistro) {
        this.fechaRegistro = fechaRegistro;
    }
    
}
