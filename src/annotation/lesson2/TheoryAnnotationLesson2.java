package annotation.lesson2;

public class TheoryAnnotationLesson2 {
    /* Зачем нужно создавать аннотации:
    * 1) Если вы реализуете анализатор исходного кода, вы можете создать свои аннотации, чтобы их можно было использовать
    * в коде и тем самым передавать дополнительную информацю об этом коде (те самые метаданные)
    * 2) Если вы  реализуете свою библиотеку или фреймворк, вы можете создать свои аннотации, чтобы пользователь с
    * помощью них взаимодействовал с вашей библиотекой или фреймворком (например Spring Framework). в этом сценарии
    * активно используется рефлексия*/

    /*Аннотации, аннотирующие аннотации (находятся в java.lang.annotation
    * @Target - указывает, к чему может быть применена аннотация. Значения берутся из перечисления (enum) ElementType
    * (из того же пакета) FIELD - поле, METHOD - метод, TYPE - класс, интерфейс - перечисление
    * @Retention - политика удержания Аннотации (до какого этапа компилирования или выполнения аннотация видна)
    * Значения лежат в перечислении RetentionPolicy:
    * 1) SOURCE  - отбрасываются при компиляции. Видны только в самом исходном коде (подойдет для анализаторов исходного
    * кода, например)
    * 2) CLASS - сохраняются в байт-коде, но недоступны во время работы програмыы
    * 3) RUNTIME - сохраняются в байт-коде и доступны во время работы программы (с помощью рефлексии)*/
}
