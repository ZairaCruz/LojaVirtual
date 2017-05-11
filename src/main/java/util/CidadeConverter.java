package util;
import javax.faces.application.FacesMessage;
import javax.faces.component.UIComponent;
import javax.faces.context.FacesContext;
import javax.faces.convert.Converter;
import javax.faces.convert.ConverterException;
import javax.faces.convert.FacesConverter;

import beans.Cidade;
import negocio.CidadeCtrl;
import persistencia.EstadoCidadeDAO;

@FacesConverter("cidadeConverter")
public class CidadeConverter implements Converter {
	
	@Override
	public Object getAsObject(FacesContext context, UIComponent component, String value) {
		if (value != null && !value.equals("")) {
			EstadoCidadeDAO dao = new EstadoCidadeDAO();
			return dao.getByIdCidade(Long.valueOf(value));
		}
		return null;
	}
	 
	@Override
	public String getAsString(FacesContext context, UIComponent component, Object value) {
		if (value instanceof Cidade) {
			Cidade cidade = (Cidade) value;
			return String.valueOf(cidade.getCid_id());
		}
		return "";
	}
}         