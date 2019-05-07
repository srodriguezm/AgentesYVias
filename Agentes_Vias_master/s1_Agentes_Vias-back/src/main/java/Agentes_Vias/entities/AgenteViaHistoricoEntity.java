/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import podam.RegistroStrategy;
import uk.co.jemos.podam.common.PodamStrategyValue;

/**
 *
 * @author Santisgo
 */
@Entity
public class AgenteViaHistoricoEntity  extends BaseEntity implements Serializable
{
    @ManyToOne(fetch=FetchType.EAGER)
    private AgenteEntity agente;
    
    @ManyToOne(fetch=FetchType.EAGER)
    private ViaEntity via;
    
    private boolean activa;
    
    @Temporal(TemporalType.TIMESTAMP)
    @PodamStrategyValue(RegistroStrategy.class)
    private Date fechaRegistro; 

    public AgenteEntity getAgente() {
        return agente;
    }

    public void setAgente(AgenteEntity agente) {
        this.agente = agente;
    }

    public ViaEntity getVia() {
        return via;
    }

    public void setVia(ViaEntity via) {
        this.via = via;
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
