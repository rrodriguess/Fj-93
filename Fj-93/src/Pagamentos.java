import java.util.ArrayList;
import java.util.Calendar;
import java.util.Collection;
import java.util.Iterator;
/**
 * Classe Respons�vel por armazenar Pagamentos
 * @author Natho
 *
 */
public class Pagamentos implements Iterable<Pagamento>{
	
	private double valorPago;
	private Collection<Pagamento> pagamentos = new ArrayList<>();
	
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
		this.pagamentos.add(pagamento);
		this.paga(pagamento.getValor());
	}
	
	public Collection<Pagamento> pagamentosAntesDe(Calendar data) {
		Collection<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
		for (Pagamento pagamento : this) {
			if(pagamento.getData().before(data)) {
				pagamentosFiltrados.add(pagamento);
			}
		}
		return pagamentosFiltrados;
	}
	
	public Collection<Pagamento> pagamentosComValorMaiorQue(double valorMinimo) {
		Collection<Pagamento> pagamentosFiltrados = new ArrayList<>();
		for (Pagamento pagamento : this) {
			if(pagamento.getValor() > valorMinimo) {
				pagamentosFiltrados.add(pagamento);	
			}
		}
		return pagamentosFiltrados;
	}
	
    public Collection<Pagamento> pagamentosDo(Documento documentoPagador) {
        Collection<Pagamento> pagamentosFiltrados = new ArrayList<Pagamento>();
        for (Pagamento pagamento : this.pagamentos) {
          if (pagamento.getDocumentoPagador().equals(documentoPagador)) {
            pagamentosFiltrados.add(pagamento);
          }
        }
        return pagamentosFiltrados;
      }
	
	public boolean foiRealizado(Pagamento pagamento) {
		return pagamentos.contains(pagamento);
	}

	@Override
	public Iterator<Pagamento> iterator() {		
		return this.pagamentos.iterator();
	}
}
