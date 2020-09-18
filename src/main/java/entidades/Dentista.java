package entidades;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToMany;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_dentista", sequenceName = "seq_dentista", initialValue = 1)
public class Dentista extends Profissional {
	
	@Id
	@Column(name="cpf_dentista_id")
	private Long id;
	
	@OneToMany
	@JoinColumn(name = "agendamento_id", foreignKey = @ForeignKey(name = "fk_dentista_agendamento"))
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_dentista")
	private List<Agendamento> agendamento;

	public Long getId() {
		return id;
	}

	public void setId(Long id) {
		this.id = id;
	}

	public List<Agendamento> getAgendamento() {
		return agendamento;
	}

	public void setAgendamento(List<Agendamento> agendamento) {
		this.agendamento = agendamento;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + ((agendamento == null) ? 0 : agendamento.hashCode());
		result = prime * result + ((id == null) ? 0 : id.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (!super.equals(obj))
			return false;
		if (getClass() != obj.getClass())
			return false;
		Dentista other = (Dentista) obj;
		if (agendamento == null) {
			if (other.agendamento != null)
				return false;
		} else if (!agendamento.equals(other.agendamento))
			return false;
		if (id == null) {
			if (other.id != null)
				return false;
		} else if (!id.equals(other.id))
			return false;
		return true;
	}

}
