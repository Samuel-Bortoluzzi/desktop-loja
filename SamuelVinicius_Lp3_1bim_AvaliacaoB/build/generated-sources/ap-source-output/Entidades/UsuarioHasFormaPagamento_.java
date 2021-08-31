package Entidades;

import Entidades.FormaPagamento;
import Entidades.Usuario;
import Entidades.UsuarioHasFormaPagamentoPK;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-31T10:04:58")
@StaticMetamodel(UsuarioHasFormaPagamento.class)
public class UsuarioHasFormaPagamento_ { 

    public static volatile SingularAttribute<UsuarioHasFormaPagamento, FormaPagamento> formaPagamento;
    public static volatile SingularAttribute<UsuarioHasFormaPagamento, String> identificadorFormaPagamento;
    public static volatile SingularAttribute<UsuarioHasFormaPagamento, Usuario> usuario;
    public static volatile SingularAttribute<UsuarioHasFormaPagamento, UsuarioHasFormaPagamentoPK> usuarioHasFormaPagamentoPK;

}