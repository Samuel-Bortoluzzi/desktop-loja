package Entidades;

import java.util.Date;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value="EclipseLink-2.5.2.v20140319-rNA", date="2021-08-30T18:49:17")
@StaticMetamodel(Produto.class)
public class Produto_ { 

    public static volatile SingularAttribute<Produto, Double> preco;
    public static volatile SingularAttribute<Produto, Integer> idProduto;
    public static volatile SingularAttribute<Produto, Integer> qtdEstoque;
    public static volatile SingularAttribute<Produto, String> categoria;
    public static volatile SingularAttribute<Produto, String> imagem;
    public static volatile SingularAttribute<Produto, String> nomeProduto;
    public static volatile SingularAttribute<Produto, Date> dataCadastro;

}