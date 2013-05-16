package com.wxy.servlet.user;

import org.shinshi.gallery.model.UserModel;
import org.shinshi.gallery.model.UserRole;
import org.shinshi.gallery.service.IAccountService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;

/**
 * Created with IntelliJ IDEA.
 * User: apple
 * Date: 13-5-11
 * Time: 上午10:04
 * To change this template use File | Settings | File Templates.
 */
@WebServlet(name = "UserRegisterServlet")



public class UserRegisterServlet extends HttpServlet
{
    private  IAccountService accountService;
    public UserRegisterServlet(IAccountService accountService)
    {
        super();
        this.accountService = accountService;
    }

    protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException
    {
        //user_name, pass_word, email
        String userName = request.getParameter("user_name");
        String pass_word = request.getParameter("pass_word");
        String email = request.getParameter("email");

        UserModel userModel = new UserModel();

        userModel.setName(userName);
        userModel.setEmail(email);
        userModel.setPassword(pass_word);
        userModel.setRole(UserRole.MEMBER);
        long time = System.currentTimeMillis();
        userModel.setJoinedAt(time);
        userModel.setLastLoginAt(time);

        boolean isSuccess = false;
        //TODO register
        try
        {
            this.accountService.register(userModel);

            HttpSession session = request.getSession();
            synchronized (session)
            {
                session.setAttribute("user_name",userName);
            }
        }
        catch (Exception e)
        {
        }
        Boolean isSuccessObj = new Boolean(isSuccess);
        request.setAttribute("isLoginSuccess",isSuccessObj);
        RequestDispatcher view = request.getRequestDispatcher("user_register_result.jsp");
        view.forward(request,response);
    }

}
