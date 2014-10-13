package com.provar.activity.recarga;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;


import com.provar.activity.recarga.utils.Constantes;

/**
 * Created by jose on 2/08/14.
 */
public class ConfiguracionActivity extends ActionBarActivity implements View.OnClickListener {

    TextView tvUsario;
    private Button configurarTerminal;
    private Button configurarGprs;
    private TextView codigoTerminal;
    private TextView codigoEntidad;
    private SharedPreferences preferencias;
    /**
     *
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_configuracion);

        tvUsario = (TextView)findViewById(R.id.tvUsuario);
        //Bundle bolsa = getIntent().getExtras();
        //tvUsario.setText(bolsa.getString("nombreKey"));

        configurarTerminal = (Button)findViewById(R.id.idConfTerminal);
        configurarGprs     = (Button)findViewById(R.id.idConfGprs);

    }

    /*
    @Override
    public void onClick(View v) {

        System.out.println(" CLASE CONFIGURACION ... " + v.getId());
        System.out.println(" CLASE CONFIGURACION ... " + R.id.idConfTerminal);
        System.out.println(" CLASE CONFIGURACION ... " + R.id.idConfGprs);

        switch(v.getId()){

            case R.id.idConfTerminal:

                ValidarUsuario_();

                break;
            case R.id.idConfGprs:

                /*Dialog dialog1 = new Dialog(this);
                dialog1.setTitle("CONFIGURAR TERMINAL");
                dialog1.setContentView(R.layout.parametros_terminal);

                dialog1.show();* /


                Toast toast = Toast.makeText(this, "Evento informe", Toast.LENGTH_SHORT );
                toast.show();


                final CharSequence[] items = {"Red", "Green", "Blue"};

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Exit!")
                        .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int item) {
                                Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
                            }
                        });

                builder.create().show();

                break;
        }
    }*/

    /**
     *
     */
    public void ValidarUsuario_() {

        preferencias = getSharedPreferences(Constantes.PREFERENCIA_APP, 0);

        //capturamos el layout
        String codTerminal = null;
        String codEntidad  = null;

        View capa = this.getLayoutInflater().inflate(R.layout.parametros_terminal, null);

        codigoTerminal = (EditText)capa.findViewById(R.id.idTerminal);
        codigoEntidad  = (EditText)capa.findViewById(R.id.idEntidad);

        codTerminal = preferencias.getString(Constantes.COD_TERMINAL,"00000000");
        codEntidad  = preferencias.getString(Constantes.COD_ENTIDAD,"000010101000000");

        codigoTerminal.setText(codTerminal);
        codigoEntidad.setText(codEntidad);

        AlertDialog.Builder miDialogo = new AlertDialog.Builder(this);
        miDialogo.setMessage("CONFIGURAR TERMINAL");

        //asignamos la vista creada a nuestro diálogo.
        miDialogo.setView(capa);

        //establecemos la instrucción en caso afirmativo
        miDialogo.setPositiveButton("GUARDAR", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which)
            {

                SharedPreferences.Editor editor = preferencias.edit();
                editor.putString(Constantes.COD_TERMINAL, codigoTerminal.getText().toString());
                editor.putString(Constantes.COD_ENTIDAD,  codigoEntidad.getText().toString());

                editor.commit();

                Toast.makeText(getApplicationContext(), " DATOS ALMACENADOS ", Toast.LENGTH_SHORT).show();

            }
        });

        //se crea y luego se muestra...
        miDialogo.create();
        miDialogo.show();

    }

    public Button getConfigurarGprs() {
        return configurarGprs;
    }

    public void setConfigurarGprs(Button configurarGprs) {
        this.configurarGprs = configurarGprs;
    }

    public Button getConfigurarTerminal() {
        return configurarTerminal;
    }

    public void setConfigurarTerminal(Button configurarTerminal) {
        this.configurarTerminal = configurarTerminal;
    }


    @Override
    public void onClick(View view) {

        System.out.println(" CLASE CONFIGURACION ... " + view.getId());
        System.out.println(" CLASE CONFIGURACION ... " + R.id.idConfTerminal);
        System.out.println(" CLASE CONFIGURACION ... " + R.id.idConfGprs);

        switch(view.getId()){

            case R.id.idConfTerminal:

                ValidarUsuario_();

                break;
            case R.id.idConfGprs:

                /*Dialog dialog1 = new Dialog(this);
                dialog1.setTitle("CONFIGURAR TERMINAL");
                dialog1.setContentView(R.layout.parametros_terminal);

                dialog1.show();*/


                Toast toast = Toast.makeText(this, "Evento informe", Toast.LENGTH_SHORT );
                toast.show();


                final CharSequence[] items = {"Red", "Green", "Blue"};

                AlertDialog.Builder builder = new AlertDialog.Builder(this);
                builder.setTitle("Exit!")
                        .setSingleChoiceItems(items, 1, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialogInterface, int item) {
                                Toast.makeText(getApplicationContext(), items[item], Toast.LENGTH_SHORT).show();
                            }
                        });

                builder.create().show();

                break;
        }
    }

    public TextView getCodigoTerminal() {
        return codigoTerminal;
    }

    public void setCodigoTerminal(EditText codigoTerminal) {
        this.codigoTerminal = codigoTerminal;
    }

    public TextView getCodigoEntidad() {
        return codigoEntidad;
    }

    public void setCodigoEntidad(EditText codigoEntidad) {
        this.codigoEntidad = codigoEntidad;
    }

}
