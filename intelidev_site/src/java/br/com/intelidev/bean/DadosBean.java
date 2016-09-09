/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intelidev.bean;

import br.com.intelidev.dao.DadosDao;
import br.com.intelidev.entity.Dados;
import br.com.intelidev.entity.Usuario;
import java.util.ArrayList;
import java.util.List;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

/**
 *
 * @author diogenes
 */
@ManagedBean(name ="dadosBeanCrt")
@SessionScoped
public class DadosBean {
    private List<Dados> list_dados;
    /**
     * Creates a new instance of DadosBean
     */
    public DadosBean() {
        this.list_dados = new ArrayList<>();
    }
    
    public void set_list_dados(Usuario user){
        this.list_dados = new DadosDao().get_stream_data("00000000-00000000-00409DFF-FF6064F8/xbee.analog/[00:13:A2:00:40:E6:5A:88]!/AD1", user.getUsername(), user.getPassword());
        System.out.println("this.list_dados.size(): " + this.list_dados.size());
        //return this.list_dados;
    }

    public List<Dados> getList_dados() {
        return list_dados;
    }

    public void setList_dados(List<Dados> list_dados) {
        this.list_dados = list_dados;
    }
    
    
}
