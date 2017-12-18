/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.entities;

import java.io.Serializable;
import java.util.Date;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author HOME
 */
@Entity
@Table(name = "bien_ban_khoa_vinh_vien")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "BienBanKhoaVinhVien.findAll", query = "SELECT b FROM BienBanKhoaVinhVien b")
    , @NamedQuery(name = "BienBanKhoaVinhVien.findById", query = "SELECT b FROM BienBanKhoaVinhVien b WHERE b.id = :id")
    , @NamedQuery(name = "BienBanKhoaVinhVien.findByNgayKhoaVinhVien", query = "SELECT b FROM BienBanKhoaVinhVien b WHERE b.ngayKhoaVinhVien = :ngayKhoaVinhVien")
    , @NamedQuery(name = "BienBanKhoaVinhVien.findByLyDo", query = "SELECT b FROM BienBanKhoaVinhVien b WHERE b.lyDo = :lyDo")})
public class BienBanKhoaVinhVien implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Column(name = "ngay_khoa_vinh_vien")
    @Temporal(TemporalType.TIMESTAMP)
    private Date ngayKhoaVinhVien;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "ly_do")
    private String lyDo;
    @JoinColumn(name = "id_nguoi_ban", referencedColumnName = "id")
    @ManyToOne(optional = false)
    private NguoiBan idNguoiBan;

    public BienBanKhoaVinhVien() {
    }

    public BienBanKhoaVinhVien(Integer id) {
        this.id = id;
    }

    public BienBanKhoaVinhVien(Integer id, Date ngayKhoaVinhVien, String lyDo) {
        this.id = id;
        this.ngayKhoaVinhVien = ngayKhoaVinhVien;
        this.lyDo = lyDo;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Date getNgayKhoaVinhVien() {
        return ngayKhoaVinhVien;
    }

    public void setNgayKhoaVinhVien(Date ngayKhoaVinhVien) {
        this.ngayKhoaVinhVien = ngayKhoaVinhVien;
    }

    public String getLyDo() {
        return lyDo;
    }

    public void setLyDo(String lyDo) {
        this.lyDo = lyDo;
    }

    public NguoiBan getIdNguoiBan() {
        return idNguoiBan;
    }

    public void setIdNguoiBan(NguoiBan idNguoiBan) {
        this.idNguoiBan = idNguoiBan;
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
        if (!(object instanceof BienBanKhoaVinhVien)) {
            return false;
        }
        BienBanKhoaVinhVien other = (BienBanKhoaVinhVien) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.BienBanKhoaVinhVien[ id=" + id + " ]";
    }
    
}
