package negocio;

import java.io.Serializable;
import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;

import beans.Cidade;
import beans.Estado;
import persistencia.EstadoCidadeDAO;

@SuppressWarnings("unchecked")
@ManagedBean
@SessionScoped
public class EstadoCidadeCtrl implements Serializable {

	private static final long serialVersionUID = 1L;
	private final EstadoCidadeDAO dao = new EstadoCidadeDAO();
	private List<Estado> estados;
	private List<Cidade> cidades;
	private Cidade cidade = new Cidade();
	private Estado estado = new Estado();

	@PostConstruct
	public void init() {
		estados = dao.consultaTodosEstados();
	}
	
	public void listaCidades() {
		cidades = dao.consultaCidades(estado);
	}

	public List<Estado> getEstados() {
		return estados;
	}

	public void setEstados(List<Estado> estados) {
		this.estados = estados;
	}

	public List<Cidade> getCidades() {
		return cidades;
	}

	public void setCidades(List<Cidade> cidades) {
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
