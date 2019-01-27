package com.Model;

// classe usada pra o transporte de dados tambem chamado de POJO no java
public class SqliteParametroBean {

    public static final String P_CODIGO_USUARIO = "p_uso_codigo";
    public static final String P_IMPORTAR_CLIENTE = "p_importar_cliente";
    public static final String P_ENDERECO_IP_LOCAL = "p_end_ip_local";
    public static final String P_ENDERECO_IP_REMOTO = "p_end_ip_remoto";
    public static final String P_ESTOQUE_NEGATIVO = "p_trabalhar_com_estoque_negativo";
    public static final String P_DESCONTO_VENDEDORR = "p_desconto_do_vendedor";
    public static final String P_USUARIO = "p_usuario";
    public static final String P_SENHA = "p_senha";

    private Integer p_uso_codigo;
    private String p_importar_cliente;
    private String p_end_ip_local;
    private String p_end_ip_remoto;
    private String p_trabalhar_com_estoque_negativo;
    private Integer p_desconto_do_vendedor;
    private String p_senha;
    private String p_usuario;

    public Integer getP_uso_codigo() {
        return p_uso_codigo;
    }

    public void setP_uso_codigo(Integer p_uso_codigo) {
        this.p_uso_codigo = p_uso_codigo;
    }

    public String getP_importar_cliente() {
        return p_importar_cliente;
    }

    public void setP_importar_cliente(String p_importar_cliente) {
        this.p_importar_cliente = p_importar_cliente;
    }

    public String getP_end_ip_local() {
        return p_end_ip_local;
    }

    public void setP_end_ip_local(String p_end_ip_local) {
        this.p_end_ip_local = p_end_ip_local;
    }

    public String getP_end_ip_remoto() {
        return p_end_ip_remoto;
    }

    public void setP_end_ip_remoto(String p_end_ip_remoto) {
        this.p_end_ip_remoto = p_end_ip_remoto;
    }

    public String getP_trabalhar_com_estoque_negativo() {
        return p_trabalhar_com_estoque_negativo;
    }

    public void setP_trabalhar_com_estoque_negativo(String p_trabalhar_com_estoque_negativo) {
        this.p_trabalhar_com_estoque_negativo = p_trabalhar_com_estoque_negativo;
    }

    public Integer getP_desconto_do_vendedor() {
        return p_desconto_do_vendedor;
    }

    public void setP_desconto_do_vendedor(Integer p_desconto_do_vendedor) {
        this.p_desconto_do_vendedor = p_desconto_do_vendedor;
    }

    public String getP_usuario() {
        return p_usuario;
    }

    public void setP_usuario(String p_usuario) {
        this.p_usuario = p_usuario;
    }

    public String getP_senha() {
        return p_senha;
    }

    public void setP_senha(String p_senha) {
        this.p_senha = p_senha;
    }
}
