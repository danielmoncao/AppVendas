package com.Model;

import android.content.Context;
import android.database.Cursor;
import android.database.SQLException;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteStatement;
import android.util.Log;

//Classe que contem o espelho do banco de dados - classe mais importante do sistema
public class SqliteParametroDao {

    private Context ctx; //informa ao SQlite de onde estao vindo os dados
    private String sql; //variavel dos metodos do SQL
    private boolean gravacao; //atributo para gravar as alteracoes das tabelas

    public SqliteParametroDao(Context ctx) {
        this.ctx = ctx;
    }

    public boolean  gravar_parametro(SqliteParametroBean param) {
        SQLiteDatabase db = new Db(ctx).getWritableDatabase();
        gravacao = false;

        sql = "insert into PARAMETROS (" +
                "p_uso_codigo, " +
                "p_importar_cliente, " +
                "p_end_ip_local, " +
                "p_end_ip_remoto, " +
                "p_trabalhar_com_estoque_negativo, " +
                "p_desconto_do_vendedor ," +
                "p_usuario," +
                "p_senha )" +
                "values (?,?,?,?,?,?,?,?)";

        SQLiteStatement stmt = db.compileStatement(sql);

        try {
            stmt.bindLong(1, param.getP_uso_codigo());
            stmt.bindString(2, param.getP_importar_cliente());
            stmt.bindString(3, param.getP_end_ip_local());
            stmt.bindString(4, param.getP_end_ip_remoto());
            stmt.bindString(5, param.getP_trabalhar_com_estoque_negativo());
            stmt.bindLong(6, param.getP_desconto_do_vendedor());
            stmt.bindString(7, param.getP_usuario());
            stmt.bindString(8, param.getP_senha());

            if (stmt.executeInsert() > 0) {
                gravacao = true; //se o stmt for maior que zero houve uma gravacao na tabela
                sql = "";
            }

        } catch (SQLException e) {
            Log.d("Script", e.getMessage());
            gravacao = false;
        }

        return gravacao;
    }

    public SqliteParametroBean busca_parametros() {

        SQLiteDatabase db = new Db(ctx).getReadableDatabase();
        SqliteParametroBean parametro = null;

        sql = "select * from PARAMETROS";

        try {
            Cursor cursor = db.rawQuery(sql, null);

            //metodo de consulta
            //se o cursor mover para o proximo registro, é porque tem dados na tabela
            if (cursor.moveToFirst()) {

                parametro = new SqliteParametroBean(); //criacao do objeto

                parametro.setP_uso_codigo(cursor.getInt(cursor.getColumnIndex(parametro.P_CODIGO_USUARIO)));
                parametro.setP_importar_cliente(cursor.getString(cursor.getColumnIndex(parametro.P_IMPORTAR_CLIENTE)));
                parametro.setP_end_ip_local(cursor.getString(cursor.getColumnIndex(parametro.P_ENDERECO_IP_LOCAL)));
                parametro.setP_end_ip_remoto(cursor.getString(cursor.getColumnIndex(parametro.P_ENDERECO_IP_REMOTO)));
                parametro.setP_trabalhar_com_estoque_negativo(cursor.getString(cursor.getColumnIndex(parametro.P_ESTOQUE_NEGATIVO)));
                parametro.setP_desconto_do_vendedor(cursor.getInt(cursor.getColumnIndex(parametro.P_DESCONTO_VENDEDORR)));
                parametro.setP_usuario(cursor.getString(cursor.getColumnIndex(parametro.P_USUARIO)));
                parametro.setP_senha(cursor.getString(cursor.getColumnIndex(parametro.P_SENHA)));
            }

        } catch (SQLException e) {
            Log.d("Script", e.getMessage());
        } finally {
            db.close();

        }

        return parametro;
    }

    //metodo de atualizacao tabela
    public void atualizaparametro(SqliteParametroBean param) {
        SQLiteDatabase db = new Db(ctx).getWritableDatabase();
        sql = "update PARAMETROS set p_uso_codigo=?, " +
                "p_importar_cliente=?, " +
                "p_end_ip_local=?, " +
                "p_end_ip_remoto=?, " +
                "p_trabalhar_com_estoque_negativo=?, " +
                "p_desconto_do_vendedor=? ";
        SQLiteStatement stmt = db.compileStatement(sql);

        try {
            stmt.bindLong(1, param.getP_uso_codigo());
            stmt.bindString(2, param.getP_importar_cliente());
            stmt.bindString(3, param.getP_end_ip_local());
            stmt.bindString(4, param.getP_end_ip_remoto());
            stmt.bindString(5, param.getP_trabalhar_com_estoque_negativo());
            stmt.bindLong(6, param.getP_desconto_do_vendedor());


            stmt.executeUpdateDelete();
            stmt.clearBindings();

        } catch (SQLException e) {
            Log.d("Script", e.getMessage());
        } finally {
            db.close();
            stmt.close();
        }
    }
}
