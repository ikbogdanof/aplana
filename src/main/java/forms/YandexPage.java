package forms;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import ru.yandex.qatools.htmlelements.annotations.Name;
import ru.yandex.qatools.htmlelements.element.Button;
import ru.yandex.qatools.htmlelements.element.CheckBox;

public class YandexPage {
    private WebDriver driver;

    public YandexPage(WebDriver driver) {
        this.driver = driver;
    }

    @Name("Ссылка - маркет")
    @FindBy(xpath = "//a[@data-id='market']")
    public WebElement market;

    @Name("Раздел - Электроника")
    @FindBy(xpath = "(//a[text()='Электроника'])[1]")
    public WebElement electronics;

    @Name("Раздел - Телевизоры")
    @FindBy(xpath = "//a[text()='Телевизоры']")
    public WebElement tv;

    @Name("Раздел - Наушники")
    @FindBy(xpath = "//a[text()='Наушники']")
    public WebElement headPhone;

    @Name("SelectBox - Показывать по")
    @FindBy(xpath = "//span[@class='select select_size_s select_theme_normal b-pager__select i-bem select_js_inited']")
    public WebElement showBy;

    @Name("SelectBox - Показывать по 12")
    @FindBy(xpath = "//span[text()='Показывать по 12']")
    public WebElement showBy12;

    @Name("Поле - Цена")
    @FindBy(xpath = "//input[@name='Цена от']")
    public WebElement price;

    @Name("Количество товаров")
    @FindBy(xpath = "//div[@class='n-snippet-list n-snippet-list_type_vertical metrika b-zone b-spy-init i-bem metrika_js_inited snippet-list_js_inited b-spy-init_js_inited b-zone_js_inited']")
    public WebElement productCount;

    @Name("Поле - Строка поиска")
    @FindBy(xpath = "//input[@name='text']")
    public WebElement searchLine;

    @Name("Кнопка - Найти")
//    @FindBy(xpath = "//span[text()='Найти']")
    @FindBy(xpath = "//span[@class='search2__button']")
    public WebElement searchButton;

    @Name("Заголовок - Название телевизора")
    @FindBy(xpath = "//div[@class='n-product-summary__headline']//h1")
    public WebElement productNameTv;

    @Name("Заголовок - Название наушников")
    @FindBy(xpath = "//div[@class='n-snippet-card2__title']")
    public WebElement productNameHeadPhone;

    @Name("Выбор региона")
    @FindBy(xpath = "(//div[@class='n-region-notification__actions-cell'])[1]")
    public WebElement regionOkButton;

    @Name("Отображение списком")
    @FindBy(xpath = "//label[@class = 'radio-button__radio radio-button__radio_side_right']")
    public WebElement viewListButton;

    @Name("Первая карточка товара")
    @FindBy(xpath = "(//div[@class='n-snippet-card2 i-bem b-zone b-spy-visible b-spy-visible_js_inited b-zone_js_inited n-snippet-card2_js_inited'])[1]")
    public WebElement firstCard;

}
