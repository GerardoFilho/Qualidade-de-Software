package recursos.MVC.controles;

import recursos.MVC.modelos.Contato;
import recursos.ORM.Tabela;
import recursos.Persistencia;
import recursos.Persistencia.Utils;
import recursos.MVC.modelos.Grupo;

import java.lang.reflect.Field;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class GrupoController{
    private Persistencia db;

    public GrupoController(Persistencia db) {
        this.db = db;
    }

    public GrupoController() {
    }

    public void novoGrupo(String descricao) {
        Grupo newGrupo = new Grupo(descricao);
        this.adicionar(newGrupo);
    }

    public void vincularContato(Contato contato) {

    }


    public void adicionar(Grupo grupo) {
        Persistencia r = this.db;
		String nomeTabela = Utils.relativeNomeClasse(grupo.getClass().getName()).toLowerCase();
		
		Tabela tabelaDoObjeto = r.tabelas.stream()
		    .filter(tb -> tb.getNome().equals(nomeTabela))
		    .findAny()
		    .orElse(null);
		
		if (tabelaDoObjeto != null) {
		    //tabelaDoObjeto.adicionarObjeto(objeto);
		} else {
		    System.err.println("Aviso em Tabela::salvarObjeto. Tabela desconhecida.");
		}
		
		List<Field> f = r.getAtributos(grupo);
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
		            valores.add(String.valueOf(fi.get(grupo)));
		        }
		    } catch (IllegalAccessException e) {
		        e.printStackTrace();
		    }
		}
		
		r.genericInsert(nomeTabela, colunas, valores);
		r.carregaDados();
    }


    public void remover(Grupo grupo) {
        this.db.removerObjeto(grupo);
    }


    public void atualiza(Grupo grupo) {

    }

    
    public ArrayList<Grupo> procurar(String descricao) {
        this.db = new Persistencia();
        List<Tabela> tbs = this.db.getTabelaPorClasse(Grupo.class);
        ArrayList<Grupo> resultado = new ArrayList<>();

        if (tbs.size() == 1) {
            Tabela tb = tbs.get(0);
            ArrayList<Object> linhas = tb.getLinhas()
                    .stream()
                    .filter( linha -> ( (Grupo) linha).comparaGrupo(descricao) )
                    .collect(Collectors
                            .toCollection(ArrayList::new));

            linhas.forEach(o -> resultado.add((Grupo) o));

            return resultado;

        } else if(tbs.size() > 1) {
            System.err.println("Aviso em GrupoController::procurar. Foram encontradas mais de uma tabela com o mesmo nome.");
        } else {
            System.err.println("Aviso em GrupoController::procurar. Tabela não encontrada;");
        }

        return resultado;
    }

    public Grupo procurarPorId(String id) {
        ArrayList<Grupo> todos = this.procurar("");

        return todos.stream()
                .filter(c ->  String.valueOf(c.getId_grupo()).equals(id) )
                .collect(Collectors.toList()).get(0);
    }

    public ArrayList<Grupo> procurarPorTelefone(String numero) {
        ArrayList<Grupo> todos = this.procurar("");
        List<Grupo> result = todos.stream()
                .filter(grupo -> grupo.getContatos().stream()
                        .anyMatch(contato -> contato.getTelefones().stream()
                                    .anyMatch(telefone -> telefone.comparaTelefone(numero))))
                .collect(Collectors.toList());

        return new ArrayList<>(result);
    }

    public ArrayList<Grupo> procurarPorContato(String nome) {
        ArrayList<Grupo> todos = this.procurar("");
        List<Grupo> result = todos.stream()
                .filter(grupo -> grupo.getContatos().stream()
                        .anyMatch(contato -> contato.comparaNome(nome)))
                .collect(Collectors.toList());

        return new ArrayList<>(result);
    }
}
