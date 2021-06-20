/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package trabalhojava;

import java.io.IOException;
import java.time.LocalDate;
import java.util.ArrayList;
import javax.swing.DefaultComboBoxModel;
import javax.swing.JComboBox;
import javax.swing.JDialog;
import javax.swing.JOptionPane;

/**
 *
 * @author Meri e Leo
 */
public class Principal {
    public static void main(String[] args) throws IOException, ClassNotFoundException{
        int opcao = 0;
  /*1 – Cadastrar Usuário
    2 – Cadastrar Veículo Segurado
    3 – Cadastrar Cliente
    4 – Listar todos os Clientes
    5 – Listar todos os Veículos
    6 – Listar todos os Usuários
    7 – Sair*/
  
    ArrayList listaUsuarios = new ArrayList();
    ArrayList veiculoSeguradoCadastro = new ArrayList();
    ArrayList listaClientes = new ArrayList();
     
        do{       
            try{
                String input = leInput("Escolha opção:" 
                + "\n1 - Cadastrar Usuário."
                + "\n2 - Cadastrar Veículo Segurado."
                + "\n3 - Cadastrar Cliente."
                + "\n4 - Listar todos os Usuários."
                + "\n5 - Listar todos os Veículos."
                + "\n6 - Listar todos os Clientes."
                + "\n7 - Sair");

                opcao = Integer.parseInt(input);
                } catch(CampoVazioException cve){
                 JOptionPane.showMessageDialog(null, cve.getMessage());
                } catch (NumberFormatException obj){
                 JOptionPane.showMessageDialog(null, "Você deve informar um número.");
                } catch (Exception e){
                 JOptionPane.showMessageDialog(null, "Algo de errado aconteceu.");
                }

                switch(opcao){
                    case 1://1 – Cadastrar Usuário
                        //variaveis
                        String nomeUsuario;
                        String identificadorUsuario;
                        String nasUsuarioAux;
                        LocalDate nasUsuario;
                        String senhaUsuario;
                        
                        //entradas
                        nomeUsuario = JOptionPane.showInputDialog(null,"Digite o nome do usuario.");
                        nasUsuarioAux = JOptionPane.showInputDialog(null,"Digite a data de nascimento no padrão ano-mes-dia, sendo ano com 4 digitos e 2 digitos para mês e dia.");
                        identificadorUsuario = JOptionPane.showInputDialog(null, "Digite o identificador do usuario.");
                        senhaUsuario = JOptionPane.showInputDialog(null, "Digite a senha do usuario.");                      
                        nasUsuario = LocalDate.parse(nasUsuarioAux);
                        //instância de classe Usuario
                        Usuario usuarioCadastro;
                        //criando um objeto Usuario
                        usuarioCadastro = new Usuario(identificadorUsuario, senhaUsuario, nomeUsuario, nasUsuario);
                        
                        //Criando uma lista do tipo ArrayList
                        listaUsuarios.add(usuarioCadastro);
             
                        break;
                  
                    case 2://Cadastrar Veiculo Segurado
                        //variaveis
                        String kilometragemAux;
                        String placa;
                        Apolice apolice = new Apolice();
                        apolice.setData(LocalDate.now());
                        apolice.setDataValidade(LocalDate.of(2030, 05, 05));
                        apolice.setNumero(01);
                        apolice.setSeguradora("Meridiane Seguradora");
                        apolice.setSituacao(SituacaoApolice.Negociação);
                        SituacaoApolice situacao;
                        String modelo;
                        double kilometragem = 0;
                    
                        //entradas
                        kilometragemAux = JOptionPane.showInputDialog(null, "Digite a kilometragem do carro.");
                        placa = JOptionPane.showInputDialog(null, "Digite a placa do carro.");
                        modelo = JOptionPane.showInputDialog(null, "Digite o modelo do carro.");
                        
                        /*JComboBox comboBox = new JComboBox();
                        comboBox.add(null, situacao.Cancelada);
                        comboBox.add(null, situacao.Negociação);
                        comboBox.add(null, situacao.Parcelada);
                        comboBox.add(null, situacao.Quitada);
                        //setModel(new DefaultComboBoxModel(SituacaoApolice.values()));
                        comboBox.setEditable(true);
                        Object[] options = new Object[] {};
                            JOptionPane jop = new JOptionPane("Selecione",
                                        JOptionPane.QUESTION_MESSAGE,
                                        JOptionPane.DEFAULT_OPTION,
                                        null,options, null);
                        jop.add(comboBox);
                        
                        JDialog diag = new JDialog();
                        diag.getContentPane().add(jop);
                        diag.pack();
                        diag.setVisible(true);
                        
                        apolice.setSituacao((SituacaoApolice)comboBox.getSelectedItem());*/
                        kilometragem = Double.parseDouble(kilometragemAux);
                        
                        //instância de classe VeiculoSegurado e objeto criado
                        VeiculoSegurado veiculo = new VeiculoSegurado(kilometragem, placa, apolice);
                    
                        //Criando uma lista do tipo ArrayList
                        veiculoSeguradoCadastro.add(veiculo);
                        break;
                  
                    case 3:
                        //Cadastrar cliente
                        String nomeCliente;
                        String nasClienteAux;
                        String enderecoCliente;
                        LocalDate nasCliente;
                        String telefoneCliente;
                        
                        //entradas
                        nomeCliente = JOptionPane.showInputDialog(null,"Digite o nome do cliente.");
                        nasClienteAux = JOptionPane.showInputDialog(null,"Digite a data de nascimento no padrão ano-mes-dia, sendo ano com 4 digitos e 2 digitos para mês e dia.");
                        enderecoCliente = JOptionPane.showInputDialog(null, "Digite o endereço do cliente.");
                        telefoneCliente = JOptionPane.showInputDialog(null, "Digite o telefone do cliente.");
                        
                        nasCliente = LocalDate.parse(nasClienteAux);
                        //instância de classe Usuario
                        Cliente clienteCadastro;
                        //criando um objeto Usuario
                        clienteCadastro = new Cliente(nomeCliente, nasCliente, enderecoCliente, telefoneCliente);
                        
                        //Criando uma lista do tipo ArrayList
                        listaClientes.add(clienteCadastro);
                        
                        break; 
                  
                    case 4://Listar Usuarios
                        JOptionPane.showMessageDialog(null, listaUsuarios);
                        break;
                    
                    case 5://Listar Veiculos Segurados
                        JOptionPane.showMessageDialog(null, veiculoSeguradoCadastro);
                        break;
                    
                    case 6://Listar Clientes
                        JOptionPane.showMessageDialog(null, listaClientes);
                        break;
                }//switch                 

       } while (opcao < 7);//do
   
}
//principal
    public static String leInput(String mensagem) throws CampoVazioException{
        //throws sinaliza que dentro deste método há excessão
        String S = JOptionPane.showInputDialog(null, mensagem);
        if (S==null || S.equals(" ")) throw new CampoVazioException("Digite algo");
        //throw cria excessão
        return S;
     }
    
}
    
    
    
    
