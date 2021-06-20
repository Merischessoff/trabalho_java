package contas;

import agencias.Agencia;

public abstract class  Conta {
	private double saldo=0;
	private long numero=0;
	private Agencia agencia = new Agencia();
	
	public Conta(){}
	
	public Conta(double saldo, long numero) {
		super();
		this.saldo = saldo;
		this.numero = numero;
	}

	public Conta(double saldo, long numero, Agencia agencia) {
		super();
		this.saldo = saldo;
		this.numero = numero;
		this.agencia = agencia;
	}

	public double getSaldo() {
		return saldo;
	}
	public void setSaldo(double saldo) {
		this.saldo = saldo;
	}
	public double getNumero() {
		return numero;
	}
	public void setNumero(long numero) {
		this.numero = numero;
	}

	public double credita(double aux) {
		return 0;
	}
	
	public double  debita(double aux) {
		return aux;
		
	}
	
	public Agencia getAgencia() {
		return agencia;
	}

	public void setAgencia(Agencia agencia) {
		this.agencia = agencia;
	}

	@Override
	public String toString() {
		return "Conta [saldo=" + saldo + ", numero=" + numero + "]";
	}

}
