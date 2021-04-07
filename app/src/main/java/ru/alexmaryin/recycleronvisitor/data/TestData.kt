package ru.alexmaryin.recycleronvisitor.data

import kotlinx.coroutines.flow.flow
import ru.alexmaryin.recycleronvisitor.data.ui_models.CardItem
import ru.alexmaryin.recycleronvisitor.data.ui_models.OneLineItem2
import ru.alexmaryin.recycleronvisitor.data.ui_models.RecyclerHeader
import ru.alexmaryin.recycleronvisitor.data.ui_models.TwoStringsItem

object  TestData {

    private val pictures = listOf(
        "https://cdn.pixabay.com/photo/2021/02/23/11/06/mountains-6043079_960_720.jpg",
        "https://cdn.pixabay.com/photo/2013/10/02/23/03/mountains-190055_960_720.jpg",
        "https://cdn.pixabay.com/photo/2015/03/26/09/47/sky-690293_960_720.jpg",
        "https://cdn.pixabay.com/photo/2013/03/02/02/41/alley-89197_960_720.jpg",
    )

    val cardFlow = flow {
        emit(RecyclerHeader(text = "Карточки с фото"))
        repeat(10) { num ->
            emit(CardItem(
                image = pictures.random(),
                title = "Карточка номер $num",
                description = "Здесь должно быть описание фотографии, длинное описание, со множеством деталей.\n" +
                        "все фото взяты с сайта pixabay.com")
            )
        }
    }

    val twoLinesFlow = flow {
        emit(RecyclerHeader(text = "Двустрочные элементы списка"))
        repeat(10) { num ->
            emit(TwoStringsItem(caption = "Заголовок $num", details = "Текст $num под заголовоком $num"))
        }
    }

    val oneLineFlow = flow {
        emit(RecyclerHeader(text = "Однострочные элементы"))
        repeat(10) { num ->
            emit(OneLineItem2(left = "$num элемент", right = "значение $num элемента"))
        }
    }
}