package org.zahid.apps.web.pos;

//import org.assertj.core.api.Java6Assertions;

import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

//import org.assertj.core.api.Assertions;
import org.apache.commons.lang.builder.EqualsBuilder;
import org.assertj.core.api.Assertions;
import org.hamcrest.Matchers;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit.jupiter.SpringExtension;
import org.unitils.reflectionassert.ReflectionComparatorMode;
import org.zahid.apps.web.pos.entity.Item;
import org.zahid.apps.web.pos.service.ItemService;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class ItemServiceTest {

  @Autowired
  private ItemService itemService;

  @DisplayName("Testing item service")
  @Test
  void testGetItem() {
    Item expected = itemService.findById(1L);
    expected.setInvoiceDtls(null);
    expected.setItemStocks(null);
    expected.setItemDesc("abc");
    Item actual = itemService.findById(1L);
    actual.setInvoiceDtls(null);
    actual.setItemStocks(null);
//    assertThat(actual, Matchers.arrayContaining(expected));
//    assertReflectionEquals(expected, actual);
//    assertReflectionEquals(expected, actual, ReflectionComparatorMode.IGNORE_DEFAULTS);
//    Assertions.assertThat(actual).isEqualToComparingFieldByField(expected);
    assertThat(actual, is(samePropertyValuesAs(expected)));
//    assertThat(expected, samePropertyValuesAs(actual));
//    assertEquals(item, itemService.findById(1L));
//    assertTrue(EqualsBuilder.reflectionEquals(item, itemService.findById(1L)));
//    assertTrue(EqualsBuilder.reflectionEquals(expected, actual));
  }
}
