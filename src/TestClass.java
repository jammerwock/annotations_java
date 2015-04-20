public class TestClass {
    @File (name = "/home/aizen/at/s1.txt")
    private String s1;

    @File (name = "/home/aizen/at/s2.txt")
    private String s2;

    public TestClass(String str1, String str2){
        s1 = str1;
        s2 = str2;
    }

    public String getS1() {
        return s1;
    }

    public String getS2() {
        return s2;
    }

    public String toString(){
        return s1 +" " +s2;
    }

    @Saver(saveMany = true)
    public static boolean saveMany(TestClass...tcs){
        System.out.println("Save many...");
        for (TestClass tc: tcs){
            System.out.println(tc);
        }

        return  true;
    }

    @Saver(saveMany = false)
    public boolean saveOne(){
        System.out.println("Save one...");
        System.out.println(this);
        return  true;
    }
}
