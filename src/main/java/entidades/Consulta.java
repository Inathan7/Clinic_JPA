package entidades;

import java.io.Serializable;

import javax.persistence.Entity;
import javax.persistence.ForeignKey;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.MapsId;
import javax.persistence.OneToOne;

@Entity
public class Consulta implements Serializable{
	
	private String receituario;
	
	@Id
	@MapsId
	@OneToOne
	@JoinColumn(name = "agendamento_id", foreignKey = @ForeignKey(name = "fk_consulta_agendamento"))
	private Agendamento agendamento;

	public String getReceituario() {
		return receituario;
	}

	public void setReceituario(String receituario) {
		this.receituario = receituario;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((receituario == null) ? 0 : receituario.hashCode());
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
		Consulta other = (Consulta) obj;
		if (receituario == null) {
			if (other.receituario != null)
				return false;
		} else if (!receituario.equals(other.receituario))
			return false;
		return true;
	}
	
	

}
