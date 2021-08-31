package recursos.MVC.controles;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import recursos.MVC.modelos.Contato;
import recursos.MVC.modelos.Grupo;
import recursos.MVC.modelos.Telefone;
import recursos.ORM.Coluna;
import recursos.ORM.Tabela;
import recursos.Persistencia;
import recursos.Populate;

import java.util.ArrayList;
import java.util.StringJoiner;

import static org.junit.jupiter.api.Assertions.*;

class TelefoneViewControllerTest {
    Persistencia db;

    @Test
    void novoTelefone() {
        Populate.trucateTelefones();

        // Re instancia a percistencia porcausa do truncamento dos dados
        this.db = new Persistencia();
        TelefoneController tCtrl = new TelefoneController(db);
        assert ( tCtrl.procurar("").size() == 0 );

        // TODO Fazer teste
    }

    @Test
    void adicionar() {
        Populate.trucateTelefones();

        // Re instancia a percistencia porcausa do truncamento dos dados
        this.db = new Persistencia();
        TelefoneController tCtrl = new TelefoneController(db);
        assert ( tCtrl.procurar("").size() == 0 );

        // TODO Fazer teste
    }

    @Test
    void remover() {
        // TODO Fazer teste
    }

    @Test
    void atualiza() {
        // TODO Fazer teste
    }


}