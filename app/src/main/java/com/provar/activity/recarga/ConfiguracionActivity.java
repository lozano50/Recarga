package com.provar.activity.recarga;

import android.app.Activity;
import android.app.AlertDialog;
import android.app.Dialog;
import android.content.DialogInterface;
import android.content.Intent;
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
    Button configurarTerminal;
    Button configurarGprs;

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

        //capturamos el layout
        View capa = this.getLayoutInflater().inflate(R.layout.validar_usuario, null);

        //capturamos la imagen y el campo de texto desde nuestro layout personalizado.
        tvUsario = (EditText) capa.findViewById(R.id.password);

        AlertDialog.Builder miDialogo = new AlertDialog.Builder(this);
        miDialogo.setMessage("Ingresa Codigo");

        //asignamos la vista creada a nuestro diálogo.
        miDialogo.setView(capa);

        //establecemos la instrucción en caso afirmativo
        miDialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {

                String nombre = tvUsario.getText().toString();
                // Log.println(BIND_WAIVE_PRIORITY, et1.getText().toString(), et1.getText().toString());

                //  getTextViewResult().setText(nombre);

                if ( !nombre.equals(Constantes.PASS_CONFIG) ) {
                    Toast.makeText(getApplicationContext(), " CLAVE INCORRECTA ", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intentUno = new Intent("com.provar.jose.facturacion.ConfiguracionActivity");
                Bundle bolsa = new Bundle();
                bolsa.putString("nombreKey",nombre);
                intentUno.putExtras(bolsa);
                startActivity(intentUno);


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

        tvUsario.setText("prueba 1");



    }
}
