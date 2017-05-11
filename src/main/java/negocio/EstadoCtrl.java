package negocio;

import java.util.List;

import javax.annotation.PostConstruct;
import javax.faces.bean.ApplicationScoped;
import javax.faces.bean.ManagedBean;

import beans.Estado;
import persistencia.EstadoDAO;

@ManagedBean(name="estadoCtrl", eager = true)
@ApplicationScoped
public class EstadoCtrl {
	
	@PostConstruct
	public List<Estado> getListaEstados(){
		return EstadoDAO.listagem("");
	}   
   
}
