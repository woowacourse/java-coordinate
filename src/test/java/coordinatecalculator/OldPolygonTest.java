//package coordinatecalculator;

//class OldPolygonTest {
//    Point a;
//    Point b;
//    Point c;
//    Point d;
//    Point e;
//    OldPolygon oldPolygon;
//
//    @Test
//    void insufficientPoints() {
//        a = new Point(10, 10);
//        b = new Point(15, 15);
//        assertThatIllegalArgumentException().isThrownBy(() -> {
//            new OldPolygon(a, b);
//        });
//    }
//
//    @Test
//    void duplicationAware() {
//        a = new Point(1, 1);
//        b = new Point(2, 2);
//        c = new Point(2, 2);
//        assertThatIllegalArgumentException().isThrownBy(() -> {
//            new OldPolygon(a, b, c);
//        });
//    }
//
//    // TODO: 점들이 모두 일직선일 때?
//    @Test
//    void area() {
//        a = new Point(2, 1);
//        b = new Point(4, 5);
//        c = new Point(7, 8);
//        oldPolygon = new OldPolygon(a, b, c);
//        assertThat(oldPolygon.area()).isEqualTo(3);
//
//        a = new Point(5, 5);
//        b = new Point(10, 10);
//        c = new Point(5, 10);
//        d = new Point(10, 5);
//        oldPolygon = new OldPolygon(a, b, c, d);
//        assertThat(oldPolygon.area()).isEqualTo(25);
//
//        a = new Point(3, 4);
//        b = new Point(5, 11);
//        c = new Point(12, 8);
//        d = new Point(9, 5);
//        e = new Point(5, 6);
//        oldPolygon = new OldPolygon(a, b, c, d, e);
//        assertThat(oldPolygon.area()).isEqualTo(30);
//    }
//}
