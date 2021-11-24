import android.widget.ImageView
import androidx.core.net.toUri
import androidx.databinding.BindingAdapter
import coil.load

@BindingAdapter("photoUrl")
fun ImageView.bind(photoUrl: String?){
    photoUrl?.let {
    val photoUri = photoUrl.toUri().buildUpon().scheme("https").build()
    this.load(photoUri)}
}