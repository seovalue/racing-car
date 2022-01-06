package racingCar.model

import racingCar.exception.CarNameException

class CarName(var name: String) {
    init {
        if (name.length > MAX_NAME_LENGTH) {
            throw CarNameException("자동차의 이름은 10글자를 초과할 수 없습니다.")
        }
    }

    companion object {
        private const val MAX_NAME_LENGTH: Int = 10
    }
}