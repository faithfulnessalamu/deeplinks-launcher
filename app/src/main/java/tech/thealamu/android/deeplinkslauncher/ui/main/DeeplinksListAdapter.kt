package tech.thealamu.android.deeplinkslauncher.ui.main

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tech.thealamu.android.deeplinkslauncher.R
import tech.thealamu.android.deeplinkslauncher.data.DeepLink

class DeeplinksListAdapter : ListAdapter<DeepLink, DeeplinksListAdapter.ViewHolder>(DiffCallback){
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view)

    /**
     * Allows the RecyclerView to determine which items have changed when the [List] of [DeepLink]
     * has been updated.
     */
    companion object DiffCallback : DiffUtil.ItemCallback<DeepLink>() {
        override fun areItemsTheSame(oldItem: DeepLink, newItem: DeepLink): Boolean {
            return oldItem === newItem
        }

        override fun areContentsTheSame(oldItem: DeepLink, newItem: DeepLink): Boolean {
            return oldItem.id == newItem.id
        }
    }

    /**
     * Create new [RecyclerView] item views (invoked by the layout manager)
     */
    override fun onCreateViewHolder(parent: ViewGroup,
                                    viewType: Int): ViewHolder {
        return ViewHolder(LayoutInflater.from(parent.context).inflate(R.layout.layout_deeplink_item, parent, false))
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
    }

}