package ru.alexmaryin.recycleronvisitor.ui.viewHolders

import androidx.databinding.ViewDataBinding
import ru.alexmaryin.recycleronvisitor.R
import ru.alexmaryin.recycleronvisitor.data.ui_models.TwoStringsItem
import ru.alexmaryin.recycleronvisitor.databinding.TwoLineItemBinding
import ru.alexmaryin.recycleronvisitor.ui.adapter.AdapterClickListenerById
import ru.alexmaryin.recycleronvisitor.ui.adapter.ViewHolderVisitor

class TwoStringsViewHolder : ViewHolderVisitor {
    override val layout: Int = R.layout.two_line_item

    override fun acceptBinding(item: Any): Boolean = item is TwoStringsItem

    override fun bind(binding: ViewDataBinding, item: Any, clickListener: AdapterClickListenerById) {
        (binding as TwoLineItemBinding).model = item as TwoStringsItem
    }
}