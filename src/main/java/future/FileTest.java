package future;

import java.io.*;
import java.util.Arrays;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantLock;

public class FileTest {

    public static void main(String[] args) {
//        new ReadWriteLock();
        File file = new File("C:\\Users\\admin\\Desktop\\file.txt");
        try {
//            ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(file));
//            oos.writeObject(new int[]{23,45,60,23,24,58});
//            oos.writeObject(new int[]{1,2,3,4,5,6});
//            oos.close();
//
//            ObjectInputStream ois = new ObjectInputStream(new FileInputStream(file));
//            int[] data = (int[])ois.readObject();
//            System.out.println(Arrays.toString(data));
//            data = (int[])ois.readObject();
//            System.out.println(Arrays.toString(data));
//            ois.close();

//            FileOutputStream fos = new FileOutputStream(file);
//            fos.write("HELLO".getBytes("UTF-8"));
//            fos.close();
//
//            FileInputStream fis = new FileInputStream(file);
//            int read = fis.read((new byte[1024]));
//            System.out.println(read);
//            fis.close();

            FileInputStream is = new FileInputStream(file);
            InputStreamReader isr= new InputStreamReader(is);
            BufferedReader in= new BufferedReader(isr);

            String line=null;
            while((line = in.readLine()) != null){
                System.out.println(line);
            }
            is.close();
            isr.close();
            in.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
