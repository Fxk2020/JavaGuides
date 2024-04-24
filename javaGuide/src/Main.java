import reflection.Student;

public class Main {
    public static void main(String[] args) throws ClassNotFoundException {
        //1.获取类对象
        Student s1 = new Student();
        Class c1 = s1.getClass();
        Class c2 = Class.forName("reflection.Student");
        Class c3 = Student.class;
        Class c4 = ClassLoader.getSystemClassLoader().loadClass("reflection.Student");

        System.out.println("class1 = " + c1 + "\n" +
                "class2 = " + c2 + "\n" +
                "class3 = " + c3 + "\n" +
                "class4 = " + c4 + "\n" +
                "class1 == class2 ? " + (c1 == c2) + "\n" +
                "class2 == class3 ? " + (c2 == c3)+ "\n"+
                "class3 == class4 ? " + (c3 == c4)) ;






    }
}