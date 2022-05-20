
public class Item {
	
	private String nome;
	private double valor;
	private Desconto desconto = new SemDesconto();

	public Item(String nome, double valor) {
		super();
		this.nome = nome;
		this.valor = valor;
	}

	public Item(String nome, double valor, Desconto desconto) {
		super();
		this.nome = nome;
		this.valor = valor;
		this.desconto = desconto;
	}

	public double precoQuantidade(int qtd) {
		return desconto.darDesconto(valor) * qtd;
	}

	@Override
	public String toString() {
		return nome + " R$" + desconto.darDesconto(valor);
	}
	
	

}
