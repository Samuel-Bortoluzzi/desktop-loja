/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.Table;

/**
 *
 * @author Samuel
 */
@Entity
@Table(name = "endereco")
@NamedQueries({
    @NamedQuery(name = "Endereco.findAll", query = "SELECT e FROM Endereco e")})
public class Endereco implements Serializable {

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_endere\u00e7o")
    private Integer idEndereço;
    @Basic(optional = false)
    @Column(name = "numero")
    private String numero;
    @Basic(optional = false)
    @Column(name = "rua")
    private String rua;
    @Basic(optional = false)
    @Column(name = "Cidade")
    private String cidade;
    @Column(name = "Complemento")
    private String complemento;
    @Basic(optional = false)
    @Column(name = "cep")
    private String cep;

    public Endereco() {
    }

    public Endereco(Integer idEndereço) {
        this.idEndereço = idEndereço;
    }

    public Endereco(Integer idEndereço, String numero, String rua, String cidade, String cep) {
        this.idEndereço = idEndereço;
        this.numero = numero;
        this.rua = rua;
        this.cidade = cidade;
        this.cep = cep;
    }

    public Integer getIdEndereço() {
        return idEndereço;
    }

    public void setIdEndereço(Integer idEndereço) {
        this.idEndereço = idEndereço;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idEndereço != null ? idEndereço.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof Endereco)) {
            return false;
        }
        Endereco other = (Endereco) object;
        if ((this.idEndereço == null && other.idEndereço != null) || (this.idEndereço != null && !this.idEndereço.equals(other.idEndereço))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.Endereco[ idEndere\u00e7o=" + idEndereço + " ]";
    }
    
}
