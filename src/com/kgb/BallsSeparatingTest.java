package com.kgb;

import org.junit.Test;

import static org.junit.Assert.*;

/**
 * Created by k.betlej on 9/28/15.
 */
public class BallsSeparatingTest {

    @Test
    public void test0() {
        int[] red =   new int[] {1, 1, 1};
        int[] green = new int[] {1, 1, 1};
        int[] blue =  new int[] {1, 1, 1};
        int operationCount = BallsSeparating.minOperations(red, green, blue);
        assertEquals(6, operationCount);
    }

    @Test
    public void test1() {
        int[] red =   new int[] {5};
        int[] green = new int[] {6};
        int[] blue =  new int[] {8};
        int operationCount = BallsSeparating.minOperations(red, green, blue);
        assertEquals(-1, operationCount);
    }

    @Test
    public void test2() {
        int[] red =   new int[] {4, 6, 5, 7};
        int[] green = new int[] {7, 4, 6, 3};
        int[] blue =  new int[] {6, 5, 3, 8};
        int operationCount = BallsSeparating.minOperations(red, green, blue);
        assertEquals(37, operationCount);
    }

    @Test
    public void test3() {
        int[] red =   new int[] {7, 12, 9, 9, 7};
        int[] green = new int[] {7, 10, 8, 8, 9};
        int[] blue =  new int[] {8, 9, 5, 6, 13};
        int operationCount = BallsSeparating.minOperations(red, green, blue);
        assertEquals(77, operationCount);
    }

    @Test
    public void test4() {
        int[] red =   new int[] {842398, 491273, 958925, 849859, 771363, 67803, 184892, 391907, 256150, 75799};
        int[] green = new int[] {268944, 342402, 894352, 228640, 903885, 908656, 414271, 292588, 852057, 889141};
        int[] blue =  new int[] {662939, 340220, 600081, 390298, 376707, 372199, 435097, 40266, 145590, 505103};
        int operationCount = BallsSeparating.minOperations(red, green, blue);
        assertEquals(7230607, operationCount);
    }

    @Test
    public void test5() {
        int[] red =   new int[] {852057, 889141, 662939, 340220};
        int[] green = new int[] {600081, 390298, 376707, 372199};
        int[] blue =  new int[] {435097, 40266, 145590, 505103};
        int operationCount = BallsSeparating.minOperations(red, green, blue);
        assertEquals(2952434, operationCount);
    }

    @Test
    public void test6() {

        int[] red =   new int[] {593633, 211316, 46137, 237279, 341207, 383572, 32736, 39339, 457733, 976647, 936427, 370527, 663144, 523038, 55546, 45875, 384421, 930620, 92741, 806460, 614363, 851389, 157524, 782148, 791526, 621541, 229605, 792784, 674698, 453232, 339522, 206915, 911094, 498363, 67339, 73740, 720783, 604107, 315456, 296207, 767669, 327099, 82766, 297005, 481234, 868477, 232044, 811528, 386635, 116589};
        int[] green = new int[] {581606, 344355, 539392, 107584, 6247, 476731, 283909, 192119, 536154, 112385, 518864, 419309, 103608, 240114, 174019, 417338, 546623, 255782, 616012, 821750, 811090, 130300, 411073, 849526, 915036, 874752, 315333, 991465, 11545, 892774, 86677, 864862, 477402, 695379, 52258, 302661, 871685, 20473, 343326, 563033, 885263, 562211, 924155, 605257, 476478, 206575, 852290, 914024, 301077, 818675};
        int[] blue =  new int[] {356079, 486648, 225494, 523195, 986436, 821025, 738039, 205869, 861592, 931534, 276083, 834584, 105338, 818044, 866221, 468466, 417944, 42253, 197656, 702004, 865723, 487838, 669021, 833309, 745388, 853227, 123547, 638191, 117769, 918374, 401330, 565617, 94498, 998787, 110890, 336896, 293902, 342820, 448302, 647186, 788734, 981589, 429579, 908541, 359347, 610617, 689037, 682546, 762716, 903090};
        int operationCount = BallsSeparating.minOperations(red, green, blue);
        assertEquals(38459049, operationCount);
    }

    @Test
    public void test7() {
        int[] red =   new int[] {759564, 499725, 752986, 786187, 225323, 988351, 815046, 523270};
        int[] green = new int[] {812696, 345573, 327941, 114064, 772300, 218251, 195578, 291685};
        int[] blue =  new int[] {369269, 964300, 274165, 989620, 192456, 438171, 578367, 441979};
        int operationCount = BallsSeparating.minOperations(red, green, blue);
        assertEquals(6058298, operationCount);
    }
}