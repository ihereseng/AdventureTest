package com.example.adventuredemo.component

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.adventuredemo.databinding.ViewHolderBinding
import com.example.adventuredemo.network.Product

class ProductAdapter(private val productList: List<Product>) :
    RecyclerView.Adapter<ProductViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductViewHolder {
        val binding = ViewHolderBinding.inflate(
            LayoutInflater.from(parent.context),
            parent,
            false
        )
        return ProductViewHolder(binding.root)
    }

    override fun onBindViewHolder(holder: ProductViewHolder, position: Int) {
        val product = productList[position]
        holder.bind(product.productImage, product.productName, product.productTopic)
    }

    override fun getItemCount(): Int = productList.size

}

class ProductViewHolder(itemView: View) :
    RecyclerView.ViewHolder(itemView) {
    private val binding = ViewHolderBinding.bind(itemView)

    fun bind(imageUrl: String?, title: String?, description: String?) {
        Log.d("ProductViewHolder", "bind: $imageUrl")
        binding.image.loadImageUrl(imageUrl)
        binding.title.text = title
        binding.description.text = description
    }
}