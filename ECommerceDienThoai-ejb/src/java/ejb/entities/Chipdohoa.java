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
@Table(name = "chipdohoa")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Chipdohoa.findAll", query = "SELECT c FROM Chipdohoa c"),
    @NamedQuery(name = "Chipdohoa.findByMaChipDoHoa", query = "SELECT c FROM Chipdohoa c WHERE c.maChipDoHoa = :maChipDoHoa"),
    @NamedQuery(name = "Chipdohoa.findByChipDoHoa", query = "SELECT c FROM Chipdohoa c WHERE c.chipDoHoa = :chipDoHoa")})
public class Chipdohoa implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaChipDoHoa")
    private Integer maChipDoHoa;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "ChipDoHoa")
    private String chipDoHoa;

    public Chipdohoa() {
    }

    public Chipdohoa(Integer maChipDoHoa) {
        this.maChipDoHoa = maChipDoHoa;
    }

    public Chipdohoa(Integer maChipDoHoa, String chipDoHoa) {
        this.maChipDoHoa = maChipDoHoa;
        this.chipDoHoa = chipDoHoa;
    }

    public Integer getMaChipDoHoa() {
        return maChipDoHoa;
    }

    public void setMaChipDoHoa(Integer maChipDoHoa) {
        this.maChipDoHoa = maChipDoHoa;
    }

    public String getChipDoHoa() {
        return chipDoHoa;
    }

    public void setChipDoHoa(String chipDoHoa) {
        this.chipDoHoa = chipDoHoa;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maChipDoHoa != null ? maChipDoHoa.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Chipdohoa)) {
            return false;
        }
        Chipdohoa other = (Chipdohoa) object;
        if ((this.maChipDoHoa == null && other.maChipDoHoa != null) || (this.maChipDoHoa != null && !this.maChipDoHoa.equals(other.maChipDoHoa))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Chipdohoa[ maChipDoHoa=" + maChipDoHoa + " ]";
    }
    
}
