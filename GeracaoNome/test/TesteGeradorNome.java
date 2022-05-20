import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class TesteGeradorNome {

	@Test
	void nomeBase() {
		GeradorNome gn = new GeradorNomeBuilder()
				.criarPessoa().gerar();
		String nome = gn.gerarNome("Eduardo");
		assertEquals("Eduardo", nome);
	}
	
	@Test
	void mestre() {
		GeradorNome gn = new GeradorNomeBuilder()
				.criarMestre().gerar();
		String nome = gn.gerarNome("Eduardo");
		assertEquals("Mestre Eduardo", nome);
	}
	
	@Test
	void doutor() {
		GeradorNome gn = new GeradorNomeBuilder()
				.criarDoutor().gerar();
		String nome = gn.gerarNome("Eduardo");
		assertEquals("Doutor Eduardo", nome);
	}
	
	@Test
	void excelentissimoDoutor() {
		GeradorNome gn = new GeradorNomeBuilder()
				.criarDoutor().excelentissimo().gerar();
		String nome = gn.gerarNome("Eduardo");
		assertEquals("Excelentíssimo Doutor Eduardo", nome);
	}
	
	@Test
	void magnificoDoutor() {
		GeradorNome gn = new GeradorNomeBuilder()
				.criarDoutor().magnifico().gerar();
		String nome = gn.gerarNome("Eduardo");
		assertEquals("Magnífico Doutor Eduardo", nome);
	}
	
	@Test
	void excelentissimoMagnificoDoutor() {
		GeradorNome gn = new GeradorNomeBuilder()
				.criarDoutor().excelentissimo().magnifico().gerar();
		String nome = gn.gerarNome("Eduardo");
		assertEquals("Excelentíssimo Magnífico Doutor Eduardo", nome);
	}
	
	@Test
	void pessoaDeJuizDeFora() {
		GeradorNome gn = new GeradorNomeBuilder()
				.criarPessoa().de("Juiz de Fora").gerar();
		String nome = gn.gerarNome("Eduardo");
		assertEquals("Eduardo de Juiz de Fora", nome);
	}
	
	@Test
	void magnificoDoutorDeJuizDeForaDeSaoJose() {
		GeradorNome gn = new GeradorNomeBuilder()
				.criarDoutor().magnifico()
				.de("Juiz de Fora").de("São José").gerar();
		String nome = gn.gerarNome("Eduardo");
		assertEquals("Magnífico Doutor Eduardo de Juiz de Fora de São José", nome);
	}

}
