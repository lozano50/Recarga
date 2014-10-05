package com.provar.activity.recarga;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.provar.activity.recarga.utils.Constantes;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;


public class Activity_main extends ActionBarActivity implements View.OnClickListener{


    private Button   recargas;
    private Button   configuracion;
    private Button   informes;
    private TextView et1;
    private TextView textViewResult;


    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recargas       = (Button)findViewById(R.id.recarga);
        configuracion  = (Button)findViewById(R.id.configuracion);
        informes       = (Button)findViewById(R.id.informe);

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }


    @Override
    public void onClick(View view) {


        switch (view.getId()) {

            case R.id.recarga:

                //textViewResult.setText(" Recarga ");

                // CREACION DEL ARCHIVO Y ESCRITURA
                try {

                    OutputStreamWriter OSW = new OutputStreamWriter(openFileOutput("pruebas.DAT", 0));
                    OSW.write("TEXTO PRUEBA");
                    OSW.flush();
                    OSW.close();

                } catch (FileNotFoundException e) {
                    Log.e("ERROR", "No ha sido posible crear el archivo" + e.toString());

                } catch (IOException e) {
                    Log.e("ERROR", "No ha sido posible escribir en el archivo" +e.toString());
                }

                String str = "";

                // LECTURA DEL ARCHIVO
                try {
                    BufferedReader BR = new BufferedReader(new InputStreamReader(
                            openFileInput("pruebas.DAT")));
                    str = BR.readLine();
                    BR.close();
                } catch (FileNotFoundException e) {
                    Log.e("ERROR", "No a sido posible acceder al archivo" + e.toString());
                } catch (IOException e) {
                    Log.e("ERROR", "No ha sido posible leer el archivo" + e.toString());
                }

                Toast toast = Toast.makeText(this, "Evento Recarga : " + str, Toast.LENGTH_SHORT );
                toast.show();

                break;

            case R.id.configuracion:

                ValidarUsuario_();

                break;

            case R.id.informe:

                Toast toast2 = Toast.makeText(this, "Evento informe", Toast.LENGTH_SHORT );
                toast2.show();

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

            default:
                break;

        }
    }

    /**
     *
     * @return
     */
    public void ValidarUsuario_() {

        //capturamos el layout
        View capa = this.getLayoutInflater().inflate(R.layout.validar_usuario, null);

        //capturamos la imagen y el campo de texto desde nuestro layout personalizado.
        et1 = (EditText) capa.findViewById(R.id.password);

        AlertDialog.Builder miDialogo = new AlertDialog.Builder(this);
        miDialogo.setMessage("Ingresa Codigo");

        //asignamos la vista creada a nuestro diálogo.
        miDialogo.setView(capa);

        //establecemos la instrucción en caso afirmativo
        miDialogo.setPositiveButton("Confirmar", new DialogInterface.OnClickListener() {

            @Override
            public void onClick(DialogInterface dialog, int which) {
                String nombre = et1.getText().toString();
                // Log.println(BIND_WAIVE_PRIORITY, et1.getText().toString(), et1.getText().toString());

                //  getTextViewResult().setText(nombre);

                if ( !nombre.equals(Constantes.PASS_CONFIG) ) {
                    Toast.makeText(getApplicationContext(), " CLAVE INCORRECTA ", Toast.LENGTH_SHORT).show();
                    return;
                }

                Intent intentUno = new Intent("com.provar.activity.recarga.ConfiguracionActivity");
                //Bundle bolsa = new Bundle();
                //bolsa.putString("nombreKey",nombre);
                //intentUno.putExtras(bolsa);
                startActivity(intentUno);


            }
        });

        //se crea y luego se muestra...
        miDialogo.create();
        miDialogo.show();

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    public Button getRecargas() {
        return recargas;
    }

    public void setRecargas(Button recargas) {
        this.recargas = recargas;
    }

    public Button getConfiguracion() {
        return configuracion;
    }

    public void setConfiguracion(Button configuracion) {
        this.configuracion = configuracion;
    }

    public Button getInformes() {
        return informes;
    }

    public void setInformes(Button informes) {
        this.informes = informes;
    }


}
