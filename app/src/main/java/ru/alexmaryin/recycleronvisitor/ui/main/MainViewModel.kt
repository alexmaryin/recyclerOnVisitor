package ru.alexmaryin.recycleronvisitor.ui.main

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.emitAll
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.shareIn
import ru.alexmaryin.recycleronvisitor.data.TestData
import javax.inject.Inject

@HiltViewModel
class MainViewModel @Inject constructor(

): ViewModel() {

    private val items = flow {
        emitAll(TestData.cardFlow)
        emitAll(TestData.twoLinesFlow)
        emitAll(TestData.oneLineFlow)
    }

    fun getItems() = items.shareIn(viewModelScope, SharingStarted.Lazily, 1)

}