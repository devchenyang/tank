package com.chenyang.tank;

import javax.imageio.ImageIO;
import java.awt.image.BufferedImage;
import java.io.IOException;

public class ResourceMgr {
    public static BufferedImage rBadTankU, rBadTankD, rBadTankL, rBadTankR;
    public static BufferedImage bBadTankU, bBadTankD, bBadTankL, bBadTankR;
    public static BufferedImage rGoodTankU, rGoodTankD, rGoodTankL, rGoodTankR;
    public static BufferedImage bGoodTankU, bGoodTankD, bGoodTankL, bGoodTankR;
    public static BufferedImage bulletU, bulletD, bulletL, bulletR;
    public static BufferedImage[] explodes = new BufferedImage[16];

//    public static ResourceMgr resourceMgr = new ResourceMgr();
    public static ResourceMgr resourceMgr;

    private ResourceMgr() {
    }

    public static ResourceMgr getInstance() {
        if (resourceMgr == null) {
            return new ResourceMgr();
        }
        return resourceMgr;
    }

    static {
        try {
            rBadTankU = ImageIO.read(ResourceMgr.class.getResourceAsStream("/images/BadTank1.png"));
            rBadTankD = ImageUtil.rotateImage(rBadTankU, 180);
            rBadTankL = ImageUtil.rotateImage(rBadTankU, -90);
            rBadTankR = ImageUtil.rotateImage(rBadTankU, 90);

            bBadTankU = ImageIO.read(ResourceMgr.class.getResourceAsStream("/images/BadTank2.png"));
            bBadTankD = ImageUtil.rotateImage(bBadTankU, 180);
            bBadTankL = ImageUtil.rotateImage(bBadTankU, -90);
            bBadTankR = ImageUtil.rotateImage(bBadTankU, 90);

            rGoodTankU = ImageIO.read(ResourceMgr.class.getResourceAsStream("/images/GoodTank1.png"));
            rGoodTankD = ImageUtil.rotateImage(rGoodTankU, 180);
            rGoodTankL = ImageUtil.rotateImage(rGoodTankU, -90);
            rGoodTankR = ImageUtil.rotateImage(rGoodTankU, 90);

            bGoodTankU = ImageIO.read(ResourceMgr.class.getResourceAsStream("/images/GoodTank2.png"));
            bGoodTankD = ImageUtil.rotateImage(bGoodTankU, 180);
            bGoodTankL = ImageUtil.rotateImage(bGoodTankU, -90);
            bGoodTankR = ImageUtil.rotateImage(bGoodTankU, 90);

            bulletU = ImageIO.read(ResourceMgr.class.getResourceAsStream("/images/bulletU.png"));
            bulletD = ImageUtil.rotateImage(bulletU, 180);
            bulletL = ImageUtil.rotateImage(bulletU, -90);
            bulletR = ImageUtil.rotateImage(bulletU, 90);

            for (int i = 0; i < explodes.length; i++) {
                explodes[i] = ImageIO.read(ResourceMgr.class.getResourceAsStream("/images/e" + (i + 1) + ".gif"));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void main(String[] args) {
        for (int i = 0; i < 100; i++) {
            new Thread(()-> System.out.println(ResourceMgr.getInstance().hashCode())).start();
        }
    }
}
