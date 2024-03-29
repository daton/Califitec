package org.unitec.califitec

import android.content.Context
import android.os.AsyncTask
import android.widget.Toast
import kotlinx.android.synthetic.main.activity_configuracion.*
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory

class TareaActualizarAlumno(var ctx: Context?, var activity: ConfiguracionActivity?):
AsyncTask<Void,Void,Void>(){
    var alumno=Alumno()
    var estatus =Estatus()

    //En este le pedimos la informacion a la interfaz de usuario (si es que la hay)
    override fun onPreExecute() {
        super.onPreExecute()
        //Preparamos al alumno a partir de la info de la intefaz de usuario
  //Formamos nuestro objeto usuario a partir de la vista (layout asociado)
    alumno.email=    activity?.txtActualizarEmail?.text.toString()
   //Aora asignamos el nuevo password
    alumno.cuenta=activity?.txtActualizarPassword?.text.toString()
        //Con esto simplemente vamos a generar  el nuevo alumno con el mismo
        //para que cuando llegue al back-end  no lo genere sino que lo sobrescriba
        //es decir actualiza
    alumno.id=Globales.alumno?.id

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
    var envio=servicioAlumno.guardar(alumno)
    estatus=envio.execute().body()!!


return null

    }

   //ESte método una vez que se obtenga la respuesta del back end se informa
    //nuevamente en la interfaz de usuario la info aqui, por ejemplo,
    //navegacion hacia otra pagina
    override fun onPostExecute(result: Void?) {
        super.onPostExecute(result)
       Toast.makeText(ctx,estatus.mensaje,Toast.LENGTH_LONG).show()
    }
}