package edu.furb.sistemanfe.domain;

import java.io.Serializable;

import javax.persistence.Column;
import javax.persistence.Embedded;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.persistence.TableGenerator;

@Entity
@Table(name = "TBCLIENTES")
@TableGenerator(name = "GenCliente", table = "TBSEQUENCIAS", pkColumnName = "CDSEQUENCIA", pkColumnValue = "CLIENTESSEQ", valueColumnName = "VLSEQUENCIA")
public class Cliente implements Serializable {

	/**
	 * 
	 */
	private static final long serialVersionUID = 8667477979944114262L;

	@Id
	@Column(name = "IDCLIENTES")
	@GeneratedValue(generator = "GenCliente", strategy = GenerationType.TABLE)
	private Long id;
	@Column(name = "NRDOCUMENTO", length = 20)
	private String documento;
	@Column(name = "NMEMITENTE", length = 100)
	private String nome;
	@Column(name = "NRINSCESTADUAL", length = 20)
	private String inscricaoEstadual;
	@Column(name = "NRFONE", length = 14)
	private String fone;
	//@Embedded
	//private Endereco endereco2;
	@ManyToOne
	@JoinColumn(name = "IDEMITENTE")
	private Emitente emitente;
	@Column(name = "DSEMAIL", length = 60)
	private String email;
	@Embedded
	private Endereco endereco;
	
	public Cliente(){
		
	}

	public Cliente(String documento, String nome, String inscricaoEstadual,
			String fone, Emitente emitente, String email,
			Endereco endereco) {
		super();
		this.documento = documento;
		this.nome = nome;
		this.inscricaoEstadual = inscricaoEstadual;
		this.fone = fone;
		//this.endereco2 = endereco2;
		this.emitente = emitente;
		this.email = email;
		this.endereco = endereco;
	}
	
	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public String getDocumento() {
		return documento;
	}

	public void setDocumento(String documento) {
		this.documento = documento;
	}

	public String getNome() {
		return nome;
	}

	public void setNome(String nome) {
		this.nome = nome;
	}

	public String getInscricaoEstadual() {
		return inscricaoEstadual;
	}

	public void setInscricaoEstadual(String inscricaoEstadual) {
		this.inscricaoEstadual = inscricaoEstadual;
	}
	public String getFone() {
		return fone;
	}

	public void setFone(String fone) {
		this.fone = fone;
	}

	public String getEmail() {
		return email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public Endereco getEndereco() {
		return endereco;
	}

	public void setEndereco(Endereco endereco) {
		this.endereco = endereco;
	}

//	public Endereco getEndereco2() {
//		return endereco2;
//	}
//
//	public void setEndereco2(Endereco endereco2) {
//		this.endereco2 = endereco2;
//	}

	public Emitente getEmitente() {
		return emitente;
	}

	public void setEmitente(Emitente emitente) {
		this.emitente = emitente;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result
				+ ((documento == null) ? 0 : documento.hashCode());
		result = prime * result + ((email == null) ? 0 : email.hashCode());
		result = prime * result
				+ ((emitente == null) ? 0 : emitente.hashCode());
		result = prime * result
				+ ((endereco == null) ? 0 : endereco.hashCode());
//		result = prime * result
//				+ ((endereco2 == null) ? 0 : endereco2.hashCode());
		result = prime * result + ((fone == null) ? 0 : fone.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		result = prime
				* result
				+ ((inscricaoEstadual == null) ? 0 : inscricaoEstadual
						.hashCode());
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Cliente other = (Cliente) obj;
		if (documento == null) {
			if (other.documento != null)
				return false;
		} else if (!documento.equals(other.documento))
			return false;
		if (email == null) {
			if (other.email != null)
				return false;
		} else if (!email.equals(other.email))
			return false;
		if (emitente == null) {
			if (other.emitente != null)
				return false;
		} else if (!emitente.equals(other.emitente))
			return false;
		if (endereco == null) {
			if (other.endereco != null)
				return false;
		} else if (!endereco.equals(other.endereco))
			return false;
//		if (endereco2 == null) {
//			if (other.endereco2 != null)
//				return false;
//		} else if (!endereco2.equals(other.endereco2))
//			return false;
		if (fone == null) {
			if (other.fone != null)
				return false;
		} else if (!fone.equals(other.fone))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		if (inscricaoEstadual == null) {
			if (other.inscricaoEstadual != null)
				return false;
		} else if (!inscricaoEstadual.equals(other.inscricaoEstadual))
			return false;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		return true;
	}

	

	

}
