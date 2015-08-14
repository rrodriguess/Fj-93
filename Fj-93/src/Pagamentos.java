import java.util.ArrayList;
import java.util.Calendar;
/**
 * Classe Respons�vel por armazenar Pagamentos
 * @author Natho
 *
 */
public class Pagamentos extends ArrayList<Pagamento> {
	
	private double valorPago;
	
	public double getValorPago() {
		return valorPago;
	}
	
	private void paga(double valor) {
		if(valor < 0)
			throw new IllegalArgumentException("Valor invalido para pagamento");
		if(valor > 100)
			valor -= 8;
		
		this.valorPago += valor;
	}
	
	public void registra(Pagamento pagamento) {
		this.add(pagamento);
		this.paga(pagamento.getValor());
	}
	
	public ArrayList<Pagamento> pagamentosAntesDe(Calendar data) {
		ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
		for (Pagamento pagamento : this) {
			if(pagamento.getData().before(data)) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}
	
	public ArrayList<Pagamento> pagamentosComValorMaiorQue(double valorMinimo) {
		ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<>();
		for (Pagamento pagamento : this) {
			if(pagamento.getValor() > valorMinimo) {
				pagamentosFiltrados.add(pagamento);	
			}
		}
		return pagamentosFiltrados;
	}
	
	public ArrayList<Pagamento> pagamentosDo(String cnpjPagador) {
		ArrayList<Pagamento> pagamentosFiltrados = new ArrayList<>();
		for(Pagamento pagamento : this) {
			if(pagamento.getCnpjPagador().equals(cnpjPagador)) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}
}
