import java.util.Scanner;

//grid world => 4 by 4
//|‾0‾|‾‾‾|‾‾‾|‾‾‾|
//|‾‾‾|‾‾‾|‾‾‾|‾‾‾|
//|‾‾‾|‾‾‾|‾‾‾|‾‾‾|
//|‾‾‾|‾‾‾|‾‾‾|‾0‾|
// ‾‾‾ ‾‾‾ ‾‾‾ ‾‾‾
class assignmnet_algolithm {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        double grid_world[][] = new double[4][4];

        System.out.println("반복횟수입력:");
        int iter = sc.nextInt();
        sc.close();

        Policy_evaluation_iter pei = new Policy_evaluation_iter(iter, grid_world);
        pei.cal_action();
    }

    static class Policy_evaluation_iter {
        int iter;
        double grid_world[][];

        Policy_evaluation_iter(int iter, double grid_world[][]) {
            this.iter = iter;
            this.grid_world = grid_world;
        }

        void cal_action() {
            double up;
            double down;
            double right;
            double left;

            for (int cnt = 0; cnt < iter; cnt++) { // 반복횟수

                for (int row = 0; row < 4; row++) { // 행 증가
                    for (int col = 0; col < 4; col++) { // 열 증가
                        if ((row == 0 && col == 0) || (row == 3 && col == 3)) {
                            grid_world[row][col] = 0;
                            continue;
                        }
                        if ((row - 1) < 0) { // up value
                            up = 0.25 * (-1 + grid_world[row][col]);
                        } else {
                            up = 0.25 * (-1 + grid_world[row - 1][col]);
                        }

                        if ((row + 1) > 3) { // down value
                            down = 0.25 * (-1 + grid_world[row][col]);
                        } else {
                            down = 0.25 * (-1 + grid_world[row + 1][col]);
                        }

                        if ((col - 1) < 0) { // left value
                            left = 0.25 * (-1 + grid_world[row][col]);
                        } else {
                            left = 0.25 * (-1 + grid_world[row][col - 1]);
                        }

                        if ((col + 1) > 3) { // right value
                            right = 0.25 * (-1 + grid_world[row][col]);
                        } else {
                            right = 0.25 * (-1 + grid_world[row][col + 1]);
                        }

                        double sum = up + down + left + right;
                        grid_world[row][col] = sum;
                    } // 열 끝
                } // 행 끝

            } // 반복 횟수만큼 반복 끝

            StringBuilder sb = new StringBuilder();     //이하 결과 출력 부분
            for (int row = 0; row < 4; row++) {
                for (int col = 0; col < 4; col++) {
                    sb.append(grid_world[row][col]).append("    ");
                }
                sb.append("\n");
            }

            System.out.print(sb);
        }
    }
}