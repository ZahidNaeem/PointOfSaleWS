package org.zahid.apps.web.pos;

import static junit.framework.Assert.assertNotNull;
import static junit.framework.TestCase.assertTrue;
import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.samePropertyValuesAs;
import static org.unitils.reflectionassert.ReflectionAssert.assertReflectionEquals;

//import org.assertj.core.api.Assertions;
import java.math.BigDecimal;
import java.util.Arrays;
import java.util.Date;

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
import org.zahid.apps.web.pos.entity.ItemStock;
import org.zahid.apps.web.pos.repo.UserRepo;
import org.zahid.apps.web.pos.service.ItemService;
import org.zahid.apps.web.pos.utils.Miscellaneous;

@ExtendWith(SpringExtension.class)
@SpringBootTest
public class UserTest {

    @Autowired
    private UserRepo userRepo;

    @DisplayName("User exists by email")
    @Test
    void existsByEmail() {
        assertTrue(userRepo.existsByEmail("zhd.naeem@temp.com"));
    }
}
