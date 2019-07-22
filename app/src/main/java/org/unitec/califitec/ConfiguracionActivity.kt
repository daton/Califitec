package org.unitec.califitec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_configuracion.*

class ConfiguracionActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_configuracion)
        //Asignamos cada campo a su respectivo atributo mediante sus id's
        txtActualizarEmail.setText(Globales.alumno?.email)
        txtActualizarPassword.setText(Globales.alumno?.cuenta)
        txtActualizarPasswordConfirmar.setText(Globales.alumno?.cuenta)
    }
}
