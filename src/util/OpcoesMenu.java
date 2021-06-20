package util;

public enum OpcoesMenu {	
	CADASTRAR(1), PESQUISAR_CONTA_ESPECIAL_USANDO_NUMERO(2), 
	PESQUISAR_CONTA_ESPECIAL_USANDO_AGENCIA(3), 
	PESQUISAR_CONTA_ESPECIAL_USANDO_CPF(4), SAIR(5);
	
	/*1 – Cadastrar Conta Especial
	2 – Pesquisar Conta Especial usando número
	3 – Pesquisar Conta Especial usando número da agência
	4 – Pesquisar Conta Especial usando o CPF do cliente
	5 – Sair*/
	
	private final int valor;
	private String nome = "";
	
	OpcoesMenu(int valorOpcao){
		valor = valorOpcao;
		if(valorOpcao==1) {
			this.nome = "Cadastrar Conta Especial";
		}else if (valorOpcao==2) {
			this.nome = "Pesquisar Conta Especial usando número";
		}else if (valorOpcao==3) {
			this.nome = "Pesquisar Conta Especial usando número da agência";
		}else if (valorOpcao==4) {
			this.nome = "Pesquisar Conta Especial usando o CPF do cliente";
		}else if (valorOpcao==5) {
			this.nome = "Sair";
		}
	}
	
	public int getValor(){
		return valor;
	}
	public String getNome() {
		return nome;
	}
	
    @Override
    public String toString(){
    	return this.getValor() + " - " + this.getNome();
    }

	

}
