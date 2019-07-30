package org.unitec.califitec

import com.fasterxml.jackson.annotation.JsonIgnoreProperties
import java.io.Serializable


@JsonIgnoreProperties(ignoreUnknown = true)
class Alumno :Serializable {
    var id:String?=null
    var cuenta:String?=null
    var nombre:String?= null
    var materias:ArrayList<Materia>?=null
    var email:String?=null
    var autenticado:Boolean?=null
    override fun toString(): String {
        return "Alumno(id=$id, cuenta=$cuenta, nombre=$nombre, materias=$materias, email=$email, autenticado=$autenticado)"
    }

}