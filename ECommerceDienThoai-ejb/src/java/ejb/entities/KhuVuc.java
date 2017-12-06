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
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DacTien
 */
@Entity
@Table(name = "khu_vuc")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "KhuVuc.findAll", query = "SELECT k FROM KhuVuc k")
    , @NamedQuery(name = "KhuVuc.findById", query = "SELECT k FROM KhuVuc k WHERE k.id = :id")
    , @NamedQuery(name = "KhuVuc.findByTenKhuVuc", query = "SELECT k FROM KhuVuc k WHERE k.tenKhuVuc = :tenKhuVuc")})
public class KhuVuc implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Size(max = 255)
    @Column(name = "ten_khu_vuc")
    private String tenKhuVuc;

    public KhuVuc() {
    }

    public KhuVuc(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getTenKhuVuc() {
        return tenKhuVuc;
    }

    public void setTenKhuVuc(String tenKhuVuc) {
        this.tenKhuVuc = tenKhuVuc;
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
        if (!(object instanceof KhuVuc)) {
            return false;
        }
        KhuVuc other = (KhuVuc) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.KhuVuc[ id=" + id + " ]";
    }
    
}
