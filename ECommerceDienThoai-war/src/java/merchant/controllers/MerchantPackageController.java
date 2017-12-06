/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchant.controllers;

import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import web.services.GoiTinService;

/**
 *
 * @author XinKaChu
 */
@Controller
@RequestMapping("merchant/package")
public class MerchantPackageController {
    @Autowired
    GoiTinService goiTinService;
    
    @RequestMapping("index")
    public String index(Model model, HttpSession httpSession) {
        goiTinService.laySoTinTon(model, httpSession);
        return "merchant/home/package";
    }
    
    @RequestMapping("purchase")
    public String purchase(){
        return "merchant/home/purchase";
    }
    
    
}
