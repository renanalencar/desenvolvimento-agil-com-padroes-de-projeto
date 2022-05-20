
public class TrechoAereoSimples implements TrechoAereo {
	
	private String origem;
	private String destino;
	private int custo;
	private int distancia;
	
	public TrechoAereoSimples(String origem, String destino, int custo, int distancia) {
		super();
		this.origem = origem;
		this.destino = destino;
		this.custo = custo;
		this.distancia = distancia;
	}

	/* (non-Javadoc)
	 * @see TrechosAereos#getOrigem()
	 */
	@Override
	public String getOrigem() {
		return origem;
	}

	public void setOrigem(String origem) {
		this.origem = origem;
	}

	/* (non-Javadoc)
	 * @see TrechosAereos#getDestino()
	 */
	@Override
	public String getDestino() {
		return destino;
	}

	/* (non-Javadoc)
	 * @see TrechosAereos#getCusto()
	 */
	@Override
	public int getCusto() {
		return custo;
	}

	/* (non-Javadoc)
	 * @see TrechosAereos#getDistancia()
	 */
	@Override
	public int getDistancia() {
		return distancia;
	}

}
