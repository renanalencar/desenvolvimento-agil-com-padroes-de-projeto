import static org.junit.Assert.*;

import org.junit.Test;

public class TesteProxySeguranca {

	@Test
	public void testeAutorizaAcesso() {
		Usuario guerra = new Usuario("Guerra");
		guerra.autorizaAcesso("InterfaceNegocio", "executaTransacao");
		NegocioMock mock = new NegocioMock();
		InterfaceNegocio n = new SegurancaNegocio(mock, guerra);
		n.executaTransacao();
		assertTrue(mock.isFoiAcessado());
	}
	
	@Test
	public void testeNaoAutorizaAcesso() {
		Usuario guerra = new Usuario("Guerra");
		guerra.autorizaAcesso("InterfaceNegocio", "executaTransacao");
		NegocioMock mock = new NegocioMock();
		InterfaceNegocio n = new SegurancaNegocio(mock, guerra);
		try {
			n.cancelaTransacao();
			fail();
		} catch (Exception e) {
			assertFalse(mock.isFoiAcessado());
		}
		
	}

}
