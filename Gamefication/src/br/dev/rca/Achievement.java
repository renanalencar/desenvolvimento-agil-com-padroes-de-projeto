package br.dev.rca;

import java.util.List;
import java.util.Objects;

/**
 * @author renanalencar
 *
 */
public abstract class Achievement {

	private String name;

	public Achievement(String name) {
		this.name = name;
	}

	public String getName() {
		return name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public abstract void addTo(List<Achievement> achievements);

	@Override
	public int hashCode() {
		return Objects.hash(name);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null || getClass() != obj.getClass())
			return false;
		Achievement other = (Achievement) obj;
		return Objects.equals(name, other.name);
	}

}
