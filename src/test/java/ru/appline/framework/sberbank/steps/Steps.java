package ru.appline.framework.sberbank.steps;

import io.cucumber.datatable.DataTable;

import io.cucumber.java.ru.Когда;
import io.cucumber.java.ru.Тогда;
import ru.appline.framework.sberbank.managers.PageManager;

public class Steps {
    private PageManager app = PageManager.getPageManager();

    @Когда("Загружена стартовая страница")
    public void getMainPage() {
        app.getStartPage();
    }

    @Когда("^Переход в главное меню '(.*)'$")
    public void selectBaseMenuC(String nameOfMenuItem) {
        app.getStartPage().selectBaseMenu(nameOfMenuItem);
    }

    @Когда("Выбор под-меню '(.*)'$")
    public void selectSubMenuC(String nameOfSubMenu) {
        app.getStartPage().selectSubMenu(nameOfSubMenu);
    }

    @Тогда("Проверка открытия страницы '(.*)'$")
    public void checkThePageTitle(String pageTitle) {
        app.getMortgagePage().checkPageIsOpened(pageTitle);
    }

    @Когда("^Заполняем форму поле/значение$")
    public void fillFieldsC(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getMortgagePage().fillFields(raw.get(0), raw.get(1));
                }
        );
    }

    @Когда("Выбор статуса чек-боксов")
    public void selectCheckBoxStatusC(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getMortgagePage().selectCheckBoxStatus(raw.get(0), raw.get(1));
                }
        );
    }

    @Когда("Проверка подсчитанных значений")
    public void checkCalculationResultsC(DataTable dataTable) {
        dataTable.cells().forEach(
                raw -> {
                    app.getMortgagePage().checkCalculationResults(raw.get(0), raw.get(1));
                }
        );
    }
}
