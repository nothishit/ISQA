import pytest
from io import StringIO
import sys
from main import To_Test

class Test_To_Test:
    @pytest.mark.parametrize("input_data,expected_output", [
        ("50", "tf = 122.0"),
        ("0", "tf = 32.0"),
        ("100", "tf = 212.0"),
        ("1.25", "tf = 34.25")
    ])
    @pytest.mark.smoke
    def test_task8_valid_input(self, monkeypatch, capsys, input_data, expected_output):
        # ARRANGE
        monkeypatch.setattr('sys.stdin', StringIO(input_data + "\n"))
        # ACT
        To_Test.task8()
        # ASSERT
        captured = capsys.readouterr()
        assert expected_output in captured.out

    @pytest.mark.smoke
    def test_task8_invalid_input(self, monkeypatch, capsys):
        # ARRANGE
        monkeypatch.setattr('sys.stdin', StringIO("101\n"))
        # ACT
        To_Test.task8()
        # ASSERT
        captured = capsys.readouterr()
        assert "Введите значения [0,100]" in captured.out

    @pytest.mark.task2
    def test_task2_positive_x(self, monkeypatch, capsys):
        # ARRANGE
        monkeypatch.setattr('sys.stdin', StringIO("2\n"))
        # ACT
        To_Test.task2()
        # ASSERT
        captured = capsys.readouterr()
        assert "f(x)= 5.7321" in captured.out

    @pytest.mark.task2
    def test_task2_negative_x(self, monkeypatch, capsys):
        # ARRANGE
        monkeypatch.setattr('sys.stdin', StringIO("-1\n"))
        # ACT
        To_Test.task2()
        # ASSERT
        captured = capsys.readouterr()
        assert "f(x)= -5.0000" in captured.out

    @pytest.mark.regression
    def test_task3(self, monkeypatch, capsys):
        # ARRANGE
        monkeypatch.setattr('sys.stdin', StringIO("1\n"))
        # ACT
        To_Test.task3()
        # ASSERT
        captured = capsys.readouterr()
        assert "F(x)= -2.6191" in captured.out

    @pytest.mark.regression
    def test_task7(self, monkeypatch, capsys):
        # ARRANGE
        monkeypatch.setattr('sys.stdin', StringIO("3\n7\n"))
        # ACT
        To_Test.task7()
        # ASSERT
        captured = capsys.readouterr()
        assert "Расстояние между X1 и X2 - 4.0000" in captured.out

    @pytest.mark.regression
    def test_task7_exception(self, monkeypatch):
        # ARRANGE
        monkeypatch.setattr('sys.stdin', StringIO("three\nseven\n"))
        # ACT
        with pytest.raises(Exception) as exc_info:
            To_Test.task7()
        # ASSERT
        assert "ValueError" in str(exc_info.type.__name__)

    @pytest.mark.regression
    def test_task6(self, capsys):
        # ACT
        To_Test.task6()
        # ASSERT
        captured = capsys.readouterr()
        assert "Число кроликов через год = 232" in captured.out