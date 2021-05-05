import java.io.IOException;

public class Hexdump {
    private static int col = 16;

    public static void main(String[] args) throws IOException {
        byte[] buf = new byte[col];
        int numRead;
        while ((numRead = System.in.read(buf)) > 0) {
            int i;
            for (i = 0; i < numRead; i++) {
                System.out.print(String.format("%02X ", buf[i]));
            }
            for (i = 0; i < (col - numRead) * 3 + 2; i++) {
                System.out.print(' ');
            }
            for (i = 0; i < numRead; i++) {
                if (buf[i] < 0x20 || buf[i] > 0x7E) {
                    System.out.print('.');
                } else {
                    System.out.print((char)buf[i]);
                }
            }
            System.out.println();
        }
    }
}
