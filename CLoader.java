
import javax.tools.JavaCompiler;
import javax.tools.ToolProvider;
import java.io.*;

public class CLoader extends  ClassLoader{
    private final File dir;

    public CLoader(File dir, ClassLoader parent) {
        super(parent);
        this.dir = dir;
    }

    public Class<?> findClass(String name) throws ClassNotFoundException{
        System.out.printf("Search : %s\n", name);

        File classFileName = new File(dir, (String)name + ".class");
//        File classFileName = new File ("./src/TestModule.class");
        if (!classFileName.exists()) throw new ClassNotFoundException(name);

        byte[] classData = loadClassData(classFileName);
        Class c = defineClass(name, classData, 0 , classData.length);
        System.out.printf("%s Found\n", name);
        return c;
    }


    private byte[] loadClassData(File classfilename){
        int length = (int) classfilename.length();
        byte[] result = new byte[length];
        InputStream in = null;

        try {
            in  = new FileInputStream(classfilename);
        } catch (FileNotFoundException e){
            throw new RuntimeException(e);
        }

        try{
            in.read(result);
        } catch (IOException e){
            throw new RuntimeException(e);
        }

        return result;
    }

}
