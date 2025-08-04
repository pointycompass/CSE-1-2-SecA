package generics;

public class GenObject {
    private Object a;

    public void setObj(Object a) {
        this.a = a;
    }

    public Object getObj() {
        return this.a;
    }

    public static void main(String[] args) {
        GenObject genObject = new GenObject();
        genObject.setObj("Hello");
        //genObject.setObj(10);
        //genObject.setObj(new Thread());
        System.out.println(genObject.getObj());
        String s = (String) genObject.getObj();
        System.out.println(s);
    }
}


