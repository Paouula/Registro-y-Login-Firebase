package paola.rivera.myapplication

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.activity.enableEdgeToEdge
import androidx.appcompat.app.AppCompatActivity
import androidx.core.view.ViewCompat
import androidx.core.view.WindowInsetsCompat
import com.google.firebase.auth.FirebaseAuth

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContentView(R.layout.activity_main)
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main)) { v, insets ->
            val systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars())
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom)
            insets
        }

        // 1.Mandar a llamar a todos los elementos de la vista
        val txtCorreo = findViewById<EditText>(R.id.txtCorreo)
        val txtContra = findViewById<EditText>(R.id.txtContra)
        val btnRegistrar = findViewById<Button>(R.id.btnRegistrar)

        fun limpiar(){
            txtCorreo.setText("")
            txtContra.setText("")
            txtCorreo.clearFocus()
            txtContra.clearFocus()
        }

        // 2.Programar el botón para registrar los usuarios
        btnRegistrar.setOnClickListener {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(txtCorreo.text.toString(), txtContra.text.toString())
            limpiar()
            Toast.makeText(this, "Usuario Registrado", Toast.LENGTH_LONG).show()
            println("Mensaje en consola")
        }
    }
}