public class Divida {

	private double total;

	private String credor;
	private Documento documentoCredor;
	private Pagamentos pagamentos = new Pagamentos();

	public double getTotal() {
		return total;
	}

	public void setTotal(double total) {
		this.total = total;
	}

//	public Pagamentos getPagamentos() {
//		return pagamentos;
//	}
	
	public Documento getDocumentoCredor() {
		return documentoCredor;
	}

	public void setDocumentoCredor(Documento documentoCredor) {
		this.documentoCredor = documentoCredor;
	}


	public void registra(Pagamento pagamento) {
		pagamentos.registra(pagamento);
	}

	public double getValorPago() {
		return pagamentos.getValorPago();
	}

	public String getCredor() {
		return credor;
	}

	public void setCredor(String credor) {
		this.credor = credor;
	}
	

}
