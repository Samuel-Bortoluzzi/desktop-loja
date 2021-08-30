package DAOs;

import Entidades.FormaPagamento;
import java.util.ArrayList;
import java.util.List;

public class DAOFormaPagamento extends DAOGenerico<FormaPagamento> {

    private List<FormaPagamento> lista = new ArrayList<>();

    public DAOFormaPagamento() {
        super(FormaPagamento.class);
    }

    public int autoIdFormaPagamento() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idFormaPagamento) FROM FormaPagamento e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<FormaPagamento> listByNome(String nome) {
        return em.createQuery("SELECT e FROM FormaPagamento e WHERE e.idFormaPagamento) LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<FormaPagamento> listById(int id) {
        return em.createQuery("SELECT e FROM FormaPagamento + e WHERE e.idFormaPagamento= :id").setParameter("id", id).getResultList();
    }

    public List<FormaPagamento> listInOrderNome() {
        return em.createQuery("SELECT e FROM FormaPagamento e ORDER BY e.nomeFormaPagamento").getResultList();
    }

    public List<FormaPagamento> listInOrderId() {
        return em.createQuery("SELECT e FROM FormaPagamento e ORDER BY e.idFormaPagamento").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<FormaPagamento> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdPagamento()+ "-" + lf.get(i).getNomeFormaPagamento());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOFormaPagamento daoFormaPagamento = new DAOFormaPagamento();
        List<FormaPagamento> listaFormaPagamento = daoFormaPagamento.list();
        for (FormaPagamento formaPagamento : listaFormaPagamento) {
            System.out.println(formaPagamento.getIdPagamento()+ "-" + formaPagamento.getNomeFormaPagamento());
        }
    }
}
