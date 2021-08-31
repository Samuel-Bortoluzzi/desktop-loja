/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import java.util.List;
import javax.persistence.Basic;
import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToMany;
import javax.persistence.Table;

/**
 *
 * @author Samuel
 */
@Entity
@Table(name = "forma_pagamento")
@NamedQueries({
    @NamedQuery(name = "FormaPagamento.findAll", query = "SELECT f FROM FormaPagamento f")})
public class FormaPagamento implements Serializable {

    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaPagamento")
    private List<UsuarioHasFormaPagamento> usuarioHasFormaPagamentoList;
    @OneToMany(cascade = CascadeType.ALL, mappedBy = "formaPagamentoIdPagamento")
    private List<Pedido> pedidoList;

    private static final long serialVersionUID = 1L;
    @Id
    @Basic(optional = false)
    @Column(name = "id_pagamento")
    private Integer idPagamento;
    @Basic(optional = false)
    @Column(name = "nome_forma_pagamento")
    private String nomeFormaPagamento;

    public FormaPagamento() {
    }

    public FormaPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public FormaPagamento(Integer idPagamento, String nomeFormaPagamento) {
        this.idPagamento = idPagamento;
        this.nomeFormaPagamento = nomeFormaPagamento;
    }

    public Integer getIdPagamento() {
        return idPagamento;
    }

    public void setIdPagamento(Integer idPagamento) {
        this.idPagamento = idPagamento;
    }

    public String getNomeFormaPagamento() {
        return nomeFormaPagamento;
    }

    public void setNomeFormaPagamento(String nomeFormaPagamento) {
        this.nomeFormaPagamento = nomeFormaPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (idPagamento != null ? idPagamento.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof FormaPagamento)) {
            return false;
        }
        FormaPagamento other = (FormaPagamento) object;
        if ((this.idPagamento == null && other.idPagamento != null) || (this.idPagamento != null && !this.idPagamento.equals(other.idPagamento))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return idPagamento + ";" + nomeFormaPagamento;
    }

    public List<UsuarioHasFormaPagamento> getUsuarioHasFormaPagamentoList() {
        return usuarioHasFormaPagamentoList;
    }

    public void setUsuarioHasFormaPagamentoList(List<UsuarioHasFormaPagamento> usuarioHasFormaPagamentoList) {
        this.usuarioHasFormaPagamentoList = usuarioHasFormaPagamentoList;
    }

    public List<Pedido> getPedidoList() {
        return pedidoList;
    }

    public void setPedidoList(List<Pedido> pedidoList) {
        this.pedidoList = pedidoList;
    }
    
}
