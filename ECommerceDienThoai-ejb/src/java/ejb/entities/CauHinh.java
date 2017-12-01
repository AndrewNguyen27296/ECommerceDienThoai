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
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author XinKaChu
 */
@Entity
@Table(name = "cau_hinh")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "CauHinh.findAll", query = "SELECT c FROM CauHinh c"),
    @NamedQuery(name = "CauHinh.findById", query = "SELECT c FROM CauHinh c WHERE c.id = :id"),
    @NamedQuery(name = "CauHinh.findBySoLanBlock", query = "SELECT c FROM CauHinh c WHERE c.soLanBlock = :soLanBlock")})
public class CauHinh implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "so_lan_block")
    private int soLanBlock;

    public CauHinh() {
    }

    public CauHinh(Integer id) {
        this.id = id;
    }

    public CauHinh(Integer id, int soLanBlock) {
        this.id = id;
        this.soLanBlock = soLanBlock;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public int getSoLanBlock() {
        return soLanBlock;
    }

    public void setSoLanBlock(int soLanBlock) {
        this.soLanBlock = soLanBlock;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (id != null ? id.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof CauHinh)) {
            return false;
        }
        CauHinh other = (CauHinh) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.CauHinh[ id=" + id + " ]";
    }
    
}
