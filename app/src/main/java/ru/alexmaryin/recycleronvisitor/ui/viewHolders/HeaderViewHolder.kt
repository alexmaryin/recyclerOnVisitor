package ru.alexmaryin.recycleronvisitor.ui.viewHolders

import androidx.databinding.ViewDataBinding
import ru.alexmaryin.recycleronvisitor.R
import ru.alexmaryin.recycleronvisitor.data.ui_models.RecyclerHeader
import ru.alexmaryin.recycleronvisitor.databinding.RecyclerHeaderItemBinding
import ru.alexmaryin.recycleronvisitor.ui.adapter.AdapterClickListenerById
import ru.alexmaryin.recycleronvisitor.ui.adapter.ViewHolderVisitor

class HeaderViewHolder : ViewHolderVisitor {

    override val layout = R.layout.recycler_header_item

    override fun bind(binding: ViewDataBinding, item: Any, clickListener: AdapterClickListenerById) {
        (binding as RecyclerHeaderItemBinding).headerItem = item as RecyclerHeader
    }

    override fun acceptBinding(item: Any): Boolean = item is RecyclerHeader
}