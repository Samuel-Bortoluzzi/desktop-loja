/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Embeddable;

/**
 *
 * @author Samuel
 */
@Embeddable
public class UsuarioHasFormaPagamentoPK implements Serializable {

    @Basic(optional = false)
    @Column(name = "usuario_id_usuario")
    private int usuarioIdUsuario;
    @Basic(optional = false)
    @Column(name = "forma_pagamento_id_pagamento")
    private int formaPagamentoIdPagamento;

    public UsuarioHasFormaPagamentoPK() {
    }

    public UsuarioHasFormaPagamentoPK(int usuarioIdUsuario, int formaPagamentoIdPagamento) {
        this.usuarioIdUsuario = usuarioIdUsuario;
        this.formaPagamentoIdPagamento = formaPagamentoIdPagamento;
    }

    public int getUsuarioIdUsuario() {
        return usuarioIdUsuario;
    }

    public void setUsuarioIdUsuario(int usuarioIdUsuario) {
        this.usuarioIdUsuario = usuarioIdUsuario;
    }

    public int getFormaPagamentoIdPagamento() {
        return formaPagamentoIdPagamento;
    }

    public void setFormaPagamentoIdPagamento(int formaPagamentoIdPagamento) {
        this.formaPagamentoIdPagamento = formaPagamentoIdPagamento;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (int) usuarioIdUsuario;
        hash += (int) formaPagamentoIdPagamento;
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasFormaPagamentoPK)) {
            return false;
        }
        UsuarioHasFormaPagamentoPK other = (UsuarioHasFormaPagamentoPK) object;
        if (this.usuarioIdUsuario != other.usuarioIdUsuario) {
            return false;
        }
        if (this.formaPagamentoIdPagamento != other.formaPagamentoIdPagamento) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.UsuarioHasFormaPagamentoPK[ usuarioIdUsuario=" + usuarioIdUsuario + ", formaPagamentoIdPagamento=" + formaPagamentoIdPagamento + " ]";
    }
    
}
