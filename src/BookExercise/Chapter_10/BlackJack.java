package BookExercise.Chapter_10;

import java.util.*;

public class BlackJack {
    public static HashMap<Integer, String> cards = new HashMap<>();

    public static Integer sum = 0;

    public static void main(String[] args) {
        cards.put(2, "Валет");
        cards.put(3, "Дама");
        cards.put(4, "Король");
        cards.put(11, "Туз");
        cards.put(6, "Шестерка");
        cards.put(7, "Семерка");
        cards.put(8, "Восьмерка");
        cards.put(9, "Девятка");
        cards.put(10, "Десятка");
        cards.put(1, "Туз");

        begin();
        addCards();
    }

    public static Integer getRandom() {
        List<Integer> valuesList = new ArrayList<>(cards.keySet());
        if (valuesList.contains(1)) valuesList.remove(0);
        int randomCard = new Random().nextInt(valuesList.size());
        Integer randomValue = valuesList.get(randomCard);
        return randomValue;
    }

    public static void begin() {

        int firstCard = getRandom();
        int secondCard = getRandom();
        sum = firstCard + secondCard;
        System.out.println(" Вы получили 2 карты: '" +
                cards.get(firstCard) + "' и '" + cards.get(secondCard) + "' .Общая сумма = " + (sum));
        if (firstCard == 11 && secondCard == 11) {
            System.out.println(" Вы выиграли! 2 туза = золотое очко");
            System.exit(0);
        }
    }

    public static void addCards() {
        Scanner scan = new Scanner(System.in);
        Integer card;
        int yesNo;
        while (true) {
            System.out.println("Добавить карту?  1 - да, 0 - нет");
            yesNo = scan.nextInt();
            if (yesNo == 1) {
                card = getRandom();
                if (card == 11 && ((sum + 11) > 21)) card = 1;
                sum+= card;
                System.out.println("Вы получили '" +cards.get(card) +  "'. Общая сумма = " + sum);
            }
            if (yesNo == 0 || sum >= 21) {
                if (sum < 21) System.out.println("Недобор. Вы проиграли");
                else if (sum == 21) System.out.println("Поздравляем вы выиграли");
                else System.out.println("Перебор. Вы проиграли");
                break;
            }
        }

    }

}
