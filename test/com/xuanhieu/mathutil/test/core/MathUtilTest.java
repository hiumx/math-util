package com.xuanhieu.mathutil.test.core;

import com.xuanhieu.mathutil.core.MathUtil;
import org.junit.Assert;
import org.junit.Test;

//viết code để test code
//test automation - tự động hóa quá trình kiểm thử
public class MathUtilTest {
    //đây là class sẽ sử dụng các hàm của thư viện/framework JUnit
    //để kiểm tra/kiểm tra code chính - hàm tinshGiaiThua() bên
    //class core.MathUtil

    //có nhiều quy tắc đặt tên hàm kiểm thử
    // nhưng thường sẽ là nói lên mục địch của các case
    //tình huống xài hàm theo kiểu thành công hay thất bại
    //@Test Junit sẽ phồi hợp JVM để chạy hàm này
    //@Test phía hậu trường chính là public static void main()
    //Có nhiều @Test ứng với nhiều case khác nhau
    
    @Test
    public void testGetFactorialGivenRightArgumentReturnsWell() {
        int n = 0;
        long expected = 1;
        long actual = MathUtil.getFatorial(n);
        //dùng framework để so sánh expected vs. actual
        Assert.assertEquals(expected, actual);
        //hàm giúp so sánh 2 giá trị nào đó có giống nhau không
        //nếu giống nhau -> màu xanh, code ngon
        //  ít nhất cho case đang test
        //nếu không giống nhau -> màu đỏ 

        //gộp thêm vài case thành công
        Assert.assertEquals(1, MathUtil.getFatorial(1));
        Assert.assertEquals(2, MathUtil.getFatorial(2));
        Assert.assertEquals(6, MathUtil.getFatorial(3));
        Assert.assertEquals(24, MathUtil.getFatorial(4));
        Assert.assertEquals(120, MathUtil.getFatorial(5));

    }

    //đưa data vào cà chớn, âm, > 20: THIẾT KẾ CỦA HÀM NÉM RA NGOẠI LẸ
    //KÌ VỌNG NÉN RA NGOẠI LỆ KHI N < 0 || N > 20
    //rất mong ngoại lệ xuất hiện với các N cà chớn này
    //nếu hàn nhận vào n < 0 hoặc n > 20 hàm ném ra ngoại lệ
    //HÀM CHẠY ĐÚNG NHƯ THIẾT KẾT -> XANH PHẢI XUẤT HIỆN
    //nếu hàn nhận vào n < 0 hoặc n > 20 hàm KHÔNG ném ra ngoại lệ
    //hàm chạy sai thiết kế, sai kì vọng, HÀM SAI -> MÀU ĐỎ
    //Exception là một thứ để biê nó có xảy ra(xuất hiện) hay không chứ không 
    //phải thứ để so sánh trực tiếp về VALUE
    //đo lường = cách nó có xuất hiện hay không
    //assertEquals() không dùng để so sánh 2 ngoại lệ
//    @Test(expected = NumberFormatException.class)
//    public void testGetFatorialGivenWrongArgumentThrowsException() {
//        MathUtil.getFatorial(-5); //hàm @Test chạy hay hàm getF() chạy
//        //sẽ nesm ra ngoaị lệ NumberFormatException
//        //MÀU ĐỎ, DO HÀM ĐÚNG LÀ CÓ NÉM RA NGOẠI LỆ 
//        //NHƯNG NGOẠI LỆ KHÔNG NHƯ EXPECTED                          
//    }
    //NGOẠI LỆ NÉM RA NHƯ KÌ VỌNG
    @Test(expected = IllegalArgumentException.class)
    public void testGetFatorialGivenWrongArgumentThrowsException() {
        MathUtil.getFatorial(-5); //hàm @Test chạy hay hàm getF() chạy
        //sẽ nesm ra ngoaị lệ NumberFormatException
        //MÀU ĐỎ, DO HÀM ĐÚNG LÀ CÓ NÉM RA NGOẠI LỆ 
        //NHƯNG NGOẠI LỆ KHÔNG NHƯ EXPECTED                          
    }

    @Test
    public void testGetFatorialGivenWrongArgumentThrowsException_LambdaVersion() {
//        Assert.assertThrows(class loại ngoại lệ muốn so sánh,
//                tham số 2 đoạn code ném ra ngoại lệ);

        Assert.assertThrows(IllegalArgumentException.class,
                () -> MathUtil.getFatorial(-5)
        );
    }
    
    @Test
    public void testGetFatorialGivenWrongArgumentThrowsException_TryCatch() {
//       chủ động bắt ngoại lệ
        try {
            MathUtil.getFatorial(-5);
        } catch (Exception e) {
            //bắt try-catch là JUnit sẽ ra xanh đỏ dã chủ động kiểm soát ngoại lệ
            //nhưng không chắc ngoại lệ mình cần có xuất hiện không
            //có đoạn code kiểm soát đúng ngoại lệ IllegalArgumentException xh
            Assert.assertEquals("Invalid argument. N must be between 0...20", e.getMessage());
        }
    }
    
}


//CLEAN & BUILD 
//NETBEANS KHÔNG LÀM MÀ GỌI THẰNG KHÁC LÀM
//HẬU TRƯỜNG
//GỌI JDK BIẾN ĐỔI FILE .JAVA THÀNH FILE .CLASS
//GỌI ANT/MAVEN ĐÓNG GÓI CÁC FILE .CLASS THÀNH FILE .JAR
//CLEAN : Xóa bên trong và làm lại
//BUILD: Gọi thằng Ant