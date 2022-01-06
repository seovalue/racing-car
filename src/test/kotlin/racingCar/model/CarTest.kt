package racingCar.model

import org.assertj.core.api.Assertions.assertThat
import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.DisplayName
import org.junit.jupiter.api.Test
import org.junit.jupiter.params.ParameterizedTest
import org.junit.jupiter.params.provider.CsvSource

internal class CarTest {
    @DisplayName("자동차를 생성한다.")
    @Test
    internal fun `create car`() {
        assertThatCode { Car(CarName("joanne")) }.doesNotThrowAnyException()
    }

    @DisplayName("4보다 작은 경우 1칸 전진한다.")
    @Test
    internal fun `move one position less than pivot`() {
        val car = Car(CarName("joanne"))

        val movedCar = car.move(object : MoveStrategy {
            override fun canMove(): Boolean {
                return true
            }
        })

        assertThat(movedCar.position).isEqualTo(1)
    }

    @DisplayName("4보다 큰 경우 정지한다.")
    @Test
    internal fun `stop when more than pivot`() {
        val car = Car(CarName("joanne"))

        val movedCar = car.move(object : MoveStrategy {
            override fun canMove(): Boolean {
                return false
            }
        })

        assertThat(movedCar.position).isEqualTo(0)
    }

    @DisplayName("Position이 같은지 확인한다")
    @ParameterizedTest
    @CsvSource(value = ["3:3:true", "2:1:false"], delimiter = ':')
    internal fun isSamePosition(position: Int, targetPosition: Int, expected: Boolean) {
        // given
        val car = Car(carName = CarName("BENZ"), position = position)

        // when
        val actual = car.isSamePosition(targetPosition)

        // then
        assertThat(actual).isEqualTo(expected)
    }
}