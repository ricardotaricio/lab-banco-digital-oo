package banco;
import java.util.ArrayList;
import java.util.List;

public abstract class Conta {
	
	private static final int AGENCIA_PADRAO = 1;
	private static int SEQUENCIAL = 1;

	protected int agencia;
	protected int numero;
	protected double saldo;
	protected Cliente cliente;
	protected List<Operacao> operacoes;

	public Conta(Cliente cliente) {
		this.agencia = Conta.AGENCIA_PADRAO;
		this.numero = SEQUENCIAL++;
		this.cliente = cliente;
		this.operacoes = new ArrayList<Operacao>();
	}

	protected abstract String getTipoConta();

	public void sacar(double valor) {
		saldo -= valor;
		this.registrarOperacao(TipoOperacao.SAQUE, valor);
	}

	public void depositar(double valor) {
		saldo += valor;
		this.registrarOperacao(TipoOperacao.DEPOSITO, valor);
	}

	public void transferir(double valor, Conta contaDestino) {
		this.sacar(valor);
		contaDestino.depositar(valor);
	}

	public void imprimirSaldo() {
		System.out.println("=== Saldo " + this.getTipoConta() + " ===");
		this.imprimirInfosComuns();
		System.out.println();
	}

	public void imprimirExtrato() {
		System.out.println("=== Extrato " + this.getTipoConta() + " ===");
		this.imprimirInfosComuns();
		this.imprimirListaOperacoes();
		System.out.println();
	}
	
	private void registrarOperacao(TipoOperacao tipo, double valor) {
		this.operacoes.add(new Operacao(tipo, valor));
	}
	
	private void imprimirInfosComuns() {
		System.out.println(String.format("Titular: %s", this.cliente.getNome()));
		System.out.println(String.format("Agencia: %d", this.agencia));
		System.out.println(String.format("Numero: %d", this.numero));
		System.out.println(String.format("Saldo: %.2f", this.saldo));
	}
	
	private void imprimirListaOperacoes() {
		operacoes.forEach(op -> System.out.println(op));
	}
	
	public int getAgencia() {
		return agencia;
	}

	public int getNumero() {
		return numero;
	}

	public double getSaldo() {
		return saldo;
	}
}
