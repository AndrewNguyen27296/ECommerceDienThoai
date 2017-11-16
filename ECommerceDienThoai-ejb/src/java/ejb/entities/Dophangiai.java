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
@Table(name = "dophangiai")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Dophangiai.findAll", query = "SELECT d FROM Dophangiai d"),
    @NamedQuery(name = "Dophangiai.findByMaDoPhanGiai", query = "SELECT d FROM Dophangiai d WHERE d.maDoPhanGiai = :maDoPhanGiai"),
    @NamedQuery(name = "Dophangiai.findByDoPhanGiai", query = "SELECT d FROM Dophangiai d WHERE d.doPhanGiai = :doPhanGiai")})
public class Dophangiai implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaDoPhanGiai")
    private Integer maDoPhanGiai;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DoPhanGiai")
    private String doPhanGiai;

    public Dophangiai() {
    }

    public Dophangiai(Integer maDoPhanGiai) {
        this.maDoPhanGiai = maDoPhanGiai;
    }

    public Dophangiai(Integer maDoPhanGiai, String doPhanGiai) {
        this.maDoPhanGiai = maDoPhanGiai;
        this.doPhanGiai = doPhanGiai;
    }

    public Integer getMaDoPhanGiai() {
        return maDoPhanGiai;
    }

    public void setMaDoPhanGiai(Integer maDoPhanGiai) {
        this.maDoPhanGiai = maDoPhanGiai;
    }

    public String getDoPhanGiai() {
        return doPhanGiai;
    }

    public void setDoPhanGiai(String doPhanGiai) {
        this.doPhanGiai = doPhanGiai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maDoPhanGiai != null ? maDoPhanGiai.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Dophangiai)) {
            return false;
        }
        Dophangiai other = (Dophangiai) object;
        if ((this.maDoPhanGiai == null && other.maDoPhanGiai != null) || (this.maDoPhanGiai != null && !this.maDoPhanGiai.equals(other.maDoPhanGiai))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Dophangiai[ maDoPhanGiai=" + maDoPhanGiai + " ]";
    }
    
}
