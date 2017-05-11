package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import beans.Estado;

public class EstadoDAO implements Serializable{

	private static final long serialVersionUID = 1L;

	public static List<Estado> listagem(String filtro){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if(filtro.trim().length() == 0){
			consulta = sessao.createQuery(" from Estado order by est_nome ");
		}
		else{
			consulta = sessao.createQuery(" from Estado "
					+ "where est_nome like :paramentro order by est_nome");
			consulta.setString("parametro", "%" + filtro + "%");
		}
		List lista = consulta.list();
		sessao.close();
		return lista;
	}

}
