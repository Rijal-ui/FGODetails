package com.belajar.latihan.fgoservantdetail

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.request.RequestOptions

class ListServantAdapter(val listServantData: ArrayList<Servant>) : RecyclerView.Adapter<ListServantAdapter.ListViewHolder>() {

    override fun onCreateViewHolder(viewGroup: ViewGroup, i: Int): ListViewHolder {
        val view:View = LayoutInflater.from(viewGroup.context).inflate(R.layout.item_servant, viewGroup, false)
        return ListViewHolder(view)
    }

    override fun onBindViewHolder(holder: ListViewHolder, position: Int) {
        val servant = listServantData[position]

        Glide.with(holder.itemView.context)
            .load(servant.photo)
            .apply(RequestOptions().override(55,55))
            .into(holder.imgPhoto)

        holder.tvName.text = servant.name
        holder.tvKelas.text = servant.click

        val mContext = holder.itemView.context

        holder.itemView.setOnClickListener {
            val moveDetail = Intent(mContext, ServantDetailActivity::class.java)
            moveDetail.putExtra(ServantDetailActivity.EXTRA_KELAS, servant.click)
            moveDetail.putExtra(ServantDetailActivity.EXTRA_NAME, servant.name)
            moveDetail.putExtra(ServantDetailActivity.EXTRA_PHOTO, servant.photo)
            moveDetail.putExtra(ServantDetailActivity.EXTRA_DETAIL, servant.detail)
            moveDetail.putExtra(ServantDetailActivity.EXTRA_BIO, servant.bio)
            mContext.startActivity(moveDetail)
        }
    }

    override fun getItemCount(): Int {
        return listServantData.size
    }
    inner class ListViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        var tvName: TextView = itemView.findViewById(R.id.tv_servant)
        var tvKelas: TextView = itemView.findViewById(R.id.tv_kelas)
        var imgPhoto: ImageView = itemView.findViewById(R.id.item_photo)
    }
}