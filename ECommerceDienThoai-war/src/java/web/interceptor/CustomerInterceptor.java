/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package web.interceptor;

import ejb.entities.NguoiMua;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

/**
 *
 * @author DacTien
 */
public class CustomerInterceptor extends HandlerInterceptorAdapter {

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        HttpSession httpSession = request.getSession();
        NguoiMua user = (NguoiMua) httpSession.getAttribute("nguoiMua");
        if (user == null) {
            String cpath = request.getContextPath();
//            String url = request.getRequestURI().replace(cpath, "");
//            httpSession.setAttribute("BackUrl", url);
            response.sendRedirect(cpath + "/home/index.php");
            return false;
        }
        return true;
    }
}
