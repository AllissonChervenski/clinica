package com.myapp.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Paciente extends Pessoa
{
    @Id
    @GeneratedValue
    private int id;
<<<<<<< Updated upstream
    private Date nascimento;
=======
>>>>>>> Stashed changes
    private String email;
    private String telefone;

    public Date getNascimento() {
        return nascimento;
    }

    public void setNascimento(Date nascimento) {
        this.nascimento = nascimento;
    }

<<<<<<< Updated upstream
    public int getId()
    {
        return id;
    }

    public void setId(int id)
    {
        this.id = id;
    }
=======
>>>>>>> Stashed changes

    public String getEmail()
    {
        return email;
    }

    public void setEmail(String email)
    {
        this.email = email;
    }

    public String getTelefone()
    {
        return telefone;
    }

    public void setTelefone(String telefone)
    {
        this.telefone = telefone;
    }

}
