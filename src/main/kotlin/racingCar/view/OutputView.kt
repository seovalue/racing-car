package racingCar.view

import racingCar.model.Car
import racingCar.model.Cars

fun printResults(racingResult: Pair<List<Cars>, List<Car>>) {
    println("실행 결과")
    for (cars in racingResult.first) {
        printResult(cars)
    }

    val winnerNames = racingResult.second.map { it.name }
    println("${winnerNames.joinToString(",")}가 최종 우승했습니다.")
}

fun printResult(cars: Cars) {
    cars.forEach {
        println("${it.name} : ${"-".repeat(it.position)}")
    }
    println()
}
