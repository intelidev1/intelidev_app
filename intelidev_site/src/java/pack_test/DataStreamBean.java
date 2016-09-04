/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package pack_test;

import javax.faces.bean.ManagedBean;
import javax.faces.bean.RequestScoped;

/**
 *
 * @author diogenes
 */
@ManagedBean(name = "dataStreamBeancrt")
@RequestScoped
public class DataStreamBean {
    private Get_stream get_stream;
    private String status;
    /**
     * Creates a new instance of DataStreamBean
     */
    public DataStreamBean() {
        this.status = "ola";
        this.get_stream = new Get_stream();
    }
    public void requestPstream(){
        System.err.println("Teste");
        this.get_stream.main();
    }
    
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    
}
