package coordinatecalculator;

class Output {
    private static final int BOARD_X_MIN = 1;
    private static final int BOARD_Y_MIN = 1;
    private static final int BOARD_X_MAX = 24;
    private static final int BOARD_Y_MAX = 24;
    private static final String HORIZONTAL_BAR = "―";
    private static final String VERTICAL_BAR = "|";
    private static final String POINT = "●";

    //    private List<SingleLine> lines;
    //
    //    String drawBoard(List<Point> points) {
    //        points.sort(Point::compareTo);
    //        for (int i = BOARD_Y_MIN; i < BOARD_Y_MAX; i++) {
    //            lines.add();
    //        }
    //    }
    //
    //    class SingleLine {
    //        private final int totalLength
    //                = BOARD_Y_MAX
    //                + VERTICAL_BAR.length()
    //                + Integer.toString(BOARD_Y_MAX).length();
    //        private final List<Point> singleX = new ArrayList<>();
    //        private final int yAxis;
    //
    //        SingleLine(int yAxis) {
    //            this.yAxis = yAxis;
    //        }
    //
    //        void addPoint(Point point) {
    //            singleX.add(point);
    //        }
    //
    //        private String padLeft(String string, int pad) {
    //            return String.format("%" + pad + "s", string);
    //        }
    //
    //        String makeString() {
    //            final StringBuilder sb = new StringBuilder(totalLength);
    //            final String temp = Integer.toString(BOARD_Y_MAX);
    //            final String start = padLeft(temp, temp.length());
    //            sb.append(start);
    //            sb.append(VERTICAL_BAR);
    //            for (Point point : singleX) {
    //                sb.insert(point.getX(), POINT);
    //            }
    //            return sb.toString();
    //        }
    //    }
}
