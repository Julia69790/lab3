# lab3
## Создана функция:
fun TagConsumer<HTMLElement>.label(classes : String? = null,<br>
                                   colorButton:ArrayList<String>,<br>
                                   block : LABEL.() -> Unit = {})<br>
        : HTMLLabelElement = label(classes)<br>
{<br>
    colorButton.forEach {<br>
        attributes += "value" to it<br>
        + it<br>
        input(InputType.radio) {<br>
            onClickFunction = buttonColor(it)<br>
        }<br>
    }<br>
    block()<br>
}<br>
В функцию передается список цветов для радиокнопок. Атрибут "value" задает значение для кнопки. input(InputType.radio) создает радиокнопки. onClickFunction определяет, что происходит после нажатия на кнопку.
Программа после запуска: [1](/screen/Запуск.PNG)<br>
Выбор первой радиокнопки:  [2](/screen/радиокнопка1.PNG)<br>
Выбор второй радиокнопки:  [3](/screen/радиокнопка2.PNG)<br>
Выбор третьей радиокнопки:  [4](/screen/радиокнопка3.PNG)<br>
