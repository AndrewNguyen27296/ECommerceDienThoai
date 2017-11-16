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
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import javax.xml.bind.annotation.XmlRootElement;

/**
 *
 * @author DacTien
 */
@Entity
@Table(name = "thong_so_ky_thuat")
@XmlRootElement
@NamedQueries({
    @NamedQuery(name = "ThongSoKyThuat.findAll", query = "SELECT t FROM ThongSoKyThuat t")
    , @NamedQuery(name = "ThongSoKyThuat.findById", query = "SELECT t FROM ThongSoKyThuat t WHERE t.id = :id")
    , @NamedQuery(name = "ThongSoKyThuat.findByCameraTruoc", query = "SELECT t FROM ThongSoKyThuat t WHERE t.cameraTruoc = :cameraTruoc")
    , @NamedQuery(name = "ThongSoKyThuat.findByCameraSau", query = "SELECT t FROM ThongSoKyThuat t WHERE t.cameraSau = :cameraSau")
    , @NamedQuery(name = "ThongSoKyThuat.findByDungLuongPin", query = "SELECT t FROM ThongSoKyThuat t WHERE t.dungLuongPin = :dungLuongPin")
    , @NamedQuery(name = "ThongSoKyThuat.findByTheNho", query = "SELECT t FROM ThongSoKyThuat t WHERE t.theNho = :theNho")})
public class ThongSoKyThuat implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Basic(optional = false)
    @Column(name = "id")
    private Integer id;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "camera_truoc")
    private String cameraTruoc;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "camera_sau")
    private String cameraSau;
    @Basic(optional = false)
    @NotNull
    @Size(min = 1, max = 250)
    @Column(name = "dung_luong_pin")
    private String dungLuongPin;
    @Basic(optional = false)
    @NotNull
    @Column(name = "the_nho")
    private boolean theNho;
    @JoinColumn(name = "id_bo_nho_trong", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private BoNhoTrong idBoNhoTrong;
    @JoinColumn(name = "id_chip_do_hoa", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private ChipDoHoa idChipDoHoa;
    @JoinColumn(name = "id_cpu", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Cpu idCpu;
    @JoinColumn(name = "id_do_phan_giai", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private DoPhanGiai idDoPhanGiai;
    @JoinColumn(name = "id_he_dieu_hanh", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private HeDieuHanh idHeDieuHanh;
    @JoinColumn(name = "id_kich_thuoc_man_hinh", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private KichThuocManHinh idKichThuocManHinh;
    @JoinColumn(name = "id_loai_man_hinh", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private LoaiManHinh idLoaiManHinh;
    @JoinColumn(name = "id_ram", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private Ram idRam;
    @JoinColumn(name = "id_san_pham", referencedColumnName = "id")
    @ManyToOne(optional = false, fetch = FetchType.LAZY)
    private SanPham idSanPham;

    public ThongSoKyThuat() {
    }

    public ThongSoKyThuat(Integer id) {
        this.id = id;
    }

    public ThongSoKyThuat(Integer id, String cameraTruoc, String cameraSau, String dungLuongPin, boolean theNho) {
        this.id = id;
        this.cameraTruoc = cameraTruoc;
        this.cameraSau = cameraSau;
        this.dungLuongPin = dungLuongPin;
        this.theNho = theNho;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCameraTruoc() {
        return cameraTruoc;
    }

    public void setCameraTruoc(String cameraTruoc) {
        this.cameraTruoc = cameraTruoc;
    }

    public String getCameraSau() {
        return cameraSau;
    }

    public void setCameraSau(String cameraSau) {
        this.cameraSau = cameraSau;
    }

    public String getDungLuongPin() {
        return dungLuongPin;
    }

    public void setDungLuongPin(String dungLuongPin) {
        this.dungLuongPin = dungLuongPin;
    }

    public boolean getTheNho() {
        return theNho;
    }

    public void setTheNho(boolean theNho) {
        this.theNho = theNho;
    }

    public BoNhoTrong getIdBoNhoTrong() {
        return idBoNhoTrong;
    }

    public void setIdBoNhoTrong(BoNhoTrong idBoNhoTrong) {
        this.idBoNhoTrong = idBoNhoTrong;
    }

    public ChipDoHoa getIdChipDoHoa() {
        return idChipDoHoa;
    }

    public void setIdChipDoHoa(ChipDoHoa idChipDoHoa) {
        this.idChipDoHoa = idChipDoHoa;
    }

    public Cpu getIdCpu() {
        return idCpu;
    }

    public void setIdCpu(Cpu idCpu) {
        this.idCpu = idCpu;
    }

    public DoPhanGiai getIdDoPhanGiai() {
        return idDoPhanGiai;
    }

    public void setIdDoPhanGiai(DoPhanGiai idDoPhanGiai) {
        this.idDoPhanGiai = idDoPhanGiai;
    }

    public HeDieuHanh getIdHeDieuHanh() {
        return idHeDieuHanh;
    }

    public void setIdHeDieuHanh(HeDieuHanh idHeDieuHanh) {
        this.idHeDieuHanh = idHeDieuHanh;
    }

    public KichThuocManHinh getIdKichThuocManHinh() {
        return idKichThuocManHinh;
    }

    public void setIdKichThuocManHinh(KichThuocManHinh idKichThuocManHinh) {
        this.idKichThuocManHinh = idKichThuocManHinh;
    }

    public LoaiManHinh getIdLoaiManHinh() {
        return idLoaiManHinh;
    }

    public void setIdLoaiManHinh(LoaiManHinh idLoaiManHinh) {
        this.idLoaiManHinh = idLoaiManHinh;
    }

    public Ram getIdRam() {
        return idRam;
    }

    public void setIdRam(Ram idRam) {
        this.idRam = idRam;
    }

    public SanPham getIdSanPham() {
        return idSanPham;
    }

    public void setIdSanPham(SanPham idSanPham) {
        this.idSanPham = idSanPham;
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
        if (!(object instanceof ThongSoKyThuat)) {
            return false;
        }
        ThongSoKyThuat other = (ThongSoKyThuat) object;
        if ((this.id == null && other.id != null) || (this.id != null && !this.id.equals(other.id))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "ejb.entities.ThongSoKyThuat[ id=" + id + " ]";
    }
    
}
