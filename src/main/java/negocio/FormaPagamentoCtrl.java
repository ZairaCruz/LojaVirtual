package negocio;

import java.io.Serializable;
import java.util.List;

import javax.faces.application.FacesMessage;
import javax.faces.bean.ManagedBean;
import javax.faces.bean.SessionScoped;
import javax.faces.context.FacesContext;

import org.primefaces.event.CloseEvent;
import org.primefaces.event.SelectEvent;

import beans.FormaPagamento;
import persistencia.FormaPagamentoDAO;

@ManagedBean
@SessionScoped
public class FormaPagamentoCtrl implements Serializable {

	private static final long serialVersionUID = 1L;
	private FormaPagamento formaPagamento = new FormaPagamento();
	private String filtro = "";
		
	public FormaPagamento getFormaPagamento() {
		return formaPagamento;
	}

	public void setFormaPagamento(FormaPagamento formaPagamento) {
		this.formaPagamento = formaPagamento;
	}

	public String getFiltro() {
		return filtro;
	}

	public void setFiltro(String filtro) {
		this.filtro = filtro;
	}

	public List<FormaPagamento> getListagem(){
		return FormaPagamentoDAO.listagem("");
	}
	
	public String actionGravar(){
		FacesContext context = FacesContext.getCurrentInstance();
		if(formaPagamento.getId() == 0){
			FormaPagamentoDAO.inserir(formaPagamento);
			context.addMessage(null, new FacesMessage("Sucesso", "Inserido com sucesso!"));
			return actionInserir();
		}else{
			FormaPagamentoDAO.alterar(formaPagamento);
			context.addMessage(null, new FacesMessage("Sucesso", "Alterado com sucesso!"));
		}
		return "lista_formapagamento";
	}
	
	public String actionInserir(){
		formaPagamento = new FormaPagamento();
		return "lista_formapagamento";
	}
	
	public String actionExcluir(){
		FormaPagamentoDAO.excluir(formaPagamento);
		return "lista_formapagamento";
	}
	
	public String voltar(){
		return "lista_formapagamento";
	}
	
	public void onRowSelect(SelectEvent event){
		FacesMessage msg = new FacesMessage("Forma de pagamento selecionada",
				String.valueOf(((FormaPagamento) event.getObject()).getId()));
		FacesContext.getCurrentInstance().addMessage(null, msg);
	}
	
	public void handleClose(CloseEvent event) {   
        FacesContext facesContext = FacesContext.getCurrentInstance();   
        FacesMessage message = new FacesMessage(FacesMessage.SEVERITY_INFO,    
            event.getComponent().getId() + " closed", "So you don't like nature?");   
        facesContext.addMessage(null, message);   
    }   
}

