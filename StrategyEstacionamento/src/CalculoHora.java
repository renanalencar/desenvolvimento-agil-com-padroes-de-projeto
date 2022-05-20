
public class CalculoHora implements Calculo {
	
	private int valorHora;

	public CalculoHora(int valorHora) {
		this.valorHora = valorHora;
	}

	@Override
	public int calcularTarifa(int qtdHoras) {
		return qtdHoras * valorHora;
	}

}
