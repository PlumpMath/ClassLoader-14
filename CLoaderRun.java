import java.io.File;
import java.io.IOException;
import java.util.Date;
import java.util.Objects;

/**
 * Created by eagle on 13.09.2014.
 */
public class CLoaderRun {
    public static File checkedfile;
    private static long timeStamp;

    private static boolean isFileUpdated(File cfile){

        if (timeStamp != cfile.lastModified()) {
            System.out.println("Last updated:" + new Date(timeStamp) + "!\nNow:" + new Date(checkedfile.lastModified()));
            timeStamp = cfile.lastModified();
            return true;
        }
    return false;
    }



    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, IOException, InterruptedException {

        checkedfile = new File("./src/TestModule.java");


        while (true) {
            if (isFileUpdated(checkedfile)) {


                try {
                    Runtime.getRuntime().exec("javac ./src/TestModule.java").waitFor();
                } catch (InterruptedException e) {
                    System.out.println("Error was found :(" + e);
                }
//                Object j = new ClassLoad().loadClass("TestModule",false).newInstance();
                Object t = new CLoader(new File("./src"), CLoaderRun.class.getClassLoader()).findClass("TestModule").newInstance();
                System.out.println(t);

            }

    }
}}
