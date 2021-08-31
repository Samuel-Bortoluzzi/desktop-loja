package Entidades;

import Entidades.Pedido;
import Entidades.PedidoHasProdutoPK;
import Entidades.Produto;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-31T10:04:58")
@StaticMetamodel(PedidoHasProduto.class)
public class PedidoHasProduto_ { 

    public static volatile SingularAttribute<PedidoHasProduto, Integer> qtdProduto;
    public static volatile SingularAttribute<PedidoHasProduto, Produto> produto;
    public static volatile SingularAttribute<PedidoHasProduto, PedidoHasProdutoPK> pedidoHasProdutoPK;
    public static volatile SingularAttribute<PedidoHasProduto, Pedido> pedido;
    public static volatile SingularAttribute<PedidoHasProduto, Double> precoUnitarioProduto;

}