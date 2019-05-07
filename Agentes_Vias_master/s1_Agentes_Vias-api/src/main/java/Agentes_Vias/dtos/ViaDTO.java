/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.dtos;

import Agentes_Vias.entities.ViaEntity;

/**
 *
 * @author Santisgo
 */
public class ViaDTO {
    private Long id;
    private String tipo;
    private String calleCarrera;
    private Integer numero;
    private Double nivelCongestion;
    
    public ViaDTO(){}
    
    public ViaDTO(ViaEntity entity) {
        if (entity != null) {
            this.id=entity.getId();
            this.tipo = entity.getTipo();
            this.calleCarrera = entity.getCalleCarrera();
            this.numero = entity.getNumero();
            this.nivelCongestion=entity.getNivelCongestion();
        }
    }

    public String getTipo() {
        return tipo;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCalleCarrera() {
        return calleCarrera;
    }

    public void setCalleCarrera(String calleCarrera) {
        this.calleCarrera = calleCarrera;
    }

    public Integer getNumero() {
        return numero;
    }

    public void setNumero(Integer numero) {
        this.numero = numero;
    }

    public Double getNivelCongestion() {
        return nivelCongestion;
    }

    public void setNivelCongestion(Double nivelCongestion) {
        this.nivelCongestion = nivelCongestion;
    }
    
    public ViaEntity toEntity()
    {
        ViaEntity e=new ViaEntity();
        e.setId(id);
        e.setTipo(tipo);
        e.setCalleCarrera(calleCarrera);
        e.setNumero(numero);
        e.setNivelCongestion(nivelCongestion);
        return e;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
}   
