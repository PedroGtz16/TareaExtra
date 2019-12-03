package iteso.mx.recycler

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.EditText
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.parse.*
import iteso.mx.recycler.adapters.AdapterName
import org.jetbrains.anko.toast





class MainActivity : AppCompatActivity() {

    lateinit var boton: Button
    lateinit var textonuevo: EditText
    lateinit var textoviejo: EditText

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


       val recyclerView = findViewById<RecyclerView>(R.id.activity_main_names_rv)
       /*
        val names = arrayListOf<HashMap<String, String>>()
        names.add(HashMap())
        names[0].put("name", "Erick")
        names[0].put("lastName", "De Santiago")
        names.add(HashMap())
        names[1].put("name", "Edmundo")
        names[1].put("lastName", "Vidalvarez")
        names.add(HashMap())
        names[2].put("name", "Rogelio")
        names[2].put("lastName", "Sandoval")
        names.add(HashMap())
        names[3].put("name", "Javier")
        names[3].put("lastName", "Gil")
        names.add(HashMap())
        names[4].put("name", "Alberto")
        names[4].put("lastName", "Miramontes")
        recyclerView.adapter = AdapterName(names)
        recyclerView.layoutManager = LinearLayoutManager(this) */

        var arraynames = arrayListOf<String>()
        val user = ParseUser.getCurrentUser()
        ParseUser.logOut()
        val query = ParseQuery.getQuery<ParseObject>("post")

        query.findInBackground{ objects, e ->
            runOnUiThread{
                if (e == null) {

                    for (nombres in objects?.indices!!) {
                        arraynames.add(objects.get(nombres).getString("name")!!)

                    }
                    recyclerView.adapter = AdapterName(arraynames)
                    recyclerView.layoutManager = LinearLayoutManager(this@MainActivity)

                } else {
                    Log.wtf("Error", e.localizedMessage)
                    toast ("error")
                }
            }
        }


        boton = findViewById(R.id.boton)
        textonuevo = findViewById(R.id.textonuevo)
        textoviejo = findViewById(R.id.textoviejo)


        boton.setOnClickListener(){

           //var obj = ParseObject("post")
           // obj.put("name",textonuevo.text.toString())
           // obj.saveInBackground()
toast(textonuevo.text.toString())
            var queryn = ParseQuery.getQuery<ParseObject>("post");
            queryn.whereEqualTo("name", textoviejo.text.toString())

            queryn.getFirstInBackground(object: GetCallback<ParseObject> {
                override fun done(usuario: ParseObject, e: ParseException?) {
                    if (e == null) {

                       usuario.put("name",textonuevo.text.toString())
                        usuario.saveInBackground()
                       //usuario.deleteInBackground()
                    }
                    else{
                        toast("errror222")
                    }
                }


            })
        }
    }
}