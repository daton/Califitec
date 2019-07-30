package org.unitec.califitec

import android.content.Context
import android.content.Intent
import android.os.AsyncTask
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class TareaAutenticarAlumno(var ctx: Context?, var activity: MainActivity?):
AsyncTask<Void,Void,Void>(){
    var alumno=Alumno()

    //En este le pedimos la informacion a la interfaz de usuario (si es que la hay)
    override fun onPreExecute() {
        super.onPreExecute()
        //Preparamos al alumno a partir de la info de la intefaz de usuario
      alumno.email=  activity?.txtNuevoNombre?.text.toString()
      alumno.cuenta=activity?.txtPassword?.text.toString()

    }
//Este es olbigatorio!! y aqui si es importante tener este metodo
    //este somete a informacion al back-end
    override fun doInBackground(vararg p0: Void?): Void? {

   // Aqui vamos a preparar nuestro objeto alumno que ya tenemos para enviar a
    // El back-end
    //Aqui usaremos la bibloteca REtrofir que es muy iportante

    var retrofit= Retrofit.Builder()
        .baseUrl("https://topotiyo.herokuapp.com/")
        .addConverterFactory(JacksonConverterFactory.create())
        .build()

    var servicioAlumno=retrofit.create(ServicioAlumno::class.java)
    var envio=servicioAlumno.autenticar(alumno)
    alumno=envio.execute().body()!!

    //Clase Java
    Globales2.alumno2=Alumno()
    Globales2.alumno2=alumno

    //clase Kotlin
    Globales.alumno=Alumno()
    Globales.alumno=alumno

return null

    }

   //ESte método una vez que se obtenga la respuesta del back end se informa
    //nuevamente en la interfaz de usuario la info aqui, por ejemplo,
    //navegacion hacia otra pagina
    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)

       if(alumno.autenticado!!){
           var i= Intent(ctx, ConfiguracionActivity::class.java)

           Toast.makeText(ctx,"Autenticado "+alumno.toString(),Toast.LENGTH_LONG).show()
           activity?.startActivity(i)
       }
       else Toast.makeText(ctx, "Datos incorrectos", Toast.LENGTH_LONG).show()
    }
}