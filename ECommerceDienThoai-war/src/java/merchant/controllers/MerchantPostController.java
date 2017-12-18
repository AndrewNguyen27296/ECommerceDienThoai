/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchant.controllers;

import ejb.entities.NguoiBan;
import ejb.entities.SanPham;
import java.io.File;
import java.util.Date;
import javax.servlet.ServletContext;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;
import web.models.SanPhamViewModel;
import web.services.GoiTinService;
import web.services.PostService;

/**
 *
 * @author XinKaChu
 */
@Controller
@RequestMapping("merchant/post")
public class MerchantPostController {

    //Nhúng GoiTinService để sử dụng
    @Autowired
    PostService postService;

    @Autowired
    ServletContext app;

    @RequestMapping("new")
    public String post(Model model) {
        model.addAttribute("hangSanXuat", postService.layDanhSachHangSanXuat());
        return "merchant/home/post";
    }

    @RequestMapping("list")
    public String list(Model model, HttpSession httpSession) {
        NguoiBan nguoiBan = (NguoiBan) httpSession.getAttribute("nguoiBan");
        model.addAttribute("sanPham", httpSession.getAttribute("sanPham"));
        return "merchant/home/post-list";
    }

    @RequestMapping(value = "new", method=RequestMethod.POST)
    public String dangTin(Model model,
            SanPhamViewModel sanPhamVM,
            @RequestParam
            MultipartFile hinhAnh,
            HttpServletRequest request,
            HttpSession httpSession) {
        String temp = postService.dangTin(model, sanPhamVM, hinhAnh, request, httpSession);
        return temp;
    }
}
