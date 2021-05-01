package com.chenyang.tank.test;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertNotNull;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.File;

public class ImageTest {

    @Test
    public void test01() throws Exception {
        BufferedImage image = ImageIO.read(new File("E:/IdeaProjects/tank/tank01/src/main/resources/images/bulletD.gif"));
        assertNotNull(image);

        BufferedImage image2 = ImageIO.read(ImageTest.class.getResourceAsStream("/images/bulletD.gif"));
        assertNotNull(image2);
    }
}
