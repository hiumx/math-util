/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package com.xuanhieu.mathutil.main;

import com.xuanhieu.mathutil.core.MathUtil;

/**
 *
 * @author Admin
 */
public class Main {
    public static void main(String[] args) {
        
        //thử nghiệm hàm tính giai thừa coi chạy đúng như thiết kế hay không
        //ta phải đưa ra các tình huống sử dụng hàm trong thực tế
        
        //TEST CASE: LÀ 1 TÌNH HUỐNG SỬ DỤNG, XÀI APP HAY HÀM MÀ NÓ BAO GỒM:
        //INPUT: DATA ĐẦU VÀO CỤ THỂ NÀO ĐÓ
        //OUTPUT: ĐẦU RA ỨNG VỚI XỬ LÍ CỦA HÀM/CHỨC NĂNG CỦA APP, DĨ NHIÊN ỨNG VỚI ĐẦU VÀO
        //ĐỂ XỬ LÍ
        //KÌ VỌNG: MONG HÀM TRẢ VỀ VALUE NÀO ĐÓ ỨNG VỚI INPUT Ở TRÊN
        //SO SÁNH ĐỂ XEM XETS KẾT QUẢ CÓ NHƯ KÌ VỌNG KHÔNG
        
        long expected = 120;
        int n = 5;
        long actual = MathUtil.getFatorial(n);
        System.out.println(n + "! = " + expected + " expected");
        System.out.println(n + "! = " + actual + " actual");
        
    }
}
