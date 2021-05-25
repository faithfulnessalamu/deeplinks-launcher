package tech.thealamu.android.deeplinkslauncher.ui.main

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import tech.thealamu.android.deeplinkslauncher.data.DeepLink
import tech.thealamu.android.deeplinkslauncher.databinding.LayoutDeeplinkItemBinding

class DeeplinksListAdapter(val onLinkClickListener: MainActivity.Companion.OnLinkClickListener) :
    ListAdapter<DeepLink, DeeplinksListAdapter.ViewHolder>(DiffCallback) {
    class ViewHolder(val binding: LayoutDeeplinkItemBinding) : RecyclerView.ViewHolder(binding.root)

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
    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = LayoutDeeplinkItemBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    /**
     * Replaces the contents of a view (invoked by the layout manager)
     */
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val deeplink = getItem(position)
        with(holder.binding) {
            linkTitle.text = deeplink.title
            linkDesc.text = deeplink.description

            editLink.setOnClickListener {
                onLinkClickListener.onLinkEdit(deeplink.id)
            }

            linkRoot.setOnClickListener {
                onLinkClickListener.onLinkClick(deeplink)
            }
        }
    }

}