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
@SequenceGenerator(name = "seq_atendente", sequenceName = "seq_atendente", initialValue = 1)
public class Atendente extends Profissional {
	
	@Id
	@Column(name="cpf_atendente_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_atendente")
	private Long id;
	
	@OneToMany
	@JoinColumn(name="cpf_profissional_id", foreignKey = @ForeignKey(name = "fk_atendente_atendente"))
	private List<Atendente> supervisorAtendentes;

	public Long getId() {
		return id;
	}

	public void setId(long id) {
		this.id = id;
	}

	public List<Atendente> getSupervisorAtendentes() {
		return supervisorAtendentes;
	}

	public void setSupervisorAtendentes(List<Atendente> supervisorAtendentes) {
		this.supervisorAtendentes = supervisorAtendentes;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = super.hashCode();
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((supervisorAtendentes == null) ? 0 : supervisorAtendentes.hashCode());
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
		Atendente other = (Atendente) obj;
		if (id != other.id)
			return false;
		if (supervisorAtendentes == null) {
			if (other.supervisorAtendentes != null)
				return false;
		} else if (!supervisorAtendentes.equals(other.supervisorAtendentes))
			return false;
		return true;
	}

}
