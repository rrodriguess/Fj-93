
public class GerenciadorDeDividas {

	public void efetuaPagamento(Divida divida, String nomePagador, String cnpjPagador, double valor) {
		Pagamento pagamento = new Pagamento();
		pagamento.setCnpjPagador(cnpjPagador);
		pagamento.setValor(valor);
		pagamento.setPagador(nomePagador);
		
		divida.registra(pagamento);		
	}
}
