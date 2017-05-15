package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.SelectEvent;

import beans.Fabricante;
import beans.FormaPagamento;
import persistencia.FabricanteDAO;

@ManagedBean
@SessionScoped
public class FabricanteCtrl implements Serializable{

	private static final long serialVersionUID = 1L;
	private Fabricante fabricante;
	
	public List<Fabricante> getListagem(){
		return FabricanteDAO.listagem("");
	}
	
	public String actionGravar(){
		FacesContext context = FacesContext.getCurrentInstance();
		if(fabricante.getId() == 0){
			FabricanteDAO.inserir(fabricante);
			context.addMessage(null, new FacesMessage("Sucesso", "Inserido com sucesso!"));
			return actionInserir();
		}else{
			FabricanteDAO.alterar(fabricante);
			context.addMessage(null, new FacesMessage("Sucesso", "Alterado com sucesso!"));
		}
		return "fabricante";
	}
	
	public String actionInserir(){
		fabricante = new Fabricante();
		return "fabricante";
	}
	
	public String actionExcluir(){
		FabricanteDAO.excluir(fabricante);
		return "fabricante";
	}
	
	public String voltar(){
		return "fabricante";
	}
	
	public void onRowSelect(SelectEvent event){
		FacesMessage msg = new FacesMessage("Fabricante selecionado",
				String.valueOf(((FormaPagamento) event.getObject()).getId()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void handleClose(CloseEvent event) {   
        FacesContext facesContext = FacesContext.getCurrentInstance();   
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,    
            event.getComponent().getId() + " closed", "So you don't like nature?");   
        facesContext.addMessage(null, message);   
    }

	public Fabricante getFabricante() {
		return fabricante;
	}

	public void setFabricante(Fabricante fabricante) {
		this.fabricante = fabricante;
	}   
}