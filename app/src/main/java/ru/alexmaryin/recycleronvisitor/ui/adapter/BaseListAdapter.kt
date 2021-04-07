package ru.alexmaryin.recycleronvisitor.ui.adapter

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.databinding.ViewDataBinding
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import ru.alexmaryin.recycleronvisitor.data.HasStringId

class BaseListAdapter(
    private val clickListener: AdapterClickListenerById,
    private val viewHoldersManager: ViewHoldersManager
) : ListAdapter<HasStringId, BaseListAdapter.DataViewHolder>(BaseDiffCallback()) {

    inner class DataViewHolder(
        private val binding: ViewDataBinding,
        private val holder: ViewHolderVisitor
    ) : RecyclerView.ViewHolder(binding.root) {
        fun bind(item: HasStringId, clickListener: AdapterClickListenerById) =
            holder.bind(binding, item, clickListener)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): DataViewHolder =
        LayoutInflater.from(parent.context).run {
            val holder = viewHoldersManager.getViewHolder(viewType)
            DataViewHolder(DataBindingUtil.inflate(this, holder.layout, parent, false), holder)
        }

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) = holder.bind(getItem(position), clickListener)

    override fun getItemViewType(position: Int): Int = viewHoldersManager.getItemType(getItem(position))
}

class BaseDiffCallback : DiffUtil.ItemCallback<HasStringId>() {
    override fun areItemsTheSame(oldItem: HasStringId, newItem: HasStringId): Boolean = oldItem.id == newItem.id
    override fun areContentsTheSame(oldItem: HasStringId, newItem: HasStringId): Boolean = oldItem == newItem
}