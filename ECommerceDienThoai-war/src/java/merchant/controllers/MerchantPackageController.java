/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package merchant.controllers;

//import com.paypal.api.payments.Payment;
import ejb.entities.NguoiBan;
import ejb.entities.PhieuMuaTin;
import java.util.List;
import javax.servlet.http.HttpSession;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import web.services.GoiTinService;
//import web.services.PaypalService;
import web.services.SoTinTonService;

/**
 *
 * @author XinKaChu
 */
@Controller
@RequestMapping("merchant/package")
public class MerchantPackageController {
    //Nhúng GoiTinService để sử dụng
    @Autowired
    GoiTinService goiTinService;
    
//    @Autowired
//    PaypalService paypalService;
    
    @Autowired
    SoTinTonService soTinTonService;
    
    
    @RequestMapping("index")
    public String index(Model model, HttpSession httpSession) {
        goiTinService.laySoTinTon(model, httpSession);
        return "merchant/home/package";
    }   
    
    @RequestMapping("purchase")
    public String purchase(){
        
        return "merchant/home/purchase";
    }
    
    @RequestMapping("history")
    public String history(Model model, HttpSession httpSession){
        List<PhieuMuaTin> list = goiTinService.layDanhSachPhieuMuaTin(httpSession);
        model.addAttribute("phieuMuaTin", list);
        return "merchant/home/purchase-history";
    }
    
    /**
     * Xử lí mua gói tin khi merchant chọn thanh toán bằng Paypal
     */
    @RequestMapping("thanh-toan/{id}")
    public String thanhToanGoiTin(ModelMap model,
            @PathVariable("id") String id) {
        try {
//            String redirectURL = paypalService.paymentWithPaypal(goiTinService.timGoiTinTheoId(id));
//            if (redirectURL != null) {
//                return "redirect:" + redirectURL;
//            } else {
//                model.addAttribute("error", "Hệ thống bảo trì, xin vui lòng thử lại.");
//            }
        } catch (Exception ex) {
            model.addAttribute("error", "Lỗi hệ thống, xin vui lòng thử lại.");
        }
        return "merchant/home/purchase";
    }
    
    /**
     * Khi giao dịch thành công ở trang paypal, sẽ chuyển tới trang này rùi lưu
     * lại id liên quan đến hóa đơn giao dịch đó
     */
    @RequestMapping("xac-nhan-thanh-toan")
    public String xacNhanThanhToanPaypal(ModelMap model,
            @RequestParam(value = "paymentId", defaultValue = "") String paymentId,
            @RequestParam(value = "PayerID", defaultValue = "") String payerId,
            HttpSession httpSession) {

        if (paymentId.isEmpty() || payerId.isEmpty()) {
            return "redirect:/merchant/purchase/";
        } else {
//            Payment hoaDonPaypal = paypalService.completePaymentProcess(paymentId, payerId);
//            String idGoiTin = hoaDonPaypal.getTransactions().get(0).getItemList().getItems().get(0).getSku();
//            /// Cập nhật số tin            
//            soTinTonService.capNhatSoTinDang(goiTinService.timGoiTinTheoId(idGoiTin), httpSession);
//            /// Tạo phiếu mua tin
//            phieuMuaTinService.taoPhieuMuaTinQuaPayPal((NguoiBan) httpSession.getAttribute("merchant"),
//                    goiTinService.timGoiTinTheoId(idGoiTin), paymentId, payerId);
            return "redirect:/merchant/xu-ly-du-lieu/";
        }
    }
}
