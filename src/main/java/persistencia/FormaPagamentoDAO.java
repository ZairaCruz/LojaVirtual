package persistencia;

import java.io.Serializable;
import java.util.List;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.Transaction;

import beans.FormaPagamento;

public class FormaPagamentoDAO implements Serializable{

private static final long serialVersionUID = 1L;
	
	public static void inserir(FormaPagamento formaPagamento){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.save(formaPagamento);
		t.commit();
		sessao.close();
	}
	
	public static void alterar(FormaPagamento formaPagamento){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.update(formaPagamento);
		t.commit();
		sessao.close();
	}
	
	public static void excluir(FormaPagamento formaPagamento){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Transaction t = sessao.beginTransaction();
		sessao.delete(formaPagamento);
		t.commit();
		sessao.close();
	}
	
	public static List<FormaPagamento> listagem(String filtro){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta;
		if(filtro.trim().length() == 0){
			consulta = sessao.createQuery(" from FormaPagamento order by descricao ");
		}
		else{
			consulta = sessao.createQuery(" from FormaPagamento "
					+ "where descricao like :paramentro order by descricao");
			consulta.setString("parametro", "%" + filtro + "%");
		}
		List lista = consulta.list();
		sessao.close();
		return lista;
	}
	
	public static FormaPagamento pesquisaId(int valor){
		Session sessao = HibernateUtil.getSessionFactory().openSession();
		Query consulta = sessao.createQuery("from FormaPagamento where id = :parametro");
		consulta.setInteger("parametro", valor);
		sessao.close();
		return (FormaPagamento)consulta.uniqueResult();
	}
	
}
