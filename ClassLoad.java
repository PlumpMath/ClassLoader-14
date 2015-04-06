/**
 * Created by eagle on 9/18/14.
 */
public class ClassLoad extends ClassLoader {

    public Class<?> loadClass(String name, boolean resolve) throws ClassNotFoundException{
        return super.loadClass(name,resolve);

    }

}
