package BookExercise.Chapter_10;

public class Exercise1013 {
    /* Два человека играют в кости по следующим правилам: в каждом раунде игры (а она состоит из 10 раундов) каждый из
    участников бросает «кость» (кубик, на гранях которого значения от 1 до 6). В каждом раунде определяется победитель
    или фиксируется состояние «ничья», в зависимости от значения, которое выпало на кубике участника. Напишите класс,
    который моделирует эту игру, указывая для каждого раунда, кто из игроков набрал в этом раунде больше очков - или
    сообщая О СОСТОЯНИИ «НИЧЬЯ».*/
    public static void main(String[] args) {
        int win = 0;
        int win2 = 0;
        for (int i = 1; i <= 10; i++) {
            int player1 = 1 + (int) (Math.random() * 6);
            int player2 = 1 + (int) (Math.random() * 6);
            if (player1 > player2) {

                System.out.println("В раунде № " + i + " победил первый игрок.");
                win++;
            }
            else if (player1 < player2) {
                System.out.println("В раунде № " + i + " победил второй игрок.");
                win2++;
            }
            else System.out.println("В раунде № " + i + " Ничья");
        }
        if (win > win2) System.out.println("Победил первый игрок ");
        else if (win < win2) System.out.println("Победил второй игрок ");
        else System.out.println("Ничья");
    }
}
