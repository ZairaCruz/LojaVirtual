package negocio;

import java.util.List;

import javax.annotation.PostConstruct;

import beans.Cidade;
import beans.Pessoa;
import persistencia.CidadeDAO;

public class CidadeCtrl {

	private Pessoa pessoa = new Pessoa();
	
	@PostConstruct
	public List<Cidade> getListaCidades(){
		return CidadeDAO.listagem(pessoa.getEstado().getEst_id());
	}
	
}
