package com.myapp.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Prontuario
{
    @Id
    @GeneratedValue
    private int id;
    private String objetivo;
    private String subjetivo;
    private String avaliacao;
    private Date dta;

    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getObjetivo()
    {
        return objetivo;
    }

    public void setObjetivo(String objetivo)
    {
        this.objetivo = objetivo;
    }

    public String getSubjetivo()
    {
        return subjetivo;
    }

    public void setSubjetivo(String subjetivo)
    {
        this.subjetivo = subjetivo;
    }

    public String getAvaliacao()
    {
        return avaliacao;
    }

    public void setAvaliacao(String avaliacao)
    {
        this.avaliacao = avaliacao;
    }

    public Date getDta()
    {
        return dta;
    }

    public void setDta(Date dta)
    {
        this.dta = dta;
    }
    
    
}
