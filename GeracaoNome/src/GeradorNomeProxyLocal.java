
public class GeradorNomeProxyLocal extends GeradorNome {

	private GeradorNome gerador;
	private String local;
	
	public GeradorNomeProxyLocal(GeradorNome gerador, String local) {
		super();
		this.gerador = gerador;
		this.local = local;
	}

	public void setTratamento(Tratamento tratamento) {
		gerador.setTratamento(tratamento);
	}

	public Tratamento getTratamentoStrategy() {
		return gerador.getTratamentoStrategy();
	}

	public String gerarNome(String nomeBase) {
		return gerador.gerarNome(nomeBase) + " de " + local;
	}

	@Override
	protected String getTratamento() {
		return gerador.getTratamento();
	}
	
	
}
