/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.controllers;

import com.google.gson.Gson;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;
import web.services.AdminService;

/**
 *
 * @author XinKaChu
 */
@Controller
public class DemoController {

    @Autowired
    AdminService adminService;

    @RequestMapping(value = {"", "demo"})
    public String index() {
        return "demo/index";
    }

//    @ModelAttribute("dsAdmin")
//    public List<Admin> layDanhSachAdmin() {
//        return adminService.layDanhSachAdmin();
//    }
    
//    @ResponseBody
//    @RequestMapping("api")
//    public String layDanhSachAdminJSON() {
//        return new Gson().toJson(adminService.layDanhSachAdmin());
//    }

}
