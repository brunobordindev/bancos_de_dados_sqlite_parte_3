package com.example.bancodedadossqlite3;

import androidx.appcompat.app.AppCompatActivity;

import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.os.Bundle;
import android.util.Log;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        try {

            //Criar bando de dados
            SQLiteDatabase bancoDados = openOrCreateDatabase("app", MODE_PRIVATE, null);

            //Criar uma tabela
            bancoDados.execSQL("CREATE TABLE IF NOT EXISTS pessoas (id INTEGER PRIMARY KEY AUTOINCREMENT, nome VARCHAR, idade INT(3))");

            //Atualiza tabela
//           bancoDados.execSQL("UPDATE  pessoas SET idade = 20, nome = 'Bruna Reche Silva' WHERE id= 1");

            //Apaga tabela
//            bancoDados.execSQL("DROP TABLE pessoas");

            //Deletar registro especificos
//            bancoDados.execSQL("DELETE FROM pessoas WHERE id = 1");

            //Inserir os registros
//            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Jamilton Dasmasceno', 35)");
//            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Bruno Rodrigues Bordin', 33)");
//            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Patricia Oliboni do Amaral', 18)");
//            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Pedro Mathias Gabral', 50)");
//            bancoDados.execSQL("INSERT INTO pessoas (nome, idade) VALUES ('Bruna', 40)");


            //Recuperar os registros da tabela
            /*
            OPCAO(1)
            String consulta = "SELECT nome, idade  FROM pessoas";

            // OPCAO(2) consulta somente o nome pesquisado
            String consulta = "SELECT nome, idade  " +
                            "FROM pessoas WHERE nome = 'Bruno Rodrigues Bordin'";

            // OPCAO(3) consulta o nome e idade da pessoa pesquisado (podendo utilizar mais AND)
            String consulta = "SELECT nome, idade FROM pessoas" +
                            " WHERE nome = 'Bruno Rodrigues Bordin' AND idade = '33'";

            // OPCAO(4) consulta somente pela idade
            String consulta = "SELECT nome, idade FROM pessoas" +
                    " WHERE idade >= 34 ";

            // OPCAO(5) consulta somente pela idade que voce deseja
            String consulta = "SELECT nome, idade FROM pessoas" +
                    " WHERE idade >= 34 OR idade = 18";

             // OPCAO(6) consulta somente pela idade DENTRO da idade desejada IN (significa dentro) posso colocar uma idade ou mais
            String consulta = "SELECT nome, idade FROM pessoas" +
                    " WHERE idade IN(18,33)";

            // OPCAO(7) consulta somente pelo nome DENTRO do nome desejado IN (significa dentro) posso colocar um nome ou mais
            String consulta = "SELECT nome, idade FROM pessoas" +
                    " WHERE nome IN('Bruno Rodrigues Bordin', 'Pedro Mathias Gabral' )";

            // OPCAO(8) consulta somente pela idade ENTRE da idade desejada BETWEEN (significado entre) posso colocar uma idade ou mais com o AND
            String consulta = "SELECT nome, idade FROM pessoas" +
                    " WHERE idade BETWEEN 18 AND 45";

 /          / OPCAO(9) consulta somente pela nome COMO do nome desejado LIKE (significa como) coloca uma letra ou o nome e depois % - B% pra todos nomes com B ou %una% pra todos que tenha esse no nome
            String consulta = "SELECT nome, idade FROM pessoas" +
                    " WHERE nome LIKE '%una%'";

            String filtro = "una";
            String consulta = "SELECT nome, idade FROM pessoas" +
                    " WHERE nome LIKE '%" + filtro + "%' ";

            // OPCAO(10) consulta por ordem de idade e o tipo crescende ASC (menor p/ maior) , descentente DESC (maior p/ menor)- ordenacao ORDER BY
            String consulta = "SELECT nome, idade FROM pessoas" +
                    " WHERE 1=1 ORDER BY idade DESC ";

            // OPCAO(11) consulta por ordem de idade com limite desejado e o tipo crescende ASC (menor p/ maior) , descentente DESC (maior p/ menor)- ordenacao ORDER BY
            String consulta = "SELECT nome, idade FROM pessoas" +
                    " WHERE 1=1 ORDER BY idade DESC LIMIT 4";

             // OPCAO(12) consulta por ordem de alfabtica nome e o tipo crescende ASC (A a Z) , descentente DESC (Z a A)- ordenacao ORDER BY LIMIT numero desejado.
            String consulta = "SELECT nome, idade FROM pessoas" +
                    " WHERE 1=1 ORDER BY nome ASC ";

            // OPCAO(13) consulta por ordem de alfabtica nome com limite desejado e o tipo crescende ASC (A a Z) , descentente DESC (Z a A)- ordenacao ORDER BY LIMIT numero desejado.
            String consulta = "SELECT nome, idade FROM pessoas" +
                    " WHERE 1=1 ORDER BY nome ASC LIMIT 2";

             */

            // OPCAO(11) consulta por ordem de alfabtica nome com limite desejado e o tipo crescende ASC (A a Z) , descentente DESC (Z a A)- ordenacao ORDER BY LIMIT numero desejado.
            String consulta = "SELECT * FROM pessoas" +
                    " WHERE 1=1";

            Cursor cursor = bancoDados.rawQuery(consulta, null);

            //Recuperar os indicices da tabela (as colunas do nome e idade)
            int indiceId = cursor.getColumnIndex("id");
            int indiceNome = cursor.getColumnIndex("nome");
            int indiceIdade = cursor.getColumnIndex("idade");

            //Iniciar cursor do zero
            cursor.moveToFirst();

            while (cursor != null){

                String id = cursor.getString(indiceId);
                String nome = cursor.getString(indiceNome);
                String idade = cursor.getString(indiceIdade);

                Log.i("RESULTADO - id ", id +" / nome: "+ nome + " / idade: " + idade);

                //fazer o cursor mover para o proximo registro
                cursor.moveToNext();
            }

        }catch (Exception e){
            e.printStackTrace();
        }
    }
}