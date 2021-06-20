package principal;
/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

import javax.swing.JOptionPane;

import agencias.Agencia;
import clientes.Cliente;
import contas.ContaEspecial;


import util.OpcoesMenu;

/**
 *
 * @author Meri e Leo
 */
public class Principal {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
	  /*4) Crie o menu abaixo:
		1 – Cadastrar Conta Especial
		2 – Pesquisar Conta Especial usando número
		3 – Pesquisar Conta Especial usando número da agência
		4 – Pesquisar Conta Especial usando o CPF do cliente
		5 – Sair
		4) Usar uma interface com método validador para o CPF
		5) Usar enum para os itens de menu*/
    	boolean opcaoW = true;
    	List <ContaEspecial> listaConta = new ArrayList<ContaEspecial>();
    	while (opcaoW) {   
        	int opcao = montaMenu();
            switch(opcao){
            	case 1:
            		//1 – Cadastrar Conta Especial
            		boolean cadastra = true;
            		while(cadastra) {
            	    	List <Cliente> listaCliente = new ArrayList<Cliente>();
            	    	int clienteCadastra = 0;
	            		while(clienteCadastra==0) {
	            	    	Cliente c = new Cliente();
		            		
		                    String nome = JOptionPane.showInputDialog(null, "Digite o nome do cliente.");
		                    c.setNome(nome);
		                    String cpf = JOptionPane.showInputDialog(null, "Digite o cpf do cliente.");
		                    boolean a = c.validaCpf(cpf);
		                    if(a) {
		                    	c.setCpf(cpf);
		                    }else {
			                    while(!a) {
			                    	int aux = Integer.parseInt(JOptionPane.showInputDialog(null, "Cpf inválido. para inserir novo cpf, digite 1, para sair digite 2"));
			                    	if(aux==1) {
			                    		cpf = JOptionPane.showInputDialog(null, "Digite o cpf do cliente.");
			                    		a = c.validaCpf(cpf);
			                    		if(a)
			                    			c.setCpf(cpf);
			                    	}else {
			                    		System.exit(0);
			                    	}
			                    }
		                    }
		                    listaCliente.add(c);
		                    clienteCadastra = JOptionPane.showConfirmDialog(null, "Gostaria de cadastrar mais 1 cliente na conta especial?");
	            		}
	                    
	                    int agencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da agência."));
	                    String endAgencia = "Padrão";
	                    Agencia aG = new Agencia(agencia, endAgencia);
	                    double saldoConta = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o saldo da conta especial."));
	                    long numConta = Long.parseLong(JOptionPane.showInputDialog(null, "Digite o numero da conta."));
	                    double limContaEspecial = Double.parseDouble(JOptionPane.showInputDialog(null, "Digite o limite da conta especial."));
	                    ContaEspecial contaEspecial = new ContaEspecial(saldoConta, numConta, aG, limContaEspecial, listaCliente);
	                    listaConta.add(contaEspecial);
	                    cadastra = false;
            		}
                    break;
                case 2:
                	//2 – Pesquisar Conta Especial usando número
                	 int numConta = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número da conta especial sem nenhum caractere especial."));
                	 boolean achou = false;
                	 for (ContaEspecial aux: listaConta) {
                		 if(!achou) {
	                		 if(aux.getNumero() == numConta) {
	                			 JOptionPane.showMessageDialog(null, "Conta especial encontrada " + aux.toString());
	                			 achou = true;
	                		 }
                		 }
                	 }
                	 if (!achou) {
            			 JOptionPane.showInputDialog("Conta especial não encontrada ");
            		 }
                	 break;
                case 3:
                	//3 – Pesquisar Conta Especial usando número da agência
                	int numAgencia = Integer.parseInt(JOptionPane.showInputDialog(null, "Digite o número de agencia vinculada à conta especial sem nenhum caractere especial."));
                	achou = false;
                	for (ContaEspecial aux: listaConta) {
               		 	if(!achou) {
		               		 if(aux.getAgencia().getNumero() == numAgencia) {
		               			 JOptionPane.showMessageDialog(null, "Conta especial encontrada " + aux.toString());
		               			achou = true;
		               		 }
               		 	}
                	}
                	 if (!achou) {
            			 JOptionPane.showMessageDialog(null, "Conta especial não encontrada ");
            		 }
                    break; 
                  
                case 4:
                //Pesquisar Conta Especial usando o CPF do cliente
                	String numCpf = JOptionPane.showInputDialog(null, "Digite o número de cpf vinculado à conta especial sem nenhum caractere especial.");
                	achou = false;
                	for (ContaEspecial aux: listaConta) {
                		int i = 0;
                		while(i < aux.getClientes().size()) {
                   		 	if(!achou) {
		                		if(aux.getClientes().get(i).getCpf().equalsIgnoreCase(numCpf)) {
				               		JOptionPane.showMessageDialog(null, "Conta especial encontrada " + aux.toString());
				               		achou = true;
		                		}
                   		 	}
	                		i++;
                		}
                	}
                	 if (!achou) {
            			 JOptionPane.showInputDialog("Conta especial não encontrada ");
            		 }
                    break; 
                case 5:
                	opcaoW = false;
                	break;
                }//switch                 
       }
    }
    private static int montaMenu(){
        String str = "";
        for(OpcoesMenu op : OpcoesMenu.values())
            str +=  op.toString() + "\n";
        return Integer.parseInt(JOptionPane.showInputDialog(str));             
    }
}
    
    
    
    
