package test;

import net.openhft.compiler.CachedCompiler;

public class SampleApp {

  private final static String className = "test.MyClass";
  private final static String myClassStr = "package test;\n" +
      "public class MyClass implements Runnable {\n" +
      " public void run() {\n" +
      "  System.out.println(\"Hello, MyClass!\");\n" +
      " }\n" +
      "}\n";

  public static void main(String[] args) throws Exception {
      CachedCompiler cc = new CachedCompiler(null, null);
      Class aClass = cc.loadFromJava(className, myClassStr);

      Runnable runnable = (Runnable) aClass.getDeclaredConstructor().newInstance();
      runnable.run();
  }
}
