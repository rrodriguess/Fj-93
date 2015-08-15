
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
	
	public String getValor() {
		return valor;
	}

	public void setValor(String novoValor) {
		this.valor = novoValor;
	}

	@Override
	public int hashCode() {
		return this.valor.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		if(!(obj instanceof Cnpj)) {
			return false;
		} 
		Cnpj cnpjOutro = (Cnpj) obj;
		return this.getValor().equals(cnpjOutro.getValor());

	}
	

}
