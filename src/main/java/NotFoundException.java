public class NotFoundException extends RuntimeException {
    public NotFoundException(String s) { //создадим контруктор который будет принимать сообщение об ошибке и передавать его в основной класс
        super(s);
    }
}