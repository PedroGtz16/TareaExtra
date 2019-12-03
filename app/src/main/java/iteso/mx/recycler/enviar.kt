package iteso.mx.recycler

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import androidx.appcompat.app.AppCompatActivity
import org.jetbrains.anko.find

class enviar : AppCompatActivity() {

    lateinit var boton:Button
    lateinit var texto: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.vistanueva)


        boton = findViewById(R.id.boton)
        texto = findViewById(R.id.texto)


        boton.setOnClickListener(){





        }



    }

}