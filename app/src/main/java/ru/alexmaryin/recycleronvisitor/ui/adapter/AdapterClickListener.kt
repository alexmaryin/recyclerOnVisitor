package ru.alexmaryin.recycleronvisitor.ui.adapter


class AdapterClickListenerById(val clickListener: (id: String) -> Unit) {
    fun onClick(id: String) = clickListener(id)
}