package recursos.MVC.views;

import recursos.MVC.controles.GrupoController;
import recursos.MVC.modelos.Grupo;

import java.util.ArrayList;
import java.util.Scanner;

public class GrupoView{

    
    public void alterar(Scanner input) {
        //TODO Fazer metodo Alterar grupo
    }

    
    public void consultarPorDescricao(Scanner inp) {
        System.out.println("Qual descrição você deseja consultar? ");
        System.out.print("Descrição: ");
        String desc = inp.nextLine();

        ArrayList <Grupo> result = new GrupoController().procurar(desc);
        if (result.size() < 1) {
		    System.out.println("Nenhum grupo encontrado :c");
		} else {
		    System.out.println(":::::                   :::::");
		    result.forEach(grupo -> System.out.println(grupo.toString()));
		    System.out.println(":::::                   :::::");
		}
    }

    public void consultarPorContato(Scanner inp) {
        System.out.println("Qual contato você deseja consultar? ");
        System.out.print("Nome: ");
        String nome = inp.nextLine();

        ArrayList <Grupo> result = new GrupoController().procurarPorContato(nome);
        if (result.size() < 1) {
		    System.out.println("Nenhum grupo encontrado :c");
		} else {
		    System.out.println(":::::                   :::::");
		    result.forEach(grupo -> System.out.println(grupo.toString()));
		    System.out.println(":::::                   :::::");
		}
    }

}
