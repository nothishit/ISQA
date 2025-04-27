import pytest
from io import StringIO
import sys
from main import To_Test

# Тест для task8 с параметризацией
@pytest.mark.parametrize("input_data,expected_output", [
    ("50", "tf = 122.0"),
    ("0", "tf = 32.0"),
    ("100", "tf = 212.0"),
    ("1.25", "tf = 34.25")
])
@pytest.mark.smoke
def test_task8_valid_input(monkeypatch, capsys, input_data, expected_output):
    
    monkeypatch.setattr('sys.stdin', StringIO(input_data + "\n"))
    

    To_Test.task8()
    

    captured = capsys.readouterr()
    assert expected_output in captured.out

@pytest.mark.smoke
def test_task8_invalid_input(monkeypatch, capsys):
    monkeypatch.setattr('sys.stdin', StringIO("101\n"))
    
    To_Test.task8()
    
    captured = capsys.readouterr()
    assert "Введите значения [0,100]" in captured.out

# Тесты для task2
@pytest.mark.task2
def test_task2_positive_x(monkeypatch, capsys):
    monkeypatch.setattr('sys.stdin', StringIO("2\n"))
    
    To_Test.task2()
    
    captured = capsys.readouterr()
    assert "f(x)= 5.7321" in captured.out

@pytest.mark.task2
def test_task2_negative_x(monkeypatch, capsys):
    monkeypatch.setattr('sys.stdin', StringIO("-1\n"))
    
    To_Test.task2()
    
    captured = capsys.readouterr()
    assert "f(x)= -5.0000" in captured.out

# Тесты для task3
@pytest.mark.regression
def test_task3(monkeypatch, capsys):
    monkeypatch.setattr('sys.stdin', StringIO("1\n"))
    
    To_Test.task3()
    
    captured = capsys.readouterr()
    assert "F(x)= -2.6191" in captured.out

# Тесты для task7
@pytest.mark.regression
def test_task7(monkeypatch, capsys):
    monkeypatch.setattr('sys.stdin', StringIO("3\n7\n"))
    
    To_Test.task7()
    
    captured = capsys.readouterr()
    assert "Расстояние между X1 и X2 - 4.0000" in captured.out

@pytest.mark.regression
def test_task7_exception(monkeypatch):
    monkeypatch.setattr('sys.stdin', StringIO("three\nseven\n"))
    
    with pytest.raises(Exception) as exc_info:
        To_Test.task7()
    
    assert "ValueError" in str(exc_info.type.__name__)

# Тест для task6
@pytest.mark.regression
def test_task6(capsys):
    To_Test.task6()
    
    captured = capsys.readouterr()
    assert "Число кроликов через год = 232" in captured.out