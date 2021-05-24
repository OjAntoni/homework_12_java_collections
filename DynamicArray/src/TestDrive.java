public class TestDrive {
    public static void main(String[] args) {
        DArray<String> names = new DArray<>();
        for(int i = 0; i < 10; i++){
            names.add("name"+i);
        }
        System.out.println(names.getLength());
        for (int i = 0; i < names.getLength(); i++){
            System.out.print(names.getValue(i)+" ");
        }
        System.out.println();
        names.add("nameXX",3);
        for (int i = 0; i < names.getLength(); i++){
            System.out.print(names.getValue(i)+" ");
        }
        System.out.println();
        names.delete("name0");
        names.delete("name9");
        for (int i = 0; i < names.getLength(); i++){
            System.out.print(names.getValue(i)+" ");
        }
        System.out.println();
        System.out.println(names.getValue(5));
        System.out.println(names.contains("name2"));

        for(int i = 0; i < 40; i++){
            names.add("name"+i*i);
        }

        for (int j =0; j < names.getLength(); j++)
            System.out.println(names.getValue(j));

        System.out.println(names.getLength());
        System.out.println(names.getValue(-1));
        System.out.println(names.getValue(-49));
        System.out.println(names.getValue(-50));
    }
}
