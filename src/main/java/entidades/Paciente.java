package entidades;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_paciente", sequenceName = "seq_paciente", initialValue = 1)
public class Paciente {
	
	@Id
	@Column(name="cpf_paciente_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_paciente")
	private long id;
	@Basic(optional = false)
	private String nome;
	
	public long getPaciente_id_cpf() {
		return id;
	}
	public void setPaciente_id_cpf(long paciente_id_cpf) {
		this.id = paciente_id_cpf;
	}
	public String getNome() {
		return nome;
	}
	public void setNome(String nome) {
		this.nome = nome;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((nome == null) ? 0 : nome.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
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
		Paciente other = (Paciente) obj;
		if (nome == null) {
			if (other.nome != null)
				return false;
		} else if (!nome.equals(other.nome))
			return false;
		if (id != other.id)
			return false;
		return true;
	}
	
	

}
