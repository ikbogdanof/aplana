import helpers.FindTvHelper;
import org.testng.annotations.AfterClass;
import org.testng.annotations.Test;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.hamcrest.Matchers.equalTo;

public class FindTv {

    private FindTvHelper helper = new FindTvHelper();

    @Test
    public void findTv_Step01() throws Exception {
        helper.startBrowser("https://www.yandex.ru/");
    }

    @Test(dependsOnMethods="findTv_Step01")
    public void findTv_Step02() throws Exception {
        helper.goToMarket();
    }

    @Test(dependsOnMethods="findTv_Step02")
    public void findTv_Step03() throws Exception {
        helper.chooseTv();
    }

    @Test(dependsOnMethods="findTv_Step03")
    public void findTv_Step04() throws Exception {
        helper.showBy12();
    }

    @Test(dependsOnMethods="findTv_Step04")
    public void findTv_Step05() throws Exception {
        helper.setPrice("20000");
    }

    @Test(dependsOnMethods="findTv_Step05")
    public void findTv_Step06() throws Exception {
        helper.chooseProducer("LG");

        helper.chooseProducer("Samsung");
    }

    @Test(dependsOnMethods="findTv_Step06")
    public void findTv_Step07() throws Exception {
        String productCount = helper.productCount();

        assertThat("12 карточек продуктов", productCount, containsString("\"products\":{\"count\":12}"));

        String getNameProductFromCardTv = helper.getNameProductFromCardTv(1);

        helper.findProduct(getNameProductFromCardTv);

        String getNameProduct = helper.getNameProductTv();

        assertThat("Название продуктов совпадают", getNameProductFromCardTv, equalTo(getNameProduct));
    }

    @AfterClass
    public void afterClass() throws Exception {
        helper.closeBrowser();
    }
}
