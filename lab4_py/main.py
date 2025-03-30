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


