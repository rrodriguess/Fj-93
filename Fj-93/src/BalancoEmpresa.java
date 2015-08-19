public class BalancoEmpresa {	
	private ArmazenadorDeDividas dividas;

	public BalancoEmpresa(ArmazenadorDeDividas bd) {
		this.dividas = bd;
	}

	public void registroDividas(Divida divida) {		
		dividas.salva(divida);
	}	
	
	public void pagaDivida(Documento documentoCredor, Pagamento pagamento) {
		Divida divida = dividas.carrega(documentoCredor);
		if(divida != null) {
			divida.registra(pagamento);
		}
		dividas.salva(divida);
	}

}
