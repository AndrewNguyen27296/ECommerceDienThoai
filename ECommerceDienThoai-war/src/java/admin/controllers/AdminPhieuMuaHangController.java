/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package admin.controllers;

import ejb.entities.PhieuMuaHang;
import ejb.sessions.PhieuMuaHangFacade;
import java.util.List;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.services.LookupFactory;

/**
 *
 * @author DacTien
 */
@RequestMapping("admin/order")
public class AdminPhieuMuaHangController {
    PhieuMuaHangFacade phieuMuaHangFacade = (PhieuMuaHangFacade) LookupFactory.lookupFacadeBean("PhieuMuaHangFacade");
    
    @RequestMapping("all")
    public String order(Model model) {
        List<PhieuMuaHang> list = phieuMuaHangFacade.findAll();
        model.addAttribute("phieuMuaHangs", list);
        return "admin/order/danhSachPhieuMuaHang";
    }
}
