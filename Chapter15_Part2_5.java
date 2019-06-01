/********************************************************************************************************************
 ********************************************************************************************************************
 *****                                    Chapter 15, Part 2: Problem 5                                         *****
 *****__________________________________________________________________________________________________________*****
 *****             5. Implement a bouncing ball program in which the ball bounces off of each wall.             *****
 *****            Use bx, by for the location of the ball and bdx, bdy for the velocity of the ball.            *****
 *****       When the ball hits a wall, multiply its bdx or bdy value by -1 (depending on which wall it hit)    *****
 *****                                  so that it bounces "symmetrically".                                     *****
 *****         Start the ball at a random location with a random bdx/bdy but make sure they are not 0           *****
 *****                              so that the ball moves around the entire pane.                              *****
 ********************************************************************************************************************
 ********************************************************************************************************************/

// IMPORTS of needed tools and plug-ins
import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.shape.Circle;
import javafx.stage.*;
import javafx.scene.layout.*;
import javafx.animation.*;
import javafx.util.Duration;
import java.util.Random;


public class Chapter15_Part2_5 extends Application {

    // CLASS VARIABLE(s) declaration(s)
    private Pane pane;
    private Circle ball;
    private double bx, by, bdx, bdy;
    private int coinToss = 0;
    private int radius = 25;
    private Random random;
    private Timeline timer;


    public static void main(String[] args) {
        launch(args);
    }


    public void start(Stage primaryStage){
        // Initialize the Pane
        pane = new Pane();

        // Initialize the Random variable
        random = new Random();

        // Get the initialize random position of the ball (Circle)
        bx = (random.nextInt(475) + 25);
        by = (random.nextInt(475) + 25);

        // Initialize the Circle and add it to the Pane
        ball = new Circle(bx, by, radius);
        pane.getChildren().add(ball);

        // Get the initial velocity of the ball
        bdx = (random.nextInt(6) + 1);
        bdy = (random.nextInt(6) + 1);

        // Get the horizontal direction of the initial movement
        coinToss = random.nextInt(2);
        System.out.println(coinToss);
        if(coinToss == 0){
            bdx *= -1;
        }

        // Get the vertical direction of the initial movement
        coinToss = random.nextInt(2);
        System.out.println(coinToss);
        if(coinToss == 0){
            bdy *= -1;
        }

        // Animation EventHandler
        timer = new Timeline(new KeyFrame(Duration.millis(50), e-> {
            // remove the old ball
            pane.getChildren().remove(ball);

            // Move the ball at the associated current Velocity
            bx += bdx;
            by += bdy;

            // if and else if block to check if the ball hits the left or right side of the Stage and
                // reverse direction if so (commented out code was to try to change the velocity to a new random number)
            if(bx >= 480){
                // bdx = (random.nextInt(6) + 1);
                bdx *= -1;
            } else if(bx <= 20){
                // bdx = (random.nextInt(6) + 1);
                bdx *= -1;
            }

            // if and else if block to check if the ball hits the top or bottom side of the Stage and
                // reverse direction if so (commented out code was to try to change the velocity to a new random number)
            if(by >= 480){
                // bdy = (random.nextInt(3) + 1);
                bdy *= -1;
            } else if(by <= 20){
                // bdy = (random.nextInt(3) + 1);
                bdy *= -1;
            }

            // Create a new ball (Circle) and add it to the Pane
            ball = new Circle(bx, by, radius);
            pane.getChildren().add(ball);
        }));

        // Set the CycleCount of the Animation to INDEFINITE (animation doesn't end) and Play the animation
        timer.setCycleCount(Timeline.INDEFINITE);
        timer.play();

        // Create the Scene, Set the Title of the Stage, Set the Scene to the Stage, Show the Stage
        Scene scene = new Scene(pane, 500, 500);
        primaryStage.setTitle("Chapter 15, Part 2: Problem 5");
        primaryStage.setScene(scene);
        primaryStage.show();
    }
}
