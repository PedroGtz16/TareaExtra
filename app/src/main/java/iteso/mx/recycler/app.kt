package iteso.mx.recycler

import android.app.Application
import com.parse.Parse

class app: Application() {
    override fun onCreate() {
        super.onCreate()
        Parse.initialize(
            Parse.Configuration.Builder(this).applicationId("8PgyG99PVHKo4v6qeNnIQvoti9Z1poDxgrN6OGYj")
                .clientKey("1Q89Jm5BP8GgQHlWLbpQxmstiPDqmVjODsEgTuCN")
                .server("https://parseapi.back4app.com/")
                .build()
        )
    }
}