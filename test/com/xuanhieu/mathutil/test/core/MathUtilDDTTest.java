
package com.xuanhieu.mathutil.test.core;

import com.xuanhieu.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

//bản chất là class MathUtilDDTTest đang implement inteface RunWith
//RunWith là 1 interface

//câu lệnh này của JUnit báo hiệu rằng sẽ cần loop qua tập data để
//lấy cặp data input/expected nhồi vào hàm test
@RunWith(value = Parameterized.class)
public class MathUtilDDTTest {
    
    //ta sẽ trả về mảng 2 chiều gồm nhiều cặp input/expected
    @Parameterized.Parameters  //JUnit sẽ ngầm chạy loop qua từng dòng
                               //của mảng để lấy ra từng cặp data input/expected.
    //tên hàm không quan trọng, @(Anotation) mới quan trọng nó sẽ quy ước
            //điều gì sẽ diễn ra
    public static Object[][] initData() {
        return new Integer[][] {
            {0, 1},
            {1, 1},
            {2, 2},
            {3, 6},
            {4, 24},
            {5, 120},
            {6, 720},
        };
    }
    
    
    //giả sử loop qua từng dòng của mảng, ta vẫn cần gán từng value của cột
    //vào biến tương ứng input, expected để lát hồi feed cho hàm
    
    @Parameterized.Parameter(value = 0) //value = 0 lf map với cột 0 mảng data
    public int n; //biến map với value của cột [0] của mảng
    
    @Parameterized.Parameter(value = 1)
    public long expected; //long cho getF()
    
    @Test
    public void testGetFactorialGivenRightArgumentReturnWell() {
        Assert.assertEquals(expected, MathUtil.getFatorial(n));
    }
    
    //1 hàm nhưng 7 lần gọi -> 7 test case passed
    
}
