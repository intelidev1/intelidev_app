/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package br.com.intelidev.entity;

import java.util.List;

/**
 *
 * @author diogenes
 */
public class StreamDados {
    private int count;
    private int size;
    private String cursor;
    private String next_uri;
    private List<Dados> list;

    public StreamDados(){
    };
    
    public StreamDados(int count, int size, String cursor, String next_uri, List<Dados> list) {
        this.count = count;
        this.size = size;
        this.cursor = cursor;
        this.next_uri = next_uri;
        this.list = list;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }

    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public String getCursor() {
        return cursor;
    }

    public void setCursor(String cursor) {
        this.cursor = cursor;
    }

    public String getNext_uri() {
        return next_uri;
    }

    public void setNext_uri(String next_uri) {
        this.next_uri = next_uri;
    }

    public List<Dados> getList() {
        return list;
    }

    public void setList(List<Dados> list) {
        this.list = list;
    }
    
    
    
}
