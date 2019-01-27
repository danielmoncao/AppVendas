package com.Model;

import android.content.Context;
import android.database.sqlite.SQLiteDatabase;
import android.database.sqlite.SQLiteOpenHelper;

public class Db extends SQLiteOpenHelper {

    public static String Dbname = "vendas.db";
    public static int versao = 1;

    public Db(Context ctx) {
        super(ctx, Dbname, null, versao);
    }

    private static String SQL_CLIENTE = "CREATE TABLE [CLIENTES](" +
            "cli_codigo INTERGER," +
            "cli_nome VARCHAR DEFAULT 50," +
            "cli_fantasia VARCHAR DEFAULT 50," +
            "cli_endereco VARCHAR DEFAULT 50," +
            "uso_codigo VARCHAR DEFAULT 50," +
            "cli_bairro CHAR DEFAULT 50," +
            "cli_cep CHAR DEFAULT 50," +
            "cid_codigo INTEGER," +
            "cli_contato VARCHAR DEFAULT 20," +
            "cli_nascimemnto VARCHAR DEFAULT 13," +
            "cli_cpfcnpj VARCHAR DEFAULT 25," +
            "cli_rginscricaoest VARCHAR DEFAULT 40," +
            "cli_email VARCHAR DEFAULT 50," +
            "cli_enviado CHAR DEFAULT 1," +
            "cli_chave VARCHAR DEFAULT 100)";

    private static String SQL_PRODUTOS = "CREATE TABLE [PRODUTOS] (  " +
            "prod_codigo INTEGER,  " +
            "prod_EAN13 VARCHAR DEFAULT 15,  " +
            "prod_descricao VARCHAR DEFAULT 50,   " +
            "prod_unmedida VARCHAR DEFAULT 10,   " +
            "prod_custo DECIMAL(10, 2),   " +
            "prod_quantidade DECIMAL(10, 2),   " +
            "prod_preco DECIMAL(10, 2),   " +
            "prod_categoria VARCHAR DEFAULT 30)";

    //tabela VENDA_C - Cabeçalho da venda
    private static String SQL_VENDA_C = "CREATE TABLE [VENDAC] ( " +
            "vendac_id INTEGER PRIMARY KEY AUTOINCREMENT,  " +
            "vendac_chave VARCHAR DEFAULT 70, " +
            "vendac_datahoravenda  DATETIME,  " +
            "vendac_previsaoentrega DATE, " +
            "vendac_cli_codigo INTEGER, " +
            " vendac_cli_nome VARCHAR DEFAULT 50, " +
            "vendac_uso_codigo INTEGER,  " +
            "vendac_uso_nome VARCHAR DEFAULT 50,  " +
            "vendac_formapgto VARCHAR DEFAULT 50,  " +
            "vendac_valor DECIMAL (10, 2),  " +
            "vendac_desconto DECIMAL (10, 2),  " +
            "vendac_pesototal DECIMAL (10, 2),  " +
            "vendac_enviada CHAR DEFAULT 1, " +
            "vendac_latitude DOUBLE, " +
            "vendac_longitude DOUBLE)";

    //tabela VENDA_D - descricao da venda
    private static String SQL_VENDA_D = "CREATE TABLE [VENDAD] (" +
            "vendac_chave VARCHAR DEFAULT 70," +
            "vendad_nro_item INTEGER," +
            "vendad_ean VARCHAR DEFAULT 50," +
            "vendad_prod_codigo INTEGER," +
            "vendad_prod_descricao VARCHAR DEFAULT 50," +
            "vendad_quantidade DECIMAL (10, 2)," +
            "vendad_preco_venda DECIMAL (10, 2)," +
            "vendad_total DECIMAL (10, 2))";

    //tabela VENDA_D_TEMP - tabela temporaria para armazenar itens de venda para depois passar para SQL_VENDA_D
    private static String SQL_VENDA_D_TEMP = "CREATE TABLE [VENDAD_TEMP] ( " +
            "vendad_ean VARCHAR DEFAULT 50, " +
            "vendad_prod_codigo INTEGER, " +
            "vendad_prod_descricao VARCHAR DEFAULT 50, " +
            "vendad_quantidade DECIMAL (10, 2), " +
            "vendad_preco_venda DECIMAL (10, 2), " +
            "vendad_total DECIMAL (10, 2))";

    // tabela CHEQUE - tabela que vai armazenar os dados do cheque que foi dado na venda
    private static String SQL_CHEQUE = "CREATE TABLE [CHEQUES] ( " +
            "ch_codigo INTEGER PRIMARY KEY AUTOINCREMENT, " +
            "ch_cli_codigo INTEGER, " +
            "ch_numero_cheque VARCHAR DEFAULT 20, " +
            "ch_contato VARCHAR DEFAULT 20, " +
            "ch_cpf_dono VARCHAR DEFAULT 50, " +
            "ch_nome_dono VARCHAR DEFAULT 50, " +
            "ch_nome_banco VARCHAR DEFAULT 50, " +
            "ch_vencimento DATE, " +
            "ch_valor_cheque DECIMAL (10, 2), " +
            "ch_terceiro CHAR DEFAULT 1, " +
            "vendac_chave VARCHAR DEFAULT 70, " +
            "ch_enviado VARCHAR DEFAULT 1, " +
            "ch_data_cadastro DATE)";

    private static String SQL_RECEBER = "CREATE TABLE [CONREC] ( " +
            "ec_codigo INTEGER, " +
            "rec_numeroparcela INTEGER, " +
            "rec_cli_codigo INTEGER, " +
            "rec_cli_nome VARCHAR DEFAULT 50, " +
            "vendac_chave VARCHAR DEFAULT 70, " +
            "rec_datamovimento DATE, " +
            "rec_valorareceber DECIMAL (10, 2), " +
            "rec_datavencimento DATE, " +
            "rec_data_que_pagou DATE, " +
            "rec_recebeu_com VARCHAR DEFAULT 20, " +
            "rec_enviado CHAR DEFAULT 1)";

    private static String SQL_CONFPAGAMENTO = "CREATE TABLE [CONFPAGAMEMNTO] ( " +
            "conf_codigo INTEGER, " +
            "conf_sementrada_comentrada CHAR DEFAULT 1, " +
            "conf_tipo_pagamento VARCHAR DEFAULT 20, " +
            "conf_recebeucom_din_chq_cart VARCHAR DEFAULT 20, " +
            "conf_valor_recebido DECIMAL(10,2), " +
            "conf_parcelas INTERGER, " +
            "vendac_chave VARCHAR DEFAULT 70, " +
            "conf_enviado CHAR DEFAULT 1)";

    private static String SQL_HISTORICO_PAGAMENTO = "CREATE TABLE [HISTPAGAMENTO] ( " +
            "hist_codigo INTEGER, " +
            "hist_numero_parcela INTEGER, " +
            "hist_valor_real_parcela DECIMAL (10, 2), " +
            "hist_valor_pago_no_dia DECIMAL (10, 2), " +
            "hist_restante_a_pagar DECIMAL (10, 2), " +
            "hist_data_do_pagamento DATE, " +
            "hist_nome_cliente VARCHAR DEFAULT 30, " +
            "hist_como_pagou VARCHAR DEFAULT 20, " +
            "vendac_chave VARCHAR DEFAULT 70, " +
            "hist_enviado CHAR DEFAULT 1)";


    private static String SQL_PARAMETROS = "CREATE TABLE [PARAMETROS] (  " +
            "p_uso_codigo INTEGER, " +
            "p_importar_cliente VARCHAR DEFAULT 20, " +
            "p_usuario VARCHAR DEFAULT 20, " +
            "p_senha VARCHAR DEFAULT 20, " +
            "p_end_ip_local VARCHAR DEFAULT 50, " +
            "p_end_ip_remoto VARCHAR DEFAULT 50, " +
            "p_trabalhar_com_estoque_negativo CHAR DEFAULT 1, " +
            "p_desconto_do_vendedor INTEGER)";

    @Override
    public void onCreate(SQLiteDatabase db) {

        db.execSQL(SQL_CLIENTE);
        db.execSQL(SQL_PRODUTOS);
        db.execSQL(SQL_VENDA_C);
        db.execSQL(SQL_VENDA_D);
        db.execSQL(SQL_VENDA_D_TEMP);
        db.execSQL(SQL_CHEQUE);
        db.execSQL(SQL_RECEBER);
        db.execSQL(SQL_CONFPAGAMENTO);
        db.execSQL(SQL_HISTORICO_PAGAMENTO);
        db.execSQL(SQL_PARAMETROS);
    }

    @Override
    public void onUpgrade(SQLiteDatabase db, int VersaoAntiga, int VersaoNova) {

    }

}
