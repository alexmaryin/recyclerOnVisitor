package ru.alexmaryin.recycleronvisitor

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.components.FragmentComponent
import dagger.hilt.android.scopes.FragmentScoped
import dagger.hilt.components.SingletonComponent
import ru.alexmaryin.recycleronvisitor.ui.adapter.ItemTypes
import ru.alexmaryin.recycleronvisitor.ui.adapter.ViewHoldersManager
import ru.alexmaryin.recycleronvisitor.ui.adapter.ViewHoldersManagerImpl
import ru.alexmaryin.recycleronvisitor.ui.viewHolders.CardViewHolder
import ru.alexmaryin.recycleronvisitor.ui.viewHolders.HeaderViewHolder
import ru.alexmaryin.recycleronvisitor.ui.viewHolders.OneLine2ViewHolder
import ru.alexmaryin.recycleronvisitor.ui.viewHolders.TwoStringsViewHolder

@Module
@InstallIn(FragmentComponent::class)
object DiModule {

    @Provides
    @FragmentScoped
    fun provideAdaptersManager(): ViewHoldersManager = ViewHoldersManagerImpl().apply {
        registerViewHolder(ItemTypes.HEADER, HeaderViewHolder())
        registerViewHolder(ItemTypes.ONE_LINE_STRINGS, OneLine2ViewHolder())
        registerViewHolder(ItemTypes.TWO_STRINGS, TwoStringsViewHolder())
        registerViewHolder(ItemTypes.CARD, CardViewHolder())
    }
}