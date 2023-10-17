import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

        public class Main {
            static String FILE_PATH = "results.txt";
            private static void saveToFile(String text) {
                File file = new File(FILE_PATH);
                FileWriter writer = null;
                try {
                    writer = new FileWriter(file,true);
                    writer.write(text);

                } catch (IOException e) {
                    e.printStackTrace();
                } finally {
                    try {
                        writer.close();
                    } catch (IOException e) {
                        e.printStackTrace();
                    }
                }
            }
            public static void main(String[] args) {
                Lottery lotto = new Lottery();
                lotto.putToy(new Toy(1, "Конструктор", 2));
                lotto.putToy(new Toy(2, "Робот", 2));
                lotto.putToy(new Toy(3, "Кукла", 6));

                for (int attempt = 1; attempt <= 11; attempt++) {
                    Toy toy = lotto.get();
                    if (toy != null) {
                        String str = String.format("Попытка %d: %s\n", attempt, toy);
                        System.out.printf(str);
                        saveToFile(str);
                    } else {
                        String str = String.format("Попытка %d: Игрушки закончились\n", attempt);
                        System.out.printf(str);
                        saveToFile(str);
                        break;
                    }
                }
                String str = lotto.getToysQuantity();
                System.out.println(str);
                saveToFile(str);
            }
        }
