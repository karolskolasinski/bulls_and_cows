package bulls_and_cows;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

class GameControllerTest {

    private GameController gameController = new GameController();

    @Test
    void shouldcountBullsAndCountCows() {
        //given
        gameController.randomizeComputerDigitsToList();
        gameController.setUserString(gameController.getComputerString());

        //when
        gameController.countBullsCountCows();

        //then
        assertEquals(gameController.getBulls(), 4);
        assertEquals(gameController.getCows(), 0);
    }

}
