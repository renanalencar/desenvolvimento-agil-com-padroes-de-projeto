package br.dev.rca;

import java.util.List;

/**
 * @author renanalencar
 *
 */
public class Badge extends Achievement {

	public Badge(String name) {
		super(name);
	}

	@Override
	public void addTo(List<Achievement> achievements) {
		if (achievements.contains(this) == false) {
			achievements.add(this);
		}
	}

}
