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
@Table(name = " fone")
public class Fone {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "fon_id")
	private int fon_id;

	@Column(name = "numero", length = 20, nullable = true)
	private String numero;

	@Column(name = "descricao", length = 30, nullable = true)
	private String descricao;

	// Relacionamento de vários para 1
	@ManyToOne
	@JoinColumn(name = "id")
	private Pessoa pessoa;

	public int getFon_id() {
		return fon_id;
	}

	public void setFon_id(int fon_id) {
		this.fon_id = fon_id;
	}

	public String getNumero() {
		return numero;
	}

	public void setNumero(String numero) {
		this.numero = numero;
	}

	public String getDescricao() {
		return descricao;
	}

	public void setDescricao(String descricao) {
		this.descricao = descricao;
	}

	public Pessoa getPessoa() {
		return pessoa;
	}

	public void setPessoa(Pessoa pessoa) {
		this.pessoa = pessoa;
	}

}

