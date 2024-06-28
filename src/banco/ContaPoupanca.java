package banco;

public class ContaPoupanca extends Conta {

	public ContaPoupanca(Cliente cliente) {
		super(cliente);
	}

	@Override
	protected String getTipoConta() {
		return "Conta Poupança";
	}
}
