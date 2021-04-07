package ru.alexmaryin.recycleronvisitor.data.ui_models

import ru.alexmaryin.recycleronvisitor.data.HasStringId

data class CardItem(
    override val id: String = "card",
    val image: String,
    val title: String,
    val description: String,
) : HasStringId
