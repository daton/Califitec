package org.unitec.califitec

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import com.mobsandgeeks.saripaar.ValidationError
import com.mobsandgeeks.saripaar.Validator
import com.mobsandgeeks.saripaar.annotation.Email
import com.mobsandgeeks.saripaar.annotation.NotEmpty
import com.mobsandgeeks.saripaar.annotation.Password
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), Validator.ValidationListener {

    @NotEmpty(message="este campo es requerido")
    @Email(message = "correo inválido")
    private var login:TextInputEditText?=null

    @NotEmpty(message = "es necesario el password")
    @Password(min = 6, scheme = Password.Scheme.ANY, message = "passwrdo no valido")
    private var password: TextInputEditText? = null


    override fun onValidationFailed(errors: MutableList<ValidationError>?) {
        //Aqui van las acciones  a tomar en caso de validaciones erroneas
        var mensa="men"

        for (error in errors!!) {
            val view = error.view

            mensa=error.getCollatedErrorMessage(applicationContext)
            Toast.makeText(applicationContext,mensa, Toast.LENGTH_LONG).show()
        }
    }

    override fun onValidationSucceeded() {
        //Aqui van acciones a tomar si la validación fue exitosa, por ejemplo navegacion a otro activity
        //Ya quitamos todo del presenter solo invocamos la Tarea autenticar
        //Un pequeño cambio
        TareaAutenticarAlumno(this,this).execute()

    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var validator = Validator(this);
        validator.setValidationListener(this);
        login= txtNuevoNombre
        password=txtPassword

        button.setOnClickListener {
            validator.validate();
        }

    }
}

