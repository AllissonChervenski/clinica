
package com.myapp.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
@Entity
public class Medico extends Empregado
{
    @Id
    @GeneratedValue
    private int id;
    private String crm;
    
  
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }

    public String getCrm()
    {
        return crm;
    }

    public void setCrm(String crm)
    {
        this.crm = crm;
    }
    
}
