package racingCar.model

import org.assertj.core.api.Assertions.assertThatCode
import org.junit.jupiter.api.Test
import org.junit.jupiter.api.assertThrows
import racingCar.exception.CarNameException

internal class CarNameTest {
    @Test
    internal fun `create failed when name length over than max name length`() {
        assertThrows<CarNameException> { CarName("aaaaaaaaaaa") }
    }

    @Test
    internal fun create() {
        assertThatCode { CarName("abc") }.doesNotThrowAnyException()
    }
}