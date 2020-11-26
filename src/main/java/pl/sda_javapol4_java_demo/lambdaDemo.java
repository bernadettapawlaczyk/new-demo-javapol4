package pl.sda_javapol4_java_demo;

class MyRunnable implements Runnable {
    public void run() {
        System.out.println("From MyRunnable class");
    }
}

abstract class MyClass {
    abstract void m1(); // mamy dwie abstrakcyjne metody
    abstract void m2();
}

interface MyInterface{
    void justDoIt();
}

@FunctionalInterface
interface StringToInt{
    int nameLength(String name);
    default int nameAndSurnameLength(String name, String surname){
     return -1;
    } //metoda, ktora ma cialo w interfejsie musi byc poprzedona slowkiem default
}

public class lambdaDemo {

    public static void main(String[] args) {
        Runnable job = new MyRunnable(); // przypisanie referencji
        job.run(); // wywołanie metody, na rzecz referencji job metodka run

        Runnable job3 = new Runnable() {
            @Override
            public void run() {
                System.out.println("From anonymous Runnable");
            }
        };
        job3.run();

        MyClass myClass = new MyClass() {
            @Override
            void m1() {

            }

            @Override
            void m2() {

            }
        };

        Runnable job2 = () -> {
            System.out.println("Hello from runnable lambda2");
        }; // nic nie przyjmuje i nic nie zwraca

        MyInterface nike = new MyInterface() {
            @Override
            public void justDoIt() {

            }
        };

        MyInterface nike2 = ()-> {
            System.out.println("Hello from lambda");
        };

         //StringToInt stringToInt = name -> name.length(); // rozwiazanie kamila

        StringToInt hack = (String s) -> 4;     // rozwiazanie trenera
         StringToInt better = arg -> {
             System.out.println("Calculation .......");
             return arg.length();
         };
         StringToInt best = arg -> arg.length();
                            // implementacja tej metody, takie ktora znajduje sie w interfejsie funkcyjnym
        System.out.println("using best: " + best.nameLength("Beciuch"));
        System.out.println("using best: " + best.nameAndSurnameLength("Bernadetta", "Pawlaczyk"));



    }
}
