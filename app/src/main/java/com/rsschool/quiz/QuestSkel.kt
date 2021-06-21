package com.rsschool.quiz

data class QuestSkel(
    val id: Int,
    val question: String,
    val answers: ArrayList<String>,
    val rightAnswer: String,
    var userAnswer: String
)

