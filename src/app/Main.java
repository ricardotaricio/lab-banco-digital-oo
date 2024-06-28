package app;
import banco.Cliente;
import banco.Conta;
import banco.ContaCorrente;
import banco.ContaPoupanca;

public class Main {

	public static void main(String[] args) {
		Cliente venilton = new Cliente();
		venilton.setNome("Venilton");
		
		Conta cc = new ContaCorrente(venilton);
		Conta poupanca = new ContaPoupanca(venilton);

		cc.depositar(100);
		cc.transferir(100, poupanca);
		
		cc.imprimirSaldo();
		cc.imprimirExtrato();
		
		poupanca.imprimirSaldo();
		poupanca.imprimirExtrato();
	}

}
