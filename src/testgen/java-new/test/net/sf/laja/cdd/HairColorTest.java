package net.sf.laja.cdd;

import com.google.common.collect.ImmutableList;
import com.google.common.collect.ImmutableMap;
import org.junit.Test;

import java.util.Arrays;

import static net.sf.laja.cdd.HairColorCreator.*;
import static org.hamcrest.CoreMatchers.equalTo;
import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

public class HairColorTest {

    @Test
    public void createHairColorFromString() {
        HairColor color = createHairColor("red").asHairColor();

        assertThat(color, is(HairColor.RED));
    }

    @Test
    public void createHairColorFromEnum() {
        String color = createHairColor(HairColor.BLACK).asValue();

        assertThat(color, is("BLACK"));
    }

    @Test
    public void shouldBePossibleToCreateHairColorList() {
        ImmutableList<HairColor> colors = createHairColorList("red", "grey", "black").asHairColorList();

        assertThat(colors, equalTo(Arrays.asList(HairColor.RED, HairColor.GREY, HairColor.BLACK)));
    }

    @Test
    public void createHairColorMapFromStringAndEnum() {
        ImmutableMap<String,HairColor> map = createHairColorMap(
                hairColorEntry("r", "red"),
                hairColorEntry("g", HairColor.GREY)
        ).asHairColorMap();

        ImmutableMap expectedMap = ImmutableMap.builder()
                .put("r", HairColor.RED)
                .put("g", HairColor.GREY).build();

        assertThat(map, equalTo(expectedMap));
    }
}
