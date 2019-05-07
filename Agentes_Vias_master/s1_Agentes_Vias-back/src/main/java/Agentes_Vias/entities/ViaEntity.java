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
public class ViaEntity extends BaseEntity implements Serializable  {
    private String tipo;
    private String calleCarrera;
    private Integer numero;
    private Double nivelCongestion;
    
    @OneToMany(mappedBy="via", fetch=FetchType.LAZY, cascade = CascadeType.PERSIST, orphanRemoval = true)
    private List<AgenteViaHistoricoEntity> historico=new ArrayList<>();
    
    /**
     * @return tipo de via Autopista, Carretera Principal, Carretera Secundaria.
     */
    public String getTipo() {
        return tipo;
    }
    /**
     * @param tipo tipo de via Autopista, Carretera Principal, Carretera Secundaria.
     */
    public void setTipo(String tipo) {
        this.tipo = tipo;
    }
    /**
     * @return ¿Es Calle o Carrera?.
     */
    public String getCalleCarrera() {
        return calleCarrera;
    }
    /**
     * @param calleCarrera ¿Es Calle o Carrera?.
     */
    public void setCalleCarrera(String calleCarrera) {
        this.calleCarrera = calleCarrera;
    }
    /**
     * @return Corresponde al número de la calle o de la carrera.
     */
    public Integer getNumero() {
        return numero;
    }
    /**
     * @param numero Corresponde al número de la calle o de la carrera. Ejemplo: 100.
     */
    public void setNumero(Integer numero) {
        this.numero = numero;
    }
    /**
     * @return Nivel de Congestión.
     */
    public Double getNivelCongestion() {
        return nivelCongestion;
    }
    /**
     * @param numero Es un valor decimal que oscila entre 0 y 100. Ejemplo 45,2.
     */
    public void setNivelCongestion(Double nivelCongestion) {
        this.nivelCongestion = nivelCongestion;
    }

    public List<AgenteViaHistoricoEntity> getHistorico() {
        return historico;
    }

    public void setHistorico(List<AgenteViaHistoricoEntity> historico) {
        this.historico = historico;
    }
    
    
}
