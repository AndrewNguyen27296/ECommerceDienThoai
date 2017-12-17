/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

import ejb.entities.CtPhieuMuaHang;
import ejb.entities.PhieuMuaHang;
import ejb.sessions.CtPhieuMuaHangFacade;
import ejb.sessions.PhieuMuaHangFacade;
import java.util.List;

/**
 *
 * @author XinKaChu
 */
public class PhieuMuaHangService {
    
    //Nhúng facade để sử dụng entities
    PhieuMuaHangFacade phieuMuaHangFacade = (PhieuMuaHangFacade) LookupFactory.lookupFacadeBean("PhieuMuaHangFacade");
    CtPhieuMuaHangFacade ctPhieuMuaHangFacade = (CtPhieuMuaHangFacade) LookupFactory.lookupFacadeBean("CtPhieuMuaHangFacade");
    
    //Lấy danh sách phiếu mua hàng
    public List<PhieuMuaHang> layDanhSachPhieuMuaHang(){
            return phieuMuaHangFacade.findAll();
            }
    
    //Lấy danh sách ct_phiếu mua hàng
    public List<CtPhieuMuaHang> layDanhSachCTPhieuMuaHang(){
        return ctPhieuMuaHangFacade.findAll();
    }
    
}
