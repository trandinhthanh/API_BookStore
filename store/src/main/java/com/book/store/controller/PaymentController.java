package com.book.store.controller;


import com.book.store.modelConvert.NguoiDungConvert;
import com.book.store.utils.Utils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import com.paypal.api.payments.Links;
import com.paypal.api.payments.Payment;
import com.paypal.base.rest.PayPalRESTException;
import com.book.store.config.PaypalPaymentIntent;
import com.book.store.config.PaypalPaymentMethod;
import com.book.store.serviceImpl.PaypalService;
import org.springframework.web.servlet.ModelAndView;

import javax.servlet.http.HttpServletRequest;
import java.util.List;

@Controller
@RequestMapping("paypal")
@CrossOrigin(origins = "*")
public class PaymentController {

    public static final String URL_PAYPAL_SUCCESS = "/pay/success";
    public static final String URL_PAYPAL_CANCEL = "/pay/cancel";

    @Value("${paypal.vnd_to_usd}")
    private double VND_TO_USD;

    private Logger log = LoggerFactory.getLogger(getClass());

    @Autowired
    private PaypalService paypalService;

    //chuyển sang trang web paypal
    @PostMapping("/pay")
    public ResponseEntity<String> pay(HttpServletRequest request, @RequestParam("price") double price ){
        String cancelUrl = Utils.getBaseURL(request) + "/paypal" + URL_PAYPAL_CANCEL;
        String successUrl = Utils.getBaseURL(request) + "/paypal" + URL_PAYPAL_SUCCESS;
        double priceUSD = price/VND_TO_USD;
        try {
            Payment payment = paypalService.createPayment(
                    priceUSD,
                    "USD",
                    PaypalPaymentMethod.paypal,
                    PaypalPaymentIntent.sale,
                    "Thanh toán đơn hàng từ BookStore",
                    cancelUrl,
                    successUrl);
            for(Links links : payment.getLinks()){
                if(links.getRel().equals("approval_url")){
                    return new ResponseEntity<>(links.getHref(), HttpStatus.OK);
                }
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return  new ResponseEntity<>("redirect:/", HttpStatus.OK);
    }

    // trả về kết quà nếu hủy giao dịch
    @RequestMapping(value = URL_PAYPAL_CANCEL, method = RequestMethod.GET)
    public ModelAndView cancelPay(){
        ModelAndView pav = new ModelAndView("cancel");
        return pav;
    }

    // khi thanh toán thành công gọi về trang index, xữ lý lưu giao dịch, gửi email xác nhận
    @RequestMapping(value = URL_PAYPAL_SUCCESS, method = RequestMethod.GET)
    public ModelAndView successPay(@RequestParam("paymentId") String paymentId, @RequestParam("PayerID") String payerId){
        ModelAndView pav = new ModelAndView("success");
        try {
            Payment payment = paypalService.executePayment(paymentId, payerId);
            if(payment.getState().equals("approved")){
                return pav;
            }
        } catch (PayPalRESTException e) {
            log.error(e.getMessage());
        }
        return pav;
    }
}
