package com.rsschool.quiz

object QuezQuestss {
    val questsList = listOf(
        QuestSkel(
            id = 1,
            question = "Почему?",
            answers = arrayListOf(
                "Потому что",
                "Да",
                "Нет",
                "Не понял",
                "А че, всмысле"
            ),
            rightAnswer = "Потому что",
            userAnswer = ""
        ),
        QuestSkel(
            id = 2,
            question = "Главный вопрос жизни, Вселенной и всего такого?",
            answers = arrayListOf(
                "42",
                "Не знаю",
                "Не понял",
                "33",
                "43"
            ),
            rightAnswer = "42",
            userAnswer = ""
        ),
        QuestSkel(
            id = 3,
            question = "Сколько хвостов у 7-ми хвостого 8-ми хвоста?",
            answers = arrayListOf(
                "7",
                "15",
                "8",
                "14",
                "1"
            ),
            rightAnswer = "15",
            userAnswer = ""
        ),
        QuestSkel(
            id = 4,
            question = "Сколько весит 1 кг хлопка, если сегодня очень жарко, а завтра понедельник?",
            answers = arrayListOf(
                "1кг",
                "10гр",
                "10000гр",
                "Вторник",
                "Воскресенье"
            ),
            rightAnswer = "1кг",
            userAnswer = ""
        ),
        QuestSkel(
            id = 5,
            question = "Если солнце всходит на востоке, а садится на западе, то стоит ли сегодня идти в магазин?",
            answers = arrayListOf(
                "Стоит",
                "Не стоит",
                "Лучше в понедельник",
                "Не знаю",
                "Не понял"
            ),
            rightAnswer = "Стоит",
            userAnswer = ""
        ),
    )
    fun calcResult(): Int {
        val step = 100 / questsList.size
        return questsList.fold(0) { acc, question ->
            if (question.userAnswer == question.rightAnswer) acc + step else acc
        }
    }
}
