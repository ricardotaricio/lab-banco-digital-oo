package banco;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Operacao {
	private LocalDateTime dataHora;
	private TipoOperacao tipo;
	private double valor;
	
	public Operacao(TipoOperacao tipo, double valor) {
		this.dataHora = LocalDateTime.now();
		this.tipo = tipo;
		this.valor = valor;
	}
	
	@Override
	public String toString() {
		DateTimeFormatter dtf = DateTimeFormatter.ofPattern("dd/MM/yyyy HH:mm:ss");
		return this.dataHora.format(dtf) + " - " + tipo + " - " + valor;
	}
}
