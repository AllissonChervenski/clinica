package com.myapp.model;

import java.util.Date;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;

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

    public Medico getMedico() {
        return medico;
    }

    public void setMedico(Medico medico) {
        this.medico = medico;
    }
    @ManyToOne
    @JoinColumn(name = "id_medico")
    private Medico medico;
    @ManyToOne
    @JoinColumn(name = "id_paciente")
    private Paciente paciente;

    public Paciente getPaciente() {
        return paciente;
    }

    public void setPaciente(Paciente paciente) {
        this.paciente = paciente;
    }
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
