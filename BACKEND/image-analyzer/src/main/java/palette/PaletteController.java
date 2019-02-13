package palette;

import org.json.JSONObject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import static palette.util.ColorThief.getPalette;
import static palette.util.PaletteUtil.arrayTopalette;
import static palette.util.PaletteUtil.extractMainRGB;
import static palette.util.PaletteUtil.paletteToJson;

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
    public String handleImageUpload(@RequestParam("file-img") MultipartFile file) {

        JSONObject paletteJson = new JSONObject();
        try {
            BufferedImage imgBuff = ImageIO.read(file.getInputStream());
            int[][] paletteArrayRgb = getPalette(imgBuff, 3);
            paletteJson = paletteToJson(arrayTopalette(paletteArrayRgb));

            // TODO : Send mainRGB to the Arduino
            String mainRGB = extractMainRGB(paletteArrayRgb);

        } catch (IOException e) {
            e.printStackTrace();
        }

        return paletteJson.toString();
    }
}
