package com.applicando.cursoappvendas;

import android.app.Activity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;

import com.Model.SqliteParametroBean;
import com.Model.SqliteParametroDao;

public class Principal extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.principal);
    }

    public void chamarParametro(View v) {

        SqliteParametroBean parBean = new SqliteParametroBean();
        SqliteParametroDao parDao = new SqliteParametroDao(getBaseContext());


        parBean = parDao.busca_parametros();

        Log.d("usuário", parBean.getP_uso_codigo().toString());
        Log.d("IP local", parBean.getP_end_ip_local());
        Log.d("IP remoto", parBean.getP_end_ip_remoto());
        Log.d("importar cliente", parBean.getP_importar_cliente());
        Log.d("estoque negativo", parBean.getP_trabalhar_com_estoque_negativo());
        Log.d("descontão", parBean.getP_desconto_do_vendedor().toString());



        //parBean.setP_uso_codigo(3);
        //parBean.setP_importar_cliente("BruceWayne");
        //parBean.setP_desconto_do_vendedor(100);
        //parBean.setP_trabalhar_com_estoque_negativo("N");
        //parBean.setP_end_ip_local("Batman");
        //parBean.setP_end_ip_remoto("WOW");

        //parDao.gravar_parametro(parBean);




        //Intent Parametro = new Intent(getBaseContext(), Parametro.class);
        //startActivity(Parametro);

    }
}
