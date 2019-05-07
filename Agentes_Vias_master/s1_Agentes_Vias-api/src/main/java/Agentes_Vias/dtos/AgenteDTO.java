/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.dtos;

import Agentes_Vias.entities.AgenteEntity;
import java.io.Serializable;

/**
 *
 * @author Santisgo
 */
public class AgenteDTO implements Serializable{
    private Long id;
    private String nombre;
    private String codigo;
    private Double experiencia;
    private String codigoSecretT;
    private Integer viaActual;
    
    public AgenteDTO(){}
     /**
     * Crea un objeto AgenteDTO a partir de un objeto AgenteEntity.
     *
     * @param entity Entidad AgenteEntity desde la cual se va a crear el nuevo
     * objeto.
     * 
     */
    public AgenteDTO(AgenteEntity entity) {
        if (entity != null) {
            this.id= entity.getId();
            this.nombre = entity.getNombre();
            this.codigo = entity.getCodigo();
            this.experiencia = entity.getExperiencia();
            this.codigoSecretT=entity.getCodigoSecretT();
            this.viaActual=entity.getViaActual();
        }
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getCodigo() {
        return codigo;
    }

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public Double getExperiencia() {
        return experiencia;
    }

    public void setExperiencia(Double experiencia) {
        this.experiencia = experiencia;
    }

    public String getCodigoSecretT() {
        return codigoSecretT;
    }

    public void setCodigoSecretT(String codigoSecretT) {
        this.codigoSecretT = codigoSecretT;
    }

    public Integer getViaActual() {
        return viaActual;
    }

    public void setViaActual(Integer viaActual) {
        this.viaActual = viaActual;
    }
    
    public AgenteEntity toEntity()
    {
        AgenteEntity e=new AgenteEntity();
        e.setId(id);
        e.setNombre(nombre);
        e.setCodigo(codigo);
        e.setExperiencia(experiencia);
        e.setCodigoSecretT(codigoSecretT);
        e.setViaActual(viaActual);
        return e;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }
    
}
