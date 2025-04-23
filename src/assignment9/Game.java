package assignment9;

import java.awt.event.KeyEvent;
import edu.princeton.cs.introcs.StdDraw;

public class Game {

    private Snake snake;
    private Food food;

    public Game() {
        StdDraw.enableDoubleBuffering();
        initializeGame();
    }

    private void initializeGame() {
        snake = new Snake();
        food = new Food();
    }

    public void play() {
        snake.changeDirection(4); // Start moving right

        while (true) {
            int dir = getKeypress();
            if (dir != -1) {
                snake.changeDirection(dir);
            }

            snake.move();

            if (snake.eatFood(food)) {
                food = new Food();
                snake.changeColor(ColorUtils.solidColor());
            }

            if (!snake.isInbounds()) {
                return; // End game
            }

            updateDrawing();
        }
    }

    private void updateDrawing() {
        StdDraw.clear();
        snake.draw();
        food.draw();
        StdDraw.setPenColor(StdDraw.BLACK);
        StdDraw.textLeft(0.02, 0.98, "snake length: " + snake.getLength());
        StdDraw.show();
        StdDraw.pause(100);
    }

    private int getKeypress() {
        if (StdDraw.isKeyPressed(KeyEvent.VK_W)) return 1;
        if (StdDraw.isKeyPressed(KeyEvent.VK_S)) return 2;
        if (StdDraw.isKeyPressed(KeyEvent.VK_A)) return 3;
        if (StdDraw.isKeyPressed(KeyEvent.VK_D)) return 4;
        return -1;
    }

    public static void main(String[] args) {
        Game g = new Game();
        g.play();
    }
}
