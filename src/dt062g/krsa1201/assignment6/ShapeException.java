package dt062g.krsa1201.assignment6;

import java.lang.Exception;

/**
 * <h1>Shape Exception</h1>
 * <p>A simple exception class used for handling
 * various shape-related errors</p>
 * @author Kristian Sakarisson
 * @version 1.0
 * @since 09-11-2017
 */
class ShapeException extends Exception {
    /**
     * <h2>Message constructor</h2>
     * <p>Constructs a new ShapeException with a given message</p>
     * @param message The details of the error message. Can be accessed with the getMessage() method
     */
    public ShapeException(String message) {
        super(message);
    }
}
