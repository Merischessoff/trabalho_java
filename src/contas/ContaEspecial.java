package contas;

import java.util.ArrayList;
import java.util.List;

import agencias.Agencia;
import clientes.Cliente;

public class ContaEspecial extends Conta{
	private double limite=0;
	private List<Cliente> clientes = new ArrayList<Cliente>();
	
	public ContaEspecial() {}

	public ContaEspecial(double saldo, long numero, Agencia agencia, double limite, List<Cliente> clientes) {
		super(saldo, numero, agencia);
		this.limite = limite;
		this.setClientes(clientes);
	}

	public double getLimite() {
		return limite;
	}

	public void setLimite(double limite) {
		this.limite = limite;
	}

	public List<Cliente> getClientes() {
		return clientes;
	}

	public void setClientes(List<Cliente> clientes) {
		this.clientes = clientes;
	}

	
	@Override
	public double credita(double aux) {
		// TODO Auto-generated method stub
		return super.credita(aux);
	}

	@Override
	public double debita(double aux) {
		// TODO Auto-generated method stub
		return super.debita(aux);
	}

	@Override
	public String toString() {
		if(this.clientes.size() > 0) {
			String clientes = "";
			for(Cliente a: this.clientes){
				clientes += "Cliente[cpf=" + a.getCpf() + ",nome=" + a.getNome() + "]";
			}
			return "ContaEspecial [limite=" +limite  +  ", saldo=" + getSaldo() + 
					", numero=" + getNumero() + ","+ getAgencia() + "], " + clientes ;
		}else {
			return "ContaEspecial necessida de pelo menos 1 cliente cadastrado!";
		}
	}
	
	
	 
	
}
