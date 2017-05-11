package negocio;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.event.AjaxBehaviorEvent;

import beans.Cidade;
import beans.Estado;
import persistencia.EstadoCidadeDAO;

@ManagedBean
@SessionScoped
public class EstadoCidadeCtrl implements Serializable {

	private static final long serialVersionUID = 1L;
	private final EstadoCidadeDAO dao = new EstadoCidadeDAO();
	private List estados;
	private List cidades;
	private Cidade cidade = new Cidade();
	private Estado estado = new Estado();

	@PostConstruct
	public void init() {
		estados = dao.consultaTodosEstados();
	}

	@PostConstruct
	public void listaCidades(AjaxBehaviorEvent event) {
		cidades = dao.consultaCidades(estado);
	}

	public List getEstados() {
		return estados;
	}

	public void setEstados(List estados) {
		this.estados = estados;
	}

	public List getCidades() {
		return cidades;
	}

	public void setCidades(List cidades) {
		this.cidades = cidades;
	}

	public Cidade getCidade() {
		return cidade;
	}

	public void setCidade(Cidade cidade) {
		this.cidade = cidade;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	public EstadoCidadeDAO getDao() {
		return dao;
	}

}
