/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ejb.sessions;

import ejb.entities.Mausac;
import javax.ejb.Stateless;
import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

/**
 *
 * @author XinKaChu
 */
@Stateless
public class MausacFacade extends AbstractFacade<Mausac> {

    @PersistenceContext(unitName = "ECommerceDienThoai-ejbPU")
    private EntityManager em;

    @Override
    protected EntityManager getEntityManager() {
        return em;
    }

    public MausacFacade() {
        super(Mausac.class);
    }
    
}
