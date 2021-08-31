/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Entidades;

import java.io.Serializable;
import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.EmbeddedId;
import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.JoinColumns;
import javax.persistence.ManyToOne;
import javax.persistence.NamedQueries;
import javax.persistence.NamedQuery;
import javax.persistence.OneToOne;
import javax.persistence.Table;

/**
 *
 * @author Samuel
 */
@Entity
@Table(name = "usuario_has_forma_pagamento")
@NamedQueries({
    @NamedQuery(name = "UsuarioHasFormaPagamento.findAll", query = "SELECT u FROM UsuarioHasFormaPagamento u")})
public class UsuarioHasFormaPagamento implements Serializable {

    private static final long serialVersionUID = 1L;
    @EmbeddedId
    protected UsuarioHasFormaPagamentoPK usuarioHasFormaPagamentoPK;
    @Basic(optional = false)
    @Column(name = "identificador_forma_pagamento")
    private String identificadorFormaPagamento;
    @JoinColumn(name = "forma_pagamento_id_pagamento", referencedColumnName = "id_pagamento", insertable = false, updatable = false)
    @ManyToOne(optional = false)
    private FormaPagamento formaPagamento;
    @JoinColumns({
        @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)
        , @JoinColumn(name = "usuario_id_usuario", referencedColumnName = "id_usuario", insertable = false, updatable = false)})
    @OneToOne(optional = false)
    private Usuario usuario;

    public UsuarioHasFormaPagamento() {
    }

    public UsuarioHasFormaPagamento(UsuarioHasFormaPagamentoPK usuarioHasFormaPagamentoPK) {
        this.usuarioHasFormaPagamentoPK = usuarioHasFormaPagamentoPK;
    }

    public UsuarioHasFormaPagamento(UsuarioHasFormaPagamentoPK usuarioHasFormaPagamentoPK, String identificadorFormaPagamento) {
        this.usuarioHasFormaPagamentoPK = usuarioHasFormaPagamentoPK;
        this.identificadorFormaPagamento = identificadorFormaPagamento;
    }

    public UsuarioHasFormaPagamento(int usuarioIdUsuario, int formaPagamentoIdPagamento) {
        this.usuarioHasFormaPagamentoPK = new UsuarioHasFormaPagamentoPK(usuarioIdUsuario, formaPagamentoIdPagamento);
    }

    public UsuarioHasFormaPagamentoPK getUsuarioHasFormaPagamentoPK() {
        return usuarioHasFormaPagamentoPK;
    }

    public void setUsuarioHasFormaPagamentoPK(UsuarioHasFormaPagamentoPK usuarioHasFormaPagamentoPK) {
        this.usuarioHasFormaPagamentoPK = usuarioHasFormaPagamentoPK;
    }

    public String getIdentificadorFormaPagamento() {
        return identificadorFormaPagamento;
    }

    public void setIdentificadorFormaPagamento(String identificadorFormaPagamento) {
        this.identificadorFormaPagamento = identificadorFormaPagamento;
    }

    public FormaPagamento getFormaPagamento() {
        return formaPagamento;
    }

    public void setFormaPagamento(FormaPagamento formaPagamento) {
        this.formaPagamento = formaPagamento;
    }

    public Usuario getUsuario() {
        return usuario;
    }

    public void setUsuario(Usuario usuario) {
        this.usuario = usuario;
    }

    @Override
    public int hashCode() {
        int hash = 0;
        hash += (usuarioHasFormaPagamentoPK != null ? usuarioHasFormaPagamentoPK.hashCode() : 0);
        return hash;
    }

    @Override
    public boolean equals(Object object) {
        // TODO: Warning - this method won't work in the case the id fields are not set
        if (!(object instanceof UsuarioHasFormaPagamento)) {
            return false;
        }
        UsuarioHasFormaPagamento other = (UsuarioHasFormaPagamento) object;
        if ((this.usuarioHasFormaPagamentoPK == null && other.usuarioHasFormaPagamentoPK != null) || (this.usuarioHasFormaPagamentoPK != null && !this.usuarioHasFormaPagamentoPK.equals(other.usuarioHasFormaPagamentoPK))) {
            return false;
        }
        return true;
    }

    @Override
    public String toString() {
        return "Entidades.UsuarioHasFormaPagamento[ usuarioHasFormaPagamentoPK=" + usuarioHasFormaPagamentoPK + " ]";
    }
    
}
