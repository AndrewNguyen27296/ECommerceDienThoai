/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.CtPhieuMuaHang;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author myly
 */
@Stateless
public class CtPhieuMuaHangFacade extends AbstractFacade<CtPhieuMuaHang> {

    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public CtPhieuMuaHangFacade() {
        super(CtPhieuMuaHang.class);
    }
    
}
