package recursos.MVC.controles;

import recursos.MVC.modelos.Contato;
import recursos.ORM.Tabela;
import recursos.Persistencia;
import recursos.Persistencia.Utils;
import recursos.MVC.modelos.Telefone;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class TelefoneController {
    private Persistencia db;

    public TelefoneController(Persistencia db) {
        this.db = db;
    }

    public TelefoneController() {

    }

    public void novoTelefone(String telefone) {
        Telefone newTelefone = new Telefone(telefone);
        this.adicionar(newTelefone);
    }

    public void vincularContato(Contato contato) {

    }

    
    public void adicionar(Telefone telefone) {
        Persistencia r = this.db;
		String nomeTabela = Utils.relativeNomeClasse(telefone.getClass().getName()).toLowerCase();
		
		Tabela tabelaDoObjeto = r.tabelas.stream()
		    .filter(tb -> tb.getNome().equals(nomeTabela))
		    .findAny()
		    .orElse(null);
		
		if (tabelaDoObjeto != null) {
		    //tabelaDoObjeto.adicionarObjeto(objeto);
		} else {
		    System.err.println("Aviso em Tabela::salvarObjeto. Tabela desconhecida.");
		}
		
		List<Field> f = r.getAtributos(telefone);
		f.forEach(fi -> fi.setAccessible(true));
		
		ArrayList<String> colunas = new ArrayList<>();
		ArrayList<String> valores = new ArrayList<>();
		
		for (Field fi : f) {
		    String constraints = Utils.convertAnotation(fi.getAnnotations());
		    try {
		        String nomeColuna = fi.getName();
		        boolean isId = nomeColuna.startsWith("id_");
		        if (!isId) {
		            colunas.add(nomeColuna);
		            valores.add(String.valueOf(fi.get(telefone)));
		        }
		    } catch (IllegalAccessException e) {
		        e.printStackTrace();
		    }
		}
		
		r.genericInsert(nomeTabela, colunas, valores);
		r.carregaDados();
    }

    
    public void remover(Telefone telefone) {
        this.db.removerObjeto(telefone);
    }

    
    public void atualiza(Telefone telefone) {

    }

    
    public ArrayList<Telefone> procurar(String telefone) {
        this.db = new Persistencia();
        List<Tabela> tbs = this.db.getTabelaPorClasse(Telefone.class);
        ArrayList<Telefone> resultado = new ArrayList<>();

        if (tbs.size() == 1) {

            return resultado;

        } else if(tbs.size() > 1) {
            System.err.println("Aviso em TelefoneController::procurar. Foram encontradas mais de uma tabela com o mesmo nome.");
        } else {
            System.err.println("Aviso em TelefoneController::procurar. Tabela não encontrada;");
        }

        return resultado;
    }

    public Telefone procurarPorId(String id) {
        ArrayList<Telefone> todos = this.procurar("");

        return todos.stream()
                .filter(c ->  String.valueOf(c.getId_telefone()).equals(id) )
                .collect(Collectors.toList()).get(0);
    }

    public ArrayList<Telefone> procurarPorGrupo(String descricao) {
        ArrayList<Telefone> todos = this.procurar("");
        return todos.stream()
                .filter(telefone -> telefone.getContatos().stream()
                        .anyMatch(contato -> contato.getGrupos().stream()
                                                    .anyMatch(grupo -> grupo.comparaGrupo(descricao))))
                .collect(Collectors.toCollection(ArrayList<Telefone>::new));
    }

    public ArrayList<Telefone> procurarPorContato(String nome) {
        ArrayList<Telefone> todos = this.procurar("");
        return todos.stream()
                .filter(telefone -> telefone.getContatos().stream()
                        .anyMatch(contato -> contato.comparaNome(nome)))
                .collect(Collectors.toCollection(ArrayList<Telefone>::new));
    }
}
































