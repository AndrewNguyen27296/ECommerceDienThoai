/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.services;

//import com.paypal.api.payments.Amount;
//import com.paypal.api.payments.Payer;
//import com.paypal.api.payments.Item;
//import com.paypal.api.payments.ItemList;
//import com.paypal.api.payments.Links;
//import com.paypal.api.payments.Payment;
//import com.paypal.api.payments.PaymentExecution;
//import com.paypal.api.payments.RedirectUrls;
//import com.paypal.api.payments.Transaction;
//import static com.paypal.base.Constants.SANDBOX;
//import com.paypal.base.rest.APIContext;
//import com.paypal.base.rest.PayPalRESTException;
import common.Constants;
import ejb.entities.GoiTin;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import org.springframework.stereotype.Component;
/**
 *
 * @author XinKaChu
 */
//@Component
//public class PaypalService {
//
//    public String paymentWithPaypal(GoiTin goiTin) {
//        APIContext apiContext = new APIContext(Constants.clientID, Constants.clientSecret, SANDBOX);
//        // Set payer details
//        Payer payer = new Payer();
//        payer.setPaymentMethod("paypal");
//
//        // Set redirect URLs
//        RedirectUrls redirectUrls = new RedirectUrls();
//        redirectUrls.setCancelUrl("http://localhost:8080/ECommerceDienThoai-war/merchant/huy-thanh-toan/");
//        redirectUrls.setReturnUrl("http://localhost:8080/ECommerceDienThoai-war/merchant/xac-nhan-thanh-toan/");
//
//        // ### Items
//        Item item = new Item();
//        item.setSku(goiTin.getId()+"")
//                .setName(goiTin.getTenGoiTin())
//                .setQuantity("1")
//                .setCurrency("USD")
//                .setPrice(String.format("%.2f", (goiTin.getGiaBan() * 0.044) / 1000.0))
//                .setDescription(String.format("Mua gói tin đăng với giá bán là: %.2f, tỉ giá 1000 VNĐ = 0.044USD", goiTin.getGiaBan()));
//        ItemList itemList = new ItemList();
//        List<Item> items = new ArrayList<Item>();
//        items.add(item);
//        itemList.setItems(items);
//
//        // Payment amount
//        Amount amount = new Amount();
//        amount.setCurrency("USD");
//        // Total must be equal to sum of shipping, tax and subtotal.
//        amount.setTotal(String.format("%.2f", (goiTin.getGiaBan() * 0.044) / 1000.0));
//
//        // Transaction information
//        Transaction transaction = new Transaction();
//        transaction.setAmount(amount);
//        transaction.setDescription("Thanh toán gói tin đăng.");
//        transaction.setItemList(itemList);
//
//        // The Payment creation API requires a list of
//        // Transaction; add the created `Transaction`
//        // to a List
//        List<Transaction> transactions = new ArrayList<Transaction>();
//        transactions.add(transaction);
//
//        // Add payment details
//        Payment payment = new Payment();
//        payment.setIntent("sale");
//        payment.setPayer(payer);
//        payment.setRedirectUrls(redirectUrls);
//        payment.setTransactions(transactions);
//
//        // Create payment
//        try {
//            Payment createdPayment = payment.create(apiContext);
//
//            Iterator links = createdPayment.getLinks().iterator();
//            while (links.hasNext()) {
//                Links link = (Links) links.next();
//                //
//                if (link.getRel().equalsIgnoreCase("approval_url")) {
//                    return link.getHref();
//                }
//            }
//        } catch (PayPalRESTException e) {
//            throw new RuntimeException(e.getMessage());
//        }
//        return null;
//    }
        // quá trình xử lí thanh toán thành công 
    
            // paymentId hóa đơn do paypal tự tạo, payerId id account của người mua
//    public Payment completePaymentProcess(String paymentId, String payerId) {
//        APIContext apiContext = new APIContext(Constants.clientID, Constants.clientSecret, SANDBOX);
//        if (paymentId != null && payerId != null) {
//            Payment payment = new Payment();
//            payment.setId(paymentId);
//
//            PaymentExecution paymentExecution = new PaymentExecution();
//            paymentExecution.setPayerId(payerId);
//            try {
//                Payment createdPayment = payment.execute(apiContext, paymentExecution);
//                System.out.println(createdPayment);
//                return createdPayment;
//            } catch (PayPalRESTException e) {
//                System.err.println(e.getDetails());
//                return null;
//            }
//        } else {
//            return null;
//        }
//    }

//}
