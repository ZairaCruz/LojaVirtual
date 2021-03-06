package beans;

import javax.persistence.*;

@Entity
@Table(name = " produto")
public class Produto {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;
	
	@Column(name = "nome", length = 60, nullable = true)
	private String nome;
	
	@Column(name = "preco", nullable = true)
	private float preco;
	
//	@Column(name = )
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public float getPreco() {
		return preco;
	}

	public void setPreco(float preco) {
		this.preco = preco;
	}
}

