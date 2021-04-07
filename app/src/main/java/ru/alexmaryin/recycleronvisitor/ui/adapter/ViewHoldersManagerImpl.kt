package ru.alexmaryin.recycleronvisitor.ui.adapter

class ViewHoldersManagerImpl : ViewHoldersManager {

    private val holdersMap = emptyMap<Int, ViewHolderVisitor>().toMutableMap()

    override fun registerViewHolder(itemType: Int, viewHolder: ViewHolderVisitor) {
        holdersMap += itemType to viewHolder
    }

    override fun getItemType(item: Any): Int {
        holdersMap.forEach { (itemType, holder) ->
            if(holder.acceptBinding(item)) return itemType
        }
        return ItemTypes.UNKNOWN
    }

    override fun getViewHolder(itemType: Int) = holdersMap[itemType] ?: throw TypeCastException("Unknown recycler item type!")
}