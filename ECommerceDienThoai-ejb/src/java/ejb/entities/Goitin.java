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
@Table(name = "goitin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Goitin.findAll", query = "SELECT g FROM Goitin g"),
    @NamedQuery(name = "Goitin.findByMaGoi", query = "SELECT g FROM Goitin g WHERE g.maGoi = :maGoi"),
    @NamedQuery(name = "Goitin.findByTenGoi", query = "SELECT g FROM Goitin g WHERE g.tenGoi = :tenGoi"),
    @NamedQuery(name = "Goitin.findBySoLuongTin", query = "SELECT g FROM Goitin g WHERE g.soLuongTin = :soLuongTin"),
    @NamedQuery(name = "Goitin.findByGiaBan", query = "SELECT g FROM Goitin g WHERE g.giaBan = :giaBan")})
public class Goitin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 2)
    @Column(name = "MaGoi")
    private String maGoi;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "TenGoi")
    private String tenGoi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "SoLuongTin")
    private int soLuongTin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "GiaBan")
    private float giaBan;

    public Goitin() {
    }

    public Goitin(String maGoi) {
        this.maGoi = maGoi;
    }

    public Goitin(String maGoi, String tenGoi, int soLuongTin, float giaBan) {
        this.maGoi = maGoi;
        this.tenGoi = tenGoi;
        this.soLuongTin = soLuongTin;
        this.giaBan = giaBan;
    }

    public String getMaGoi() {
        return maGoi;
    }

    public void setMaGoi(String maGoi) {
        this.maGoi = maGoi;
    }

    public String getTenGoi() {
        return tenGoi;
    }

    public void setTenGoi(String tenGoi) {
        this.tenGoi = tenGoi;
    }

    public int getSoLuongTin() {
        return soLuongTin;
    }

    public void setSoLuongTin(int soLuongTin) {
        this.soLuongTin = soLuongTin;
    }

    public float getGiaBan() {
        return giaBan;
    }

    public void setGiaBan(float giaBan) {
        this.giaBan = giaBan;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maGoi != null ? maGoi.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Goitin)) {
            return false;
        }
        Goitin other = (Goitin) object;
        if ((this.maGoi == null && other.maGoi != null) || (this.maGoi != null && !this.maGoi.equals(other.maGoi))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Goitin[ maGoi=" + maGoi + " ]";
    }
    
}
