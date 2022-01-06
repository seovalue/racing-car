package racingCar.controller

import racingCar.RacingCarGame
import racingCar.model.Car
import racingCar.model.Cars
import racingCar.model.RandomMoveStrategy
import racingCar.view.inputCarNames
import racingCar.view.inputTryNumber
import racingCar.view.printResults

class RacingCarController {
    fun run() {
        val cars = createCars(inputCarNames())
        val tryNumber = inputTryNumber()
        val racingCarGame = RacingCarGame(cars, tryNumber)
        val racingResult = racingCarGame.race(RandomMoveStrategy())
        printResults(racingResult)
    }

    private fun createCars(carNames: List<String>): Cars {
        return Cars(carNames.map { Car(it) })
    }
}