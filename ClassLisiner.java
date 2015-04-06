/**
 * Created by eagle on 15.09.2014.
 */
public class ClassLisiner implements Runnable{

    public static ClassLisiner implement = new ClassLisiner();
    static {
        new Thread(implement).start();
    }

    @Override
    public void run() {
        while (true){
            
        }
    }
}
