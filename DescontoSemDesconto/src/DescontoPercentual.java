
public class DescontoPercentual implements Desconto {
	
	private double percentualDesconto;

	public DescontoPercentual(double percentualDesconto) {
		super();
		this.percentualDesconto = percentualDesconto;
		
	}

	@Override
	public double darDesconto(double valorOriginal) {
		return valorOriginal * (1.0 - percentualDesconto / 100.0);
	}

}
