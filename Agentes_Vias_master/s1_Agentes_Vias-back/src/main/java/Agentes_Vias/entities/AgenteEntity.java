/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Agentes_Vias.entities;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;
import javax.persistence.CascadeType;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.OneToMany;

/**
 *
 * @author Santisgo
 */
@Entity
public class AgenteEntity extends BaseEntity implements Serializable 
{
    private String nombre;
    private String codigo;
    private Double experiencia;
    private String codigoSecretT;
    private Integer viaActual;
    
    @OneToMany(mappedBy="agente", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<AgenteViaHistoricoEntity> historico= new ArrayList<>();

    /**
     * @return el nombre del agente.
     */
    public String getNombre() {
        return nombre;
    }
    /**
     * @param nombre el nuevo nombre del agente.
     */
    public void setNombre(String nombre) {
        this.nombre = nombre;
    }
    /**
     * @return identificador del agente de tránsito
     */
    public String getCodigo() {
        return codigo;
    }
    /**
     * @param nombre el nuevo identificador del agente de tránsito
     */
    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }
    /**
     * @return Años de experiencia.
     */
    public Double getExperiencia() {
        return experiencia;
    }
    /**
     * @param experiencia Años de experiencia.
     */
    public void setExperiencia(Double experiencia) {
        this.experiencia = experiencia;
    }
    /**
     * @return Código de la secretaría de tránsito a la que pertenece.
     */
    public String getCodigoSecretT() {
        return codigoSecretT;
    }
    /**
     * @param codigoSecretT Código de la secretaría de tránsito a la que pertenece.
     */
    public void setCodigoSecretT(String codigoSecretT) {
        this.codigoSecretT = codigoSecretT;
    }
    /**
     * @return Indica la vía en la cual el agente está ubicado actualmente. Es llave foránea a la tabla de vías.
     */
    public Integer getViaActual() {
        return viaActual;
    }
    /**
     * @param viaActual Indica la vía en la cual el agente está ubicado actualmente. Es llave foránea a la tabla de vías.
     */
    public void setViaActual(Integer viaActual) {
        this.viaActual = viaActual;
    }

    public List<AgenteViaHistoricoEntity> getHistorico() {
        return historico;
    }

    public void setHistorico(List<AgenteViaHistoricoEntity> historico) {
        this.historico = historico;
    }
    
}

