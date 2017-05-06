import org.apache.commons.codec.digest.DigestUtils;

/**
 * Created by yanfeng-mac on 2017/5/6.
 */
public class test {
    public static void main(String[] args) {
        String password = "admin";
        System.out.println(DigestUtils.md5Hex(password+"QDF&*^%&#$%$$%#123123^%^#%$#"));
    }
}
