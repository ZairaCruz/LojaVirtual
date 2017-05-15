package persistencia;
import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.FormaPagamento;
import beans.Pessoa;

public class PessoaDAO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	public static void inserir(Pessoa pessoa){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(pessoa);
		t.commit();
		sessao.close();
	}
	
	public static void alterar(Pessoa pessoa){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(pessoa);
		t.commit();
		sessao.close();
	}
	
	public static void excluir(Pessoa pessoa){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(pessoa);
		t.commit();
		sessao.close();
	}
	
	public static List<Pessoa> listagem(String filtro){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if(filtro.trim().length() == 0){
			consulta = sessao.createQuery(" from Pessoa order by nome ");
		}
		else{
			consulta = sessao.createQuery(" from Pessoa "
					+ "where nome like :paramentro order by nome");
			consulta.setString("parametro", "%" + filtro + "%");
		}
		List lista = consulta.list();
		sessao.close();
		return lista;
	}
	
	public static FormaPagamento pesquisaId(int valor){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from Pessoa where id = :parametro");
		consulta.setInteger("parametro", valor);
		sessao.close();
		return (FormaPagamento)consulta.uniqueResult();
	}

}
