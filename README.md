# Akka Visual Extention
Netbeans Plugin for visual programming and prototyping actors in Akka with immersive possibilities

Основы
======

Установка
---------

Для использования плагина необходимо распаковать VisualAkkaPlug-in.zip и подключить все модули к NetBeans 

Рабочая область
---------------

Основная рабочая область – граф-ориентированная сцена, где узлами являются
функциональные объекты, а гранями – связи между ними. Отображается во кладке
“Visual’ открытого в NetBeans vau-файла.

![](<http://avisualistic.com/images/git/1.png>)

*Вид базовой рабочей области*

Все объекты рабочей области можно перетаскивать (за область заголовка). Сцена
масштабируется при помощи зажатой клавиши Ctrl и движениям колесика мыши.

### Панель навигации

Во время работы с рабочей областью vau-файла, в навигаторе NetBeans
(Окно-Навигатор/Ctrl + 7) отображается миниатюрный вид сцены. В рамках этого
вида прямоугольник с толстыми контурами обозначает видимую область. С помощью
данной панели можно перемещаться по рабочей сцене, перетаскивая вышеупомянутый
прямоугольник.

![](<http://avisualistic.com/images/git/2.png>)

*Вид панели навигации*

Методы
------

Согласно принципам Visual Akka, каждый функциональный модуль может иметь
несколько методов. Для работы с методами предназначена область панели
инструментов в редакторе vau-файлов.

![](<http://avisualistic.com/images/git/3.png>)

*Панель инструментов vau-файла (подчеркнутая область – блок инструментов для
работы с методами)*

Тут выделяются следующие элементы:

-   выпадающий список – отображает текущее имя метода и позволяет переключатся
    между методами данного модуля.

-   кнопка «Новый метод» - позволяет создать новый метод, имя метода вводится в
    появляющемся диалоговом окне, созданный метод автоматически будет выбран как
    «текущий»

-   кнопка «Удалить метод» удаляет текущий выбранный метод. Внимание: пока что
    удаление метода не ведет к удалению всех экземпляров этого метода в модулях
    проекта! (см. ниже)

Входы
-----

Вход – функциональный объект, отвечающий за определенный аргумент/константу
метода. Каждый метод должен иметь как минимум один главный вход, имя которого
совпадает с именем метода; удалить данный вход нельзя.

![](<http://avisualistic.com/images/git/4.png>)

*Вид входа*

Визуально вход является виджетом, который состоит из следующих элементов:

-   Имени входа

-   Поля входа, которое содержит тип входа и так называемого «узла связи»

Создание нового входа происходит путем перетаскивания из палитры (см. ниже)
элемента “New entry” на рабочую область.

При выборе входа в окне свойств NetBeans (Окно-IDE и
сервис-Свойства/Ctrl+Shift+7) отображаются следующие свойства:

| Название     | Описание
---------------|---------
| Name         | Имя входа
| Type         | Тип входа; должен представлять собой полную сигнатуру класса Java
| IsMainArg    | Является ли вход главным; поле только для чтения
| IsFixed      | Является ли этот вход аргументом метода или константой (константа – true)
| DefaultValue | В случае, если вход является константой, содержит ее значение.

Вход можно удалить, нажав по нему правой кнопкой мыши и выбрать пункт “Delete”

Выходы
------

Выход – функциональный элемент, отвечающий за возвращение результата метода. В
отличии от методов Java, методы модулей Visual Akka могут иметь несколько
выходов; в зависимости от пути выполнения на некоторые выходы могут попасть
сигналы, а на некоторые – нет.

![](<http://avisualistic.com/images/git/5.png>)

*Вид выхода*

Визуально выход является виджетом, который состоит из следующих элементов:

-   Имени выхода

-   Поля выхода, которое содержит тип выхода и так называемого «узла связи»

Создание нового выхода происходит путем перетаскивания из палитры (см. ниже)
элемента “New exit” на рабочую область.

При выборе входа в окне свойств NetBeans (Окно-IDE и
сервис-Свойства/Ctrl+Shift+7) отображаются следующие свойства:

| Название | Описание
-----------|---------
| Name     | Имя входа
| Type     | Тип входа; должен представлять собой полную сигнатуру класса Java

Выход можно удалить, нажав по нему правой кнопкой мыши и выбрать пункт “Delete”

Экземпляры методов
------------------

Экземпляр метода – функциональный элемент, который представляет собой
«воплощенную» ссылку на метод модуля. В реалиях Акка экземпляр метода – это
экземпляр сгенерированного java актора akka, с указанными параметрами,
переданными в Creator данного актора. Экземпляры являются основными
композиционными элементами Visual Akka.

![](<http://avisualistic.com/images/git/6.png>)

*Вид экземпляра метода*

Визуально экземпляр метода является виджетом, который состоит из следующих
элементов:

-   Имени метода, на который ссылается данный экземпляр

-   Поля роутера, который кратко отображает информацию о привязанном роутере
    (если он есть), или сообщает об его отсутствии

-   Одного или более поля аргумента, которые состоят из «узла связи», названия
    аргумента и его типа

-   Нескольких полей констант (если они есть), которые состоят из названия
    константы, ее типа и установленного значения

-   Нескольких полей выходов (если они есть), которые состоят из его названия,
    типа и «узла связи»

Создание экземпляра метода происходит путем перетаскивания узла-названия метода
из иерархического дерева окна Units на рабочую область (Окно Units вызывается
путем Окно-UnitsView)

![](<http://avisualistic.com/images/git/7.png>)

*Вид окна “Units”*

При выборе входа в окне свойств NetBeans (Окно-IDE и
сервис-Свойства/Ctrl+Shift+7) отображаются следующие свойства:

| Название                        | Описание
----------------------------------|---------
| Default values                  | Раздел с наборами пар-значений, отвечающий за установку констант
| Supervising                     | Раздел настройки супервизинга
| Supervisor strategy             | Тип стратегии супервизинга (подробнее в референсе akka)
| Within time range               | Временной интервал по истечению которого происходит перезапуск актора в случае  исключительной ситуации
| Max Number of reties            | Максимальное количество перезапусков
| Routing                         | Раздел настройки роутинга
| Enabled                         | Включен ли роутинг для этого экземпляра
| Routing logic                   | Тип логики роутинга, подробнее в референсе akka
| Stretching                      | Включить ли поддержку гибкого роутинга (на данный момент не поддерживается)
| Routes amount(min + max routes) | Минимальное и максимальное количество  экземпляров
| Max mailbox capacity            | Максимальный размер очереди сообщений  (akka mailbox) после которой происходит расширение роутера

В отличии от входов и выходов, экземпляр метода можно скопировать в другой метод
модуля (посредством контекстного меню); в таком случае сообщения будут
пересылаться именно этому экземпляру. Также, как и прочий объект рабочей
области, экземпляр метода можно удалить через контекстное меню.

Пользовательские методы
-----------------------

Пользовательские методы предоставляют интерфейс для исполнения произвольного
пользовательского кода в рамках модулей Visual Akka. При создании данных
объектов будут сгенерированы соответствующие классы заглушки (с полностью
настроенным роутингом), в рамках которых пользователь должен будет написать
логику созданного метода. Пользовательские методы создаются из палитры
посредством перетаскивания из палитры (см. ниже) элемента “New User Code Block”
на рабочую область. При этом будет вызван помощник, в ходе работы с которым
пользователь должен создать сигнатуру метода. Основные поля, которые потребуется
заполнить, это Method name, Entries, и Outputs.

![](<http://avisualistic.com/images/git/8.png>)

*Вид пользовательского метода*

В остальном работа с созданным пользовательским методом (в рамках визуальной
сцены) ничем не отличается от работы с экземплярами методов. Свойства роутинга,
супервизинга и работа с константами остается прежней.

Палитра
-------

Палитра – элемент интерфейса (окно), предназначенное для быстрой и удобной
работы при создании новых объектов рабочей области Visual Akka. Все объекты
создаются путем перетаскивания соответствующих пунктов на рабочую область. На
данный момент палитра содержит только раздел “New”, в котором находятся три
пункта: “Entry”, “Exit”, “User code block”

![](<http://avisualistic.com/images/git/9.png>)

*Вид окна палитры*

Состояния
---------

Состояния – реализация FSM на akka. Позволяет создавать условные переходы по
связям в зависимости от состояния, а также выполнять смену состояния на нужное
при переходе по связи.

### Окно состояний

Окно состояний (Окно-StatesView) позволяет отслеживать, создавать и удалять
состояния для данного модуля. С помощью перетаскивания элемента списка окна
состояний на рабочую область можно создать установщик состояния, который
переведет модуль в соответствующее состояние.

![](<http://avisualistic.com/images/git/10.png>)

*Вид окна состояний*

### Установщики состояний

Установщик состояния – функциональный элемент, отвечающий за перевод модуля в
соответствующее состояние. Создается путем перетаскивания элемента списка из
окна “States”

![](<http://avisualistic.com/images/git/11.png>)

*Вид установщика состояния*

Визуально установщик состояния является виджетом, который состоит из следующих
элементов:

-   Имени состояния

-   «узла связи»

Связи
-----

Связи – линии, соединяющие выходные и входные «узлы связи» функциональных
объектов рабочей сцены. Определяют соответствующие потоки передачи сообщений
между экземплярами акторов. Для каждой связи можно установить фильтр перехода по
состоянию, путем установки соответствующего пункта из контекстного меню (подменю
“SetState”)

Также предусмотрен механизм извлечения конкретного поля из более сложной
структуры данных выхода (контекстное меню-подменю ”Extract field”)(на данный
момент функция недоступна)

Сгенерированный код
===================
```java
package test;

import org.vap.core.Flow;

/**
* User code logic implementation
*/

public class PowImpl extends test.Pow.UCBAbstract {

  @Override
  public void Power(Double Power, Double Base, Flow\<Double\> Result) {
    Double res = Math.pow(Power, Base);
    System.out.println("Result is - " + res);
    Result.send(res);
  }
}
```
Все пользовательские блоки кода после генерации кода (которая производится при
сохранении файла) будут представлены в виде реализаций абстрактный методов
класса с логикой пользовательских блоков кода.

Практические указания
=====================

Создание проекта
----------------

Для импорта всех требуемых зависимостей предусмотрен специальный тип проекта
“Visual Akka project”. Такой проект может быть создан c помощью
последовательности действий “Создать проект-JavaEE-VisualAkkaProject”. Или же
создать вручную проект java, и добавить нужные библиотеки самостоятельно.
Базовый набор библиотек это akka-actor и akka-visual.

Создание файла модуля
---------------------

Создать новый файл модуля (“vau”-файл) можно с помощью последовательности
действий “Файл-Создать файл(Ctrl-N)-Visual Akka- Visual Akka Unit”.


# Licence
Akka Visual Extention is Open Source and available under the Apache 2 License.

Vladislav Larin, vlarinmain@gmail.com

Oleg Bantysh, iambantysh@gmail.com

Serhii Biletskyi, shutclare@gmail.com

All rights reserved.
