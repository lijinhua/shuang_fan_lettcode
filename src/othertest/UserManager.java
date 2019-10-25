package othertest;

@ClassId("UserManager")
public class UserManager implements IUserManager {

    private static UserManager sInstance = null;

    private UserManager() {

    }

    public static synchronized UserManager getInstance() {
        if (sInstance == null) {
            sInstance = new UserManager();
        }
        return sInstance;
    }

    @MethodId("getUser")
    @Override
    public String getUser() {
        return "Xiaofei";
    }

    @MethodId("getName")
    @Override
    public String getName() {
        return "lijinhia";
    }
}