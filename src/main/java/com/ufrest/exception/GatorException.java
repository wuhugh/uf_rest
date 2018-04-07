package com.ufrest.exception;

/**
 * http://www.chris.com/ascii/index.php?art=animals/reptiles/aligators
 *                      _.---._     .---.
 * __...---' .---. `---'-.   `.
 * ~ -~ -.-''__.--' _.'( | )`.  `.  `._ :
 * -.~~ .'__-'_ .--'' ._`---'_.-.  `.   `-`.
 * ~ ~_~-~-~_ ~ -._ -._``---. -.    `-._   `.
 * ~- ~ ~ -_ -~ ~ -.._ _ _ _ ..-_ `.  `-._``--.._
 * ~~-~ ~-_ _~ ~-~ ~ -~ _~~_-~ -._  `-.  -. `-._``--.._.--''. ~ -~_
 * ~~ -~_-~ _~- _~~ _~-_~ ~-_~~ ~-.___    -._  `-.__   `. `. ~ -_~
 * jgs   ~~ _~- ~~- -_~  ~- ~ - _~~- _~~ ~---...__ _    ._ .` `. ~-_~
 * ~ ~- _~~- _-_~ ~-_ ~-~ ~_-~ _~- ~_~-_~  ~--.....--~ -~_ ~
 * ~ ~ - ~  ~ ~~ - ~~-  ~~- ~-  ~ -~ ~ ~ -~~-  ~- ~-~
 */
public class GatorException extends RuntimeException {
    private Throwable cause;
    private String message;

    public GatorException(Throwable cause) {
        super(cause);
        this.cause = cause;
    }

    public GatorException(String message) {
        super(message);
        this.message = message;
    }

    public GatorException(Throwable cause, String message) {
        super(message, cause);
    }

}
