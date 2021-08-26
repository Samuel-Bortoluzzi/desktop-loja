package DAOs;

import Entidades.Usuario;
import java.util.ArrayList;
import java.util.List;

public class DAOUsuario extends DAOGenerico<Usuario> {

    private List<Usuario> lista = new ArrayList<>();

    public DAOUsuario() {
        super(Usuario.class);
    }

    public int autoIdUsuario() {
        Integer a = (Integer) em.createQuery("SELECT MAX(e.idUsario) FROM Usuario e ").getSingleResult();
        if (a != null) {
            return a + 1;
        } else {
            return 1;
        }
    }

    public List<Usuario> listByNome(String nome) {
        return em.createQuery("SELECT e FROM Usuario e WHERE e.idUsuario) LIKE :nome").setParameter("nome", "%" + nome + "%").getResultList();
    }

    public List<Usuario> listById(int id) {
        return em.createQuery("SELECT e FROM Usuario + e WHERE e.idUsuario= :id").setParameter("id", id).getResultList();
    }

    public List<Usuario> listInOrderNome() {
        return em.createQuery("SELECT e FROM Usuario e ORDER BY e.nomeCompleto").getResultList();
    }

    public List<Usuario> listInOrderId() {
        return em.createQuery("SELECT e FROM Usuario e ORDER BY e.idUsuario").getResultList();
    }

    public List<String> listInOrderNomeStrings(String qualOrdem) {
        List<Usuario> lf;
        if (qualOrdem.equals("id")) {
            lf = listInOrderId();
        } else {
            lf = listInOrderNome();
        }

        List<String> ls = new ArrayList<>();
        for (int i = 0; i < lf.size(); i++) {
            ls.add(lf.get(i).getIdUsuario()+ "-" + lf.get(i).getIdUsuario());
        }
        return ls;
    }

    public static void main(String[] args) {
        DAOUsuario daoUsuario = new DAOUsuario();
        List<Usuario> listaUsuario = daoUsuario.list();
        for (Usuario usuario : listaUsuario) {
            System.out.println(usuario.getIdUsuario()+ "-" + usuario.getNomeCompleto());
        }
    }
}
