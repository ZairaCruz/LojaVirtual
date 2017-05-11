package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;

@Entity
@Table(name = " end_cidade")
public class Cidade {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "cid_id")
	private Long cid_id;

	@Column(name = "cid_nome", length = 60, nullable = true)
	private String cid_nome= "";

	// Relacionamento de vários para 1
	@ManyToOne
	@JoinColumn(name = "est_id")
	private Estado estado;
	
	public Long getCid_id() {
		return cid_id;
	}

	public void setCid_id(Long cid_id) {
		this.cid_id = cid_id;
	}

	public String getCid_nome() {
		return cid_nome;
	}

	public void setCid_nome(String cid_nome) {
		this.cid_nome = cid_nome;
	}

	public Estado getEstado() {
		return estado;
	}

	public void setEstado(Estado estado) {
		this.estado = estado;
	}

	@Override
	public boolean equals(Object obj) {
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		final Cidade other = (Cidade) obj;
		if (this.cid_id != other.cid_id && (this.cid_id == null || !this.cid_id.equals(other.cid_id)))
			return false;
		return true;
	}
	
	 @Override
	    public int hashCode() {
	        int hash = 7;
	        hash = 97 * hash + (this.cid_id != null ? this.cid_id.hashCode() : 0);
	        return hash;
	    }	
	
	
}
