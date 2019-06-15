package com.woowa.rentcar.view;

import com.woowa.rentcar.domain.RentCompany;

public class OutputView {
    public static void title() {
        System.out.println("어서오세요. 우아한 렌트카 입니다.");
        System.out.println("렌트 가능 차종은 다음과 같습니다.");
        System.out.println("1. Sonata");
        System.out.println("2. Avante");
        System.out.println("3. K5");
    }

    public static void car() {
        System.out.print("렌트할 차종을 입력해주세요. (추가할 차가 없으면 end 를 입력) : ");
    }

    public static void distance() {
        System.out.print("예상 주행 거리를 입력해주세요 : ");
    }
    public static void result(RentCompany rentCompany) {
        System.out.println(rentCompany.generateReport());
    }
}
