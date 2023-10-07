import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;


public class ProductTest {

    Product one = new Product(1, "Клавиатура", 15000);
    Product two = new Product(2, "Мышь", 5000);
    Product three = new Product(3, "Системный блок", 10000);
    Product four = new Product(4, "Монитор", 25000);
    Product five = new Product(5, "Колонки", 10000);

    //успешность удаления существующего элемента
    @Test
    public void successfulRemoval() {
        ShopRepository manager = new ShopRepository();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        manager.remove(1);

        Product[] actual = manager.findAll();
        Product[] expected = {two, three, four, five};
        Assertions.assertArrayEquals(expected, actual);
    }

    //генерация NotFoundException при попытке удаления несуществующего элемента
    @Test
    public void generationNotFoundException() {
        ShopRepository manager = new ShopRepository();
        manager.add(one);
        manager.add(two);
        manager.add(three);
        manager.add(four);
        manager.add(five);

        // Проверим, что элемент с индексом 6 не существует
        Assertions.assertThrows(NotFoundException.class, () -> manager.remove(6));
        Product[] expected = {one, two, three, four, five};
        Assertions.assertArrayEquals(expected, manager.findAll());
    }
}