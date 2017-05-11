package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;

import beans.Cidade;

public class CidadeDAO implements Serializable {

	private static final long serialVersionUID = 1L;

	public static List<Cidade> listagem(Long long1) {

		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if (long1 == 0) {
			consulta = sessao.createQuery(" from Cidade order by cid_nome ");
		} else {
			consulta = sessao.createQuery(" from Cidade "
					+ "where est_id = :paramentro ");
			consulta.setLong("paramentro",  long1 );
		}
		List lista = consulta.list();
		sessao.close();
		return lista;
	}

}