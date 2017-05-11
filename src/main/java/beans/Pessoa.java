package beans;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.FetchType;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

@Entity
@Table(name = "pessoa")
public class Pessoa {

	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	@Column(name = "id")
	private int id;

	@Column(name = "nome", length = 60, nullable = true)
	private String nome;

	@Column(name = "cpf", length = 14, nullable = true)
	private String cpf;

	@Column(name = "rg", length = 10, nullable = true)
	private String rg;

	@Column(name = "data_nasc")
	private Date data_nasc;

	@Column(name = "rua", length = 60, nullable = true)
	private String rua;

	@Column(name = "bairro", length = 30, nullable = true)
	private String bairro;

	@Column(name = "cep", length = 8, nullable = true)
	private String cep;

	@Column(name = "email", length = 40, nullable = true)
	private String email;

	@Column(name = "senha", length = 32, nullable = true)
	private String senha;

	@Column(name = "tipo", length = 30, nullable = true)
	private String tipo;

	// Relacionamento de 1 para vários
	@OneToMany(fetch = FetchType.EAGER, mappedBy = "pessoa", cascade = CascadeType.ALL)
	private List<Fone> fones = new ArrayList<Fone>();

	// Relacionamento de vários para 1
	@ManyToOne
	@JoinColumn(name = "est_id")
	private Estado est_id = new Estado();

	// Relacionamento de vários para 1
	@ManyToOne
	@JoinColumn(name = "cid_id")
	private Cidade cid_id = new Cidade();
	
	//Gets e Sets

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

	public String getCpf() {
		return cpf;
	}

	public void setCpf(String cpf) {
		this.cpf = cpf;
	}

	public String getRg() {
		return rg;
	}

	public void setRg(String rg) {
		this.rg = rg;
	}

	public Date getData_nasc() {
		return data_nasc;
	}

	public void setData_nasc(Date data_nasc) {
		this.data_nasc = data_nasc;
	}

	public String getRua() {
		return rua;
	}

	public void setRua(String rua) {
		this.rua = rua;
	}

	public String getBairro() {
		return bairro;
	}

	public void setBairro(String bairro) {
		this.bairro = bairro;
	}


	public String getCep() {
		return cep;
	}

	public void setCep(String cep) {
		this.cep = cep;
	}

	public Estado getEst_id() {
		return est_id;
	}

	public void setEst_id(Estado est_id) {
		this.est_id = est_id;
	}

	public Cidade getCid_id() {
		return cid_id;
	}

	public void setCid_id(Cidade cid_id) {
		this.cid_id = cid_id;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getSenha() {
		return senha;
	}

	public void setSenha(String senha) {
		this.senha = senha;
	}

	public String getTipo() {
		return tipo;
	}

	public void setTipo(String tipo) {
		this.tipo = tipo;
	}

	public List<Fone> getFones() {
		return fones;
	}

	public void setFones(List<Fone> fones) {
		this.fones = fones;
	}

	public Estado getEstado() {
		return est_id;
	}

	public void setEstado(Estado estado) {
		this.est_id = estado;
	}

	public Cidade getCidade() {
		return cid_id;
	}

	public void setCidade(Cidade cidade) {
		this.cid_id = cidade;
	}


	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pessoa other = (Pessoa) obj;
		if (id != other.id)
			return false;
		return true;
	}
	
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + id;
		return result;
	}
}
