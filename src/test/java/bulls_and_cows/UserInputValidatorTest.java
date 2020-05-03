package bulls_and_cows;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertThrows;

class UserInputValidatorTest {

    private UserInputValidator userInputValidator = new UserInputValidator();

    @ParameterizedTest
    @MethodSource("givenStringDuplicated")
    void exceptionShouldBeThrownIfUserInputContainsDuplicatedCharacters(String userInput) {
        assertThrows(IllegalArgumentException.class, () -> userInputValidator.validateIfDigitsAreAllDifferent(userInput));
    }

    private static Stream<Arguments> givenStringDuplicated() {
        return Stream.of(
                Arguments.of("1123"),
                Arguments.of("0122"),
                Arguments.of("1221"),
                Arguments.of("1233"),
                Arguments.of("1213"),
                Arguments.of("1112"),
                Arguments.of("4444")
        );
    }

    @ParameterizedTest
    @MethodSource("givenStringLessThanFour")
    void exceptionShouldBeThrownIfUserInputLengthIsLessThanFour(String userInput) {
        assertThrows(IllegalArgumentException.class, () -> userInputValidator.validateIfLengthIsLessThanFour(userInput));
    }

    private static Stream<Arguments> givenStringLessThanFour() {
        return Stream.of(
                Arguments.of(""),
                Arguments.of("1"),
                Arguments.of("12"),
                Arguments.of("123")
        );
    }

    @Test
    void exceptionShouldBeThrownIfUserInputLengthIsMoreThanFour() {
        String userInput = "12345";

        assertThrows(IllegalArgumentException.class, () -> userInputValidator.validateIfLengthIsMoreThanFour(userInput));
    }

    @ParameterizedTest
    @MethodSource("givenStringNotOnlyDigits")
    void exceptionShouldBeThrownIfUserInputNotContainsOnlyDigits(String userInput) {
        assertThrows(IllegalArgumentException.class, () -> userInputValidator.validateIfOnlyDigits(userInput));
    }

    private static Stream<Arguments> givenStringNotOnlyDigits() {
        return Stream.of(
                Arguments.of("123a"),
                Arguments.of("0abc"),
                Arguments.of("12bb"),
                Arguments.of("aaaa"),
                Arguments.of("abcd")
        );
    }
}
