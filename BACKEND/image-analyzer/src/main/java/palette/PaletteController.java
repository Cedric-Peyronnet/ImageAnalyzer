package palette;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static palette.util.ColorThief.getPalette;

@RestController
public class PaletteController {

    //Try to put "localhost" instead of *
    @CrossOrigin(origins="*")
    @RequestMapping("/randompalette")
    public Palette handleRandomPalette(@RequestParam(value="maincolor", defaultValue="orange") String mainColor) {
        Palette randomPalette = new Palette();
        //juste pour test - il faudrait aussi check notBlank
        if(mainColor.isEmpty()) {
            randomPalette.setMainColor("NOT IMPLEMENTED LOL");
            randomPalette.setSecondColor("NOT IMPLEMENTED LOL");
            randomPalette.setThirdColor("NOT IMPLEMENTED LOL");
        } else {
            randomPalette.setMainColor("#457821");
            randomPalette.setSecondColor("#518934");
            randomPalette.setThirdColor("#508732");
        }
        return randomPalette;
    }

    //Try to put "localhost" instead of *
    @CrossOrigin(origins="*")
    @PostMapping("/palette")
    public Palette handleImageUpload(@RequestParam("file-img") MultipartFile file) {

        try {
            BufferedImage imgBuff = ImageIO.read(file.getInputStream());
            int[][] paletteArrayRgb = getPalette(imgBuff, 3);
            System.out.println(paletteArrayRgb[0][0]);
            System.out.println(paletteArrayRgb[0][1]);
            System.out.println(paletteArrayRgb[0][2]);

            String hexColor = String.format( "#%02x%02x%02x", paletteArrayRgb[0][0], paletteArrayRgb[0][1], paletteArrayRgb[0][2] );
            System.out.println(hexColor);
        } catch (IOException e) {
            e.printStackTrace();
        }



        return new Palette(
                "#457821",
                "#518934",
                "#508732");
    }
}
