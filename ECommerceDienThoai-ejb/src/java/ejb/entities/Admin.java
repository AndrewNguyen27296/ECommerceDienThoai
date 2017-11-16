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
@Table(name = "admin")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "Admin.findAll", query = "SELECT a FROM Admin a"),
    @NamedQuery(name = "Admin.findByMaAdmin", query = "SELECT a FROM Admin a WHERE a.maAdmin = :maAdmin"),
    @NamedQuery(name = "Admin.findByEmail", query = "SELECT a FROM Admin a WHERE a.email = :email"),
    @NamedQuery(name = "Admin.findByMatKhau", query = "SELECT a FROM Admin a WHERE a.matKhau = :matKhau"),
    @NamedQuery(name = "Admin.findByHoTen", query = "SELECT a FROM Admin a WHERE a.hoTen = :hoTen"),
    @NamedQuery(name = "Admin.findBySoDT", query = "SELECT a FROM Admin a WHERE a.soDT = :soDT"),
    @NamedQuery(name = "Admin.findBySoTK", query = "SELECT a FROM Admin a WHERE a.soTK = :soTK"),
    @NamedQuery(name = "Admin.findByDiaChi", query = "SELECT a FROM Admin a WHERE a.diaChi = :diaChi"),
    @NamedQuery(name = "Admin.findByTrangThai", query = "SELECT a FROM Admin a WHERE a.trangThai = :trangThai")})
public class Admin implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "MaAdmin")
    private Integer maAdmin;
    // @Pattern(regexp="[a-z0-9!#$%&'*+/=?^_`{|}~-]+(?:\\.[a-z0-9!#$%&'*+/=?^_`{|}~-]+)*@(?:[a-z0-9](?:[a-z0-9-]*[a-z0-9])?\\.)+[a-z0-9](?:[a-z0-9-]*[a-z0-9])?", message="Invalid email")//if the field contains email address consider using this annotation to enforce field validation
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "Email")
    private String email;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "MatKhau")
    private String matKhau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "HoTen")
    private String hoTen;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 11)
    @Column(name = "SoDT")
    private String soDT;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 12)
    @Column(name = "SoTK")
    private String soTK;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 150)
    @Column(name = "DiaChi")
    private String diaChi;
    @Basic(optional = false)
    @NotNull
    @Column(name = "TrangThai")
    private boolean trangThai;

    public Admin() {
    }

    public Admin(Integer maAdmin) {
        this.maAdmin = maAdmin;
    }

    public Admin(Integer maAdmin, String email, String matKhau, String hoTen, String soDT, String soTK, String diaChi, boolean trangThai) {
        this.maAdmin = maAdmin;
        this.email = email;
        this.matKhau = matKhau;
        this.hoTen = hoTen;
        this.soDT = soDT;
        this.soTK = soTK;
        this.diaChi = diaChi;
        this.trangThai = trangThai;
    }

    public Integer getMaAdmin() {
        return maAdmin;
    }

    public void setMaAdmin(Integer maAdmin) {
        this.maAdmin = maAdmin;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getMatKhau() {
        return matKhau;
    }

    public void setMatKhau(String matKhau) {
        this.matKhau = matKhau;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public String getSoDT() {
        return soDT;
    }

    public void setSoDT(String soDT) {
        this.soDT = soDT;
    }

    public String getSoTK() {
        return soTK;
    }

    public void setSoTK(String soTK) {
        this.soTK = soTK;
    }

    public String getDiaChi() {
        return diaChi;
    }

    public void setDiaChi(String diaChi) {
        this.diaChi = diaChi;
    }

    public boolean getTrangThai() {
        return trangThai;
    }

    public void setTrangThai(boolean trangThai) {
        this.trangThai = trangThai;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (maAdmin != null ? maAdmin.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Admin)) {
            return false;
        }
        Admin other = (Admin) object;
        if ((this.maAdmin == null && other.maAdmin != null) || (this.maAdmin != null && !this.maAdmin.equals(other.maAdmin))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.Admin[ maAdmin=" + maAdmin + " ]";
    }
    
}
