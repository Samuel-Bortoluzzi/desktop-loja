package Entidades;

import Entidades.Pedido;
import Entidades.UsuarioHasFormaPagamento;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-31T10:04:58")
@StaticMetamodel(FormaPagamento.class)
public class FormaPagamento_ { 

    public static volatile ListAttribute<FormaPagamento, UsuarioHasFormaPagamento> usuarioHasFormaPagamentoList;
    public static volatile SingularAttribute<FormaPagamento, String> nomeFormaPagamento;
    public static volatile SingularAttribute<FormaPagamento, Integer> idPagamento;
    public static volatile ListAttribute<FormaPagamento, Pedido> pedidoList;

}