/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intelidev.entity;



/**
 *
 * @author diogenes
 */
public class Dados {
    private String id;
    private String stream_id;
    private String value;
    private String timestamp;
    private String server_timestamp;
    private int quality; 

    public Dados(){
    }

    public Dados(String id, String stream_id, String value, String timestamp, String server_timestamp, int quality) {
        this.id = id;
        this.stream_id = stream_id;
        this.value = value;
        this.timestamp = timestamp;
        this.server_timestamp = server_timestamp;
        this.quality = quality;
    }
    

    
    
    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getStream_id() {
        return stream_id;
    }

    public void setStream_id(String stream_id) {
        this.stream_id = stream_id;
    }

    public String getValue() {
        return value;
    }

    public void setValue(String value) {
        this.value = value;
    }

    public String getTimestamp() {
        return timestamp;
    }

    public void setTimestamp(String timestamp) {
        this.timestamp = timestamp;
    }

    public int getQuality() {
        return quality;
    }

    public void setQuality(int quality) {
        this.quality = quality;
    }

    public String getServer_timestamp() {
        return server_timestamp;
    }

    public void setServer_timestamp(String server_timestamp) {
        this.server_timestamp = server_timestamp;
    }
    
    
}
