package com.example.whichnumberisbigger

import android.widget.Toast

// in java, when you had a class that had no Android functionality, it was called a POJO
// POJO = Plain Old Java Object

// POKO = Plain Old Kotlin Object? Maybe... or also a data class perhaps...

class BiggerNumberGame(val lowerLimit: Int, val upperLimit: Int) {
    var leftNumber = 0
    var rightNumber = 0
    var score = 0

    // init block gets run one time when the object is constructed
    // usually used for complex operation to set the initial state of the object
    init {
        generateRandomNumbers()
    }


    // need a function to generate the random numbers
    fun generateRandomNumbers() {
        // give two unique numbers for leftNumber and rightNumber between upper and lower limits inclusive
        leftNumber = (Math.random() * (upperLimit + 1 - lowerLimit) + lowerLimit).toInt()
        rightNumber = (Math.random() * (upperLimit + 1- lowerLimit) + lowerLimit).toInt()

        // ensures two numbers are different
        while (leftNumber == rightNumber) {
            rightNumber = (Math.random() * (upperLimit - lowerLimit) + lowerLimit + 1).toInt()
        }
    }


    // need a function to check the answer, update the s core, and return a message
    // in java if we wanted a function that accepted an int parameter called answer and returned a String
    // public String checkAnswer (int answer)
    // in kotlin
    // fun methodName(paramVar : paramType) : returnType

    fun checkAnswer(answer: Int): String {
        return if (answer == leftNumber && leftNumber > rightNumber || answer == rightNumber && leftNumber < rightNumber) {
            score++
            "Your answer is correct."
        } else {
            score--
            "Your answer is incorrect."
        }
        // decide i the answer was bigger or not
        // adjust the score accordingly
        // return a message for the MainActivity to Toast
    }
}
