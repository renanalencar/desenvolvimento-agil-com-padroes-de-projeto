package br.dev.rca;

import java.util.List;

/**
 * @author renanalencar
 *
 */
public class Points extends Achievement {

	private int amount;

	public Points(String name, int amount) {
		super(name);
		this.amount = amount;
	}

	public int getAmount() {
		return amount;
	}

	public void setAmount(int amount) {
		this.amount += amount;
	}

	@Override
	public void addTo(List<Achievement> achievements) {
		if (achievements.contains(this)) {
			int index = achievements.indexOf(this);
			Points points = (Points) achievements.remove(index);
			this.setAmount(points.getAmount());
			achievements.add(this);
			return;
		} else {
			achievements.add(this);
		}
	}

}
