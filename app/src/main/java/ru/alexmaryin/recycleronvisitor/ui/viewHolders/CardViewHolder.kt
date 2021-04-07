package ru.alexmaryin.recycleronvisitor.ui.viewHolders

import androidx.databinding.ViewDataBinding
import com.squareup.picasso.Picasso
import ru.alexmaryin.recycleronvisitor.R
import ru.alexmaryin.recycleronvisitor.data.ui_models.CardItem
import ru.alexmaryin.recycleronvisitor.databinding.CardItemBinding
import ru.alexmaryin.recycleronvisitor.ui.adapter.AdapterClickListenerById
import ru.alexmaryin.recycleronvisitor.ui.adapter.ViewHolderVisitor

class CardViewHolder : ViewHolderVisitor {
    override val layout: Int = R.layout.card_item

    override fun acceptBinding(item: Any): Boolean = item is CardItem

    override fun bind(binding: ViewDataBinding, item: Any, clickListener: AdapterClickListenerById) {
        with(binding as CardItemBinding) {
            card = item as CardItem
            Picasso.get()
                .load(item.image)
                .into(cardBackgroundImage)
        }
    }
}