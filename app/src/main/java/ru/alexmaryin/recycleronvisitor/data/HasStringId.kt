package ru.alexmaryin.recycleronvisitor.data

interface HasStringId {
    val id: String
    override fun equals(other: Any?): Boolean
}
