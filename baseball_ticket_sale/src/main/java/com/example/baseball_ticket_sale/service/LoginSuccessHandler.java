package com.example.baseball_ticket_sale.service;

import com.example.baseball_ticket_sale.SecurityConfig;
import org.springframework.security.core.Authentication;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

public class LoginSuccessHandler implements AuthenticationSuccessHandler {
    @Override
    public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response, Authentication authentication) throws IOException, ServletException, IOException {
//        로그인에 성공했을 떄
        HttpSession session = request.getSession();
        session.setAttribute("my_greeting", authentication.getName() + " 님 환영합니다.");
        response.sendRedirect("/");
    }
}
