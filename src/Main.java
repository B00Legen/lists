public class Main {
    public static void main(String[] args) {
        { //MyArrayList
            System.out.println("[MyArrayList]");
            MyArrayList<String> arr = new MyArrayList<>();
            System.out.println(arr.getFirst());

            arr.add("Halo");
            System.out.println(arr.getFirst());

            arr.set(0, "World");
            System.out.println(arr.get(0));

            arr.addFirst("Hello");
            arr.addLast("Everyone");
            System.out.println(arr.getFirst() + " " + arr.get(1) + " " + arr.getLast());

            arr.remove(1);
            System.out.println(arr.get(1));

            arr.removeFirst();
            System.out.println(arr.getFirst());

            arr.add("Is");
            arr.add("Small");
            System.out.print(arr.getLast());
            arr.removeLast();
            System.out.println(arr.getLast());

            arr.add("Oval");
            arr.add("Shaped");
            System.out.print(arr.getFirst());
            arr.sort();
            System.out.println(arr.getFirst());

            System.out.println(arr.indexOf("Shaped"));
            arr.add("Shaped");
            System.out.println(arr.lastIndexOf("Shaped"));

            System.out.println(arr.exists("Hello"));
            System.out.println(arr.exists("Oval"));

            Object[] array = arr.toArray();
            for (int i = 0; i < arr.size(); i++) {
                System.out.print(array[i]);
            }

            arr.clear();
            System.out.println(arr.size());
        }
        System.out.println("----------");
        { //MyLinkedList
            System.out.println("[MyLinkedList]");
            MyLinkedList<Integer> list = new MyLinkedList<Integer>();
            System.out.println(list.getFirst());

            list.add(257);
            System.out.println(list.getFirst() + " " + list.getLast());

            list.addFirst(144);
            list.addLast(236);
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2) + " " + list.get(3));

            list.set(1, 130);
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2) + " " + list.get(3));

            list.add(2, 430);
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2) + " " + list.get(3));

            list.sort();
            Object[] array = list.toArray();
            for (int i = 0; i < list.size(); i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();

            System.out.println(list.exists(228));
            System.out.println(list.exists(130));

            list.add(236);
            System.out.println(list.indexOf(236) + " " + list.lastIndexOf(236));

            array = list.toArray();
            for (int i = 0; i < list.size(); i++) {
                System.out.print(array[i] + " ");
            }
            System.out.println();
            list.remove(2);
            list.removeFirst();
            list.removeLast();
            System.out.println(list.get(0) + " " + list.get(1) + " " + list.get(2) + " " + list.get(3));

            list.clear();
            System.out.println(list.size());
        }
    }
}