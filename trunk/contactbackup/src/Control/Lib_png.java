package  Control;
import java.io.ByteArrayOutputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.io.OutputStream;
import javax.microedition.io.Connector;
import javax.microedition.io.file.FileConnection;
import javax.microedition.lcdui.Image;

public class Lib_png {

    public static FileConnection fc = null;
    public static OutputStream os = null;
    static int[] crcTable = null;
    
    public static Image makeScale6(Image img) {
        // work out how many pixels, and create array 
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        // get the pixel data 
        img.getRGB(pixels, 0, width, 0, 0, width, height);
        // convert to grey scale 
        for (int i = 0; i < pixels.length; i++) {
            // get one pixel 
            int argb = pixels[i];
            // separate colour components 
            int alpha = (argb >> 24) & 0xff;
            int red = (argb >> 16) & 0xff;
            int green = (argb >> 8) & 0xff;
            int blue = argb & 0xff;
            // construct grey value 
            int grey = (((red * 30) / 100) + ((green * 59) / 100) + ((blue * 11) / 100)) & 0xff;
            // reconstruct pixel with grey value - keep original alpha 
            argb = (alpha << 24) | (grey << 20) | (grey << 8) | grey;
            // put back in the pixel array 
            pixels[i] = argb;
        }
        // create and return a new Image 
        return Image.createRGBImage(pixels, width, height, true);
    }

    public static Image makeScale5(Image img) {
        // work out how many pixels, and create array 
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        // get the pixel data 
        img.getRGB(pixels, 0, width, 0, 0, width, height);
        // convert to grey scale 
        for (int i = 0; i < pixels.length; i++) {
            // get one pixel 
            int argb = pixels[i];
            // separate colour components 
            int alpha = (argb >> 24) & 0xff;
            int red = (argb >> 16) & 0xff;
            int green = (argb >> 8) & 0xff;
            int blue = argb & 0xff;
            // construct grey value 
            int grey = (((red * 30) / 100) + ((green * 59) / 100) + ((blue * 11) / 100)) & 0xff;
            // reconstruct pixel with grey value - keep original alpha 
            argb = (alpha << 24) | (grey << 8) | (grey) | grey << 8;
            // put back in the pixel array 
            pixels[i] = argb;
        }
        // create and return a new Image 
        return Image.createRGBImage(pixels, width, height, true);
    }

    public static Image makeScale4(Image img) {
        // work out how many pixels, and create array 
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        // get the pixel data 
        img.getRGB(pixels, 0, width, 0, 0, width, height);
        // convert to grey scale 
        for (int i = 0; i < pixels.length; i++) {
            // get one pixel 
            int argb = pixels[i];
            // separate colour components 
            int alpha = (argb >> 24) & 0xff;
            int red = (argb >> 16) & 0xff;
            int green = (argb >> 8) & 0xff;
            int blue = argb & 0xff;
            // construct grey value 
            int grey = (((red * 30) / 100) + ((green * 59) / 100) + ((blue * 11) / 100)) & 0xff;
            // reconstruct pixel with grey value - keep original alpha 
            argb = (alpha << 24) | (grey << 8) | (grey << 8) | grey << 8;
            // put back in the pixel array 
            pixels[i] = argb;
        }
        // create and return a new Image 
        return Image.createRGBImage(pixels, width, height, true);
    }

    public static Image makeScale3(Image img) {
        // work out how many pixels, and create array 
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        // get the pixel data 
        img.getRGB(pixels, 0, width, 0, 0, width, height);
        // convert to grey scale 
        for (int i = 0; i < pixels.length; i++) {
            // get one pixel 
            int argb = pixels[i];
            // separate colour components 
            int alpha = (argb >> 24) & 0xff;
            int red = (argb >> 16) & 0xff;
            int green = (argb >> 8) & 0xff;
            int blue = argb & 0xff;
            // construct grey value 
            int grey = (((red * 30) / 100) + ((green * 59) / 100) + ((blue * 11) / 100)) & 0xff;
            // reconstruct pixel with grey value - keep original alpha 
            argb = (alpha << 24) | (grey << 16) | (grey << 8) | grey << 8;
            // put back in the pixel array 
            pixels[i] = argb;
        }
        // create and return a new Image 
        return Image.createRGBImage(pixels, width, height, true);
    }

    public static Image makeScale2(Image img) {
        // work out how many pixels, and create array 
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        // get the pixel data 
        img.getRGB(pixels, 0, width, 0, 0, width, height);
        // convert to grey scale 
        for (int i = 0; i < pixels.length; i++) {
            // get one pixel 
            int argb = pixels[i];
            // separate colour components 
            int alpha = (argb >> 24) & 0xff;
            int red = (argb >> 16) & 0xff;
            int green = (argb >> 8) & 0xff;
            int blue = argb & 0xff;
            // construct grey value 
            int grey = (((red * 130) / 100) + ((green * 159) / 100) + ((blue * 111) / 100)) & 0xff;
            // reconstruct pixel with grey value - keep original alpha 
            argb = (alpha << 24) | (grey << 16) | (grey << 8) | grey;
            // put back in the pixel array 
            pixels[i] = argb;
        }
        // create and return a new Image 
        return Image.createRGBImage(pixels, width, height, true);
    }

    public static Image makeScale1(Image img) {
        // work out how many pixels, and create array 
        int width = img.getWidth();
        int height = img.getHeight();
        int[] pixels = new int[width * height];
        // get the pixel data 
        img.getRGB(pixels, 0, width, 0, 0, width, height);
        // convert to grey scale 
        for (int i = 0; i < pixels.length; i++) {
            // get one pixel 
            int argb = pixels[i];
            // separate colour components 
            int alpha = (argb >> 24) & 0xff;
            int red = (argb >> 16) & 0xff;
            int green = (argb >> 8) & 0xff;
            int blue = argb & 0xff;
            // construct grey value 
            int grey = (((red * 30) / 100) + ((green * 59) / 100) + ((blue * 11) / 100)) & 0xff;
            // reconstruct pixel with grey value - keep original alpha 
            argb = (alpha << 24) | (grey << 16) | (grey << 8) | grey;
            // put back in the pixel array 
            pixels[i] = argb;
        }
        // create and return a new Image 
        return Image.createRGBImage(pixels, width, height, true);
    }
   public static byte[] getByteArrayAlpha(Image image) {
        int[] raw = new int[image.getWidth() * image.getHeight()];
        image.getRGB(raw, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
        byte[] rawByte = new byte[image.getWidth() * image.getHeight() * 4];
        int n = 0;
        for (int i = 0; i < raw.length; i++) {
            int ARGB = raw[i];
            int a = (ARGB & 0xFF000000) >> 24;
            rawByte[n] = ((byte) a);
            n++;
        }

        raw = null;
        return rawByte;
    }

    public static byte[] getByteArrayBlue(Image image) {
        int[] raw = new int[image.getWidth() * image.getHeight()];
        image.getRGB(raw, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
        byte[] rawByte = new byte[image.getWidth() * image.getHeight() * 4];
        int n = 0;
        for (int i = 0; i < raw.length; i++) {
            int ARGB = raw[i];
            int b = ARGB & 0xFF;
            rawByte[n] = ((byte) b);
            n++;
        }

        raw = null;
        return rawByte;
    }

    public static byte[] getByteArrayRed(Image image) {
        int[] raw = new int[image.getWidth() * image.getHeight()];
        image.getRGB(raw, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
        byte[] rawByte = new byte[image.getWidth() * image.getHeight() * 4];
        int n = 0;
        for (int i = 0; i < raw.length; i++) {
            int ARGB = raw[i];
            int r = (ARGB & 0xFF0000) >> 16;
            rawByte[n] = ((byte) r);
            n++;
        }
        raw = null;
        return rawByte;
    }

    public static byte[] getByteArrayGreen(Image image) {
        int[] raw = new int[image.getWidth() * image.getHeight()];
        image.getRGB(raw, 0, image.getWidth(), 0, 0, image.getWidth(), image.getHeight());
        byte[] rawByte = new byte[image.getWidth() * image.getHeight() * 4];
        int n = 0;
        for (int i = 0; i < raw.length; i++) {
            int ARGB = raw[i];
            int g = (ARGB & 0xFF00) >> 8;
            rawByte[n] = ((byte) g);
            n++;
        }

        raw = null;
        return rawByte;
    }

    public static byte[] toPNG(int width, int height, byte[] alpha, byte[] red, byte[] green, byte[] blue)
            throws IOException {
        byte[] signature = {-119, 80, 78, 71, 13, 10, 26, 10};
        byte[] header = createHeaderChunk(width, height);
        byte[] data = createDataChunk(width, height, alpha, red, green, blue);
        byte[] trailer = createTrailerChunk();

        ByteArrayOutputStream png = new ByteArrayOutputStream(signature.length + header.length + data.length + trailer.length);
        png.write(signature);
        png.write(header);
        png.write(data);
        png.write(trailer);
        return png.toByteArray();
    }

    public static byte[] createHeaderChunk(int width, int height) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(13);
        DataOutputStream chunk = new DataOutputStream(baos);
        chunk.writeInt(width);
        chunk.writeInt(height);
        chunk.writeByte(8);
        chunk.writeByte(6);
        chunk.writeByte(0);
        chunk.writeByte(0);
        chunk.writeByte(0);
        return toChunk("IHDR", baos.toByteArray());
    }

    public static byte[] createDataChunk(int width, int height, byte[] alpha, byte[] red, byte[] green, byte[] blue) throws IOException {
        int source = 0;
        int dest = 0;
        byte[] raw = new byte[4 * (width * height) + height];
        for (int y = 0; y < height; y++) {
            raw[(dest++)] = 0;
            for (int x = 0; x < width; x++) {
                raw[(dest++)] = red[source];
                raw[(dest++)] = green[source];
                raw[(dest++)] = blue[source];
                raw[(dest++)] = alpha[(source++)];
            }
        }
        return toChunk("IDAT", toZLIB(raw));
    }

    public static byte[] createTrailerChunk() throws IOException {
        return toChunk("IEND", new byte[0]);
    }

    public static byte[] toChunk(String id, byte[] raw) throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(raw.length + 12);
        DataOutputStream chunk = new DataOutputStream(baos);
        chunk.writeInt(raw.length);
        byte[] bid = new byte[4];
        for (int i = 0; i < 4; i++) {
            bid[i] = ((byte) id.charAt(i));
        }
        chunk.write(bid);
        chunk.write(raw);

        int crc = -1;
        crc = updateCRC(crc, bid);
        crc = updateCRC(crc, raw);
        chunk.writeInt(crc ^ 0xFFFFFFFF);

        return baos.toByteArray();
    }

    public static void createCRCTable() {
        crcTable = new int[256];

        for (int i = 0; i < 256; i++) {
            int c = i;
            for (int k = 0; k < 8; k++) {
                c = (c & 0x1) > 0 ? 0xEDB88320 ^ c >>> 1 : c >>> 1;
            }
            crcTable[i] = c;
        }
    }

    public static int updateCRC(int crc, byte[] raw) {
        if (crcTable == null) {
            createCRCTable();
        }

        for (int i = 0; i < raw.length; i++) {
            crc = crcTable[((crc ^ raw[i]) & 0xFF)] ^ crc >>> 8;
        }

        return crc;
    }

    public static byte[] toZLIB(byte[] raw)
            throws IOException {
        ByteArrayOutputStream baos = new ByteArrayOutputStream(raw.length + 5 + 6);
        DataOutputStream zlib = new DataOutputStream(baos);
        byte tmp = 8;
        zlib.writeByte(tmp);
        zlib.writeByte((31 - (tmp << 8) % 31) % 31);

        zlib.writeByte(1);
        char length = (char) raw.length;
        zlib.writeByte((byte) (length & 0xFF));
        zlib.writeByte((byte) ((length & 0xFF00) >> '\b'));
        zlib.writeByte((byte) ((length ^ 0xFFFFFFFF) & 0xFF));
        zlib.writeByte((byte) (((length ^ 0xFFFFFFFF) & 0xFF00) >> '\b'));
        zlib.write(raw);

        zlib.writeInt(calcADLER32(raw));
        return baos.toByteArray();
    }

    public static int calcADLER32(byte[] raw) {
        int s1 = 1;
        int s2 = 0;
        for (int i = 0; i < raw.length; i++) {
            s1 = (s1 + raw[i]) % 65521;
            s2 = (s2 + s1) % 65521;
        }
        return (s2 << 16) + s1;
    }

    public static int save_png(Image img, String FileName) {
        byte[] ba = null;
        try {
            ba = toPNG(img.getWidth(), img.getHeight(), getByteArrayAlpha(img), getByteArrayRed(img), getByteArrayGreen(img), getByteArrayBlue(img));
        } catch (Exception e) {
        }
        try {
            fc = (FileConnection) Connector.open("file:///" + FileName);
            if (fc.exists()) {
                fc.delete();
            }
            fc.create();
            os = fc.openOutputStream();
            os.write(ba);
            if (os != null) {
                os.close();
            }
            if (fc != null) {
                fc.close();
            }
        } catch (Exception e) {
            return -1;
        }
        return 1;
    }
}
