package com.guyu.compare;

import java.util.Comparator;

/**
 * @author guyu06
 * @date 2023/5/24 16:53
 */
public class EntMaterialComparator implements Comparator<EntMaterial> {
    @Override
    public int compare(EntMaterial m1, EntMaterial m2) {
        if (m1.isHasClaimAndOnline() != m2.isHasClaimAndOnline()) {
            if (m1.isHasClaimAndOnline()) {
                return 1;
            } else {
                return -1;
            }
        }
        if (m1.isHasClaimAndOnline()) {
            return Comparator.comparingLong(EntMaterial::getUpdateTime).compare(m1, m2);
        }

        if (m1.isHasClaim() != m2.isHasClaim()) {
            if (m1.isHasClaim()) {
                return 1;
            } else {
                return -1;
            }
        }
        if (m1.isHasClaim()) {
            return Comparator.comparingLong(EntMaterial::getUpdateTime).compare(m1, m2);
        }

        return Comparator.comparingLong(EntMaterial::getUpdateTime).compare(m1, m2);
    }
}
