
public class Cnpj {
	
	private String valor;
	
	private boolean ehValido() {
		return primeiroDigitoVerificador() == primeiroDigitoCorreto()
				&& segundoDigitoVerificador() == segundoDigitoCorreto();
	}
	
	private int segundoDigitoCorreto() {
		return 2;
	}
	
	private int segundoDigitoVerificador() {
		return 2;
	}
	
	private int primeiroDigitoVerificador() {
		return 1;
	}
	
	private int primeiroDigitoCorreto() {
		return 1;
	}
	
	public String getCnpjCredor() {
		return valor;
	}

	public void setCnpjCredor(String novoValor) {
		this.valor = novoValor;
	}
	

}
