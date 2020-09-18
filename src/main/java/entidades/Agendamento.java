package entidades;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.OneToOne;
import javax.persistence.SequenceGenerator;

@Entity
@SequenceGenerator(name = "seq_agendamento", sequenceName = "seq_agendamento", initialValue = 1)
public class Agendamento {
	
	@Id
	@Column(name="agendamento_id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "seq_agendamento")
	private long id;
	
	@ManyToOne
	@JoinColumn(name = "cpf_dentista_id", foreignKey = @ForeignKey(name = "fk_agendamento_dentista"))
	private Dentista destista;
	
	@OneToOne
	@JoinColumn(name = "cpf_atendente_id", foreignKey = @ForeignKey(name = "fk_agendamento_atendente"))
	private Atendente atendente;
	
	@OneToOne
	@JoinColumn(name = "cpf_paciente_id", foreignKey = @ForeignKey(name = "fk_agendamento_paciente"))
	private Paciente paciente;
	
	@OneToOne
	@JoinColumn(name = "agendamento_id", foreignKey = @ForeignKey(name = "fk_agendamento_consulta"))
	private Consulta consulta;
	
	public Long getData_hora_id() {
		return id;
	}
	public void setData_hora_id(Long data_hora_id) {
		this.id = data_hora_id;
	}
	public Dentista getDestista() {
		return destista;
	}
	public void setDestista(Dentista destista) {
		this.destista = destista;
	}
	public Atendente getAtendente_id() {
		return atendente;
	}
	public void setAtendente_id(Atendente atendente_id) {
		this.atendente = atendente_id;
	}
	public Paciente getPaciente() {
		return paciente;
	}
	public void setPaciente(Paciente paciente) {
		this.paciente = paciente;
	}
	public Consulta getConsulta_id() {
		return consulta;
	}
	public void setConsulta_id(Consulta consulta_id) {
		this.consulta = consulta_id;
	}
	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((atendente == null) ? 0 : atendente.hashCode());
		result = prime * result + ((consulta == null) ? 0 : consulta.hashCode());
		result = prime * result + ((destista == null) ? 0 : destista.hashCode());
		result = prime * result + (int) (id ^ (id >>> 32));
		result = prime * result + ((paciente == null) ? 0 : paciente.hashCode());
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
		Agendamento other = (Agendamento) obj;
		if (atendente == null) {
			if (other.atendente != null)
				return false;
		} else if (!atendente.equals(other.atendente))
			return false;
		if (consulta == null) {
			if (other.consulta != null)
				return false;
		} else if (!consulta.equals(other.consulta))
			return false;
		if (destista == null) {
			if (other.destista != null)
				return false;
		} else if (!destista.equals(other.destista))
			return false;
		if (id != other.id)
			return false;
		if (paciente == null) {
			if (other.paciente != null)
				return false;
		} else if (!paciente.equals(other.paciente))
			return false;
		return true;
	}
	
}
