package othertest;


/**
 * Created by Xiaofei on 16/4/25.
 */

@ClassId("UserManager")
public interface IUserManager {

    @MethodId("getUser")
    String getUser();

    @MethodId("getName")
    String getName();

}