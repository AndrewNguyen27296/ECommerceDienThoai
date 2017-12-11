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
@RequestMapping("merchant/post")
public class MerchantPostController {
    //Nhúng GoiTinService để sử dụng
    @Autowired
    GoiTinService goiTinService;
    
    @RequestMapping("new")
    public String post(Model model, HttpSession httpSession){
        goiTinService.laySoTinTon(model, httpSession);
        return "merchant/home/post";
    }
}
