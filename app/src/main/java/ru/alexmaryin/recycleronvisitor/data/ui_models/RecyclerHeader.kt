package ru.alexmaryin.recycleronvisitor.data.ui_models

import ru.alexmaryin.recycleronvisitor.data.HasStringId

data class RecyclerHeader(
    override val id: String = "header",
    val text: String
) : HasStringId
