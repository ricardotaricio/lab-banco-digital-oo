package banco;

public class ContaCorrente extends Conta {

	public ContaCorrente(Cliente cliente) {
		super(cliente);
	}

	@Override
	protected String getTipoConta() {
		return "Conta Corrente";
	}	
}
