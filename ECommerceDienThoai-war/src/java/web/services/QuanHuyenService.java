/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.business.QuanHuyenBusiness;
import ejb.entities.QuanHuyen;
import ejb.entities.ThanhPho;
import java.util.List;
import org.springframework.stereotype.Component;

/**
 *
 * @author DacTien
 */
@Component
public class QuanHuyenService {
    QuanHuyenBusiness quanHuyenBusiness = (QuanHuyenBusiness) LookupFactory.lookupBusinessBean("QuanHuyenBusiness");
    
    public List<QuanHuyen> getQuanHuyen(ThanhPho thanhPho) {
        return quanHuyenBusiness.getQuanHuyen(thanhPho);
    }
}
