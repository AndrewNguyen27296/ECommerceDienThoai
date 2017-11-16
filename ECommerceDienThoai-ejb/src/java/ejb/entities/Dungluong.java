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
@Table(name = "dungluong")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dungluong.findAll", query = "SELECT d FROM Dungluong d"),
    @NamedQuery(name = "Dungluong.findByMaDungLuong", query = "SELECT d FROM Dungluong d WHERE d.maDungLuong = :maDungLuong"),
    @NamedQuery(name = "Dungluong.findByDungLuong", query = "SELECT d FROM Dungluong d WHERE d.dungLuong = :dungLuong")})
public class Dungluong implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaDungLuong")
    private Integer maDungLuong;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DungLuong")
    private String dungLuong;

    public Dungluong() {
    }

    public Dungluong(Integer maDungLuong) {
        this.maDungLuong = maDungLuong;
    }

    public Dungluong(Integer maDungLuong, String dungLuong) {
        this.maDungLuong = maDungLuong;
        this.dungLuong = dungLuong;
    }

    public Integer getMaDungLuong() {
        return maDungLuong;
    }

    public void setMaDungLuong(Integer maDungLuong) {
        this.maDungLuong = maDungLuong;
    }

    public String getDungLuong() {
        return dungLuong;
    }

    public void setDungLuong(String dungLuong) {
        this.dungLuong = dungLuong;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDungLuong != null ? maDungLuong.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dungluong)) {
            return false;
        }
        Dungluong other = (Dungluong) object;
        if ((this.maDungLuong == null && other.maDungLuong != null) || (this.maDungLuong != null && !this.maDungLuong.equals(other.maDungLuong))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Dungluong[ maDungLuong=" + maDungLuong + " ]";
    }
    
}
