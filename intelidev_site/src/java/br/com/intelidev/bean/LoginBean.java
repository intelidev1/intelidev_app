/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intelidev.bean;



import br.com.intelidev.dao.userDao;
import br.com.intelidev.entity.Usuario;
import br.com.intelidev.session.SessionUtils;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.servlet.http.HttpSession;

/**
 *
 * @author diogenes
 */
@ManagedBean(name = "loginBeanCrt")
@SessionScoped
public class LoginBean {
    
    private Usuario usuario;
    
    /**
     * Creates a new instance of LoginBean
     */
    public LoginBean() {
        usuario = new Usuario();
    }
    
    public String login_on_digi(String user,String pass, String page){ 
        System.out.println("Usuario:" + user + "passwd:" + pass);
        if(new userDao().login_acess(user, pass)){
            usuario.setUsername(user);
            usuario.setPassword(pass);
            HttpSession session = SessionUtils.getSession();
            session.setAttribute("username", user);
            System.out.println("br.com.intelidev.bean.LoginBean.login_on_digi() conectado: " + user);
            return page;
        }
        else
        {
            System.out.println("br.com.intelidev.bean.LoginBean.login_on_digi() Não conectado: " + user);
            return "index";
        }
    }

    //logout event, invalidate session
    public String logout() {
        HttpSession session = SessionUtils.getSession();
        session.invalidate();
        return "index";
    }
    
    
    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }
    
    
}
