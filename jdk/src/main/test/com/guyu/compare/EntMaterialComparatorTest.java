package com.guyu.compare;

import com.google.common.collect.Lists;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

/**
 * @author guyu06
 * @date 2023/5/24 16:54
 */
class EntMaterialComparatorTest {

    @Test
    void test() {
        var entMaterials = List.of(
                new EntMaterial(false, false, 100L),
                new EntMaterial(false, false, 200L),
                new EntMaterial(true, true, 100L),
                new EntMaterial(true, true, 200L),
                new EntMaterial(true, false, 100L),
                new EntMaterial(true, false, 200L)
        );
        var list = Lists.<EntMaterial>newArrayList();

        testCase(list, new EntMaterial(false, false, 100L));
        testCase(list, new EntMaterial(false, false, 200L));
        testCase(list, new EntMaterial(true, false, 100L));
        testCase(list, new EntMaterial(true, false, 200L));
        testCase(list, new EntMaterial(true, true, 100L));
        testCase(list, new EntMaterial(true, true, 200L));

        System.out.println(new Date().getTime());
    }

    private void testCase(ArrayList<EntMaterial> list, EntMaterial entMaterial) {
        list.add(entMaterial);
        var finalEntMaterial = list.stream()
                .max(new EntMaterialComparator())
                .orElse(null);
        Assertions.assertEquals(entMaterial, finalEntMaterial);
    }

}