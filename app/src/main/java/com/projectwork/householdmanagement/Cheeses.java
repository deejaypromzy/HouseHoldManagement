/*
 * Copyright (C) 2015 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *      http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package com.projectwork.householdmanagement;

import java.util.Random;

class Cheeses {

    private static final Random RANDOM = new Random();

    static int getRandomDishDrawable() {
        switch (RANDOM.nextInt(4)) {
            default:
            case 0:
                return R.drawable.apapransa;
            case 1:
                return R.drawable.waakye;
            case 2:
                return R.drawable.oto;
            case 3:
                return R.drawable.tuozaafi;
        }
    }
    static int getRandomChildDrawable() {
        switch (RANDOM.nextInt(4)) {
            default:
            case 0:
                return R.drawable.bathchild;
            case 1:
                return R.drawable.feedbaby;
            case 2:
                return R.drawable.sleepingchild;
            case 3:
                return R.drawable.changingdiaper;
        }
    }
    static int getRandomRoomDrawable() {
        switch (RANDOM.nextInt(4)) {
            default:
            case 0:
                return R.drawable.room0;
            case 1:
                return R.drawable.room1;
            case 2:
                return R.drawable.room2;
            case 3:
                return R.drawable.room3;
        }
    }    static int getRandomBedDrawable() {
        switch (RANDOM.nextInt(4)) {
            default:
            case 0:
                return R.drawable.bed3;
            case 1:
                return R.drawable.bed1;
            case 2:
                return R.drawable.bed;
            case 3:
                return R.drawable.bed2;
        }
    }


}
