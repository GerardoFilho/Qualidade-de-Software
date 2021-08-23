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
        System.out.println("Qual descricao voce deseja consultar? \n" + "Descricao");

        ArrayList <Grupo> result = new GrupoController().procurar(consultaEx(inp));
        if (consultaSize(result) < 1) {
		    System.out.println("Nenhum grupo encontrado :c");
		} else {
		   // System.out.println(":::::                   :::::");
		    result.forEach(grupo -> System.out.println(grupo.toString()));
		   // System.out.println(":::::                   :::::");
		}
    }
    
    private String consultaEx(Scanner inp) {
		String desc = inp.nextLine();
		return desc;
    }
    private int consultaSize(ArrayList result) {
    	return result.size();
    }

    public void consultarPorContato(Scanner inp) {
        System.out.println("Qual contato voce deseja consultar? \n" + "Nome: ");
        

        ArrayList <Grupo> result = new GrupoController().procurarPorContato(consultaEx(inp));
        if (consultaSize(result) < 1) {
		    System.out.println("Nenhum grupo encontrado :c");
		} else {
		    //System.out.println(":::::                   :::::");
		    result.forEach(grupo -> System.out.println(grupo.toString()));
		    //System.out.println(":::::                   :::::");
		}
    }

}
