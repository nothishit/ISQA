import math
import pytest
from main import To_Test

class TestToTest:
    # Тесты для task8 (температура Цельсия -> Фаренгейта)
    def test_task8_valid_input(self, monkeypatch, capsys):
        monkeypatch.setattr('builtins.input', lambda _: '50')
        To_Test.task8()
        captured = capsys.readouterr()
        assert 'tf = 122.0' in captured.out

    def test_task8_invalid_input_low(self, monkeypatch, capsys):
        monkeypatch.setattr('builtins.input', lambda _: '-10')
        To_Test.task8()
        captured = capsys.readouterr()
        assert 'Введите значения [0,100]' in captured.out

    # Тесты для task2 (вычисление f(x) = sqrt(x+a) + (x²+b)/x)
    def test_task2_positive_x(self, monkeypatch, capsys):
        monkeypatch.setattr('builtins.input', lambda _: '2')
        To_Test.task2()
        captured = capsys.readouterr()
        assert 'f(x)= 5.7321' in captured.out

    def test_task2_negative_x(self, monkeypatch, capsys):
        monkeypatch.setattr('builtins.input', lambda _: '-1')
        To_Test.task2()
        captured = capsys.readouterr()
        assert 'f(x)= -5.0000' in captured.out

    # Тесты для task3 (вычисление f(x) = log3(x²+1) - 3.25x)
    def test_task3_positive_x(self, monkeypatch, capsys):
        monkeypatch.setattr('builtins.input', lambda _: '1')
        To_Test.task3()
        captured = capsys.readouterr()
        assert 'F(x)= -2.6191' in captured.out

    def test_task3_zero_x(self, monkeypatch, capsys):
        monkeypatch.setattr('builtins.input', lambda _: '0')
        To_Test.task3()
        captured = capsys.readouterr()
        assert 'F(x)= 0.0000' in captured.out

    # Тесты для task7 (расстояние между точками)
    def test_task7_positive_distance(self, monkeypatch, capsys):
        inputs = iter(['3', '7'])
        monkeypatch.setattr('builtins.input', lambda _: next(inputs))
        To_Test.task7()
        captured = capsys.readouterr()
        assert 'Расстояние между X1 и X2 - 4.0000' in captured.out

    def test_task7_negative_distance(self, monkeypatch, capsys):
        inputs = iter(['-2', '-5'])
        monkeypatch.setattr('builtins.input', lambda _: next(inputs))
        To_Test.task7()
        captured = capsys.readouterr()
        assert 'Расстояние между X1 и X2 - 3.0000' in captured.out

    # Тест для task6 (ряд Фибоначчи) - только один тест, так как функция не принимает входные параметры
    def test_task6_fibonacci(self, capsys):
        To_Test.task6()
        captured = capsys.readouterr()
        assert 'Число кроликов через год = 376' in captured.out