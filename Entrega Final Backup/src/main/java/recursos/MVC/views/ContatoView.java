package recursos.MVC.views;

import recursos.MVC.controles.ContatoController;
import recursos.MVC.modelos.Contato;

import java.util.ArrayList;
import java.util.Scanner;

public class ContatoView{


    public void alterar(Scanner input) {
        //TODO Fazer metodo Alterar contato
    }


    public void consultar(Scanner inp) {
        System.out.println("Deseja consultar por:\n" + "1 - Nome\n" + "2 - Numero\n" + "3 - Grupo\n" + "4 - Listar todos\n" + "0 - Voltar. \n" + "Escolha:");

        boolean valido = false;
        while (!valido) {
            String escolha = inp.nextLine();
            switch (escolha) {
                case "1":
                    valido = true;
                    consultaNome(inp);
                    break;
                case "2":
                    valido = true;
                    consultaNumero(inp);
                    break;
                case "3":
                    valido = true;
                    consultaPorGrupo(inp);
                    break;
                case "4":
                    valido = true;
                    listarTodos();
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
    }


    public void listarTodos() {
        ArrayList<Contato> result = new ContatoController().procurar("");
        printarResultado(result);
    }


    public void printarResultado(ArrayList<Contato> result) {
        if (result.size() < 1) {
            System.out.println("Nenhum contato encontrado :c");
        } else {
            //System.out.println(":::::                   :::::");
            result.forEach(contato -> System.out.println(contato.toString()));
            //System.out.println(":::::                   :::::");
        }
    }

    private void consultaNome(Scanner inp) {
        System.out.println("Qual nome você deseja consultar? ");
        System.out.print("Nome: ");
        String nomeConsulta = inp.nextLine();

        ArrayList <Contato> result = new ContatoController().procurar(nomeConsulta);
        printarResultado(result);
    }

    private void consultaNumero(Scanner inp) {
        System.out.println("Qual numero você deseja consultar? ");
        System.out.print("Numero: ");
        String numeroConsulta = inp.nextLine();

        ArrayList <Contato> result = new ContatoController().procurarPorNumero(numeroConsulta);
        printarResultado(result);
    }

    private void consultaPorGrupo(Scanner inp) {
        System.out.println("Qual grupo você deseja consultar? ");
        System.out.print("Descrição: ");
        String desc = inp.nextLine();

        ArrayList <Contato> result = new ContatoController().procurarPorGrupo(desc);
        printarResultado(result);
    }

}