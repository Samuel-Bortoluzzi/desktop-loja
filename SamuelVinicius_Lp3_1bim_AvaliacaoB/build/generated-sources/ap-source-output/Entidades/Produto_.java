package Entidades;

import Entidades.PedidoHasProduto;
import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.ListAttribute;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-31T10:04:58")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Double> preco;
    public static volatile SingularAttribute<Produto, Integer> idProduto;
    public static volatile SingularAttribute<Produto, Integer> qtdEstoque;
    public static volatile SingularAttribute<Produto, String> categoria;
    public static volatile SingularAttribute<Produto, String> imagem;
    public static volatile ListAttribute<Produto, PedidoHasProduto> pedidoHasProdutoList;
    public static volatile SingularAttribute<Produto, String> nomeProduto;
    public static volatile SingularAttribute<Produto, Date> dataCadastro;

}