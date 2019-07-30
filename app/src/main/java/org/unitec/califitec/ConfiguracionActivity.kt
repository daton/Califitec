package org.unitec.califitec

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_configuracion.*
import java.io.FileOutputStream
import java.io.ObjectOutputStream

class ConfiguracionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)
        //Asignamos cada campo a su respectivo atributo mediante sus id's
        txtActualizarEmail.setText(Globales.alumno?.email)
        txtActualizarPassword.setText(Globales.alumno?.cuenta)
        txtActualizarPasswordConfirmar.setText(Globales.alumno?.cuenta)

        cambiarDatos.setOnClickListener {
            TareaActualizarAlumno(this,this).execute()

        }

        recordarDatos.setOnClickListener {
        var fos=    openFileOutput("archivaldo", Context.MODE_PRIVATE)
            var obj=ObjectOutputStream(fos)
            obj.writeObject(Globales.alumno)

            /*
              var fis=openFileInput("archivaldo");
              var obj=ObjectInputStream(fis);
              Globales.alumno=readObject() as Alumno
             */
            Toast.makeText(
                this, "Valores guardados", Toast.LENGTH_LONG
            ).show()
        }
    }
}
