package palette;

import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

@RestController
public class PaletteController {

    @RequestMapping("/palette")
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

    @PostMapping("/palette")
    public Palette handleImageUpload(@RequestParam("file") MultipartFile file) {

        return new Palette(
                "#457821",
                "#518934",
                "#508732");
    }
}
