package recursos;

import recursos.MVC.controles.ContatoController;
import recursos.MVC.controles.GrupoController;
import recursos.MVC.controles.TelefoneController;
import recursos.MVC.modelos.Contato;
import recursos.MVC.modelos.Grupo;
import recursos.MVC.modelos.Telefone;
import recursos.ORM.Coluna;
import recursos.ORM.Tabela;

import java.util.ArrayList;
import java.util.StringJoiner;

public class Populate {

    /**
     * Metodo para popular a tabela de Contatos com alguns dados de exemplo.
     * @param db Instancia de persistencia.
     */
    public static void populateContatos(Persistencia db) {
        ContatoController contControl = new ContatoController(db);
        contControl.novoContato("Jose", "Silva", "jose.silva@gmail.com");
        contControl.novoContato("Maria", "Antonia", "maria_antonia@gmail.com");
        contControl.novoContato("Roberto", "Souza", "robert-souza@gmail.com");
    }

    /**
     * Metodo para popular a tabela de Telefones com alguns dados de exemplo.
     * @param db Instancia de persistencia.
     */
    public static void populateTelefones (Persistencia db) {
        TelefoneController telefControl = new TelefoneController(db);

        telefControl.novoTelefone("99999-9999");
        telefControl.novoTelefone("88888-8888");
        telefControl.novoTelefone("77777-7777");
        telefControl.novoTelefone("66666-6666");
        telefControl.novoTelefone("55555-5555");
    }

    /**
     * Metodo para popular a tabela de Grupos com alguns dados de exemplo.
     * @param db Instancia de persistencia.
     */
    public static void populateGrupos (Persistencia db) {
        GrupoController grupControl = new GrupoController(db);
        grupControl.novoGrupo("Familia");
        grupControl.novoGrupo("Escola");
        grupControl.novoGrupo("Trabalho");
        grupControl.novoGrupo("RPG");
        grupControl.novoGrupo("Teatro");
    }

    /**
     * Metodo somente para desenvolvimento.
     */
    public static void trucateGrupos() {
        Persistencia.truncarTabelaPorClasse(Grupo.class);
    }

    /**
     * Metodo somente para desenvolvimento.
     */
    public static void trucateContatos() {
        Persistencia.truncarTabelaPorClasse(Contato.class);
    }

    /**
     * Metodo somente para desenvolvimento.
     */
    public static void trucateTelefones() {
        Persistencia.truncarTabelaPorClasse(Telefone.class);
    }
}
