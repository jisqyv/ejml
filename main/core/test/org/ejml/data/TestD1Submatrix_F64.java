/*
 * Copyright (c) 2009-2017, Peter Abeles. All Rights Reserved.
 *
 * This file is part of Efficient Java Matrix Library (EJML).
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *   http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package org.ejml.data;

import org.ejml.UtilEjml;
import org.ejml.ops.CommonOps_D64;
import org.ejml.ops.MatrixFeatures_D64;
import org.ejml.ops.RandomMatrices_D64;
import org.junit.Test;

import java.util.Random;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;


/**
 * @author Peter Abeles
 */
public class TestD1Submatrix_F64 {

    Random rand = new Random(234234);

    @Test
    public void get() {
        RowMatrix_F64 A = RandomMatrices_D64.createRandom(5,10,-1,1,rand);

        D1Submatrix_F64 S = new D1Submatrix_F64(A,2,4,1,10);

        assertEquals(A.get(3,2),S.get(1,1), UtilEjml.TEST_F64);
    }

    @Test
    public void set() {
        RowMatrix_F64 A = RandomMatrices_D64.createRandom(5,10,-1,1,rand);

        D1Submatrix_F64 S = new D1Submatrix_F64(A,2,4,1,10);

        S.set(1,1,5);

        assertEquals(A.get(3,2),5,UtilEjml.TEST_F64);
    }

    @Test
    public void extract() {
        RowMatrix_F64 A = RandomMatrices_D64.createRandom(5,10,-1,1,rand);

        D1Submatrix_F64 S = new D1Submatrix_F64(A,2,4,1,10);

        RowMatrix_F64 M = S.extract();

        RowMatrix_F64 E = CommonOps_D64.extract(A,2,4,1,10);

        assertTrue(MatrixFeatures_D64.isEquals(E,M));
    }
}