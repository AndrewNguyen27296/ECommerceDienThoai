/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.BienBanKhoaVinhVien;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author HOME
 */
@Stateless
public class BienBanKhoaVinhVienFacade extends AbstractFacade<BienBanKhoaVinhVien> {

    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public BienBanKhoaVinhVienFacade() {
        super(BienBanKhoaVinhVien.class);
    }
    
}
