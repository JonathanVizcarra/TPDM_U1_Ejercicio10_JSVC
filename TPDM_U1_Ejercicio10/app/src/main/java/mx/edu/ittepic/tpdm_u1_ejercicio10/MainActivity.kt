package mx.edu.ittepic.tpdm_u1_ejercicio10

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import androidx.appcompat.app.AlertDialog
import java.util.*

class MainActivity : AppCompatActivity() {

    var icono : ImageView ?= null
    var usuario : EditText ?= null
    var password : EditText ?= null
    var autenticar : Button ?= null
    var usuarios = Vector<String>()
    var passwords = Vector<String>()
    var intentos = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        agregarUsuario("usuario1","1usuari0")
        agregarUsuario("usuario2","2usuari0")
        agregarUsuario("usuario3","3usuari0")
        agregarUsuario("usuario4","4usuari0")
        agregarUsuario("usuario5","5usuari0")

        icono = findViewById(R.id.icono)
        usuario = findViewById(R.id.usuario)
        password = findViewById(R.id.password)
        autenticar = findViewById(R.id.autenticar)

        icono?.setBackgroundResource(R.drawable.user0)

        autenticar?.setOnClickListener {
            var usuarioIngresado = usuario?.text.toString()
            var passwordIngresado = password?.text.toString()
            var autenticado = false
            (0..(usuarios.size-1)).forEach {
                var usuarioReal = usuarios.get(it)
                var passwordReal = passwords.get(it)
                if (usuarioIngresado.equals(usuarioReal) && passwordIngresado.equals(passwordReal)){
                    mensaje("ACEPTADO","Usuario y Contraseña CORRECTA !!!")
                    autenticado = true
                    when (it){
                        0 -> icono?.setBackgroundResource(R.drawable.user1)
                        1 -> icono?.setBackgroundResource(R.drawable.user2)
                        2 -> icono?.setBackgroundResource(R.drawable.user3)
                        3 -> icono?.setBackgroundResource(R.drawable.user4)
                        4 -> icono?.setBackgroundResource(R.drawable.user5)
                    }
                }
            }
            if (!autenticado){
                mensaje("RECHASADO", "Intenta de nuevo...")
                icono?.setBackgroundResource(R.drawable.user0)
                intentos++
                if (intentos == 3){
                    finish()
                }
            }
            autenticado = false
        }
    }

    fun agregarUsuario(usuario : String, password : String){
        usuarios.add(usuario)
        passwords.add(password)
    }

    fun mensaje(titulo:String, mensaje:String){
        var msj = AlertDialog.Builder(this)
        msj.setTitle(titulo).setMessage(mensaje).show()
    }

}
