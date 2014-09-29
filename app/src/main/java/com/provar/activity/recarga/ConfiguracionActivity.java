package com.provar.activity.recarga;

import android.app.Activity;
import android.os.Bundle;
import android.widget.TextView;

/**
 * Created by jose on 2/08/14.
 */
public class ConfiguracionActivity extends Activity {

    TextView tvUsario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        tvUsario = (TextView)findViewById(R.id.tvUsuario);
        Bundle bolsa = getIntent().getExtras();
        tvUsario.setText(bolsa.getString("nombreKey"));

    }
}
