Домашнее задание к Модулю 6
------------
В данном ДЗ нужно:

1. Дополнить код уже имеющихся классов из ДЗ к модулям 4 и 5 обработкой исключительной ситуации. При этом использовать **УЖЕ СУЩЕСТВУЮЩИЙ** класс (например, IllegalStateException).

2. Добавить в магазин инструментов метод, который готовит к отгрузке партию музыкальных инструментов согласно заказу.

Сигнатура метода:
public List < Instrument > prepareInstruments(Map < String, Integer > order){...}

В заказе (Map < String, Integer > order) хранится название инструмента и количество необходимых инструментов.

Ключом в заказе является одна из строк "piano", "guitar", "trumpet"

Создать свое исключение, которое будет брошено в случае, когда ключ в заказе другой.

Каким-то образом (самостоятельно выбрать решение) обработать ситуацию, когда количество элементов в заказе отрицательное, нулевое.

После выполнения метода из магазина должны пропасть те инструменты, которые были отгружены.

В случае, когда количество запрашиваемых инструментов определенного типа больше, чем количество доступных инструментов в магазине, должно быть брошено исключение. Выбрать наиболее подходящее из доступных в стандартной библиотеке исключений.

**Пример:**

 1. В магазине было 2 фортепиано, 16 гитар и 7 труб.
 2. Пришел заказ на 7 гитар и 2 трубы.
 3. После выполнения заказа в магазине осталось 2 фортепиано, 9 гитар и 5 труб.
 4. Пришел заказ на 1 фортепиано
 5. После выполнения заказа в магазине осталось 1 фортепиано, 9 гитар и 5 труб.
 6. Пришел заказ на 1 фортепиано, 8 гитар и 6 труб
 7. Товар не был отгружен (было брошено исключение).
 8. В магазине осталось 1 фортепиано, 9 гитар и 5 труб.
