package persistencia;
import java.io.Serializable;

import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Fone;

public class FoneDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static void excluir(Fone f){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(f);
		t.commit();
		sessao.close();
	}	
	public static void alterar(Fone	f){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(f);
		t.commit();
		sessao.close();
	}
}
