import java.util.HashMap;

public class BalancoEmpresa {
	
	private HashMap<String, Divida> dividas = new HashMap<String, Divida>();

	public void registroDividas(String credor, String cnpjCredor, double valor) {
		Divida divida = new Divida();
		divida.setCredor(credor);
		divida.setTotal(valor);
		divida.getCnpjCredor().setValor(cnpjCredor);
		
		dividas.put(cnpjCredor, divida);
		
	}
	
	public void registroDividas(Divida divida) {
		dividas.put(divida.getCnpjCredor().getValor(), divida);
	}
	
	public void pagaDivida(String cnpjCredor, double valor, String nomePagador, String cnpjPagador) {
		Divida divida = dividas.get(cnpjCredor);
		if(divida != null) {
			Pagamento pagamento = new Pagamento();
			pagamento.setCnpjPagador(cnpjPagador);
			pagamento.setPagador(nomePagador);
			pagamento.setValor(valor);
			
			divida.getPagamentos().registra(pagamento);
		}
	}
	
	public void pagaDivida(String cnpjCredor, Pagamento pagamento) {
		Divida divida = dividas.get(cnpjCredor);
		if(divida != null) {
			divida.getPagamentos().add(pagamento);
		}
	}

}
