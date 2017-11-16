/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XinKaChu
 */
@Entity
@Table(name = "chip")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chip.findAll", query = "SELECT c FROM Chip c"),
    @NamedQuery(name = "Chip.findByMaChip", query = "SELECT c FROM Chip c WHERE c.maChip = :maChip"),
    @NamedQuery(name = "Chip.findByChip", query = "SELECT c FROM Chip c WHERE c.chip = :chip")})
public class Chip implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaChip")
    private Integer maChip;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Chip")
    private String chip;

    public Chip() {
    }

    public Chip(Integer maChip) {
        this.maChip = maChip;
    }

    public Chip(Integer maChip, String chip) {
        this.maChip = maChip;
        this.chip = chip;
    }

    public Integer getMaChip() {
        return maChip;
    }

    public void setMaChip(Integer maChip) {
        this.maChip = maChip;
    }

    public String getChip() {
        return chip;
    }

    public void setChip(String chip) {
        this.chip = chip;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maChip != null ? maChip.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chip)) {
            return false;
        }
        Chip other = (Chip) object;
        if ((this.maChip == null && other.maChip != null) || (this.maChip != null && !this.maChip.equals(other.maChip))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Chip[ maChip=" + maChip + " ]";
    }
    
}
