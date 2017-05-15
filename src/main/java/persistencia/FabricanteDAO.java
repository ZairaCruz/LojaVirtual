package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.Fabricante;
import beans.FormaPagamento;

public class FabricanteDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static void inserir(Fabricante fabricante){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(fabricante);
		t.commit();
		sessao.close();
	}
	
	public static void alterar(Fabricante fabricante){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(fabricante);
		t.commit();
		sessao.close();
	}
	
	public static void excluir(Fabricante fabricante){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(fabricante);
		t.commit();
		sessao.close();
	}
	
	public static List<Fabricante> listagem(String filtro){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if(filtro.trim().length() == 0){
			consulta = sessao.createQuery("from Fabricante order by nome ");
		}
		else{
			consulta = sessao.createQuery("from Fabricante "
					+ "where nome like :parametro order by nome");
			consulta.setString("parametro", "%" + filtro + "%");
		}
		List lista = consulta.list();
		sessao.close();
		return lista;
	}
	
	public static FormaPagamento pesquisaId(int valor){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from Fabricante where id = :parametro");
		consulta.setInteger("parametro", valor);
		sessao.close();
		return (FormaPagamento)consulta.uniqueResult();
	}

}
