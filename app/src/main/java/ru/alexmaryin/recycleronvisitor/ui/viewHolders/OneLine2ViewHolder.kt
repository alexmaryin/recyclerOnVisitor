package ru.alexmaryin.recycleronvisitor.ui.viewHolders

import androidx.databinding.ViewDataBinding
import ru.alexmaryin.recycleronvisitor.R
import ru.alexmaryin.recycleronvisitor.data.ui_models.OneLineItem2
import ru.alexmaryin.recycleronvisitor.databinding.OneLineItem2Binding
import ru.alexmaryin.recycleronvisitor.ui.adapter.AdapterClickListenerById
import ru.alexmaryin.recycleronvisitor.ui.adapter.ViewHolderVisitor


class OneLine2ViewHolder : ViewHolderVisitor {
    override val layout: Int = R.layout.one_line_item_2

    override fun acceptBinding(item: Any): Boolean = item is OneLineItem2

    override fun bind(binding: ViewDataBinding, item: Any, clickListener: AdapterClickListenerById) {
        (binding as OneLineItem2Binding).model = item as OneLineItem2
    }
}