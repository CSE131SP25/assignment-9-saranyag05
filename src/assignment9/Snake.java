package assignment9;

import java.awt.Color;
import java.util.LinkedList;

public class Snake {

    private static final double SEGMENT_SIZE = 0.02;
    private static final double MOVEMENT_SIZE = SEGMENT_SIZE * 1.5;
    private LinkedList<BodySegment> segments;
    private double deltaX;
    private double deltaY;
    private Color currentColor;

    public Snake() {
        segments = new LinkedList<>();
        BodySegment initialSegment = new BodySegment(0.5, 0.5, SEGMENT_SIZE);
        segments.add(initialSegment);
        deltaX = 0;
        deltaY = 0;
        currentColor = Color.GREEN;
    }

    public void changeDirection(int direction) {
        if (direction == 1) {
            deltaY = MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 2) {
            deltaY = -MOVEMENT_SIZE;
            deltaX = 0;
        } else if (direction == 3) {
            deltaY = 0;
            deltaX = -MOVEMENT_SIZE;
        } else if (direction == 4) {
            deltaY = 0;
            deltaX = MOVEMENT_SIZE;
        }
    }

    public void move() {
        LinkedList<BodySegment> newSegments = new LinkedList<>();
        // Get the current head
        BodySegment head = segments.getFirst();
        // Create a new head based on direction
        BodySegment newHead = new BodySegment(head.getX() + deltaX, head.getY() + deltaY, SEGMENT_SIZE);
        // Add new head to the new list
        newSegments.addFirst(newHead);
        for (int i = 0; i < segments.size() - 1; i++) {
            // Add rest of the body 
        	newSegments.addLast(segments.get(i));
        }
        segments = newSegments;
    }

    public void draw() {
        for (BodySegment segment : segments) {
            segment.draw(currentColor);
        }
    }

    public boolean eatFood(Food f) {
        BodySegment head = segments.getFirst();
        if (Math.abs(head.getX() - f.getX()) < SEGMENT_SIZE &&
            Math.abs(head.getY() - f.getY()) < SEGMENT_SIZE) {
            BodySegment newSegment = new BodySegment(segments.getLast().getX(), segments.getLast().getY(), SEGMENT_SIZE);
            segments.addLast(newSegment);
            return true;
        }
        return false;
    }

    public boolean isInbounds() {
        BodySegment head = segments.getFirst();
        return head.getX() >= 0 && head.getX() <= 1 && head.getY() >= 0 && head.getY() <= 1;
    }

    public void changeColor(Color newColor) {
        currentColor = newColor;
    }

    public int getLength() {
        return segments.size();
    }
}
