package com.myapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class ReceitaRemedio
{
    @Id
    @GeneratedValue
    private int id;
    private int quantidade;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public int getQuantidade()
    {
        return quantidade;
    }

    public void setQuantidade(int quantidade)
    {
        this.quantidade = quantidade;
    }
    
}
