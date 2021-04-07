package ru.alexmaryin.recycleronvisitor.data.ui_models

import ru.alexmaryin.recycleronvisitor.data.HasStringId

data class TwoStringsItem(
    override val id: String = "two strings",
    val caption: String,
    val details: String
) : HasStringId
