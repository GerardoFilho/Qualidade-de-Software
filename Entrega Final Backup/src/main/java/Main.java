import recursos.MVC.controles.ContatoController;
import recursos.MVC.controles.GrupoController;
import recursos.MVC.controles.TelefoneController;
import recursos.MVC.modelos.Contato;
import recursos.MVC.modelos.Grupo;
import recursos.MVC.modelos.Telefone;
import recursos.MVC.views.ContatoView;
import recursos.MVC.views.GrupoView;
import recursos.MVC.views.TelefoneView;

import java.util.ArrayList;
import java.util.Scanner;


public class Main{

    public static void main(String... args){
        System.out.println("Bem vindo a sua Agenda Eletronica!");

        Scanner input = new Scanner(System.in);
		boolean isFim = false;
		
		while (!isFim) {
		    System.out.println();
		    System.out.println("Escolha uma categoria: ");
		
		    System.out.println("1 - Contatos.");
		    System.out.println("2 - Telefones.");
		    System.out.println("3 - Grupos.");
		    System.out.println("9 - Sair.");
		
		    boolean entradaValida = false;
		    while (!entradaValida){
		        System.out.print("Opcao: ");
		        String entrada = input.nextLine();
		        switch (entrada){
		            case "1":
		                entradaValida = true;
					ContatoView r2 = new ContatoView();
		                System.out.println();
					System.out.println("Escolha uma ação: ");
					
					System.out.println("1 - Consultar contato.");
					System.out.println("2 - Adicionar contato.");
					System.out.println("3 - Deletar contato.");
					System.out.println("4 - Alterar contato.");
					System.out.println("0 - Voltar.");
					
					boolean entradaValida3 = false;
					while (!entradaValida3){
					    System.out.print("Ação: ");
					    String entrada3 = input.nextLine();
					    switch (entrada3){
					        case "1":
					            entradaValida3 = true;
					            r2.consultar(input);
					            break;
					        case "2":
					            entradaValida3 = true;
							System.out.println("Você esta adicionando um novo contato");
							System.out.println("Se o campo não se aplicar, basta deixar em branco.");
							String numero1 = "";
							String nome1 = "";
							String sobreNnome = "";
							String email = "";
							
							boolean confirmado = false;
							while (!confirmado){
							    System.out.print("\nNome: ");
							    nome1 = input.nextLine();
							
							    System.out.print("\nSobrenome: ");
							    sobreNnome = input.nextLine();
							
							    System.out.print("\nNumero: ");
							    numero1 = input.nextLine();
							
							    System.out.print("\nEmail: ");
							    email = input.nextLine();
							
							    System.out.println("Você vai adicionar o contato: " + nome1 + " " + sobreNnome + " com o numero: " + numero1);
							
							    boolean confirmacaoValida = false;
							    while (!confirmacaoValida){
							        System.out.print("Confirmar? (S/N) ");
							        String confirmacao = input.nextLine();
							        switch (confirmacao.toUpperCase()){
							            case "S":
							                confirmado = true;
							                confirmacaoValida = true;
							                break;
							            case "N":
							                confirmado = false;
							                confirmacaoValida = true;
							                break;
							            default:
							                confirmacaoValida = false;
							                System.err.println("Confirmação invalida. Por favor digite novamente.");
							                break;
							        }
							    }
							}
							//TODO adicionar telefone e vincular grupo
							new ContatoController().novoContato(nome1, sobreNnome, email);
					            break;
					        case "3":
					            entradaValida3 = true;
							ContatoView r3 = new ContatoView();
					            System.out.println("Qual contato você deseja deletar? ");
							System.out.println("Deseja consultar por:");
							
							System.out.println("1 - Nome");
							System.out.println("2 - Numero");
							
							boolean valido = false;
							while (!valido) {
							    System.out.print("Escolha: ");
							    String escolha = input.nextLine();
							    switch (escolha) {
							        case "1":
									System.out.print("\nNome: ");
									String nome = input.nextLine();
									
									ArrayList <Contato> result1 = new ContatoController().procurar(nome);
									if ( result1.size() < 1 ) {
									    System.out.println("Não foi encontrado nenhum contato com esse numero.");
									} else {
									    System.out.println("Deseja deletar o contato: ");
									    System.out.println(result1.get(0).toString());
									    System.out.println("S/N");
									    System.out.print("> ");
									    String escolha2 = input.nextLine();
									
									    boolean escolhaValida1 = false;
									    while (!escolhaValida1) {
									        switch (escolha2.toUpperCase()) {
									            case "S":
									                escolhaValida1 = true;
									                new ContatoController().remover(result1.get(0));
									                break;
									            case "N":
									                escolhaValida1 = true;
									                System.out.println("Cancelado.");
									                break;
									            default:
									                escolhaValida1 = false;
									                break;
									        }
									    }
									}
							            valido = true;
							            break;
							        case "2":
									System.out.print("\nNumero: ");
									String numero = input.nextLine();
									ArrayList <Contato> result = new ContatoController().procurarPorNumero(numero);
									if ( result.size() < 1 ) {
									    System.out.println("Não foi encontrado nenhum contato com esse numero.");
									} else {
									    System.out.println("Deseja deletar o contato: ");
									    System.out.println(result.get(0).toString());
									    System.out.println("S/N");
									    System.out.print("\n> ");
									    String escolha1 = input.nextLine();
									
									    boolean escolhaValida = false;
									    while (!escolhaValida) {
									        switch (escolha1.toUpperCase()) {
									            case "S":
									                escolhaValida = true;
									                new ContatoController().remover(result.get(0));
									                break;
									            case "N":
									                escolhaValida = true;
									                System.out.println("Cancelado.");
									                break;
									            default:
									                escolhaValida = false;
									                break;
									        }
									    }
									}
							            valido = true;
							            break;
							        default:
							            valido = false;
							            System.err.println("Modo de consulta invalido. Por favor escolha outro.");
							            break;
							    }
							}
					            break;
					        case "4":
					            entradaValida3 = true;
					            r2.alterar(input);
					            break;
					        case "0":
					            entradaValida3 = true;
					            break;
					        default:
					            entradaValida3 = false;
					            System.err.println("Ação invalida, por favor escolha novamente.");
					            break;
					    }
					}
		                break;
		            case "2":
		                entradaValida = true;
					TelefoneView r1 = new TelefoneView();
		                System.out.println();
					System.out.println("Escolha uma ação: ");
					
					System.out.println("1 - Consultar telefone.");
					System.out.println("2 - Adicionar telefone.");
					System.out.println("3 - Deletar telefone.");
					System.out.println("4 - Alterar telefone.");
					System.out.println("0 - Voltar.");
					
					boolean entradaValida2 = false;
					while (!entradaValida2){
					    System.out.print("Ação: ");
					    String entrada2 = input.nextLine();
					    switch (entrada2){
					        case "1":
					            entradaValida2 = true;
							System.out.println("Deseja consultar por:");
							
							System.out.println("1 - Numero.");
							System.out.println("2 - Contato.");
							System.out.println("3 - Grupo.");
							System.out.println("4 - Listar Todos.");
							System.out.println("0 - Voltar.");
							
							boolean valido = false;
							while (!valido) {
							    System.out.print("Escolha: ");
							    String escolha = input.nextLine();
							    switch (escolha) {
							        case "1":
							            valido = true;
									System.out.println("Qual numero você deseja consultar? ");
									System.out.print("Numero: ");
									String num = input.nextLine();
									
									ArrayList <Telefone> result = new TelefoneController().procurar(num);
									if (result.size() < 1) {
									    System.out.println("Nenhum telefone encontrado :c");
									} else {
									    System.out.println(":::::                   :::::");
									    result.forEach(telefone1 -> System.out.println(telefone1.toString()));
									    System.out.println(":::::                   :::::");
									}
							            break;
							        case "2":
							            valido = true;
									System.out.println("Qual contato você deseja consultar? ");
									System.out.print("Nome: ");
									String nome = input.nextLine();
									
									ArrayList <Telefone> result2 = new TelefoneController().procurarPorContato(nome);
									if (result2.size() < 1) {
									    System.out.println("Nenhum telefone encontrado :c");
									} else {
									    System.out.println(":::::                   :::::");
									    result2.forEach(telefone2 -> System.out.println(telefone2.toString()));
									    System.out.println(":::::                   :::::");
									}
							            break;
							        case "3":
							            valido = true;
									System.out.println("Qual grupo você deseja consultar? ");
									System.out.print("Descrição: ");
									String desc = input.nextLine();
									
									ArrayList <Telefone> result1 = new TelefoneController().procurarPorGrupo(desc);
									if (result1.size() < 1) {
									    System.out.println("Nenhum telefone encontrado :c");
									} else {
									    System.out.println(":::::                   :::::");
									    result1.forEach(telefone1 -> System.out.println(telefone1.toString()));
									    System.out.println(":::::                   :::::");
									}
							            break;
							        case "4":
							            valido = true;
									ArrayList <Telefone> result3 = new TelefoneController().procurar("");
									if (result3.size() < 1) {
									    System.out.println("Nenhum telefone encontrado :c");
									} else {
									    System.out.println(":::::                   :::::");
									    result3.forEach(telefone1 -> System.out.println(telefone1.toString()));
									    System.out.println(":::::                   :::::");
									}
							            break;
							        case "0":
							            valido = true;
							            break;
							        default:
							            valido = false;
							            System.err.println("Modo de consulta invalido. Por favor escolha outro.");
							            break;
							    }
							}
					            break;
					        case "2":
					            entradaValida2 = true;
							System.out.println("Você esta adicionando um novo telefone.");
							String telefone = "";
							
							boolean confirmado = false;
							while (!confirmado){
							    System.out.print("\nTelefone: ");
							    telefone = input.nextLine();
							
							    System.out.println("Você vai adicionar o telefone: " + telefone);
							
							    boolean confirmacaoValida = false;
							    while (!confirmacaoValida){
							        System.out.print("Confirmar? (S/N) ");
							        String confirmacao = input.nextLine();
							        switch (confirmacao.toUpperCase()){
							            case "S":
							                confirmado = true;
							                confirmacaoValida = true;
							                break;
							            case "N":
							                confirmado = false;
							                confirmacaoValida = true;
							                break;
							            default:
							                confirmacaoValida = false;
							                System.err.println("Confirmação invalida. Por favor digite novamente.");
							                break;
							        }
							    }
							}
							//TODO adicionar contatos ao criar
							new TelefoneController().novoTelefone(telefone);
					            break;
					        case "3":
					            entradaValida2 = true;
							ContatoView r3 = new ContatoView();
					            System.out.println("Qual contato você deseja deletar? ");
							System.out.println("Deseja consultar por:");
							
							System.out.println("1 - Nome");
							System.out.println("2 - Numero");
							
							boolean valido1 = false;
							while (!valido1) {
							    System.out.print("Escolha: ");
							    String escolha = input.nextLine();
							    switch (escolha) {
							        case "1":
									System.out.print("\nNome: ");
									String nome = input.nextLine();
									
									ArrayList <Contato> result1 = new ContatoController().procurar(nome);
									if ( result1.size() < 1 ) {
									    System.out.println("Não foi encontrado nenhum contato com esse numero.");
									} else {
									    System.out.println("Deseja deletar o contato: ");
									    System.out.println(result1.get(0).toString());
									    System.out.println("S/N");
									    System.out.print("> ");
									    String escolha2 = input.nextLine();
									
									    boolean escolhaValida1 = false;
									    while (!escolhaValida1) {
									        switch (escolha2.toUpperCase()) {
									            case "S":
									                escolhaValida1 = true;
									                new ContatoController().remover(result1.get(0));
									                break;
									            case "N":
									                escolhaValida1 = true;
									                System.out.println("Cancelado.");
									                break;
									            default:
									                escolhaValida1 = false;
									                break;
									        }
									    }
									}
							            valido1 = true;
							            break;
							        case "2":
									System.out.print("\nNumero: ");
									String numero = input.nextLine();
									ArrayList <Contato> result = new ContatoController().procurarPorNumero(numero);
									if ( result.size() < 1 ) {
									    System.out.println("Não foi encontrado nenhum contato com esse numero.");
									} else {
									    System.out.println("Deseja deletar o contato: ");
									    System.out.println(result.get(0).toString());
									    System.out.println("S/N");
									    System.out.print("\n> ");
									    String escolha1 = input.nextLine();
									
									    boolean escolhaValida = false;
									    while (!escolhaValida) {
									        switch (escolha1.toUpperCase()) {
									            case "S":
									                escolhaValida = true;
									                new ContatoController().remover(result.get(0));
									                break;
									            case "N":
									                escolhaValida = true;
									                System.out.println("Cancelado.");
									                break;
									            default:
									                escolhaValida = false;
									                break;
									        }
									    }
									}
							            valido1 = true;
							            break;
							        default:
							            valido1 = false;
							            System.err.println("Modo de consulta invalido. Por favor escolha outro.");
							            break;
							    }
							}
					            break;
					        case "4":
					            entradaValida2 = true;
					            r1.alterar(input);
					            break;
					        case "0":
					            entradaValida2 = true;
					            break;
					        default:
					            entradaValida2 = false;
					            System.err.println("Ação invalida, por favor escolha novamente.");
					            break;
					    }
					}
		                break;
		            case "3":
		                entradaValida = true;
					GrupoView r = new GrupoView();
		                System.out.println();
					System.out.println("Escolha uma ação: ");
					
					System.out.println("1 - Consultar grupo.");
					System.out.println("2 - Adicionar grupo.");
					System.out.println("3 - Deletar grupo.");
					System.out.println("4 - Alterar grupo.");
					System.out.println("0 - Voltar.");
					
					boolean entradaValida1 = false;
					while (!entradaValida1){
					    System.out.print("Ação: ");
					    String entrada1 = input.nextLine();
					    switch (entrada1){
					        case "1":
					            entradaValida1 = true;
							System.out.println("Deseja consultar por:");
							
							System.out.println("1 - Descrição.");
							System.out.println("2 - Contato.");
							System.out.println("3 - Telefone.");
							System.out.println("4 - Listar Todos.");
							System.out.println("0 - Voltar.");
							
							boolean valido = false;
							while (!valido) {
							    System.out.print("Escolha: ");
							    String escolha = input.nextLine();
							    switch (escolha) {
							        case "1":
							            valido = true;
							            r.consultarPorDescricao(input);
							            break;
							        case "2":
							            valido = true;
							            r.consultarPorContato(input);
							            break;
							        case "3":
							            valido = true;
									System.out.println("Qual numero você deseja consultar? ");
									System.out.print("Numero: ");
									String num = input.nextLine();
									
									ArrayList <Grupo> result1 = new GrupoController().procurarPorTelefone(num);
									if (result1.size() < 1) {
									    System.out.println("Nenhum grupo encontrado :c");
									} else {
									    System.out.println(":::::                   :::::");
									    result1.forEach(grupo1 -> System.out.println(grupo1.toString()));
									    System.out.println(":::::                   :::::");
									}
							            break;
							        case "4":
							            valido = true;
									ArrayList <Grupo> result = new GrupoController().procurar("");
									if (result.size() < 1) {
									    System.out.println("Nenhum grupo encontrado :c");
									} else {
									    System.out.println(":::::                   :::::");
									    result.forEach(grupo -> System.out.println(grupo.toString()));
									    System.out.println(":::::                   :::::");
									}
							            break;
							        case "0":
							            valido = true;
							            break;
							        default:
							            valido = false;
							            System.err.println("Modo de consulta invalido. Por favor escolha outro.");
							            break;
							    }
							}
					            break;
					        case "2":
					            entradaValida1 = true;
							System.out.println("Você esta adicionando um novo grupo.");
							String descricao = "";
							
							boolean confirmado = false;
							while (!confirmado){
							    System.out.print("\nDescrição: ");
							    descricao = input.nextLine();
							
							    System.out.println("Você vai adicionar o grupo: " + descricao);
							
							    boolean confirmacaoValida = false;
							    while (!confirmacaoValida){
							        System.out.print("Confirmar? (S/N) ");
							        String confirmacao = input.nextLine();
							        switch (confirmacao.toUpperCase()){
							            case "S":
							                confirmado = true;
							                confirmacaoValida = true;
							                break;
							            case "N":
							                confirmado = false;
							                confirmacaoValida = true;
							                break;
							            default:
							                confirmacaoValida = false;
							                System.err.println("Confirmação invalida. Por favor digite novamente.");
							                break;
							        }
							    }
							}
							//TODO adicionar contatos ao criar
							new GrupoController().novoGrupo(descricao);
					            break;
					        case "3":
					            entradaValida1 = true;
							ContatoView r3 = new ContatoView();
					            System.out.println("Qual contato você deseja deletar? ");
							System.out.println("Deseja consultar por:");
							
							System.out.println("1 - Nome");
							System.out.println("2 - Numero");
							
							boolean valido1 = false;
							while (!valido1) {
							    System.out.print("Escolha: ");
							    String escolha = input.nextLine();
							    switch (escolha) {
							        case "1":
									System.out.print("\nNome: ");
									String nome = input.nextLine();
									
									ArrayList <Contato> result1 = new ContatoController().procurar(nome);
									if ( result1.size() < 1 ) {
									    System.out.println("Não foi encontrado nenhum contato com esse numero.");
									} else {
									    System.out.println("Deseja deletar o contato: ");
									    System.out.println(result1.get(0).toString());
									    System.out.println("S/N");
									    System.out.print("> ");
									    String escolha2 = input.nextLine();
									
									    boolean escolhaValida1 = false;
									    while (!escolhaValida1) {
									        switch (escolha2.toUpperCase()) {
									            case "S":
									                escolhaValida1 = true;
									                new ContatoController().remover(result1.get(0));
									                break;
									            case "N":
									                escolhaValida1 = true;
									                System.out.println("Cancelado.");
									                break;
									            default:
									                escolhaValida1 = false;
									                break;
									        }
									    }
									}
							            valido1 = true;
							            break;
							        case "2":
									System.out.print("\nNumero: ");
									String numero = input.nextLine();
									ArrayList <Contato> result = new ContatoController().procurarPorNumero(numero);
									if ( result.size() < 1 ) {
									    System.out.println("Não foi encontrado nenhum contato com esse numero.");
									} else {
									    System.out.println("Deseja deletar o contato: ");
									    System.out.println(result.get(0).toString());
									    System.out.println("S/N");
									    System.out.print("\n> ");
									    String escolha1 = input.nextLine();
									
									    boolean escolhaValida = false;
									    while (!escolhaValida) {
									        switch (escolha1.toUpperCase()) {
									            case "S":
									                escolhaValida = true;
									                new ContatoController().remover(result.get(0));
									                break;
									            case "N":
									                escolhaValida = true;
									                System.out.println("Cancelado.");
									                break;
									            default:
									                escolhaValida = false;
									                break;
									        }
									    }
									}
							            valido1 = true;
							            break;
							        default:
							            valido1 = false;
							            System.err.println("Modo de consulta invalido. Por favor escolha outro.");
							            break;
							    }
							}
					            break;
					        case "4":
					            entradaValida1 = true;
					            r.alterar(input);
					            break;
					        case "0":
					            entradaValida1 = true;
					            break;
					        default:
					            entradaValida1 = false;
					            System.err.println("Ação invalida, por favor escolha novamente.");
					            break;
					    }
					}
		                break;
		            case "9":
		                entradaValida = true;
		                isFim = true;
		                break;
		            default:
		                entradaValida = false;
		                System.err.println("opcao invalida, por favor escolha novamente.");
		                break;
		        }
		    }
		}

        System.out.println("Volte sempre! :D");
    }
}