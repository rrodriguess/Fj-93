public class TestaPagamentos {
	
	public static void main(String[] args) {
		BancoDeDados bd = new BancoDeDados("localhost", "usuario", "senha");
		Arquivo arquivoBd = new Arquivo();
		BalancoEmpresa balanco = new BalancoEmpresa(bd);
		
		registraDivida(balanco);
		realizaPagamentos(balanco );
		
		bd.desconecta();
	}
	
	private static void registraDivida(BalancoEmpresa balanco) {
		Divida divida1 = new Divida();
		Divida divida2 = new Divida();
		
		divida1.setCredor("Rental");
		divida1.setDocumentoCredor(new Cnpj("00.000.001/0001-01"));
		divida1.setTotal(1000);
		
		divida2.setCredor("Assessorize");
		divida2.setDocumentoCredor(new Cnpj("00.000.001/0001-01"));
		divida2.setTotal(1000);
	}
	
	private static void realizaPagamentos(BalancoEmpresa balanco) {
		Pagamentos pagamentos = new Pagamentos();
		Pagamento pagamento1 = new Pagamento();
		pagamento1.setValor(105);
		
		Pagamento pagamento2 = new Pagamento();
		pagamento2.setValor(25);
		
		pagamentos.registra(pagamento1);
		pagamentos.registra(pagamento2);
		
		System.out.println(pagamentos.foiRealizado(pagamento1));
		
		System.out.println("Valor total pago: " + pagamentos.getValorPago());
		System.out.println("Valor total pagao: " + pagamentos.getValorPago());
		
		Iterable<Pagamento> lista = new Pagamentos();
		for (Pagamento pagamento : lista) {
			System.out.println(pagamento.getValor());
		}
	}
	
}
