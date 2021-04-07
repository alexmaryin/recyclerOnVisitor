package ru.alexmaryin.recycleronvisitor.data.ui_models

import ru.alexmaryin.recycleronvisitor.data.HasStringId

data class OneLineItem2(
    override val id: String = "one line",
    val left: String,
    val right: String
) : HasStringId