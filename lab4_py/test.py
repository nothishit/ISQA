
import pytest
from main import To_Test

class Test_To_Test:
    def test_task8_valid_input(self, monkeypatch, capsys):
        #Проверка task8 с корректным вводом (температура в диапазоне [0, 100])
        monkeypatch.setattr('builtins.input', lambda _: '50')
        To_Test.task8()
        captured = capsys.readouterr()
        assert captured.out.strip() == "tf = 122.0"
    
    def test_task8_invalid_input(self, monkeypatch, capsys):
        #Проверка task8 с некорректным вводом (температура вне диапазона [0, 100])
        monkeypatch.setattr('builtins.input', lambda _: '-10')
        To_Test.task8()
        captured = capsys.readouterr()
        assert captured.out.strip() == "Введите значения [0,100]"
    
    def test_task2(self, monkeypatch, capsys):
        #Проверка task2 с заданным X
        monkeypatch.setattr('builtins.input', lambda _: '2')
        To_Test.task2()
        captured = capsys.readouterr()
        assert captured.out.strip() == "f(x)= 5.7321"
    
    def test_task3(self, monkeypatch, capsys):
        #Проверка task3 с заданным X
        monkeypatch.setattr('builtins.input', lambda _: '1')
        To_Test.task3()
        captured = capsys.readouterr()
        assert captured.out.strip() == "F(x)= -2.6191"
    
    def test_task7(self, monkeypatch, capsys):
        #Проверка task7 (расстояние между точками)
        inputs = iter(['3', '7'])
        monkeypatch.setattr('builtins.input', lambda _: next(inputs))
        To_Test.task7()
        captured = capsys.readouterr()
        assert captured.out.strip() == "Расстояние между X1 и X2 - 4.0000"
    
    def test_task6(self, capsys):
        #Проверка task6 (сумма первых 12 чисел Фибоначчи)
        To_Test.task6()
        captured = capsys.readouterr()
        assert captured.out.strip() == "Число кроликов через год = 376"