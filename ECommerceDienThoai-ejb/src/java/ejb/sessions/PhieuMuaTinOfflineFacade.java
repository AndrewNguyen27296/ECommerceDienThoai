/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.PhieuMuaTinOffline;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author myly
 */
@Stateless
public class PhieuMuaTinOfflineFacade extends AbstractFacade<PhieuMuaTinOffline> {

    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public PhieuMuaTinOfflineFacade() {
        super(PhieuMuaTinOffline.class);
    }
    
}
