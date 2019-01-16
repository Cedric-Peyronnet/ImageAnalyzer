package palette;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static palette.util.ColorThief.getPalette;

@SpringBootApplication
public class Application {

    public static void main(String[] args) {



        // JUST FOR TEST
        try {
            final BufferedImage testbuf = ImageIO.read(new File("colorpalette.png"));
            int[][] paletteArrayRgb = getPalette(testbuf, 3);
            System.out.println(paletteArrayRgb);
        } catch (IOException e) {
            e.printStackTrace();
        }


        SpringApplication.run(Application.class, args);
    }
}
