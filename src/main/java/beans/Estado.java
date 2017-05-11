package beans;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

@Entity
@Table(name = "end_estado")
public class Estado {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "est_id")
	private Long est_id;

	@Column(name = "est_nome", length = 60, nullable = true)
	private String est_nome = "";

	@Column(name = "est_sigla", length = 2, nullable = true)
	private String est_sigla;

	public Long getEst_id() {
		return est_id;
	}

	public void setEst_id(Long est_id) {
		this.est_id = est_id;
	}

	public String getEst_nome() {
		return est_nome;
	}

	public void setEst_nome(String est_nome) {
		this.est_nome = est_nome;
	}

	public String getEst_sigla() {
		return est_sigla;
	}

	public void setEst_sigla(String est_sigla) {
		this.est_sigla = est_sigla;
	}

	 @Override
	    public boolean equals(Object obj) {
	        if (obj == null) {
	            return false;
	        }
	        if (getClass() != obj.getClass()) {
	            return false;
	        }
	        final Estado other = (Estado) obj;
	        if (this.est_id != other.est_id && (this.est_id == null || !this.est_id.equals(other.est_id))) {
	            return false;
	        }
	        return true;
	    }

	    @Override
	    public int hashCode() {
	        int hash = 5;
	        hash = 41 * hash + (this.est_id != null ? this.est_id.hashCode() : 0);
	        return hash;
	    }
}
