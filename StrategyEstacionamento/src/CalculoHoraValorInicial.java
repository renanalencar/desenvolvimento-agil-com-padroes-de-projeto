
public class CalculoHoraValorInicial implements Calculo {
	
	private int valorInicial;
	private int limiteHoraInicial;
	private int valorHoraExcedente;

	public CalculoHoraValorInicial(int valorInicial, 
			int limiteHoraInicial, int valorHoraExcedente) {
		this.valorInicial = valorInicial;
		this.limiteHoraInicial = limiteHoraInicial;
		this.valorHoraExcedente = valorHoraExcedente;
	}

	@Override
	public int calcularTarifa(int qtdHoras) {
		int valor = valorInicial;
		if (qtdHoras > limiteHoraInicial) {
			valor += (qtdHoras - limiteHoraInicial) * valorHoraExcedente;
		}
		return valor;
	}

}
