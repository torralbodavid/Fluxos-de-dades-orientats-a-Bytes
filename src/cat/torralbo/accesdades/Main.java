package cat.torralbo.accesdades;


import java.io.*;

public class Main {

    static File ranaGustavo = new File("ranagustavo.gif");
    static File ranaGustavoCopia = new File("ranagustavo2.gif");


    public static void main(String[] args) {

        try {
            copiaFitxer(ranaGustavo, ranaGustavoCopia);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }

    public static void llegeixFitxer(File fitxer){
        int content, iteracions = 0;

        try (FileInputStream fis = new FileInputStream(fitxer)) {

            System.out.println("Bytes totals: "+ fis.available());


            while ((content = fis.read()) != -1) {
                System.out.println(content);
                iteracions++;
            }

            System.out.println("\nS'han fet "+iteracions+" iteracions.");

            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void llegeixFitxer128(File fitxer){
        int content, iteracions = 0;
        byte[] lectura = new byte[128];

        try (FileInputStream fis = new FileInputStream(fitxer)) {

            System.out.println("Bytes totals: "+ fis.available());


            while ((content = fis.read(lectura)) != -1) {
                System.out.println(content);
                iteracions++;
            }

            System.out.println("\nS'han fet "+iteracions+" iteracions.");
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void ignora64(File fitxer){
        int content, iteracions = 0;
        byte[] lectura = new byte[128];

        try (FileInputStream fis = new FileInputStream(fitxer)) {

            System.out.println("Bytes totals: "+ fis.available());


            while ((content = fis.read(lectura)) != -1) {
                System.out.println(content);

                //Ignora 64 bytes
                fis.skip(64);
                iteracions++;
            }

            System.out.println("\nS'han fet "+iteracions+" iteracions.");
            fis.close();

        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static void copiaFitxer(File primer, File segon) throws IOException {
        InputStream is = null;
        OutputStream os = null;
        try {
            is = new FileInputStream(primer);
            os = new FileOutputStream(segon, true);
            byte[] buffer = new byte[100];

            while ((is.read(buffer)) > 0) {
                os.flush();
                os.write(buffer);
            }

        } finally {
            is.close();
            os.close();
        }
    }
}

