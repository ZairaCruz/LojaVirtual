package persistencia;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;

import beans.Cidade;
import beans.Estado;

public class EstadoCidadeDAO {
	
	private Estado estado = new Estado();

	public Cidade getByIdCidade(Long cid_id) {
		return (Cidade) HibernateUtil.getSession().get(Cidade.class, cid_id);
	}

	public Estado getByIdEstado(Long est_id) {
		return (Estado) HibernateUtil.getSession().get(Estado.class, est_id);
	}

	public List consultaTodosEstados() {
		Criteria crit = HibernateUtil.getSession().createCriteria(Estado.class);
		return crit.list();
	}

	public List consultaCidades(Estado estado) {
		Criteria crit = HibernateUtil.getSession().createCriteria(Cidade.class);
		crit.add(Restrictions.eq("estado", estado));
		return crit.list();
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}
}
