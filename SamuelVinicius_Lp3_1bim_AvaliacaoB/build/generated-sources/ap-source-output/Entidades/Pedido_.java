package Entidades;

import Entidades.FormaPagamento;
import Entidades.PedidoHasProduto;
import Entidades.Usuario;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-31T10:04:58")
@StaticMetamodel(Pedido.class)
public class Pedido_ { 

    public static volatile SingularAttribute<Pedido, FormaPagamento> formaPagamentoIdPagamento;
    public static volatile SingularAttribute<Pedido, Date> dataPedido;
    public static volatile SingularAttribute<Pedido, Usuario> usuario;
    public static volatile ListAttribute<Pedido, PedidoHasProduto> pedidoHasProdutoList;
    public static volatile SingularAttribute<Pedido, Integer> idPedido;

}