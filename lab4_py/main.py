import math

class To_Test:
    '''(47)'''
    def task8():
        temperature_celsia = float(input('Введите Температуру Цельсия\n'))
        # Ввод произвольного значения Температуры Цельсия
        if 0 <= temperature_celsia <= 100:
            # Проверяем соответсвует ли введённое значение промежутку [0;100]
            temperature_farengeita = ((temperature_celsia * 9) / 5) + 32
            # Вычисляем значение температуры Фаренгейта
            return print('tf =', round(temperature_farengeita, 4))
            # Выводим значение температуры Фаренгейта с точностью до 4 цифр в дробной части
        else:
            return print('Введите значения [0,100]\n')
            # Вывод ошибки

    '''(76) Вычислить значение f(x) по формуле: f(x)=sqrt(x+a)+(x**2+b)/x; a=1; b=4'''
    def task2():
        x = float(input("X= "))
        a = 1
        b = 4
        f = math.sqrt(x + a) + (((x ** 2) + b) / x)
        return print("f(x)= {:.4f}".format(f))
    
    '''(77) Вычислить значение f(x) по формуле: f(x)=log3(x^2+1)-3,25x'''
    def task3():
        x = float(input("X= "))
        f = math.log(x **2 + 1, 3) - 3.25 * x
        return print("F(x)= {:.4f}".format(f))

    '''(81) Найдите расстояние между двумя точками с заданными координатами x1 и x2 на числовой оси: |x2-x1|.'''
    def task7():
        x1 = float(input("Введите X1 -"))
        x2 = float(input("Введите X2 -"))
        distance=abs(x2-x1)
        return print("Расстояние между X1 и X2 - {:.4f}". format(distance))

    '''(87) Написать функцию, которая считает число первых 12 членов ряда Фибоначчи'''
    def task6():
        Sum = 0
        quan1, quan2 = 0, 1
        for i in range(12):
            Sum += quan1
            quan1, quan2 = quan2, quan1 + quan2
        return print(f'Число кроликов через год = {Sum}')

    '''(61)Два рабочих заработали вместе money рублей. 
    Один работал 2 недели, а другой 4недели. Сколько денег заработал каждый?'''
    def task5():
        Money = float(input("введите сколько двое рабочих заработали вместе"))
        Week_1_Working = 2
        Week_2_Working = 4
        Earnings_1 = (Week_1_Working / (Week_1_Working + Week_2_Working )) * Money
        Earnings_2 = (Week_2_Working / (Week_1_Working + Week_2_Working)) * Money
        print(f"Первый рабочий заработал, {Earnings_1:.4f} рублей")
        print(f"Второй рабочий заработал, {Earnings_2:.4f} рублей")

    '''(63)Найти расстояние между двумя точками с заданными координатами х1 
    и х2 на числовой оси |x2-x1|.'''
    def task63():
        x1 = float(input("введите координату x1"))
        x2 = float(input("введите координату x2"))
        dist = abs (x2-x1)
        print(f"расстояние между координатами, {dist:.4f}")


    '''(78)Найти длину образующей l усеченного, если известны радиусы основания r и R, а также высота h.'''
    def task4():
        r = float(input("Радиус меньшего основания (r)="))
        R = float(input("Радиус большего основания (R)="))
        h = float(input("Высота конуса (h)="))

        cone_generatrix = math.sqrt(h ** 2 + (R - r) ** 2)

        print("Образующая (l)= {:.4f}".format(cone_generatrix))


