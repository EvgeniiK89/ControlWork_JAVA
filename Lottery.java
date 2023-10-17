import java.util.ArrayList;
import java.util.Random;

public class Lottery {

    ArrayList<Toy> toys;
    public static Random random = new Random();

    public Lottery() {
        toys = new ArrayList<>();
    }

    public void putToy(Toy toy){

        toys.add(toy);
    }

    public String getToysQuantity() {
        StringBuilder toysQuantity = new StringBuilder("\nОстаток:\n");
        for (Toy toy : toys) {
            toysQuantity.append(String.format("%s: %s\n", toy.getName(), toy.quantity));
        }
        toysQuantity.append("\n");
        return toysQuantity.toString();
    }

    private Toy randomToy() {
        ArrayList<Integer> lottoDrum = new ArrayList();
        for (Toy toy : toys) {
            for (int i = 0; i < toy.quantity; i++) {
                lottoDrum.add(toy.getId());
            }
        }
        try {
            int randomId = lottoDrum.get(random.nextInt(lottoDrum.size()));
            for (Toy toy : toys) {
                if (toy.getId() == randomId) {
                    return toy;
                }
            }
        } catch (Exception e) {
        }
        return null;
    }

    public Toy get() {
        Toy toy = randomToy();
        if (toy != null) {
            toy.quantity -= 1;
        }
        return toy;
    }
}

