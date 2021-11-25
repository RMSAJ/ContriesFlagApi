import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.contriesflagapi.databinding.GridViewItemBinding
import com.example.contriesflagapi.network.contriemodel
import com.example.contriesflagapi.network.dataarray

class  PhotoGridAdapter : ListAdapter <contriemodel,
        PhotoGridAdapter.FlagViewHolder>(DiffCallback) {

        class FlagViewHolder( private var binding: GridViewItemBinding):
                RecyclerView.ViewHolder(binding.root) {
                    fun bind(flagPhoto: contriemodel){
                        binding.contryModel = flagPhoto
                        binding.executePendingBindings()
                    }
                }

    companion object DiffCallback : DiffUtil.ItemCallback<contriemodel>() {
        override fun areItemsTheSame(oldItem: contriemodel, newItem: contriemodel): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: contriemodel, newItem: contriemodel): Boolean {
            return oldItem.flag == newItem.flag
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): FlagViewHolder {
       return FlagViewHolder(GridViewItemBinding.inflate(
       LayoutInflater.from(parent.context)))
    }

    override fun onBindViewHolder(holder: FlagViewHolder, position: Int) {
        val flagPhoto = getItem(position)
        holder.bind(flagPhoto)
    }

}